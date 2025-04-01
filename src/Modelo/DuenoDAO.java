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

import Modelo.Dueno;

/**
 *
 * @author wilmer
 */
public class DuenoDAO {

    private String URL = "jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn";

    private String USUARIO = "ue1oyjioflexxw8f";
    private String PASSWORD = "RSMHhaXROhzgve0aR7Jb";

    //Metodo para conectar a la BBDD
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    //Crear (insert)
    public boolean insertarDueno(Dueno duenos) {
        String sql = "insert into duenos (nombre, cedula, direccion, telefono, correo_electronico, contacto_emergencia) values (?,?,?,?,?,?)";
        try (
                Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
            //Asignar valores a las incognitas
            solicitud.setString(1, duenos.getNombre());
            solicitud.setString(2, duenos.getCedula());
            solicitud.setString(3, duenos.getDireccion());
            solicitud.setString(4, duenos.getTelefono());
            solicitud.setString(5, duenos.getCorreo_electronico());
            solicitud.setString(6, duenos.getContacto_emergencia());

            int filas = solicitud.executeUpdate();
            
             
             return filas > 0;
            

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
            
        }
    }

    //Leer
    //
    public List<Dueno> obtenerDuenos() {
        List<Dueno> listaDuenos = new ArrayList<>();
        String sql = "select * from duenos";
        
        try ( 
                Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql); ResultSet resultado = solicitud.executeQuery();) {
            while (resultado.next()) {
                
                Dueno D = new Dueno(
             resultado.getInt(1),
               resultado.getString(2),
               resultado.getString(3),
          resultado.getString(4),
               resultado.getString(5),
                resultado.getString(6),
                resultado.getNString(7)
                        );
                listaDuenos.add(D);
                
                
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDuenos;

    }
    
    //Dueño por id
    public Dueno obtenerDuenoPorId(int duenoId) {
    String sql = "SELECT * FROM duenos WHERE id = ?";
    Dueno dueno = null;

    try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
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
    
    
    //Actualizar Dueno
    public boolean actualizarDueno(Dueno dueno) {
        
        

    String sql = "UPDATE duenos SET  nombre = ?, direccion = ?, telefono = ?, correo_electronico = ?, contacto_emergencia = ? WHERE cedula = ?";
    
    try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
        
        solicitud.setString(1, dueno.getNombre());
        solicitud.setString(2, dueno.getDireccion());
        solicitud.setString(3, dueno.getTelefono());
        solicitud.setString(4, dueno.getCorreo_electronico());
        solicitud.setString(5, dueno.getContacto_emergencia());
        solicitud.setString(6, dueno.getCedula());
        
        
        
       

        
        
        
        
        int filasActualizadas = solicitud.executeUpdate();
        
        return filasActualizadas > 0;
        
      
    } catch (SQLException e) {
      
        e.printStackTrace();
        return false;
    }
}
    
    
    
    //Eliminar Dueno
    
    public boolean eliminarDueno(String cedula) {
    String sql = "DELETE FROM duenos WHERE cedula = ?";

    try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
        

        solicitud.setString(1, cedula);
        int filaEliminada = solicitud.executeUpdate();
        
        return filaEliminada > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false; 
    }
}
    
    
    public Dueno obtenerDuenoPorCedula(String cedula) {
    Dueno dueno = null;
    String sql = "SELECT * FROM duenos WHERE cedula = ?";
    
    try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
        
        solicitud.setString(1, cedula);
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





}
