package Inicio;

import Modelo.ConsultasMedicaDAO;
import Vista.VentanaActualizarCita;
import Vista.VentanaAgregarCita;
import Vista.VentanaEliminarCita;
import Vista.VentanaListarCitas;
import javax.swing.*;
import java.awt.*;

public class MenuConsultasMedicas extends JFrame {
    private ConsultasMedicaDAO citaDAO;

    public MenuConsultasMedicas() {
        citaDAO = new ConsultasMedicaDAO();

        setTitle("Gestion de Consultas Medicas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        JButton btnVerCitas = new JButton("Ver Consultas");
        JButton btnAgregarConsulta = new JButton("Agregar Consulta");
        JButton btnActualizarCita = new JButton("Actualizar Consulta");
        JButton btnEliminarCita = new JButton("Eliminar Consulta");
        JButton btnSalir = new JButton("Salir");

        btnVerCitas.addActionListener(e -> new VentanaListarCitas(citaDAO));
        btnAgregarConsulta.addActionListener(e -> new VentanaAgregarCita(citaDAO));
        btnActualizarCita.addActionListener(e -> new VentanaActualizarCita(citaDAO));
        btnEliminarCita.addActionListener(e -> new VentanaEliminarCita(citaDAO));
        btnSalir.addActionListener(e -> dispose());

        add(btnVerCitas);
        add(btnAgregarConsulta);
        add(btnActualizarCita);
        add(btnEliminarCita);
        add(btnSalir);

        setVisible(true);
    }
}