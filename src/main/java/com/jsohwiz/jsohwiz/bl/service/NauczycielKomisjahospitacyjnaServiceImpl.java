package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.NauczycielKomisjahospitacyjnaEntity;
import com.jsohwiz.jsohwiz.dal.repository.NauczycielKomisjahospitacyjnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NauczycielKomisjahospitacyjnaServiceImpl implements NauczycielKomisjahospitacyjnaService {
    private NauczycielKomisjahospitacyjnaRepository nauczycielKomisjahospitacyjnaRepository;

    @Autowired
    public NauczycielKomisjahospitacyjnaServiceImpl(NauczycielKomisjahospitacyjnaRepository nauczycielKomisjahospitacyjnaRepository) {
        this.nauczycielKomisjahospitacyjnaRepository = nauczycielKomisjahospitacyjnaRepository;
    }

    @Override
    public NauczycielKomisjahospitacyjnaEntity create(NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity) {
        return nauczycielKomisjahospitacyjnaRepository.save(nauczycielKomisjahospitacyjnaEntity);
    }

    @Override
    public List<NauczycielKomisjahospitacyjnaEntity> findAll() {
        return nauczycielKomisjahospitacyjnaRepository.findAll();
    }

    @Override
    public NauczycielKomisjahospitacyjnaEntity findByNauczycielIdAndKomisjaHospitacyjnaId(Integer nauczycielId, Integer komisjaHospitacyjnaId) {
        return nauczycielKomisjahospitacyjnaRepository.findByNauczycielIdAndKomisjaHospitacyjnaId(nauczycielId, komisjaHospitacyjnaId);
    }

    @Override
    public void save(NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity) {
        nauczycielKomisjahospitacyjnaRepository.save(nauczycielKomisjahospitacyjnaEntity);
    }

    @Override
    public void delete(NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity) {
        nauczycielKomisjahospitacyjnaRepository.delete(nauczycielKomisjahospitacyjnaEntity);
    }
}