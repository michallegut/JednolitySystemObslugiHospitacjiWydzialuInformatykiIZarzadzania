package com.jsohwiz.jsohwiz.presentation.mapper;

import com.jsohwiz.jsohwiz.dal.entity.NauczycielEntity;
import com.jsohwiz.jsohwiz.presentation.model.ProwadzacyDTO;
import org.springframework.stereotype.Component;

@Component
public class ProwadzacyDTOMapper {
    public static ProwadzacyDTO mapTo(NauczycielEntity nauczycielEntity) {
        String stopienNaukowy;
        switch (nauczycielEntity.getStopienNaukowy()) {
            case 1:
                stopienNaukowy = "dr";
                break;
            case 2:
                stopienNaukowy = "dr hab.";
                break;
            case 3:
                stopienNaukowy = "doc.";
                break;
            case 4:
                stopienNaukowy = "";
                break;
            default:
                stopienNaukowy = "";
                break;
        }
        return new ProwadzacyDTO(
                nauczycielEntity.getId(),
                nauczycielEntity.getImie(),
                nauczycielEntity.getNazwisko(),
                stopienNaukowy,
                nauczycielEntity.getCzyDoktorant() ? "Tak" : "Nie",
                nauczycielEntity.getCzyZUczelni() ? "Tak" : "Nie"
        );
    }
}
