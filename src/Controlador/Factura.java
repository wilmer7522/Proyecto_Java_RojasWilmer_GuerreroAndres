package Controlador;

import java.sql.*;
import java.io.*;

public class Factura {
    private Connection conn;

    public Factura(Connection conn) {
        this.conn = conn;
    }

    public void generarArchivoTXT() {
        String query = "SELECT * FROM inventario";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Crear el archivo de texto
            FileWriter fileWriter = new FileWriter("inventario.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir los resultados en el archivo
            while (rs.next()) {
                // Ejemplo de cómo obtener datos de las columnas
                String nombreProducto = rs.getString("nombre_producto");
                int cantidad = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");

                // Escribir los datos en el archivo
                bufferedWriter.write("Producto: " + nombreProducto + ", Cantidad: " + cantidad + ", Precio: " + precio);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            System.out.println("Archivo inventario.txt generado exitosamente.");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
