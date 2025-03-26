package Inicio;

import Controlador.ProductoControlador;
import Controlador.ReportesControlador;
import Modelo.ProductoDAO;
import Vista.ProductosVista;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JLabel lblTitulo = new JLabel("Bienvenido al Sistema", SwingConstants.CENTER);
        JButton btnReportes = new JButton("Ver Reportes");
        JButton btnSalir = new JButton("Salir");

        btnReportes.addActionListener(e -> {
            dispose();
            new ReportesControlador().mostrarReportes();
        });

        btnSalir.addActionListener(e -> System.exit(0));

        add(lblTitulo);
        add(btnReportes);
        add(btnSalir);

        ProductoDAO productoDAO = new ProductoDAO();
        ProductosVista productosVista = new ProductosVista();
        ProductoControlador productoControlador = new ProductoControlador(productoDAO, productosVista);

        productoControlador.iniciar();
    }
}