// Autor: Arias Quispe Jhonatan David
// Colaboro: --------
// Tiempo: 30 minutos
import java.util.*;
import graphics.*;


public class VideoJuego{
  
  public static Soldado[][] board = new Soldado[10][10];
  public static Picture gBoard;
  public static Soldado[] maxLife;
  public static int promedio = 0;
  
  public static void main(String[] args){
    Soldado[] army1 = initializeArmy(); 
    makeGBoard();
    displayBoard();

  }


  public static void displayArmy(Soldado[] army){
    System.out.println("\n===== Army Soldiers =====");
    for(Soldado soldier : army){
      System.out.println(" " + soldier.getName());
    }
  }

  public static void displayBoard(){
    Graphics g = new Graphics(gBoard);
    g.print();
  }
  
  public static void makeGBoard(){
    for(int i = 0; i < 10; i++){
      Picture fila = null;
      for(int j = 0; j < 10; j++){
        Picture c = Picture.casilleroBlanco();
        if(board[i][j] != null)
          c = Picture.soldier().superponer(c);
        if(j == 0){
          fila = c;
          continue;
        }
        fila = fila.alLado(c);
      }
      if(i == 0){
        gBoard = fila;
        continue;
      }
      gBoard = gBoard.encima(fila);
    } 
  }

  public static Soldado[] initializeArmy(){
    int promLife = 0;
    Random rand = new Random();
    int randNum = rand.nextInt(10) + 1;
    Soldado[] army = new Soldado[randNum];

    for(int i = 0; i < randNum; i++){
      army[i] = new Soldado("Soldado " + (i + 1));
      army[i].setLife(rand.nextInt(5) + 1);
      promLife += army[i].getLife();
      genColumnRow(army[i]);
    }
    promLife = promLife / army.length;
    promedio = (promLife + promedio) / 2;
    return army;
  }

  public static void genColumnRow(Soldado s){
    Random rand = new Random();
    int column;
    int row;
    do {
      column = rand.nextInt(10);
      row = rand.nextInt(10);
    } while(!isEmpty(column, row));
    s.setColumn(column);
    s.setRow(row);
    board[row][column] = s;
  }
  public static boolean isEmpty(int column, int row){
    return board[row][column] == null;
  }
  public static String whoWins(Soldado[] army1, Soldado[] army2){
    if (army1.length > army2.length)
      return "\n***** Army 1 is the winner! *****";

    if (army2.length > army1.length)
      return "\n***** Army 2 is the winner! *****";

    return "\n***** It's a tie. No clear winner. *****";
  }

}
