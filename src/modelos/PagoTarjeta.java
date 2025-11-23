package modelos;
import java.io.Serializable;

public class PagoTarjeta extends Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    private String numeroTarjeta;
    private String nombreTitular;
    private String cvv;
    private String fechaVencimiento;
    
    public PagoTarjeta(double monto, String numeroTarjeta, String nombreTitular, 
                       String cvv, String fechaVencimiento) {
        super(monto);
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.cvv = cvv;
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public String getNumeroTarjeta() { return numeroTarjeta; }
    public String getNombreTitular() { return nombreTitular; }
    public String getCVV() { return cvv; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    
    @Override
    public boolean realizarPago() {
        if (validarTarjeta()) {
            this.estado = "completado";
            System.out.println("Pago de $" + monto + " realizado exitosamente.");
            System.out.println("Tarjeta: **** **** **** " + numeroTarjeta.substring(12));
            return true;
        } else {
            this.estado = "rechazado";
            System.out.println("Error: Tarjeta rechazada.");
            return false;
        }
    }
    
    private boolean validarTarjeta() {
        return numeroTarjeta.length() == 16 && cvv.length() == 3 && !fechaVencimiento.isEmpty();
    }
    
    @Override
    public String obtenerDetalles() {
        return "Pago con Tarjeta - " + nombreTitular + " - $" + monto;
    }
    
    @Override
    public String toString() {
        return "PagoTarjeta{" + "monto=$" + monto + ", estado='" + estado + 
               "', titular='" + nombreTitular + '\'' + '}';
    }
}
