package Vista;

import Modelo.Productos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListarProductos extends JFrame {
    private DefaultTableModel modelo;
    private JTable tablaProductos;

    public VentanaListarProductos(List<Productos> productos) {
        setTitle("Lista de Productos en Inventario");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] columnas = {"ID", "Nombre", "Tipo", "Fabricante", "Stock", "Vence", "Proveedor"};
        modelo = new DefaultTableModel(columnas, 0);
        tablaProductos = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        actualizarTabla(productos);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> dispose());

        add(scrollPane, BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actualizarTabla(List<Productos> productos) {
        if (modelo == null) return;

        modelo.setRowCount(0);
        for (Productos p : productos) {
            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNombre(),
                    p.getTipo(),
                    p.getFabricante(),
                    p.getCantidad_stock(),
                    p.getFecha_vencimiento(),
                    p.getProveedor_id()
            });
        }
    }
}