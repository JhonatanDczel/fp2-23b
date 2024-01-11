package prac01.almacen;

import java.lang.reflect.Field;

public abstract class Documento {
  protected String id;
  protected String titulo;
  protected String tipo; //no tiene setter
  protected String ubicacion; //que sea una letra y un número: A11
  protected String autor;
  protected boolean disponible;

  //getters
  public String getTitulo() {
    return titulo;
  }
  //Cosntructor
  public Documento (String id, String titulo, String ubicacion, String autor){
    this.id = id;    
    this.titulo = titulo;
    //this.tipo = ; //no tiene setter
    this.ubicacion = ubicacion; //que sea una letra y un número: A11
    this.autor = autor;
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
  public String toString() {
    return titulo;
  }
}
