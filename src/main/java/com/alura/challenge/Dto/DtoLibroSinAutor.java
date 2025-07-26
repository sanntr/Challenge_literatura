package com.alura.challenge.Dto;

public record DtoLibroSinAutor(
        String titulo,
        String idioma,
        Integer descargas
) {
    @Override
    public String toString() {
        return "---------Libro-------------\n" +
                "Título: " + titulo + "\n" +
                "Idioma: " + idioma + "\n" +
                "Descargas: " + descargas + "\n";
    }
}
