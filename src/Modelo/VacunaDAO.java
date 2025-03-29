package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacunaDAO {
    private Connection conexion;

    private void conectar() throws SQLException {
        String url = "jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn";
        String usuario = "ue1oyjioflexxw8f";
        String contrasena = "RSMHhaXROhzgve0aR7Jb";
        conexion = DriverManager.getConnection(url, usuario, contrasena);
    }

    private void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarVacuna(Vacuna vacuna) {
        String sql = "INSERT INTO vacunas (nombre, fabricante, lote, fecha_aplicacion, fecha_vencimiento, mascota_id, inventario_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conectar();
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, vacuna.getNombre());
            stmt.setString(2, vacuna.getFabricante());
            stmt.setString(3, vacuna.getLote());
            stmt.setString(4, vacuna.getFechaAplicacion());
            stmt.setString(5, vacuna.getFechaVencimiento());
            stmt.setInt(6, vacuna.getMascotaId());
            stmt.setInt(7, vacuna.getInventarioId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public List<Vacuna> obtenerVacunas() {
        List<Vacuna> vacunas = new ArrayList<>();
        String sql = "SELECT * FROM vacunas";
        try {
            conectar();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vacuna vacuna = new Vacuna(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("fabricante"),
                        rs.getString("lote"),
                        rs.getString("fecha_aplicacion"),
                        rs.getString("fecha_vencimiento"),
                        rs.getInt("mascota_id"),
                        rs.getInt("inventario_id")
                );
                vacunas.add(vacuna);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return vacunas;
    }

    public Vacuna obtenerPorId(int id) {
        String sql = "SELECT * FROM vacunas WHERE id = ?";
        try {
            conectar();
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Vacuna(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("fabricante"),
                        rs.getString("lote"),
                        rs.getString("fecha_aplicacion"),
                        rs.getString("fecha_vencimiento"),
                        rs.getInt("mascota_id"),
                        rs.getInt("inventario_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return null;
    }

    public void actualizarVacuna(Vacuna vacuna) {
        String sql = "UPDATE vacunas SET nombre=?, fabricante=?, lote=?, fecha_aplicacion=?, fecha_vencimiento=?, mascota_id=?, inventario_id=? WHERE id=?";
        try {
            conectar();
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, vacuna.getNombre());
            stmt.setString(2, vacuna.getFabricante());
            stmt.setString(3, vacuna.getLote());
            stmt.setString(4, vacuna.getFechaAplicacion());
            stmt.setString(5, vacuna.getFechaVencimiento());
            stmt.setInt(6, vacuna.getMascotaId());
            stmt.setInt(7, vacuna.getInventarioId());
            stmt.setInt(8, vacuna.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void eliminarVacuna(int id) {
        String sql = "DELETE FROM vacunas WHERE id = ?";
        try {
            conectar();
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }
}