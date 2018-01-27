package com.jsohwiz.jsohwiz.bl.service;

import com.jsohwiz.jsohwiz.dal.entity.NauczycielKursEntity;
import com.jsohwiz.jsohwiz.dal.repository.NauczycielKursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NauczycielKursServiceImpl implements NauczycielKursService {
    private NauczycielKursRepository nauczycielKursRepository;

    @Autowired
    public NauczycielKursServiceImpl(NauczycielKursRepository nauczycielKursRepository) {
        this.nauczycielKursRepository = nauczycielKursRepository;
    }

    @Override
    public NauczycielKursEntity create(NauczycielKursEntity nauczycielKursEntity) {
        return nauczycielKursRepository.save(nauczycielKursEntity);
    }

    @Override
    public List<NauczycielKursEntity> findAll() {
        return nauczycielKursRepository.findAll();
    }

    @Override
    public NauczycielKursEntity findByNauczycielIdAndKursId(Integer nauczycielId, Integer kursId) {
        return nauczycielKursRepository.findByNauczycielIdAndKursId(nauczycielId, kursId);
    }
}