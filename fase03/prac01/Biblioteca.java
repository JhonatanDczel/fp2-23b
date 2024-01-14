package prac01;

import prac01.almacen.*;

import java.util.*;
import java.io.*;

public class Biblioteca {
  private Map<String, Usuario> usuarios = new HashMap<>();
  private Map<String, Documento> almacen = new HashMap<>();
  private String rutaLibros = "./almacen/registroDeLibros.csv";
  private String rutaCuentas = "./almacen/cuentas.csv";

  public Biblioteca() {
    logAcoounts();
    logBooks();
  }

  public void logBooks(){
    try (BufferedReader br = new BufferedReader(new FileReader(rutaLibros))) {
      String linea;

      while ((linea = br.readLine()) != null) {
        String[] campos = linea.split(",");
        String ID = campos[0];
        String title = campos[1];
        String type = campos[2];
        String autor = campos[3];
        String ubicacion = campos[4];
        String lector = campos[6];

        Documento doc = null;
        if (type.equals("Articulo"))
          doc = new Articulo(ID, title, autor, ubicacion, lector);
        else if (type.equals("Libro"))
          doc = new Libro(ID, title, autor, ubicacion, lector);
        else
          doc = new Tesis(ID, title, autor, ubicacion, lector);

        almacen.put(ID, doc);
      }

    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Error al leer los documentos");
    }
  }

  public void logAcoounts(){
    try (BufferedReader br = new BufferedReader(new FileReader(rutaCuentas))) {
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

  public String entregarLibro(Ficha ficha){
    String bookID = ficha.getBookID();
    Documento book = almacen.get(bookID);
    if (book == null || !book.disponible) {
      return "fallo";
    }
    book.disponible = false;
    book.idLector = ficha.getUser();

    System.out.println("\n" + book.tipo + " \"" + book.titulo + "\" entregado exitosamente");
    System.out.println("Fecha del prestamo: " + ficha.getStart());
    System.out.println("Fecha de devolucion: " + ficha.getEnd() + "\n");
    return "exitoso";
  }

  public void recibirLibro(Ficha ficha){

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
