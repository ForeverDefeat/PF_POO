package Modelo;

public class Consumo {

    private int id;
    private int computadoraId;
    private int productoId;
    private int cantidad;
    private double subtotal;

    // Constructor vacío
    public Consumo() {
    }

    // Constructor completo
    public Consumo(int id, int computadoraId, int productoId, int cantidad, double subtotal) {
        this.id = id;
        this.computadoraId = computadoraId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getComputadoraId() {
        return computadoraId;
    }

    public void setComputadoraId(int computadoraId) {
        this.computadoraId = computadoraId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
