package Inicio;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal(Menu menu) {
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));

        JLabel lblTitulo = new JLabel("Bienvenido al Sistema", SwingConstants.CENTER);
        JButton btnProductos = new JButton("Gestion de Productos");
        JButton btnReportes = new JButton("Ver Reportes");
        JButton btnConsultas = new JButton("Ver Consultas Medicas");
        JButton btnProcedimientos = new JButton("Ver Cirugias y Procedimientos Especiales");
        JButton btnSalir = new JButton("Salir");

        btnProductos.addActionListener(e -> new MenuProductos(this));
        btnReportes.addActionListener(e -> new MenuReportes(this));
        btnConsultas.addActionListener(e -> new MenuConsultas(this));
        btnProcedimientos.addActionListener(e -> new MenuProcedimientos(this));
        btnSalir.addActionListener(e -> System.exit(0));

        add(lblTitulo);
        add(btnProductos);
        add(btnReportes);
        add(btnConsultas);
        add(btnProcedimientos);
        add(btnSalir);
    }
}