package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    private final Connection conexion;

    public FacturaDAO() {
        this.conexion = ConexionDB.getConnection();
    }

    public List<Factura> obtenerTodos() {
        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT * FROM facturas";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Factura factura = new Factura(
                        rs.getInt("id"),
                        rs.getString("fecha"),
                        rs.getInt("dueno_id"),
                        rs.getBigDecimal("total"),
                        rs.getString("cufe"),
                        rs.getString("codigo_qr")
                );
                lista.add(factura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Factura buscarPorId(int id) {
        String sql = "SELECT * FROM facturas WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Factura(
                        rs.getInt("id"),
                        rs.getString("fecha"),
                        rs.getInt("dueno_id"),
                        rs.getBigDecimal("total"),
                        rs.getString("cufe"),
                        rs.getString("codigo_qr")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}