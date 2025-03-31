package Inicio;

import Modelo.ProductoDAO;
import Modelo.Productos;
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
        setLayout(new GridLayout(6, 1));

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
            } else {
                ventanaListarProductos.setVisible(true);
            }
        });

        btnAgregarProductos.addActionListener(e ->
                new VentanaAgregarProducto(this, ventanaListarProductos)
        );

        btnActualizarProductos.addActionListener(e -> {
            if (ventanaListarProductos != null) {
                ventanaListarProductos.actualizarTabla(productoDAO.obtenerProductos());
            } else {
                System.err.println("No se puede agregar productos");
            }
        });

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
}