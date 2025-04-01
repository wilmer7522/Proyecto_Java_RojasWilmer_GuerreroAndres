package Vista;

import Modelo.Vacuna;
import Modelo.VacunaDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class VentanaVacunas extends JFrame {
    private VacunaDAO vacunaDAO;
    private JTable tablaVacunas;
    private DefaultTableModel modeloTabla;

    public VentanaVacunas() {
        this.vacunaDAO = new VacunaDAO(); // Corrección aquí

        setTitle("Gestión de Vacunas");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Fabricante", "Lote", "Fecha Aplicación", "Fecha Vencimiento", "Mascota ID", "Inventario ID"}, 0);
        tablaVacunas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaVacunas);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        add(panelBotones, BorderLayout.SOUTH);

        cargarVacunas();

        btnAgregar.addActionListener(this::agregarVacuna);
        btnEditar.addActionListener(this::editarVacuna);
        btnEliminar.addActionListener(this::eliminarVacuna);
    }

    private void cargarVacunas() {
        modeloTabla.setRowCount(0);
        List<Vacuna> vacunas = vacunaDAO.obtenerVacunas();
        for (Vacuna vacuna : vacunas) {
            modeloTabla.addRow(new Object[]{
                    vacuna.getId(),
                    vacuna.getNombre(),
                    vacuna.getFabricante(),
                    vacuna.getLote(),
                    vacuna.getFechaAplicacion(),
                    vacuna.getFechaVencimiento(),
                    vacuna.getMascotaId(),
                    vacuna.getInventarioId()
            });
        }
    }

    private void agregarVacuna(ActionEvent e) {
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String fabricante = JOptionPane.showInputDialog("Fabricante:");
        String lote = JOptionPane.showInputDialog("Lote:");
        String fechaAplicacion = JOptionPane.showInputDialog("Fecha de Aplicación (YYYY-MM-DD):");
        String fechaVencimiento = JOptionPane.showInputDialog("Fecha de Vencimiento (YYYY-MM-DD):");
        int mascotaId = Integer.parseInt(JOptionPane.showInputDialog("ID de Mascota:"));
        int inventarioId = Integer.parseInt(JOptionPane.showInputDialog("ID de Inventario:"));

        Vacuna vacuna = new Vacuna(nombre, fabricante, lote, fechaAplicacion, fechaVencimiento, mascotaId, inventarioId);
        boolean resultado = vacunaDAO.insertarVacuna(vacuna);

        if (resultado) {
            JOptionPane.showMessageDialog(this, "Vacuna agregada correctamente.");
            cargarVacunas();
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar la vacuna.");
        }
    }

    private void editarVacuna(ActionEvent e) {
        int fila = tablaVacunas.getSelectedRow();
        if (fila != -1) {
            int id = (int) modeloTabla.getValueAt(fila, 0);
            String nombre = JOptionPane.showInputDialog("Nuevo Nombre:", modeloTabla.getValueAt(fila, 1));
            String fabricante = JOptionPane.showInputDialog("Nuevo Fabricante:", modeloTabla.getValueAt(fila, 2));
            String lote = JOptionPane.showInputDialog("Nuevo Lote:", modeloTabla.getValueAt(fila, 3));
            String fechaAplicacion = JOptionPane.showInputDialog("Nueva Fecha de Aplicación (YYYY-MM-DD):", modeloTabla.getValueAt(fila, 4));
            String fechaVencimiento = JOptionPane.showInputDialog("Nueva Fecha de Vencimiento (YYYY-MM-DD):", modeloTabla.getValueAt(fila, 5));
            int mascotaId = Integer.parseInt(JOptionPane.showInputDialog("Nuevo ID de Mascota:", modeloTabla.getValueAt(fila, 6)));
            int inventarioId = Integer.parseInt(JOptionPane.showInputDialog("Nuevo ID de Inventario:", modeloTabla.getValueAt(fila, 7)));

            Vacuna vacuna = new Vacuna(id, nombre, fabricante, lote, fechaAplicacion, fechaVencimiento, mascotaId, inventarioId);
            boolean resultado = vacunaDAO.actualizarVacuna(vacuna);

            if (resultado) {
                JOptionPane.showMessageDialog(this, "Vacuna actualizada correctamente.");
                cargarVacunas();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar la vacuna.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una vacuna.");
        }
    }

    private void eliminarVacuna(ActionEvent e) {
        int fila = tablaVacunas.getSelectedRow();
        if (fila != -1) {
            int id = (int) modeloTabla.getValueAt(fila, 0);
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar esta vacuna?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                boolean resultado = vacunaDAO.eliminarVacuna(id);
                if (resultado) {
                    JOptionPane.showMessageDialog(this, "Vacuna eliminada correctamente.");
                    cargarVacunas();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar la vacuna.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una vacuna.");
        }
    }
}