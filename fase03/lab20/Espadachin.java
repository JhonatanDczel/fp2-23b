package lab.lab20;

public class Espadachin extends Soldado {
  private int logitudEspada;

  public Espadachin(int nivelVida, String team, int lEspada) {
    super(nivelVida, team);
    logitudEspada = lEspada;
  }

  public void crearMuro() {
    System.out.println("Se creo un muro de escudos");
  }

  public int getLongitudEspada() {
    return logitudEspada;
  }
}
