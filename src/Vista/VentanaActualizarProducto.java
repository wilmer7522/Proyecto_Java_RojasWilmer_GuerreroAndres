package Vista;

import Modelo.ProductoDAO;
import Modelo.Productos;
import javax.swing.*;
import java.awt.*;

public class VentanaActualizarProducto extends JFrame {
    private ProductoDAO productoDAO;
    private JFrame menuAnterior;

    public VentanaActualizarProducto(JFrame menuAnterior) {
        this.menuAnterior = menuAnterior;

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

        // Acción de buscar producto
        btnBuscar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                Productos producto = productoDAO.buscarProductoPorId(id);

                if (producto != null) {
                    txtNombre.setText(producto.getNombre());
                    txtTipo.setText(producto.getTipo());
                    txtFabricante.setText(producto.getFabricante());
                    txtCantidad.setText(String.valueOf(producto.getCantidad_stock()));
                    txtVencimiento.setText(producto.getFecha_vencimiento());
                    txtProveedor.setText(String.valueOf(producto.getProveedor_id()));

                    txtId.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID válido (número entero)", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción de actualizar producto
        btnActualizar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                String nombre = txtNombre.getText().trim();
                String tipo = txtTipo.getText().trim();
                String fabricante = txtFabricante.getText().trim();
                int cantidad = Integer.parseInt(txtCantidad.getText().trim());
                String vencimiento = txtVencimiento.getText().trim();
                int proveedor = Integer.parseInt(txtProveedor.getText().trim());

                Productos producto = new Productos(id, nombre, tipo, fabricante, cantidad, vencimiento, proveedor);

                if (productoDAO.actualizarProductos(producto)) {
                    JOptionPane.showMessageDialog(this, "Producto actualizado correctamente");
                    dispose();
                    if (menuAnterior != null) {
                        menuAnterior.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el producto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese valores numéricos en Cantidad y Proveedor ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnVolver.addActionListener(e -> {
            dispose();
            if (menuAnterior != null) {
                menuAnterior.setVisible(true);
            }
        });

        setVisible(true);
    }
}