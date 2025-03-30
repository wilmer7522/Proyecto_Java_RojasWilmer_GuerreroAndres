package Inicio;

import Vista.VentanaProveedores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuProveedores extends JFrame {
    public MenuProveedores() {
        setTitle("Menú de Proveedores");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JButton btnVer = new JButton("Ver Proveedores");
        JButton btnSalir = new JButton("Salir");

        btnVer.setBounds(100, 80, 200, 40);
        btnSalir.setBounds(100, 130, 200, 40);

        add(btnVer);
        add(btnSalir);

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuPrincipal menuPrincipal = new MenuPrincipal();
            }
        });

        btnVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new VentanaProveedores();
                } catch (SQLException ex) {
                    mostrarError(ex);
                }
            }
        });
        setVisible(true);
    }

    private void mostrarError(SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}