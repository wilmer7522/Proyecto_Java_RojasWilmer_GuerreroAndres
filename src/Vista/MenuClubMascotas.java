package Vista;

import javax.swing.*;
import java.awt.*;

public class MenuClubMascotas extends JFrame {
    public MenuClubMascotas(JFrame parent) {
        setTitle("Club de Mascotas Frecuentes");
        setSize(400, 300);
        setLocationRelativeTo(parent); // Centrar respecto a la ventana padre
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Aquí puedes ver el club de mascotas", SwingConstants.CENTER);
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> dispose());

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);

        setVisible(true);
    }
}