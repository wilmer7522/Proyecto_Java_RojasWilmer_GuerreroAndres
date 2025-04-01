package Inicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class MenuClientesFrecuentes extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private Connection conn;

    public MenuClientesFrecuentes() {
        setTitle("Clientes Frecuentes");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Cedula");
        model.addColumn("Beneficio");
        model.addColumn("Direccion");
        model.addColumn("Correo");
        model.addColumn("Contacto Emergencia");

        JButton btnActualizar = new JButton("Actualizar");
        JButton btnVolver = new JButton("Volver");

        btnActualizar.addActionListener(e -> cargarDatos());
        btnVolver.addActionListener(e -> abrirMenuPrincipal());

        JPanel panel = new JPanel();
        panel.add(btnActualizar);
        panel.add(btnVolver);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        conectarBaseDatos();
        cargarDatos();
    }

    private void conectarBaseDatos() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn", "ue1oyjioflexxw8f", "RSMHhaXROhzgve0aR7Jb");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de conexion: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatos() {
        model.setRowCount(0);
        String query = """
                SELECT cf.id, d.nombre, d.cedula, cf.beneficio, d.direccion, d.correo_electronico, d.contacto_emergencia
                FROM clientes_frecuentes cf
                JOIN duenos d ON d.id = cf.dueno_id;
                """;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                model.addRow(new Object[] {
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("cedula"),
                        rs.getString("beneficio"),
                        rs.getString("direccion"),
                        rs.getString("correo_electronico"),
                        rs.getString("contacto_emergencia")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirMenuPrincipal() {
        this.dispose();
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
    }
}