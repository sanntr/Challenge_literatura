package com.alura.challenge.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DtoLibro(
        @JsonAlias("title")
        String titulo,

        @JsonAlias("authors")
        List<DtoAutor> autor,

        @JsonAlias("languages")
        List<String> idioma,

        @JsonAlias("download_count")
        Integer descargas
) {
}
