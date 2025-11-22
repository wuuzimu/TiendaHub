package modelos;

import java.io.Serializable;

public class Notificaciones implements Serializable {
    
    private String mensaje;

    public Notificaciones() {
    }

    public Notificaciones(String mensaje) {
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    // Método de acción
    public void enviar() {
        System.out.println("--- NOTIFICACIÓN ---");
        System.out.println(mensaje);
        System.out.println("--------------------");
    }
}