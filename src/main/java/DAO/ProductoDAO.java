package DAO;

import Modelo.Producto;
import java.sql.*;
import java.util.*;

public class ProductoDAO {

    public static List<Producto> obtenerTodos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection conn = ConexionBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener productos: " + e.getMessage());
        }
        return lista;
    }

    public static boolean insertar(Producto p) {
        String sql = "INSERT INTO productos (nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getCategoria());
            stmt.setDouble(3, p.getPrecio());
            stmt.setInt(4, p.getStock());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
            return false;
        }
    }

    public static boolean actualizar(Producto p) {
        String sql = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, stock = ? WHERE id = ?";

        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getCategoria());
            stmt.setDouble(3, p.getPrecio());
            stmt.setInt(4, p.getStock());
            stmt.setInt(5, p.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    public static boolean eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }

    public static Producto buscarPorID(int id) {
        String sql = "SELECT * FROM productos WHERE id = ?";

        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                return p;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar producto por ID: " + e.getMessage());
        }
        return null;
    }
}
