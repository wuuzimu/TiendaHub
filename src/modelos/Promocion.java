package modelos;

import java.io.Serializable;

public class Promocion implements Serializable {
    
    private String descripcion;
    private double descuento;
    private VideoJuego videojuego;

    public Promocion(String descripcion, double descuento, VideoJuego videojuego) {
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.videojuego = videojuego;
    }

    // Getters y Setters
    public String getDescripcion() { return descripcion; }
    public double getDescuento() { return descuento; }
    public VideoJuego getVideojuego() { return videojuego; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setDescuento(double descuento) { this.descuento = descuento; }
    public void setVideojuego(VideoJuego videojuego) { this.videojuego = videojuego; }

    // Método clave para aplicar el descuento
    public double aplicarDescuento(double precioOriginal) {
        // El descuento es un valor entre 0.0 y 1.0 (ej. 0.1 para 10%)
        if (descuento > 0 && descuento <= 1.0) {
            return precioOriginal * (1.0 - descuento);
        }
        return precioOriginal; // No aplica descuento
    }
}