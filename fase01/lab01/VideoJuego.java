// Laboratorio Nro 1 - Ejercicios
// Autor: Arias Quispe Jhonatan David
// Colaboro: --------
// Tiempo: 30 minutos
import java.util.*;

public class VideoJuego{

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Ingrese el nombre del nuevo soldado:");
    Soldado s1 = new Soldado(sc.next());
    System.out.println("Ingrese el nivel de vida del nuevo soldado:");
    s1.setLife(sc.nextInt());


    System.out.println("Ingrese el nombre del nuevo soldado:");
    Soldado s2 = new Soldado(sc.next());
    System.out.println("Ingrese el nivel de vida del nuevo soldado:");
    s2.setLife(sc.nextInt());

    System.out.println("Ingrese el nombre del nuevo soldado:");
    Soldado s3 = new Soldado(sc.next());
    System.out.println("Ingrese el nivel de vida del nuevo soldado:");
    s3.setLife(sc.nextInt());

    System.out.println("Ingrese el nombre del nuevo soldado:");
    Soldado s4 = new Soldado(sc.next());
    System.out.println("Ingrese el nivel de vida del nuevo soldado:");
    s4.setLife(sc.nextInt());

    System.out.println("Ingrese el nombre del nuevo soldado:");
    Soldado s5 = new Soldado(sc.next());
    System.out.println("Ingrese el nivel de vida del nuevo soldado:");
    s5.setLife(sc.nextInt());

    System.out.println("=====DATOS DE SOLDADOS=====");
    System.out.println("Soldado: " + s1.getName() + " \nNivel de vida: " + s1.getLife() + "\n");
    System.out.println("Soldado: " + s2.getName() + " \nNivel de vida: " + s2.getLife() + "\n");
    System.out.println("Soldado: " + s3.getName() + " \nNivel de vida: " + s3.getLife() + "\n");
    System.out.println("Soldado: " + s4.getName() + " \nNivel de vida: " + s4.getLife() + "\n");
    System.out.println("Soldado: " + s5.getName() + " \nNivel de vida: " + s5.getLife() + "\n");

  }

}
