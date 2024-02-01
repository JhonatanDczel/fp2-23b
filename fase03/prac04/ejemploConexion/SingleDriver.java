import java.sql.*;
public class SingleDriver {
  // Una única instancia de la conexión
  private static Connection driver;

  // Constructor privado para evitar instancias adicionales de la clase
  private SingleDriver() {}

  // Método estático para obtener una conexión a la base de datos
  public static Connection getDriver(String url, String user, String pass) {
    try {
      // Si la conexión no ha sido inicializada, crea una nueva conexión
      if (driver == null)
        driver = DriverManager.getConnection(url, user, pass);
      return driver;
    } catch (SQLException e) {
      // Si ocurre un error al intentar obtener la conexión, maneja la excepción
      System.err.println("\u001B[31mError: \n\u001B[0m" + e);
      // Devuelve null para indicar que ha ocurrido un error en la obtención de la conexión
      return null;
    }
  }
}
