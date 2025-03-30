package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    private Connection conexion;

    public ProveedorDAO() {
        conectar();
    }

    private void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn", "ue1oyjioflexxw8f", "RSMHhaXROhzgve0aR7Jb");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Proveedor> obtenerProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";

        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                proveedores.add(new Proveedor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("contacto"),
                        rs.getString("direccion")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedores;
    }

    public void insertarProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedores (nombre, contacto, direccion) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getContacto());
            stmt.setString(3, proveedor.getDireccion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProveedor(Proveedor proveedor) {
        String sql = "UPDATE proveedores SET nombre = ?, contacto = ?, direccion = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getContacto());
            stmt.setString(3, proveedor.getDireccion());
            stmt.setInt(4, proveedor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProveedor(int id) {
        String sql = "DELETE FROM proveedores WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}