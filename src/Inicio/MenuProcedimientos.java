package Inicio;

import Modelo.ProcedimientosDAO;
import javax.swing.*;
import java.awt.*;

public class MenuProcedimientos extends JFrame {
    private ProcedimientosDAO procedimientosDAO;

    public MenuProcedimientos(MenuPrincipal menuPrincipal) {
        procedimientosDAO = new ProcedimientosDAO();

        setTitle("Gestión de Procedimientos Médicos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        JButton btnVerProcedimientos = new JButton("Ver Procedimientos");
        JButton btnAgregarProcedimiento = new JButton("Agregar Procedimiento");
        JButton btnActualizarProcedimiento = new JButton("Actualizar Procedimiento");
        JButton btnEliminarProcedimiento = new JButton("Eliminar Procedimiento");

        btnVerProcedimientos.addActionListener(e -> procedimientosDAO.mostrarProcedimientos());

        btnAgregarProcedimiento.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Nombre del procedimiento:");
            String tipo = JOptionPane.showInputDialog("Tipo:");
            String insumos = JOptionPane.showInputDialog("Insumos utilizados:");
            int mascotaId = Integer.parseInt(JOptionPane.showInputDialog("ID de la Mascota:"));
            int veterinarioId = Integer.parseInt(JOptionPane.showInputDialog("ID del Veterinario:"));
            String fecha = JOptionPane.showInputDialog("Fecha (YYYY-MM-DD):");
            String observaciones = JOptionPane.showInputDialog("Observaciones:");
            int inventarioId = Integer.parseInt(JOptionPane.showInputDialog("ID del Insumo en Inventario:"));

            if (procedimientosDAO.insertarProcedimiento(nombre, tipo, insumos, mascotaId, veterinarioId, fecha, observaciones, inventarioId)) {
                JOptionPane.showMessageDialog(null, "Procedimiento agregado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar el procedimiento.");
            }
        });

        btnActualizarProcedimiento.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID del Procedimiento a actualizar:"));
            String nombre = JOptionPane.showInputDialog("Nuevo Nombre del procedimiento:");
            String tipo = JOptionPane.showInputDialog("Nuevo Tipo:");
            String insumos = JOptionPane.showInputDialog("Nuevos Insumos utilizados:");
            int mascotaId = Integer.parseInt(JOptionPane.showInputDialog("Nuevo ID de la Mascota:"));
            int veterinarioId = Integer.parseInt(JOptionPane.showInputDialog("Nuevo ID del Veterinario:"));
            String fecha = JOptionPane.showInputDialog("Nueva Fecha (YYYY-MM-DD):");
            String observaciones = JOptionPane.showInputDialog("Nuevas Observaciones:");
            int inventarioId = Integer.parseInt(JOptionPane.showInputDialog("Nuevo ID del Insumo en Inventario:"));

            if (procedimientosDAO.actualizarProcedimiento(id, nombre, tipo, insumos, mascotaId, veterinarioId, fecha, observaciones, inventarioId)) {
                JOptionPane.showMessageDialog(null, "Procedimiento actualizado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el procedimiento.");
            }
        });

        btnEliminarProcedimiento.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID del Procedimiento a eliminar:"));
            if (procedimientosDAO.eliminarProcedimiento(id)) {
                JOptionPane.showMessageDialog(null, "Procedimiento eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el procedimiento.");
            }
        });

        add(btnVerProcedimientos);
        add(btnAgregarProcedimiento);
        add(btnActualizarProcedimiento);
        add(btnEliminarProcedimiento);

        setVisible(true);
    }
}