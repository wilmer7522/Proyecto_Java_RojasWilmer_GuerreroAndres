/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Dueno;
import Modelo.Mascota;
import Modelo.MascotaDAO;
import Modelo.DuenoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MascotaControlador {

    private MascotaDAO mascotaDAO;
    

    public MascotaControlador(MascotaDAO mascotaDAO, DuenoDAO duenoDAO) {
        this.mascotaDAO = mascotaDAO;
          
    }
    
    
    //Agregar Duenos
    public boolean agregarMascota(Mascota mascotas) {
        return mascotaDAO.insertarMascota(mascotas);
    }
    
    //listar Duenos
    public void cargarDuenosEnTabla(javax.swing.JTable tablaDueno) {
        // Implementación para cargar los datos en la tabla
        
        List<Mascota> lista = mascotaDAO.obtenerMascotas(); // Llamamos al DAO
        DefaultTableModel modelo = (DefaultTableModel) tablaDueno.getModel();
        modelo.setRowCount(0); // Limpiamos la tabla

        for (Mascota mascota : lista) {
            modelo.addRow(new Object[]{
                mascota.getId(),
                mascota.getNombre(),
                mascota.getEspecie(),
                mascota.getRaza(),
                mascota.getEdad(),
                mascota.getFechaNacimiento(),
                mascota.getSexo(),
                mascota.getMicrochipTatuaje(),
                mascota.getFoto(),
                mascota.getDueno()
            });
        }
    }
    
    
    //Eliminar Mascotas
    public boolean eliminarMascota(int id){
        return mascotaDAO.eliminarMascota(id);
    }
    
    //buscar Mascota por id
    public Mascota buscarMascota(int id){
        return mascotaDAO.obtenerMascotaId(id);
    }
    
    public boolean actualizarMascota(Mascota mascota) {
    return mascotaDAO.actualizarMascota(mascota); // Método que actualiza en la BD
}

   
}
