import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.SwingUtilities;


public class Videojuego {
  public static void main(String[] args) {
    // Metodo principal de la clase
  }

  public static ArrayList<Ejercito> crearReino(Mapa mapa, String n, String reinoN){
    Random random=new Random();
    ArrayList<Ejercito> reino=new ArrayList<>();
    int fila, columna;
    for(int i=0; i<1; i++ ){
      do{
        fila=random.nextInt(10);
        columna=random.nextInt(10);
      }while(mapa.tablero()[fila][columna]!= null);
      reino.add(i, new Ejercito(n));
      reino.get(i).setFilaEjercito(fila);
      reino.get(i).setColumnaEjercito(columna);
      reino.get(i).setNombreEjercito(n+i);  
      reino.get(i).setReino(reinoN);
      reino.get(i).unidadesEspeciales(n);
      mapa.agregarEjercito(fila, columna, reino.get(i), reino.get(i).vidaTotalEjercito());
    }
    return reino;
  }

  public static void preTablero(Ejercito ejercito, Soldado[][] tablero){
    Random random=new Random();
    int fila, columna;
    for(Soldado s: ejercito.iterar()){
      do{
        fila=random.nextInt(10);
        columna=random.nextInt(10);
      }while(tablero[fila][columna]!= null);
      s.setFila(fila);
      s.setColumna(columna);
      tablero[fila][columna]=s;
    }
  }

  public static void eliminarSoldado(Soldado eliminar, ArrayList<Soldado> soldados) {
    Iterator<Soldado> iterator = soldados.iterator();
    while (iterator.hasNext()) {
        Soldado entry = iterator.next();
        if (entry.getNombre().equals(eliminar.getNombre())) {
            iterator.remove();
            break;
        }
    }
  }
  public static double promedioVida(Ejercito ejercito){
    double promedio=0;
    for(Soldado soldado: ejercito.iterar())
      promedio+=soldado.getNivelVida();
    return promedio/(double)ejercito.getTotalSoldados();
  }
  private static void determinarGanador(Ejercito ejercito1, Ejercito ejercito2, String reinoJugador1, String reinoJugador2) {
    Random random=new Random();
    System.out.println("\n---Metrica: Ejercito con mas soldados---");
    double vida1=ejercito1.vidaTotalEjercito();
    double vida2=ejercito2.vidaTotalEjercito();
    System.out.printf("Ejercito 1: %-10s: %d   %.2f%% de probabilidad de victoria\n", reinoJugador1, ejercito1.vidaTotalEjercito(), (100/(vida1+vida2)*vida1));
    System.out.printf("Ejercito 2: %-10s: %d   %.2f%% de probabilidad de victoria\n", reinoJugador2, ejercito2.vidaTotalEjercito(), (100/(vida1+vida2)*vida2));
    double numGanador=random.nextDouble(100)+1;
    String ganador="";
    if(numGanador<=(100/(vida1+vida2)*vida1)){
      ganador="Ejercito 1 de: "+reinoJugador1;      
    }else if(numGanador>(100/(vida1+vida2)*vida2)){
      ganador="Ejercito 2 de: "+reinoJugador2;
    }
    System.out.printf("\nEl ganador es el %s. Ya que al generar los\nporcentajes de probabilidad de victoria basada en los niveles de\nvida de sus soldados y aplicando un experimento aleatorio salió\nvencedor. (Aleatorio generado: %.2f%%)\n", ganador, numGanador);
  }
}

