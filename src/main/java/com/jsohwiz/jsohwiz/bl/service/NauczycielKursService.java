package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.NauczycielKursEntity;

import java.util.List;

public interface NauczycielKursService {
    NauczycielKursEntity create(NauczycielKursEntity nauczycielKursEntity);

    List<NauczycielKursEntity> findAll();

    NauczycielKursEntity findByNauczycielIdAndKursId(
            Integer nauczycielId,
            Integer kursId
    );
}