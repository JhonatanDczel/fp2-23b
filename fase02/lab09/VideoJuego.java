import java.util.Random;

public class VideoJuego{
  public static void main(String[] args){
    Tablero t = new Tablero(10);
    t.print();
  }

  public static Soldado[] generarEjercito(String equipo){
    Random rand = new Random();
    int numSoldados = rand.nextInt(10) + 1;
    Soldado[] ejercito = new Soldado[numSoldados];
    for(int i = 0; i < numSoldados; i++){
      ejercito[i] = new Soldado("S" + equipo + "x" + i, rand.nextInt(5) + 1);
      ejercito[i].setEquipo(equipo);
    }
    return ejercito;
  }
}
