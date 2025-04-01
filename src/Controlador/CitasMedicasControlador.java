/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CitasMedicas;
import Modelo.CitasMedicasDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CitasMedicasControlador {
    
    private CitasMedicasDAO citasMedicasDAO;
    
    public CitasMedicasControlador(CitasMedicasDAO citasMedicasDAO){
        this.citasMedicasDAO = citasMedicasDAO;
    }
    
    //Agregar Citas
    public boolean agregarCitas(CitasMedicas citasMedicas){
        return citasMedicasDAO.insertarCitas(citasMedicas);
    }
    
    //Listar Citas
    public void cargarDuenosEnTabla(javax.swing.JTable tablaDueno) {
        
        
        List<CitasMedicas> lista = citasMedicasDAO.obtenerCitas();
        DefaultTableModel modelo = (DefaultTableModel) tablaDueno.getModel();
        modelo.setRowCount(0);

        for (CitasMedicas citas : lista) {
            modelo.addRow(new Object[]{
                citas.getId(),
                citas.getFecha(),
                citas.getHora(),
                citas.getMascotaId(),
                citas.getDuenoId(),
                citas.getEstado()
            });
        }
    }
    
    //buscar citas por fecha
    public CitasMedicas buscarCitas(String fecha){
        return citasMedicasDAO.obtenerCitasporFecha(fecha);
    }
    
    //Actualizar Citas
    public boolean actualizarCitas(CitasMedicas citasMedicas){
        return citasMedicasDAO.actualizarCitas(citasMedicas);
    }
    
    public boolean eliminarCitas(int id){
        return citasMedicasDAO.eliminarCita(id);
    }
    
}
