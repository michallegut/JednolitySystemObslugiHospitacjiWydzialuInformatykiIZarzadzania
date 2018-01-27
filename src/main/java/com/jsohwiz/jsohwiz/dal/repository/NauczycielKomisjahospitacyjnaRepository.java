package com.jsohwiz.jsohwiz.dal.repository;

import com.jsohwiz.jsohwiz.dal.entity.NauczycielKomisjahospitacyjnaEntity;
import com.jsohwiz.jsohwiz.dal.entity.NauczycielKomisjahospitacyjnaEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NauczycielKomisjahospitacyjnaRepository extends JpaRepository<NauczycielKomisjahospitacyjnaEntity, NauczycielKomisjahospitacyjnaEntityPK> {
    NauczycielKomisjahospitacyjnaEntity findByNauczycielIdAndKomisjaHospitacyjnaId(
            Integer nauczycielId,
            Integer komisjaHospitacyjnaId
    );
}