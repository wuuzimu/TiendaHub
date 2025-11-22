 package tiendahubgames;

import modelos.Cliente;
import modelos.Carrito;
import modelos.Administrador;
import gestores.Tienda;
import modelos.VideoJuego;
import modelos.PagoTarjeta;
import modelos.Promocion;
import java.util.Date;

public class TiendaHubGames {

    public static void main(String[] args) {
        
        // 1. Inicialización de la Tienda
        Tienda miTienda = new Tienda("HubGames Central");
        
        // 2. Agregar Videojuegos
        VideoJuego v1 = new VideoJuego(1, "Cyberpunk 2077", "RPG", 59.99, 10);
        VideoJuego v2 = new VideoJuego(2, "FIFA 25", "Deportes", 69.99, 5);
        miTienda.agregarVideojuego(v1);
        miTienda.agregarVideojuego(v2);

        // 3. Registrar Usuarios
        Cliente c1 = new Cliente(100, "Pedro Páramo", "pedro@mail.com", "1234", "Cll Falsa 123", "3001234567");
        miTienda.registrarUsuario(c1);
        
        Administrador a1 = new Administrador(1, "Admin Juez", "admin@hub.com", "root");
        miTienda.registrarUsuario(a1);
        
        // 4. Búsqueda y Compra (Simulación de un flujo de Cliente)
        System.out.println("\n--- BÚSQUEDA ---");
        miTienda.buscarVideojuego("RPG").forEach(v -> System.out.println("Encontrado: " + v.getTitulo()));
        
        // El cliente agrega items al carrito
        Carrito carritoCliente = new Carrito();
        carritoCliente.agregarVideojuego(v1);
        carritoCliente.agregarVideojuego(v2);
        
        System.out.println("Total a pagar: " + carritoCliente.calcularTotal());
        
        // Pago
        PagoTarjeta pago = new PagoTarjeta(carritoCliente.calcularTotal(), "1111222233334444", new Date(new Date().getTime() + 86400000 * 365));
        
        // El cliente realiza la compra
        boolean compraExitosa = c1.comprar(carritoCliente, pago);
        
        if (compraExitosa) {
            // **Paso Crítico:** Actualizar Stock en la Tienda
            miTienda.actualizarStock(c1, carritoCliente);
        }

        // Verificar stock después de la compra
        System.out.println("\n--- VERIFICACIÓN DE STOCK ---");
        System.out.println(v1.getTitulo() + " Stock restante: " + v1.getStock()); // Debería ser 9
        System.out.println(v2.getTitulo() + " Stock restante: " + v2.getStock()); // Debería ser 4
    }
}