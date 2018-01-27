package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.KursEntity;

import java.util.List;

public interface KursService {
    KursEntity create(KursEntity kursEntity);

    List<KursEntity> findAll();

    KursEntity findById(Integer id);
}