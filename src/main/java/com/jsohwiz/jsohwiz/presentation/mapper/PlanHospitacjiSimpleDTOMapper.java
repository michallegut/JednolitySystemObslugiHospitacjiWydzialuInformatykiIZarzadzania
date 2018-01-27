package com.jsohwiz.jsohwiz.presentation.mapper;

import com.jsohwiz.jsohwiz.dal.entity.PlanhospitacjiEntity;
import com.jsohwiz.jsohwiz.presentation.model.PlanHospitacjiSimpleDTO;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class PlanHospitacjiSimpleDTOMapper {
    public static PlanHospitacjiSimpleDTO mapTo(PlanhospitacjiEntity planhospitacjiEntity) {
        return new PlanHospitacjiSimpleDTO(
                planhospitacjiEntity.getId(),
                KierunekDTOMapper.mapTo(planhospitacjiEntity.getKierunekByKierunekId()),
                SemestrDTOMapper.mapTo(planhospitacjiEntity.getSemestrBySemestrId()),
                new SimpleDateFormat("dd/MM/yyyy").format(planhospitacjiEntity.getDataUtworzenia()));
    }
}
