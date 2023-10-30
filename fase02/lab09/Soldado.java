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
  
  public void defender(){
    this.velocidad = 0;
  }

  public void huir(){
    this.velocidad += 2;
  }

  public void retroceder(){
    if(this.velocidad > 0){
      this.velocidad = 0;
      this.actitud = "defensiva";
    }
  }

  public void avanzar(){
    this.velocidad++;
  }
}
