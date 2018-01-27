package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.KursSemestrEntity;
import com.jsohwiz.jsohwiz.dal.repository.KursSemestrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KursSemestrServiceImpl implements KursSemestrService {
    private KursSemestrRepository kursSemestrRepository;

    @Autowired
    public KursSemestrServiceImpl(KursSemestrRepository kursSemestrRepository) {
        this.kursSemestrRepository = kursSemestrRepository;
    }

    @Override
    public KursSemestrEntity create(KursSemestrEntity kursSemestrEntity) {
        return kursSemestrRepository.save(kursSemestrEntity);
    }

    @Override
    public List<KursSemestrEntity> findAll() {
        return kursSemestrRepository.findAll();
    }

    @Override
    public KursSemestrEntity findByKursIdAndSemestrId(Integer kursId, Integer semestrId) {
        return kursSemestrRepository.findByKursIdAndSemestrId(kursId, semestrId);
    }
}