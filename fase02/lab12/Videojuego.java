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

}
