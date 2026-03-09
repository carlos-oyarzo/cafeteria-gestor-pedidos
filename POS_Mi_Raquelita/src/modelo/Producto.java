package modelo;

public class Producto {
    // 1. ATRIBUTOS: Privados por el principio de Encapsulamiento.
    private int id;
    private String nombre;
    private String categoria; 
    private double precio;
    private int cantidad;

    // 2. CONSTRUCTOR: El método que "fabrica" el objeto cuando lo necesitamos.
    public Producto(int id, String nombre, String categoria, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // 3. GETTERS: Métodos públicos para poder "leer" los datos privados desde otras pantallas.
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
