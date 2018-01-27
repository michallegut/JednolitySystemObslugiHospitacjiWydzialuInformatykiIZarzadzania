package com.jsohwiz.jsohwiz.presentation.mapper;

import com.jsohwiz.jsohwiz.dal.entity.HospitacjaEntity;
import com.jsohwiz.jsohwiz.presentation.model.HospitacjaDTO;
import org.springframework.stereotype.Component;

@Component
public class HospitacjaDTOMapper {
    public static HospitacjaDTO mapTo(HospitacjaEntity hospitacjaEntity) {
        return new HospitacjaDTO(
                hospitacjaEntity.getId(),
                KursDTOMapper.mapTo(hospitacjaEntity.getKursByKursId()),
                ProwadzacyDTOMapper.mapTo(hospitacjaEntity.getNauczycielByNauczycielId()),
                KomisjaHospitacyjnaDTOMapper.mapTo(hospitacjaEntity.getKomisjahospitacyjnaByKomisjaHospitacyjnaId())
        );
    }
}
