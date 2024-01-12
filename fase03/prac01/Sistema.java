package prac01;
import java.io.*;
import java.util.*;

public class Sistema {
  Map<String, String> cuentas = new HashMap<>();
  private Biblioteca biblioteca = new Biblioteca();
  Usuario user;

  public static void main(String[] args) {
    getCuentas();
    System.out.println("Sistema de Biblioteca EPIS");
    user = getLogin();

  }

  public Usuario getLogin() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Iniciar sesión:");
    System.out.println("Usuario:");
    String user = sc.nextLine();
    System.out.println("Password:");
    String pwd = sc.nextLine();

    if(pwd == cuentas.get(user)){
      return biblioteca.get(user);
    }
    return getLogin();
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

