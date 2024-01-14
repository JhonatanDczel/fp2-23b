package prac01.almacen;

public class Articulo extends Documento {
  public Articulo (String id, String titulo, String ubicacion, String autor, String idLector) {
    super( id,  titulo,  ubicacion,  autor, idLector);
    tipo = "artículo";
  }
}
