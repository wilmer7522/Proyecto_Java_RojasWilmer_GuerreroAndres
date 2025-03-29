package Vista;

import Modelo.CitaMedica;
import Modelo.ConsultasMedica;
import Modelo.ConsultasMedicaDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaEliminarCita extends JFrame {
    private ConsultasMedicaDAO citaDAO;
    private JComboBox<CitaMedica> comboCitas;
    private JButton btnEliminar, btnCancelar;

    public VentanaEliminarCita(ConsultasMedicaDAO citaDAO) {
        this.citaDAO = citaDAO;

        setTitle("Eliminar Cita Médica");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        comboCitas = new JComboBox<>();
        cargarCitas();

        btnEliminar = new JButton("Eliminar Cita");
        btnEliminar.addActionListener(e -> eliminarCita());

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        add(new JLabel("Seleccione la Cita a eliminar:"));
        add(comboCitas);
        add(btnEliminar);
        add(btnCancelar);

        setVisible(true);
    }

    private void cargarCitas() {
        List<ConsultasMedica> citas = citaDAO.obtenerCitas();
        comboCitas.removeAllItems();
        for (ConsultasMedica cita : citas) {
            comboCitas.addItem(cita);
        }
    }

    private void eliminarCita() {
        CitaMedica citaSeleccionada = (CitaMedica) comboCitas.getSelectedItem();

        if (citaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar la cita?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (citaDAO.eliminarCita(citaSeleccionada.getId())) {
                JOptionPane.showMessageDialog(this, "Cita eliminada correctamente");
                cargarCitas();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar la cita");
            }
        }
    }
}