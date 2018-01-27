package com.jsohwiz.jsohwiz.dal.repository;

import com.jsohwiz.jsohwiz.dal.entity.NauczycielKursEntity;
import com.jsohwiz.jsohwiz.dal.entity.NauczycielKursEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NauczycielKursRepository extends JpaRepository<NauczycielKursEntity, NauczycielKursEntityPK> {
    NauczycielKursEntity findByNauczycielIdAndKursId(
            Integer nauczycielId,
            Integer kursId
    );
}