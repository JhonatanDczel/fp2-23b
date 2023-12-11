import java.util.*;

public class VideoJuego {
  public static void juegoRapido() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Para salir de la partida ingresa 'S'");
    String salir = sc.next();
    if(salir.toLowerCase().charAt(0) == 's') return;

    Soldado[][] table = new Soldado[10][10];
    ArrayList<Soldado> ejercito1 = new ArrayList<Soldado>();
    ArrayList<Soldado> ejercito2 = new ArrayList<Soldado>();
    fillTable(table, ejercito1, ejercito2);
    printMayorNivel(table, ejercito1, ejercito2);
    System.out.println("___________________________________");
    System.out.println("IMPRIMIR PROMEDIO DE PUNTOS");
    printPromedioPuntos(table, ejercito1, ejercito2);
    System.out.println("___________________________________");
    System.out.println("SOLDADOS ORDENADOS");
    printSoladosOrdenados(table, ejercito1, ejercito2);
    System.out.println("___________________________________");
    System.out.println("RANKING DE PUNTOS EJERCITO1 POR BUBBLE SORT");
    printRankingPointsBubble(table, ejercito1);
    System.out.println("___________________________________");
    System.out.println("RANKING DE PUNTOS EJERCITO2 POR SELECT SORT");
    printRankingPointsSelect(table, ejercito2);


    System.out.println("###################################");
    int turno = 1;
    while (true) {
      printTable(table);
      mover(table, ejercito1, ejercito2, turno);

      turno = turno == 1 ? 2 : 1;

      String winner = getWinner(ejercito1, ejercito2);

      if(winner != null) {
        System.out.println("###########################");
        System.out.println("GANA EL EQUIPO " + winner);
        System.out.println("###########################");
        break;
      }
    }
  }

  public static void juegoPersonalizado() {
    Scanner sc = new Scanner(System.in);
    Soldado[][] table = new Soldado[10][10];
    ArrayList<Soldado> ejercito1 = new ArrayList<Soldado>(); // *
    ArrayList<Soldado> ejercito2 = new ArrayList<Soldado>(); // #
    fillTable(table, ejercito1, ejercito2);

    System.out.println("SOLDADOS ORDENADOS");
    printSoladosOrdenados(table, ejercito1, ejercito2);
    System.out.println("###################################");

    System.out.print("Escoge al equipo a personlizar: ");
    String team = sc.next();
    ArrayList<Soldado> currentE = team.equals("*") ? ejercito1 : ejercito2;

    System.out.println("Escogue una opcion: ");
    System.out.println("1. Crear soldado");
    System.out.println("2. Eliminar soldado");
    System.out.println("3. Clonar soldado");
    System.out.println("4. Modificar soldado");
    System.out.println("5. Comparar soldado");
    System.out.println("6. Intercambiar soldados");
    System.out.println("7. Ver soldado");
    System.out.println("8. Ver ejercito");
    System.out.println("9. Sumar niveles");
    System.out.println("10. Jugar");
    System.out.println("11. Volver");

    int input = sc.nextInt();
    if(input == 1) crearSoldado(table, currentE, team);
    if(input == 2) eliminarSoldado(table, currentE, team);
    if(input == 3) clonarSoldado(table, currentE, team);
    if(input == 4) modificarSoldado(table, currentE, team);
    if(input == 5) compararSoldado(table, currentE, team);
    if(input == 6) intercambiarSoldado(table, currentE, team);
    if(input == 7) verSoldado(table, currentE, team);
    if(input == 8) verEjercito(table, currentE, team);
    if(input == 9) sumarNiveles(table, currentE, team);
    if(input == 10) jugar();
    if(input == 11) volver();
  }
  public static void crearSoldado(Soldado[][] t, ArrayList<Soldado> e, String team) {
    Scanner sc = new Scanner(System.in);
    Soldado s = new Soldado(team);

    if(e.size() >= 10) {
      System.out.println("El ejercito tiene el maximo de soladados: ");
      return;
    }

    System.out.print("Ingresa el nivel del soldado: ");
    s.setNivelVida(sc.nextInt());
    System.out.print("Ingresa el nivel de ataque: ");
    s.setNivelAtaque(sc.nextInt());
    System.out.print("Ingresa el nivel de defensa: ");
    s.setNivelDefensa(sc.nextInt());
    System.out.print("Ingresa la columna: ");
    s.setColumna(sc.nextInt());
    System.out.print("Ingresa la fila: ");
    s.setFila(sc.nextInt());
    s.setNombre("Soldado " + (e.size() + 1));

    e.add(s);
    t[s.getColumna()][s.getFila()] = s;
  }
  public static void eliminarSoldado(Soldado[][] t, ArrayList<Soldado> e, String team) {
    Scanner sc = new Scanner(System.in);

    if(e.size() <= 1) {
      System.out.println("El ejercito nesecita al menos 1 soldado");
      return;
    }

    System.out.print("Ingresa la columna: ");
    int col = sc.nextInt();
    System.out.print("Ingresa la fila: ");
    int fila = sc.nextInt();

    for(int i = 0; i < e.size(); i += 1) {
      if(e.get(i).getColumna() == col && e.get(i).getFila() == fila){
        e.remove(i);
        break;
      }
    }

    t[col][fila] = null;
  }
  public static void clonarSoldado(Soldado[][] t, ArrayList<Soldado> e, String team) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingresa la columna: ");
    int col = sc.nextInt();
    System.out.print("Ingresa la fila: ");
    int fila = sc.nextInt();

    Soldado soldadoOriginal = t[col][fila];

    Soldado soldadoNuevo = new Soldado(soldadoOriginal.getTeam());
    soldadoNuevo.setNivelAtaque(soldadoOriginal.getNivelAtaque());
    soldadoNuevo.setNivelDefensa(soldadoOriginal.getNivelDefensa());
    soldadoNuevo.setNivelVida(soldadoOriginal.getNivelVida());
    soldadoNuevo.setNombre("Soldado " + (e.size() + 1));

    System.out.print("Ingresa la columna nueva: ");
    int newCol = sc.nextInt();
    System.out.print("Ingresa la fila nueva: ");
    int newFila = sc.nextInt();

    e.add(soldadoNuevo);
    t[newCol][newFila] = soldadoNuevo;
  }
  public static void modificarSoldado(Soldado[][] t, ArrayList<Soldado> e, String team) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingresa la columna: ");
    int col = sc.nextInt();
    System.out.print("Ingresa la fila: ");
    int fila = sc.nextInt();

    Soldado s = t[col][fila];
    System.out.println("Ingresa nivel de vida nuevo: ");
    s.setNivelVida(sc.nextInt());
    System.out.println("Ingresa nivel de ataque nuevo: ");
    s.setNivelAtaque(sc.nextInt());
    System.out.println("Ingresa nivel de defensa nuevo: ");
    s.setNivelDefensa(sc.nextInt());
    System.out.println("Ingresa la columna nueva: ");
    s.setColumna(sc.nextInt());
    System.out.println("Ingresa la fila nueva: ");
    s.setFila(sc.nextInt());
  }
   //Estos son metodos por implementar
  public static void compararSoldado(Soldado[][] t, ArrayList<Soldado> e, String team) {

  }
  public static void intercambiarSoldado(Soldado[][] t, ArrayList<Soldado> e, String team) {

  }
  public static void verSoldado(Soldado[][] t, ArrayList<Soldado> e, String team) {

  }
  public static void verEjercito(Soldado[][] t, ArrayList<Soldado> e, String team) {

  }
  public static void sumarNiveles(Soldado[][] t, ArrayList<Soldado> e, String team) {

  }
  public static void jugar() {

  }
  public static void volver() {

  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("1. Juego rapido");
      System.out.println("2. Juego personalizado");
      System.out.println("3. Salir");
      int input = sc.nextInt();
      if(input == 1) juegoRapido();
      if(input == 2) juegoPersonalizado();
      if(input == 3) break;
    }
  }
  public static void fillTable(Soldado[][] t, ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
    int nSoldados1 = random(10) + 1;
    for(int i = 0; i < nSoldados1; i += 1) addSoldado(t, i, e1, "*");

    int nSoldados2 = random(10) + 1;
    for(int i = 0; i < nSoldados2; i += 1) addSoldado(t, i, e2, "#");
  }
  public static void addSoldado(Soldado[][] t, int i, ArrayList<Soldado> e, String team) {
    int points = random(5) + 1;
    int x = random(10);
    int y = random(10);
    String name = "Soldado " + (i + 1);
    if(!(t[x][y] == null)) addSoldado(t, i, e, team);
    else {
      Soldado soldado = new Soldado(team);
      soldado.setColumna(x);
      soldado.setFila(y);
      soldado.setNombre(name);
      soldado.setNivelVida(points);
      t[x][y] = soldado;
      e.add(soldado);
    }
  }
  public static void printTable(Soldado[][] t) {
    System.out.println("     A     B     C     D     E     F     G     H     I     J     ");
    System.out.println("  -------------------------------------------------------------");
    for(int i = 0; i < t.length; i += 1) {
      System.out.print((i + 1) + " |");
      for(int j = 0; j < t.length; j += 1) {
        Soldado soldado = t[i][j];
        if(soldado == null) System.out.print("     |");
        else System.out.print(" " + soldado.getTeam() + "/"+soldado.getNivelVida()+" |");
      }
      System.out.println();
      System.out.println("  -------------------------------------------------------------");
    }
  }
  public static void printArr(Soldado[] arr) {
    for(Soldado n : arr) {
      if(n != null)System.out.println(n + " | ");
    }
  }
  public static int random(int n) {
    return (int) (Math.random() * n);
  }
  public static void printMayorNivel(Soldado[][] t, ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
    int maxPoints1 = 0;
    int maxPoints2 = 0;

    for(int i = 0; i < e1.size(); i += 1) {
      if(e1.get(i).getNivelVida() > maxPoints1) maxPoints1 = e1.get(i).getNivelVida();
    }
    for(int i = 0; i < e2.size(); i += 1) {
      if(e2.get(i).getNivelVida() > maxPoints2) maxPoints2 = e2.get(i).getNivelVida();
    }

    System.out.println("Los soldados con el mayor nivel de puntos de la primera flota son:");
    for(Soldado s : e1) { 
      if(maxPoints1 == s.getNivelVida())
        System.out.println(s);
    }
    System.out.println("Los soldados con el mayor nivel de puntos de la segunda flota son:");
    for(Soldado s : e1) { 
      if(maxPoints2 == s.getNivelVida())
        System.out.println(s);
    }
  }
  public static void printPromedioPuntos(Soldado[][] t, ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
    double sum1 = 0;
    int count1 = 0;
    double sum2 = 0;
    int count2 = 0;

    for(Soldado s : e1){
      sum1 += s.getNivelVida();
      count1 += 1;
    }
    for(Soldado s : e2){
      sum2 += s.getNivelVida();
      count2 += 1;
    }
    System.out.println("El promedio de la primera flota es: " + (sum1/count1));
    System.out.println("El promedio de la segunda flota es: " + (sum2/count2));
  }
  public static void printPuntosAll(Soldado[][] t, ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
    System.out.println("Nivel de vida de cada soldado de la primera flota: ");
    for(Soldado s : e1) { 
      System.out.println("Nivel de vida del " + s.getNombre() + " es: " + s.getNivelVida());
    }
    System.out.println("Nivel de vida de cada soldado de la segunda flota: ");
    for(Soldado s : e2) { 
      System.out.println("Nivel de vida del " + s.getNombre() + " es: " + s.getNivelVida());
    }
  }

  public static void printSoladosOrdenados(Soldado[][] t, ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
    int count1 = 0;
    Soldado[] newArr1 = new Soldado[10];

    for(Soldado s : e1) {
      newArr1[count1] = s;
      count1 += 1;
    }

    for(int i = 0; i < count1 - 1 ; i += 1) {
      for(int j = 0; j < count1 - 1 - i; j += 1) {
        if(newArr1[j].getNombre().charAt(8) > newArr1[j + 1].getNombre().charAt(8)) {
          Soldado s = newArr1[j];
          newArr1[j] = newArr1[j + 1];
          newArr1[j + 1] = s;
        }
      }
    }

    int count2 = 0;
    Soldado[] newArr2 = new Soldado[10];

    for(Soldado s : e2) {
      newArr2[count2] = s;
      count2 += 1;
    }

    for(int i = 0; i < count2 - 1 ; i += 1) {
      for(int j = 0; j < count2 - 1 - i; j += 1) {
        if(newArr2[j].getNombre().charAt(8) > newArr2[j + 1].getNombre().charAt(8)) {
          Soldado s = newArr2[j];
          newArr2[j] = newArr2[j + 1];
          newArr2[j + 1] = s;
        }
      }
    }

    System.out.println("Soldados ordenado de la primera flota");
    printArr(newArr1);
    System.out.println("Soldados ordenado de la segunda flota");
    printArr(newArr2);
  }

}
