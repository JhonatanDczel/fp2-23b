package prac01;

import java.io.*;
import java.util.*;

public class Sistema {
  private static Map<String, String> cuentas = new HashMap<>();
  private static Biblioteca biblioteca = new Biblioteca();
  private static Usuario user;

  public static void main(String[] args) {
    getCuentas();
    System.out.println("Sistema de Biblioteca EPIS");
    user = getLogin();
    user.setBiblioteca(biblioteca);
    menu();
  }

  public static void menu(){
    System.out.println("====== Menu principal ======");
    System.out.println("1. Pedir prestado libro");

    System.out.println("2. Devolver libro");
    System.out.println("3. Salir");
    System.out.println();

    Scanner sc = new Scanner(System.in);
    int op = sc.nextInt();

    switch (op) {
      case 1:
        pedirLibro();
        break;
      case 2:
        devolverLibro();
        break;
      case 3:
        System.out.println("Cerrando sesion...");
        return;
    }
    menu();
  }

  public static void devolverLibro() {
    System.out.println();
    user.mostrarLibros();
    System.out.print("Ingrese el ID del libro a devolver: ");
    Scanner sc = new Scanner(System.in);
    String id = sc.nextLine();
    user.devolverLibro(id);
  }

  public static void pedirLibro() {
    System.out.println("\n====== Libros en almacen ======");
    mostrarLibros();
    System.out.print("Ingrese el ID del libro: ");
    Scanner sc = new Scanner(System.in);
    String id = sc.nextLine();

    user.pedirLibro(id);
  }

  public static void mostrarLibros() {
    try (BufferedReader br = new BufferedReader(new FileReader("./almacen/registroDeLibros.csv"))) {
      String linea;

      System.out.println("Listado de libros:");

      while ((linea = br.readLine()) != null) {
        String[] campos = linea.split(",");

        if (campos.length >= 7) {
          System.out.println("ID: " + campos[0].trim());
          System.out.println("TITULO: " + campos[1].trim());
          System.out.println("TIPO: " + campos[2].trim());
          System.out.println("AUTOR: " + campos[3].trim());
          System.out.println("UBICACION: " + campos[4].trim());
          System.out.println("DISPONIBLE: " + campos[5].trim());
          System.out.println("IDLECTOR: " + campos[6].trim());
          System.out.println("------");
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Usuario getLogin() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Iniciar sesión:");
    System.out.println("Usuario:");
    String user = sc.nextLine();
    System.out.println("Password:");
    String pwd = sc.nextLine();

    if(pwd.equals(cuentas.get(user))){
      return biblioteca.getUser(user);
    }
    return getLogin();
  }

  public static void getCuentas(){
    String ruta = "./almacen/cuentas.csv";

    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
      String linea;

      while ((linea = br.readLine()) != null) {
        String[] campos = linea.split(",");

        String usuario = campos[0].trim();
        String contrasena = campos[1].trim();

        cuentas.put(usuario, contrasena);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

