package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.PlanhospitacjiEntity;

import java.util.List;

public interface PlanhospitacjiService {
    PlanhospitacjiEntity create(PlanhospitacjiEntity planhospitacjiEntity);

    List<PlanhospitacjiEntity> findAll();

    PlanhospitacjiEntity findById(Integer id);

    void save(PlanhospitacjiEntity planhospitacjiEntity);

    void delete(PlanhospitacjiEntity planhospitacjiEntity);
}