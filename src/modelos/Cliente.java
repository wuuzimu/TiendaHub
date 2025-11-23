package modelos;
import java.io.Serializable;

public class Cliente extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private Carrito carrito;
    private String telefono;
    private String direccion;
    
    public Cliente(String nombre, String email, String password, String telefono, String direccion) {
        super(nombre, email, password, "cliente");
        this.carrito = new Carrito();
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public Carrito getCarrito() { return carrito; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre='" + nombre + '\'' +
               ", email='" + email + '\'' + ", telefono='" + telefono + '\'' + 
               ", direccion='" + direccion + '\'' + '}';
    }
}