package Vista;

import Controlador.Factura;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class FacturaVista {
    public void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("Generador de Facturas");
        JButton generarBoton = new JButton("Generar Archivo TXT");

        Connection conn = DriverManager.getConnection("jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn", "ue1oyjioflexxw8f", "RSMHhaXROhzgve0aR7Jb");

        Factura facturaGenerator = new Factura(conn);

        generarBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                facturaGenerator.generarArchivoTXT();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        generarBoton.setBounds(50, 50, 200, 30);
        frame.add(generarBoton);

        frame.setVisible(true);
    }
}