package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.HospitacjaEntity;
import com.jsohwiz.jsohwiz.dal.repository.HospitacjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitacjaServiceImpl implements HospitacjaService {
    private HospitacjaRepository hospitacjaRepository;

    @Autowired
    public HospitacjaServiceImpl(HospitacjaRepository hospitacjaRepository) {
        this.hospitacjaRepository = hospitacjaRepository;
    }

    @Override
    public HospitacjaEntity create(HospitacjaEntity hospitacjaEntity) {
        return hospitacjaRepository.save(hospitacjaEntity);
    }

    @Override
    public List<HospitacjaEntity> findAll() {
        return hospitacjaRepository.findAll();
    }

    @Override
    public HospitacjaEntity findById(Integer id) {
        return hospitacjaRepository.findById(id);
    }

    @Override
    public void save(HospitacjaEntity hospitacjaEntity) {
        hospitacjaRepository.save(hospitacjaEntity);
    }

    @Override
    public void delete(HospitacjaEntity hospitacjaEntity) {
        hospitacjaRepository.delete(hospitacjaEntity);
    }
}