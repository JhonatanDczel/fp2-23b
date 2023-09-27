import java.util.*;
public class DemoBatalla {
  static Scanner sc = new Scanner(System.in);
  public static void main(String [] args){
    Nave [] misNaves = new Nave[3];
    String nomb, col;
    int fil, punt;
    boolean est;
    for (int i = 0; i < misNaves.length; i++) {
      System.out.println("Nave " + (i+1));
      System.out.print("Nombre: ");
      nomb = sc.next();
      System.out.print("Fila: ");
      fil = sc.nextInt();
      System.out.print("Columna: ");
      col = sc.next();
      System.out.print("Estado: ");
      est = sc.nextBoolean();
      System.out.print("Puntos: ");
      punt = sc.nextInt();
      misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves
      misNaves[i].setNombre(nomb);
      misNaves[i].setFila(fil);
      misNaves[i].setColumna(col);
      misNaves[i].setEstado(est);
      misNaves[i].setPuntos(punt);
      System.out.println();
    }
    System.out.println("\nNaves creadas:");
    mostrarNaves(misNaves);


    System.out.println("Busqueda lineal, inserte un nombre:");
    int bL = busquedaLinealNombre(misNaves, sc.next());
    mostrarNave(misNaves[bL]);

    System.out.println("Busqueda binaria, inserte un nombre:");
    int bB = busquedaBinariaNombre(misNaves, sc.next());
    mostrarNave(misNaves[bB]);

    System.out.println("Ahora usaremos el algoritmo de ordenamiento burbuja, con respecto a Puntos.\nNaves ordenadas:\n");
    ordenarPorPuntosBurbuja(misNaves);
    mostrarNaves(misNaves);
    desordenar(misNaves);

    System.out.println("\nAhora usaremos el algoritmo de ordenamiento burbuja, con respecto a Nombres.\nNaves ordenadas:\n");
    ordenarPorNombreBurbuja(misNaves);
    mostrarNaves(misNaves);
    desordenar(misNaves);

    System.out.println("\nAhora usaremos el algoritmo de ordenamiento seleccion, con respecto a Puntos.\nNaves ordenadas:\n");
    ordenarPorPuntosSeleccion(misNaves);
    mostrarNaves(misNaves);
    desordenar(misNaves);

    System.out.println("\nAhora usaremos el algoritmo de ordenamiento seleccion, con respecto a Nombres.\nNaves ordenadas:\n");
    ordenarPorNombreSeleccion(misNaves);
    mostrarNaves(misNaves);
    desordenar(misNaves);

    System.out.println("\nAhora usaremos el algoritmo de ordenamiento insercion, con respecto a Puntos.\nNaves ordenadas:\n");
    ordenarPorPuntosInsercion(misNaves);
    mostrarNaves(misNaves);
    desordenar(misNaves);

    System.out.println("\nAhora usaremos el algoritmo de ordenamiento seleccion, con respecto a Nombres.\nNaves ordenadas:\n");
    ordenarPorNombreInsercion(misNaves);
    mostrarNaves(misNaves);
    desordenar(misNaves);

  }

//Método para mostrar todas las naves
  public static void mostrarNaves(Nave [] flota){
    System.out.println();
    int i = 1;
    for(Nave n : flota){
      System.out.println("Nave " + i + ":");
      mostrarNave(n);
      System.out.println();
      i++;
    } 
  }
//Método para mostrar todas las naves de un nombre que se pide por teclado
  public static void mostrarPorNombre(Nave [] flota){
    System.out.println("\nMostrar naves por nombre, ingrese un nombre:\n");
    String nombre = sc.next().toLowerCase();
    int i = 1;
    for(Nave n : flota){
      if(n.getNombre().toLowerCase().equals(nombre)){
        System.out.println("Nave " + i + ":");
        mostrarNave(n);
        System.out.println();
        i++;
      }
    }
    if(i == 1){
      System.out.println("No se han encontrado naves con ese nombre");
      System.out.println();
    }

  }
//Método para mostrar todas las naves con un número de puntos inferior o igual
//al número de puntos que se pide por teclado
  public static void mostrarPorPuntos(Nave [] flota){
    System.out.println("\nMostrar naves por puntos, ingrese una cantidad:\n");
    int pts = sc.nextInt();
    int i = 1;
    for(Nave n : flota){
      if(n.getPuntos() <= pts){
        System.out.println("Nave " + i + ":");
        mostrarNave(n);
        System.out.println();
        i++;
      }
    }
    if(i == 1){
      System.out.println("No se han encontrado naves");
      System.out.println();
    }   
  }
//Método que devuelve la Nave con mayor número de Puntos
  public static Nave mostrarMayorPuntos(Nave [] flota){
    Nave mayor = flota[0];
    for(int i = 0; i < flota.length; i++){
      if(flota[i].getPuntos() > mayor.getPuntos())
        mayor = flota[i];
    }
    return mayor;
  }
  public static void mostrarNave(Nave nave){
    System.out.println("Nombre: " + nave.getNombre());
    System.out.println("Estado: " + nave.getEstado());
    System.out.println("Puntos: " + nave.getPuntos());
  }
//Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos previamente ingresados
//pero aleatoriamente desordenados
  public static Nave[] desordenar(Nave[] flota){
    System.out.println("\nDesordenando las naves:\n");
    Random random = new Random();
    Nave[] nuevaFlota = new Nave[flota.length];
    
    for(int i = 0; i < flota.length; i++){
      boolean ubicado = false;
      while(!ubicado){
        int numRandom = random.nextInt(flota.length);
        if(nuevaFlota[numRandom] == null){
          nuevaFlota[numRandom] = flota[i];
          ubicado = true;
          System.out.println("Nave " + i + " ahora ubicada en: " + numRandom);
        }
      }
    }
    return nuevaFlota;
  } 
  public static int busquedaLinealNombre(Nave[] flota, String s){
    for(int i = 0; i < flota.length; i++){
      if(flota[i].getNombre().equals(s))
        return i;
    }
    return -1;
  }

  public static void ordenarPorPuntosBurbuja(Nave[] flota){
    for(int i = 0; i < flota.length - i; i++){
      for(int j = 0; j < flota.length - 1 - i; j++){
        if(flota[j].getPuntos() > flota[j + 1].getPuntos())
          intercambiar(flota, j, j + 1);
      }
    }
  }

  public static void ordenarPorNombreBurbuja(Nave[] flota){
    for(int i = 0; i < flota.length - 1; i++){
      for(int j = 0; j < flota.length - 1 - i; j++){
        if(esMayor(flota[j].getNombre(), flota[j + 1].getNombre()))
          intercambiar(flota, j, j + 1);
      }
    }
  }

  public static void intercambiar(Nave[] flota, int i, int j){
    Nave aux = flota[i];
    flota[i] = flota [j];
    flota[j] = aux;
  }

  public static void ordenarPorNombreSeleccion(Nave[] flota){
    for(int i = 0; i < flota.length - 1; i++){
      int min = i;
      for(int j = i + 1; j < flota.length; j++){
        if(esMayor(flota[min].getNombre(), flota[j].getNombre()))
          min = j;
      }
      intercambiar(flota, i, min);
    }
  }

  public static void ordenarPorPuntosSeleccion(Nave[] flota){
    for(int i = 0; i < flota.length - 1; i++){
      int min = i;
      for(int j = i + 1; j < flota.length; j++){
        if(flota[j].getPuntos() < flota[min].getPuntos())
          min = j;
      }
      intercambiar(flota, i, min);
    }
  }

  public static boolean esMayor(String s1, String s2){
    return s1.compareToIgnoreCase(s2) > 0;
  }

  public static int busquedaBinariaNombre(Nave[] flota, String s){
    ordenarPorNombreSeleccion(flota);
    int min = 0;
    int max = flota.length - 1;
    while(min <= max){
      int medio = (max + min) / 2;
      if(flota[medio].getNombre().equalsIgnoreCase(s))
        return medio;
      if(esMayor(s, flota[medio].getNombre()))
        min = medio + 1;
      else
        max = medio - 1;

    }
    return - 1;
  }

  public static void ordenarPorPuntosInsercion(Nave[] flota){
    for(int i = 1; i < flota.length; i++){
      Nave actual = flota[i];
      int j = i - 1;
      while(j >= 0 && flota[j].getPuntos() > actual.getPuntos()){
        flota[j + 1] = flota[j];
        j--;
      }
      flota[j + 1] = actual;
    }
  }
  
  /*public static void ordenarPorNombreInsercion(Nave[] flota){
    for(int i = 1; i < flota.length; i ++){
      Nave actual = flota[i];
      int j = i - 1;
      while(j > 0 && esMayor(flota[j].getNombre(), actual.getNombre())){
        flota[j + 1] = flota[j];
        j--;
      }
      flota[j + 1] = actual;
    }
  }*/
}
