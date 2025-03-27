package Inicio;

import javax.swing.*;
import java.awt.*;

public class MenuCentroVeterinario extends JFrame {
    public MenuCentroVeterinario() {
        setTitle("Centro Veterinario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblInfo = new JLabel("Información del Centro Veterinario", SwingConstants.CENTER);
        add(lblInfo, BorderLayout.NORTH);

        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.addActionListener(e -> volverAlMenu());

        add(btnVolver, BorderLayout.SOUTH);
    }

    private void volverAlMenu() {
        new Menu().setVisible(true);
        dispose();
    }
}
