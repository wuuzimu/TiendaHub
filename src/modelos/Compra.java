package modelos;

import java.util.Date;
import java.io.Serializable;

public class Compra implements Serializable {
    
    private double monto;
    private Date fecha;
    private Carrito carrito;
    private Pago pago;

    public Compra(Carrito carrito) {
        this.monto = carrito.calcularTotal();
        this.fecha = new Date();
        this.carrito = carrito;
    }

    // Getters y Setters (simplicidad)
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    // Método principal
    public boolean realizarPago(Pago pago) {
        this.pago = pago;
        System.out.println("Iniciando compra por un total de: " + monto);
        
        boolean pagoExitoso = pago.realizarPago();
        
        if (pagoExitoso) {
            // Lógica para descontar stock (debe hacerse en Tienda o Gestor)
            System.out.println("Compra exitosa el " + fecha.toString());
        } else {
            System.out.println("La compra no pudo completarse.");
        }
        return pagoExitoso;
    }
}