
import java.util.Scanner;

public class PlataformaMatricula {

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
        System.out.println("|  3. Regresar al menu principal |");
        System.out.println("+--------------------------------+");
        System.out.print("|  Elige una opcion: ");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        System.out.println("+--------------------------------+");
        sleep(500);

        switch (op) {
          case 1:
            //Logica para mostrar cupos
            break;
          case 2:
            //Logica para registrar matricula
            break;
          case 3:
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

}

