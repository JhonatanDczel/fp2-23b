public class Soldado {
  private String nombre;
  private int fila;
  private int nivelAtaque = random(5);
  private int nivelDefensa = random(5);
  private int columna;
  private int nivelVida;
  private int vidaActual;
  private int velocidad;
  private String actitud;
  private boolean vive;
  private String team;
  public Soldado(String t) {
    team = t;
    velocidad = 0;
    vive = true;
    actitud = "ataque";

  }
}
