package prac01.almacen;

import java.lang.reflect.Field;

public abstract class Documento {
  public String id;
  public String titulo;
  public String tipo; //no tiene setter
  public String autor;
  public String ubicacion; //que sea una letra y un número: A11
  public boolean disponible;
  public String idLector;

  //getters
  public String getTitulo() {
    return titulo;
  }

  //Cosntructor
  public Documento (String id, String titulo, String autor, String ubicacion, String idLector){
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
