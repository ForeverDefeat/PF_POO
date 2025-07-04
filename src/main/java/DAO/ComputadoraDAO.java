package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Computadora;

public class ComputadoraDAO {

    //Insertar nueva computadora
    public static boolean insertar(Computadora pc) {
        Connection conn = ConexionBD.conectar();
        String sql = "INSERT INTO computadoras (numero, estado) VALUES (?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pc.getNumero());
            stmt.setString(2, pc.getEstado());

            int filas = stmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar computadora: " + e.getMessage());
            return false;
        }
    }

    //Eliminar una computadora
    public static boolean eliminar(int id) {
        Connection conn = ConexionBD.conectar();
        String sql = "DELETE FROM computadoras WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar computadora: " + e.getMessage());
            return false;
        }
    }

    // Obtener todas las computadoras
    public static List<Computadora> obtenerTodas() {
        List<Computadora> lista = new ArrayList<>();
        Connection conn = ConexionBD.conectar();
        String sql = "SELECT * FROM computadoras";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Computadora pc = new Computadora();
                pc.setId(rs.getInt("id"));
                pc.setNumero(rs.getString("numero"));
                pc.setEstado(rs.getString("estado"));
                lista.add(pc);
            }

            //System.out.println("Cantidad de computadoras encontradas: " + lista.size());
        } catch (SQLException e) {
            System.out.println("Error al obtener computadoras: " + e.getMessage());
        }

        return lista;
    }

    // Buscar una computadora por ID
    public static Computadora buscarPorId(int id) {
        Computadora pc = null;
        Connection conn = ConexionBD.conectar();

        if (conn != null) {
            try {
                String sql = "SELECT * FROM computadoras WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    pc = new Computadora();
                    pc.setId(rs.getInt("id"));
                    pc.setNumero(rs.getString("numero"));
                    pc.setEstado(rs.getString("estado"));
                }

                conn.close();
            } catch (SQLException e) {
                System.out.println("Error al buscar computadora: " + e.getMessage());
            }
        }

        return pc;
    }

    //Obtener Id de la computadora
    public static int obtenerIdPorNumero(String numero) {
        int id = -1;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionBD.conectar();
            String sql = "SELECT id FROM computadoras WHERE numero = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, numero);
            rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener ID por número: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return id;
    }

    public static String obtenerNumeroPorId(int idComputadora) {
        String numero = "";
        String sql = "SELECT numero FROM computadoras WHERE id = ?";
        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idComputadora);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                numero = rs.getString("numero");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener número por ID: " + e.getMessage());
        }
        return numero;
    }

    // Actualizar estado de una computadora
    public static boolean actualizarEstado(int idComputadora, String nuevoEstado) {
        Connection conn = ConexionBD.conectar();

        if (conn != null) {
            try {
                String sql = "UPDATE computadoras SET estado = ? WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nuevoEstado);
                stmt.setInt(2, idComputadora);

                int filas = stmt.executeUpdate();
                conn.close();
                return filas > 0;
            } catch (SQLException e) {
                System.out.println("Error al actualizar estado: " + e.getMessage());
            }
        }

        return false;
    }
}
