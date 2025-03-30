package Vista;

import Modelo.ConsultasMedica;
import Modelo.ConsultasMedicaDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaActualizarCita extends JFrame {
    private ConsultasMedicaDAO citaDAO;
    private JComboBox<Integer> comboCitas;
    private JTextField txtEstado, txtDiagnostico, txtPrescripcion;

    public VentanaActualizarCita(ConsultasMedicaDAO citaDAO) {
        this.citaDAO = citaDAO;

        setTitle("Actualizar Cita Médica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        comboCitas = new JComboBox<>();
        cargarCitas();

        txtEstado = new JTextField();
        txtDiagnostico = new JTextField();
        txtPrescripcion = new JTextField();

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> actualizarCita());

        add(new JLabel("ID Cita:"));
        add(comboCitas);
        add(new JLabel("Estado:"));
        add(txtEstado);
        add(new JLabel("Diagnóstico:"));
        add(txtDiagnostico);
        add(new JLabel("Prescripción:"));
        add(txtPrescripcion);
        add(new JLabel(""));
        add(btnActualizar);

        setVisible(true);
    }

    private void cargarCitas() {
        List<ConsultasMedica> citas = citaDAO.obtenerCitas();
        for (ConsultasMedica cita : citas) {
            comboCitas.addItem(cita.getId());
        }
    }

    private void actualizarCita() {
        if (comboCitas.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita");
            return;
        }
        int id = (int) comboCitas.getSelectedItem();
        String fechaHora = txtDiagnostico.getText();
        String mascota = txtEstado.getText();
        String dueno = txtPrescripcion.getText();
        String veterinario = txtPrescripcion.getText();
        String estado = txtEstado.getText();
        String diagnostico = txtDiagnostico.getText();
        String prescripcion = txtPrescripcion.getText();

        ConsultasMedica cita = new ConsultasMedica(id,
                fechaHora,
                mascota,
                dueno,
                veterinario,
                estado,
                diagnostico,
                prescripcion);
        if (citaDAO.actualizarCita(cita)) {
            JOptionPane.showMessageDialog(this, "Cita actualizada correctamente");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar la cita");
        }
    }
}

