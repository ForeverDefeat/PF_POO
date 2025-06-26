
package Modelo;

public class Computadora {

    private int id;              // ID único en base de datos
    private int numero;          // Número visible de la PC (ej. PC 1, PC 2...)
    private String estado;       // "OCUPADA" o "LIBRE"
    private String observacion;  // Por si deseas agregar mensajes como "Requiere mantenimiento"

    // Constructor vacío (necesario para algunas operaciones con frameworks)
    public Computadora() {
    }

    // Constructor completo
    public Computadora(int id, int numero, String estado, String observacion) {
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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
