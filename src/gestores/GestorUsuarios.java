package gestores;
import modelos.Usuario;
import modelos.Cliente;
import modelos.Administrador;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    private List<Usuario> usuarios;
    
    public GestorUsuarios() {
        this.usuarios = new ArrayList<>();
    }
    
    public boolean registrarUsuario(Usuario usuario) {
        if (buscarPorEmail(usuario.getEmail()) != null) {
            System.out.println("Error: El email ya está registrado.");
            return false;
        }
        usuarios.add(usuario);
        System.out.println("Usuario '" + usuario.getNombre() + "' registrado con éxito.");
        return true;
    }
    
    public Usuario buscarPorId(int id) {
        return usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    public Usuario buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
    
    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios);
    }
    
    public List<Usuario> obtenerPorTipo(String tipo) {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.getTipoUsuario().equals(tipo)) {
                resultado.add(u);
            }
        }
        return resultado;
    }
    
    public boolean actualizarUsuario(Usuario usuarioActualizado) {
        Usuario usuario = buscarPorId(usuarioActualizado.getId());
        if (usuario != null) {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setPassword(usuarioActualizado.getPassword());
            System.out.println("Usuario actualizado.");
            return true;
        }
        return false;
    }
    
    public boolean eliminarUsuario(int id) {
        Usuario usuario = buscarPorId(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            System.out.println("Usuario eliminado.");
            return true;
        }
        return false;
    }
    
    public Usuario iniciarSesion(String email, String password) {
        Usuario usuario = buscarPorEmail(email);
        if (usuario != null && usuario.getPassword().equals(password)) {
            System.out.println("Sesión iniciada como: " + usuario.getNombre());
            return usuario;
        }
        System.out.println("Error: Credenciales inválidas.");
        return null;
    }
    
    public int getTotalUsuarios() {
        return usuarios.size();
    }
}