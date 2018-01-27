package com.jsohwiz.jsohwiz.presentation.mapper;

import com.jsohwiz.jsohwiz.dal.entity.KierunekEntity;
import com.jsohwiz.jsohwiz.presentation.model.KierunekDTO;
import org.springframework.stereotype.Component;

@Component
public class KierunekDTOMapper {
    public static KierunekDTO mapTo(KierunekEntity kierunekEntity) {
        return new KierunekDTO(kierunekEntity.getId(), kierunekEntity.getNazwa());
    }
}
