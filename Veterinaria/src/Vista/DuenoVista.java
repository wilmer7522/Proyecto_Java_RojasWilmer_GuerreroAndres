/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Dueno;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author wilmer
 */
public class DuenoVista {
    
    
    public void mostrarDuenos(List<Dueno> duenos){
        System.out.println("Lista de Dueños:");
        for (Dueno D:duenos){
            System.out.println(D);
        }
    }

    public Dueno agregarDueno(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Datos para nuevo Dueño");
        
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        
        System.out.println("Cedula");
        String cedula = sc.nextLine();
        
        System.out.println("Direccion");
        String direccion = sc.nextLine();
        
        System.out.println("Telefono");
        String telefono = sc.nextLine();
        
        System.out.println("Correo");
        String correo = sc.nextLine();
        
        System.out.println("Contacto de Emergencia");
        String contacto_emergencia= sc.nextLine();
        
        return new Dueno(nombre,cedula, direccion, telefono, correo, contacto_emergencia);
    }
    
    
    public Dueno ingresarDatosDueno(int id) {
    Scanner leer = new Scanner(System.in);
    
    System.out.println("Ingrese el nuevo nombre del dueño: ");
    String nombre = leer.nextLine();
    
    System.out.println("Ingrese la nueva cédula: ");
    String cedula = leer.nextLine();
    
    System.out.println("Ingrese la nueva dirección: ");
    String direccion = leer.nextLine();
    
    System.out.println("Ingrese el nuevo teléfono: ");
    String telefono = leer.nextLine();
    
    System.out.println("Ingrese el nuevo correo electrónico: ");
    String correo = leer.nextLine();
    
    System.out.println("Ingrese el nuevo contacto de emergencia: ");
    String contactoEmergencia = leer.nextLine();
    
    return new Dueno(id, nombre, cedula, direccion, telefono, correo, contactoEmergencia);
}

    
    
}
