package Inicio;

import Vista.MenuAdopcion;
import Vista.MenuAgendarCita;
import Inicio.MenuCentroVeterinario;
import Vista.MenuJornadaVacunacion;
import Vista.MenuClubMascotas;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    public Menu() {
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Texto de bienvenida
        JLabel lblTitulo = new JLabel("Menú Principal", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel con botones
        JPanel panelBotones = new JPanel(new GridLayout(3, 2, 10, 10));
        JButton btnCentroVeterinario = new JButton("Centro Veterinario");
        JButton btnCita = new JButton("Agendar Cita");
        JButton btnAdopcion = new JButton("Días de Adopción");
        JButton btnJornada = new JButton("Jornadas de Vacunación");
        JButton btnClubMascotas = new JButton("Club Mascotas");
        JButton btnSalir = new JButton("Salir");

        // Agregar botones al panel
        panelBotones.add(btnCentroVeterinario);
        panelBotones.add(btnCita);
        panelBotones.add(btnAdopcion);
        panelBotones.add(btnJornada);
        panelBotones.add(btnClubMascotas);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.CENTER);

        // Acciones de los botones
        btnCentroVeterinario.addActionListener(e -> abrirVentana(new MenuCentroVeterinario()));
        btnCita.addActionListener(e -> new MenuAgendarCita(this));
        btnAdopcion.addActionListener(e -> new MenuAdopcion(this).setVisible(true));
        btnJornada.addActionListener(e -> new MenuJornadaVacunacion(this));
        btnClubMascotas.addActionListener(e -> new MenuClubMascotas(this));
        btnSalir.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void abrirVentana(JFrame ventana) {
        ventana.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }
}