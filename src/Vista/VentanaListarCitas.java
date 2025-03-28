package Vista;

import Modelo.CitaMedica;
import Modelo.CitaMedicaDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListarCitas extends JFrame {
    private CitaMedicaDAO citaDAO;
    private JTable table;
    private DefaultTableModel modelo;

    public VentanaListarCitas(CitaMedicaDAO citaDAO) {
        this.citaDAO = citaDAO;

        setTitle("Lista de Citas Médicas");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"ID", "Fecha", "Mascota ID", "Dueño ID", "Veterinario ID", "Estado", "Diagnóstico", "Prescripción"});

        table = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton btnActualizar = new JButton("Actualizar Lista");
        JButton btnEliminar = new JButton("Eliminar Cita");

        btnActualizar.addActionListener(e -> actualizarLista());
        btnEliminar.addActionListener(e -> eliminarCitaSeleccionada());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);

        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        actualizarLista();
        setVisible(true);
    }

    private void actualizarLista() {
        modelo.setRowCount(0);
        List<CitaMedica> citas = citaDAO.obtenerCitas();
        for (CitaMedica cita : citas) {
            modelo.addRow(new Object[]{
                    cita.getId(), cita.getFechaHora(), cita.getMascotaId(),
                    cita.getDuenoId(), cita.getVeterinarioId(), cita.getEstado(),
                    cita.getDiagnostico(), cita.getPrescripcion()
            });
        }
    }

    private void eliminarCitaSeleccionada() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idCita = (int) table.getValueAt(filaSeleccionada, 0);
            if (citaDAO.eliminarCita(idCita)) {
                JOptionPane.showMessageDialog(this, "Cita eliminada correctamente.");
                actualizarLista();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar la cita.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una cita para eliminar.");
        }
    }
}