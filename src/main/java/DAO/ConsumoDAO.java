package DAO;

import Modelo.Consumo;
import java.sql.*;
import java.util.*;

public class ConsumoDAO {

    public static boolean registrarConsumo(Consumo c) {
        String sql = "INSERT INTO consumos (computadora_id, producto_id, cantidad, subtotal) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getComputadoraId());
            stmt.setInt(2, c.getProductoId());
            stmt.setInt(3, c.getCantidad());
            stmt.setDouble(4, c.getSubtotal());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al registrar consumo: " + e.getMessage());
            return false;
        }
    }

    public static List<Consumo> obtenerPorComputadora(int computadoraId) {
        List<Consumo> lista = new ArrayList<>();
        String sql = "SELECT * FROM consumos WHERE computadora_id = ?";

        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, computadoraId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Consumo c = new Consumo();
                c.setId(rs.getInt("id"));
                c.setComputadoraId(rs.getInt("computadora_id"));
                c.setProductoId(rs.getInt("producto_id"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setSubtotal(rs.getDouble("subtotal"));
                lista.add(c);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener consumos: " + e.getMessage());
        }
        return lista;
    }

    public static double calcularTotalConsumo(int computadoraId) {
        String sql = "SELECT SUM(subtotal) FROM consumos WHERE computadora_id = ?";
        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, computadoraId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble(1);
            }

        } catch (Exception e) {
            System.out.println("Error al calcular total de consumos: " + e.getMessage());
        }
        return 0;
    }
}
