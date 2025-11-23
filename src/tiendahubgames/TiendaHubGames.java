 package tiendahubgames;
import gestores.Tienda;
import modelos.Cliente;
import modelos.Administrador;
import modelos.VideoJuego;
import modelos.Promocion;
import java.util.Date;

public class TiendaHubGames {
    private static Tienda tienda;
    
    public TiendaHubGames() {
        tienda = new Tienda("TiendaHubGames");
    }
    
    public static Tienda getTienda() {
        if (tienda == null) {
            tienda = new Tienda("TiendaHubGames");
        }
        return tienda;
    }
    
    public static void inicializarDatos() {
        // Agregar videojuegos de ejemplo
        tienda.getGestorVideoJuegos().agregarVideojuego(
            new VideoJuego("The Legend of Zelda: Breath of the Wild", "Aventura", 59.99, 10, 
                          "Nintendo", "Juego de aventura en mundo abierto")
        );
        tienda.getGestorVideoJuegos().agregarVideojuego(
            new VideoJuego("Elden Ring", "RPG", 59.99, 15, 
                          "FromSoftware", "RPG de acción desafiante")
        );
        tienda.getGestorVideoJuegos().agregarVideojuego(
            new VideoJuego("Cyberpunk 2077", "RPG", 49.99, 8, 
                          "CD Projekt Red", "RPG futurista de mundo abierto")
        );
        tienda.getGestorVideoJuegos().agregarVideojuego(
            new VideoJuego("Minecraft", "Sandbox", 19.99, 50, 
                          "Mojang", "Juego de construcción infinita")
        );
        
        System.out.println("Datos iniciales cargados.");
    }
    
    public static void main(String[] args) {
        // Inicializar la tienda
        TiendaHubGames app = new TiendaHubGames();
        inicializarDatos();
        
        // Ejemplo de uso
        System.out.println("\n=== TIENDA HUB GAMES ===");
        System.out.println(tienda);
        
        // Registrar un cliente
        Cliente cliente = new Cliente("Juan Pérez", "juan@email.com", "123456", "3012345678", "Calle 1");
        tienda.getGestorUsuarios().registrarUsuario(cliente);
        
        // Registrar un administrador
        Administrador admin = new Administrador("María López", "admin@email.com", "admin123", "ADMIN001", "Ventas");
        tienda.getGestorUsuarios().registrarUsuario(admin);
        
        // Iniciar sesión
        System.out.println("\n=== INICIAR SESIÓN ===");
        tienda.getGestorUsuarios().iniciarSesion("juan@email.com", "123456");
        
        // Buscar videojuegos
        System.out.println("\n=== BÚSQUEDA DE VIDEOJUEGOS ===");
        var resultados = tienda.getGestorVideoJuegos().buscar("zelda");
        resultados.forEach(System.out::println);
        
        // Mostrar todos los videojuegos
        System.out.println("\n=== CATÁLOGO COMPLETO ===");
        tienda.getGestorVideoJuegos().obtenerTodos().forEach(System.out::println);
    }
}