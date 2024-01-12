package prac01;
import java.io.*;
import java.util.*;

public class Sistema {
  Map<String, String> cuentas = new HashMap<>();

  public static void main(String[] args) {
   Biblioteca biblioteca = new Biblioteca();
   System.out.println("Sistema de Biblioteca EPIS");
  }

  public Usuario getLogin() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Iniciar sesión:");
    System.out.println("Usuario:");
    String user = sc.nextLine();
    System.out.println("Password:");
    String pwd = sc.nextLine();

    if(pwd == cuentas.get(user)){
      return 
    }
    return getLogin();
  }

  public void signUp() {

  }
  public void operacion() {

  }

  public void getCuentas(){
    String ruta = "./almacen/cuentas.csv";

    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
      String linea;

      while ((linea = br.readLine()) != null) {
        String[] campos = linea.split(",");

        String usuario = campos[0].trim();
        String contrasena = campos[1].trim();

        cuentas.put(usuario, contrasena);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

