package Inicio;

import Vista.*;

import javax.swing.*;
import java.awt.*;

public class MenuProductos extends JFrame {
    public MenuProductos(JFrame menuAnterior) {
        setTitle("Gestión de Productos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JButton btnAgregar = new JButton("Agregar Producto");
        JButton btnListar = new JButton("Listar Productos");
        JButton btnBuscar = new JButton("Buscar Producto");
        JButton btnActualizar = new JButton("Actualizar Producto");
        JButton btnEliminar = new JButton("Eliminar Producto");
        JButton btnVolver = new JButton("Volver");

        btnAgregar.addActionListener(e -> {
            dispose();
            new VentanaAgregarProducto(this);
        });

        btnListar.addActionListener(e -> {
            dispose();
            new VentanaListarProductos(this);
        });

        btnBuscar.addActionListener(e -> {
            dispose();
            new VentanaBuscarProducto(this);
        });

        btnActualizar.addActionListener(e -> {
            dispose();
            new VentanaActualizarProducto(this);
        });

        btnEliminar.addActionListener(e -> {
            dispose();
            new VentanaEliminarProducto(this);
        });

        btnVolver.addActionListener(e -> {
            dispose();
            menuAnterior.setVisible(true);
        });

        add(btnAgregar);
        add(btnListar);
        add(btnBuscar);
        add(btnActualizar);
        add(btnEliminar);
        add(btnVolver);

        setVisible(true);
    }
}