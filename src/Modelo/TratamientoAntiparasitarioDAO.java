package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TratamientoAntiparasitarioDAO {

    public boolean insertarTratamiento(TratamientoAntiparasitario tratamiento) {
        String sql = "INSERT INTO tratamientos_antiparasitarios (tipo, fecha_aplicacion, fecha_proxima_dosis, mascota_id, inventario_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tratamiento.getTipo());
            stmt.setString(2, tratamiento.getFechaAplicacion());
            stmt.setString(3, tratamiento.getFechaProximaDosis());
            stmt.setInt(4, tratamiento.getMascotaId());
            stmt.setInt(5, tratamiento.getInventarioId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar tratamiento: " + e.getMessage());
            return false;
        }
    }

    public List<TratamientoAntiparasitario> obtenerTratamientos() {
        List<TratamientoAntiparasitario> lista = new ArrayList<>();
        String sql = "SELECT * FROM tratamientos_antiparasitarios";

        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new TratamientoAntiparasitario(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("fecha_aplicacion"),
                        rs.getString("fecha_proxima_dosis"),
                        rs.getInt("mascota_id"),
                        rs.getInt("inventario_id")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener tratamientos: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizarTratamiento(TratamientoAntiparasitario tratamiento) {
        String sql = "UPDATE tratamientos_antiparasitarios SET tipo = ?, fecha_aplicacion = ?, fecha_proxima_dosis = ?, mascota_id = ?, inventario_id = ? WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tratamiento.getTipo());
            stmt.setString(2, tratamiento.getFechaAplicacion());
            stmt.setString(3, tratamiento.getFechaProximaDosis());
            stmt.setInt(4, tratamiento.getMascotaId());
            stmt.setInt(5, tratamiento.getInventarioId());
            stmt.setInt(6, tratamiento.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar tratamiento: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarTratamiento(int id) {
        String sql = "DELETE FROM tratamientos_antiparasitarios WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar tratamiento: " + e.getMessage());
            return false;
        }
    }
}