package gestores;

import java.util.ArrayList;
import java.util.List;
import modelos.VideoJuego;
import modelos.Usuario;
import modelos.Cliente;
import modelos.Promocion;
import java.io.Serializable;
import modelos.Carrito;

public class Tienda implements Serializable {
    
    private String nombre;
    private List<VideoJuego> listVideojuegos;
    private List<Usuario> listUsuarios;
    private List<Promocion> listPromociones; // Nueva lista para gestión

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.listVideojuegos = new ArrayList<>();
        this.listUsuarios = new ArrayList<>();
        this.listPromociones = new ArrayList<>();
    }

    // Getters y Setters (simplicidad)
    public String getNombre() { return nombre; }
    public List<VideoJuego> getListVideojuegos() { return listVideojuegos; }
    public List<Usuario> getListUsuarios() { return listUsuarios; }
    
    // Métodos de gestión
    public void agregarVideojuego(VideoJuego v) {
        listVideojuegos.add(v);
    }

    public void registrarUsuario(Usuario u) {
        // Verifica si el email ya existe antes de registrar
        if (listUsuarios.stream().noneMatch(user -> user.getEmail().equals(u.getEmail()))) {
            listUsuarios.add(u);
            System.out.println("Usuario " + u.getNombre() + " registrado con éxito.");
        } else {
            System.out.println("Error: El email ya está registrado.");
        }
    }
    
    public void agregarPromocion(Promocion p) {
        this.listPromociones.add(p);
    }

    // --- Funcionalidad Clave ---
    
    // 1. Iniciar Sesión
    public Usuario iniciarSesion(String email, String password) {
        for (Usuario u : listUsuarios) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                System.out.println("Sesión iniciada como: " + u.getNombre());
                return u;
            }
        }
        System.out.println("Error de credenciales. Intente de nuevo.");
        return null;
    }
    
    // 2. Búsqueda de Videojuegos
    public List<VideoJuego> buscarVideojuego(String criterioBusqueda) {
        List<VideoJuego> resultados = new ArrayList<>();
        String criterioLower = criterioBusqueda.toLowerCase();
        
        for (VideoJuego v : listVideojuegos) {
            if (v.getTitulo().toLowerCase().contains(criterioLower) || 
                v.getGenero().toLowerCase().contains(criterioLower)) {
                resultados.add(v);
            }
        }
        return resultados;
    }
    
    // 3. Actualizar Stock después de la Compra (ESENCIAL)
    public void actualizarStock(Cliente cliente, Carrito carrito) {
        for (VideoJuego itemCarrito : carrito.getListItems()) {
            for (VideoJuego v : listVideojuegos) {
                // Buscamos el videojuego por su ID en la lista de la tienda
                if (v.getId() == itemCarrito.getId()) {
                    if (v.getStock() > 0) {
                        v.setStock(v.getStock() - 1); // Descontar 1 unidad
                    }
                    // No hace falta buscar más, ya que se encuentra el item
                    break;
                }
            }
        }
        // Limpiar carrito después del proceso de stock
        carrito.getListItems().clear();
        new modelos.Notificaciones("Stock de la compra de " + cliente.getNombre() + " actualizado.").enviar();
    }
}