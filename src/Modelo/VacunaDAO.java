package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacunaDAO {
    private Connection conexion;

    public VacunaDAO() {
        this.conexion = ConexionDB.getConnection();
    }

    public boolean insertarVacuna(Vacuna vacuna) {
        String sql = "INSERT INTO vacunas (nombre, fabricante, lote, fecha_aplicacion, fecha_vencimiento, mascota_id, inventario_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, vacuna.getNombre());
            stmt.setString(2, vacuna.getFabricante());
            stmt.setString(3, vacuna.getLote());
            stmt.setDate(4, Date.valueOf(vacuna.getFechaAplicacionAsDate())); // Convierte String a Date
            stmt.setDate(5, Date.valueOf(vacuna.getFechaVencimientoAsDate())); // Convierte String a Date
            stmt.setInt(6, vacuna.getMascotaId());
            stmt.setInt(7, vacuna.getInventarioId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarVacuna(Vacuna vacuna) {
        String sql = "UPDATE vacunas SET nombre=?, fabricante=?, lote=?, fecha_aplicacion=?, fecha_vencimiento=?, mascota_id=?, inventario_id=? WHERE id=?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, vacuna.getNombre());
            stmt.setString(2, vacuna.getFabricante());
            stmt.setString(3, vacuna.getLote());
            stmt.setDate(4, Date.valueOf(vacuna.getFechaAplicacionAsDate()));
            stmt.setDate(5, Date.valueOf(vacuna.getFechaVencimientoAsDate()));
            stmt.setInt(6, vacuna.getMascotaId());
            stmt.setInt(7, vacuna.getInventarioId());
            stmt.setInt(8, vacuna.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarVacuna(int id) {
        String sql = "DELETE FROM vacunas WHERE id=?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Vacuna> obtenerVacunas() {
        List<Vacuna> lista = new ArrayList<>();
        String sql = "SELECT * FROM vacunas";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vacuna vacuna = new Vacuna(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("fabricante"),
                        rs.getString("lote"),
                        rs.getDate("fecha_aplicacion").toString(),
                        rs.getDate("fecha_vencimiento").toString(),
                        rs.getInt("mascota_id"),
                        rs.getInt("inventario_id")
                );
                lista.add(vacuna);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}