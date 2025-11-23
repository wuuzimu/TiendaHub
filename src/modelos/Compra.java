package modelos;
import java.io.Serializable;
import java.util.Date;

public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int idUsuario;
    private Carrito carrito;
    private double monto;
    private Date fecha;
    private String estado;
    private static int contadorId = 1;
    
    public Compra(int idUsuario, Carrito carrito) {
        this.id = contadorId++;
        this.idUsuario = idUsuario;
        this.carrito = carrito;
        this.monto = carrito.calcularTotal();
        this.fecha = new Date();
        this.estado = "pendiente";
    }
    
    public int getId() { return id; }
    public int getIdUsuario() { return idUsuario; }
    public Carrito getCarrito() { return carrito; }
    public double getMonto() { return monto; }
    public Date getFecha() { return fecha; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", usuario=" + idUsuario + 
               ", monto=$" + monto + ", estado='" + estado + '\'' + '}';
    }
}