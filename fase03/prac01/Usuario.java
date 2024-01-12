public class Usuario {
    private String iD;
    private String usuario;
    private String password;

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
    }

    public void devolverLibro(String iD){
        recibirLibro(iD);
    }
}
/*
 * Pedir libro(ID){
 * crear ficha
 * ID
 * //prestar libro
 * }
 */