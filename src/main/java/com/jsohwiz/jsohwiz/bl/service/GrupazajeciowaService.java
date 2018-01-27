package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.GrupazajeciowaEntity;

import java.util.List;

public interface GrupazajeciowaService {
    GrupazajeciowaEntity create(GrupazajeciowaEntity grupazajeciowaEntity);

    List<GrupazajeciowaEntity> findAll();

    GrupazajeciowaEntity findById(Integer id);
}