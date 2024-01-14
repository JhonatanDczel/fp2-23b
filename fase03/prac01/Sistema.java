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
    System.out.println("\n====== Menu principal ======");
    System.out.println("1. Pedir prestado libro");

    System.out.println("2. Devolver libro");
    System.out.println("3. Salir");
    System.out.println();

    System.out.println("> Elige una opcion: ");

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
    System.out.print("\n> Ingrese el ID del libro a devolver: ");
    Scanner sc = new Scanner(System.in);
    String id = sc.nextLine();
    user.devolverLibro(id);
  }

  public static void pedirLibro() {
    System.out.println("\n====== Libros en almacen ======");
    mostrarLibros();
    System.out.print("> Ingrese el ID del libro: ");
    Scanner sc = new Scanner(System.in);
    String id = sc.nextLine();

    user.pedirLibro(id);
  }

  public static void mostrarLibros() {
    biblioteca.mostrarStock();
  }

  public static Usuario getLogin() {
    Scanner sc = new Scanner(System.in);
    System.out.println("\nIniciar sesión:");
    System.out.println("Usuario:");
    String user = sc.nextLine();
    System.out.println("Password:");
    String pwd = sc.nextLine();

    if(pwd.equals(cuentas.get(user))){
      return biblioteca.getUser(user);
    }

    System.out.println("\nUsuario o contraseña incorrectos\nIntente de nuevo...");
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

