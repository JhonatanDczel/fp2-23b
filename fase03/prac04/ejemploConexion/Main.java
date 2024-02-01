import java.sql.*;
public class Main {
  public static void main(String args[]) {
    try {
      // Corrección del nombre del controlador 
      Class.forName("com.mysql.cj.jdbc.Driver");

      // Conexión con la base de datos
      String url = "jdbc:mysql://localhost:3306/fp2_23b";
      String user = "fp2_23b";
      String password = "12345678";
      Connection miConexion = SingleDriver.getDriver(url, user, password);

      if (miConexion != null) {
        // Operaciones con la conexión exitosa

        // Declaración y ejecución de la consulta SQL
        String consultas = "SELECT first_name, last_name FROM owners";
        Statement statement = miConexion.createStatement();
        ResultSet resultados = statement.executeQuery(consultas);
        
        // Procesamiento de los resultados
        while (resultados.next()) {
          String firstName = resultados.getString("first_name");
          String lastName = resultados.getString("last_name");
          System.out.println("First Name: " + firstName + ", Last Name: " + lastName);
        }
      } else {
        // Manejo del caso de conexión fallida
        System.out.println("La conexión no se pudo establecer");
      }

    // Manejo de las excepciones
    } catch (SQLException e) {
      System.err.println("\u001B[31mError: \n\u001B[0m" + e);
    } catch (ClassNotFoundException e) {
      System.err.println("\u001B[31mError: \n\u001B[0m" + e);
    }
  }
}
