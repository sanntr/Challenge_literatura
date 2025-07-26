package com.alura.challenge.model;

import com.alura.challenge.Dto.DtoLibro;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )

    private List<Autor> autores;
    private String idioma;
    private Integer descargas;

    public Libro(){}
    public Libro(String titulo, List<Autor> autores, String idioma, Integer descargas) {
        this.titulo = titulo;
        this.autores = autores;
        this.idioma = idioma;
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return "\n-------Libro------- \n" +
                "titulo=" + titulo + '\n' +
                "autores=" + autores+ "\n"+
                "idioma=" + idioma + '\n' +
                "descargas=" + descargas ;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public String getIdioma() {
        return idioma;
    }

    public Integer getDescargas() {
        return descargas;
    }
}
