// Laboratorio Nro 1 - Ejercicios
// Autor: Arias Quispe Jhonatan David
// Colaboro: --------
// Tiempo: 30 minutos
import java.util.*;

public class VideoJuego{

  public static void main(String[] args){
    String[] army1 = initializeArmy(); 
    String[] army2 = initializeArmy();

    System.out.println("╔════════════════════════════╗");
    System.out.println("║    Welcome to the Battle   ║");
    System.out.println("║       Simulator Game!      ║");
    System.out.println("╚════════════════════════════╝");
    
    System.out.println("\n***** Prepare for battle! *****");

    displayArmy(army1);
    displayArmy(army2);

    System.out.println(whoWins(army1, army2));

  }


  public static void displayArmy(String[] army){
    System.out.println("\n===== Army Soldiers =====");
    for(String soldier : army){
      System.out.println(" " + soldier);
    }
  }

  public static String[] initializeArmy(){
    Random rand = new Random();
    int randNum = rand.nextInt(5) + 1;
    String[] army = new String[randNum];

    for(int i = 0; i < randNum; i++){
      army[i] = "Soldado " + (i + 1);
    }
    return army;
  }

  public static String whoWins(String[] army1, String[] army2){
    if (army1.length > army2.length)
      return "\n***** Army 1 is the winner! *****";

    if (army2.length > army1.length)
      return "\n***** Army 2 is the winner! *****";

    return "\n***** It's a tie. No clear winner. *****";
  }

}
