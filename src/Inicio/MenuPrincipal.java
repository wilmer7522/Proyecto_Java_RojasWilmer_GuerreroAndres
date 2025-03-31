package Inicio;

import Modelo.FacturaPDF;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 1));

        JLabel lblTitulo = new JLabel("Bienvenido al sistema de la veterinaria Happy Feet", SwingConstants.CENTER);
        JButton btnProductos = new JButton("Gestion de Productos");
        JButton btnDuenos = new JButton("Gestion de dueños");
        JButton btnReportes = new JButton("Gestion de reportes");
        JButton btnProcedimientos = new JButton("Gestion de rocedimientos medicos");
        JButton btnCitasMedicas = new JButton("Gestion de consultas medicas");
        JButton btnVacunas = new JButton("Gestion de vacunas");
        JButton btnProveedores = new JButton("Gestion de proveedores");
        JButton btnTratamiento = new JButton("Gestion de tratamiento antiparasitarios");
        JButton btnDetalles = new JButton("Gestion de detalles en facturas");
        JButton btnHistorial = new JButton("Gestion de historial medico");
        JButton btnDetallesFacturas = new JButton("Gestion de detalle de inventario en facturas");
        JButton btnFacturas = new JButton("Gestion de Facturas");
        JButton btnDescargar = new JButton("Descargar Factura");
        JButton btnSalir = new JButton("Salir");

        btnProductos.addActionListener(e -> new MenuProductos().setVisible(true));
        btnReportes.addActionListener(e -> new MenuReportes(this).setVisible(true));
        btnProcedimientos.addActionListener(e -> new MenuProcedimientos(this).setVisible(true));
        btnCitasMedicas.addActionListener(e -> new MenuConsultasMedicas().setVisible(true));
        btnVacunas.addActionListener(e -> new MenuVacunas().setVisible(true));
        btnProveedores.addActionListener(e -> new MenuProveedores().setVisible(true));
        btnTratamiento.addActionListener( e-> new MenuTratamientoAntiparasitarios().setVisible(true));
        btnDetalles.addActionListener( e-> new MenuDetallesFactura().setVisible(true));
        btnHistorial.addActionListener(e -> new MenuHistorialMedico().setVisible(true));
        btnDetallesFacturas.addActionListener( e-> new MenuDetallesFactura().setVisible(true));
        btnFacturas.addActionListener( e -> new MenuFacturas().setVisible(true));
        btnDescargar.addActionListener( e -> new FacturaPDF());
        btnSalir.addActionListener(e -> System.exit(0));

        add(lblTitulo);
        add(btnProductos);
        add(btnDuenos);
        add(btnReportes);
        add(btnProcedimientos);
        add(btnCitasMedicas);
        add(btnVacunas);
        add(btnProveedores);
        add(btnTratamiento);
        add(btnDetalles);
        add(btnHistorial);
        add(btnDetallesFacturas);
        add(btnFacturas);
        add(btnDescargar);
        add(btnSalir);
    }
}