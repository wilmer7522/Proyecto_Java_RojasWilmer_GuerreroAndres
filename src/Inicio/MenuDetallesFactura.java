package Inicio;

import Modelo.DetalleFactura;
import Modelo.DetalleFacturaDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MenuDetallesFactura extends JFrame {
    private JTextField txtBuscarId;
    private JButton btnBuscar, btnCargarTodos, btnSalir;
    private JTable tablaDetalles;
    private DefaultTableModel modeloTabla;
    private DetalleFacturaDAO dao;

    public MenuDetallesFactura() {
        dao = new DetalleFacturaDAO();

        setTitle("Gestión de Detalles de Factura");
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
        modeloTabla.setColumnIdentifiers(new String[]{"ID", "Factura ID", "Servicio", "Cantidad", "Precio Unitario", "Subtotal"});

        tablaDetalles = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaDetalles);
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
            DetalleFactura detalle = dao.buscarPorId(id);

            if (detalle != null) {
                modeloTabla.addRow(new Object[]{
                        detalle.getId(),
                        detalle.getFacturaId(),
                        detalle.getServicioProducto(),
                        detalle.getCantidad(),
                        detalle.getPrecioUnitario(),
                        detalle.getSubtotal()
                });
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro el detalle con ID: " + id);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID valido");
        }
    }

    private void cargarTodos() {
        modeloTabla.setRowCount(0);
        List<DetalleFactura> detalles = dao.obtenerTodos();
        for (DetalleFactura d : detalles) {
            modeloTabla.addRow(new Object[]{
                    d.getId(),
                    d.getFacturaId(),
                    d.getServicioProducto(),
                    d.getCantidad(),
                    d.getPrecioUnitario(),
                    d.getSubtotal()
            });
        }
    }

    private void salirAlMenuPrincipal() {
        dispose();
        new MenuPrincipal();
    }
}