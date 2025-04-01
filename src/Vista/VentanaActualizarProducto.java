package Vista;

import Inicio.MenuProductos;
import Modelo.ProductoDAO;
import Modelo.Productos;

import javax.swing.*;
import java.awt.*;

public class VentanaActualizarProducto extends JFrame {
    private JTextField txtId, txtNombre, txtTipo, txtFabricante, txtStock, txtFechaVenc, txtProveedor;
    private ProductoDAO productoDAO;
    private MenuProductos menu;

    public VentanaActualizarProducto(MenuProductos menu) {
        this.menu = menu;
        this.productoDAO = new ProductoDAO();

        setTitle("Actualizar Producto");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("ID del producto:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Tipo:"));
        txtTipo = new JTextField();
        add(txtTipo);

        add(new JLabel("Fabricante:"));
        txtFabricante = new JTextField();
        add(txtFabricante);

        add(new JLabel("Stock:"));
        txtStock = new JTextField();
        add(txtStock);

        add(new JLabel("Fecha de Vencimiento:"));
        txtFechaVenc = new JTextField();
        add(txtFechaVenc);

        add(new JLabel("Proveedor ID:"));
        txtProveedor = new JTextField();
        add(txtProveedor);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> actualizarProducto());
        add(btnActualizar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        add(btnCancelar);

        setVisible(true);
    }

    private void actualizarProducto() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            String tipo = txtTipo.getText();
            String fabricante = txtFabricante.getText();
            int stock = Integer.parseInt(txtStock.getText());
            String fechaVenc = txtFechaVenc.getText();
            int proveedor = Integer.parseInt(txtProveedor.getText());

            Productos producto = new Productos(id, nombre, tipo, fabricante, stock, fechaVenc, proveedor);
            boolean actualizado = productoDAO.actualizarProductos(producto);

            if (actualizado) {
                JOptionPane.showMessageDialog(this, "Producto actualizado exitosamente.");
                menu.actualizarListaProductos();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el producto.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados.");
        }
    }
}