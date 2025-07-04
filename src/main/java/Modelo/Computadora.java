package Modelo;

public class Computadora {

    private int id;              // ID único en base de datos
    private String numero;          // Número visible de la PC (ej. PC 1, PC 2...)
    private String estado;       // "OCUPADA" o "LIBRE"
    private String observacion;  // Mensajes como "Requiere mantenimiento"

    // Constructor vacío
    public Computadora() {
    }

    // Constructor completo
    public Computadora(int id, String numero, String estado, String observacion) {
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.observacion = observacion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
