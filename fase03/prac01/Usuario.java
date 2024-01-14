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
          System.out.println("El libro no esta disponible o no existe");
          return;
        }
        librosGuardados.put(ID, f);
    }

    public void devolverLibro(String ID) {
      Ficha ficha = librosGuardados.get(ID);
      if (ficha == null) {
        System.out.println("No tienes el libro en tu posesión");
      }
      biblio.recibirLibro(ficha);
      librosGuardados.remove(ID);
    }

    public void mostrarLibros() {
        System.out.println("Libros guardados por el usuario " + usuario + ":");
        for (String libroID : librosGuardados.keySet()) {
            System.out.println(libroID);
        }
    }
}
