package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.*;

public class ConnectionDB {
  // Campos que se usan en la conexion, ojito que de esta forma solo es necesario modificar
  // el archivo .properties si deseamos hacer un cambio de base de datos
  private static final String DB_PROPERTIES = "confidential/database.properties";
  private static final String DB_NAME_PROP = "dbname";
  private static final String DB_HOST_PROP = "host";
  private static final String DB_PASSWORD_PROP = "password";
  private static final String DB_PORT_PROP = "port";
  private static final String DB_USER_PROP = "user";

  // Campos que serviran para hacer las consultas, ESTO ES LO QUE USARAN
  // LOS METODOS WHRITE
  private static ConnectionDB instance;
  private Connection connection;
  private Statement statement;
  private ResultSet resultQuery;

  //atributo que contiene los cursos y cupos disponibles
  private HashMap <Integer, Integer> placesAvailable;
  //lista de cursos seleccionados
  private ArrayList<Integer> listSelectedCourses = new ArrayList<Integer>();

  private ConnectionDB() {
    // Estoy repitiendo usar try catch ya que aqui recien inicializamos statemente
    // Podria inicializarlo en getConnection pero para mejor legibilidad lo hago aqui
    try {
      connection = getConnection();
      statement = connection.createStatement();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public HashMap <Integer, Integer> getPlacesAvailable() {
    return placesAvailable;
  }

  // Metodo para realizar la consulta
  public ResultSet makeQuery (String query) {
    try {
      return statement.executeQuery(query);
    } catch (SQLException e) {
      System.err.println("\u001B[31mError from sql: \n\u001B[0m" + e);
    }
    return null;
  }

  //Metodo que guarda los cursos seleccionados
  public void selectCourse (int id) {
    if ( isValidSelection(id) )
      listSelectedCourses.add(id);
  }

  //Método que valida entrada de id
  public boolean isValidSelection (int id) {
    return placesAvailable.get(id) > 0;
  }

  public void refreshPlaces() {
    if ( placesAvailable == null ) {
      placesAvailable = new HashMap <Integer, Integer>();
    }
    placesAvailable.clear();
    String query = "SELECT * FROM cursosSemestre";
    try {
      resultQuery = statement.executeQuery(query);
      while (resultQuery.next()) {
        int id = resultQuery.getInt("id_curso");
        int places = resultQuery.getInt("cupos");
        placesAvailable.put(id, places);
      }
    } catch (SQLException e) {
      System.err.println("\u001B[31mError from sql: \n\u001B[0m" + e);
    }
  }

  //Método que escirbe la base de datos
  public synchronized void executeRegister() {
    if (Thread.holdsLock(this)) {
      String query = "UPDATE cursosSemestre SET cupos = cupos - 1 WHERE id_curso = ";
      try {
        for (int ids : listSelectedCourses) {
          statement.executeUpdate(query + ids);
        }
      } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("\u001B[31mError from register in sql: \n\u001B[0m" + e);
      }
    } else {
      System.out.println("Error, otro método está registrando los cursos");
    }
  }

  public synchronized static ConnectionDB getInstance() {
    if (instance == null) {
      instance = new ConnectionDB();
    }
    return instance;
  }

  private Connection getConnection() {
    try {
      String url = createUrl();
      Connection connection = DriverManager.getConnection(url);
      // Observamos la conexion exitosa
      System.out.println("Connection class ==> " + connection.getClass().getName());
      return connection;
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  
  private String createUrl() {
    Properties prop = PropertiesUtil.loadProperty(DB_PROPERTIES);
    String host = prop.getProperty(DB_HOST_PROP);
    String port = prop.getProperty(DB_PORT_PROP);
    String db = prop.getProperty(DB_NAME_PROP);
    String user = prop.getProperty(DB_USER_PROP);
    String password = prop.getProperty(DB_PASSWORD_PROP);

    String url = "jdbc:mariadb://" + host 
      + ":" + port + "/" + db + "?user=" + user + "&password=" + password;
    // Verificamos la url generada
    System.out.println("ConnectionString ==> " + url);
    return url;
  }

  public static void main(String... args) {
    //siempre actualizar data
    ConnectionDB dabaBase = ConnectionDB.getInstance();
    dabaBase.refreshPlaces();
    //se muestran cursos disponibles (solol disp. en esta clase)
    System.out.println(dabaBase.placesAvailable);
    //Cursos seleccionados:
    int misCursosID [] = { 1, 3, 4 };
    //Se registran los cursos, se puede usar isValidSeleccion para 
    //saber si se eligió bien
    for (int id : misCursosID) 
      dabaBase.selectCourse(id);
    //Se realiza el registro
    //--dabaBase.executeRegister();
    //Ya lo actualizo para que los veas
    dabaBase.refreshPlaces();
    System.out.println(dabaBase.placesAvailable);

    //Dinámica: 
    //Se muestran los cupos xxxxxxx
    //Se selecciona id del curso
    //Se registran
    //
    /*
     * warnings:
     * ver si no se repite los cursos en Plataforma virtual
    */
  }
}
