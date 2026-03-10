package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionDB {
    
    // Dirección, puerto y nombre de DDBB para la conexion de la base de datos
    String ip = "localhost"; // Tu propia PC
    String puerto = "3306"; // Este es el puerto por defecto de MySQL
    String baseDatos = "pos_raquelita"; // El nombre exacto que le pusimos en phpMyAdmin
    
    // La URL de la base de datos
    String cadenaConexion = "jdbc:mysql://" + ip + ":" + puerto + "/" + baseDatos;
    
    // Credenciales de XAMPP
    String usuario = "root";
    String contrasena = ""; 
    
    // Variable de la conexion
    Connection conectar = null;

    // Método para abrir la conexion
    public Connection establecerConexion() {
        try {
            // Configuramos el controlador de la conexion
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Iniciar sesión en MySQL
            conectar = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            
        } catch (ClassNotFoundException | SQLException e) {
            // Captura de error
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.toString());
        }
        return conectar;
    }
    
    
}