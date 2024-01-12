import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String iD;
    private String usuario;
    private String password;
    private Map<String, Ficha> librosGuardados = new HashMap<>();
    private Biblioteca biblio;

    public void setBiblioteca(Biblioteca biblio){
        this.biblio = biblio;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
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

    public Usuario(String iD, String usuario, String password) {
        this.iD = iD;
        this.usuario = usuario;
        this.password = password;
    }

    public Usuario() {
    }

    public void pedirLibro(String iD) {
        Ficha f = new Ficha(iD, usuario);
        librosGuardados.put(iD, f);
        biblio.entregarLibro(iD);
    }

    public void devolverLibro(String iD) {
        biblio.recibirLibro(iD);
    }

    public void imprimirLibrosGuardados() {
        System.out.println("Libros guardados por el usuario " + usuario + ":");
        for (String libroID : librosGuardados.keySet()) {
            System.out.println(libroID);
        }
    }
}
/*
 * Pedir libro(ID){
 * crear ficha
 * ID
 * //prestar libro
 * }
 */