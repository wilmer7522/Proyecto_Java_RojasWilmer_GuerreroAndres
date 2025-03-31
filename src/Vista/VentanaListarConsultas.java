package Vista;

import Modelo.ConsultasMedica;
import Modelo.ConsultasMedicaDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListarConsultas extends JFrame {
    private ConsultasMedicaDAO consultaDAO;
    private JTable table;
    private DefaultTableModel modelo;

    public VentanaListarConsultas(ConsultasMedicaDAO consultaDAO) {
        this.consultaDAO = consultaDAO;

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
        btnEliminar.addActionListener(e -> eliminarConsultaSeleccionada());
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
        List<ConsultasMedica> consultas = consultaDAO.obtenerConsultas();
        for (ConsultasMedica consulta : consultas) {
            modelo.addRow(new Object[]{
                    consulta.getId(), consulta.getFechaHora(), consulta.getMascota(),
                    consulta.getDueno(), consulta.getVeterinario(), consulta.getEstado(),
                    consulta.getDiagnostico(), consulta.getPrescripcion()
            });
        }
    }

    private void eliminarConsultaSeleccionada() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idConsulta = (int) table.getValueAt(filaSeleccionada, 0);
            if (consultaDAO.eliminarConsultas(idConsulta)) {
                JOptionPane.showMessageDialog(this, "Consulta eliminada correctamente");
                actualizarLista();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar la consulta");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una consulta para eliminar");
        }
    }
}