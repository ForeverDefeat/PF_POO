package DAO;

import Modelo.Sesion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.*;

public class SesionDAO {

    public static boolean insertar(Sesion sesion) {
        Connection conn = ConexionBD.conectar();
        String sql = "INSERT INTO sesiones (id_computadora, hora_inicio, estado) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, sesion.getIdComputadora());
            stmt.setTimestamp(2, sesion.getHoraInicio());
            stmt.setString(3, sesion.getEstado());

            int filas = stmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar sesión: " + e.getMessage());
            return false;
        }
    }

    public static boolean iniciarSesion(int computadoraId) {
        String sql = "INSERT INTO sesiones (computadora_id, hora_inicio) VALUES (?, NOW())";
        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, computadoraId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error iniciar sesión: " + e.getMessage());
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

    public static boolean finalizarSesion(Sesion s) {
        Connection conn = ConexionBD.conectar();
        String sql = "UPDATE sesiones SET hora_fin = ?, duracion_minutos = ?, monto = ?, estado = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(1, s.getHoraFin());
            stmt.setLong(2, s.getDuracionMinutos());
            stmt.setDouble(3, s.getMonto());
            stmt.setString(4, "FINALIZADA");
            stmt.setInt(5, s.getId());

            int filas = stmt.executeUpdate();
            conn.close();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error al finalizar sesión: " + e.getMessage());
            return false;
        }

    }

    public static List<Sesion> obtenerTodas() {
        List<Sesion> lista = new ArrayList<>();
        String sql = "SELECT * FROM sesiones";
        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sesion s = new Sesion();
                s.setId(rs.getInt("id"));
                s.setIdComputadora(rs.getInt("id_computadora"));
                s.setHoraInicio(rs.getTimestamp("hora_inicio"));
                s.setHoraFin(rs.getTimestamp("hora_fin"));
                s.setDuracionMinutos(rs.getLong("duracion_minutos"));
                s.setMonto(rs.getDouble("monto"));
                s.setEstado(rs.getString("estado"));
                lista.add(s);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener sesiones: " + e.getMessage());
        }
        return lista;
    }
}
