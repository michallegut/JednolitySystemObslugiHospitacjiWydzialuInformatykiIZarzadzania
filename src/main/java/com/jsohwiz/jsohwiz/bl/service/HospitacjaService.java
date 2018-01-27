package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.HospitacjaEntity;

import java.util.List;

public interface HospitacjaService {
    HospitacjaEntity create(HospitacjaEntity hospitacjaEntity);

    List<HospitacjaEntity> findAll();

    HospitacjaEntity findById(Integer id);

    void save(HospitacjaEntity hospitacjaEntity);

    void delete(HospitacjaEntity hospitacjaEntity);
}