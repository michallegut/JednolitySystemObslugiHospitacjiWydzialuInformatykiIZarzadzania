package com.jsohwiz.jsohwiz.dal.repository;

import com.jsohwiz.jsohwiz.dal.entity.SemestrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemestrRepository extends JpaRepository<SemestrEntity, Integer> {
    SemestrEntity findById(Integer id);
}