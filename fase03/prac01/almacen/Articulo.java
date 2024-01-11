package prac01.almacen;

public class Articulo extends Documento {
  public Articulo (String titulo) {
    this.titulo = titulo;
  }
  public static void main(String args []) {
    Articulo a = new Articulo("Investigación");
    System.out.println("Es un:" + a);
  }
}
