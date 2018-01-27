package com.jsohwiz.jsohwiz.presentation.mapper;

import com.jsohwiz.jsohwiz.dal.entity.KomisjahospitacyjnaEntity;
import com.jsohwiz.jsohwiz.dal.entity.NauczycielKomisjahospitacyjnaEntity;
import com.jsohwiz.jsohwiz.presentation.model.HospitujacyDTO;
import com.jsohwiz.jsohwiz.presentation.model.KomisjHospitacyjnaDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KomisjaHospitacyjnaDTOMapper {
    public static KomisjHospitacyjnaDTO mapTo(KomisjahospitacyjnaEntity komisjahospitacyjnaEntity) {
        List<HospitujacyDTO> hospitujacyDTOS = new ArrayList<>();
        for (NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity : komisjahospitacyjnaEntity.getNauczycielKomisjahospitacyjnasById()) {
            hospitujacyDTOS.add(HospitujacyDTOMapper.mapTo(nauczycielKomisjahospitacyjnaEntity.getNauczycielByNauczycielId()));
        }
        return new KomisjHospitacyjnaDTO(
                HospitujacyDTOMapper.mapTo(komisjahospitacyjnaEntity.getNauczycielByNauczycielId()),
                hospitujacyDTOS
        );
    }
}
