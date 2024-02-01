package prac01;

import prac01.almacen.*;

import java.util.*;
import java.io.*;
import prac01.almacen.*;
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

      System.out.println("Datos agregados al archivo CSV correctamente.");
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

    String t = book.tipo.substring(0, 1).toUpperCase() + book.tipo.substring(1).toLowerCase();
    System.out.println("\n" + t + " \"" + book.titulo + "\" entregado exitosamente");
    System.out.println("Fecha del prestamo: " + ficha.getStart());
    System.out.println("Fecha de devolucion: " + ficha.getEnd() + "\n");
    return "exitoso";
  }

  public void recibirLibro(Ficha ficha){
    String bookID = ficha.getBookID();
    Documento doc = almacen.get(bookID);
    doc.disponible = true;
    doc.idLector = "none";

    System.out.println("\nEl libro fue entredado exitosamente");
    System.out.println("Fecha del prestamo: " + ficha.getStart());
    System.out.println("Fecha de devolucion: " + ficha.getEnd() + "\n");
  }

  public void imprimirLibro(String ID){
    Documento doc = almacen.get(ID);
    System.out.println();
    Sistema.sleep(200);
    System.out.println("- " + doc.tipo.toUpperCase());
    System.out.println("Titulo:\t\t" + doc.titulo);
    System.out.println("Autor:\t\t" + doc.autor);
    System.out.println("Ubicacion:\t" + doc.ubicacion);
    System.out.println("Disponible:\t" + (doc.disponible ? "Si" : "No"));
    System.out.println("ID:\t\t" + doc.id);
  }

  public void mostrarStock(){
    System.out.println("Listado de libros en Biblioteca:");
    for (String bookID : almacen.keySet()) {
      imprimirLibro(bookID);
    }
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
    return doc;

  }
  public void verLibros() {
    try {
      Scanner sc = new Scanner(new File(registro));
      sc.nextLine();
      while (sc.hasNextLine()) {
        String [] datos = sc.nextLine().split(",");
        System.out.printf("TITULO: %s\nID: %s\nTIPO: %s\nAUTOR: %s\nUBICACIÓN: %s\nDisponible: %b\nid - lector: %s\n",
            datos[1], datos[0], datos[2], 
            datos[3], datos[4], datos[5], datos[5]);
      }
    } catch (FileNotFoundException e) {
      System.err.println("Archivo no encontrado: " + e.getMessage());
    }
  }
}
