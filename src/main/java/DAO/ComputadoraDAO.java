
package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Computadora;

public class ComputadoraDAO {

    // Obtener todas las computadoras
    public static List<Computadora> obtenerTodas() {
        List<Computadora> lista = new ArrayList<>();

        String sql = "SELECT * FROM computadoras";

        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Computadora pc = new Computadora();
                pc.setId(rs.getInt("id"));
                pc.setNumero(rs.getInt("numero"));
                pc.setEstado(rs.getString("estado"));
                pc.setObservacion(rs.getString("observacion"));
                lista.add(pc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar una computadora por ID
    public static Computadora buscarPorId(int id) {
        Computadora pc = null;
        String sql = "SELECT * FROM computadoras WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pc = new Computadora();
                    pc.setId(rs.getInt("id"));
                    pc.setNumero(rs.getInt("numero"));
                    pc.setEstado(rs.getString("estado"));
                    pc.setObservacion(rs.getString("observacion"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pc;
    }

    // Actualizar estado de una computadora
    public static boolean actualizarEstado(int idComputadora, String nuevoEstado) {
        String sql = "UPDATE computadoras SET estado = ? WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevoEstado);
            stmt.setInt(2, idComputadora);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}