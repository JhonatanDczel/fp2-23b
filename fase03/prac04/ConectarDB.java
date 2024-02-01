import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarDB {
  public static database;
  private Connection;
  private Statement;
  private ResultSet
  
  private ConectarDB () {
    if (database == null)
      database = new ConectarDB();
    return database;
  }

  private synchronized void register() {

  }
  //métodos
  //modificar cupos

  public static void main(String[] args) {
    Connection connection = null;
    try {
      // Cargar el driver JDBC
      Class.forName("org.mariadb.jdbc.Driver");

      // Establecer la conexión
      String url = "jdbc:mariadb://localhost:3306/fp2_23b";
      String usuario = "fp2_23b";
      String contraseña = "12345678";
      connection = DriverManager.getConnection(url, usuario, contraseña);

      System.out.println("¡Conexión exitosa!");

      // Aquí puedes realizar operaciones con la base de datos

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // Cerrar la conexión
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
