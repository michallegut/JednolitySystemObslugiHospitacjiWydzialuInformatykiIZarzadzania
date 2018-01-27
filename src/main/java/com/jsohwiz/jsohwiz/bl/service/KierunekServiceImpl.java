package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.KierunekEntity;
import com.jsohwiz.jsohwiz.dal.repository.KierunekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KierunekServiceImpl implements KierunekService {
    private KierunekRepository kierunekRepository;

    @Autowired
    public KierunekServiceImpl(KierunekRepository kierunekRepository) {
        this.kierunekRepository = kierunekRepository;
    }

    @Override
    public KierunekEntity create(KierunekEntity kierunekEntity) {
        return kierunekRepository.save(kierunekEntity);
    }

    @Override
    public List<KierunekEntity> findAll() {
        return kierunekRepository.findAll();
    }

    @Override
    public KierunekEntity findById(Integer id) {
        return kierunekRepository.findById(id);
    }
}