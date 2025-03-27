package Inicio;

import javax.swing.*;
import java.awt.*;

public class MenuProductos extends JFrame {

    public MenuProductos(JFrame menuAnterior) {
        setTitle("Gestión de Productos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        JButton btnVolver = new JButton("Volver");

        btnVolver.addActionListener(e -> {
            dispose();
            menuAnterior.setVisible(true);
        });

        add(btnVolver);
        setVisible(true);
    }
}
