package com.jsohwiz.jsohwiz.presentation.mapper;

import com.jsohwiz.jsohwiz.dal.entity.HospitacjaEntity;
import com.jsohwiz.jsohwiz.dal.entity.PlanhospitacjiEntity;
import com.jsohwiz.jsohwiz.presentation.model.HospitacjaDTO;
import com.jsohwiz.jsohwiz.presentation.model.PlanHospitacjiDTO;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlanHospitacjiDTOMapper {
    public static PlanHospitacjiDTO mapTo(PlanhospitacjiEntity planhospitacjiEntity) {
        List<HospitacjaDTO> hospitacjaDTOS = new ArrayList<>();
        for (HospitacjaEntity hospitacjaEntity : planhospitacjiEntity.getHospitacjasById()) {
            hospitacjaDTOS.add(HospitacjaDTOMapper.mapTo(hospitacjaEntity));
        }
        return new PlanHospitacjiDTO(
                hospitacjaDTOS,
                KierunekDTOMapper.mapTo(planhospitacjiEntity.getKierunekByKierunekId()),
                SemestrDTOMapper.mapTo(planhospitacjiEntity.getSemestrBySemestrId()),
                new SimpleDateFormat("dd/MM/yyyy").format(planhospitacjiEntity.getDataUtworzenia())
        );
    }
}
