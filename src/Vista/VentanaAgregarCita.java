package Vista;

import Modelo.CitaMedica;
import Modelo.CitaMedicaDAO;
import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VentanaAgregarCita extends JFrame {
    private JTextField txtFechaHora, txtMascotaId, txtDuenoId, txtVeterinarioId, txtEstado, txtDiagnostico, txtPrescripcion;
    private CitaMedicaDAO citaMedicaDAO;

    public VentanaAgregarCita(CitaMedicaDAO citaMedicaDAO) {
        this.citaMedicaDAO = citaMedicaDAO;

        setTitle("Agregar Cita Médica");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("Fecha y Hora (yyyy-MM-dd HH:mm:ss):"));
        txtFechaHora = new JTextField();
        add(txtFechaHora);

        add(new JLabel("ID Mascota:"));
        txtMascotaId = new JTextField();
        add(txtMascotaId);

        add(new JLabel("ID Dueño:"));
        txtDuenoId = new JTextField();
        add(txtDuenoId);

        add(new JLabel("ID Veterinario:"));
        txtVeterinarioId = new JTextField();
        add(txtVeterinarioId);

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
        btnGuardar.addActionListener(e -> guardarCita());
        add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        add(btnCancelar);

        setVisible(true);
    }

    private void guardarCita() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp fechaHora = new Timestamp(dateFormat.parse(txtFechaHora.getText()).getTime());
            int mascotaId = Integer.parseInt(txtMascotaId.getText());
            int duenoId = Integer.parseInt(txtDuenoId.getText());
            int veterinarioId = Integer.parseInt(txtVeterinarioId.getText());
            String estado = txtEstado.getText();
            String diagnostico = txtDiagnostico.getText();
            String prescripcion = txtPrescripcion.getText();

            CitaMedica nuevaCita = new CitaMedica(0, fechaHora, mascotaId, duenoId, veterinarioId, estado, diagnostico, prescripcion);

            if (citaMedicaDAO.insertarCita(nuevaCita)) {
                JOptionPane.showMessageDialog(this, "Cita agregada con exito");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar la cita");
            }
        } catch (ParseException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Datos invalidos");
        }
    }
}