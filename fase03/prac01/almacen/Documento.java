
public abstract class Documento {
    private String id;
    private String titulo;
    private String ubicacion;
    private String autor;
    private String estado;

    public Documento(String id, String titulo, String ubicacion, String autor, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.autor = autor;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }
}
