/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.pkg2_andrenavas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author eliza
 */
public class Prueba2_AndreNavas {

    private static Libro LIBRO_NO_ENCONTRADO;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Ingresar información del libro a la biblioteca");
            System.out.println("2. Prestar libro");
            System.out.println("3. Regresar libro");
            System.out.println("4. Buscar libro por nombre");
            System.out.println("5. Listar libros disponibles");
            System.out.println("6. Listar libros prestados");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de leer el número

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del libro: ");
                    String nombreLibro = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autorLibro = scanner.nextLine();

                    Libro nuevoLibro = new Libro(nombreLibro, autorLibro);
                    Libro.ingresarLibro(nuevoLibro);

                    nuevoLibro.mostrarInformacion();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del libro: ");
                    String nombrePrestamo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autorPrestamo = scanner.nextLine();

                    Libro libroPrestamo = Libro.buscarLibro(nombrePrestamo, autorPrestamo);
                    if (libroPrestamo != LIBRO_NO_ENCONTRADO) {
                        System.out.print("Ingrese el nombre del nuevo dueño: ");
                        String nuevoDueño = scanner.nextLine();
                        libroPrestamo.prestar(nuevoDueño);
                        libroPrestamo.mostrarInformacion();
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del libro: ");
                    String nombreRegreso = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autorRegreso = scanner.nextLine();

                    Libro libroRegreso = Libro.buscarLibro(nombreRegreso, autorRegreso);
                    if (libroRegreso != LIBRO_NO_ENCONTRADO) {
                        libroRegreso.regresar();
                        libroRegreso.mostrarInformacion();
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del libro: ");
                    String nombreBusqueda = scanner.nextLine();
                    ArrayList<Libro> librosEncontrados = Libro.buscarLibroPorNombre(nombreBusqueda);
                    if (!librosEncontrados.isEmpty()) {
                        System.out.println("Libros encontrados:");
                        for (Libro libro : librosEncontrados) {
                            libro.mostrarInformacion();
                        }
                    } else {
                        System.out.println("No se encontraron libros con ese nombre.");
                    }
                    break;
                case 5:
                    System.out.println("Libros disponibles:");
                    ArrayList<Libro> librosDisponibles = Libro.listarLibrosDisponibles();
                    for (Libro libro : librosDisponibles) {
                        libro.mostrarInformacion();
                    }
                    break;
                case 6:
                    System.out.println("Libros prestados:");
                    ArrayList<Libro> librosPrestados = Libro.listarLibrosPrestados();
                    for (Libro libro : librosPrestados) {
                        libro.mostrarInformacion();
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente!.");
            }
        } while (opcion != 7);
    }
}