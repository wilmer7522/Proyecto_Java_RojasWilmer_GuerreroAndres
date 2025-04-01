/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Dueno;
import Modelo.DuenoDAO;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

public class DuenoControlador{
    
    
    
    
    
   
    private DuenoDAO duenoDAO;

    public DuenoControlador(DuenoDAO duenoDAO) {
        this.duenoDAO = duenoDAO;
        
    }
    
    //Agregar Duenos
    public boolean agregarDueno(Dueno duenos) {
        return duenoDAO.insertarDueno(duenos);
    }
    
    
//listar Duenos
    public void cargarDuenosEnTabla(javax.swing.JTable tablaDueno) {
        
        
        List<Dueno> lista = duenoDAO.obtenerDuenos();
        DefaultTableModel modelo = (DefaultTableModel) tablaDueno.getModel();
        modelo.setRowCount(0);

        for (Dueno dueno : lista) {
            modelo.addRow(new Object[]{
                dueno.getId(),
                dueno.getNombre(),
                dueno.getCedula(),
                dueno.getDireccion(),
                dueno.getTelefono(),
                dueno.getCorreo_electronico(),
                dueno.getContacto_emergencia()
            });
        }
    }
    
    
    //Eliminar Duenos
    public boolean eliminarDueno(String cedula) {
    return duenoDAO.eliminarDueno(cedula);
}
    
    
    //Buscar Dueno por cedula
    public Dueno buscarDueno(String cedula) {
    return duenoDAO.obtenerDuenoPorCedula(cedula); // Llama al método del DAO
}

    
    //Actualizar Dueno
public boolean actualizarDueno(Dueno dueno) {
    return duenoDAO.actualizarDueno(dueno); // Método que actualiza en la BD
}

    
    
    
   //Buscar Dueno por ID
public Dueno buscarDuenoId(int id){
    return duenoDAO.obtenerDuenoPorId(id);
}


    
    
}



    

