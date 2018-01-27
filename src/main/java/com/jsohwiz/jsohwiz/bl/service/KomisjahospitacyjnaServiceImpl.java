package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.KomisjahospitacyjnaEntity;
import com.jsohwiz.jsohwiz.dal.repository.KomisjahospitacyjnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KomisjahospitacyjnaServiceImpl implements KomisjahospitacyjnaService {
    private KomisjahospitacyjnaRepository komisjahospitacyjnaRepository;

    @Autowired
    public KomisjahospitacyjnaServiceImpl(KomisjahospitacyjnaRepository komisjahospitacyjnaRepository) {
        this.komisjahospitacyjnaRepository = komisjahospitacyjnaRepository;
    }

    @Override
    public KomisjahospitacyjnaEntity create(KomisjahospitacyjnaEntity komisjahospitacyjnaEntity) {
        return komisjahospitacyjnaRepository.save(komisjahospitacyjnaEntity);
    }

    @Override
    public List<KomisjahospitacyjnaEntity> findAll() {
        return komisjahospitacyjnaRepository.findAll();
    }

    @Override
    public KomisjahospitacyjnaEntity findById(Integer id) {
        return komisjahospitacyjnaRepository.findById(id);
    }

    @Override
    public void save(KomisjahospitacyjnaEntity komisjahospitacyjnaEntity) {
        komisjahospitacyjnaRepository.save(komisjahospitacyjnaEntity);
    }

    @Override
    public void delete(KomisjahospitacyjnaEntity komisjahospitacyjnaEntity) {
        komisjahospitacyjnaRepository.delete(komisjahospitacyjnaEntity);
    }
}