package prac01;
public class Sistema {
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
    return getLogin();
  }

  public void signUp() {

  }
  public void operacion() {

  }
}

