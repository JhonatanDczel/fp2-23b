import java.sql.*;

public class Peticion {
  public Peticion() throws SQLException, ClassNotFoundException{
    String url = "jdbc:mariadb://localhost/fp2_23b"; 
    String user = "fp2_23b"; 
    String password = "12345678";

    Class.forName("org.mariadb.jdbc.Driver");

    Connection connection = DriverManager.getConnection(url, user, password);
    
    Statement statement = connection.createStatement();

    String query = "SELECT * FROM vets";
    ResultSet resultSet = statement.executeQuery(query);

    while (resultSet.next()) {
      int id = resultSet.getInt("id");
      String fn = resultSet.getString("first_name");
      String ln = resultSet.getString("last_name");

      System.out.println("ID: " + id + ", First Name: " + fn + " Last Name: " + ln);
    }
  }
}
