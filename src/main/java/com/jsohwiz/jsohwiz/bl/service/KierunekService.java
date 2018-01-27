package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.KierunekEntity;

import java.util.List;

public interface KierunekService {
    KierunekEntity create(KierunekEntity kierunekEntity);

    List<KierunekEntity> findAll();

    KierunekEntity findById(Integer id);
}