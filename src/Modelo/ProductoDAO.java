package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public boolean insertarProductos(Productos productos) {
        String sql = "INSERT INTO inventario (nombre, tipo, fabricante, cantidad_stock, fecha_vencimiento, proveedor_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, productos.getNombre());
            stmt.setString(2, productos.getTipo());
            stmt.setString(3, productos.getFabricante());
            stmt.setInt(4, productos.getCantidad_stock());
            stmt.setString(5, productos.getFecha_vencimiento());
            stmt.setInt(6, productos.getProveedor_id());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Productos> obtenerProductos() {
        List<Productos> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM inventario";

        try (Connection conn = ConexionDB.getConnection();
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

                listaProductos.add(new Productos(id, nombre, tipo, fabricante, cantidad_stock, fecha_vencimiento, proveedor_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProductos;
    }

    public boolean actualizarProductos(Productos producto) {
        String sql = "UPDATE inventario SET nombre = ?, tipo = ?, fabricante = ?, cantidad_stock = ?, fecha_vencimiento = ?, proveedor_id = ? WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getTipo());
            stmt.setString(3, producto.getFabricante());
            stmt.setInt(4, producto.getCantidad_stock());
            stmt.setString(5, producto.getFecha_vencimiento());
            stmt.setInt(6, producto.getProveedor_id());
            stmt.setInt(7, producto.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM inventario WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Productos buscarProductoPorId(int id) {
        String sql = "SELECT * FROM inventario WHERE id = ?";
        Productos producto = null;

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = new Productos(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("tipo"),
                            rs.getString("fabricante"),
                            rs.getInt("cantidad_stock"),
                            rs.getString("fecha_vencimiento"),
                            rs.getInt("proveedor_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }
}
