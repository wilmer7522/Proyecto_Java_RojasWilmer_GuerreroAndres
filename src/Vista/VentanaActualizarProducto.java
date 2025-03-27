package Vista;

import Modelo.ProductoDAO;
import Modelo.Productos;

import javax.swing.*;
import java.awt.*;

public class VentanaActualizarProducto extends JFrame {
    public VentanaActualizarProducto(JFrame menuAnterior) {
        setTitle("Actualizar Producto");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        JTextField txtId = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtTipo = new JTextField();
        JTextField txtFabricante = new JTextField();
        JTextField txtCantidad = new JTextField();
        JTextField txtVencimiento = new JTextField();
        JTextField txtProveedor = new JTextField();

        JButton btnBuscar = new JButton("Buscar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnVolver = new JButton("Volver");

        add(new JLabel("ID del Producto:"));
        add(txtId);
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
        add(btnBuscar);
        add(btnActualizar);
        add(btnVolver);

        btnBuscar.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            ProductoDAO productoDAO = new ProductoDAO();
            Productos producto = productoDAO.buscarProductoPorId(id);

            if (producto != null) {
                txtNombre.setText(producto.getNombre());
                txtTipo.setText(producto.getTipo());
                txtFabricante.setText(producto.getFabricante());
                txtCantidad.setText(String.valueOf(producto.getCantidad_stock()));
                txtVencimiento.setText(producto.getFecha_vencimiento());
                txtProveedor.setText(String.valueOf(producto.getProveedor_id()));
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnActualizar.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            ProductoDAO productoDAO = new ProductoDAO();

            Productos producto = new Productos(
                    id,
                    txtNombre.getText(),
                    txtTipo.getText(),
                    txtFabricante.getText(),
                    Integer.parseInt(txtCantidad.getText()),
                    txtVencimiento.getText(),
                    Integer.parseInt(txtProveedor.getText())
            );

            if (productoDAO.actualizarProductos(producto)) {
                JOptionPane.showMessageDialog(this, "Producto actualizado correctamente");
                dispose();
                menuAnterior.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el producto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnVolver.addActionListener(e -> {
            dispose();
            menuAnterior.setVisible(true);
        });

        setVisible(true);
    }
}
