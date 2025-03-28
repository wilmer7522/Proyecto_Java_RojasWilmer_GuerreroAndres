package Vista;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ReportesVista extends JFrame {
    private JLabel lblVisitas;
    private JLabel lblFacturacion;
    private JButton btnActualizar;
    private JTable tablaServicios;
    private DefaultTableModel modeloTabla;
    private JTextArea txtServicios;

    public ReportesVista() {
        setTitle("Reportes de la Veterinaria");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelSuperior = new JPanel(new GridLayout(2, 1));
        lblVisitas = new JLabel("Total Visitas: ");
        lblFacturacion = new JLabel("Facturacion Total: ");
        panelSuperior.add(lblVisitas);
        panelSuperior.add(lblFacturacion);

        String[] columnas = {"Servicio / Producto", "Cantidad"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaServicios = new JTable(modeloTabla);
        JScrollPane scrollPaneTabla = new JScrollPane(tablaServicios);

        txtServicios = new JTextArea(5, 30);
        txtServicios.setEditable(false);
        JScrollPane scrollPaneTxt = new JScrollPane(txtServicios);

        btnActualizar = new JButton("Revisar Reportes");

        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPaneTxt, BorderLayout.EAST);
        add(btnActualizar, BorderLayout.SOUTH);
    }

    public void mostrarReportes(int totalVisitas, int totalProcedimientos, int totalVacunas, double totalFacturacion, List<String> serviciosMasSolicitados) {
        lblVisitas.setText("Total Visitas: " + totalVisitas);
        lblFacturacion.setText("Facturación Total: $" + totalFacturacion);

        StringBuilder serviciosTexto = new StringBuilder("Servicios Mas Solicitados:\n");
        for (String servicio : serviciosMasSolicitados) {
            serviciosTexto.append("- ").append(servicio).append("\n");
        }
        txtServicios.setText(serviciosTexto.toString());
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }
}