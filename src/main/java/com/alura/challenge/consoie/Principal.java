package com.alura.challenge.consoie;

import com.alura.challenge.service.LibrosService;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class Principal {
    private Scanner scanner= new Scanner(System.in);
    private LibrosService librosService ;
    public Principal(LibrosService librosService) {
        this.librosService = librosService;
    }
    public void menu() {
        int selector = 8;
        try {
            while (selector != 0) {
                System.out.println("""
                    --------
                    Elija la opción a través de su número:
                    1- buscar libro por título
                    2- listar libros registrados
                    3- listar autores registrados
                    4- listar autores vivos en un determinado año
                    5- listar libros por idioma
                    0 - salir
                    """);

                selector = scanner.nextInt();
                scanner.nextLine();

                switch (selector) {
                    case 1:
                        System.out.println("Escriba el nombre del libro: ");
                        librosService.busquedaLibroApi(scanner.nextLine());
                        break;
                    case 2:
                        librosService.listaLibro();
                        break;
                    case 3:
                        librosService.listarAutor();
                        break;
                    case 4:
                        System.out.println("Ingrese el año:");
                        librosService.buscaAutoresVivos(scanner.nextInt());
                        scanner.nextLine(); // limpiar entrada
                        break;
                    case 5:
                        System.out.print("Selecciona el idioma\n1. Inglés \n2. Español \n3. Francés \n4. Finlandés:\n ");
                        librosService.buscarLibroPorIdioma(scanner.nextInt());
                        scanner.nextLine(); // limpiar entrada
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Se esperaba un número.");
            scanner.nextLine();
            menu();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

}
