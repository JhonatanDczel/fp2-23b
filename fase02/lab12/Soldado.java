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
  public void avanzar() {
    velocidad += 1;
  }

  public void serAtacado() {
    vidaActual -= 1;
    if(vidaActual == 0) morir();
  }
  public void morir() { 
    vive = false;
  }

  public void retroceder() {
    if (velocidad > 0) {
      velocidad = 0;
      actitud = "defensiva";
    } else if (velocidad == 0) {
      velocidad = -1; 
    }
  }
  public String getTeam() { return team; }

  public void setNombre(String n) { nombre = n; }

  public void setFila(int f) { fila = f; }

  public void setColumna(int c) { columna = c; }

  public void setNivelVida(int p) { nivelVida = p; }

  public String getNombre() { return nombre; }

  public int getFila() { return fila; }

  public int getColumna() { return columna; }

  public int getNivelVida() { return nivelVida; }

  public int getNivelAtaque() { return nivelAtaque; }

  public int getNivelDefensa() { return nivelDefensa; }

  public void setNivelAtaque(int n) { nivelAtaque = n; }

  public void setNivelDefensa(int n) { nivelDefensa = n; }

  public boolean isLive() { return vive; }
}

