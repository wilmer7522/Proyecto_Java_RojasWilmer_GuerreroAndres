package Inicio;

import Modelo.ReportesDAO;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MenuReportes extends JFrame {
    private ReportesDAO reportesDAO;

    public MenuReportes(JFrame menuAnterior) {
        reportesDAO = new ReportesDAO();

        setTitle("Menu de Reportes");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));

        JButton btnVisitas = new JButton("Total de visitas");
        JButton btnProcedimientos = new JButton("Total de procedimientos");
        JButton btnVacunas = new JButton("Total de vacunas aplicadas");
        JButton btnFacturacion = new JButton("Total facturado");
        JButton btnServicios = new JButton("Servicios mas solicitados");
        JButton btnVeterinarios = new JButton("Desempeño de veterinarios");
        JButton btnSalir = new JButton("Salir");

        btnVisitas.addActionListener(e -> mostrarMensaje("Total de visitas", reportesDAO.obtenerTotalVisitas() + " visitas"));
        btnProcedimientos.addActionListener(e -> mostrarMensaje("Total de procedimientos", reportesDAO.obtenerTotalProcedimientos() + " procedimientos"));
        btnVacunas.addActionListener(e -> mostrarMensaje("Total de vacunas aplicadas", reportesDAO.obtenerTotalVacunas() + " vacunas aplicadas"));
        btnFacturacion.addActionListener(e -> mostrarMensaje("Total facturado", "$ " + reportesDAO.obtenerTotalFacturacion()));

        btnServicios.addActionListener(e -> mostrarLista("Servicios mas solicitados", reportesDAO.obtenerServiciosMasSolicitados()));
        btnVeterinarios.addActionListener(e -> mostrarLista("Desempeño de veterinarios", reportesDAO.obtenerDesempenoVeterinarios()));

        add(btnVisitas);
        add(btnProcedimientos);
        add(btnVacunas);
        add(btnFacturacion);
        add(btnServicios);
        add(btnVeterinarios);
        add(btnSalir);

        setVisible(true);
    }

    private void mostrarMensaje(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarLista(String titulo, List<String> datos) {
        String contenido = String.join("\n", datos);
        JOptionPane.showMessageDialog(this, new JTextArea(contenido), titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}