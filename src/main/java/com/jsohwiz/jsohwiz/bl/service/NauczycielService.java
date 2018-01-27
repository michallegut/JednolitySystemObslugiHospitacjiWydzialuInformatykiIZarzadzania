package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.NauczycielEntity;

import java.util.Set;

public interface NauczycielService {
    NauczycielEntity create(NauczycielEntity nauczycielEntity);

    Set<NauczycielEntity> findAll();

    NauczycielEntity findById(Integer id);

    void save(NauczycielEntity nauczycielEntity);
}