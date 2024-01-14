package prac01;

import prac01.almacen.*;

import java.util.*;
import java.io.*;

public class Biblioteca {
  private Map<String, Usuario> usuarios = new HashMap<>();

  public Biblioteca() {
    String rutaArchivo = "./almacen/cuentas.csv";

    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
      String linea;

      while ((linea = br.readLine()) != null) {
        String[] campos = linea.split(",");

        String usuario = campos[0].trim();
        String contrasena = campos[1].trim();
        Usuario user = new Usuario(usuario, contrasena);

        usuarios.put(usuario, user);
      }

    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Error al leer los usuarios");
    }
  }

  public Usuario getUser(String user) {
    return usuarios.get(user);
  }

  public void entregarLibro(String ID){

  }

  public void recibirLibro(String ID){

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
        doc = new Articulo(id, titulo, ubicacion, autor, "");
      else if (tipo.equals("LIBRO"))
        doc = new Libro(id, titulo, ubicacion, autor, "");
      else
        doc = new Tesis(id, titulo, ubicacion, autor, "");
    }

    // Especifica la ruta del archivo CSV
    String registro = "./prac01/almacen/registroDeLibros.csv";

    try {
      // Abre el archivo en modo de escritura (true indica que se añadirán datos al
      // final)
      FileWriter escritor = new FileWriter(registro, true);
      BufferedWriter bufferedWriter = new BufferedWriter(escritor);

      // Agrega una nueva línea al final del archivo CSV
      bufferedWriter.write(doc.datosFormatoCSV());
      bufferedWriter.newLine(); // Agrega un salto de línea

      // Cierra el BufferedWriter
      bufferedWriter.close();

      System.out.println("Datos agregados al archivo CSV correctamente.");
    } catch (IOException e) {
      // Manejo de excepciones en caso de error de escritura
      System.err.println("Error al escribir en el archivo: " + e.getMessage());
    }
  }
}
