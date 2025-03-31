package Vista;

import Modelo.ConsultasMedica;
import Modelo.ConsultasMedicaDAO;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaEliminarConsulta extends JFrame {
    private ConsultasMedicaDAO consultaDAO;
    private JComboBox<ConsultasMedica> comboConsultas;
    private JButton btnEliminar, btnCancelar;

    public VentanaEliminarConsulta(ConsultasMedicaDAO consultaDAO) {
        this.consultaDAO = consultaDAO;

        setTitle("Eliminar Consulta Medica");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        comboConsultas = new JComboBox<ConsultasMedica>();
        cargarConsultas();

        btnEliminar = new JButton("Eliminar Consulta");
        btnEliminar.addActionListener(e -> eliminarConsultas());

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        add(new JLabel("Seleccione la Consulta a eliminar:"));
        add(comboConsultas);
        add(btnEliminar);
        add(btnCancelar);

        setVisible(true);
    }

    private void cargarConsultas() {
        List<ConsultasMedica> consultas = consultaDAO.obtenerConsultas();
        comboConsultas.removeAllItems();
        for (ConsultasMedica Consultas : consultas) {
            comboConsultas.addItem(Consultas);
        }
    }

    private void eliminarConsultas() {
        ConsultasMedica consultaSeleccionada = (ConsultasMedica) comboConsultas.getSelectedItem();

        if (consultaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una consulta");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar la consulta?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (consultaDAO.eliminarConsultas(consultaSeleccionada.getId())) {
                JOptionPane.showMessageDialog(this, "Consulta eliminada correctamente");
                cargarConsultas();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar la consulta");
            }
        }
    }
}