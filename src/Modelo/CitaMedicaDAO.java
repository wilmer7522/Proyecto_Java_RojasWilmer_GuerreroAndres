package Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaMedicaDAO {
    private static final String URL = "jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn";
    private static final String USUARIO = "ue1oyjioflexxw8f";
    private static final String PASSWORD = "RSMHhaXROhzgve0aR7Jb";

    private Connection conexion;

    private void conectar() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        }
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

    public List<CitaMedica> obtenerCitas() {
        List<CitaMedica> citas = new ArrayList<>();
        String sql = "SELECT cm.id, cm.fecha_hora, cm.mascota_id, m.nombre AS mascota_nombre, " +
                "cm.dueno_id, d.nombre AS dueno_nombre, cm.veterinario_id, cm.estado, " +
                "cm.diagnostico, cm.prescripcion_medica " +
                "FROM consultas_medicas cm " +
                "JOIN mascotas m ON cm.mascota_id = m.id " +
                "JOIN duenos d ON cm.dueno_id = d.id";

        try {
            conectar();
            try (PreparedStatement stmt = conexion.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    CitaMedica cita = new CitaMedica(
                            rs.getInt("id"),
                            rs.getTimestamp("fecha_hora"),
                            rs.getInt("mascota_id"),
                            rs.getInt("dueno_id"),
                            rs.getInt("veterinario_id"),
                            rs.getString("estado"),
                            rs.getString("diagnostico"),
                            rs.getString("prescripcion_medica")
                    );
                    cita.setNombreMascota(rs.getString("mascota_nombre"));
                    cita.setNombreDueno(rs.getString("dueno_nombre"));

                    citas.add(cita);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return citas;
    }

    public boolean insertarCita(CitaMedica cita) {
        String sql = "INSERT INTO consultas_medicas (fecha_hora, mascota_id, dueno_id, veterinario_id, estado, diagnostico, prescripcion_medica) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            conectar();
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setTimestamp(1, new Timestamp(cita.getFechaHora().getTime()));
                stmt.setInt(2, cita.getMascotaId());
                stmt.setInt(3, cita.getDuenoId());
                stmt.setInt(4, cita.getVeterinarioId());
                stmt.setString(5, cita.getEstado());
                stmt.setString(6, cita.getDiagnostico());
                stmt.setString(7, cita.getPrescripcion());

                return stmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            cerrarConexion();
        }
    }

    public boolean actualizarCita(CitaMedica cita) {
        String sql = "UPDATE consultas_medicas SET fecha_hora = ?, mascota_id = ?, dueno_id = ?, veterinario_id = ?, estado = ?, diagnostico = ?, prescripcion_medica = ? WHERE id = ?";

        try {
            conectar();
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setTimestamp(1, new Timestamp(cita.getFechaHora().getTime()));
                stmt.setInt(2, cita.getMascotaId());
                stmt.setInt(3, cita.getDuenoId());
                stmt.setInt(4, cita.getVeterinarioId());
                stmt.setString(5, cita.getEstado());
                stmt.setString(6, cita.getDiagnostico());
                stmt.setString(7, cita.getPrescripcion());
                stmt.setInt(8, cita.getId());

                return stmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            cerrarConexion();
        }
    }

    public boolean eliminarCita(int id) {
        String sql = "DELETE FROM consultas_medicas WHERE id = ?";

        try {
            conectar();
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setInt(1, id);
                return stmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            cerrarConexion();
        }
    }
}