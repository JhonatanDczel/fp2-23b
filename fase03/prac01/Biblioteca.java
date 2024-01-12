package prac01;
import java.util.*;
public class Biblioteca {
  private String nombre;

  public Biblioteca(String n) {
    nombre = n;
  }

  public void RegistrarNuevoLibro() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese su título: ");
    String id = sc.nextLine();
  }
}
