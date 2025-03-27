package Vista;

import javax.swing.*;
import java.awt.*;

public class MenuAdopcion extends JFrame {
    public MenuAdopcion(JFrame parent) {
        setTitle("Días de Adopción de Mascotas");
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Aquí puedes ver los días de adopción", SwingConstants.CENTER);
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> dispose());

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);
    }
}
