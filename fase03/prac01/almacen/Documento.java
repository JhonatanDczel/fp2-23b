package prac01.almacen;
abstract class Documento {
  protected String id;
  protected String tipo;
  protected String ubicacion; //que sea una letra y un número: A11
  protected String autor;
  protected boolean disponible;
  protected byte ejemplares;

  public Documento (){
  }
}
