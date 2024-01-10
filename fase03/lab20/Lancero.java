package lab.lab20;

public class Lancero extends Soldado {
  private int logitudLanza;

  public Lancero(int nivelVida, String team, int lEspada) {
    super(nivelVida, team);
    logitudLanza = lEspada;
  }

  public void schiltrom() {
    System.out.println("Se creo un muro de escudos");
  }

  public int getLongitudLanza() {
    return logitudLanza;
  }
}
