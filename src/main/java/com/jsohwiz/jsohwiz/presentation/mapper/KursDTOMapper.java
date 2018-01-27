package com.jsohwiz.jsohwiz.presentation.mapper;

import com.jsohwiz.jsohwiz.dal.entity.KursEntity;
import com.jsohwiz.jsohwiz.presentation.model.KursDTO;
import org.springframework.stereotype.Component;

@Component
public class KursDTOMapper {
    public static KursDTO mapTo(KursEntity kursEntity) {
        String dziedzina;
        switch (kursEntity.getDziedzina()) {
            case 1:
                dziedzina = "zarządzanie";
                break;
            case 2:
                dziedzina = "programowanie";
                break;
            case 3:
                dziedzina = "sieci komputerowe";
                break;
            case 4:
                dziedzina = "bazy danych";
                break;
            case 5:
                dziedzina = "grafika komputerowa";
                break;
            case 6:
                dziedzina = "logika";
                break;
            case 7:
                dziedzina = "matematyka dyskretna";
                break;
            case 8:
                dziedzina = "systemy operacyjne";
                break;
            case 9:
                dziedzina = "elektronika";
                break;
            case 10:
                dziedzina = "teleinformatyka";
                break;
            case 11:
                dziedzina = "architektura systemów komputerowych";
                break;
            case 12:
                dziedzina = "rachunek prawdopodobieństwa";
                break;
            case 13:
                dziedzina = "projektowanie oprogramowania";
                break;
            case 14:
                dziedzina = "paradygmaty programowania";
                break;
            case 15:
                dziedzina = "nauczanie maszynowe";
                break;
            default:
                dziedzina = "";
                break;
        }
        return new KursDTO(
                kursEntity.getId(),
                kursEntity.getNazwa(),
                dziedzina
        );
    }
}
