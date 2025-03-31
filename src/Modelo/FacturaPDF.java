package Modelo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FacturaPDF {

    public void escribirFactura() {
        Document document = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Factura.pdf"));

            document.open();

            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());

            g.setColor(Color.blue);
            g.drawRect(1, 1, 593, 790);

            g.setColor(new Color(101, 121, 206));
            g.fillOval(290, 90, 280, 100);

            Font font1 = new Font("Arial", Font.BOLD, 20);
            g.setFont(font1);

            g.setColor(Color.RED);
            g.drawString("Factura PDF", 40, 150);

            g.setColor(Color.BLUE);
            g.drawString("Factura PDF", 40, 150);

            ImageIcon imagen = new ImageIcon(getClass().getResource("imagenes/Codigo_QR.png"));
            g.drawImage(imagen.getImage(), 230, 220, 250, 250, null);

            Font font2 = new Font("Tahoma", Font.PLAIN, 15);
            g.setFont(font2);
            g.setColor(Color.BLACK);
            g.drawString("Codigo QR de tu factura", 60, 460);

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        document.close();

        JOptionPane.showMessageDialog(null, "Factura PDF creada con exito");
    }

    public static void main(String[] args) {
        FacturaPDF obj = new FacturaPDF();
        obj.escribirFactura();
    }
}