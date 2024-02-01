public class PlataformaMatricula {
  public static ConectarDB datos;
  public void mostrarDatos() {
    //ConectarDB
    /**
     * mostrar :
     * 1 fundamentos de la progración - hora - turno - cupos
     */
  }

  public void seleccionarCurso() {

  }

  public void cerrarSesion() {

  }

  public static void main(String args []) {
    datos = ConectarDB.getConnection();
    //muestro los datos
    datos.showPlaces();
    //selecciono uno o mas cursos
    Scanner sc = new Scanner(System.in);
    int result = sc.nextInt();
    while (result != 0) {
      result = sc.nextInt();
      datos.selectPlace(result);
    }
    //se modifica la base de datos
    datos.register();
    //se matricula
  }
}
