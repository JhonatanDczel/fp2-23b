// Fundamentos de la programacion 2
// Autor: Arias Quispe Jhonatan David
import java.util.*;
import graphics.*;


public class VideoJuego{
  
  public static Soldado[][] campo1; //Este array contendra a los soldados del ejercito 1
  public static Soldado[][] campo2; //Este array contendra a los soldados del ejercito 2
  public static Soldado[][] board; //Este array contendra a los soldados despues de la batalla
                                                         //
  public static Picture gcampo1; //Este es el objeto Picture que representa el primer ejercito antes de la batalla
  public static Picture gcampo2; //Este es el objeto Picture que representa el segundo ejercito antes de la batalla
  public static Picture gboard; //Este es el objeto Picture que representa al tablero
                                //
  public static int promedio = 0; //Este es el promedio de vida global
  public static int con1;
  public static int con2;

  public static void main(String[] args){
    //Se le pide al usuario que ingrese el numero de soldados
    System.out.println("Ingrese el numero de soldados por ejercito:");
    Scanner sc = new Scanner(System.in);
    int cantidad = sc.nextInt();

    //Se inicializan los arrays de campo
    campo1 = new Soldado[cantidad][cantidad];
    campo2 = new Soldado[cantidad][cantidad];
    board = new Soldado[cantidad][cantidad];
    con1 = cantidad;
    con2 = cantidad;

    //Se inicializan dos ejercitos de soldados, el primer parametro es el numero de ejercito, el segundo sirve para activar la coloracion de negro y el tercer parametro es la cantidad de soldados que se generaran
    //Cada ejercito se inicializara en su respectivo campo
    Soldado[] army1 = initializeArmy(0, false, cantidad); 
    Soldado[] army2 = initializeArmy(1, true, cantidad); 

    makeGBoard(campo1, gcampo1);
    displayArmy(army1, "Ejercito 1");

    makeGBoard(campo2, gcampo2);
    displayArmy(army2, "Ejercito 2");

    war(campo1, campo2);
    makeGBoard(board, gboard);

    System.out.println(whoWins(campo1, campo2));
  }

  //Este metodo genera el enfrentamiento entre dos campos de soldados
  public static void war(Soldado[][] c1, Soldado[][] c2){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        Soldado s = null;
        if(c1[i][j] != null)
          s = c1[i][j];
        if(c2[i][j] != null)
          s = c2[i][j];
        if(c1[i][j] != null && c2[i][j] != null)
          s = combate(c1, c2, i, j);
        board[i][j] = s;
      }
    }
  }

  //Este metodo determinara el ganador en un enfrentamiento de dos soldados
  public static Soldado combate(Soldado[][] c1, Soldado[][] c2, int i, int j){
    if(c2[i][j].getLife() > c1[i][j].getLife()){
      c2[i][j].setLife(c2[i][j].getLife() - c1[i][j].getLife());
      c1[i][j] = null;
      con1--;
      return c2[i][j];
    }else{
      c1[i][j].setLife(c1[i][j].getLife() - c2[i][j].getLife());
      c2[i][j] = null;
      con2--;
      return c1[i][j];
    }

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

  //Este metodo genera una previsualizacion de un objeto Picture
  public static void displayBoard(Picture gCampo){
    Graphics g = new Graphics(gCampo);
    g.print();
  }
  
  //Este metodo genera una grafica respecto a un campo que se le pase
  //campo se refiere al array de soldados que queremos graficar
  //gCampo se refiere al objeto Picture sobre el cual queremos graficar campo
  public static void makeGBoard(Soldado[][] campo, Picture gCampo){
    for(int i = 0; i < campo.length; i++){
      Picture fila = null;
      for(int j = 0; j < campo.length; j++){
        Picture c = Picture.casilleroBlanco();
        if(campo[i][j] != null){
          c = Picture.soldier().superponer(c);
          if(campo[i][j].isNegro())
            c = Picture.soldier().invertir().superponer(c);
        }
        if(j == 0){
          fila = c;
          continue;
        }
        fila = fila.alLado(c);
      }
      if(i == 0){
        gCampo = fila;
        continue;
      }
      gCampo = gCampo.encima(fila);
    } 
    displayBoard(gCampo);
  }

  //Metodo que genera un array de soldados
  public static Soldado[] initializeArmy(int n, boolean negro, int cantidad){
    Random rand = new Random();
    int promLife = 0; //Aqui se acumularan las vidas de los soldados, lo usaremos para sacar el promedio global
    Soldado[] army = new Soldado[cantidad];

    //Se utiliza un bucle for para crear soldados respecto a cantidad
    for(int i = 0; i < cantidad; i++){
      //Los nombres de los soldados estaran en la forma 1x0... 1x1, 1x2... etc
      army[i] = new Soldado("Soldado " + n + "x" + i);
      army[i].setNegro(negro); //Se agrega el atributo negro al soldado, si es true, sera negro, si es false, sera blanco
      army[i].setLife(rand.nextInt(5) + 1); //Se agrega una vida al azar a cada soldado
      //A continuacion se acumula la vida en la variable promLife
      promLife += army[i].getLife();
      
      //Se llama a otro metodo que se encargara de colocar al soldado en un casillero
      //El campo al que se asigna el soldado dependera de n
      if(n == 1)
        genColumnRow(army[i], campo1);
      else
        genColumnRow(army[i], campo2);
    }
    //Para hallar el promedio global, se hace un promedio local y se actualiza el valor del atributo global
    promLife = promLife / army.length;
    promedio = (promLife + promedio) / 2;
    //finalmente se devuelve el ejercito creado
    return army;
  }

  //Este metodo posiciona a los miembros de un ejercito en su respectivo tablero
  public static void genColumnRow(Soldado s, Soldado[][] campo){
    //Se inicializan las variables para su ubicacion
    Random rand = new Random();
    int column;
    int row;
    //Se encierra el codigo en un do while, ya que necesitamos probar ubicaciones hasta hallar una en la que no hayan soldados existentes
    do {
      column = rand.nextInt(campo.length);
      row = rand.nextInt(campo.length);
    } while(!isEmpty(column, row, campo)); //La condicion de parada llama al metodo isEmpty, que verifica si esa posicion esta vacia

    //Finalmente, al asegurarnos de encontrar espacio vacio para el soldado 
    //Lo colocamos ahi y cambiamos sus atributos internos
    s.setColumn(column);
    s.setRow(row);
    campo[row][column] = s;
  }

  //Este metodo analiza si una posicion en un campo esta vacia
  public static boolean isEmpty(int column, int row, Soldado[][] campo){
    return campo[row][column] == null;
  }

  //Este metodo determina cual de los dos ejercitos es el ganador
  public static String whoWins(Soldado[][] army1, Soldado[][] army2){
    if (con1 > con2)
      return "\n***** Army 1 is the winner! *****";

    if (con2 > con1)
      return "\n***** Army 2 is the winner! *****";

    return "\n***** It's a tie. No clear winner. *****";
  }

  //Este metodo cuenta los soldados en cada campo de batalla
  public static int sobrevivientes(Soldado[][] campo){
    int count = 0;
    for(Soldado[] fila : campo){
      for(Soldado s : fila){
        if(s != null)
          count++;
      }
    }
    return count;
  }
  
}
