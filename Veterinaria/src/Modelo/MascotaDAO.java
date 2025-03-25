/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author wilmer
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

    private String URL = "jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn";

    private String USUARIO = "ue1oyjioflexxw8f";
    private String PASSWORD = "RSMHhaXROhzgve0aR7Jb";

    //Metodo para conectar a la BBDD
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    public void insertarMascota(Mascota mascotas) {
        String sql = "INSERT INTO mascotas (nombre, especie, raza, edad, fecha_nacimiento, sexo, microchip_tatuaje, foto, dueno_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
            solicitud.setString(1, mascotas.getNombre());
            solicitud.setString(2, mascotas.getEspecie());
            solicitud.setString(3, mascotas.getRaza());
            solicitud.setInt(4, mascotas.getEdad());
            solicitud.setString(5, mascotas.getFechaNacimiento());
            solicitud.setString(6, mascotas.getSexo());
            solicitud.setString(7, mascotas.getMicrochipTatuaje());
            solicitud.setString(8, mascotas.getFoto());
            solicitud.setInt(9, mascotas.getDueno().getId());

            solicitud.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Mascota> obtenerMascotas() {
        String sql = "SELECT * FROM mascotas";
        List<Mascota> listaMascotas = new ArrayList<>();

        try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql); ResultSet resultado = solicitud.executeQuery();) {
            while (resultado.next()) {

                int duenoId = resultado.getInt("dueno_id");
                Dueno dueno = getDuenoPorId(duenoId); // Obtener el dueño completo

                Mascota mascota = new Mascota(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("especie"),
                        resultado.getString("raza"),
                        resultado.getInt("edad"),
                        resultado.getString("fecha_nacimiento"),
                        resultado.getString("sexo"),
                        resultado.getString("microchip_tatuaje"),
                        resultado.getString("foto"),
                        dueno // Ahora tiene el objeto completo
                );

                listaMascotas.add(mascota);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMascotas;
    }

    // Obtener dueño completo por ID
    public Dueno getDuenoPorId(int duenoId) {
        String sql = "SELECT * FROM duenos WHERE id = ?";
        Dueno dueno = null;

        try (Connection conexion = conectar(); PreparedStatement solicitud = conexion.prepareStatement(sql)) {
            solicitud.setInt(1, duenoId);
            ResultSet resultado = solicitud.executeQuery();

            if (resultado.next()) {
                dueno = new Dueno(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("cedula"),
                        resultado.getString("direccion"),
                        resultado.getString("telefono"),
                        resultado.getString("correo_electronico"),
                        resultado.getString("contacto_emergencia")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dueno;

    }
    
    
    //Mascota por dueño
    public List<Mascota> obtenerMascotasPorDueno(int duenoId) {
    String sql = "SELECT * FROM mascotas WHERE dueno_id = ?";
    List<Mascota> listaMascotas = new ArrayList<>();

    try (Connection conexion = conectar(); PreparedStatement solicitud = conexion.prepareStatement(sql)) {
        solicitud.setInt(1, duenoId);
        ResultSet resultado = solicitud.executeQuery();

        while (resultado.next()) {
            Mascota mascota = new Mascota(
                resultado.getInt("id"),
                resultado.getString("nombre"),
                resultado.getString("especie"),
                resultado.getString("raza"),
                resultado.getInt("edad"),
                resultado.getString("fecha_nacimiento"),
                resultado.getString("sexo"),
                resultado.getString("microchip_tatuaje"),
                resultado.getString("foto"),
                new Dueno(duenoId, "", "", "", "", "", "") // Solo asignamos el ID del dueño
            );
            listaMascotas.add(mascota);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return listaMascotas;
}

}
