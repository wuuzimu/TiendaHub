package modelos;
import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigoAdmin;
    private String departamento;
    
    public Administrador(String nombre, String email, String password, String codigoAdmin, String departamento) {
        super(nombre, email, password, "administrador");
        this.codigoAdmin = codigoAdmin;
        this.departamento = departamento;
    }
    
    public String getCodigoAdmin() { return codigoAdmin; }
    public void setCodigoAdmin(String codigoAdmin) { this.codigoAdmin = codigoAdmin; }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    
    @Override
    public String toString() {
        return "Administrador{" + "id=" + id + ", nombre='" + nombre + '\'' +
               ", email='" + email + '\'' + ", departamento='" + departamento + '\'' + '}';
    }
}