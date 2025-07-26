package com.alura.challenge.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DtoAutor(
        @JsonAlias("name")
        String nombre,

        @JsonAlias("birth_year")
        Integer fechaNacimiento,

        @JsonAlias("death_year")
        Integer fechaMuerte
        ) {
}
