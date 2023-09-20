// Laboratorio Nro 1 - Ejercicios
// Autor: Arias Quispe Jhonatan David
// Colaboro: --------
// Tiempo: 30 minutos
import java.util.*;

public class VideoJuego{

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] names = new String[5];

    for(int i = 0; i < 5; i++){
      System.out.println("\nIngrese el nombre del soldado numero " + (i + 1) + ":");
      names[i] = sc.next();
    }
    
    Soldado s1 = new Soldado(names[0]);
    Soldado s2 = new Soldado(names[1]);
    Soldado s3 = new Soldado(names[2]);
    Soldado s4 = new Soldado(names[3]);
    Soldado s5 = new Soldado(names[4]);


    System.out.println("=====DATOS DE SOLDADOS=====");
    System.out.println("Soldado: " + s1.getName() + " \nNivel de vida: " + s1.getLife() + "\n");
    System.out.println("Soldado: " + s2.getName() + " \nNivel de vida: " + s2.getLife() + "\n");
    System.out.println("Soldado: " + s3.getName() + " \nNivel de vida: " + s3.getLife() + "\n");
    System.out.println("Soldado: " + s4.getName() + " \nNivel de vida: " + s4.getLife() + "\n");
    System.out.println("Soldado: " + s5.getName() + " \nNivel de vida: " + s5.getLife() + "\n");

  }

}
