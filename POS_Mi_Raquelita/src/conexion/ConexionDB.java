package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionDB {
    
    // 1. LAS CREDENCIALES: La dirección y las llaves de XAMPP
    String ip = "localhost"; // Tu propia PC
    String puerto = "3306"; // Este es el puerto por defecto de MySQL
    String baseDatos = "pos_raquelita"; // El nombre exacto que le pusimos en phpMyAdmin
    
    // La URL final que une todo lo anterior
    String cadenaConexion = "jdbc:mysql://" + ip + ":" + puerto + "/" + baseDatos;
    
    // El usuario por defecto de XAMPP siempre es "root" y la contraseña viene vacía ""
    String usuario = "root";
    String contrasena = ""; 
    
    // 2. LA VARIABLE DE CONEXIÓN
    Connection conectar = null;

    // 3. EL MÉTODO PARA ABRIR LA PUERTA
    public Connection establecerConexion() {
        try {
            // Le decimos a Java que use el traductor (Driver) que descargaste
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Intentamos iniciar sesión en MySQL
            conectar = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            
            // Mensaje de éxito temporal para comprobar que funciona (luego lo borramos)
            //JOptionPane.showMessageDialog(null, "¡Éxito! Conectados a la Base de Datos de Mi Raquelita");
            
        } catch (ClassNotFoundException | SQLException e) {
            // Si algo sale mal (XAMPP apagado, mal la contraseña, etc.), el escudo atrapa el error
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.toString());
        }
        return conectar;
    }
    
    
}