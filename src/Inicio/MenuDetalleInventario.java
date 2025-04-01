package Inicio;

import Modelo.ConexionDB;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class MenuDetalleInventario extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private Connection conn;

    public MenuDetalleInventario() {
        setTitle("Menu Detalle Inventario Factura");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        conn = ConexionDB.getConnection();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Factura ID", "Inventario ID", "Cantidad", "Precio Unitario", "Subtotal"});
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton btnVer = new JButton("Ver Detalles");
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
             ResultSet rs = stmt.executeQuery("SELECT * FROM detalle_inventario_factura")) {
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getInt("factura_id"),
                        rs.getInt("inventario_id"),
                        rs.getInt("cantidad"),
                        rs.getBigDecimal("precio_unitario"),
                        rs.getBigDecimal("subtotal")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
        }
    }
}