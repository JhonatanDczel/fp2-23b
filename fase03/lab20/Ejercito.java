package lab.lab20;
import java.util.*;

public class Ejercito {
  private ArrayList<Espadachin> misEspadachines = new ArrayList<Espadachin>();
  private ArrayList<Caballero> misCaballero = new ArrayList<Caballero>();
  private ArrayList<Arquero> misArqueros = new ArrayList<Arquero>();
  private ArrayList<Lancero> misLanceros = new ArrayList<Lancero>();

  String team;

  private int columna;
  private int fila;
  private String nombre;
  private String reino;

  public void setFila(int f) { fila = f; }

  public void setColumna(int c) { columna = c; }
  
  public void setNombre(String n) { nombre = n; }

  public void setReino(String p) { reino = p; }
  
  public int getColumna() { return columna; }
  public int getFila() { return fila; }
  public String getNombre() { return nombre; }
  public String getTeam() { return team; }
  public String getReino() { return reino; }

  public ArrayList<Arquero> getMisArqueros() { return misArqueros; }
  public ArrayList<Caballero> getMisCaballeros() { return misCaballero; }
  public ArrayList<Espadachin> getMisEspadachines() { return misEspadachines; }
  public ArrayList<Lancero> getMisLanceros() { return misLanceros; }


  public Ejercito(String equipo) {
    this(equipo, null);
  }

  public Ejercito(String equipo, String reino) {
    addSoldados(equipo);
    team = equipo;
    this.reino = reino;
  }

  public Ejercito(String equipo, String reino, int nums) {
    for(int i = 0; i < nums; i += 1) addSoldados(equipo);
    team = equipo;
    this.reino = reino;
  }

  public void addSoldados(String equipo) {
    int numSoldados = random(9) + 1;
    int[] soldados = new int[numSoldados];
    for(int j = 0; j < soldados.length; j += 1) {
      soldados[j] = random(4);
    }
    int numEspadachines = 0;
    int numCaballeros = 0;
    int numArqueros = 0;
    int numLaceros = 0;
    for(int j = 0; j < soldados.length; j += 1) {
      int points = random(5) + 1;
      String name;
      if(soldados[j] == 0) {
        name = "EspadachinX" + numEspadachines;
        Espadachin espadachin = new Espadachin(points, equipo, random(3));
        espadachin.setNombre(name);
        misEspadachines.add(espadachin);
        numEspadachines += 1;
      } else if (soldados[j] == 1) {
        name = "CaballeroX" + numCaballeros;
        Caballero caballero = new Caballero(points, equipo);
        caballero.setNombre(name);
        misCaballero.add(caballero);
        numCaballeros += 1;
      } else if (soldados[j] == 2) {
        name = "LanceroX" + numLaceros;
        Lancero lancero = new Lancero(points, equipo, random(5));
        lancero.setNombre(name);
        misLanceros.add(lancero);
        numLaceros += 1;
      } else {
        name = "ArqueroX" + numArqueros;
        Arquero arquero = new Arquero(points, equipo);
        arquero.setNombre(name);
        misArqueros.add(arquero);
        numArqueros += 1;
      }
    }
  }
  public static int random(int n) {
    return (int) (Math.random() * n);
  }

  public String toString() {
    String str = "Los soldados del ejercito de "+ reino +" son: \n";
    str += "Los arqueros: \n";
    for(Arquero s : misArqueros) {
      str += s + "\n";
    }
    str += "Los espadachines: \n";
    for(Espadachin s : misEspadachines) {
      str += s + "\n";
    }
    str += "Los caballeros: \n";
    for(Caballero s : misCaballero) {
      str += s + "\n";
    }
    return str;
  }
}