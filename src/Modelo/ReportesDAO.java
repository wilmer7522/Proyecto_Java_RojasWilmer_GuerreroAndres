package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReportesDAO {

    public int obtenerTotalVisitas() {
        String sql = "SELECT COUNT(*) FROM citas_medicas";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int obtenerTotalProcedimientos() {
        String sql = "SELECT COUNT(*) FROM procedimientos_medicos";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int obtenerTotalVacunas() {
        String sql = "SELECT COUNT(*) FROM vacunas";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double obtenerTotalFacturacion() {
        String sql = "SELECT SUM(total) FROM facturas";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public List<String> obtenerServiciosMasSolicitados() {
        List<String> servicios = new ArrayList<>();
        String sql = "SELECT servicio_producto, COUNT(*) AS cantidad " +
                "FROM detalles_factura " +
                "GROUP BY servicio_producto " +
                "ORDER BY cantidad DESC";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                servicios.add(rs.getString("servicio_producto") + " - " + rs.getInt("cantidad") + " veces");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return servicios;
    }

    public List<String> obtenerDesempenoVeterinarios() {
        List<String> desempeno = new ArrayList<>();
        String sql = "SELECT v.nombre AS nombre, COUNT(c.id) AS cantidad_consultas " +
                "FROM consultas_medicas c " +
                "JOIN veterinarios v ON c.veterinario_id = v.id " +
                "GROUP BY v.nombre " +
                "ORDER BY cantidad_consultas DESC";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                desempeno.add(rs.getString("nombre") + " - " + rs.getInt("cantidad_consultas") + " consultas");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return desempeno;
    }
}