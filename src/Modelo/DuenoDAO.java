package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DuenoDAO {
    private String URL = "jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn";
    private String USUARIO = "ue1oyjioflexxw8f";
    private String PASSWORD = "RSMHhaXROhzgve0aR7Jb";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    public boolean insertarDueno(Dueno dueno) {
        String sql = "INSERT INTO duenos (nombre, cedula, direccion, telefono, correo_electronico, contacto_emergencia) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dueno.getNombre());
            stmt.setString(2, dueno.getCedula());
            stmt.setString(3, dueno.getDireccion());
            stmt.setString(4, dueno.getTelefono());
            stmt.setString(5, dueno.getCorreo());
            stmt.setString(6, String.valueOf(dueno.getContacto_emergencia()));

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Dueno> obtenerDuenos() {
        List<Dueno> listaDuenos = new ArrayList<>();
        String sql = "SELECT * FROM duenos";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String correo = rs.getString("correo_electronico");
                int contacto_emergencia = rs.getInt("contacto_emergencia");

                Dueno dueno = new Dueno(id, nombre, telefono, direccion, correo, correo,  contacto_emergencia);
                listaDuenos.add(dueno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDuenos;
    }


    public boolean actualizarDueno(Dueno dueno) {
        String sql = "UPDATE duenos SET nombre = ?, telefono = ?, direccion = ?, correo_electronico = ?, contacto_emergencia = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dueno.getNombre());
            stmt.setString(2, dueno.getTelefono());
            stmt.setString(3, dueno.getDireccion());
            stmt.setString(4, dueno.getCorreo());
            stmt.setString(5, String.valueOf(dueno.getContacto_emergencia()));
            stmt.setInt(6, dueno.getId());

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}