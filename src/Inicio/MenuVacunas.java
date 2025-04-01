package Inicio;

import Vista.VentanaVacunas;
import Modelo.ConexionDB;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

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
        });

        btnGestionarVacunas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = ConexionDB.getConnection();

                if (conexion != null) {
                    new VentanaVacunas().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error de conexion con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}