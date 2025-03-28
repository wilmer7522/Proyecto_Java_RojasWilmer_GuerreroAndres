package Inicio;

import Modelo.CitaMedicaDAO;
import Vista.VentanaActualizarCita;
import Vista.VentanaAgregarCita;
import Vista.VentanaEliminarCita;
import Vista.VentanaListarCitas;
import javax.swing.*;
import java.awt.*;

public class MenuCitasMedicas extends JFrame {
    private CitaMedicaDAO citaDAO;

    public MenuCitasMedicas() {
        citaDAO = new CitaMedicaDAO();

        setTitle("Gestion de Citas Medicas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        JButton btnVerCitas = new JButton("Ver Citas");
        JButton btnAgregarCita = new JButton("Agregar Cita");
        JButton btnActualizarCita = new JButton("Actualizar Cita");
        JButton btnEliminarCita = new JButton("Eliminar Cita");
        JButton btnSalir = new JButton("Salir");

        btnVerCitas.addActionListener(e -> new VentanaListarCitas(citaDAO));
        btnAgregarCita.addActionListener(e -> new VentanaAgregarCita(citaDAO));
        btnActualizarCita.addActionListener(e -> new VentanaActualizarCita(citaDAO));
        btnEliminarCita.addActionListener(e -> new VentanaEliminarCita(citaDAO));
        btnSalir.addActionListener(e -> dispose());

        add(btnVerCitas);
        add(btnAgregarCita);
        add(btnActualizarCita);
        add(btnEliminarCita);
        add(btnSalir);

        setVisible(true);
    }
}