/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.pkg2_andrenavas;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author eliza
 */
public class Libro {
    private String nombre;
    private String autor;
    private long id;
    private String estado;
    private String dueño;

    private static Libro LIBRO_NO_ENCONTRADO = new Libro("", "");

    private static ArrayList<Libro> biblioteca = new ArrayList<>();

    public Libro(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
        this.id = generarIdUnico();
        this.estado = "disponible";
        this.dueño = "";
    }

    private long generarIdUnico() {
        Random random = new Random();
        long idGenerado = random.nextLong();

        if (idGenerado >= 0) {
            return idGenerado;
        } else {
            return -idGenerado;
        }
    }

    public static void ingresarLibro(Libro libro) {
        biblioteca.add(libro);
        System.out.println("Libro ingresado a la biblioteca.");
    }

    public static Libro buscarLibro(String nombre, String autor) {
        for (Libro libro : biblioteca) {
            if (libro.nombre.equals(nombre) && libro.autor.equals(autor)) {
                return libro;
            }
        }
        return LIBRO_NO_ENCONTRADO;
    }

    public void prestar(String nuevoDueño) {
        boolean libroEncontrado = false;

        for (Libro libro : biblioteca) {
            if (libro.nombre.equals(this.nombre) && libro.autor.equals(this.autor)) {
                libroEncontrado = true;

                if (libro.estado.equals("disponible")) {
                    libro.estado = "prestado";
                    libro.dueño = nuevoDueño;
                    System.out.println("Libro prestado a: " + nuevoDueño);
                } else {
                    System.out.println("El libro no está disponible para prestar."); 
                    return;
                }
                break;
            }
        }

        if (!libroEncontrado) {
            System.out.println("Este libro no se encuentra disponible en la biblioteca."); 
        }
    }

    public void regresar() {
        if (estado.equals("prestado")) {
            estado = "disponible";
            dueño = "";
            System.out.println("Libro devuelto correctamente.");
        } else {
            System.out.println("El libro no estaba prestado.");
        }
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Autor: " + autor);
        System.out.println("Estado: " + estado);
        System.out.println("Dueño: " + dueño);
    } 
    
   public static ArrayList<Libro> buscarLibroPorNombre(String nombre) {
        ArrayList<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.nombre.equalsIgnoreCase(nombre)) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public static ArrayList<Libro> listarLibrosDisponibles() {
        ArrayList<Libro> librosDisponibles = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.estado.equals("disponible")) {
                librosDisponibles.add(libro);
            }
        }
        return librosDisponibles;
    }

    public static ArrayList<Libro> listarLibrosPrestados() {
        ArrayList<Libro> librosPrestados = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.estado.equals("prestado")) {
                librosPrestados.add(libro);
            }
        }
        return librosPrestados;
    }
}