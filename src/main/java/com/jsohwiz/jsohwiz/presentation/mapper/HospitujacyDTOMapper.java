package com.jsohwiz.jsohwiz.presentation.mapper;

import com.jsohwiz.jsohwiz.dal.entity.NauczycielEntity;
import com.jsohwiz.jsohwiz.presentation.model.HospitujacyDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HospitujacyDTOMapper {
    public static HospitujacyDTO mapTo(NauczycielEntity nauczycielEntity) {
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

        List<String> specjalizacje = new ArrayList<String>();
        int temp1 = nauczycielEntity.getSpecjalizacje();
        int temp2;
        while (temp1 > 11) {
            temp2 = temp1 % 100;
            temp1 /= 100;
            switch (temp2) {
                case 1:
                    specjalizacje.add("zarządzanie");
                    break;
                case 2:
                    specjalizacje.add("programowanie");
                    break;
                case 3:
                    specjalizacje.add("sieci komputerowe");
                    break;
                case 4:
                    specjalizacje.add("bazy danych");
                    break;
                case 5:
                    specjalizacje.add("grafika komputerowa");
                    break;
                case 6:
                    specjalizacje.add("logika");
                    break;
                case 7:
                    specjalizacje.add("matematyka dyskretna");
                    break;
                case 8:
                    specjalizacje.add("systemy operacyjne");
                    break;
                case 9:
                    specjalizacje.add("elektronika");
                    break;
                case 10:
                    specjalizacje.add("teleinformatyka");
                    break;
                case 11:
                    specjalizacje.add("architektura systemów komputerowych");
                    break;
                case 12:
                    specjalizacje.add("rachunek prawdopodobieństwa");
                    break;
                case 13:
                    specjalizacje.add("projektowanie oprogramowania");
                    break;
                case 14:
                    specjalizacje.add("paradygmaty programowania");
                    break;
                case 15:
                    specjalizacje.add("nauczanie maszynowe");
                    break;
                default:
                    break;
            }
        }

        return new HospitujacyDTO(
                nauczycielEntity.getId(),
                nauczycielEntity.getImie(),
                nauczycielEntity.getNazwisko(),
                stopienNaukowy,
                nauczycielEntity.getObciazenie().toString(),
                specjalizacje
        );
    }
}
