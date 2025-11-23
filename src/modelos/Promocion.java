package modelos;
import java.io.Serializable;
import java.util.Date;

public class Promocion implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String descripcion;
    private double descuento;
    private Date fechaInicio;
    private Date fechaFin;
    private static int contadorId = 1;
    
    public Promocion(String descripcion, double descuento, Date fechaInicio, Date fechaFin) {
        this.id = contadorId++;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public double getDescuento() { return descuento; }
    public Date getFechaInicio() { return fechaInicio; }
    public Date getFechaFin() { return fechaFin; }
    
    public boolean esValida() {
        Date hoy = new Date();
        return hoy.after(fechaInicio) && hoy.before(fechaFin);
    }
    
    @Override
    public String toString() {
        return "Promocion{" + "id=" + id + ", " + descripcion + 
               ", " + descuento + "% descuento}";
    }
}