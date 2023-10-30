import java.util.Random;

public class VideoJuego{
  public static void main(String[] args){

  }
  public static Soldado[] generarEjercito(){
    Random rand = new Random();
    int numSoldados = rand.nexInt(10) + 1;
    Soldado[] ejercito = new Soldado[numSoldados];
    for(int i = 0; i < numSoldados; i++){
      ejercito[i] = new Soldado("Soldado " + n + "x" + i, rand.nexInt(5) + 1)
    }
  }
}
