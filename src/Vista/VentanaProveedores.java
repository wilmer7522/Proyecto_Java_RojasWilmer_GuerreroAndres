package Vista;

import Modelo.Proveedor;
import Modelo.ProveedorDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class VentanaProveedores extends JFrame {

    private final ProveedorDAO proveedorDAO;
    private final JTextArea textArea;

    public VentanaProveedores() throws SQLException {
        proveedorDAO = new ProveedorDAO();
        setTitle("Gestion de Proveedores");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton btnActualizar = new JButton("Actualizar Lista");
        JButton btnAgregar = new JButton("Agregar Proveedor");
        JButton btnEliminar = new JButton("Eliminar Proveedor");
        JButton btnEditar = new JButton("Editar Proveedor");
        JButton btnSalir = new JButton("Salir");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnActualizar);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnSalir);

        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnActualizar.addActionListener(e -> actualizarLista());
        btnAgregar.addActionListener(e -> agregarProveedor());
        btnEliminar.addActionListener(e -> eliminarProveedor());
        btnEditar.addActionListener(e -> editarProveedor());
        btnSalir.addActionListener(e -> dispose());

        actualizarLista();
        setVisible(true);
    }

    private void actualizarLista() {
        List<Proveedor> proveedores = proveedorDAO.obtenerProveedores();
        textArea.setText("");

        if (proveedores.isEmpty()) {
            textArea.append("No hay proveedores registrados\n");
        } else {
            for (Proveedor p : proveedores) {
                textArea.append("ID: " + p.getId() + " - Nombre: " + p.getNombre() +
                        " - Telefono: " + p.getContacto() + " - Direccion: " + p.getDireccion() + "\n");
            }
        }
    }

    private void agregarProveedor() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del proveedor:");
        String contacto = JOptionPane.showInputDialog("Ingrese el contacto:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección:");

        if (nombre != null && contacto != null && direccion != null &&
                !nombre.trim().isEmpty() && !contacto.trim().isEmpty() && !direccion.trim().isEmpty()) {
            proveedorDAO.insertarProveedor(new Proveedor(0, nombre, contacto, direccion));
            actualizarLista();
        } else {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarProveedor() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del proveedor a eliminar:");

        if (idStr == null || idStr.trim().isEmpty()) {
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            Proveedor proveedor = buscarProveedor(id);

            if (proveedor == null) {
                JOptionPane.showMessageDialog(this, "Proveedor no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int confirm = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar este proveedor?",
                        "Confirmacion", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    proveedorDAO.eliminarProveedor(id);
                    actualizarLista();
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarProveedor() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del proveedor a editar:");

        if (idStr == null || idStr.trim().isEmpty()) {
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            Proveedor proveedorExistente = buscarProveedor(id);

            if (proveedorExistente == null) {
                JOptionPane.showMessageDialog(this, "Proveedor no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:", proveedorExistente.getNombre());
            String nuevoContacto = JOptionPane.showInputDialog("Ingrese el nuevo contacto:", proveedorExistente.getContacto());
            String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección:", proveedorExistente.getDireccion());

            if (nuevoNombre != null && nuevoContacto != null && nuevaDireccion != null &&
                    !nuevoNombre.trim().isEmpty() && !nuevoContacto.trim().isEmpty() && !nuevaDireccion.trim().isEmpty()) {
                Proveedor proveedorActualizado = new Proveedor(id, nuevoNombre, nuevoContacto, nuevaDireccion);
                proveedorDAO.actualizarProveedor(proveedorActualizado);
                actualizarLista();
            } else {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Proveedor buscarProveedor(int id) {
        return proveedorDAO.obtenerProveedores().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}