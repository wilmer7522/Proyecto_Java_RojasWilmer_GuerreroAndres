package Inicio;

import Modelo.TratamientoAntiparasitario;
import Modelo.TratamientoAntiparasitarioDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MenuTratamientoAntiparasitarios extends JFrame {
    private TratamientoAntiparasitarioDAO tratamientoDAO;

    public MenuTratamientoAntiparasitarios() {
        tratamientoDAO = new TratamientoAntiparasitarioDAO();

        setTitle("Gestion de Tratamientos Antiparasitarios");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JButton btnVer = new JButton("Ver Tratamientos");
        JButton btnAgregar = new JButton("Agregar Tratamiento");
        JButton btnActualizar = new JButton("Actualizar Tratamiento");
        JButton btnEliminar = new JButton("Eliminar Tratamiento");
        JButton btnSalir = new JButton("Salir");

        btnVer.addActionListener(e -> mostrarTratamientos());
        btnAgregar.addActionListener(e -> agregarTratamiento());
        btnActualizar.addActionListener(e -> actualizarTratamiento());
        btnEliminar.addActionListener(e -> eliminarTratamiento());
        btnSalir.addActionListener(e -> dispose());

        add(btnVer);
        add(btnAgregar);
        add(btnActualizar);
        add(btnEliminar);
        add(btnSalir);

        setVisible(true);
    }

    private void mostrarTratamientos() {
        List<TratamientoAntiparasitario> tratamientos = tratamientoDAO.obtenerTratamientos();

        if (tratamientos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay tratamientos registrados");
            return;
        }

        StringBuilder sb = new StringBuilder("Lista de Tratamientos:\n");
        for (TratamientoAntiparasitario t : tratamientos) {
            sb.append("ID: ").append(t.getId()).append(" - Tipo: ").append(t.getTipo())
                    .append(" - Aplicado: ").append(t.getFechaAplicacion())
                    .append(" - Proxima Dosis: ").append(t.getFechaProximaDosis())
                    .append(" - Mascota ID: ").append(t.getMascotaId())
                    .append(" - Inventario ID: ").append(t.getInventarioId()).append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void agregarTratamiento() {
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de tratamiento:");
        String fechaAplicacion = JOptionPane.showInputDialog("Ingrese la fecha de aplicacion (YYYY-MM-DD):");
        String fechaProximaDosis = JOptionPane.showInputDialog("Ingrese la proxima dosis (YYYY-MM-DD):");

        if (tipo == null || fechaAplicacion == null || fechaProximaDosis == null ||
                tipo.isEmpty() || fechaAplicacion.isEmpty() || fechaProximaDosis.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Todos los campos son obligatorios");
            return;
        }

        try {
            int mascotaId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la mascota:"));
            int inventarioId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del inventario:"));

            TratamientoAntiparasitario nuevoTratamiento = new TratamientoAntiparasitario(
                    0, tipo, fechaAplicacion, fechaProximaDosis, mascotaId, inventarioId
            );

            if (tratamientoDAO.insertarTratamiento(nuevoTratamiento)) {
                JOptionPane.showMessageDialog(this, "Tratamiento agregado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar el tratamiento");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: IDs deben ser numeros validos");
        }
    }

    private void actualizarTratamiento() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del tratamiento a actualizar:");
        if (idStr == null || idStr.trim().isEmpty()) return;

        try {
            int id = Integer.parseInt(idStr);
            List<TratamientoAntiparasitario> lista = tratamientoDAO.obtenerTratamientos();
            TratamientoAntiparasitario tratamientoExistente = null;

            for (TratamientoAntiparasitario t : lista) {
                if (t.getId() == id) {
                    tratamientoExistente = t;
                    break;
                }
            }

            if (tratamientoExistente == null) {
                JOptionPane.showMessageDialog(this, "Error: Tratamiento no encontrado");
                return;
            }

            String nuevoTipo = JOptionPane.showInputDialog("Nuevo tipo de tratamiento:", tratamientoExistente.getTipo());
            String nuevaFechaAplicacion = JOptionPane.showInputDialog("Nueva fecha de aplicación (YYYY-MM-DD):", tratamientoExistente.getFechaAplicacion());
            String nuevaFechaProximaDosis = JOptionPane.showInputDialog("Nueva fecha de proxima dosis (YYYY-MM-DD):", tratamientoExistente.getFechaProximaDosis());
            String nuevoMascotaIdStr = JOptionPane.showInputDialog("Nuevo ID de Mascota:", tratamientoExistente.getMascotaId());
            String nuevoInventarioIdStr = JOptionPane.showInputDialog("Nuevo ID de Inventario:", tratamientoExistente.getInventarioId());

            if (nuevoTipo == null || nuevaFechaAplicacion == null || nuevaFechaProximaDosis == null ||
                    nuevoMascotaIdStr == null || nuevoInventarioIdStr == null ||
                    nuevoTipo.isEmpty() || nuevaFechaAplicacion.isEmpty() || nuevaFechaProximaDosis.isEmpty() ||
                    nuevoMascotaIdStr.isEmpty() || nuevoInventarioIdStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Todos los campos son obligatorios");
                return;
            }

            int nuevaMascotaId = Integer.parseInt(nuevoMascotaIdStr);
            int nuevoInventarioId = Integer.parseInt(nuevoInventarioIdStr);

            TratamientoAntiparasitario tratamientoActualizado = new TratamientoAntiparasitario(
                    id, nuevoTipo, nuevaFechaAplicacion, nuevaFechaProximaDosis, nuevaMascotaId, nuevoInventarioId
            );

            if (tratamientoDAO.actualizarTratamiento(tratamientoActualizado)) {
                JOptionPane.showMessageDialog(this, "Tratamiento actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el tratamiento");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: IDs deben ser numeros");
        }
    }

    private void eliminarTratamiento() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del tratamiento a eliminar:");
        if (idStr == null || idStr.trim().isEmpty()) return;

        try {
            int id = Integer.parseInt(idStr);
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar el tratamiento?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                if (tratamientoDAO.eliminarTratamiento(id)) {
                    JOptionPane.showMessageDialog(this, "Tratamiento eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Error: No se encontro un tratamiento con ese ID");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: ID invalido");
        }
    }
}