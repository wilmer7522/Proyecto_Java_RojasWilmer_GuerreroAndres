/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Veterinario;
import Modelo.VeterinarioDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VeterinarioControlador {
    
    private VeterinarioDAO veterinarioDAO;
    
    
    public VeterinarioControlador(VeterinarioDAO veterinarioDAO){
        this.veterinarioDAO = veterinarioDAO;
    }
    
    
    //Agregar Veterinarios
    public boolean agregarVeterinario(Veterinario veterinarios){
        return veterinarioDAO.insertarVeterinario(veterinarios);
    }
    
    
    //listar Duenos
    public void cargarDuenosEnTabla(javax.swing.JTable tablaDueno) {
        
        
        List<Veterinario> lista = veterinarioDAO.obtenerVeterinarios();
        DefaultTableModel modelo = (DefaultTableModel) tablaDueno.getModel();
        modelo.setRowCount(0);

        for (Veterinario veterinario : lista) {
            modelo.addRow(new Object[]{
                veterinario.getId(),
                veterinario.getNombre(),
                veterinario.getEspecialidad(),
                veterinario.getTelefono(),
                veterinario.getCorreo()
            });
        }
    }
    
    
    //Eliminar Veterinario
    public boolean eliminarVeterinario(int id){
        return veterinarioDAO.eliminarVeterinario(id);
    }
    
    
    //Actualizar Veterinario
    public boolean actualizarVeterinario(Veterinario veterinario){
        return veterinarioDAO.actualizarVeterinario(veterinario);
    } 
    
    public Veterinario buscarVeterinarioID(int id){
        return veterinarioDAO.obtenerVeterinarioPorId(id);
    }
    
    
}
