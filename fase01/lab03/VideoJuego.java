// Laboratorio Nro 1 - Ejercicios
// Autor: Arias Quispe Jhonatan David
// Colaboro: --------
// Tiempo: 30 minutos
import java.util.*;

public class VideoJuego{

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Soldado[] ejercito = new Soldado[5];

    for(int i = 0; i < 5; i++){
      System.out.println("\nIngrese el nombre del soldado numero " + (i + 1) + ":");
      ejercito[i] = new Soldado(sc.next());

      System.out.println("Ingrese el nivel de vida del soldado numero " + (i + 1) + ":");
      ejercito[i].setLife(sc.nextInt());
    }

    System.out.println("\n=====DATOS DE SOLDADOS=====");
    System.out.println("Soldado: " + ejercito[0].getName() + " \nNivel de vida: " + ejercito[0].getLife() + "\n");
    System.out.println("Soldado: " + ejercito[1].getName() + " \nNivel de vida: " + ejercito[1].getLife() + "\n");
    System.out.println("Soldado: " + ejercito[2].getName() + " \nNivel de vida: " + ejercito[2].getLife() + "\n");
    System.out.println("Soldado: " + ejercito[3].getName() + " \nNivel de vida: " + ejercito[3].getLife() + "\n");
    System.out.println("Soldado: " + ejercito[4].getName() + " \nNivel de vida: " + ejercito[4].getLife() + "\n");

  }

}
