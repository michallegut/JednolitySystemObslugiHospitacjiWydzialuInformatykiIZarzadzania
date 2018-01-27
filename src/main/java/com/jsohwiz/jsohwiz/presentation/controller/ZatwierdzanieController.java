package com.jsohwiz.jsohwiz.presentation.controller;

import com.jsohwiz.jsohwiz.bl.service.NauczycielService;
import com.jsohwiz.jsohwiz.bl.service.NauczycielServiceImpl;
import com.jsohwiz.jsohwiz.bl.service.PlanhospitacjiService;
import com.jsohwiz.jsohwiz.dal.entity.NauczycielEntity;
import com.jsohwiz.jsohwiz.dal.entity.PlanhospitacjiEntity;
import com.jsohwiz.jsohwiz.presentation.mapper.PlanHospitacjiDTOMapper;
import com.jsohwiz.jsohwiz.presentation.mapper.PlanHospitacjiSimpleDTOMapper;
import com.jsohwiz.jsohwiz.presentation.model.PlanHospitacjiDTO;
import com.jsohwiz.jsohwiz.presentation.model.PlanHospitacjiSimpleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ZatwierdzanieController {
    private PlanhospitacjiService planhospitacjiService;
    private NauczycielService nauczycielService;

    @Autowired
    public ZatwierdzanieController(PlanhospitacjiService planhospitacjiService, NauczycielService nauczycielService) {
        this.planhospitacjiService = planhospitacjiService;
        this.nauczycielService = nauczycielService;
    }

    @RequestMapping(path = "/zatwierdzanie{message}", method = RequestMethod.GET)
    public String enterIndex(@PathVariable String message, Model model) {
        List<PlanHospitacjiSimpleDTO> planHospitacjiSimpleDTOS = new ArrayList<>();
        for (PlanhospitacjiEntity planhospitacjiEntity : planhospitacjiService.findAll()) {
            if (!planhospitacjiEntity.getCzyZatwierdzony())
                planHospitacjiSimpleDTOS.add(PlanHospitacjiSimpleDTOMapper.mapTo(planhospitacjiEntity));
        }
        model.addAttribute("planHospitacjiSimpleDTOS", planHospitacjiSimpleDTOS);
        model.addAttribute("message", message);
        return "/zatwierdzanie/zatwierdzanie";
    }


    @RequestMapping(path = "/zatwierdzanie", method = RequestMethod.POST)
    public String exit() {
        return "redirect:/";
    }

    @RequestMapping(path = "/zatwierdzanie/szczegoly{id}", method = RequestMethod.POST)
    public String szczegoly(@PathVariable Integer id, Model model) {
        PlanhospitacjiEntity planhospitacjiEntity = planhospitacjiService.findById(id);

        for (NauczycielEntity nauczycielEntity : nauczycielService.findAll()) {
            nauczycielEntity.setObciazenie(NauczycielServiceImpl.countLoad(nauczycielEntity, planhospitacjiEntity.getSemestrBySemestrId()));
            nauczycielService.save(nauczycielEntity);
        }

        PlanHospitacjiDTO planHospitacjiDTO = PlanHospitacjiDTOMapper.mapTo(planhospitacjiEntity);
        model.addAttribute("planHospitacjiDTO", planHospitacjiDTO);
        return "/zatwierdzanie/szczegoly";
    }

    @RequestMapping(path = "/zatwierdzanie/szczegoly{id}", params = "powrot", method = RequestMethod.POST)
    public String back() {
        return "redirect:/zatwierdzanie";
    }

    @RequestMapping(path = "/zatwierdzanie/szczegoly{id}", params = "zatwierdz", method = RequestMethod.POST)
    public String confirm(@PathVariable Integer id) {
        PlanhospitacjiEntity planhospitacjiEntity = planhospitacjiService.findById(id);
        planhospitacjiEntity.setCzyZatwierdzony(true);
        planhospitacjiService.save(planhospitacjiEntity);
        return "redirect:/zatwierdzaniemessage";
    }

    @RequestMapping(path = "/zatwierdzaniemessage", method = RequestMethod.POST)
    public String ok() {
        return "redirect:/zatwierdzanie";
    }
}
