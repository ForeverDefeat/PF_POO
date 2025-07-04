package Logica;

import DAO.ComputadoraDAO;
import DAO.ConexionBD;
import DAO.SesionDAO;
import Modelo.Computadora;
import Modelo.Sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Timestamp;
import java.time.Duration;

public class SesionServicio {

    private final double tarifaPorMinuto = 0.10;

    public boolean iniciarSesion(int computadoraId) {
        // Verificamos si la computadora está libre antes de iniciar
        Computadora pc = ComputadoraDAO.buscarPorId(computadoraId);

        if (pc == null) {
            System.out.println("Computadora no encontrada.");
            return false;
        }

        if (!pc.getEstado().equalsIgnoreCase("LIBRE")) {
            System.out.println("La computadora ya está ocupada.");
            return false;
        }

        // Creamos nueva sesión
        Sesion nuevaSesion = new Sesion();
        nuevaSesion.setIdComputadora(computadoraId); // CORREGIDO
        nuevaSesion.setHoraInicio(new Timestamp(System.currentTimeMillis()));
        nuevaSesion.setEstado("ACTIVA");

        boolean insertada = SesionDAO.insertar(nuevaSesion);

        // Si se registró la sesión correctamente, marcamos la PC como OCUPADA
        if (insertada) {
            return ComputadoraDAO.actualizarEstado(computadoraId, "OCUPADA");
        } else {
            System.out.println("No se pudo iniciar sesión.");
            return false;
        }
    }

    public static Sesion obtenerSesionActiva(int computadoraId) {
        Connection conn = ConexionBD.conectar();
        String sql = "SELECT * FROM sesiones WHERE id_computadora = ? AND estado = 'ACTIVA'";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, computadoraId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Sesion sesion = new Sesion();
                sesion.setId(rs.getInt("id"));
                sesion.setIdComputadora(rs.getInt("id_computadora"));
                sesion.setHoraInicio(rs.getTimestamp("hora_inicio"));
                return sesion;
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener sesión activa: " + e.getMessage());
        }
        return null;
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
