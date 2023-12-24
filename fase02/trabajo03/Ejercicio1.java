// Clase que representa un punto en un plano cartesiano
class Punto {
  private double x;
  private double y;

  // Constructor que inicializa las coordenadas (x, y) del punto
  public Punto(double x, double y) {
    this.x = x;
    this.y = y;
  }

  // Método para calcular la distancia entre este punto y otro punto dado
  public double distancia(Punto otroPunto) {
    // Fórmula de distancia entre dos puntos en un plano cartesiano
    return Math.sqrt(Math.pow(otroPunto.x - this.x, 2) + Math.pow(otroPunto.y - this.y, 2));
  }

  // Métodos para obtener las coordenadas x e y del punto
  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  // Métodos para establecer las coordenadas x e y del punto
  public void setY(double y) {
    this.y = y;
  }

  public void setX(double x) {
    this.x = x;
  }
}

// Clase que representa un círculo, hereda de la clase Punto
class Circulo extends Punto {
  private double radio;

  // Constructor que inicializa las coordenadas (x, y) y el radio del círculo
  public Circulo(double x, double y, double radio) {
    super(x, y); // Llamada al constructor de la clase base Punto
    this.radio = radio;
  }

  // Método para obtener el radio del círculo
  public double getRadio() {
    return this.radio;
  }

  // Método para establecer el radio del círculo
  public void setRadio(double radio) {
    this.radio = radio;
  }
}
