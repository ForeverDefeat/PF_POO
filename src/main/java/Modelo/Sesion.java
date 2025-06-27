package Modelo;

import java.sql.Timestamp;

public class Sesion {

    private int id;
    private int computadoraId;
    private Timestamp horaInicio;
    private Timestamp horaFin;
    private long duracionMinutos;
    private double monto;

    public Sesion() {
    }

    public Sesion(int computadoraId, Timestamp horaInicio) {
        this.computadoraId = computadoraId;
        this.horaInicio = horaInicio;
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

    public Timestamp getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Timestamp horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Timestamp getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Timestamp horaFin) {
        this.horaFin = horaFin;
    }

    public long getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(long duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
