package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.HospitacjaEntity;
import com.jsohwiz.jsohwiz.dal.entity.KursSemestrEntity;
import com.jsohwiz.jsohwiz.dal.entity.NauczycielKursEntity;
import com.jsohwiz.jsohwiz.dal.entity.SemestrEntity;
import com.jsohwiz.jsohwiz.dal.repository.SemestrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemestrServiceImpl implements SemestrService {
    private SemestrRepository semestrRepository;

    @Autowired
    public SemestrServiceImpl(SemestrRepository semestrRepository) {
        this.semestrRepository = semestrRepository;
    }

    public static Boolean isAllSet(SemestrEntity semestrEntity) {
        boolean isAllSet = true;
        for (KursSemestrEntity kursSemestrEntity : semestrEntity.getKursSemestrsById()) {
            for (NauczycielKursEntity nauczycielKursEntity : kursSemestrEntity.getKursByKursId().getNauczycielKursById()) {
                if (!nauczycielKursEntity.getNauczycielByNauczycielId().getCzyZUczelni() || nauczycielKursEntity.getNauczycielByNauczycielId().getCzyDoktorant()) {
                    boolean isHospitated = false;
                    for (HospitacjaEntity hospitacjaEntity : nauczycielKursEntity.getNauczycielByNauczycielId().getHospitacjasById()) {
                        if (hospitacjaEntity.getPlanhospitacjiByPlanHospitacjiId().getSemestrBySemestrId().equals(semestrEntity)) {
                            isHospitated = true;
                        }
                    }
                    if (!isHospitated) isAllSet = false;
                }
            }
        }
        return isAllSet;
    }

    @Override
    public SemestrEntity create(SemestrEntity semestrEntity) {
        return semestrRepository.save(semestrEntity);
    }

    @Override
    public List<SemestrEntity> findAll() {
        return semestrRepository.findAll();
    }

    @Override
    public SemestrEntity findById(Integer id) {
        return semestrRepository.findById(id);
    }
}