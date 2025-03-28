package Inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 1));

        JLabel lblTitulo = new JLabel("Bienvenido al Sistema", SwingConstants.CENTER);
        JButton btnProductos = new JButton("Gestion de Productos");
        JButton btnDuenos = new JButton("Gestion de Dueños");
        JButton btnReportes = new JButton("Gestion de Reportes");
        JButton btnProcedimientos = new JButton("Gestion de procedimientos medicos");
        JButton btnCitasMedicas = new JButton("Gestion de Citas medicas");
        JButton btnSalir = new JButton("Salir");

        btnProductos.addActionListener(e -> {
            new MenuProductos();
        });

        btnReportes.addActionListener(e -> new MenuReportes(this));
        btnProcedimientos.addActionListener(e -> new MenuProcedimientos(this));
        btnCitasMedicas.addActionListener(e -> new MenuCitasMedicas());
        btnSalir.addActionListener(e -> System.exit(0));

        add(lblTitulo);
        add(btnProductos);
        add(btnDuenos);
        add(btnReportes);
        add(btnProcedimientos);
        add(btnCitasMedicas);
        add(btnSalir);
    }
}