package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.KursEntity;
import com.jsohwiz.jsohwiz.dal.repository.KursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KursServiceImpl implements KursService {
    private KursRepository kursRepository;

    @Autowired
    public KursServiceImpl(KursRepository kursRepository) {
        this.kursRepository = kursRepository;
    }

    @Override
    public KursEntity create(KursEntity kursEntity) {
        return kursRepository.save(kursEntity);
    }

    @Override
    public List<KursEntity> findAll() {
        return kursRepository.findAll();
    }

    @Override
    public KursEntity findById(Integer id) {
        return kursRepository.findById(id);
    }
}