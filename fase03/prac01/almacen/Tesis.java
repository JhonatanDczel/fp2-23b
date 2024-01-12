package prac01.almacen;
public class Tesis extends Documento {
  public Tesis (String id, String titulo, String ubicacion, String autor) {
    super( id,  titulo,  ubicacion,  autor);
    tipo = "tesis";
  }
}
