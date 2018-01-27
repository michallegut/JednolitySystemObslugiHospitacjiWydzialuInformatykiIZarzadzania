package com.jsohwiz.jsohwiz.dal.repository;

import com.jsohwiz.jsohwiz.dal.entity.PlanhospitacjiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanhospitacjiRepository extends JpaRepository<PlanhospitacjiEntity, Integer> {
    PlanhospitacjiEntity findById(Integer id);
}