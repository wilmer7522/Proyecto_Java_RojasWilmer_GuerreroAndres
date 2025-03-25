/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import Controlador.DuenoControlador;
import Controlador.MascotaControlador;
import Modelo.DuenoDAO;
import Modelo.MascotaDAO;
import Vista.DuenoVista;
import Vista.MascotaVista;
import java.util.Scanner;

/**
 *
 * @author wilmer
 */
public class main {
    public static void main(String[] args) {
        
        DuenoDAO duenoDAO = new DuenoDAO();
        DuenoVista duenoVista = new DuenoVista();
        DuenoControlador duenoControlador = new DuenoControlador(duenoDAO,duenoVista);
        
        MascotaDAO mascotaDAO = new MascotaDAO();
        MascotaVista mascotaVista = new MascotaVista();
        MascotaControlador mascotaControlador = new MascotaControlador(mascotaDAO, mascotaVista, duenoDAO);
        
        
        Scanner leer = new Scanner(System.in);
        
        boolean regresar = true;
        
        while (regresar) {            
            System.out.println("Menu Principal");
            System.out.println("1. Dueños");
            System.out.println("2. Mascotas");
            
            int opcion = leer.nextInt();
            
            switch (opcion) {
                case 1:
                    duenoControlador.iniciarDueno();
                    break;
                    
                case 2:
                    
                    mascotaControlador.iniciarMascota();
                    break;
                    
                
            }
        }

        
        
    }
}
