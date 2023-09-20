// Laboratorio Nro 1 - Ejercicios
// Autor: Arias Quispe Jhonatan David
// Colaboro: --------
// Tiempo: 30 minutos
import java.util.*;

public class VideoJuego{

  public static void main(String[] args){

  }
  public static void initializeArmy(String[] army){
    Random rand = new Random();
    int randNum = rand.nextInt(5) + 1;

    for(int i = 0; i < randNum; i++){
      army[i] = "Soldado " + (i + 1);
    }
  }

}
