package Vista;

import Modelo.ProductoDAO;
import Modelo.Productos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListarProductos extends JFrame {
    public VentanaListarProductos(JFrame menuAnterior) {
        setTitle("Lista de Productos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Modelo de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Fabricante");
        model.addColumn("Stock");
        model.addColumn("Vencimiento");
        model.addColumn("Proveedor ID");

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Obtener productos desde la base de datos
        ProductoDAO productoDAO = new ProductoDAO();
        List<Productos> productos = productoDAO.obtenerProductos();
        for (Productos producto : productos) {
            model.addRow(new Object[]{
                    producto.getId(),
                    producto.getNombre(),
                    producto.getTipo(),
                    producto.getFabricante(),
                    producto.getCantidad_stock(),
                    producto.getFecha_vencimiento(),
                    producto.getProveedor_id()
            });
        }

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            dispose();
            menuAnterior.setVisible(true);
        });

        add(scrollPane, BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);

        setVisible(true);
    }
}