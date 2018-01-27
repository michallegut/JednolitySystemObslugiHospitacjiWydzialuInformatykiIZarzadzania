package com.jsohwiz.jsohwiz.dal.repository;

import com.jsohwiz.jsohwiz.dal.entity.GrupazajeciowaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupazajeciowaRepository extends JpaRepository<GrupazajeciowaEntity, Integer> {
    GrupazajeciowaEntity findById(Integer id);
}