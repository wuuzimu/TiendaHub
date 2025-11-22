package modelos;

import modelos.Carrito;
import modelos.VideoJuego;
import modelos.Notificaciones;
import modelos.Compra;
import modelos.PagoTarjeta; // Solo si compran con tarjeta por defecto

public class Cliente extends Usuario {
    
    private String direccion;
    private String telefono;
    
    // Lista para reservas (simulación, no es persistente)
    private VideoJuego reserva; 

    public Cliente(int id, String nombre, String email, String password, String direccion, String telefono) {
        super(id, nombre, email, password);
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    // Métodos de acción
    public void reservarVideojuego(VideoJuego v) {
        this.reserva = v;
        new Notificaciones("Has reservado: " + v.getTitulo()).enviar();
    }

    public boolean comprar(Carrito c, PagoTarjeta pago) {
        Compra nuevaCompra = new Compra(c);
        if (nuevaCompra.realizarPago(pago)) {
            // Aquí se necesitaría el Gestor/Tienda para actualizar stock
            return true;
        }
        return false;
    }
}