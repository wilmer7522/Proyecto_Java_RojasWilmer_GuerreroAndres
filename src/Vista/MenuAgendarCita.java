package Vista;

import javax.swing.*;
import java.awt.*;

public class MenuAgendarCita extends JFrame {
    public MenuAgendarCita(JFrame parent) {
        setTitle("Agendar Cita");
        setSize(400, 300);
        setLocationRelativeTo(parent); // Centrar respecto a la ventana padre
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Aquí puedes agendar una cita", SwingConstants.CENTER);
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> dispose());

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);

        setVisible(true);
    }
}