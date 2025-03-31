package Vista;

import Modelo.CitaMedica;
import Modelo.ConsultasMedica;
import Modelo.ConsultasMedicaDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListarCitas extends JFrame {
    private ConsultasMedicaDAO citaDAO;
    private JTable table;
    private DefaultTableModel modelo;

    public VentanaListarCitas(ConsultasMedicaDAO citaDAO) {
        this.citaDAO = citaDAO;

        setTitle("Lista de consultas medicas");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"ID", "Fecha", "Mascota", "Dueño", "Veterinario", "Estado", "Diagnostico", "Prescripcion"});

        table = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton btnActualizar = new JButton("Actualizar Lista");
        JButton btnEliminar = new JButton("Eliminar Consultas");
        JButton btnVolver = new JButton("Volver");

        btnActualizar.addActionListener(e -> actualizarLista());
        btnEliminar.addActionListener(e -> eliminarCitaSeleccionada());
        btnVolver.addActionListener(e -> dispose());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnVolver);

        add(panelBotones, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        actualizarLista();
        setVisible(true);
    }

    private void actualizarLista() {
        modelo.setRowCount(0);
        List<ConsultasMedica> citas = citaDAO.obtenerCitas();
        for (CitaMedica cita : citas) {
            modelo.addRow(new Object[]{
                    cita.getId(), cita.getFechaHora(), cita.getMascota(),
                    cita.getDueno(), cita.getVeterinario(), cita.getEstado(),
                    cita.getDiagnostico(), cita.getPrescripcion()
            });
        }
    }

    private void eliminarCitaSeleccionada() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idCita = (int) table.getValueAt(filaSeleccionada, 0);
            if (citaDAO.eliminarCita(idCita)) {
                JOptionPane.showMessageDialog(this, "Cita eliminada correctamente");
                actualizarLista();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar la cita");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una cita para eliminar");
        }
    }
}