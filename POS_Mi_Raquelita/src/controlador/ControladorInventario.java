package controlador;

// Imporación clases de SQL y de conexion con DDBB
import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Importación clase producto
import modelo.Producto;

// Importación clase ArrayList
import java.util.ArrayList;

public class ControladorInventario {
    
    // Creamos una lista dinámica para productos
    private static final ArrayList<Producto> listaProductos = new ArrayList<>();

    // Constructor vacio? para la pantalla inventario?
    public ControladorInventario() {
                
    }

    // Agregar producto a la DDBB
    public void agregarProducto(Producto nuevoProducto) {
        
        // Se establece conexion a DDBB con XAMPP
        ConexionDB con = new ConexionDB();
        Connection conexionApertura = con.establecerConexion();
        
        // Prepara la query SQL
        String sql = "INSERT INTO productos (nombre, categoria, precio, cantidad) VALUES (?, ?, ?, ?)";
        
        try {
            // Datos empacados para la query
            PreparedStatement pst = conexionApertura.prepareStatement(sql);
            pst.setString(1, nuevoProducto.getNombre());
            pst.setString(2, nuevoProducto.getCategoria());
            pst.setDouble(3, nuevoProducto.getPrecio());
            pst.setInt(4, nuevoProducto.getCantidad());
            
            // Envio de la query
            pst.executeUpdate();
            System.out.println("¡Éxito! Producto guardado en la Base de Datos de Mi Raquelita.");
            
            // Cierre de conexión con DDBB
            pst.close();
            conexionApertura.close();
            
        } catch (SQLException e) {
            // Captura de errores
            System.out.println("Error al guardar en la Base de Datos: " + e.toString());
        }
    }

    // Método para obtener productos de lista
    public ArrayList<Producto> obtenerTodosLosProductos() {
        
        ArrayList<Producto> listaLocal = new ArrayList<>();
        ConexionDB con = new ConexionDB();
        Connection conexion = con.establecerConexion();
        String sql = "SELECT * FROM productos"; // "Selecciona todo de la tabla productos"

        try {
            
            PreparedStatement pst = conexion.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(); // Ejecutamos la consulta

            while (rs.next()) {
                
                // Sacamos los datos de la fila de la base de datos
                Producto p = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("categoria"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad")
                );
                // Guardamos en lista de memoria (temporal)
                listaLocal.add(p); 
            }
            
            // Cierre de conexión con DDBB
            rs.close();
            pst.close();
            conexion.close();
            
        } catch (SQLException e) {
            
            System.out.println("Error al traer los datos: " + e.toString());
        }
        // Le entregamos la lista llena a la tabla
        return listaLocal; 
    }
    
    
    // Modificar un producto existente
    public void modificarProducto(int idBuscado, String nuevoNombre, String nuevaCategoria, double nuevoPrecio, int nuevaCantidad) {
        
        ConexionDB con = new ConexionDB();
        Connection conexion = con.establecerConexion();
        
        // Se actualiza en DDBB el producto segun ID correspondiente
        String sql = "UPDATE productos SET nombre=?, categoria=?, precio=?, cantidad=? WHERE id=?";

        try {
            
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, nuevoNombre);
            pst.setString(2, nuevaCategoria);
            pst.setString(3, String.valueOf(nuevoPrecio));
            pst.setInt(4, nuevaCantidad);
            pst.setInt(5, idBuscado);

            pst.executeUpdate();
            System.out.println("Producto actualizado con éxito.");
            
            // Cierre de conexión con DDBB
            pst.close();
            conexion.close();
            
        } catch (SQLException e) {
            
            System.out.println("Error al modificar: " + e.toString());
        }
    }
    
    // Eliminar un producto de la memoria
    public void eliminarProducto(int idBuscado) {
        
       ConexionDB con = new ConexionDB();
        Connection conexion = con.establecerConexion();
        String sql = "DELETE FROM productos WHERE id=?"; // Borra el producto con este ID

        try {
            
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, idBuscado);
            pst.executeUpdate();
            System.out.println("¡Éxito! Producto borrado de la Base de Datos.");
            
            // Cierre de conexión con DDBB
            pst.close();
            conexion.close();
            
        } catch (SQLException e) {
            
            System.out.println("Error al eliminar: " + e.toString());
        }
    }
    
}