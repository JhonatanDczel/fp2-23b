// Autor: Arias Quispe Jhonatan David
// Colaboro: --------
// Tiempo: 30 minutos
import java.util.*;
import java.util.HashMap;
import graphics.*;


public class VideoJuego{
  
  public static Soldado[][] board = new Soldado[10][10];
  public static Picture gBoard;
  public static Soldado maxLife = new Soldado("sold");
  public static int promedio = 0;
  
  public static void main(String[] args){
    HashMap<String, Soldado> army1 = initializeArmyHashMap(0, false);
    HashMap<String, Soldado> army2 = initializeArmyHashMap(1, true);
    displayArmy(army1, "Ejercito 1");
    displayArmy(army2, "Ejercito 2");
    System.out.println("Soldado con maxima vida:");
    displaySoldier(maxLife);

    HashMap<String, Soldado> ranking = ranking(army1, army2);
    displayArmy(ranking, "Ranking de soldados:");
    makeGBoard();
    displayBoard();

  }


  public static HashMap<String, Soldado> ranking(HashMap<String, Soldado> army1, HashMap<String, Soldado> army2){
    Soldado[] a1 = toArray(army1);
    Soldado[] a2 = toArray(army2);
    Soldado[] total = new Soldado[a1.length + a2.length];
    int i = 0;

    for(Soldado s : a1){
      total[i] = s;
      i++;
    }
    for(Soldado s : a2){
      total[i] = s;
      i++;
    }
    bubbleSortLife(total);
    HashMap<String, Soldado> ranking = new HashMap<>();
    for(Soldado s : total){
      ranking.put(s.getName(), s);
    }
    return ranking;
  }
  public static Soldado[] toArray(HashMap<String, Soldado> armyH){
    Soldado[] army = new Soldado[armyH.size()];
    int i = 0;
    for(String name : armyH.keySet()){
      army[i] = armyH.get(name);
      i++;
    }
    return army;
  }
  public static HashMap<String, Soldado> initializeArmyHashMap(int n, boolean negro){

    int promLife = 0;
    Random rand = new Random();
    int randNum = rand.nextInt(10) + 1;
    HashMap<String, Soldado> army = new HashMap<>();

    for(int i = 0; i < randNum; i++){
      String nombre = "Soldado " + n + "x" + i;
      army.put(nombre,new Soldado(nombre));
      army.get(nombre).setNegro(negro);
      army.get(nombre).setLife(rand.nextInt(5) + 1);
      if(army.get(nombre).getLife() > maxLife.getLife())
        maxLife = army.get(nombre);
      promLife += army.get(nombre).getLife();
      genColumnRow(army.get(nombre));
    }
    promLife = promLife / army.size();
    promedio = (promLife + promedio) / 2;
    return army;

  }
  public static void displayArmy(HashMap<String, Soldado> army, String str){
    System.out.println("\n===== " + str + " =====");
    for(String soldado : army.keySet()){
      displaySoldier(army.get(soldado));
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
        if(board[i][j] != null){
          c = Picture.soldier().superponer(c);
          if(board[i][j].isNegro())
            c = Picture.soldier().invertir().superponer(c);
        }
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

  public static Soldado[] initializeArmy(int n, boolean negro){
    int promLife = 0;
    Random rand = new Random();
    int randNum = rand.nextInt(10) + 1;
    Soldado[] army = new Soldado[randNum];

    for(int i = 0; i < randNum; i++){
      army[i] = new Soldado("Soldado " + n + "x" + i);
      if(negro)
        army[i].setNegro(true);
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
