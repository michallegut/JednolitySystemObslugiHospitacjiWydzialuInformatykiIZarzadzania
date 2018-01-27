package com.jsohwiz.jsohwiz.presentation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PlanHospitacjiSimpleDTO {
    private Integer id;
    private KierunekDTO kierunek;
    private SemestrDTO semestr;
    private String dataUtworzenia;
}
