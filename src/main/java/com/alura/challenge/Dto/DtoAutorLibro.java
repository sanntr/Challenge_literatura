package com.alura.challenge.Dto;

// Es un record transicional para DToLIstaAutorLibro
public record DtoAutorLibro(
        String libro,
        String nombre,
        Integer fechaNacimiento,
        Integer fechaMuerte
        )
{


}
