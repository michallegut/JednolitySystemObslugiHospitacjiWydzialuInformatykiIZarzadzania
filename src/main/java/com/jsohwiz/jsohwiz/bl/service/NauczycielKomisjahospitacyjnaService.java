package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.NauczycielKomisjahospitacyjnaEntity;

import java.util.List;

public interface NauczycielKomisjahospitacyjnaService {
    NauczycielKomisjahospitacyjnaEntity create(NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity);

    List<NauczycielKomisjahospitacyjnaEntity> findAll();

    NauczycielKomisjahospitacyjnaEntity findByNauczycielIdAndKomisjaHospitacyjnaId(
            Integer nauczycielId,
            Integer komisjaHospitacyjnaId
    );

    void save(NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity);

    void delete(NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity);
}