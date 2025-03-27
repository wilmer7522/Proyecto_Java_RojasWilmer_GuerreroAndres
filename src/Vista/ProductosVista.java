package Vista;

import Modelo.Productos;
import javax.swing.*;
import java.util.List;

public class ProductosVista {
    public Productos agregarProductos() {
        JTextField nombreField = new JTextField();
        JTextField tipoField = new JTextField();
        JTextField fabricanteField = new JTextField();
        JTextField stockField = new JTextField();
        JTextField fechaVencimientoField = new JTextField();
        JTextField proveedorField = new JTextField();

        Object[] message = {
                "Nombre:", nombreField,
                "Tipo:", tipoField,
                "Fabricante:", fabricanteField,
                "Stock:", stockField,
                "Fecha de Vencimiento (YYYY-MM-DD):", fechaVencimientoField,
                "Proveedor ID:", proveedorField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Agregar Producto", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String nombre = nombreField.getText();
                String tipo = tipoField.getText();
                String fabricante = fabricanteField.getText();
                int stock = Integer.parseInt(stockField.getText());
                String fechaVencimiento = fechaVencimientoField.getText();
                int proveedorId = Integer.parseInt(proveedorField.getText());

                return new Productos(0, nombre, tipo, fabricante, stock, fechaVencimiento, proveedorId);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese valores numéricos en Stock y Proveedor ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    public void mostrarProductos(List<Productos> listaProductos) {

    }
}