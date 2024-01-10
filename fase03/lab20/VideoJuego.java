package lab.lab20;

import java.util.*;

public class VideoJuego {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    while (true) {
      String[] reinos = {"Inglaterra", "Francia", "Sacro", "Castilla", "Moros"};
      ArrayList<Ejercito> reino1 = new ArrayList<Ejercito>();
      ArrayList<Ejercito> reino2 = new ArrayList<Ejercito>();
  
  
      int indice1 = random(reinos.length);
      int indice2;
      do {
        indice2 = random(reinos.length);
      } while (indice2 == indice1);
  
      String nombreReino1 = reinos[indice1];
      String nombreReino2 = reinos[indice2];
  
      Mapa table = new Mapa();

      int nEjercitos1 = random(10) + 1;
      for(int i = 0; i < nEjercitos1; i += 1) addEjercito(table, reino1, "*", i, nombreReino1);
  
      int nEjercitos2 = random(10) + 1;
      for(int i = 0; i < nEjercitos2; i += 1) addEjercito(table, reino2, "#", i, nombreReino2);  

      play(table, reino1, reino2);
    }
  }

  public static void play(Mapa table, ArrayList<Ejercito> reino1, ArrayList<Ejercito> reino2) {
    System.out.println("###################################");

    int turno = 1;
    while (true) {
      printTable(table);
      mover(table, reino1, reino2, turno);

      turno = turno == 1 ? 2 : 1;
    } 
  }
  
  public static void addEjercito(Mapa t, ArrayList<Ejercito> r, String equipo, int i, String reino) {
    int x = random(10);
    int y = random(10);
    String name = "Reino " + (i + 1);
    if(!(t.getTable()[x][y] == null)) addEjercito(t, r, equipo, i, reino);
    else {
      Ejercito ejercito = new Ejercito(equipo);
      ejercito.setColumna(x);
      ejercito.setFila(y);
      ejercito.setNombre(name);
      ejercito.setReino(reino);
      t.getTable()[x][y] = ejercito;
      r.add(ejercito);
    }
  }

  public static void printTable(Mapa t) {
    System.out.println("     A      B      C      D      E      F      G      H      I      J      ");
    System.out.println("  -----------------------------------------------------------------------");
    for(int i = 0; i < t.getTable().length; i += 1) {
      System.out.print((i + 1) + " |");
      for(int j = 0; j < t.getTable().length; j += 1) {
        Ejercito ejercito = t.getTable()[i][j];
        if(ejercito == null) System.out.print("      |");
        else {
          int suma = 0;
          for(Arquero s : ejercito.getMisArqueros()) {suma += s.getNivelVida();}
          for(Espadachin s : ejercito.getMisEspadachines()) {suma += s.getNivelVida();}
          for(Caballero s : ejercito.getMisCaballeros()) {suma += s.getNivelVida();}
          for(Lancero s : ejercito.getMisLanceros()) {suma += s.getNivelVida(); }
          System.out.print(" " + ejercito.getTeam() + "/" + suma +  " |");
        }
      }
      System.out.println();
      System.out.println("  -----------------------------------------------------------------------");
    }
  }

  public static int random(int n) {
    return (int) (Math.random() * n);
  }

  public static void mover(Mapa t, ArrayList<Ejercito> e1, ArrayList<Ejercito> e2, int turno) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Toca moverse al equipo " + (turno == 1 ? "*" : "#"));
      System.out.println("Ingrese la posicion de la ficha a mover: ");
      int y = sc.next().toUpperCase().charAt(0) - 65;
      int x = sc.nextInt() - 1;
      Ejercito s = t.getTable()[x][y];

      if (s == null) {
        System.out.println("Jugada no valida");
        continue;
      }

      if (!s.getTeam().equals(turno == 1 ? "*" : "#")) {
        System.out.println("NO ES EL TURNO DEL EQUIPO: " + s.getTeam());
        continue;
      }

      System.out.println(s);

      System.out.println("Ingrese la nueva posicion deseada: ");
      int yF = sc.next().toUpperCase().charAt(0) - 65;
      int xF = sc.nextInt() - 1;
      Ejercito sF = t.getTable()[xF][yF];

      if (x - xF > 1 || x - xF < -1 || y - yF > 1 || y - yF < -1) {
        System.out.println("Superaste el maximo de casillas por movimiento");
        continue;
      }
      if (xF < 0 || xF > 9 || y < 0 || y > 9) {
        System.out.println("Limite del tablero excedido");
        continue;
      }

      if (sF == null) {
        s.setColumna(xF);
        s.setFila(yF);
        t.getTable()[xF][yF] = s;
        t.getTable()[x][y] = null;
        return;
      }
      
      if (sF.getTeam().equals(s.getTeam())) {
        System.out.println("Ya se encuentra un soldado aliado en esa posicion");
        continue;
      }
      
      if (!sF.getTeam().equals(s.getTeam())) {
        System.out.println(sF);
        atacarEjercito(s, sF);
        return;
      }
    }
  }
  
  public static void atacarEjercito(Ejercito e1, Ejercito e2) {
    Soldado[][] mapa = new Soldado[10][10];
    int sum1 = 0;
    int sum2 = 0;

    for(Arquero s : e1.getMisArqueros()) {
      while(true) {
        int x = random(10);
        int y = random(10);
        s.setColumna(x);
        s.setFila(y);
        sum1 += s.getNivelVida();
  
        if(mapa[x][y] == null) {
          mapa[x][y] = s;
          break;
        }
      }
    }
    for(Caballero s : e1.getMisCaballeros()) {
      while(true) {
        int x = random(10);
        int y = random(10);
        s.setColumna(x);
        s.setFila(y);
        sum1 += s.getNivelVida();
  
        if(mapa[x][y] == null) {
          mapa[x][y] = s;
          break;
        }
      }
    }
    for(Espadachin s : e1.getMisEspadachines()) {
      while(true) {
        int x = random(10);
        int y = random(10);
        s.setColumna(x);
        s.setFila(y);
        sum1 += s.getNivelVida();
  
        if(mapa[x][y] == null) {
          mapa[x][y] = s;
          break;
        }
      }
    }
    for(Lancero s : e1.getMisLanceros()) {
      while(true) {
        int x = random(10);
        int y = random(10);
        s.setColumna(x);
        s.setFila(y);
        sum1 += s.getNivelVida();
  
        if(mapa[x][y] == null) {
          mapa[x][y] = s;
          break;
        }
      }
    }
    for(Arquero s : e2.getMisArqueros()) {
      while(true) {
        int x = random(10);
        int y = random(10);
        s.setColumna(x);
        s.setFila(y);
        sum2 += s.getNivelVida();
  
        if(mapa[x][y] == null) {
          mapa[x][y] = s;
          break;
        }
      }
    }
    for(Caballero s : e2.getMisCaballeros()) {
      while(true) {
        int x = random(10);
        int y = random(10);
        s.setColumna(x);
        s.setFila(y);
        sum2 += s.getNivelVida();
  
        if(mapa[x][y] == null) {
          mapa[x][y] = s;
          break;
        }
      }
    }
    for(Espadachin s : e2.getMisEspadachines()) {
      while(true) {
        int x = random(10);
        int y = random(10);
        s.setColumna(x);
        s.setFila(y);
        sum2 += s.getNivelVida();
  
        if(mapa[x][y] == null) {
          mapa[x][y] = s;
          break;
        }
      }
    }
    for(Lancero s : e2.getMisLanceros()) {
      while(true) {
        int x = random(10);
        int y = random(10);
        s.setColumna(x);
        s.setFila(y);
        sum1 += s.getNivelVida();
  
        if(mapa[x][y] == null) {
          mapa[x][y] = s;
          break;
        }
      }
    }
    
    int turno = 1;
    while (true) {
      System.out.println("     A       B       C       D       E       F       G       H       I       J      ");
      System.out.println("  -------------------------------------------------------------------------------");
      for(int i = 0; i < mapa.length; i += 1) {
        System.out.print((i + 1) + " |");
        for(int j = 0; j < mapa.length; j += 1) {
          Soldado soldado = mapa[i][j];
          if(soldado == null) System.out.print("       |");
          else {
            System.out.print(" " + soldado.getTeam() + "/" + soldado.getNombre().charAt(0) + "/" + soldado.getNivelVida() +  " |");
          }
        }
        System.out.println();
        System.out.println("  -------------------------------------------------------------------------------");
      }
      moverSoldados(mapa, e1, e2, turno);
      turno = turno == 1 ? 2 : 1;

      sum1 = 0;
      sum2 = 0;

    }
  }
  
  public static void atacar(Mapa m, Ejercito s1, Ejercito s2) {
    int sum1 = 0;
    for(Arquero s : s1.getMisArqueros()) sum1 += s.getNivelVida();
    for(Caballero s : s1.getMisCaballeros()) sum1 += s.getNivelVida();
    for(Espadachin s : s1.getMisEspadachines()) sum1 += s.getNivelVida();
    for(Lancero s : s1.getMisLanceros()) sum1 += s.getNivelVida();

    int sum2 = 0;
    for(Arquero s : s2.getMisArqueros()) sum2 += s.getNivelVida();
    for(Caballero s : s2.getMisCaballeros()) sum2 += s.getNivelVida();
    for(Espadachin s : s2.getMisEspadachines()) sum2 += s.getNivelVida();
    for(Lancero s : s2.getMisLanceros()) sum1 += s.getNivelVida();

    System.out.println("Tu ejercito tiene " + (int)((100.0/(sum1 + sum2))*sum1)
    + "% de posibilidades de vencer, y el enemigo " + (int)((100.0/(sum1 + sum2))*sum2)
    + "% de posibilidades de vencerte" );

    if(sum1 > Math.random() * (sum1 + sum2)) {
      System.out.println("Derrotaste al ejercito enemigo");
      m.getTable()[s1.getColumna()][s1.getFila()] = null;
      s1.setColumna(s2.getColumna());
      s1.setFila(s2.getFila());
      m.getTable()[s1.getColumna()][s1.getFila()] = s1;
    } else {
      System.out.println("Te derroto el ejercito enemigo");
      m.getTable()[s1.getColumna()][s1.getFila()] = null;
    }
  }
  public static void moverSoldados(Soldado[][] mapa, Ejercito e1, Ejercito e2, int turno) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Toca moverse al equipo " + (turno == 1 ? "*" : "#"));
      System.out.println("Ingrese la posicion de la ficha a mover: ");
      int y = sc.next().toUpperCase().charAt(0) - 65;
      int x = sc.nextInt() - 1;
      Soldado s = mapa[x][y];

      if (s == null) {
        System.out.println("Jugada no valida");
        continue;
      }

      if (!s.getTeam().equals(turno == 1 ? "*" : "#")) {
        System.out.println("NO ES EL TURNO DEL EQUIPO: " + s.getTeam());
        continue;
      }

      System.out.println(s);

      System.out.println("Ingrese la nueva posicion deseada: ");
      int yF = sc.next().toUpperCase().charAt(0) - 65;
      int xF = sc.nextInt() - 1;
      Soldado sF = mapa[xF][yF];

      if (x - xF > 1 || x - xF < -1 || y - yF > 1 || y - yF < -1) {
        System.out.println("Superaste el maximo de casillas por movimiento");
        continue;
      }
      if (xF < 0 || xF > 9 || y < 0 || y > 9) {
        System.out.println("Limite del tablero excedido");
        continue;
      }

      if (sF == null) {
        s.setColumna(xF);
        s.setFila(yF);
        mapa[xF][yF] = s;
        mapa[x][y] = null;
        return;
      }
      
      if (sF.getTeam().equals(s.getTeam())) {
        System.out.println("Ya se encuentra un soldado aliado en esa posicion");
        continue;
      }
      
      if (!sF.getTeam().equals(s.getTeam())) {
        System.out.println(sF);
        atacarSoldados(mapa, s, sF);
        return;
      }
    }
  }
  public static void atacarSoldados(Soldado[][] m, Soldado s1, Soldado s2) {
    int sum1 = s1.getNivelVida();
    int sum2 = s1.getNivelVida();

    System.out.println("Tu ejercito tiene " + (int)((100.0/(sum1 + sum2))*sum1)
    + "% de posibilidades de vencer, y el enemigo " + (int)((100.0/(sum1 + sum2))*sum2)
    + "% de posibilidades de vencerte" );

    if(sum1 > Math.random() * (sum1 + sum2)) {
      System.out.println("Derrotaste al soldado enemigo");
      m[s1.getColumna()][s1.getFila()] = null;
      s1.setColumna(s2.getColumna());
      s1.setFila(s2.getFila());
      m[s1.getColumna()][s1.getFila()] = s1;
    } else {
      System.out.println("Te derroto al soldado enemigo");
      m[s1.getColumna()][s1.getFila()] = null;
    }
  }
}