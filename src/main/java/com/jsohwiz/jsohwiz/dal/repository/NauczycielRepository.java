package com.jsohwiz.jsohwiz.dal.repository;

import com.jsohwiz.jsohwiz.dal.entity.NauczycielEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NauczycielRepository extends JpaRepository<NauczycielEntity, Integer> {
    NauczycielEntity findById(Integer id);
}