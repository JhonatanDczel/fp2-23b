package prac01;

import java.io.*;
import java.util.*;

public class Sistema {
  private static Map<String, String> cuentas = new HashMap<>();
  private static Biblioteca biblioteca = new Biblioteca();
  private static Usuario user;

  public static void main(String[] args) {
    getCuentas();
    System.out.println("+--------------------------------+");
    System.out.println("|   Sistema de Biblioteca EPIS   |");
    System.out.println("+--------------------------------+");
    System.out.println("|     Credenciales de prueba     |");
    System.out.println("|         Usuario: user          |");
    System.out.println("|       contraseña: contra       |");
    user = getLogin();
    user.setBiblioteca(biblioteca);
    menu();
  }

  public static void menu(){
    System.out.println();
    System.out.println("+--------------------------------+");
    System.out.println("|         Menu principal         |");
    System.out.println("+--------------------------------+");
    System.out.println("|  1. Pedir prestado libro       |");
    System.out.println("|  2. Devolver libro             |");
    System.out.println("|  3. Salir                      |");
    System.out.println("+--------------------------------+");
    System.out.print("|  Elige una opcion: ");


    Scanner sc = new Scanner(System.in);
    int op = sc.nextInt();

    System.out.println("+--------------------------------+");
    sleep(800);

    switch (op) {
      case 1:
        pedirLibro();
        break;
      case 2:
        devolverLibro();
        break;
      case 3:
        sleep(200);
        System.out.println("Cerrando sesion...");
        sleep(200);
        return;
    }
    sleep();
    menu();
  }

  public static void devolverLibro() {
    System.out.println();
    System.out.println("\n+--------------------------------+");
    System.out.println("|        Libros que tienes       |");
    System.out.println("+--------------------------------+");
    user.mostrarLibros();
    System.out.println("\n+--------------------------------+");
    System.out.print("| Ingrese el ID del libro: ");
    Scanner sc = new Scanner(System.in);
    String id = sc.nextLine();
    System.out.println("+--------------------------------+");
    sleep();
    user.devolverLibro(id);
  }

  public static void pedirLibro() {
    System.out.println("\n+--------------------------------+");
    System.out.println("|        Libros en almacen       |");
    System.out.println("+--------------------------------+");
    mostrarLibros();
    System.out.println("\n+--------------------------------+");
    System.out.print("| Ingrese el ID del libro: ");
    Scanner sc = new Scanner(System.in);
    String id = sc.nextLine();
    System.out.println("+--------------------------------+");
    sleep();

    user.pedirLibro(id);
  }

  public static void mostrarLibros() {
    biblioteca.mostrarStock();
  }

  public static Usuario getLogin() {
    Scanner sc = new Scanner(System.in);
    System.out.println("+--------------------------------+");
    System.out.println("|        Iniciar sesión:         |");
    System.out.println("+--------------------------------+");
    System.out.print("| Usuario:  ");
    String user = sc.nextLine();

    System.out.print("| Password: ");
    String pwd = sc.nextLine();
    System.out.println("+--------------------------------+");

    sleep();

    if(pwd.equals(cuentas.get(user))){
      System.out.println("\nInicio de sesion exitoso!");
      System.out.println("Bienvenid@ al sistema de biblioteca " + user);

      sleep();

      return biblioteca.getUser(user);
    }

    System.out.println("\nUsuario o contraseña incorrectos\nIntente de nuevo...\n");

    sleep();

    return getLogin();
  }

  public static void sleep(int n){
    try {
      Thread.sleep(n);
    } catch (InterruptedException e) {
      e.printStackTrace(); 
    }
  }

  public static void sleep(){
    try {
      Thread.sleep(800);
    } catch (InterruptedException e) {
      e.printStackTrace(); 
    }
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

