package gestores;
import modelos.Compra;
import java.util.ArrayList;
import java.util.List;

public class GestorCompras {
    private List<Compra> compras;
    
    public GestorCompras() {
        this.compras = new ArrayList<>();
    }
    
    public void registrarCompra(Compra compra) {
        compras.add(compra);
        System.out.println("Compra registrada: ID " + compra.getId());
    }
    
    public Compra buscarPorId(int id) {
        return compras.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    public List<Compra> buscarPorUsuario(int idUsuario) {
        List<Compra> resultado = new ArrayList<>();
        for (Compra c : compras) {
            if (c.getIdUsuario() == idUsuario) {
                resultado.add(c);
            }
        }
        return resultado;
    }
    
    public List<Compra> obtenerTodas() {
        return new ArrayList<>(compras);
    }
    
    public List<Compra> obtenerPorEstado(String estado) {
        List<Compra> resultado = new ArrayList<>();
        for (Compra c : compras) {
            if (c.getEstado().equals(estado)) {
                resultado.add(c);
            }
        }
        return resultado;
    }
    
    public boolean actualizarEstado(int idCompra, String nuevoEstado) {
        Compra compra = buscarPorId(idCompra);
        if (compra != null) {
            compra.setEstado(nuevoEstado);
            System.out.println("Compra " + idCompra + " actualizada a: " + nuevoEstado);
            return true;
        }
        return false;
    }
    
    public double obtenerTotalVentas() {
        return compras.stream()
                .filter(c -> c.getEstado().equals("completada"))
                .mapToDouble(Compra::getMonto)
                .sum();
    }
    
    public int getTotalCompras() {
        return compras.size();
    }
}