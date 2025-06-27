package Logica;

import DAO.ComputadoraDAO;
import DAO.SesionDAO;
import Modelo.Sesion;

import java.sql.Timestamp;
import java.time.Duration;

public class SesionServicio {

    private final double tarifaPorMinuto = 0.10; // puedes modificar esto

    public boolean iniciarSesion(int computadoraId) {
        boolean ok = SesionDAO.iniciarSesion(computadoraId);
        if (ok) {
            ComputadoraDAO.actualizarEstado(computadoraId, "OCUPADA");
        }
        return ok;
    }

    public boolean finalizarSesion(int computadoraId) {
        Sesion sesion = SesionDAO.obtenerSesionActiva(computadoraId);
        if (sesion == null) {
            return false;
        }

        Timestamp fin = new Timestamp(System.currentTimeMillis());
        long minutos = Duration.between(sesion.getHoraInicio().toInstant(), fin.toInstant()).toMinutes();
        double monto = minutos * tarifaPorMinuto;

        sesion.setHoraFin(fin);
        sesion.setDuracionMinutos(minutos);
        sesion.setMonto(monto);

        boolean ok = SesionDAO.finalizarSesion(sesion);
        if (ok) {
            ComputadoraDAO.actualizarEstado(computadoraId, "LIBRE");
        }
        return ok;
    }
}
