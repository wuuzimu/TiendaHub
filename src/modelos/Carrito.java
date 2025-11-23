package modelos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carrito implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private List<VideoJuego> items;
    private static int contadorId = 1;
    
    public Carrito() {
        this.id = contadorId++;
        this.items = new ArrayList<>();
    }
    
    public int getId() { return id; }
    public List<VideoJuego> getItems() { return items; }
    
    public void agregarItem(VideoJuego videojuego) {
        items.add(videojuego);
        System.out.println("'" + videojuego.getTitulo() + "' agregado al carrito.");
    }
    
    public void eliminarItem(VideoJuego videojuego) {
        if (items.remove(videojuego)) {
            System.out.println("Videojuego eliminado del carrito.");
        }
    }
    
    public double calcularTotal() {
        return items.stream().mapToDouble(VideoJuego::getPrecio).sum();
    }
    
    public void vaciar() {
        items.clear();
        System.out.println("Carrito vaciado.");
    }
    
    public int getCantidadItems() { return items.size(); }
    
    @Override
    public String toString() {
        return "Carrito{" + "id=" + id + ", items=" + items.size() + 
               ", total=$" + calcularTotal() + '}';
    }
}