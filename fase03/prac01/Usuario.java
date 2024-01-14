package prac01;
import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String usuario;
    private String password;
    private Map<String, Ficha> librosGuardados = new HashMap<>();
    private Biblioteca biblio;

    public void setBiblioteca(Biblioteca biblio){
        this.biblio = biblio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Usuario() {
    }

    public void pedirLibro(String ID) {
        Ficha f = new Ficha(usuario, ID);
        String peticion = biblio.entregarLibro(f);
        if (peticion.equals("fallo")) {
          Sistema.sleep(400);
          System.out.println("\nEl libro no esta disponible o no existe");
          return;
        }
        librosGuardados.put(ID, f);
    }

    public void devolverLibro(String ID) {
      Ficha ficha = librosGuardados.get(ID);
      if (ficha == null) {
        System.out.println("\nNo tienes el libro en tu posesión");
        return;
      }
      biblio.recibirLibro(ficha);
      librosGuardados.remove(ID);
    }

    public void mostrarLibros() {
        for (String libroID : librosGuardados.keySet()) {
          biblio.imprimirLibro(libroID);
          System.out.println("Fecha de devolucion: " + librosGuardados.get(libroID).getEnd());
        }
    }
}
