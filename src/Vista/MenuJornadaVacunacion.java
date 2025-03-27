package Vista;

import javax.swing.*;
import java.awt.*;

public class MenuJornadaVacunacion extends JFrame {
    public MenuJornadaVacunacion(JFrame parent) {
        setTitle("Jornadas de Vacunación y Esterilización");
        setSize(400, 300);
        setLocationRelativeTo(parent); // Centrar respecto a la ventana principal
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Aquí puedes ver las jornadas de vacunación", SwingConstants.CENTER);
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> dispose());

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);

        setVisible(true);
    }
}