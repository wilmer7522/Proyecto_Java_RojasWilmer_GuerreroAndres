/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class VeterinarioDAO {
    
    private String URL = "jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn";

    private String USUARIO = "ue1oyjioflexxw8f";
    private String PASSWORD = "RSMHhaXROhzgve0aR7Jb";

    //Metodo para conectar a la BBDD
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
    
    //Crear (insert)
    public boolean insertarVeterinario(Veterinario veterinarios) {
        String sql = "insert into veterinarios (nombre, especialidad, telefono, correo_electronico) values (?,?,?,?)";
        try (
                Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
            //Asignar valores a las incognitas
            solicitud.setString(1, veterinarios.getNombre());
            solicitud.setString(2, veterinarios.getEspecialidad());
            solicitud.setString(3, veterinarios.getTelefono());
            solicitud.setString(4, veterinarios.getCorreo());
            

            int filas = solicitud.executeUpdate();
            
             
             return filas > 0;
            

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
            
        }
    }
    
    
    
    //Leer Veterinarios
   
    public List<Veterinario> obtenerVeterinarios() {
        List<Veterinario> listaVeterinarios = new ArrayList<>();
        String sql = "select * from veterinarios";
        
        try ( 
                Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql); ResultSet resultado = solicitud.executeQuery();) {
            while (resultado.next()) {
                
                Veterinario V = new Veterinario(
             resultado.getInt(1),
               resultado.getString(2),
               resultado.getString(3),
          resultado.getString(4),
               resultado.getString(5)
                
                        );
                listaVeterinarios.add(V);
                
                
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaVeterinarios;

    }
    
    
    //Eliminar Veterinario
    
    public boolean eliminarVeterinario(int id) {
    String sql = "DELETE FROM veterinarios WHERE id = ?";

    try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
        

        solicitud.setInt(1, id);
        int filaEliminada = solicitud.executeUpdate();
        
        return filaEliminada > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false; 
    }
}
    
    //Buscar Veterinarios por id
    public Veterinario obtenerVeterinarioPorId(int id) {
    String sql = "SELECT * FROM veterinarios WHERE id = ?";
    Veterinario veterinario = null;

    try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
        solicitud.setInt(1, id);
        ResultSet resultado = solicitud.executeQuery();

        if (resultado.next()) {
            veterinario = new Veterinario(
                resultado.getInt("id"),
                resultado.getString("nombre"),
                resultado.getString("especialidad"),
                resultado.getString("telefono"),
                resultado.getString("correo_electronico")
                
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return veterinario;
}
    
    
    
    
    //Actualizar Veterinario
    public boolean actualizarVeterinario(Veterinario veterinario) {
        
    String sql = "UPDATE veterinarios SET  nombre = ?, especialidad = ?, telefono = ?, correo_electronico = ? WHERE id = ?";
    
    try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
        
        solicitud.setString(1, veterinario.getNombre());
        solicitud.setString(2, veterinario.getEspecialidad());
        solicitud.setString(3, veterinario.getTelefono());
        solicitud.setString(4, veterinario.getCorreo());
        solicitud.setInt(5, veterinario.getId());
        
         
        int filasActualizadas = solicitud.executeUpdate();
        
        return filasActualizadas > 0;
        
      
    } catch (SQLException e) {
      
        e.printStackTrace();
        return false;
    }
}
    
    
    
}
