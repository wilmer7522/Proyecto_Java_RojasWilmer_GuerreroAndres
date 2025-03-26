package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaActualizarProducto extends JFrame {
    public VentanaActualizarProducto(JFrame menuAnterior) {
        setTitle("Actualizar Producto");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel lblMensaje = new JLabel("Aquí puedes actualizar un producto.");
        JButton btnVolver = new JButton("Volver");

        btnVolver.addActionListener(e -> {
            dispose();
            menuAnterior.setVisible(true);
        });

        add(lblMensaje);
        add(btnVolver);

        setVisible(true);
    }
}
