package com.alura.challenge.Dto;

import java.util.List;

public record DtoLIstaAutorLibro(
        String nombre,
        Integer fechaNacimiento,
        Integer fechaMuerte,
        List<String> libros
) {
    @Override
    public String toString() {
        return  "\n"+"Autor: " + nombre + "\n" +
                "Fecha de nacimiento: " + fechaNacimiento + "\n" +
                "Fecha de fallecimiento: " + fechaMuerte + "\n" +
                "Libros: " + libros+"\n";
    }
}
