package modelos;

import java.io.Serializable;

// Se recomienda que sea abstracta ya que un "Pago" genérico no se instancia directamente
public abstract class Pago implements Serializable {
    
    protected double monto;

    public Pago(double monto) {
        this.monto = monto;
    }

    // Getters y Setters
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    // Método abstracto que debe ser implementado por subclases
    public abstract boolean realizarPago();
}