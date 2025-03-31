package Inicio;

import Modelo.ProductoDAO;
import Modelo.Productos;
import Vista.VentanaActualizarProducto;
import Vista.VentanaAgregarProducto;
import Vista.VentanaListarProductos;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MenuProductos extends JFrame {
    private ProductoDAO productoDAO;
    private VentanaListarProductos ventanaListarProductos;

    public MenuProductos() {
        productoDAO = new ProductoDAO();

        setTitle("Gestion de Productos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JButton btnVerProductos = new JButton("Ver Productos");
        JButton btnAgregarProductos = new JButton("Agregar Productos");
        JButton btnActualizarProductos = new JButton("Actualizar Productos");
        JButton btnEliminarProductos = new JButton("Eliminar Productos");
        JButton btnSalir = new JButton("Salir");

        List<Productos> productos = productoDAO.obtenerProductos();
        ventanaListarProductos = new VentanaListarProductos(productos);

        btnVerProductos.addActionListener(e -> {
            if (ventanaListarProductos == null) {
                ventanaListarProductos = new VentanaListarProductos(productoDAO.obtenerProductos());
            }
            ventanaListarProductos.setVisible(true);
        });

        btnAgregarProductos.addActionListener(e ->
                new VentanaAgregarProducto(this, ventanaListarProductos)
        );

        btnActualizarProductos.addActionListener(e ->
                new VentanaActualizarProducto(this)
        );

        btnEliminarProductos.addActionListener(e -> eliminarProducto());

        btnSalir.addActionListener(e -> {
            dispose();
            new MenuPrincipal();
        });

        add(btnVerProductos);
        add(btnAgregarProductos);
        add(btnActualizarProductos);
        add(btnEliminarProductos);
        add(btnSalir);
        setVisible(true);
    }

    public void actualizarListaProductos() {
        if (ventanaListarProductos != null) {
            ventanaListarProductos.actualizarTabla(productoDAO.obtenerProductos());
        }
    }

    private void eliminarProducto() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del producto a eliminar:");
        if (idStr != null && !idStr.trim().isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                boolean eliminado = productoDAO.eliminarProducto(id);
                if (eliminado) {
                    JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente.");
                    actualizarListaProductos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el producto");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID invalido");
            }
        }
    }
}