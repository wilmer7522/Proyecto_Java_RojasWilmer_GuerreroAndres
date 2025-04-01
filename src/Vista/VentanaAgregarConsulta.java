package Vista;

import Modelo.ConsultasMedica;
import Modelo.ConsultasMedicaDAO;
import javax.swing.*;
import java.awt.*;

public class VentanaAgregarConsulta extends JFrame {
    private JTextField txtFechaHora, txtMascota, txtDueno, txtVeterinario, txtEstado, txtDiagnostico, txtPrescripcion;
    private ConsultasMedicaDAO consultasMedicaDAO;

    public VentanaAgregarConsulta(ConsultasMedicaDAO consultasMedicaDAO) {
        this.consultasMedicaDAO = consultasMedicaDAO;

        setTitle("Agregar Consulta Medica");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("Fecha (yyyy-MM-dd):"));
        txtFechaHora = new JTextField();
        add(txtFechaHora);

        add(new JLabel("ID Mascota:"));
        txtMascota = new JTextField();
        add(txtMascota);

        add(new JLabel("ID Dueño:"));
        txtDueno = new JTextField();
        add(txtDueno);

        add(new JLabel("ID Veterinario:"));
        txtVeterinario = new JTextField();
        add(txtVeterinario);

        add(new JLabel("Estado:"));
        txtEstado = new JTextField();
        add(txtEstado);

        add(new JLabel("Diagnóstico:"));
        txtDiagnostico = new JTextField();
        add(txtDiagnostico);

        add(new JLabel("Prescripción Medica:"));
        txtPrescripcion = new JTextField();
        add(txtPrescripcion);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarConsulta());
        add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        add(btnCancelar);

        setVisible(true);
    }

    private void guardarConsulta() {
        try {
            String fechaHora = txtFechaHora.getText();
            String mascota = txtMascota.getText();
            String dueno = txtDueno.getText();
            String veterinario = txtVeterinario.getText();
            String estado = txtEstado.getText();
            String diagnostico = txtDiagnostico.getText();
            String prescripcion = txtPrescripcion.getText();

            ConsultasMedica nuevaConsulta = new ConsultasMedica(0, fechaHora, mascota, dueno, veterinario, estado, diagnostico, prescripcion);

            if (consultasMedicaDAO.insertarConsultas(nuevaConsulta)) {
                JOptionPane.showMessageDialog(this, "Consulta agregada con exito");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar la consulta");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Datos invalidos");
        }
    }
}