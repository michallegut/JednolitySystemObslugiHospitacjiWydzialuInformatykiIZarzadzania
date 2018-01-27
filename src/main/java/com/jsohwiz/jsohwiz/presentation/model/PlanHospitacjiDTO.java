package com.jsohwiz.jsohwiz.presentation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PlanHospitacjiDTO {
    List<HospitacjaDTO> hospitacje;
    private KierunekDTO kierunek;
    private SemestrDTO semestr;
    private String dataUtworzenia;
}
