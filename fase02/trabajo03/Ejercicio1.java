class Punto{
  private double x;
  private double y;

  public Punto(double x, double y){
    this.x = x;
    this.y = y; 
  }
  public double getX(){
    return this.x;
  }

  public double getY(){
    return this.y;
  }

  public void setY(double y){
    this.y = y;
  }

  public void setX(double x){
    this.x = x;
  }
}

class Circulo extends Punto{
  private double radio;

  public Circulo(double x, double y, double radio){
    super(x, y);
    this.radio = radio;
  }

  public double getRadio(){
    return this.radio;
  }
}
