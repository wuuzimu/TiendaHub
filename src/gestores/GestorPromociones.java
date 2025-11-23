package gestores;
import modelos.Promocion;
import java.util.ArrayList;
import java.util.List;

public class GestorPromociones {
    private List<Promocion> promociones;
    
    public GestorPromociones() {
        this.promociones = new ArrayList<>();
    }
    
    public void agregarPromocion(Promocion promocion) {
        promociones.add(promocion);
        System.out.println("Promoción agregada.");
    }
    
    public List<Promocion> obtenerActivas() {
        List<Promocion> resultado = new ArrayList<>();
        for (Promocion p : promociones) {
            if (p.esValida()) {
                resultado.add(p);
            }
        }
        return resultado;
    }
    
    public List<Promocion> obtenerTodas() {
        return new ArrayList<>(promociones);
    }
    
    public boolean eliminarPromocion(int id) {
        Promocion promocion = promociones.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        if (promocion != null) {
            promociones.remove(promocion);
            return true;
        }
        return false;
    }
    
    public int getTotalPromociones() {
        return promociones.size();
    }
}