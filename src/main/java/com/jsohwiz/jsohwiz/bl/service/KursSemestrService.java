package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.KursSemestrEntity;

import java.util.List;

public interface KursSemestrService {
    KursSemestrEntity create(KursSemestrEntity kursSemestrEntity);

    List<KursSemestrEntity> findAll();

    KursSemestrEntity findByKursIdAndSemestrId(
            Integer kursId,
            Integer semsetrId
    );
}