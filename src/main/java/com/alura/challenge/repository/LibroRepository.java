package com.alura.challenge.repository;


import com.alura.challenge.Dto.DtoLIstaAutorLibro;
import com.alura.challenge.Dto.DtoLibroAutor;
import com.alura.challenge.Dto.DtoLibroSinAutor;
import com.alura.challenge.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface LibroRepository extends JpaRepository<Libro,Long> {
    boolean existsByTituloIgnoreCase(String titulo);

    @Query("SELECT new com.alura.challenge.Dto.DtoLibroAutor(" +
            "l.titulo, l.idioma, l.descargas, a.nombre) " +
            "FROM Libro l JOIN l.autores a")
    List<DtoLibroAutor> todosLosLibros();

    @Query("SELECT l FROM Libro l WHERE l.idioma = :idiomaa")
    List<DtoLibroSinAutor> libroPorIdioma(@Param("idiomaa")String idioma);
}
