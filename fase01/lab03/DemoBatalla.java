import java.util.*;
public class DemoBatalla {
  public static void main(String [] args){
    Nave [] misNaves = new Nave[3];
    Scanner sc = new Scanner(System.in);
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
    System.out.println("Desordenando las naves:");
    desordenar(misNaves);
    System.out.println("Mostrar naves por nombre, ingrese un nombre:");
    mostrarPorNombre(misNaves, sc.next());
    System.out.println("Mostrar naves por puntos, ingrese una cantidad:");
    mostrarPorPuntos(misNaves, sc.nextInt());
    System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
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
  public static void mostrarPorNombre(Nave [] flota, String nombre){
    nombre = nombre.toLowerCase();
    System.out.println();
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
  public static void mostrarPorPuntos(Nave [] flota, int pts){
    System.out.println();
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
}
