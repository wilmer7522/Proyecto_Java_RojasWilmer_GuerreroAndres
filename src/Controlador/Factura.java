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

            FileWriter fileWriter = new FileWriter("inventario.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            while (rs.next()) {
                String nombreProducto = rs.getString("nombre_producto");
                int cantidad = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");

                bufferedWriter.write("Producto: " + nombreProducto + ", Cantidad: " + cantidad + ", Precio: " + precio);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            System.out.println("Archivo generado");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}