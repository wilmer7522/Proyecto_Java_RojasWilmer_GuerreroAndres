package Vista;

import Controlador.Factura;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FacturaVista {
    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("Generador de Facturas");
        JButton generarBoton = new JButton("Generar Archivo TXT");

        // Suponiendo que tienes una conexión a la base de datos (conn)
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_de_datos", "usuario", "contraseña");

        // Instanciar la clase de generación de archivo
        Factura facturaGenerator = new Factura(conn);

        generarBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                facturaGenerator.generarArchivoTXT();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        // Configurar el botón
        generarBoton.setBounds(50, 50, 200, 30);
        frame.add(generarBoton);

        frame.setVisible(true);
    }
}
