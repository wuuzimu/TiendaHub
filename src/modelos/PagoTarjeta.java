package modelos;

import java.util.Date;
import java.io.Serializable;

public class PagoTarjeta extends Pago implements Serializable {
    
    private String numeroTarjeta;
    private Date fechaExp;

    public PagoTarjeta(double monto, String numeroTarjeta, Date fechaExp) {
        super(monto);
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExp = fechaExp;
    }

    // Getters y Setters
    public String getNumeroTarjeta() { return numeroTarjeta; }
    public Date getFechaExp() { return fechaExp; }

    public void setNumeroTarjeta(String numeroTarjeta) { this.numeroTarjeta = numeroTarjeta; }
    public void setFechaExp(Date fechaExp) { this.fechaExp = fechaExp; }

    // Métodos de acción
    public boolean validarTarjeta() {
        // Lógica simple de validación (podría ser más compleja, ej. algoritmo de Luhn)
        return numeroTarjeta != null && numeroTarjeta.length() >= 13 && fechaExp.after(new Date());
    }

    @Override
    public boolean realizarPago() {
        if (validarTarjeta()) {
            System.out.println("Procesando pago con tarjeta por: " + monto);
            // Simulación de conexión a pasarela de pago...
            return true; // Éxito en la transacción
        } else {
            System.out.println("Error: Tarjeta no válida o expirada.");
            return false;
        }
    }
}