package Inicio;

import Modelo.ConsultasMedicaDAO;
import Vista.VentanaActualizarConsula;
import Vista.VentanaAgregarConsulta;
import Vista.VentanaEliminarConsulta;
import Vista.VentanaListarConsultas;
import javax.swing.*;
import java.awt.*;

public class MenuConsultasMedicas extends JFrame {
    private ConsultasMedicaDAO consultaDAO;

    public MenuConsultasMedicas() {
        consultaDAO = new ConsultasMedicaDAO();

        setTitle("Gestion de Consultas Medicas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        JButton btnVerConsulta = new JButton("Ver Consultas");
        JButton btnAgregarConsulta = new JButton("Agregar Consulta");
        JButton btnActualizarConsulta = new JButton("Actualizar Consulta");
        JButton btnEliminarConulta = new JButton("Eliminar Consulta");
        JButton btnSalir = new JButton("Salir");

        btnVerConsulta.addActionListener(e -> new VentanaListarConsultas(consultaDAO));
        btnAgregarConsulta.addActionListener(e -> new VentanaAgregarConsulta(consultaDAO));
        btnActualizarConsulta.addActionListener(e -> new VentanaActualizarConsula(consultaDAO));
        btnEliminarConulta.addActionListener(e -> new VentanaEliminarConsulta(consultaDAO));
        btnSalir.addActionListener(e -> dispose());

        add(btnVerConsulta);
        add(btnAgregarConsulta);
        add(btnActualizarConsulta);
        add(btnEliminarConulta);
        add(btnSalir);

        setVisible(true);
    }
}