package com.alura.challenge.repository;

import com.alura.challenge.Dto.DtoAutor;
import com.alura.challenge.Dto.DtoAutorLibro;
import com.alura.challenge.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository <Autor,Long> {
    Optional<Autor> findByNombreIgnoreCase(String nombre);
    @Query("SELECT new com.alura.challenge.Dto.DtoAutorLibro(" +
            "l.titulo, a.nombre, a.fechaNacimiento, a.fechaMuerte) " +
            "FROM Libro l JOIN l.autores a")
    List<DtoAutorLibro> listaAutores();
    @Query("Select a FROM Autor a where a.fechaMuerte > :fecha OR a.fechaMuerte IS NULL")
    List<Autor> autoresVivos(@Param("fecha") Integer fecha);
}
