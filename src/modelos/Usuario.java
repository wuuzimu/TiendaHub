package modelos;

import java.io.Serializable;

public class Usuario implements Serializable {
    
    protected int id;
    protected String nombre;
    protected String email;
    protected String password; // Es fundamental para el inicio de sesión

    public Usuario(int id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
    
    // Getters (solo para ejemplo, no exponer password directamente)
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getPassword() { return password; } // Usar con precaución

    // Setters
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; } // Para cambiar contraseña

    // Métodos de acción
    // La lógica de registrarse/iniciarSesion la manejaremos en la clase Tienda
}