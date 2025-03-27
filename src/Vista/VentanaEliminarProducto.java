package Vista;

import Modelo.ProductoDAO;

import javax.swing.*;
import java.awt.*;

public class VentanaEliminarProducto extends JFrame {
    public VentanaEliminarProducto(JFrame menuAnterior) {
        setTitle("Eliminar Producto");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        JTextField txtId = new JTextField();
        add(new JLabel("ID del Producto:"));
        add(txtId);

        JButton btnEliminar = new JButton("Eliminar");
        JButton btnVolver = new JButton("Volver");

        btnEliminar.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            ProductoDAO productoDAO = new ProductoDAO();

            if (productoDAO.eliminarProducto(id)) {
                JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnVolver.addActionListener(e -> {
            dispose();
            menuAnterior.setVisible(true);
        });

        add(btnEliminar);
        add(btnVolver);
        setVisible(true);
    }
}