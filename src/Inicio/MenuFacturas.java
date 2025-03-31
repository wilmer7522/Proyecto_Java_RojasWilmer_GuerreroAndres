package Inicio;

import Modelo.Factura;
import Modelo.FacturaDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MenuFacturas extends JFrame {

    private JTextField txtBuscarId;
    private JButton btnBuscar, btnCargarTodos, btnSalir;
    private JTable tablaFacturas;
    private DefaultTableModel modeloTabla;
    private FacturaDAO dao;

    public MenuFacturas() {
        dao = new FacturaDAO();

        setTitle("Gestion de Factura");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());

        txtBuscarId = new JTextField(10);
        btnBuscar = new JButton("Buscar por ID");
        btnCargarTodos = new JButton("Ver Todos");
        btnSalir = new JButton("Salir");

        panelSuperior.add(new JLabel("ID Factura:"));
        panelSuperior.add(txtBuscarId);
        panelSuperior.add(btnBuscar);
        panelSuperior.add(btnCargarTodos);
        panelSuperior.add(btnSalir);

        add(panelSuperior, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"ID", "fecha", "dueno_id", "total", "cufe", "codigoqr"});

        tablaFacturas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaFacturas);
        add(scrollPane, BorderLayout.CENTER);

        btnBuscar.addActionListener(e -> buscarPorId());
        btnCargarTodos.addActionListener(e -> cargarTodos());
        btnSalir.addActionListener(e -> salirAlMenuPrincipal());

        setVisible(true);
    }

    private void buscarPorId() {
        modeloTabla.setRowCount(0);
        try {
            int id = Integer.parseInt(txtBuscarId.getText());
            Factura factura = dao.buscarPorId(id);

            if (factura != null) {
                modeloTabla.addRow(new Object[]{
                        factura.getId(),
                        factura.getFecha(),
                        factura.getDueno_id(),
                        factura.getTotal(),
                        factura.getCufe(),
                        factura.getCodigo_qr()
                });
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro la factura con ID: " + id);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID valido");
        }
    }

    private void cargarTodos() {
        modeloTabla.setRowCount(0);
        List<Factura> facturas = dao.obtenerTodos();
        for (Factura d : facturas) {
            modeloTabla.addRow(new Object[]{
                    d.getId(),
                    d.getFecha(),
                    d.getDueno_id(),
                    d.getTotal(),
                    d.getCufe(),
                    d.getCodigo_qr()
            });
        }
    }

    private void salirAlMenuPrincipal() {
        dispose();
    }
}