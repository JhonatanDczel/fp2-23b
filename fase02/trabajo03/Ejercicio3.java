// Interfaz para la funcionalidad de barco
interface Barco{
  void navegar();
}

// Interfaz para la funcionalidad de avion
interface Avion{
  void volar();
}

Clase base para hidroavion que implementa ambas interfaces
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

// CLase de prueba
public class Ejercicio3 {
  public static void main(String[] args) {
    // Crear una instancia de hidroavion
    Hidroavion Hidroavion = new Hidroavion();

    // Llamar a los metodos de las interfaces
    hidroavion.navegar();
    hidroavion.volar();
  }
}
