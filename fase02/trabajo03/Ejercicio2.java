// Clase que representa un cilindro, hereda de la clase Circulo
class Cilindro extends Circulo{
  protected double longitud;

  // Constructor que inicializa las coordenadas (x, y), el radio y la longitud del cilindro
  public Cilindro(double x, double y, double radio, double longitud) {
    super(x, y, radio);
    this.longitud = longitud;
  }

  // Método para calcular la superficie del cilindro
  public double superficie(){
    return 2 * this.radio * (this.longitud + this.radio);
  }

  // Método para establecer la longitud del cilindro
  public void setLongitud(double longitud){
    this.longitud = longitud;
  }

  // Método para obtener la longitud del cilindro
  public double getLongitud(){
    return this.longitud;
  }
}

// Clase que representa un punto en un plano cartesiano
class Punto{
  protected double x;
  protected double y;

  // Constructor que inicializa las coordenadas (x, y) del punto
  public Punto(double x, double y){
    this.x = x;
    this.y = y; 
  }

  // Método para calcular la distancia entre este punto y otro punto dado
  public double distancia(Punto otroPunto){
    return Math.sqrt(Math.pow(otroPunto.x - this.x, 2) + Math.pow(otroPunto.y - this.y, 2));
  }

  // Métodos para obtener las coordenadas x e y del punto
  public double getX(){
    return this.x;
  }

  public double getY(){
    return this.y;
  }

  // Métodos para establecer las coordenadas x e y del punto
  public void setY(double y){
    this.y = y;
  }

  public void setX(double x){
    this.x = x;
  }
}

// Clase que representa un círculo, hereda de la clase Punto
class Circulo extends Punto{
  protected double radio;

  // Constructor que inicializa las coordenadas (x, y) y el radio del círculo
  public Circulo(double x, double y, double radio){
    super(x, y);
    this.radio = radio;
  }

  // Método para obtener el radio del círculo
  public double getRadio(){
    return this.radio;
  }

  // Método para establecer el radio del círculo
  public void setRadio(double radio){
    this.radio = radio;
  }
}
