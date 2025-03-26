package Inicio;

import Controlador.ReportesControlador;

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
    }
}