package com.alura.challenge.model;

import com.alura.challenge.Dto.DtoAutor;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nombre;
    private Integer fechaNacimiento;
    private  Integer fechaMuerte;
    @ManyToMany(mappedBy = "autores",fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor() {}

    public Autor(String nombre, Integer fechaNacimiento, Integer fechaMuerte) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaMuerte = fechaMuerte;
    }

    @Override
    public String toString() {
        return "Autor" +
                "libros=" + libros +
                ", fechaMuerte=" + fechaMuerte +
                ", fechaNacimiento=" + fechaNacimiento +
                ", nombre='" + nombre + '\'';
    }

    public String String() {
        return "\n-----Autor----\n" +
                "nombre=" + nombre + "\n" +
                "fechaNacimiento=" + fechaNacimiento +"\n"+
                "fechaMuerte=" + fechaMuerte;
    }
}
