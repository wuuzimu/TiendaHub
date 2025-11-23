package gestores;
import modelos.VideoJuego;
import java.util.ArrayList;
import java.util.List;

public class GestorVideoJuegos {
    private List<VideoJuego> videojuegos;
    
    public GestorVideoJuegos() {
        this.videojuegos = new ArrayList<>();
    }
    
    public void agregarVideojuego(VideoJuego videojuego) {
        videojuegos.add(videojuego);
        System.out.println("Videojuego '" + videojuego.getTitulo() + "' agregado.");
    }
    
    public VideoJuego buscarPorId(int id) {
        return videojuegos.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    public List<VideoJuego> buscarPorTitulo(String titulo) {
        List<VideoJuego> resultado = new ArrayList<>();
        String criterioLower = titulo.toLowerCase();
        for (VideoJuego v : videojuegos) {
            if (v.getTitulo().toLowerCase().contains(criterioLower)) {
                resultado.add(v);
            }
        }
        return resultado;
    }
    
    public List<VideoJuego> buscarPorGenero(String genero) {
        List<VideoJuego> resultado = new ArrayList<>();
        String criterioLower = genero.toLowerCase();
        for (VideoJuego v : videojuegos) {
            if (v.getGenero().toLowerCase().contains(criterioLower)) {
                resultado.add(v);
            }
        }
        return resultado;
    }
    
    public List<VideoJuego> buscar(String criterio) {
        List<VideoJuego> resultado = new ArrayList<>();
        String criterioLower = criterio.toLowerCase();
        for (VideoJuego v : videojuegos) {
            if (v.getTitulo().toLowerCase().contains(criterioLower) || 
                v.getGenero().toLowerCase().contains(criterioLower) ||
                v.getDesarrolladora().toLowerCase().contains(criterioLower)) {
                resultado.add(v);
            }
        }
        return resultado;
    }
    
    public List<VideoJuego> obtenerTodos() {
        return new ArrayList<>(videojuegos);
    }
    
    public List<VideoJuego> obtenerConStock() {
        List<VideoJuego> resultado = new ArrayList<>();
        for (VideoJuego v : videojuegos) {
            if (v.getStock() > 0) {
                resultado.add(v);
            }
        }
        return resultado;
    }
    
    public boolean actualizarVideojuego(VideoJuego videojuegoActualizado) {
        VideoJuego videojuego = buscarPorId(videojuegoActualizado.getId());
        if (videojuego != null) {
            videojuego.setTitulo(videojuegoActualizado.getTitulo());
            videojuego.setPrecio(videojuegoActualizado.getPrecio());
            videojuego.setStock(videojuegoActualizado.getStock());
            System.out.println("Videojuego actualizado.");
            return true;
        }
        return false;
    }
    
    public boolean descontarStock(int idVideojuego) {
        VideoJuego videojuego = buscarPorId(idVideojuego);
        if (videojuego != null && videojuego.getStock() > 0) {
            videojuego.setStock(videojuego.getStock() - 1);
            return true;
        }
        return false;
    }
    
    public boolean eliminarVideojuego(int id) {
        VideoJuego videojuego = buscarPorId(id);
        if (videojuego != null) {
            videojuegos.remove(videojuego);
            System.out.println("Videojuego eliminado.");
            return true;
        }
        return false;
    }
    
    public int getTotalVideojuegos() {
        return videojuegos.size();
    }
}