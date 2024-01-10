public class Sistema {
  public static void main(String[] args) {
    Biblioteca biblioteca = new Biblioteca("CEDIS UNSA");
    System.out.println("Sistema de Biblioteca EPIS");
    Usuario user = getLogin();

    System.out.println("Nueva operación: ");
    Operacion p = new Operacion(user, biblioteca);

  }
  public void login() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Iniciar sesión:");
    System.out.println("Usuario :");
    String user = sc.nextLine();
    System.out.println("Password :");
  }
  public void signUp() {
    
  }
  public void operacion() {
    
  }
}

