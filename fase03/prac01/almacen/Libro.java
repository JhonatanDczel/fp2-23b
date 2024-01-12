package prac01.almacen;
public class Libro extends Documento {
  public Libro (String id, String titulo, String ubicacion, String autor, String idLector) {
    super( id,  titulo,  ubicacion,  autor, idLector);
    tipo = "libro";
  }
}
