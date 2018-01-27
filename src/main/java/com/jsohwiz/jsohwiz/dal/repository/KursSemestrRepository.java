package com.jsohwiz.jsohwiz.dal.repository;

import com.jsohwiz.jsohwiz.dal.entity.KursSemestrEntity;
import com.jsohwiz.jsohwiz.dal.entity.KursSemestrEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KursSemestrRepository extends JpaRepository<KursSemestrEntity, KursSemestrEntityPK> {
    KursSemestrEntity findByKursIdAndSemestrId(
            Integer kursId,
            Integer semestrId
    );
}