package prac01;
import java.util.*;
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
    System.out.print("Ingrese autor");
    String autor = sc.nextLine();
    System.out.print("Ingrese la ubicación");
    String ubicacion = sc.nextLine();
    System.out.print("Ingrese qué tipo de documento es: ");
    String tipo;
    Documento doc;
    while (doc == null) {
      tipo = sc.nextLine.toUpperCase();
      if (tipo.equals("ARTICULO")) 
        doc = new Articulo ( id,  titulo,  ubicacion,  autor); 
      else if (tipo.equals("LIBRO"))
        doc = new Libro ( id,  titulo,  ubicacion,  autor); 
      else 
        doc = new Tesis ( id,  titulo,  ubicacion,  autor); 
    }

  }
}
