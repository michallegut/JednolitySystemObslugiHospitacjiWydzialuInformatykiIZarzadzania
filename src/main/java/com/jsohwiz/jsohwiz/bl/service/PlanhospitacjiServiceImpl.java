package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.PlanhospitacjiEntity;
import com.jsohwiz.jsohwiz.dal.repository.PlanhospitacjiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanhospitacjiServiceImpl implements PlanhospitacjiService {
    private PlanhospitacjiRepository planhospitacjiRepository;

    @Autowired
    public PlanhospitacjiServiceImpl(PlanhospitacjiRepository planhospitacjiRepository) {
        this.planhospitacjiRepository = planhospitacjiRepository;
    }

    @Override
    public PlanhospitacjiEntity create(PlanhospitacjiEntity planhospitacjiEntity) {
        return planhospitacjiRepository.save(planhospitacjiEntity);
    }

    @Override
    public List<PlanhospitacjiEntity> findAll() {
        return planhospitacjiRepository.findAll();
    }

    @Override
    public PlanhospitacjiEntity findById(Integer id) {
        return planhospitacjiRepository.findById(id);
    }

    @Override
    public void save(PlanhospitacjiEntity planhospitacjiEntity) {
        planhospitacjiRepository.save(planhospitacjiEntity);
    }

    @Override
    public void delete(PlanhospitacjiEntity planhospitacjiEntity) {
        planhospitacjiRepository.delete(planhospitacjiEntity);
    }
}