import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
      Peticion p0 = new Peticion();
      Peticion p1 = new Peticion();
      Peticion p2 = new Peticion();
      Peticion p3 = new Peticion();


    System.out.println(p0.hashCode() + "\n" + p1.hashCode() + "\n" + p2.hashCode() + "\n" + p3.hashCode());
  }
}
