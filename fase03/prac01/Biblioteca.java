package prac01;
import java.util.*;
import java.io.*;
import prac01.almacen.*;
public class Biblioteca {
  private String nombre;

  public Biblioteca(String n) {
    nombre = n;
  }

  public void RegistrarNuevoLibro() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el id: ");
    String id = sc.nextLine();
    System.out.print("Ingrese el título:");
    String titulo = sc.nextLine();
    System.out.print("Ingrese autor: ");
    String autor = sc.nextLine();
    System.out.print("Ingrese la ubicación: ");
    String ubicacion = sc.nextLine();
    System.out.print("Ingrese qué tipo de documento es: ");
    String tipo;
    Documento doc = null;
    while (doc == null) {
      tipo = sc.nextLine().toUpperCase();
      if (tipo.equals("ARTICULO")) 
        doc = new Articulo ( id,  titulo,  ubicacion,  autor, ""); 
      else if (tipo.equals("LIBRO"))
        doc = new Libro ( id,  titulo,  ubicacion,  autor, ""); 
      else 
        doc = new Tesis ( id,  titulo,  ubicacion,  autor, ""); 
    }

  }
  public static void main(String[] args) {
    // Especifica la ruta del archivo CSV
    String registro = "./prac01/almacen/registroDeLibros.csv";

    try {
      // Abre el archivo en modo de escritura (true indica que se añadirán datos al final)
      FileWriter escritor = new FileWriter(registro, true);
      BufferedWriter bufferedWriter = new BufferedWriter(escritor);

      // Agrega una nueva línea al final del archivo CSV
      String nuevaLinea = "NuevoLibro,2024,AutorNuevo,OtraUbicacion";
      bufferedWriter.write(nuevaLinea);
      bufferedWriter.newLine();  // Agrega un salto de línea

      // Cierra el BufferedWriter
      bufferedWriter.close();

      System.out.println("Datos agregados al archivo CSV correctamente.");
    } catch (IOException e) {
      // Manejo de excepciones en caso de error de escritura
      System.err.println("Error al escribir en el archivo: " + e.getMessage());
    }
  }
}
