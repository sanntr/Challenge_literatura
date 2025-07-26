package com.alura.challenge.Dto;

public record DtoLibroAutor(
        String titulo,
        String idioma,
        Integer descargas,
        String nombre

) {
    @Override
    public String toString() {
        return  "----- LIBRO -----\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + nombre + "\n" +
                "Idioma: " + idioma + "\n" +
                "Numero de descargas: " + descargas + "\n" +
                "------------------";
    }
}
