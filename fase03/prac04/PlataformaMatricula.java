public class PlataformaMatricula {
  public static ConectarDB datos;
  public void mostrarDatos() {
    //ConectarDB
    /**
     * mostrar :
     * Respetar nombre de campos: id, cantidadCupos
     * nombre de tabla: cursosSemestre
     *
     * 1 fundamentos de la progración - hora - turno - cupos
     * 2 programación web - hora - turno - cupos
     */
  }

  public void seleccionarCurso() {

  }

  public void cerrarSesion() {

  }

  public static void main(String args []) {
    ConnectionDB baseDeDatos = ConnectionDB.getInstance();
    //muestro los datos
    ResultSet baseDeDatos.makeQuery("La consulta que desees");
    //selecciono uno o mas cursos
    Scanner sc = new Scanner(System.in);
    int result = sc.nextInt();
    while (result != 0 ) { //ya verificar ya forma de salid de este modo
      //Puede ayudar el méotod isValidSelection()
      //ser recomienda dejar toda esta parte como synchronized
      result = sc.nextInt();
      baseDeDatos.selectCourse(result);
    }
    //se modifica la base de datos
    datos.register();
    //se matricula
  }
}
