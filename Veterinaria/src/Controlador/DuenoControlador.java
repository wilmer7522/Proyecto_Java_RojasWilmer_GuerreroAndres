/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Dueno;
import Modelo.DuenoDAO;
import Vista.DuenoVista;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author wilmer
 */
public class DuenoControlador {
    
    private DuenoDAO duenoDAO;
    private DuenoVista duenoVista;
    private Scanner leer;
    
    
    public DuenoControlador(DuenoDAO duenoDAO, DuenoVista duenoVista) {
        this.duenoDAO = duenoDAO;
        this.duenoVista = duenoVista;
        this.leer = leer = new Scanner(System.in);
    }
    
    
     public void iniciarDueno(){
        
        boolean regresar = true;
        while (regresar){
            
            System.out.println("1. Agregar Dueño");
            System.out.println("2. listar Dueños");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Buscar usuario por ID");
            System.out.println("6. Menu Principal");
            System.out.println(":");
            int opcion = leer.nextInt();
            switch (opcion){
                case 1:
                    Dueno nuevoDueno = duenoVista.agregarDueno();
                    duenoDAO.insertarDueno(nuevoDueno);
                    System.out.println("Dueño Agregado!");
                    break;
                    
                    case 2:
                     System.out.println("Lista de Usuarios ");
                    List<String> listaDuenos = duenoDAO.obtenerDuenos();
                    for (String dueno : listaDuenos) {
                        System.out.println(dueno);
                    }
                    break;
                    
                    case 3:
    System.out.println("Ingrese el ID del dueño que desea actualizar: ");
    int idDueno = leer.nextInt();
    leer.nextLine(); // Consumir el salto de línea

    Dueno duenoActualizado = duenoVista.ingresarDatosDueno(idDueno);
    duenoDAO.actualizarDueno(duenoActualizado);
    break;
                    case 6:
                        regresar = false;
                        break;
            }
        }
     }
    
}
