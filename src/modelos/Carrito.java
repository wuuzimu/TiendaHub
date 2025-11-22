package modelos; // O ajusten el paquete si es necesario

import java.util.ArrayList;
import java.util.List;
import modelos.VideoJuego;
import java.io.Serializable;

public class Carrito implements Serializable {
    
    private List<VideoJuego> listItems;

    public Carrito() {
        this.listItems = new ArrayList<>();
    }

    // Getters
    public List<VideoJuego> getListItems() { return listItems; }

    // Métodos de acción
    public void agregarVideojuego(VideoJuego v) {
        if (v.getStock() > 0) {
            listItems.add(v);
            System.out.println(v.getTitulo() + " agregado al carrito.");
        } else {
            System.out.println("No hay stock disponible de " + v.getTitulo());
        }
    }

    public void eliminarVideojuego(VideoJuego v) {
        if (listItems.remove(v)) {
            System.out.println(v.getTitulo() + " eliminado del carrito.");
        } else {
            System.out.println("El videojuego no estaba en el carrito.");
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (VideoJuego v : listItems) {
            // Aquí se podría implementar la lógica de Promociones si estuviera ligada al Videojuego
            // Por simplicidad, sumamos el precio base.
            total += v.getPrecio(); 
        }
        return total;
    }
}