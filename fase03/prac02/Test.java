import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
      Peticion p0 = Peticion.createInstance();

      Peticion p1 = Peticion.createInstance();
      Peticion p2 = Peticion.createInstance();
      Peticion p3 = Peticion.createInstance();


    System.out.println(p0.hashCode() + "\n" + p1.hashCode() + "\n" + p2.hashCode() + "\n" + p3.hashCode());
  }
}
