package com.jsohwiz.jsohwiz.presentation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class KomisjHospitacyjnaDTO {
    private HospitujacyDTO przewodniczacy;
    private List<HospitujacyDTO> hospitujacy;
}