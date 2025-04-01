package Modelo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class FacturaPDF {

    public void escribirFactura(int facturaId) {
        Document document = new Document(PageSize.LETTER);

        try {
            PdfWriter.getInstance(document, new FileOutputStream("Factura.pdf"));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLUE);
            Paragraph title = new Paragraph("Factura PDF", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("\n"));

            try (Connection conn = ConexionDB.getConnection()) {
                String sql = """
                    SELECT 
                        f.id AS factura_id,
                        d.nombre AS nombre_dueno,
                        m.nombre AS nombre_mascota,
                        i.nombre AS producto_comprado,
                        dif.cantidad,
                        dif.precio_unitario,
                        dif.subtotal,
                        f.cufe,
                        f.codigo_qr
                    FROM facturas f
                    JOIN duenos d ON f.dueno_id = d.id
                    JOIN mascotas m ON d.id = m.dueno_id
                    JOIN detalle_inventario_factura dif ON f.id = dif.factura_id
                    JOIN inventario i ON dif.inventario_id = i.id
                    WHERE f.id = ?;
                """;

                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, facturaId);
                    ResultSet rs = stmt.executeQuery();

                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "No se encontro la factura con el ID " + facturaId);
                        return;
                    }

                    Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

                    do {
                        document.add(new Paragraph("Factura ID: " + rs.getInt("factura_id"), contentFont));
                        document.add(new Paragraph("Dueño: " + rs.getString("nombre_dueno"), contentFont));
                        document.add(new Paragraph("Mascota: " + rs.getString("nombre_mascota"), contentFont));
                        document.add(new Paragraph("Producto: " + rs.getString("producto_comprado"), contentFont));
                        document.add(new Paragraph("Cantidad: " + rs.getInt("cantidad"), contentFont));
                        document.add(new Paragraph("Precio Unitario: $" + rs.getDouble("precio_unitario"), contentFont));
                        document.add(new Paragraph("Subtotal: $" + rs.getDouble("subtotal"), contentFont));
                        document.add(new Paragraph("Total: $" + rs.getDouble("subtotal"), contentFont));
                        document.add(new Paragraph("CUFE: " + rs.getString("cufe"), contentFont));
                        document.add(new Paragraph("Codigo_qr: " + rs.getString("codigo_qr"), contentFont));
                        document.add(new Paragraph("\n--------------------------------------------\n"));

                    } while (rs.next());

                    String codigoQR = rs.getString("codigo_qr");

                    if (codigoQR != null && !codigoQR.isEmpty()) {
                        try {
                            InputStream is = getClass().getClassLoader().getResourceAsStream("imagenes/Codigo_QR.png");

                            if (is != null) {
                                byte[] bytes = is.readAllBytes();
                                Image qrImage = Image.getInstance(bytes);
                                qrImage.scaleAbsolute(100, 100);
                                qrImage.setAlignment(Element.ALIGN_CENTER);
                                document.add(qrImage);
                            } else {
                                document.add(new Paragraph("No se encontró la imagen del código QR en 'imagenes/Codigo_QR.png'", contentFont));
                            }
                        } catch (Exception e) {
                            document.add(new Paragraph("Error al cargar la imagen del código QR: " + e.getMessage(), contentFont));
                        }
                    } else {
                        document.add(new Paragraph("No hay código QR disponible", contentFont));
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Factura PDF creada de forma exitosa");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
        } finally {
            document.close();
        }
    }

    public static void main(String[] args) {
        int facturaId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la factura:"));
        FacturaPDF obj = new FacturaPDF();
        obj.escribirFactura(facturaId);
    }
}