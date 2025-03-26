package Inicio;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    public Menu() {
        setTitle("Menu - Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Texto de bienvenida
        JLabel lblTitulo = new JLabel("Menu Principal", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel con botones
        JPanel panelBotones = new JPanel(new GridLayout(4, 1));
        JButton btnCentroVeterinario = new JButton("Ver informacion del centro veterinario");
        JButton btnCita = new JButton("Agendar cita");
        JButton btnAdopcion = new JButton("Ver dias de adopcion de mascotas");
        JButton btnJornada = new JButton("Ver jornadas de vacunaciones y esterelizacion masiva");
        JButton btnClubMascotas = new JButton("Ver club de mascotas frecuentes");
        JButton btnSalir = new JButton("Salir");

        // Botones añadidos al menu
        panelBotones.add(btnCentroVeterinario);
        panelBotones.add(btnCita);
        panelBotones.add(btnAdopcion);
        panelBotones.add(btnJornada);
        panelBotones.add(btnClubMascotas);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.CENTER);

        // Acciones de los botones
        btnCentroVeterinario.addActionListener(e -> JOptionPane.showMessageDialog(this, "Mostrando informacion del centro veterinario..."));

        btnCita.addActionListener(e -> JOptionPane.showMessageDialog(this, "Agendando cita..."));

        btnAdopcion.addActionListener(e -> JOptionPane.showMessageDialog(this, "Mostrando dias de adocion de mascotas..."));

        btnJornada.addActionListener(e -> JOptionPane.showMessageDialog(this, "Mostrando jornada..."));

        btnClubMascotas.addActionListener(e -> JOptionPane.showMessageDialog(this, "Mostrando club de mascotas..."));

        btnSalir.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}
