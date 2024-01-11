package prac01.almacen;

public abstract class Documento {
  protected String id;
  protected String titulo;
  protected String tipo;
  protected String ubicacion; //que sea una letra y un número: A11
  protected String autor;
  protected boolean disponible;
  protected byte ejemplares;

  public String getTitulo() {
    return titulo;
  }
  public Documento (){
  }
  public String toString() {
    return titulo;
  }
}
