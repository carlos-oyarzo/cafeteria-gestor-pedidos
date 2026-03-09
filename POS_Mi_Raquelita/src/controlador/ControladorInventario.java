package controlador;

// --- NUEVAS HERRAMIENTAS PARA LA BASE DE DATOS ---
import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Importamos nuestra clase Producto para poder usarla aquí
import modelo.Producto;
// Importamos la herramienta ArrayList de Java (nuestro "cajón" de memoria)
import java.util.ArrayList;

public class ControladorInventario {
    
    // 1. EL CAJÓN: Creamos una lista dinámica que solo guardará "Productos"
    private static final ArrayList<Producto> listaProductos = new ArrayList<>();

    // 2. EL CONSTRUCTOR: Esto se ejecuta apenas abres la ventana del inventario
    public ControladorInventario() {
                
    }

    // 3. ACCIÓN 1: Agregar un producto (AHORA DIRECTO A LA BASE DE DATOS)
    public void agregarProducto(Producto nuevoProducto) {
        // 1. Usamos tu llave maestra para abrir la puerta de XAMPP
        ConexionDB con = new ConexionDB();
        Connection conexionApertura = con.establecerConexion();
        
        // 2. Preparamos la instrucción SQL (Fíjate que no mandamos el ID porque XAMPP lo crea automático)
        String sql = "INSERT INTO productos (nombre, categoria, precio, cantidad) VALUES (?, ?, ?, ?)";
        
        try {
            // 3. Empacamos los datos en la instrucción
            PreparedStatement pst = conexionApertura.prepareStatement(sql);
            pst.setString(1, nuevoProducto.getNombre());
            pst.setString(2, nuevoProducto.getCategoria());
            pst.setDouble(3, nuevoProducto.getPrecio());
            pst.setInt(4, nuevoProducto.getCantidad());
            
            // 4. ¡Disparamos la instrucción hacia MySQL!
            pst.executeUpdate();
            System.out.println("¡Éxito! Producto guardado en la Base de Datos de Mi Raquelita.");
            
            // --- CERRANDO LAS PUERTAS ---
            pst.close();
            conexionApertura.close();
            
        } catch (SQLException e) {
            // Si algo sale mal, el escudo lo atrapa
            System.out.println("Error al guardar en la Base de Datos: " + e.toString());
        }
    }

    // 4. ACCIÓN 2: La orden para pedirle al programa que nos muestre todo lo guardado
    public ArrayList<Producto> obtenerTodosLosProductos() {
        ArrayList<Producto> listaLocal = new ArrayList<>(); // Un cajón temporal
        ConexionDB con = new ConexionDB();
        Connection conexion = con.establecerConexion();
        String sql = "SELECT * FROM productos"; // "Seleccionar todo de la tabla productos"

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
                listaLocal.add(p); // Los metemos al cajón temporal
            }
            
            // --- CERRANDO LAS PUERTAS ---
            rs.close();
            pst.close();
            conexion.close();
            
        } catch (SQLException e) {
            System.out.println("Error al traer los datos: " + e.toString());
        }
        return listaLocal; // Le entregamos la lista llena a la tabla
    }
    
    
    // 5. ACCIÓN 3: Modificar un producto existente
    public void modificarProducto(int idBuscado, String nuevoNombre, String nuevaCategoria, double nuevoPrecio, int nuevaCantidad) {
        ConexionDB con = new ConexionDB();
        Connection conexion = con.establecerConexion();
        // Le decimos a XAMPP: "Actualiza el producto donde el ID sea el que yo te diga"
        String sql = "UPDATE productos SET nombre=?, categoria=?, precio=?, cantidad=? WHERE id=?";

        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, nuevoNombre);
            pst.setString(2, nuevaCategoria);
            pst.setString(3, String.valueOf(nuevoPrecio));
            pst.setInt(4, nuevaCantidad);
            pst.setInt(5, idBuscado); // El ID es el candado para saber cuál cambiar

            pst.executeUpdate();
            System.out.println("¡Éxito! Producto actualizado en la Base de Datos.");
            
            // --- CERRANDO LAS PUERTAS ---
            pst.close();
            conexion.close();
            
        } catch (SQLException e) {
            System.out.println("Error al modificar: " + e.toString());
        }
    }
    
    // 6. ACCIÓN 4: Eliminar un producto de la memoria
    public void eliminarProducto(int idBuscado) {
       ConexionDB con = new ConexionDB();
        Connection conexion = con.establecerConexion();
        String sql = "DELETE FROM productos WHERE id=?"; // "Borra el producto con este ID"

        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, idBuscado);
            pst.executeUpdate();
            System.out.println("¡Éxito! Producto borrado de la Base de Datos.");
            
            // --- CERRANDO LAS PUERTAS ---
            pst.close();
            conexion.close();
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.toString());
        }
    }
    
}