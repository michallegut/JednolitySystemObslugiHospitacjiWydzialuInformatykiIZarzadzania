package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.GrupazajeciowaEntity;
import com.jsohwiz.jsohwiz.dal.repository.GrupazajeciowaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupazajeciowaServiceImpl implements GrupazajeciowaService {
    private GrupazajeciowaRepository grupazajeciowaRepository;

    @Autowired
    public GrupazajeciowaServiceImpl(GrupazajeciowaRepository grupazajeciowaRepository) {
        this.grupazajeciowaRepository = grupazajeciowaRepository;
    }

    @Override
    public GrupazajeciowaEntity create(GrupazajeciowaEntity grupazajeciowaEntity) {
        return grupazajeciowaRepository.save(grupazajeciowaEntity);
    }

    @Override
    public List<GrupazajeciowaEntity> findAll() {
        return grupazajeciowaRepository.findAll();
    }

    @Override
    public GrupazajeciowaEntity findById(Integer id) {
        return grupazajeciowaRepository.findById(id);
    }
}