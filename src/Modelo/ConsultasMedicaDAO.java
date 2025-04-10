package Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultasMedicaDAO {
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

    public List<ConsultasMedica> obtenerConsultas() {
        List<ConsultasMedica> Consultas = new ArrayList<>();
        String sql = "SELECT cm.id, cm.fecha_hora, m.nombre AS mascota_nombre, d.nombre AS dueno_nombre, " +
                "v.nombre AS veterinario_nombre, cm.estado, cm.diagnostico, cm.prescripcion_medica " +
                "FROM consultas_medicas cm " +
                "JOIN mascotas m ON cm.mascota_id = m.id " +
                "JOIN duenos d ON cm.dueno_id = d.id " +
                "JOIN veterinarios v ON cm.veterinario_id = v.id";

        try {
            conectar();
            try (PreparedStatement stmt = conexion.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    ConsultasMedica consulta = new ConsultasMedica(
                            rs.getInt("id"),
                            rs.getString("fecha_hora"),
                            rs.getString("mascota_nombre"),
                            rs.getString("dueno_nombre"),
                            rs.getString("veterinario_nombre"),
                            rs.getString("estado"),
                            rs.getString("diagnostico"),
                            rs.getString("prescripcion_medica")
                    );

                    Consultas.add(consulta);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Consultas;
    }

    public boolean insertarConsultas(ConsultasMedica consulta) {
        String sql = "INSERT INTO consultas_medicas (fecha_hora, mascota_id, dueno_id, veterinario_id, estado, diagnostico, prescripcion_medica) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            conectar();
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setString(1, consulta.getFechaHora());
                stmt.setString(2, consulta.getMascota());
                stmt.setString(3, consulta.getDueno());
                stmt.setString(4, consulta.getVeterinario());
                stmt.setString(5, consulta.getEstado());
                stmt.setString(6, consulta.getDiagnostico());
                stmt.setString(7, consulta.getPrescripcion());

                return stmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            cerrarConexion();
        }
    }

    public boolean actualizarConsultas(ConsultasMedica Consulta) {
        String sql = "UPDATE consultas_medicas SET fecha_hora = ?, mascota_id = ?, dueno_id = ?, veterinario_id = ?, estado = ?, diagnostico = ?, prescripcion_medica = ? WHERE id = ?";

        try {
            conectar();
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setString(1, Consulta.getFechaHora());
                stmt.setString(2, Consulta.getMascota());
                stmt.setString(3, Consulta.getDueno());
                stmt.setString(4, Consulta.getVeterinario());
                stmt.setString(5, Consulta.getEstado());
                stmt.setString(6, Consulta.getDiagnostico());
                stmt.setString(7, Consulta.getPrescripcion());
                stmt.setInt(8, Consulta.getId());

                return stmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            cerrarConexion();
        }
    }

    public boolean eliminarConsultas(int id) {
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