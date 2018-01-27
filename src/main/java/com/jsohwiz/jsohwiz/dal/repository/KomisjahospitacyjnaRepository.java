package com.jsohwiz.jsohwiz.dal.repository;

import com.jsohwiz.jsohwiz.dal.entity.KomisjahospitacyjnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KomisjahospitacyjnaRepository extends JpaRepository<KomisjahospitacyjnaEntity, Integer> {
    KomisjahospitacyjnaEntity findById(Integer id);
}