package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleFacturaDAO {
    private final Connection conexion;

    public DetalleFacturaDAO() {
        this.conexion = ConexionDB.getConnection();
    }

    public List<DetalleFactura> obtenerTodos() {
        List<DetalleFactura> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalles_factura";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                DetalleFactura detalle = new DetalleFactura(
                        rs.getInt("id"),
                        rs.getInt("factura_id"),
                        rs.getString("servicio_producto"),
                        rs.getInt("cantidad"),
                        rs.getBigDecimal("precio_unitario"),
                        rs.getBigDecimal("subtotal")
                );
                lista.add(detalle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public DetalleFactura buscarPorId(int id) {
        String sql = "SELECT * FROM detalles_factura WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new DetalleFactura(
                        rs.getInt("id"),
                        rs.getInt("factura_id"),
                        rs.getString("servicio_producto"),
                        rs.getInt("cantidad"),
                        rs.getBigDecimal("precio_unitario"),
                        rs.getBigDecimal("subtotal")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}