package com.jsohwiz.jsohwiz.presentation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProwadzacyDTO {
    private Integer id;
    private String imie;
    private String nazwisko;
    private String stopienNaukowy;
    private String czyDoktorant;
    private String czyZUczelni;
}
