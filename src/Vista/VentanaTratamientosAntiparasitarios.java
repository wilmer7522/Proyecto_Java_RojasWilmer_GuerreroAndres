package Vista;

import Modelo.TratamientoAntiparasitario;
import Modelo.TratamientoAntiparasitarioDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaTratamientosAntiparasitarios extends JFrame {
    private JTextArea textArea;
    private TratamientoAntiparasitarioDAO tratamientoAntiparasitarioDAO;

    public VentanaTratamientosAntiparasitarios() {
        tratamientoAntiparasitarioDAO = new TratamientoAntiparasitarioDAO();
        setTitle("Gestión de Tratamientos Antiparasitarios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton btnVer = new JButton("Ver Tratamientos");
        JButton btnAgregar = new JButton("Agregar Tratamiento");
        JButton btnEditar = new JButton("Editar Tratamiento");
        JButton btnEliminar = new JButton("Eliminar Tratamiento");
        JButton btnSalir = new JButton("Salir");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnVer);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnSalir);

        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnVer.addActionListener(e -> mostrarTratamientos());
        btnAgregar.addActionListener(e -> agregarTratamiento());
        btnEditar.addActionListener(e -> editarTratamiento());
        btnEliminar.addActionListener(e -> eliminarTratamiento());
        btnSalir.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void mostrarTratamientos() {
        List<TratamientoAntiparasitario> lista = tratamientoAntiparasitarioDAO.obtenerTratamientos();
        textArea.setText("");

        if (lista.isEmpty()) {
            textArea.setText("No hay tratamientos antiparasitarios registrados");
            return;
        }

        for (TratamientoAntiparasitario t : lista) {
            textArea.append("ID: " + t.getId() +
                    " - Tipo: " + t.getTipo() +
                    " - Fecha de aplicacion: " + t.getFechaAplicacion() +
                    " - Proxima dosis: " + t.getFechaProximaDosis() +
                    " - Mascota ID: " + t.getMascotaId() +
                    " - Inventario ID: " + t.getInventarioId() + "\n");
        }
    }

    private void agregarTratamiento() {
        String tipo = JOptionPane.showInputDialog("Tipo:");
        String fechaAplicacion = JOptionPane.showInputDialog("Fecha de aplicacion (YYYY-MM-DD):");
        String fechaProximaDosis = JOptionPane.showInputDialog("Próxima dosis (YYYY-MM-DD):");
        String mascotaIdStr = JOptionPane.showInputDialog("ID de la mascota:");
        String inventarioIdStr = JOptionPane.showInputDialog("ID del inventario:");

        if (tipo == null || fechaAplicacion == null || fechaProximaDosis == null ||
                mascotaIdStr == null || inventarioIdStr == null ||
                tipo.isEmpty() || fechaAplicacion.isEmpty() || fechaProximaDosis.isEmpty() ||
                mascotaIdStr.isEmpty() || inventarioIdStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Todos los campos son obligatorios");
            return;
        }

        try {
            int mascotaId = Integer.parseInt(mascotaIdStr);
            int inventarioId = Integer.parseInt(inventarioIdStr);

            TratamientoAntiparasitario nuevoTratamiento = new TratamientoAntiparasitario(
                    0, tipo, fechaAplicacion, fechaProximaDosis, mascotaId, inventarioId
            );

            if (tratamientoAntiparasitarioDAO.insertarTratamiento(nuevoTratamiento)) {
                JOptionPane.showMessageDialog(this, "Tratamiento agregado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar el tratamiento");
            }
            mostrarTratamientos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: IDs deben ser numeros validos");
        }
    }

    private void eliminarTratamiento() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del tratamiento a eliminar:");
        if (idStr == null || idStr.trim().isEmpty()) return;

        try {
            int id = Integer.parseInt(idStr);
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar el tratamiento?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                if (tratamientoAntiparasitarioDAO.eliminarTratamiento(id)) {
                    JOptionPane.showMessageDialog(this, "Tratamiento eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error: No se encontro un tratamiento con ese ID");
                }
                mostrarTratamientos();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: ID invalido");
        }
    }

    private void editarTratamiento() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del tratamiento a editar:");
        if (idStr == null || idStr.trim().isEmpty()) return;

        try {
            int id = Integer.parseInt(idStr);
            List<TratamientoAntiparasitario> lista = tratamientoAntiparasitarioDAO.obtenerTratamientos();
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

            String nuevoTipo = JOptionPane.showInputDialog("Nuevo Tipo:", tratamientoExistente.getTipo());
            String nuevaFechaAplicacion = JOptionPane.showInputDialog("Nueva Fecha de Aplicacion (YYYY-MM-DD):", tratamientoExistente.getFechaAplicacion());
            String nuevaFechaProximaDosis = JOptionPane.showInputDialog("Nueva Fecha Proxima Dosis (YYYY-MM-DD):", tratamientoExistente.getFechaProximaDosis());
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

            if (tratamientoAntiparasitarioDAO.actualizarTratamiento(tratamientoActualizado)) {
                JOptionPane.showMessageDialog(this, "Tratamiento actualizado");
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el tratamiento");
            }
            mostrarTratamientos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: ID deben ser un numero");
        }
    }
}