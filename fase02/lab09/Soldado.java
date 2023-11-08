public class Soldado {
  private String nombre;
  private int nivelAtaque;
  private int nivelDefensa;
  private int nivelActual;
  private int vida;
  private int velocidad;
  private String actitud;
  private boolean vive = true;
  private int columna;
  private int fila;
  private String equipo;

  public Soldado(String name, int life){
    this.nombre = name;
    this.vida = life;
  }
  public Soldado(String name, int life, boolean isLive){
    this.nombre = name;
    this.vida = life;
    this.vive = isLive;
  }
  public Soldado(int life, int nivel){
    this.vida = life;
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
    this.vida--;
    if(this.vida == 0){
      morir();
    }
  }

  public void morir(){
    this.vive = false;
  }

  // Setters
  public void setVidaActual(int vida){
    this.vida = vida;
  }

  public void setColumna(int n){
    this.columna = n;
  }

  public void setFila(int n){
    this.fila = n;
  }
  public void setEquipo(String s){
    this.equipo = s;
  }
  // Getters
  public int getVida(){
    return this.vida;
  }
  
  public int getFila(){
    return this.fila;
  }
  public int getColumna() {
    return this.columna;
  }
  public String getEquipo(){
    return this.equipo;
  }
  public String getNombre(){
    return this.nombre;
  }
}
