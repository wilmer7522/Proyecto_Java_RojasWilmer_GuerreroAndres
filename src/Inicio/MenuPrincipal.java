package Inicio;

import Vista.MenuProductos;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JLabel lblTitulo = new JLabel("Bienvenido al Sistema", SwingConstants.CENTER);
        JButton btnProductos = new JButton("Gestión de Productos");
        JButton btnReportes = new JButton("Ver Reportes");
        JButton btnSalir = new JButton("Salir");

        btnProductos.addActionListener(e -> new MenuProductos(this));
        btnReportes.addActionListener(e -> JOptionPane.showMessageDialog(this, "Mostrando reportes..."));
        btnSalir.addActionListener(e -> System.exit(0));

        add(lblTitulo);
        add(btnProductos);
        add(btnReportes);
        add(btnSalir);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}
