package Vista;

import Modelo.ProductoDAO;
import Modelo.Productos;
import javax.swing.*;
import java.awt.*;

public class VentanaBuscarProducto extends JFrame {
    public VentanaBuscarProducto(JFrame menuAnterior) {
        setTitle("Buscar Producto");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JTextField txtId = new JTextField();
        JLabel lblResultado = new JLabel();

        add(new JLabel("ID del Producto:"));
        add(txtId);
        add(lblResultado);

        JButton btnBuscar = new JButton("Buscar");
        JButton btnVolver = new JButton("Volver");

        btnBuscar.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            ProductoDAO productoDAO = new ProductoDAO();
            Productos producto = productoDAO.buscarProductoPorId(id);

            if (producto != null) {
                lblResultado.setText("<html>Nombre: " + producto.getNombre() +
                        "<br>Tipo: " + producto.getTipo() +
                        "<br>Fabricante: " + producto.getFabricante() +
                        "<br>Stock: " + producto.getCantidad_stock() +
                        "<br>Vencimiento: " + producto.getFecha_vencimiento() +
                        "<br>Proveedor ID: " + producto.getProveedor_id() + "</html>");
            } else {
                lblResultado.setText("Producto no encontrado.");
            }
        });

        btnVolver.addActionListener(e -> {
            dispose();
            menuAnterior.setVisible(true);
        });

        add(btnBuscar);
        add(btnVolver);
        setVisible(true);
    }
}