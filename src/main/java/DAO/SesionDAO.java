
package DAO;

import Modelo.Sesion;
import java.sql.*;
//import java.util.*;

public class SesionDAO {

    public static boolean iniciarSesion(int computadoraId) {
        String sql = "INSERT INTO sesiones (computadora_id, hora_inicio) VALUES (?, NOW())";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, computadoraId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error iniciar sesión: " + e.getMessage());
            return false;
        }
    }

    public static Sesion obtenerSesionActiva(int computadoraId) {
        String sql = "SELECT * FROM sesiones WHERE computadora_id = ? AND hora_fin IS NULL";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, computadoraId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Sesion s = new Sesion();
                s.setId(rs.getInt("id"));
                s.setComputadoraId(rs.getInt("computadora_id"));
                s.setHoraInicio(rs.getTimestamp("hora_inicio"));
                return s;
            }

        } catch (SQLException e) {
            System.out.println("Error obtener sesión activa: " + e.getMessage());
        }
        return null;
    }

    public static boolean finalizarSesion(Sesion s) {
        String sql = "UPDATE sesiones SET hora_fin = ?, duracion_minutos = ?, monto = ? WHERE id = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, s.getHoraFin());
            stmt.setLong(2, s.getDuracionMinutos());
            stmt.setDouble(3, s.getMonto());
            stmt.setInt(4, s.getId());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error finalizar sesión: " + e.getMessage());
            return false;
        }
    }
}