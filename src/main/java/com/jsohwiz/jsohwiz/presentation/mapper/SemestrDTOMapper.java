package com.jsohwiz.jsohwiz.presentation.mapper;

import com.jsohwiz.jsohwiz.dal.entity.SemestrEntity;
import com.jsohwiz.jsohwiz.presentation.model.SemestrDTO;
import org.springframework.stereotype.Component;

@Component
public class SemestrDTOMapper {
    public static SemestrDTO mapTo(SemestrEntity semestrEntity) {
        String rodzaj;
        switch (semestrEntity.getRodzaj()) {
            case 1:
                rodzaj = "Letni";
                break;
            case 2:
                rodzaj = "Zimowy";
                break;
            default:
                rodzaj = "";
                break;
        }
        return new SemestrDTO(semestrEntity.getId(), rodzaj, semestrEntity.getRok() + "/" + (semestrEntity.getRok() + 1));
    }
}