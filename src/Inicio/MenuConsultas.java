package Inicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class MenuConsultas extends JFrame {
    public MenuConsultas(MenuPrincipal menuPrincipal) {
        setTitle("Gestión de Consultas Médicas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        JButton btnVer = new JButton("Ver Consultas");
        JButton btnVolver = new JButton("Volver");

        btnVer.addActionListener(e -> mostrarConsultas());
        btnVolver.addActionListener(e -> dispose());

        add(btnVer);
        add(btnVolver);

        setVisible(true);
    }

    private void mostrarConsultas() {
        JFrame frame = new JFrame("Lista de Consultas Medicas");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        String[] columnas = {"ID", "Fecha y Hora", "Mascota", "Dueño", "Veterinario", "Estado", "Diagnóstico", "Prescripción"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modelo);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn", "ue1oyjioflexxw8f", "RSMHhaXROhzgve0aR7Jb");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT cm.id, cm.fecha_hora, m.nombre AS mascota, d.nombre AS dueño, v.nombre AS veterinario, cm.estado, cm.diagnostico, cm.prescripcion_medica FROM consultas_medicas cm JOIN mascotas m ON cm.mascota_id = m.id JOIN duenos d ON cm.dueno_id = d.id JOIN veterinarios v ON cm.veterinario_id = v.id ORDER BY cm.fecha_hora DESC")) {

            while (rs.next()) {
                Object[] fila = {
                        rs.getInt("id"),
                        rs.getTimestamp("fecha_hora"),
                        rs.getString("mascota"),
                        rs.getString("dueño"),
                        rs.getString("veterinario"),
                        rs.getString("estado"),
                        rs.getString("diagnostico"),
                        rs.getString("prescripcion_medica")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener las consultas médicas", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JScrollPane scrollPane = new JScrollPane(tabla);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}