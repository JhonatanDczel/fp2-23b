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

  public static void realizarAccion(Soldado[][] tablero, Soldado soldado, ArrayList<Soldado> ejercito, ArrayList<Soldado> ejercitoE, Scanner sc){
    Random random=new Random();
    int fila=tablero.length;
    int columna=tablero[0].length;

    System.out.print("Escriba coordenadas(fila, columna): ");
    int fila0=sc.nextInt();
    int columna0=sc.nextInt();
    if(fila0>=0 && fila0<fila && columna0>=0 && columna0<columna){
      if(tablero[fila0][columna0]!=null){
        System.out.println("*Enemigo encontrado*");
        Soldado soldadoE=tablero[fila0][columna0];

        if(soldado instanceof Caballero || soldado instanceof CaballeroFranco || soldado instanceof CaballeroMoro){
          if(soldadoE instanceof Arquero){
            if(soldado instanceof CaballeroFranco || soldado instanceof CaballeroMoro){ 
              soldado.actualizarVida(2);
            }else{soldado.actualizarDefensa(1);}}
          if(soldadoE instanceof Lancero){
            soldadoE.actualizarVida(1);}
          if(soldadoE instanceof Espadachin){
            soldado.actualizarVida(1);}
          if(soldadoE instanceof CaballeroFranco || soldadoE instanceof CaballeroMoro){
            soldadoE.actualizarVida(1);}
        }
        if(soldado instanceof Espadachin || soldado instanceof EspadachinConquistador || soldado instanceof EspadachinReal){
          if(soldadoE instanceof Lancero){
            if(soldado instanceof EspadachinConquistador || soldado instanceof EspadachinReal){
              soldado.actualizarVida(2);}
            else{soldado.actualizarVida(1);}}
          if(soldadoE instanceof EspadachinConquistador || soldadoE instanceof EspadachinReal){
            soldadoE.actualizarVida(1);}
        }
        if(soldado instanceof Arquero){
          if(soldadoE instanceof Lancero){
            soldado.actualizarVida(1);}
        }    

        double vida1=soldado.getvidaActual();
        double vida2=soldadoE.getvidaActual();
        System.out.println("Vida total de: "+soldado.getNombre()+"("+(int)vida1+")");
        System.out.println("Vida total de: "+soldadoE.getNombre()+"("+(int)vida2+")");
        int numGanador=(int)random.nextDouble(vida1+vida2)+1;
        System.out.printf("Probabilidades de vencer: \n%s: %.2f%% | %s: %.2f%%\n", soldado.getNombre(),
          (100/(vida1+vida2)*vida1), soldadoE.getNombre(), (100/(vida1+vida2)*vida2));

        if(numGanador<=vida1){
          System.out.println("*Enemigo derrotado*");
          tablero[fila0][columna0]=soldado;
          tablero[soldado.getFila()][soldado.getColumna()]=null;
          soldado.setFila(fila0);
          soldado.setColumna(columna0);
          soldado.actualizarVida(1);
          eliminarSoldado(soldadoE, ejercitoE);
          
        }else if(numGanador>vida1){
          System.out.println("*Aliado derrotado*");
          tablero[soldado.getFila()][soldado.getColumna()]=null;
          soldadoE.actualizarVida(1);
          eliminarSoldado(soldado, ejercito);
          
        }
      }else
        System.out.println("No se encontro enemigos\n");
    }else
      System.out.println("Coordenadas fuera del limite!!!");
  }
}

