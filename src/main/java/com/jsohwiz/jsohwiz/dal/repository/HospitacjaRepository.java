package com.jsohwiz.jsohwiz.dal.repository;

import com.jsohwiz.jsohwiz.dal.entity.HospitacjaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitacjaRepository extends JpaRepository<HospitacjaEntity, Integer> {
    HospitacjaEntity findById(Integer id);
}