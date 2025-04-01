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
        
        Connection conexion = null;
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    
    
    //Agregar Mascotas
    public boolean insertarMascota(Mascota mascotas) {
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
            //solicitud.setInt(9, mascotas.getDueno());
            if (mascotas.getDueno() == null) {
            solicitud.setNull(9, Types.INTEGER);
        } else {
            solicitud.setInt(9, mascotas.getDueno());
        }

           int filas = solicitud.executeUpdate();
           
           return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    

    public List<Mascota> obtenerMascotas() {
        List<Mascota> listaMascotas = new ArrayList<>();
        String sql = "SELECT * FROM mascotas";
        

        try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql); ResultSet resultado = solicitud.executeQuery();) {
            while (resultado.next()) {

              

                Mascota mascota = new Mascota(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getInt(5),
                        resultado.getString(6),
                        resultado.getString(7),
                        resultado.getString(8),
                        resultado.getString(9),
                       resultado.getInt(10)
                        
                        
                        //dueno // Ahora tiene el objeto completo
                );

                listaMascotas.add(mascota);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMascotas;
    }

    // Obtener Mascota completo por ID
    public Mascota obtenerMascotaId(int id) {
        String sql = "SELECT * FROM mascotas WHERE id = ?";
        Mascota mascota = null;

        try (Connection conexion = conectar(); PreparedStatement solicitud = conexion.prepareStatement(sql)) {
            solicitud.setInt(1, id);
            ResultSet resultado = solicitud.executeQuery();

            
            if (resultado.next()){
                
                Integer duenoId = resultado.getInt("dueno_id");
            if (resultado.wasNull()) {
                duenoId = null;
            }
                mascota = new Mascota(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("especie"),
                        resultado.getString("raza"),
                        resultado.getInt("edad"),
                        resultado.getString("fecha_nacimiento"),
                        resultado.getString("sexo"),
                        resultado.getString("microchip_tatuaje"),
                        resultado.getString("foto"),
                        duenoId
                      //  resultado.getInt("dueno_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mascota;

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
                    resultado.getInt("duenoId")
               
            );
            listaMascotas.add(mascota);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return listaMascotas;
}
    
    
    //Eliminar Mascota
    public boolean eliminarMascota(int id) {
    String sql = "DELETE FROM mascotas WHERE id = ?";

    try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
        

        solicitud.setInt(1, id);
        int filaEliminada = solicitud.executeUpdate();
        
        return filaEliminada > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false; 
    }
}
    
    
     //Actualizar Mascota
    public boolean actualizarMascota(Mascota mascota) {
        
        

    String sql = "UPDATE mascotas SET  nombre = ?, especie = ?, raza = ?, edad = ?, fecha_nacimiento = ?, sexo = ?, microchip_tatuaje = ?, foto = ?, dueno_id = ? WHERE id = ?";
    
    try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
        
        solicitud.setString(1, mascota.getNombre());
        solicitud.setString(2, mascota.getEspecie());
        solicitud.setString(3, mascota.getRaza());
        solicitud.setInt(4, mascota.getEdad());
        solicitud.setString(5, mascota.getFechaNacimiento());
        solicitud.setString(6, mascota.getSexo());
        solicitud.setString(7, mascota.getMicrochipTatuaje());
        solicitud.setString(8, mascota.getFoto());
        //solicitud.setInt(9, mascota.getDueno());
         if (mascota.getDueno() == null) {
            solicitud.setNull(9, Types.INTEGER);
        } else {
            solicitud.setInt(9, mascota.getDueno());
        }
        
        solicitud.setInt(10, mascota.getId());
           
        
        
        
       

        
        
        
        
        int filasActualizadas = solicitud.executeUpdate();
        
        return filasActualizadas > 0;
        
      
    } catch (SQLException e) {
      
        e.printStackTrace();
        return false;
    }
}

}
