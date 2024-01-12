package prac01.almacen;
public class Libro extends Documento {
  public Libro (String id, String titulo, String ubicacion, String autor) {
    super( id,  titulo,  ubicacion,  autor);
    tipo = "libro";
  }
}
