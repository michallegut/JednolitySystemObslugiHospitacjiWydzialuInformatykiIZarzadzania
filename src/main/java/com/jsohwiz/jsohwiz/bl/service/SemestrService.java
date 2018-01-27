package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.SemestrEntity;

import java.util.List;

public interface SemestrService {
    SemestrEntity create(SemestrEntity semestrEntity);

    List<SemestrEntity> findAll();

    SemestrEntity findById(Integer id);
}