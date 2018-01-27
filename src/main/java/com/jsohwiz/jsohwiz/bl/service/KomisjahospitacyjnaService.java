package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.KomisjahospitacyjnaEntity;

import java.util.List;

public interface KomisjahospitacyjnaService {
    KomisjahospitacyjnaEntity create(KomisjahospitacyjnaEntity komisjahospitacyjnaEntity);

    List<KomisjahospitacyjnaEntity> findAll();

    KomisjahospitacyjnaEntity findById(Integer id);

    void save(KomisjahospitacyjnaEntity komisjahospitacyjnaEntity);

    void delete(KomisjahospitacyjnaEntity komisjahospitacyjnaEntity);
}