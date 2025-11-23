package modelos;
import java.io.Serializable;

public class VideoJuego implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String titulo;
    private String genero;
    private double precio;
    private int stock;
    private String desarrolladora;
    private String descripcion;
    private static int contadorId = 1;
    
    public VideoJuego(String titulo, String genero, double precio, int stock, 
                      String desarrolladora, String descripcion) {
        this.id = contadorId++;
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
        this.stock = stock;
        this.desarrolladora = desarrolladora;
        this.descripcion = descripcion;
    }
    
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public String getDesarrolladora() { return desarrolladora; }
    public String getDescripcion() { return descripcion; }
    
    @Override
    public String toString() {
        return "VideoJuego{" + "id=" + id + ", titulo='" + titulo + '\'' +
               ", genero='" + genero + '\'' + ", precio=$" + precio +
               ", stock=" + stock + '}';
    }}