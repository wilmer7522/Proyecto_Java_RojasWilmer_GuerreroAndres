package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DuenoDAO {
    private String URL = "jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn";
    private String USUARIO = "ue1oyjioflexxw8f";
    private String PASSWORD = "RSMHhaXROhzgve0aR7Jb";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    public boolean insertarProductos(Productos productos) {
        String sql = "INSERT INTO inventario (nombre, tipo, fabricante, cantidad_stock, fecha_vencimiento, proveedor_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, productos.getNombre());
            stmt.setString(2, productos.getTipo());
            stmt.setString(3, productos.getFabricante());
            stmt.setInt(4, productos.getCantidad_stock());
            stmt.setString(5, productos.getFecha_vencimiento());
            stmt.setInt(6, productos.getProveedor_id());

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Productos> obtenerProductos() {
        List<Productos> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM inventario";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String fabricante = rs.getString("fabricante");
                int cantidad_stock = rs.getInt("cantidad_stock");
                String fecha_vencimiento = rs.getString("fecha_vencimiento");
                int proveedor_id = rs.getInt("proveedor_id");

                Productos productos = new Productos(id, nombre, tipo, fabricante, cantidad_stock, fecha_vencimiento, proveedor_id);
                listaProductos.add(productos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProductos;
    }

    public boolean actualizarProductos(Productos dueno) {
        String sql = "UPDATE inventario SET nombre = ?, tipo = ?, fabricante = ?, cantidad_stock = ?, fecha_vencimiento = ?, proveedor = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dueno.getNombre());
            stmt.setString(2, dueno.getTipo());
            stmt.setString(3, dueno.getFabricante());
            stmt.setString(4, String.valueOf(dueno.getCantidad_stock()));
            stmt.setString(5, String.valueOf(dueno.getFecha_vencimiento()));
            stmt.setInt(6, dueno.getProveedor_id());
            stmt.setInt(7, dueno.getId());

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM inventario WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Productos buscarProductoPorId(int id){
        String sql = "SELECT * FROM inventario WHERE id = ?";
        Productos producto = null;

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int productoId = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String fabricante = rs.getString("fabricante");
                int cantidad_stock = rs.getInt("cantidad_stock");
                String fecha_vencimiento = rs.getString("fecha_vencimiento");
                int proveedor_id = rs.getInt("proveedor_id");

                producto = new Productos(productoId, nombre, tipo, fabricante, cantidad_stock, fecha_vencimiento, proveedor_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }
}