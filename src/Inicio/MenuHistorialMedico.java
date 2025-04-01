package Inicio;

import Modelo.ConexionDB;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class MenuHistorialMedico extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private Connection conn;

    public MenuHistorialMedico() {
        setTitle("Menu Historial Medico");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        conn = ConexionDB.getConnection();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Mascota ID", "Fecha", "Motivo", "Diagnóstico", "Observaciones", "Veterinario ID"});
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton btnVer = new JButton("Ver historial");
        JButton btnSalir = new JButton("Salir");

        btnVer.addActionListener(e -> cargarDatos());
        btnSalir.addActionListener(e -> dispose());

        panelBotones.add(btnVer);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarDatos() {
        model.setRowCount(0);
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM historial_medico")) {
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getInt("mascota_id"),
                        rs.getString("fecha"),
                        rs.getString("motivo"),
                        rs.getString("diagnostico"),
                        rs.getString("observaciones"),
                        rs.getInt("veterinario_id")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
        }
    }
}