package com.jsohwiz.jsohwiz.presentation.controller;

import com.jsohwiz.jsohwiz.bl.service.*;
import com.jsohwiz.jsohwiz.dal.entity.*;
import com.jsohwiz.jsohwiz.presentation.mapper.*;
import com.jsohwiz.jsohwiz.presentation.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.*;

@Controller
public class OpracowywanieController {
    private KierunekService kierunekService;
    private SemestrService semestrService;
    private NauczycielService nauczycielService;
    private PlanhospitacjiService planhospitacjiService;
    private PlanhospitacjiEntity planhospitacjiEntity;
    private HospitacjaService hospitacjaService;
    private KomisjahospitacyjnaService komisjahospitacyjnaService;
    private NauczycielKomisjahospitacyjnaService nauczycielKomisjahospitacyjnaService;
    private KursService kursService;
    private HospitacjaEntity hospitacjaEntity;
    private KomisjahospitacyjnaEntity komisjahospitacyjnaEntity;
    private List<NauczycielKomisjahospitacyjnaEntity> nauczycielKomisjahospitacyjnaEntities;

    @Autowired
    public OpracowywanieController(KierunekService kierunekService, SemestrService semestrService, NauczycielService nauczycielService, PlanhospitacjiService planhospitacjiService, HospitacjaService hospitacjaService, KomisjahospitacyjnaService komisjahospitacyjnaService, NauczycielKomisjahospitacyjnaService nauczycielKomisjahospitacyjnaService, KursService kursService) {
        this.kierunekService = kierunekService;
        this.semestrService = semestrService;
        this.nauczycielService = nauczycielService;
        this.planhospitacjiService = planhospitacjiService;
        this.hospitacjaService = hospitacjaService;
        this.komisjahospitacyjnaService = komisjahospitacyjnaService;
        this.nauczycielKomisjahospitacyjnaService = nauczycielKomisjahospitacyjnaService;
        this.kursService = kursService;
        planhospitacjiEntity = null;
        hospitacjaEntity = null;
        komisjahospitacyjnaEntity = null;
        nauczycielKomisjahospitacyjnaEntities = null;
    }

    @RequestMapping(path = "/opracowywanie{message}", method = RequestMethod.GET)
    public String enterIndex(@PathVariable String message, Model model) {
        List<KierunekDTO> kierunekDTOS = new ArrayList<>();
        for (KierunekEntity kierunekEntity : kierunekService.findAll()) {
            kierunekDTOS.add(KierunekDTOMapper.mapTo(kierunekEntity));
        }
        model.addAttribute("kierunekDTOS", kierunekDTOS);
        model.addAttribute("message", message);
        return "/opracowywanie/opracowywanie";
    }

    @RequestMapping(path = "/opracowywanie{kierunek}", method = RequestMethod.POST)
    public String szczegoly(@PathVariable Integer kierunek, Model model) {
        List<KierunekDTO> kierunekDTOS = new ArrayList<>();
        for (KierunekEntity kierunekEntity : kierunekService.findAll()) {
            kierunekDTOS.add(KierunekDTOMapper.mapTo(kierunekEntity));
        }

        List<SemestrDTO> semestrDTOS = new ArrayList<>();
        for (SemestrEntity semestrEntity : semestrService.findAll()) {
            boolean confirmed = false;
            for (PlanhospitacjiEntity planhospitacjiEntity : semestrEntity.getPlanhospitacjisById()) {
                if (planhospitacjiEntity.getKierunekByKierunekId().equals(kierunekService.findById(kierunek)) && planhospitacjiEntity.getCzyZatwierdzony()) {
                    confirmed = true;
                }
            }
            if (!confirmed) semestrDTOS.add(SemestrDTOMapper.mapTo(semestrEntity));
        }

        model.addAttribute("kierunekDTOS", kierunekDTOS);
        model.addAttribute("kierunek", kierunek);
        model.addAttribute("semestrDTOS", semestrDTOS);
        return "/opracowywanie/opracowywanie";
    }

    @RequestMapping(path = "/opracowywanie", method = RequestMethod.POST)
    public String exit() {
        return "redirect:/";
    }

    @RequestMapping(path = "/opracowywanie{kierunekid}/aktualny{semestrid}", method = RequestMethod.POST)
    public String goCurrent(@PathVariable Integer kierunekid, @PathVariable Integer semestrid, RedirectAttributes redir) {
        for (NauczycielEntity nauczycielEntity : nauczycielService.findAll()) {
            nauczycielEntity.setObciazenie(NauczycielServiceImpl.countLoad(nauczycielEntity, semestrService.findById(semestrid)));
            nauczycielService.save(nauczycielEntity);
        }
        planhospitacjiEntity = null;
        KierunekEntity kierunekEntity = kierunekService.findById(kierunekid);
        SemestrEntity semestrEntity = semestrService.findById(semestrid);
        for (PlanhospitacjiEntity planhospitacjiEntity1 : kierunekEntity.getPlanhospitacjisById()) {
            if (planhospitacjiEntity1.getSemestrBySemestrId().equals(semestrEntity)) {
                planhospitacjiEntity = planhospitacjiEntity1;
            }
        }

        if (planhospitacjiEntity == null) {
            planhospitacjiEntity = new PlanhospitacjiEntity();
            Integer id = 0;
            Boolean set = false;
            Set<Integer> ids = new HashSet<>();
            for (PlanhospitacjiEntity planhospitacjiEntity1 : planhospitacjiService.findAll()) {
                ids.add(planhospitacjiEntity1.getId());
            }
            while (!set) {
                id += 1;
                if (!ids.contains(id)) set = true;
            }
            planhospitacjiEntity.setDataUtworzenia(new Date(new java.util.Date().getTime()));
            planhospitacjiEntity.setId(id);
            planhospitacjiEntity.setKierunekByKierunekId(kierunekService.findById(kierunekid));
            planhospitacjiEntity.setSemestrBySemestrId(semestrService.findById(semestrid));
            planhospitacjiEntity.setCzyZatwierdzony(false);
            planhospitacjiEntity.setCzyAktualny(false);
            planhospitacjiEntity.setHospitacjasById(new ArrayList<>());
        }

        if (!SemestrServiceImpl.isAllSet(planhospitacjiEntity.getSemestrBySemestrId()))
            redir.addFlashAttribute("message", "messagenotification");
        return "redirect:/opracowywanie/aktualny";
    }

    @RequestMapping(path = "/opracowywanie/aktualny", method = RequestMethod.GET)
    public String current(RedirectAttributes redir, Model model) {
        for (HospitacjaEntity hospitacjaEntity1 : planhospitacjiEntity.getHospitacjasById()) {
            hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().
                    setNauczycielByNauczycielId(nauczycielService.findById(hospitacjaEntity1.
                            getKomisjahospitacyjnaByKomisjaHospitacyjnaId().getNauczycielByNauczycielId().getId()));
            for (NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity : hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().getNauczycielKomisjahospitacyjnasById()) {
                nauczycielKomisjahospitacyjnaEntity.setNauczycielByNauczycielId(nauczycielService.findById(nauczycielKomisjahospitacyjnaEntity.getNauczycielId()));
            }
        }
        PlanHospitacjiDTO planHospitacjiDTO = PlanHospitacjiDTOMapper.mapTo(planhospitacjiEntity);
        model.addAttribute("planHospitacjiDTO", planHospitacjiDTO);
        if (redir.getFlashAttributes().get("message") != null)
            model.addAttribute(redir.getFlashAttributes().get("message"));
        return "/opracowywanie/aktualny";
    }

    @RequestMapping(path = "/opracowywanie/aktualny", params = "powrot", method = RequestMethod.POST)
    public String back() {
        return "redirect:/opracowywanie";
    }

    @RequestMapping(path = "/opracowywanie/aktualny", method = RequestMethod.POST)
    public String aktualnyOk() {
        return "redirect:/opracowywanie/aktualny";
    }

    @RequestMapping(path = "/opracowywanie/aktualny", params = "usunplanhospitacji", method = RequestMethod.POST)
    public String delete(RedirectAttributes redir) {
        PlanhospitacjiEntity planhospitacjiEntity1 = planhospitacjiService.findById(planhospitacjiEntity.getId());
        if (planhospitacjiEntity1 != null) {
            for (HospitacjaEntity hospitacjaEntity1 : planhospitacjiEntity1.getHospitacjasById()) {
                for (NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity : hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().getNauczycielKomisjahospitacyjnasById()) {
                    nauczycielKomisjahospitacyjnaService.delete(nauczycielKomisjahospitacyjnaEntity);
                }
                hospitacjaService.delete(hospitacjaEntity1);
                komisjahospitacyjnaService.delete(hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId());
            }
            planhospitacjiService.delete(planhospitacjiEntity1);
            return "redirect:/opracowywaniemessage";
        }
        redir.addFlashAttribute("message", "messagedelete");
        return "redirect:/opracowywanie/aktualny";
    }

    @RequestMapping(path = "/opracowywaniemessage", method = RequestMethod.POST)
    public String ok() {
        return "redirect:/opracowywanie";
    }

    @RequestMapping(path = "/opracowywanie/aktualny", params = "zapisz", method = RequestMethod.POST)
    public String save(RedirectAttributes redir) {
        PlanhospitacjiEntity planhospitacjiEntity1 = planhospitacjiService.findById(planhospitacjiEntity.getId());
        if (planhospitacjiEntity1 != null) {
            for (HospitacjaEntity hospitacjaEntity1 : planhospitacjiEntity1.getHospitacjasById()) {
                for (NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity : hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().getNauczycielKomisjahospitacyjnasById()) {
                    nauczycielKomisjahospitacyjnaService.delete(nauczycielKomisjahospitacyjnaEntity);
                }
                hospitacjaService.delete(hospitacjaEntity1);
                komisjahospitacyjnaService.delete(hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId());
            }
            planhospitacjiService.delete(planhospitacjiEntity1);
        }

        Collection<HospitacjaEntity> hospitacjaEntities = planhospitacjiEntity.getHospitacjasById();
        planhospitacjiEntity.setHospitacjasById(null);
        planhospitacjiService.save(planhospitacjiEntity);
        planhospitacjiEntity.setHospitacjasById(hospitacjaEntities);
        for (HospitacjaEntity hospitacjaEntity1 : hospitacjaEntities) {
            Collection<NauczycielKomisjahospitacyjnaEntity> nauczycielKomisjahospitacyjnaEntities1 = hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().getNauczycielKomisjahospitacyjnasById();
            Collection<HospitacjaEntity> hospitacjaEntities1 = hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().getHospitacjasById();
            hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().setNauczycielKomisjahospitacyjnasById(null);
            hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().setHospitacjasById(null);
            komisjahospitacyjnaService.save(hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId());
            for (NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity : nauczycielKomisjahospitacyjnaEntities1) {
                nauczycielKomisjahospitacyjnaService.save(nauczycielKomisjahospitacyjnaEntity);
            }
            hospitacjaService.save(hospitacjaEntity1);
            hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().setNauczycielKomisjahospitacyjnasById(nauczycielKomisjahospitacyjnaEntities1);
            hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().setHospitacjasById(hospitacjaEntities1);
        }

        redir.addFlashAttribute("message", "messagesave");
        return "redirect:/opracowywanie/aktualny";
    }

    @RequestMapping(path = "/opracowywanie/aktualny{hospitacja}", method = RequestMethod.POST)
    public String removeHospitation(@PathVariable Integer hospitacja) {
        HospitacjaEntity hospitacjaEntity1 = null;
        for (HospitacjaEntity hospitacjaEntity2 : planhospitacjiEntity.getHospitacjasById()) {
            if (hospitacjaEntity2.getId().equals(hospitacja)) hospitacjaEntity1 = hospitacjaEntity2;
        }
        for (NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity : hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().getNauczycielKomisjahospitacyjnasById()) {
            nauczycielKomisjahospitacyjnaEntity.getNauczycielByNauczycielId().setObciazenie(nauczycielKomisjahospitacyjnaEntity.getNauczycielByNauczycielId().getObciazenie() - 1);
            nauczycielService.save(nauczycielKomisjahospitacyjnaEntity.getNauczycielByNauczycielId());
        }
        hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().getNauczycielByNauczycielId().setObciazenie(hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().getNauczycielByNauczycielId().getObciazenie() - 1);
        nauczycielService.save(hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().getNauczycielByNauczycielId());
        planhospitacjiEntity.getHospitacjasById().remove(hospitacjaEntity1);
        return "redirect:/opracowywanie/aktualny";
    }

    @RequestMapping(path = "/opracowywanie/aktualny", params = "dodajhospitacje", method = RequestMethod.POST)
    public String addHospitation(RedirectAttributes redir) {
        redir.addFlashAttribute("kurs", null);
        return "redirect:/opracowywanie/dodaj";
    }

    @RequestMapping(path = "/opracowywanie/dodaj", method = RequestMethod.GET)
    public String enterDodaj(@ModelAttribute("kurs") Integer kurs, Model model) {
        List<KursDTO> kursDTOS = new ArrayList<>();
        for (KursEntity kursEntity : kursService.findAll()) {
            Set<SemestrEntity> semestrEntities = new HashSet<>();
            for (KursSemestrEntity kursSemestrEntity : kursEntity.getKursSemestrsById()) {
                semestrEntities.add(kursSemestrEntity.getSemestrBySemestrId());
            }
            Set<KursEntity> kursEntities = new HashSet<>();
            for (HospitacjaEntity hospitacjaEntity1 : planhospitacjiEntity.getHospitacjasById()) {
                kursEntities.add(hospitacjaEntity1.getKursByKursId());
            }
            if (kursEntity.getKierunekByKierunekId().equals(planhospitacjiEntity.getKierunekByKierunekId()) && semestrEntities.contains(planhospitacjiEntity.getSemestrBySemestrId()) && !kursEntities.contains(kursEntity)) {
                kursDTOS.add(KursDTOMapper.mapTo(kursEntity));
            }
        }
        model.addAttribute("kursDTOS", kursDTOS);
        if (kurs != null) {
            model.addAttribute("kurs", kurs);
            List<ProwadzacyDTO> prowadzacyDTOS = new ArrayList<>();
            for (NauczycielKursEntity nauczycielKursEntity : kursService.findById(kurs).getNauczycielKursById()) {
                prowadzacyDTOS.add(ProwadzacyDTOMapper.mapTo(nauczycielKursEntity.getNauczycielByNauczycielId()));
            }
            model.addAttribute("prowadzacyDTOS", prowadzacyDTOS);
        }
        return "opracowywanie/dodaj";
    }

    @RequestMapping(path = "/opracowywanie/dodaj{kurs}", method = RequestMethod.POST)
    public String postKurs(@PathVariable Integer kurs, RedirectAttributes redir) {
        redir.addFlashAttribute("kurs", kurs);
        return "redirect:/opracowywanie/dodaj";
    }

    @RequestMapping(path = "/opracowywanie/dodaj", method = RequestMethod.POST)
    public String backFromDodaj() {
        return "redirect:/opracowywanie/aktualny";
    }

    @RequestMapping(path = "/opracowywanie{prowadzacyid}/dodaj{kursid}", method = RequestMethod.POST)
    public String assembleKomisja(@PathVariable Integer prowadzacyid, @PathVariable Integer kursid, RedirectAttributes redir) {
        hospitacjaEntity = new HospitacjaEntity();
        Integer id = 0;
        Boolean set = false;
        Set<Integer> ids = new HashSet<>();
        for (HospitacjaEntity hospitacjaEntity1 : hospitacjaService.findAll()) {
            ids.add(hospitacjaEntity1.getId());
        }
        for (HospitacjaEntity hospitacjaEntity1 : planhospitacjiEntity.getHospitacjasById()) {
            ids.add(hospitacjaEntity1.getId());
        }
        while (!set) {
            id += 1;
            if (!ids.contains(id)) set = true;
        }
        hospitacjaEntity.setId(id);
        hospitacjaEntity.setGrupaZajeciowaId(0);
        hospitacjaEntity.setNauczycielByNauczycielId(nauczycielService.findById(prowadzacyid));
        hospitacjaEntity.setKursByKursId(kursService.findById(kursid));
        redir.addFlashAttribute("przewodniczacy", null);
        return "redirect:/opracowywanie/komisja";
    }

    @RequestMapping(path = "/opracowywanie/komisja", method = RequestMethod.GET)
    public String enterKomisja(@ModelAttribute("przewodniczacy") Integer przewodniczacy, Model model) {
        List<HospitujacyDTO> przewodniczacyDTOS = new ArrayList<>();
        for (NauczycielEntity nauczycielEntity : nauczycielService.findAll()) {
            if (!nauczycielEntity.getCzyDoktorant() && nauczycielEntity.getCzyZUczelni() && (nauczycielEntity.getStopienNaukowy() == 2 || nauczycielEntity.getStopienNaukowy() == 3) && !nauczycielEntity.equals(hospitacjaEntity.getNauczycielByNauczycielId())) {
                przewodniczacyDTOS.add(HospitujacyDTOMapper.mapTo(nauczycielEntity));
            }
        }
        model.addAttribute("przewodniczacyDTOS", przewodniczacyDTOS);
        if (przewodniczacy != null) {
            List<HospitujacyDTO> hospitujacyDTOS = new ArrayList<>();
            for (NauczycielEntity nauczycielEntity : nauczycielService.findAll()) {
                if (!nauczycielEntity.getCzyDoktorant() && nauczycielEntity.getCzyZUczelni() && (!nauczycielEntity.equals(hospitacjaEntity.getNauczycielByNauczycielId()) && !nauczycielEntity.equals(nauczycielService.findById(przewodniczacy)))) {
                    hospitujacyDTOS.add(HospitujacyDTOMapper.mapTo(nauczycielEntity));
                }
            }
            model.addAttribute("hospitujacyDTOS", hospitujacyDTOS);
        }
        model.addAttribute("kurs", KursDTOMapper.mapTo(hospitacjaEntity.getKursByKursId()));
        return "/opracowywanie/komisja";
    }

    @RequestMapping(path = "/opracowywanie/komisja{przewodniczacy}", method = RequestMethod.POST)
    public String enterKomisja(@PathVariable Integer przewodniczacy, RedirectAttributes redir) {
        komisjahospitacyjnaEntity = new KomisjahospitacyjnaEntity();
        komisjahospitacyjnaEntity.setNauczycielByNauczycielId(nauczycielService.findById(przewodniczacy));
        komisjahospitacyjnaEntity.getNauczycielByNauczycielId().setObciazenie(komisjahospitacyjnaEntity.getNauczycielByNauczycielId().getObciazenie() + 1);
        redir.addFlashAttribute("przewodniczacy", przewodniczacy);
        return "redirect:/opracowywanie/komisja";
    }

    @RequestMapping(path = "/opracowywanie/komisja", params = "bbb", method = RequestMethod.POST)
    public String backFromKomisja(RedirectAttributes redir) {
        redir.addFlashAttribute("kurs", null);
        return "redirect:/opracowywanie/dodaj";
    }

    @RequestMapping(path = "/opracowywanie/komisja", method = RequestMethod.POST)
    public @ResponseBody
    String dodaj(@RequestBody String hospitujacy) {
        nauczycielKomisjahospitacyjnaEntities = new ArrayList<>();
        for (String string : (hospitujacy.substring(1, hospitujacy.length() - 2)).split(" ")) {
            NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity = new NauczycielKomisjahospitacyjnaEntity();
            nauczycielKomisjahospitacyjnaEntity.setNauczycielByNauczycielId(nauczycielService.findById(Integer.parseInt(string)));
            nauczycielKomisjahospitacyjnaEntity.setNauczycielId(Integer.parseInt(string));
            nauczycielKomisjahospitacyjnaEntity.setKomisjahospitacyjnaByKomisjaHospitacyjnaId(komisjahospitacyjnaEntity);
            nauczycielKomisjahospitacyjnaEntities.add(nauczycielKomisjahospitacyjnaEntity);
        }
        if (nauczycielKomisjahospitacyjnaEntities.isEmpty()) return "error1";
        else {
            boolean specjalizacja = false;
            HospitujacyDTO hospitujacyDTO = HospitujacyDTOMapper.mapTo(komisjahospitacyjnaEntity.getNauczycielByNauczycielId());
            if (!hospitujacyDTO.getSpecjalizacje().contains(KursDTOMapper.mapTo(hospitacjaEntity.getKursByKursId()).getDziedzina())) {
                for (NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity : nauczycielKomisjahospitacyjnaEntities) {
                    HospitujacyDTO hospitujacyDTO1 = HospitujacyDTOMapper.mapTo(nauczycielKomisjahospitacyjnaEntity.getNauczycielByNauczycielId());
                    if (hospitujacyDTO1.getSpecjalizacje().contains(KursDTOMapper.mapTo(hospitacjaEntity.getKursByKursId()).getDziedzina())) {
                        specjalizacja = true;
                    }
                }
            } else specjalizacja = true;

            if (specjalizacja) {
                for (NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity : nauczycielKomisjahospitacyjnaEntities) {
                    nauczycielKomisjahospitacyjnaEntity.getNauczycielByNauczycielId().setObciazenie(nauczycielKomisjahospitacyjnaEntity.getNauczycielByNauczycielId().getObciazenie() + 1);
                    nauczycielService.save(nauczycielKomisjahospitacyjnaEntity.getNauczycielByNauczycielId());
                }
                nauczycielService.save(komisjahospitacyjnaEntity.getNauczycielByNauczycielId());
                komisjahospitacyjnaEntity.setNauczycielKomisjahospitacyjnasById(nauczycielKomisjahospitacyjnaEntities);
                for (KomisjahospitacyjnaEntity komisjahospitacyjnaEntity1 : komisjahospitacyjnaService.findAll()) {
                    if (komisjahospitacyjnaEntity.getNauczycielByNauczycielId().equals(komisjahospitacyjnaEntity1.getNauczycielByNauczycielId())
                            && komisjahospitacyjnaEntity.getNauczycielKomisjahospitacyjnasById().size() == komisjahospitacyjnaEntity1.getNauczycielKomisjahospitacyjnasById().size()) {
                        List<Integer> idHospitujacych = new ArrayList<>();
                        List<Integer> idHospitujacych1 = new ArrayList<>();
                        for (NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity : komisjahospitacyjnaEntity.getNauczycielKomisjahospitacyjnasById()) {
                            idHospitujacych.add(nauczycielKomisjahospitacyjnaEntity.getNauczycielId());
                        }
                        for (NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity : komisjahospitacyjnaEntity1.getNauczycielKomisjahospitacyjnasById()) {
                            idHospitujacych1.add(nauczycielKomisjahospitacyjnaEntity.getNauczycielId());
                        }
                        if (idHospitujacych.equals(idHospitujacych1)) {
                            komisjahospitacyjnaEntity = komisjahospitacyjnaEntity1;
                        }
                    }
                }
                if (komisjahospitacyjnaEntity.getId() == null) {
                    Integer id = 0;
                    Boolean set = false;
                    Set<Integer> ids = new HashSet<>();
                    for (KomisjahospitacyjnaEntity komisjahospitacyjnaEntity1 : komisjahospitacyjnaService.findAll()) {
                        ids.add(komisjahospitacyjnaEntity1.getId());
                    }
                    for (HospitacjaEntity hospitacjaEntity1 : planhospitacjiEntity.getHospitacjasById()) {
                        ids.add(hospitacjaEntity1.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().getId());
                    }
                    while (!set) {
                        id += 1;
                        if (!ids.contains(id)) set = true;
                    }
                    komisjahospitacyjnaEntity.setId(id);
                    komisjahospitacyjnaEntity.setHospitacjasById(new ArrayList<>());
                }
                for (NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity : komisjahospitacyjnaEntity.getNauczycielKomisjahospitacyjnasById()) {
                    nauczycielKomisjahospitacyjnaEntity.setKomisjaHospitacyjnaId(komisjahospitacyjnaEntity.getId());
                }
                hospitacjaEntity.setKomisjahospitacyjnaByKomisjaHospitacyjnaId(komisjahospitacyjnaEntity);
                hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
                planhospitacjiEntity.getHospitacjasById().add(hospitacjaEntity);
                planhospitacjiEntity.setDataUtworzenia(new Date(new java.util.Date().getTime()));
                return "success";
            } else {
                return "error";
            }
        }
    }

    @RequestMapping(path = "/opracowywanie/komisja", params = "cofnij", method = RequestMethod.POST)
    public String enterKomisja() {
        return "redirect:/opracowywanie/aktualny";
    }
}