package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.*;
import com.jsohwiz.jsohwiz.dal.repository.NauczycielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class NauczycielServiceImpl implements NauczycielService {
    private NauczycielRepository nauczycielRepository;

    @Autowired
    public NauczycielServiceImpl(NauczycielRepository nauczycielRepository) {
        this.nauczycielRepository = nauczycielRepository;
    }

    public static Integer countLoad(NauczycielEntity nauczycielEntity, SemestrEntity semestrEntity) {
        Integer load = 0;
        for (KomisjahospitacyjnaEntity komisjahospitacyjnaEntity : nauczycielEntity.getKomisjahospitacyjnasById()) {
            for (HospitacjaEntity hospitacjaEntity : komisjahospitacyjnaEntity.getHospitacjasById()) {
                if (hospitacjaEntity.getPlanhospitacjiByPlanHospitacjiId().getSemestrBySemestrId().equals(semestrEntity)) {
                    load++;
                }
            }
        }
        for (NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity : nauczycielEntity.getNauczycielKomisjahospitacyjnasById()) {
            for (HospitacjaEntity hospitacjaEntity : nauczycielKomisjahospitacyjnaEntity.getKomisjahospitacyjnaByKomisjaHospitacyjnaId().getHospitacjasById()) {
                if (hospitacjaEntity.getPlanhospitacjiByPlanHospitacjiId().getSemestrBySemestrId().equals(semestrEntity)) {
                    load++;
                }
            }
        }
        return load;
    }

    @Override
    public NauczycielEntity create(NauczycielEntity nauczycielEntity) {
        return nauczycielRepository.save(nauczycielEntity);
    }

    @Override
    public Set<NauczycielEntity> findAll() {
        Set<NauczycielEntity> nauczycielEntities = new HashSet<>();
        nauczycielEntities.addAll(nauczycielRepository.findAll());
        return nauczycielEntities;
    }

    @Override
    public NauczycielEntity findById(Integer id) {
        return nauczycielRepository.findById(id);
    }

    @Override
    public void save(NauczycielEntity nauczycielEntity) {
        nauczycielRepository.save(nauczycielEntity);
    }
}