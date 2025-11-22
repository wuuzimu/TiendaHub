package modelos;

import modelos.Promocion;
import gestores.Tienda; // Necesita acceder a la clase Tienda

public class Administrador extends Usuario {

    public Administrador(int id, String nombre, String email, String password) {
        super(id, nombre, email, password);
    }

    // Métodos de acción
    public void agregarPromocion(Promocion promocion, Tienda tienda) {
        // Lógica: La Tienda o Gestor debe tener una lista de promociones
        tienda.agregarPromocion(promocion); 
        System.out.println("Promoción " + promocion.getDescripcion() + " agregada.");
    }

    public void gestionarTienda(Tienda tienda) {
        System.out.println("Acceso a gestión de tienda (inventario, usuarios).");
        // Aquí iría la lógica para llamar a métodos de gestión en Tienda
    }
}