package prac01.almacen;

import java.lang.reflect.Field;

public abstract class Documento {
  protected String id;
  protected String titulo;
  protected String tipo; //no tiene setter
  protected String autor;
  protected String ubicacion; //que sea una letra y un número: A11
  protected boolean disponible;
  protected String idLector;

  //getters
  public String getTitulo() {
    return titulo;
  }
  //Cosntructor
  public Documento (String id, String titulo, String ubicacion, String autor, String idLector){
    this.id = id;    
    this.titulo = titulo;
    //this.tipo = ; //no tiene setter
    this.ubicacion = ubicacion; //que sea una letra y un número: A11
    this.autor = autor;
    this.idLector = idLector;
    disponible = true;

  }
  public static void imprimirAtributos(Object objeto) {
    Class<?> clase = objeto.getClass();

    while (clase != null) {
      Field[] campos = clase.getDeclaredFields();

      for (Field campo : campos) {
        campo.setAccessible(true);

        try {
          Object valor = campo.get(objeto);
          System.out.println(campo.getName() + ": " + valor);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }

      clase = clase.getSuperclass(); // Moverse a la clase base
    }
  }
  public String datosFormatoCSV() {
    return (id +","+
      titulo +","
      + tipo + ","
      + autor + ","
      + ubicacion + ","
      + disponible + ","
      + idLector);
  }
  public String toString() {
    return titulo;
  }
}
