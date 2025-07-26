package com.alura.challenge.service;

import com.alura.challenge.Dto.*;
import com.alura.challenge.model.Autor;
import com.alura.challenge.model.Libro;
import com.alura.challenge.repository.AutorRepository;
import com.alura.challenge.repository.LibroRepository;
import com.google.gson.JsonArray;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class LibrosService {
    private LibroRepository repositiry;
    private AutorRepository autorRepository;

    public LibrosService(LibroRepository repositiry, AutorRepository autorRepository) {
        this.repositiry = repositiry;
        this.autorRepository = autorRepository;
    }

    public List<DtoLibro> busquedaLibroApi(String titulo){
        // instanncia de los objetos
        List<DtoLibro> libros= new ArrayList<>();
        GutendexApiClient datosApi = new GutendexApiClient();
        ConversionDatos conversionDatos= new ConversionDatos();

        System.out.println("https://gutendex.com/books?search="+titulo.replace(" ","%20"));
        JsonArray busqueda= datosApi.consultaApi("http://gutendex.com/books?search="+titulo.replace(" ","%20"));

        //verifica la existencia de las datos
        if (busqueda.isJsonNull()||busqueda.isEmpty()){
            System.out.println("Libro no existente");;
        }else {
            //manejo de culaquier erro(indiferente)
            try {
                busqueda.forEach(e -> libros.add(
                        conversionDatos.obtenerDatos(e.toString(), DtoLibro.class)
                ));

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("**********************************************" +
                        "No se pudo realiza la conversion");
            }

            try {
                libros.forEach(e-> guardarDatos(e));
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("No se pudo guardar en la base de datos");
            }
        }
        return libros;
    }
    @Transactional
    private void guardarDatos(DtoLibro datosLibro) {
        List<Autor> autoresFinales = new ArrayList<>();

        //verifica la existencia del autor en la db
        for (DtoAutor autorDto : datosLibro.autor()) {
            Optional<Autor> autorExistente = autorRepository.findByNombreIgnoreCase(autorDto.nombre());

            Autor autor = autorExistente.orElseGet(() -> {
                Autor nuevoAutor = new Autor(autorDto.nombre(),autorDto.fechaNacimiento(),autorDto.fechaMuerte());
                return autorRepository.save(nuevoAutor);
            });

            autoresFinales.add(autor);
        }

        Libro libro = new Libro(
                datosLibro.titulo(),
                autoresFinales,
                datosLibro.idioma().getFirst().strip(),
                datosLibro.descargas()
        );

        // verifica la existencia del libro en db
        if (repositiry.existsByTituloIgnoreCase(libro.getTitulo())){
            System.out.println("libro ya existente en la base de datos");
        }else {
            repositiry.save(libro);
            System.out.println(libro.toString());
        }
    }

    public void listaLibro(){
        List<DtoLibroAutor> l =repositiry.todosLosLibros();
        l.forEach(System.out::println);
    }

    public void  listarAutor(){
     List<DtoAutorLibro> listaedAutores =autorRepository.listaAutores();
     Map<String, DtoLIstaAutorLibro> agrupado=new LinkedHashMap<>();
        for (DtoAutorLibro dto : listaedAutores) {
            agrupado.compute(dto.nombre(), (k, v) -> {
                if (v == null) {
                    return new DtoLIstaAutorLibro(
                            dto.nombre(),
                            dto.fechaNacimiento(),
                            dto.fechaMuerte(),
                            new ArrayList<>(List.of(dto.libro()))
                    );
                } else {
                    v.libros().add(dto.libro());
                    return v;
                }
            });
        }
        agrupado.values().forEach(e-> System.out.println(e.toString()));;
    }
    public void buscaAutoresVivos(Integer fecha){
        autorRepository.autoresVivos(fecha).forEach(e-> System.out.println(e.String()));
    }
    public void  buscarLibroPorIdioma(int selector){
        String idioma = null;
        switch (selector){
            case 1:
                idioma="en";
                break;
            case 2:
                idioma="es";
                break;
            case 3:
                idioma="fr";
                break;
            case 4:
                idioma="fi";
            default:
                break;
        }
        if (idioma==null){
            System.out.println("Idioma no disponible");
        }else {
            List<DtoLibroSinAutor> lobros= repositiry.libroPorIdioma(idioma);
            if (lobros.isEmpty()){
                System.out.println("no hay libros registrados con ese idioma");
            }
            lobros.forEach(e-> System.out.println(e));
        }

    }
}
