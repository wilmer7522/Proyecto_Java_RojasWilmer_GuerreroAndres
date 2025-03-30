package Vista;

import Modelo.Vacuna;
import Modelo.VacunaDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class VentanaVacunas extends JFrame {
    private VacunaDAO vacunaDAO;
    private JTable table;
    private DefaultTableModel model;

    public VentanaVacunas() throws SQLException {
        vacunaDAO = new VacunaDAO();

        setTitle("Gestion de Vacunas");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultTableModel();
        table = new JTable(model);
        model.setColumnIdentifiers(new String[]{"ID", "Nombre", "Fabricante", "Lote", "Fecha Aplicación", "Fecha Vencimiento", "Mascota ID", "Inventario ID"});
        cargarDatos();

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar vacunas");
        JButton btnEditar = new JButton("Editar vacunas");
        JButton btnEliminar = new JButton("Eliminar vacunas");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        add(panelBotones, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> {
            try {
                mostrarFormulario(null);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        btnEditar.addActionListener(e -> {
            try {
                editarVacuna();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        btnEliminar.addActionListener(e -> {
            try {
                eliminarVacuna();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        setVisible(true);
    }

    private void cargarDatos() throws SQLException {
        model.setRowCount(0);
        List<Vacuna> vacunas = vacunaDAO.obtenerVacunas();
        for (Vacuna v : vacunas) {
            model.addRow(new Object[]{v.getId(), v.getNombre(), v.getFabricante(), v.getLote(), v.getFechaAplicacion(), v.getFechaVencimiento(), v.getMascotaId(), v.getInventarioId()});
        }
    }

    private void mostrarFormulario(Vacuna vacuna) throws SQLException {
        JTextField txtNombre = new JTextField(vacuna != null ? vacuna.getNombre() : "");
        JTextField txtFabricante = new JTextField(vacuna != null ? vacuna.getFabricante() : "");
        JTextField txtLote = new JTextField(vacuna != null ? vacuna.getLote() : "");
        JTextField txtFechaAplicacion = new JTextField(vacuna != null ? vacuna.getFechaAplicacion().toString() : "");
        JTextField txtFechaVencimiento = new JTextField(vacuna != null ? vacuna.getFechaVencimiento().toString() : "");
        JTextField txtMascotaId = new JTextField(vacuna != null ? String.valueOf(vacuna.getMascotaId()) : "");
        JTextField txtInventarioId = new JTextField(vacuna != null ? String.valueOf(vacuna.getInventarioId()) : "");

        Object[] campos = {
                "Nombre:", txtNombre,
                "Fabricante:", txtFabricante,
                "Lote:", txtLote,
                "Fecha Aplicacion (YYYY-MM-DD):", txtFechaAplicacion,
                "Fecha Vencimiento (YYYY-MM-DD):", txtFechaVencimiento,
                "ID Mascota:", txtMascotaId,
                "ID Inventario:", txtInventarioId
        };

        int opcion = JOptionPane.showConfirmDialog(this, campos, vacuna == null ? "Agregar Vacuna" : "Editar Vacuna", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            Vacuna nuevaVacuna = new Vacuna(
                    vacuna != null ? vacuna.getId() : 0,
                    txtNombre.getText(),
                    txtFabricante.getText(),
                    txtLote.getText(),
                    txtFechaAplicacion.getText(),
                    txtFechaVencimiento.getText(),
                    Integer.parseInt(txtMascotaId.getText()),
                    Integer.parseInt(txtInventarioId.getText())
            );

            if (vacuna == null) {
                vacunaDAO.insertarVacuna(nuevaVacuna);
            } else {
                vacunaDAO.actualizarVacuna(nuevaVacuna);
            }
            cargarDatos();
        }
    }

    private void editarVacuna() throws SQLException {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una vacuna para editar");
            return;
        }
        int id = (int) table.getValueAt(filaSeleccionada, 0);
        Vacuna vacuna = vacunaDAO.obtenerPorId(id);
        mostrarFormulario(vacuna);
    }

    private void eliminarVacuna() throws SQLException {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una vacuna para eliminar");
            return;
        }
        int id = (int) table.getValueAt(filaSeleccionada, 0);
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar esta vacuna?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            vacunaDAO.eliminarVacuna(id);
            cargarDatos();
        }
    }
}