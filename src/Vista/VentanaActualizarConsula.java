package Vista;

import Modelo.ConsultasMedica;
import Modelo.ConsultasMedicaDAO;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaActualizarConsula extends JFrame {
    private ConsultasMedicaDAO ConsultaDAO;
    private JComboBox<Integer> comboConsultas;
    private JTextField txtEstado, txtDiagnostico, txtPrescripcion;

    public VentanaActualizarConsula(ConsultasMedicaDAO ConsultaDAO) {
        this.ConsultaDAO = ConsultaDAO;

        setTitle("Actualizar Consulta Medica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        comboConsultas = new JComboBox<>();
        cargarConsulta();

        txtEstado = new JTextField();
        txtDiagnostico = new JTextField();
        txtPrescripcion = new JTextField();

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> actualizarConsulta());

        add(new JLabel("ID Consulta:"));
        add(comboConsultas);
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

    private void cargarConsulta() {
        List<ConsultasMedica> consultas = ConsultaDAO.obtenerConsultas();
        for (ConsultasMedica consulta : consultas) {
            comboConsultas.addItem(consulta.getId());
        }
    }

    private void actualizarConsulta() {
        if (comboConsultas.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una consulta");
            return;
        }
        int id = (int) comboConsultas.getSelectedItem();
        String fechaHora = txtDiagnostico.getText();
        String mascota = txtEstado.getText();
        String dueno = txtPrescripcion.getText();
        String veterinario = txtPrescripcion.getText();
        String estado = txtEstado.getText();
        String diagnostico = txtDiagnostico.getText();
        String prescripcion = txtPrescripcion.getText();

        ConsultasMedica consulta = new ConsultasMedica(id,
                fechaHora,
                mascota,
                dueno,
                veterinario,
                estado,
                diagnostico,
                prescripcion);
        if (ConsultaDAO.actualizarConsultas(consulta)) {
            JOptionPane.showMessageDialog(this, "Consulta actualizada correctamente");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar la consulta");
        }
    }
}