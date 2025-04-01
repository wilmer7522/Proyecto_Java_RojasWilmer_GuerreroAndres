package Inicio;

import Modelo.FacturaPDF;
import Vista.*;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        setTitle("Menu Principal");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 1));

        JLabel lblTitulo = new JLabel("Bienvenido al sistema de la veterinaria Happy Feet", SwingConstants.CENTER);
        JButton btnProductos = new JButton("Gestion de Productos");
        JButton btnDuenos = new JButton("Gestion de Dueños");
        JButton btnMascotas = new JButton("Gestion de Mascotas");
        JButton btnVeterinarios = new JButton("Gestion de Veterinarios");
        JButton btnReportes = new JButton("Gestion de Reportes");
        JButton btnProcedimientos = new JButton("Gestion de Procedimientos Medicos");
        JButton btnCitasMedicas = new JButton("Gestion de Citas medicas");
        JButton btnConsultasMedicas = new JButton("Gestion de Consultas Medicas");
        JButton btnVacunas = new JButton("Gestion de Vacunas");
        JButton btnAdopciones = new JButton("Gestion de Adopciones");
        JButton btnProveedores = new JButton("Gestion de Proveedores");
        JButton btnTratamiento = new JButton("Gestion de Tratamiento Antiparasitarios");
        JButton btnDetalles = new JButton("Gestion de detalles en Facturas");
        JButton btnHistorial = new JButton("Gestion de Historial Medico");
        JButton btnDetallesFacturas = new JButton("Gestion de Detalle de Inventario en Facturas");
        JButton btnFacturas = new JButton("Gestion de Facturas");
        JButton btnClientesFrecuentes = new JButton("Gestion de Clientes Frecuentes");
        JButton btnDescargar = new JButton("Descargar Factura");
        JButton btnSalir = new JButton("Salir");

        btnProductos.addActionListener(e -> new MenuProductos().setVisible(true));
        btnDuenos.addActionListener(e -> {
            this.setVisible(false);
            DuenoVistaFrame duenoVista = new DuenoVistaFrame();
            duenoVista.setVisible(true);
        });

        btnMascotas.addActionListener(e -> {
            this.setVisible(false);
            MascotaVistaFrame mascotaVista = new MascotaVistaFrame();
            mascotaVista.setVisible(true);
        });

        btnAdopciones.addActionListener(e -> {
            this.setVisible(false);
            AdopcionesVistaFrame adopcionesVista = new AdopcionesVistaFrame();
            adopcionesVista.setVisible(true);
        });

        btnVeterinarios.addActionListener(e -> {
            this.setVisible(false);
            VeterinarioVistaFrame veterinarioVista = new VeterinarioVistaFrame();
            veterinarioVista.setVisible(true);
        });

        btnClientesFrecuentes.addActionListener(e -> {
            this.setVisible(false);
            MenuClientesFrecuentes menuClientesFrecuentes = new MenuClientesFrecuentes();
            menuClientesFrecuentes.setVisible(true);
        });

        btnCitasMedicas.addActionListener(e -> {
            this.setVisible(false);
            CitasMedicasVistaFrame citasMedicasVista = new CitasMedicasVistaFrame();
        citasMedicasVista.setVisible(true);    });


        btnReportes.addActionListener(e -> new MenuReportes(this).setVisible(true));
        btnProcedimientos.addActionListener(e -> new MenuProcedimientos(this).setVisible(true));
        btnConsultasMedicas.addActionListener(e -> new MenuConsultasMedicas().setVisible(true));
        btnVacunas.addActionListener(e -> new MenuVacunas().setVisible(true));
        btnProveedores.addActionListener(e -> new MenuProveedores().setVisible(true));
        btnTratamiento.addActionListener( e-> new MenuTratamientoAntiparasitarios().setVisible(true));
        btnDetalles.addActionListener( e-> new MenuDetallesFactura().setVisible(true));
        btnHistorial.addActionListener(e -> new MenuHistorialMedico().setVisible(true));
        btnDetallesFacturas.addActionListener( e-> new MenuDetallesFactura().setVisible(true));
        btnClientesFrecuentes.addActionListener( e -> new MenuClientesFrecuentes().setVisible(true));
        btnFacturas.addActionListener( e -> new MenuFacturas().setVisible(true));
        btnDescargar.addActionListener( e -> {
            int facturaId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la factura:"));
            FacturaPDF obj = new FacturaPDF();
            obj.escribirFactura(facturaId);
        });
        btnSalir.addActionListener(e -> System.exit(0));

        add(lblTitulo);
        add(btnProductos);
        add(btnDuenos);
        add(btnMascotas);
        add(btnVeterinarios);
        add(btnAdopciones);
        add(btnReportes);
        add(btnProcedimientos);
        add(btnCitasMedicas);
        add(btnConsultasMedicas);
        add(btnVacunas);
        add(btnProveedores);
        add(btnTratamiento);
        add(btnDetalles);
        add(btnHistorial);
        add(btnDetallesFacturas);
        add(btnFacturas);
        add(btnClientesFrecuentes);
        add(btnDescargar);
        add(btnSalir);
    }
}