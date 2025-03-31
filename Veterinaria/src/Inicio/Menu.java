package Inicio;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    public Menu() {
        setTitle("Menu");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        // Botones para acceder a los diferentes menús
        JButton btnDuenos = new JButton("Dueños");
        JButton btnCentroVet = new JButton("Centro Veterinario");
        JButton btnProductos = new JButton("Productos");
        JButton btnProcedimientos = new JButton("Procedimientos");
        JButton btnReportes = new JButton("Reportes");
        JButton btnMenuPrincipal = new JButton("Menu Principal");
        JButton btnSalir = new JButton("Salir");

        btnProductos.addActionListener(e -> {
            dispose();
            new MenuProductos();
        });

        btnProcedimientos.addActionListener(e -> {
            dispose();
            new MenuProcedimientos(this);
        });

        btnReportes.addActionListener(e -> {
            dispose();
            new MenuReportes(this);
        });

        btnMenuPrincipal.addActionListener(e -> {
            dispose();
            new MenuPrincipal();
        });

        btnSalir.addActionListener(e -> {
            System.exit(0);
        });

        add(btnCentroVet);
        add(btnProductos);
        add(btnProcedimientos);
        add(btnReportes);
        add(btnMenuPrincipal);
        add(btnSalir);

        setVisible(true);
    }
}