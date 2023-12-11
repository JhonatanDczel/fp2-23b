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
  public Soldado(int v, String t) {
    team = t;
    velocidad = v;
    vive = true;
    actitud = "ataque";
  }
  public Soldado(int v, int nV, String t) {
    team = t;
    vive = true;
    velocidad = v;
    nivelVida = nV;
    actitud = "ataque";
  }
  public void atacar() {
    actitud = "ofensiva";
  }
  public void defender() {
    actitud = "defensiva";
  }
  public void huir() {
    actitud = "fuga";
    velocidad += 2;
  }
}
