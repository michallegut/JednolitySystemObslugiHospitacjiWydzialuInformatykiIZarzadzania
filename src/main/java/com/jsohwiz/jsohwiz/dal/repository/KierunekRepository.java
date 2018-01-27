package com.jsohwiz.jsohwiz.dal.repository;

import com.jsohwiz.jsohwiz.dal.entity.KierunekEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KierunekRepository extends JpaRepository<KierunekEntity, Integer> {
    KierunekEntity findById(Integer id);
}