package Vista;

import Modelo.ProductoDAO;
import Modelo.Productos;

import javax.swing.*;
import java.awt.*;

public class VentanaAgregarProducto extends JFrame {
    public VentanaAgregarProducto(JFrame menuAnterior) {
        setTitle("Agregar Producto");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        JTextField txtNombre = new JTextField();
        JTextField txtTipo = new JTextField();
        JTextField txtFabricante = new JTextField();
        JTextField txtCantidad = new JTextField();
        JTextField txtVencimiento = new JTextField();
        JTextField txtProveedor = new JTextField();

        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Tipo:"));
        add(txtTipo);
        add(new JLabel("Fabricante:"));
        add(txtFabricante);
        add(new JLabel("Cantidad Stock:"));
        add(txtCantidad);
        add(new JLabel("Fecha Vencimiento (YYYY-MM-DD):"));
        add(txtVencimiento);
        add(new JLabel("Proveedor ID:"));
        add(txtProveedor);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnVolver = new JButton("Volver");

        btnGuardar.addActionListener(e -> {
            ProductoDAO productoDAO = new ProductoDAO();
            Productos producto = new Productos(
                    0, // ID autogenerado
                    txtNombre.getText(),
                    txtTipo.getText(),
                    txtFabricante.getText(),
                    Integer.parseInt(txtCantidad.getText()),
                    txtVencimiento.getText(),
                    Integer.parseInt(txtProveedor.getText())
            );
            if (productoDAO.insertarProductos(producto)) {
                JOptionPane.showMessageDialog(this, "Producto agregado exitosamente.");
                dispose();
                menuAnterior.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnVolver.addActionListener(e -> {
            dispose();
            menuAnterior.setVisible(true);
        });

        add(btnGuardar);
        add(btnVolver);
        setVisible(true);
    }
}