public class Soldado {
  private String nombre;
  private int nivelAtaque;
  private int nivelDefensa;
  private int nivelVida;
  private int nivelActual;
  private int vidaActual;
  private int velocidad;
  private String actitud;
  private boolean vive = true;
  private int columna;
  private int fila;

  public Soldado(String name, int life){
    this.nombre = name;
    this.vidaActual = life;
  }
  public Soldado(String name, int life, boolean isLive){
    this.nombre = name;
    this.vidaActual = life;
    this.vive = isLive;
  }
  public Soldado(int life, int nivel){
    this.vidaActual = life;
    this.nivelActual = nivel;
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
    if(this.velocidad <= 0){
      this.velocidad--;
    }
  }

  public void avanzar(){
    this.velocidad++;
  }

  public void serAtacado(){
    this.vidaActual--;
    if(this.vidaActual == 0){
      morir();
    }
  }

  public void morir(){
    this.vive = false;
  }

  // Setters
  public void setVidaActual(int vida){
    this.vidaActual = vida;
  }

  // Getters
  public int getVidaActual(){
    return this.vidaActual;
  }
}
