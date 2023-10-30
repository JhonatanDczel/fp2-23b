public class Soldado {
  private String nombre;
  private int nivelAtaque;
  private int nivelDefensa;
  private int nivelVida;
  private int nivelActual;
  private int velocidad;
  private String actitud;
  private boolean vive;

  public Soldado(){
  }
  public void atacar(){
    this.actitud = "ofensiva";
    atacar();
  }
  public void avanzar(){
    this.velocidad++;
  }
}
