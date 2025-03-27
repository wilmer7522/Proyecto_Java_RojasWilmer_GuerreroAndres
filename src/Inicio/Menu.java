package Inicio;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    public Menu() {
        setTitle("Menú Principal");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        // Botones para acceder a los diferentes menus
        JButton btnCentroVet = new JButton("Centro Veterinario");
        JButton btnConsultas = new JButton("Consultas");
        JButton btnProductos = new JButton("Productos");
        JButton btnProcedimientos = new JButton("Procedimientos");
        JButton btnReportes = new JButton("Reportes");
        JButton btnSalir = new JButton("Salir");

        // Accion de los botones para abrir los menus correspondientes
        btnConsultas.addActionListener(e -> {
            dispose();
            new MenuConsultas(this);
        });

        btnProductos.addActionListener(e -> {
            dispose();
            new MenuProductos(this);
        });

        btnProcedimientos.addActionListener(e -> {
            dispose();
            new MenuProcedimientos(this);
        });

        btnReportes.addActionListener(e -> {
            dispose();
            new MenuReportes(this);
        });

        btnSalir.addActionListener(e -> {
            System.exit(0);
        });

        // Agregar los botones a la ventana emergente
        add(btnCentroVet);
        add(btnConsultas);
        add(btnProductos);
        add(btnProcedimientos);
        add(btnReportes);
        add(btnSalir);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Menu();
    }
}
