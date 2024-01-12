package prac01.almacen;

public class Articulo extends Documento {
  public Articulo (String id, String titulo, String ubicacion, String autor, String idLector) {
    super( id,  titulo,  ubicacion,  autor, idLector);
    tipo = "artículo";
  }
  public static void main(String args []) {
    Articulo a = new Articulo("1", "Hola Mundo", "A1", "Jorge" );
    Documento.imprimirAtributos(a);
  }
}
