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
public class DuenoDAO {
    private String URL = "jdbc:mysql://b89xagd5xevxesubbvpn-mysql.services.clever-cloud.com:3306/b89xagd5xevxesubbvpn";

    private String USUARIO = "ue1oyjioflexxw8f";
    private String PASSWORD = "RSMHhaXROhzgve0aR7Jb";

    //Metodo para conectar a la BBDD
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
    
    
    //Crear (insert)
    public void insertarDueno(Dueno duenos) {
        String sql = "insert into duenos (nombre, cedula, direccion, telefono, correo, contacto_emergencia) values (?,?,?,?,?,?)";
        try (
                Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
            //Asignar valores a las incognitas
            solicitud.setString(1, duenos.getNombre());
            solicitud.setString(2, duenos.getCedula());
            solicitud.setString(3, duenos.getDireccion());
            solicitud.setString(4, duenos.getTelefono());
            solicitud.setString(5, duenos.getCorreo());
            solicitud.setString(6, duenos.getContacto_emergencia());
            
            //Ejecucion de la solicitud
            solicitud.executeUpdate();
            System.out.println("Dueños ingresado de manera exitosa");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    //Leer
    //
    public List<String> obtenerDuenos() {
        String sql = "select * from duenos";
        List<String> listaDuenos = new ArrayList<>();
        try (
                Connection conexionInterna = conectar(); 
                PreparedStatement solicitud = conexionInterna.prepareStatement(sql);
                ResultSet resultado = solicitud.executeQuery();) {
            while (resultado.next()) {
                listaDuenos.add(resultado.getInt("id") +
                        " - " + resultado.getString("nombre") + " - " + 
                        resultado.getString("cedula")+ " - " +
                resultado.getString("direccion")+ " - " +
                        resultado.getString("telefono") + " - " +
                        resultado.getString("correo") + " - " +
                        resultado.getString("contacto_emergencia"));
            }
        }catch(SQLException e){
            e.printStackTrace();
    }
        return listaDuenos;
    
    }
    
    
}
