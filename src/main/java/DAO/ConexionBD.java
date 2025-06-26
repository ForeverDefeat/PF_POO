package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Cambia estos valores según tu configuración
    private static final String URL = "jdbc:mysql://localhost:3306/GestionLanCenter";
    private static final String USUARIO = "root";
    private static final String CLAVE = "RODRIGO30JA";

    // Método que retorna una conexión activa
    public static Connection conectar() {
        try {
            // Cargar el driver si usas versiones antiguas de Java:
            // Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos:");
            e.printStackTrace();
            return null;
        }
    }
}
