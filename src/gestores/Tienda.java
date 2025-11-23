package gestores;
import modelos.Usuario;
import modelos.VideoJuego;
import modelos.Compra;
import modelos.Notificacion;
import java.io.Serializable;

public class Tienda implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private GestorUsuarios gestorUsuarios;
    private GestorVideoJuegos gestorVideoJuegos;
    private GestorCompras gestorCompras;
    private GestorNotificaciones gestorNotificaciones;
    private GestorPromociones gestorPromociones;
    
    public Tienda(String nombre) {
        this.nombre = nombre;
        this.gestorUsuarios = new GestorUsuarios();
        this.gestorVideoJuegos = new GestorVideoJuegos();
        this.gestorCompras = new GestorCompras();
        this.gestorNotificaciones = new GestorNotificaciones();
        this.gestorPromociones = new GestorPromociones();
    }
    
    public String getNombre() { return nombre; }
    
    public GestorUsuarios getGestorUsuarios() { return gestorUsuarios; }
    public GestorVideoJuegos getGestorVideoJuegos() { return gestorVideoJuegos; }
    public GestorCompras getGestorCompras() { return gestorCompras; }
    public GestorNotificaciones getGestorNotificaciones() { return gestorNotificaciones; }
    public GestorPromociones getGestorPromociones() { return gestorPromociones; }
    
    public void procesarCompra(int idUsuario) {
        Usuario usuario = gestorUsuarios.buscarPorId(idUsuario);
        if (usuario != null && usuario.getClass().getSimpleName().equals("Cliente")) {
            modelos.Cliente cliente = (modelos.Cliente) usuario;
            modelos.Carrito carrito = cliente.getCarrito();
            
            if (carrito.getCantidadItems() > 0) {
                Compra compra = new Compra(idUsuario, carrito);
                gestorCompras.registrarCompra(compra);
                
                for (VideoJuego vj : carrito.getItems()) {
                    gestorVideoJuegos.descontarStock(vj.getId());
                }
                
                carrito.vaciar();
                
                Notificacion notif = new Notificacion(idUsuario, 
                    "Tu compra por $" + compra.getMonto() + " ha sido registrada.", "compra");
                gestorNotificaciones.crearNotificacion(notif);
            }
        }
    }
    
    @Override
    public String toString() {
        return "Tienda{" + "nombre='" + nombre + '\'' +
               ", usuarios=" + gestorUsuarios.getTotalUsuarios() +
               ", videojuegos=" + gestorVideoJuegos.getTotalVideojuegos() +
               ", compras=" + gestorCompras.getTotalCompras() + '}';
    }
}