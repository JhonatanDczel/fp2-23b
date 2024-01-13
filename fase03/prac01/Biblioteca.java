import java.util.*;

public class Biblioteca {
    private String nombre;
    private Map<String, Usuario> usuarios = new HashMap<>();
    private List<Documento> catalogo = new ArrayList<>(); // Agregamos una lista para almacenar los documentos

    public Biblioteca(String n) {
        nombre = n;
    }

    // Métodos para gestionar usuarios
    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getUsuario(), usuario);
    }

    public Usuario getUsuario(String nombreUsuario) {
        return usuarios.get(nombreUsuario);
    }

    // Métodos para gestionar documentos
    public void agregarDocumento(Documento documento) {
        catalogo.add(documento);
    }

    public Documento getDocumento(String idDocumento) {
        for (Documento documento : catalogo) {
            if (documento.getId().equals(idDocumento)) {
                return documento;
            }
        }
        return null;
    }

    // Método para registrar un nuevo libro
    public void registrarNuevoLibro() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el id: ");
        String id = sc.nextLine();
        System.out.print("Ingrese el título:");
        String titulo = sc.nextLine();
        System.out.print("Ingrese autor: ");
        String autor = sc.nextLine();
        System.out.print("Ingrese la ubicación: ");
        String ubicacion = sc.nextLine();
        System.out.print("Ingrese qué tipo de documento es (LIBRO, ARTICULO, TESIS): ");
        String tipo = sc.nextLine().toUpperCase();

        Documento doc;

        switch (tipo) {
            case "LIBRO":
                doc = new Libro(id, titulo, ubicacion, autor, "");
                break;
            case "ARTICULO":
                doc = new Articulo(id, titulo, ubicacion, autor, "");
                break;
            case "TESIS":
                doc = new Tesis(id, titulo, ubicacion, autor, "");
                break;
            default:
                System.out.println("Tipo de documento no válido.");
                return;
        }

        agregarDocumento(doc);

        System.out.println("Documento registrado correctamente.");
    }

    // Otros métodos relacionados con la biblioteca pueden ir aquí

}
