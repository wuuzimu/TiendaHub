package modelos;
import java.io.Serializable;
import java.util.Date;

public class Notificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int idUsuario;
    private String mensaje;
    private Date fecha;
    private String tipo;
    private static int contadorId = 1;
    
    public Notificacion(int idUsuario, String mensaje, String tipo) {
        this.id = contadorId++;
        this.idUsuario = idUsuario;
        this.mensaje = mensaje;
        this.fecha = new Date();
        this.tipo = tipo;
    }
    
    public int getId() { return id; }
    public int getIdUsuario() { return idUsuario; }
    public String getMensaje() { return mensaje; }
    public Date getFecha() { return fecha; }
    public String getTipo() { return tipo; }
    
    public void mostrar() {
        System.out.println("[" + tipo.toUpperCase() + "] " + mensaje);
    }
    
    @Override
    public String toString() {
        return "Notificacion{" + "id=" + id + ", tipo='" + tipo + 
               "', mensaje='" + mensaje + '\'' + '}';
    }
}
