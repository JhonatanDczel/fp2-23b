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
}
