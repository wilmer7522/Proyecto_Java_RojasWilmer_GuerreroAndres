package Modelo;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProcedimientosDAO {
    private static final String URL = "jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn";
    private static final String USUARIO = "ue1oyjioflexxw8f";
    private static final String PASSWORD = "RSMHhaXROhzgve0aR7Jb";

    public void mostrarProcedimientos() {
        JFrame frame = new JFrame("Lista de Procedimientos Médicos");
        frame.setSize(900, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        String[] columnas = {"ID", "Nombre", "Tipo", "Insumos", "Mascota", "Veterinario", "Fecha", "Observaciones", "Insumo Asociado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modelo);

        String sql = "SELECT pm.id, pm.nombre, pm.tipo, pm.insumos_utilizados, m.nombre AS mascota, " +
                "v.nombre AS veterinario, pm.fecha, pm.observaciones, i.nombre AS insumo " +
                "FROM procedimientos_medicos pm " +
                "JOIN mascotas m ON pm.mascota_id = m.id " +
                "JOIN veterinarios v ON pm.veterinario_id = v.id " +
                "JOIN inventario i ON pm.inventario_id = i.id ";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Object[] fila = {
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getString("insumos_utilizados"),
                        rs.getString("mascota"),
                        rs.getString("veterinario"),
                        rs.getString("fecha"),
                        rs.getString("observaciones"),
                        rs.getString("insumo")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener los procedimientos médicos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JScrollPane scrollPane = new JScrollPane(tabla);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    public boolean insertarProcedimiento(String nombre, String tipo, String insumos, int mascotaId, int veterinarioId, String fecha, String observaciones, int inventarioId) {
        String sql = "INSERT INTO procedimientos_medicos (nombre, tipo, insumos_utilizados, mascota_id, veterinario_id, fecha, observaciones, inventario_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, tipo);
            stmt.setString(3, insumos);
            stmt.setInt(4, mascotaId);
            stmt.setInt(5, veterinarioId);
            stmt.setString(6, fecha);
            stmt.setString(7, observaciones);
            stmt.setInt(8, inventarioId);

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarProcedimiento(int id, String nombre, String tipo, String insumos, int mascotaId, int veterinarioId, String fecha, String observaciones, int inventarioId) {
        String sql = "UPDATE procedimientos_medicos SET nombre = ?, tipo = ?, insumos_utilizados = ?, mascota_id = ?, veterinario_id = ?, fecha = ?, observaciones = ?, inventario_id = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, tipo);
            stmt.setString(3, insumos);
            stmt.setInt(4, mascotaId);
            stmt.setInt(5, veterinarioId);
            stmt.setString(6, fecha);
            stmt.setString(7, observaciones);
            stmt.setInt(8, inventarioId);
            stmt.setInt(9, id);

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProcedimiento(int id) {
        String sql = "DELETE FROM procedimientos_medicos WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int filasEliminadas = stmt.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
