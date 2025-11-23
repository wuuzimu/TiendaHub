package gestores;
import modelos.Notificacion;
import java.util.ArrayList;
import java.util.List;

public class GestorNotificaciones {
    private List<Notificacion> notificaciones;
    
    public GestorNotificaciones() {
        this.notificaciones = new ArrayList<>();
    }
    
    public void crearNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
        System.out.println("Notificación creada.");
    }
    
    public List<Notificacion> obtenerPorUsuario(int idUsuario) {
        List<Notificacion> resultado = new ArrayList<>();
        for (Notificacion n : notificaciones) {
            if (n.getIdUsuario() == idUsuario) {
                resultado.add(n);
            }
        }
        return resultado;
    }
    
    public List<Notificacion> obtenerPorTipo(String tipo) {
        List<Notificacion> resultado = new ArrayList<>();
        for (Notificacion n : notificaciones) {
            if (n.getTipo().equals(tipo)) {
                resultado.add(n);
            }
        }
        return resultado;
    }
    
    public List<Notificacion> obtenerTodas() {
        return new ArrayList<>(notificaciones);
    }
    
    public void mostrarNotificacionesUsuario(int idUsuario) {
        List<Notificacion> notifs = obtenerPorUsuario(idUsuario);
        if (notifs.isEmpty()) {
            System.out.println("No hay notificaciones.");
        } else {
            System.out.println("--- Notificaciones ---");
            for (Notificacion n : notifs) {
                n.mostrar();
            }
        }
    }
}
