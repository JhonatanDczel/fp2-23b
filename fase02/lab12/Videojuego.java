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
  }
}
