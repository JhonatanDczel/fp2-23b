package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

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

  public ConnectionDB() {
    // Estoy repitiendo usar try catch ya que aqui recien inicializamos statemente
    // Podria inicializarlo en getConnection pero para mejor legibilidad lo hago aqui
    try {
      connection = getConnection();
      statement = connection.createStatement();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static synchronized ConnectionDB getInstance() {
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
    new ConnectionDB();
  }
}