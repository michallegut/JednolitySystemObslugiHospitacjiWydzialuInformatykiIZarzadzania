package com.jsohwiz.jsohwiz.presentation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class HospitacjaDTO {
    private Integer id;
    private KursDTO kurs;
    private ProwadzacyDTO prowadzacy;
    private KomisjHospitacyjnaDTO komisjaHospitacyjna;
}
