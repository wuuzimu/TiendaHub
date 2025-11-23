package modelos;
import java.io.Serializable;

public abstract class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    protected double monto;
    protected String estado;
    
    public Pago(double monto) {
        this.monto = monto;
        this.estado = "pendiente";
    }
    
    public double getMonto() { return monto; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public abstract boolean realizarPago();
    public abstract String obtenerDetalles();
}