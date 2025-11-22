package modelos;

import java.io.Serializable;

public class VideoJuego implements Serializable {
    
    private int id;
    private String titulo;
    private String genero;
    private double precio;
    private int stock; // Nuevo atributo de stock

    public VideoJuego(int id, String titulo, String genero, double precio, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setStock(int stock) { this.stock = stock; }

    // Otros métodos
    public String mostrarInfo() {
        return "ID: " + id + ", Título: " + titulo + ", Género: " + genero + ", Precio: " + precio + ", Stock: " + stock;
    }
}