interface Barco{
  void navegar();
}

interface Avion{
  void volar();
}

class Hidroavion implements Barco, Avion {
  @Override
  public void navegar(){
    System.out.println("Hidroavion navegando en el agua");
  }

  @Override
  public void volar() {
    System.out.println("Hidroavion navegando en el aire");
  }
}

public class Ejercicio3 {
  public static void main(String[] args) {
  }
}
