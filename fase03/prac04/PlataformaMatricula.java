
import java.util.*;
import java.sql.*;
import connection.ConnectionDB;

public class PlataformaMatricula {
    private ConnectionDB db = ConnectionDB.getInstance();

    public static void main(String args[]) {
        System.out.println("+--------------------------------+");
        System.out.println("|   Sistema de Matriculas EPIS   |");
        System.out.println("+--------------------------------+");
        menu();
    }

    public static void menu() {
        System.out.println("+--------------------------------+");
        System.out.println("|         Menu principal         |");
        System.out.println("+--------------------------------+");
        System.out.println("|  1. Empezar sesion             |");
        System.out.println("|  2. Salir                      |");
        System.out.println("+--------------------------------+");
        System.out.print("|  Elige una opcion: ");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        System.out.println("+--------------------------------+");
        sleep(500);

        switch (op) {
          case 1:
            menuMatriculas();
            break;
          case 2:
            System.out.println("Cerrando sesion...");
            sleep(200);
            return;
        }

        sleep(500);
        menu();
    }

    public static void menuMatriculas(){
        System.out.println("+--------------------------------+");
        System.out.println("|         Menu Matriculas        |");
        System.out.println("|      Tiempo restante:          |");
        System.out.println("+--------------------------------+");
        System.out.println("|  1. Mostrar cupos              |");
        System.out.println("|  2. Registrar matricula        |");
        System.out.println("|  3. Matricularse               |");
        System.out.println("+--------------------------------+");
        System.out.print("|  Elige una opcion: ");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        System.out.println("+--------------------------------+");
        sleep(500);

        switch (op) {
          case 1:
            mostrarCupos();
            break;
          case 2:
            registrarMatricula();
            break;
          case 3:
            ConnectionDB db = ConnectionDB.getInstance();
            db.refreshPlaces();
            db.executeRegister();
            return;
          default:
            break;
        }
        menuMatriculas();
    }

  public static void sleep(int n) {
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

  public static void mostrarCupos() {
    ConnectionDB db = ConnectionDB.getInstance();
    db.refreshPlaces();
    HashMap<Integer, Integer> places = db.getPlacesAvailable();
    System.out.println("+--------------------------------+");
    System.out.println("|         Cupos disponibles       |");
    System.out.println("+--------------------------------+");
    for (Map.Entry<Integer, Integer> entry : places.entrySet()) {
      System.out.println("|  Curso: " + entry.getKey() + " | Cupos: " + entry.getValue());
    }
    System.out.println("+--------------------------------+");
  }
  
  public synchronized static void registrarMatricula() {
    ConnectionDB db = ConnectionDB.getInstance();
    db.refreshPlaces();
    mostrarCupos();
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el id del curso que desea matricularse: ");
    int id = sc.nextInt();
    if (db.isValidSelection(id)) {
      db.selectCourse(id);
      //db.executeRegister();
      System.out.println("Curso seleccionado");
    } else {
      System.out.println("No hay cupos disponibles para el curso seleccionado");
    }
    sleep(1500);
  }
}

