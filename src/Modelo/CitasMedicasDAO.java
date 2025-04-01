/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilmer
 */
public class CitasMedicasDAO {
    
    private String URL = "jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn";

    private String USUARIO = "ue1oyjioflexxw8f";
    private String PASSWORD = "RSMHhaXROhzgve0aR7Jb";

    //Metodo para conectar a la BBDD
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
    
    //Crear (insert)
    public boolean insertarCitas(CitasMedicas citasMedicas) {
        String sql = "insert into citas_medicas (fecha, hora, mascota_id, dueno_id, estado) values (?,?,?,?,?)";
        try (
                Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
            //Asignar valores a las incognitas
            solicitud.setString(1, citasMedicas.getFecha());
            solicitud.setString(2, citasMedicas.getHora());
            solicitud.setInt(3, citasMedicas.getMascotaId());
            solicitud.setInt(4, citasMedicas.getDuenoId());
            solicitud.setString(5, citasMedicas.getEstado());
            

            int filas = solicitud.executeUpdate();
            
             
             return filas > 0;
            

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
            
        }
    }
    
    //listar Citas
    public List<CitasMedicas> obtenerCitas() {
        List<CitasMedicas> listaCitas = new ArrayList<>();
        String sql = "select * from citas_medicas";
        
        try ( 
                Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql); ResultSet resultado = solicitud.executeQuery();) {
            while (resultado.next()) {
                
                CitasMedicas Ci = new CitasMedicas(
             resultado.getInt(1),
               resultado.getString(2),
               resultado.getString(3),
          resultado.getInt(4),
               resultado.getInt(5),
                resultado.getString(6)
                        );
                listaCitas.add(Ci);
                
                
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCitas;

    }
    
    
    //Buscar Citas por fecha
    public CitasMedicas obtenerCitasporFecha(String fecha) {
    CitasMedicas citas = null;
    String sql = "SELECT * FROM citas_medicas WHERE fecha = ?";
    
    try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
        
        solicitud.setString(1, fecha);
        ResultSet resultado = solicitud.executeQuery();

        if (resultado.next()) {
            citas = new CitasMedicas(
                resultado.getInt("id"),
                resultado.getString("fecha"),
                resultado.getString("hora"),
                resultado.getInt("mascota_id"),
                resultado.getInt("dueno_id"),
                resultado.getString("estado")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return citas;
}
    
     //Actualizar Citas
    public boolean actualizarCitas(CitasMedicas cita) {
        
    String sql = "UPDATE citas_medicas SET  hora = ?, mascota_id = ?, dueno_id = ?, estado = ? WHERE fecha = ?";
    
    try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
        
        solicitud.setString(1, cita.getHora());
        solicitud.setInt(2, cita.getMascotaId());
        solicitud.setInt(3, cita.getDuenoId());
        solicitud.setString(4, cita.getEstado());
        solicitud.setString(5, cita.getFecha());
        
         
        int filasActualizadas = solicitud.executeUpdate();
        
        return filasActualizadas > 0;
        
      
    } catch (SQLException e) {
      
        e.printStackTrace();
        return false;
    }
}
    
    //Eliminar Citas
    
    public boolean eliminarCita(int id) {
    String sql = "DELETE FROM citas_medicas WHERE id = ?";

    try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
        

        solicitud.setInt(1, id);
        int filaEliminada = solicitud.executeUpdate();
        
        return filaEliminada > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false; 
    }
}
    
    
}
