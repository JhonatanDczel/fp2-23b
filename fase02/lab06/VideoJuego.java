// Autor: Arias Quispe Jhonatan David
// Colaboro: --------
// Tiempo: 30 minutos
import java.util.*;
import graphics.*;


public class VideoJuego{
  
  public static ArrayList<ArrayList<Soldado>> board = new ArrayList<>(10);
  public static Picture gBoard;
  public static Soldado maxLife = new Soldado("sold");
  public static int promedio = 0;
  
  public static void main(String[] args){
    for (int i = 0; i < 10; i++) {
      ArrayList<Soldado> fila = new ArrayList<>(10);
      for (int j = 0; j < 10; j++) {
        fila.add(null);
      }
      board.add(fila);
    }

    Soldado[] army1 = initializeArmy(1); 
    Soldado[] army2 = initializeArmy(2); 

    displayArmy(army1, "Ejercito 1");
    displayArmy(army2, "Ejercito 2");

    System.out.println("Soldado con maxima vida:");
    displaySoldier(maxLife);

    Soldado[] totales = new Soldado[army1.length + army2.length];

    System.arraycopy(army1, 0, totales, 0, army1.length);
    System.arraycopy(army2, 0, totales, army1.length, army2.length);

    System.out.println("Ranking de soldados por vida:");
    bubbleSortLife(totales);
    displayArmy(totales, "");
    
    whoWins(army1, army2);

    makeGBoard();
    displayBoard();



  }


  public static void displayArmy(Soldado[] army, String str){
    System.out.println("\n===== " + str + " =====");
    for(Soldado soldier : army){
      displaySoldier(soldier);
    }
  }

  public static void displaySoldier(Soldado s){
    System.out.println(" " + s.getName() + ":");
    System.out.println("  Nivel de vida: " + s.getLife());
    System.out.println("  Fila: " + (s.getRow() + 1));
    System.out.println("  Columna: " + (s.getColumn() + 1));
    System.out.print("\n");
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
        if(board.get(i).get(j) != null)
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

  public static Soldado[] initializeArmy(int n){
    int promLife = 0;
    Random rand = new Random();
    int randNum = rand.nextInt(10) + 1;
    Soldado[] army = new Soldado[randNum];

    for(int i = 0; i < randNum; i++){
      army[i] = new Soldado("Soldado " + n + "x" + (i + 1));
      army[i].setLife(rand.nextInt(5) + 1);
      if(army[i].getLife() > maxLife.getLife())
        maxLife = army[i];
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
    board.get(row).set(column, s);
  }
  public static boolean isEmpty(int column, int row){
    return board.get(row).get(column) == null;
  }
  public static void whoWins(Soldado[] army1, Soldado[] army2){
    System.out.println("La metrica tomada para el ganador es: cantidad");
    if (army1.length > army2.length)
      System.out.println("\n***** Army 1 is the winner! *****");
    else{
      if (army2.length > army1.length)
        System.out.println("\n***** Army 2 is the winner! *****");
      else
        System.out.println("\n***** It's a tie. No clear winner. *****");
  
    }
  }
  public static void insertionSortLife(Soldado[] army){
    for(int i = 1; i < army.length; i++){
      Soldado actual = army[i];
      int j = i - 1;
      while(j >= 0 && army[j].getLife() > actual.getLife()){
        army[j + 1] = army[j];
        j--;
      }
      army[j + 1] = actual;
    }
  }

  public static void bubbleSortLife(Soldado[] army){
    for(int i = 0; i < army.length - i; i++){
      for(int j = 0; j < army.length - 1 - i; j++){
        if(army[j].getLife() > army[j + 1].getLife())
          intercambiar(army, j, j + 1);
      }
    }
  }
  public static void intercambiar(Soldado[] army, int i, int j){
    Soldado aux = army[i];
    army[i] = army[j];
    army[j] = aux;
  }
}
