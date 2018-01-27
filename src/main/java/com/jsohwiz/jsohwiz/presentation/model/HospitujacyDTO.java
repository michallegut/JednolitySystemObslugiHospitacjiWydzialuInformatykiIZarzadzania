package com.jsohwiz.jsohwiz.presentation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class HospitujacyDTO {
    private Integer id;
    private String imie;
    private String nazwisko;
    private String stopienNaukowy;
    private String obciazenie;
    private List<String> specjalizacje;
}