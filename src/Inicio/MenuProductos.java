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
        JButton btnVolver = new JButton("Volver");

        ventanaListarProductos = new VentanaListarProductos(productoDAO.obtenerProductos());

        btnVerProductos.addActionListener(e ->{
            List<Productos> productos = ProductoDAO.obtenerProductos();
            new VentanaListarProductos(productos);
        });

        btnAgregarProductos.addActionListener(e ->
                new VentanaAgregarProducto(this, ventanaListarProductos)
        );

        btnActualizarProductos.addActionListener(e ->
                ventanaListarProductos.actualizarTabla(productoDAO.obtenerProductos())
        );

        btnVolver.addActionListener(e -> {
            dispose();
            setVisible(true);
        });

        add(btnVerProductos);
        add(btnAgregarProductos);
        add(btnActualizarProductos);
        add(btnEliminarProductos);
        add(btnVolver);
        setVisible(true);
    }
}