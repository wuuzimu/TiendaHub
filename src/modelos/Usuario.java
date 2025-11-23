package modelos;
import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    protected int id;
    protected String nombre;
    protected String email;
    protected String password;
    protected String tipoUsuario;
    protected static int contadorId = 1;
    
    public Usuario(String nombre, String email, String password, String tipoUsuario) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }
    
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getTipoUsuario() { return tipoUsuario; }
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre='" + nombre + '\'' +
               ", email='" + email + '\'' + ", tipoUsuario='" + tipoUsuario + '\'' + '}';
    }
}