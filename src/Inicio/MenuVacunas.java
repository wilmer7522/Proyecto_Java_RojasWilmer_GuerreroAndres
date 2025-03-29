package Inicio;

import Vista.VentanaVacunas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuVacunas extends JFrame {
    public MenuVacunas() {
        setTitle("Menu de Vacunas");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JButton btnGestionarVacunas = new JButton("Gestionar Vacunas");
        JButton btnSalir = new JButton("Salir");

        btnGestionarVacunas.setBounds(100, 50, 200, 50);
        btnSalir.setBounds(100, 110, 200, 50);

        add(btnGestionarVacunas);
        add(btnSalir);

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuPrincipal();
            }

            MenuPrincipal menuPrincipal = new MenuPrincipal();
        });

        btnGestionarVacunas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new VentanaVacunas();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        setVisible(true);
    }
}