/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Mascota;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author wilmer
 */
public class MascotaVista {
     public void mostrarMascotas(List<Mascota> mascotas){
        System.out.println("Lista de Mascotas: ");
        for (Mascota M: mascotas){
            System.out.println(M);
        }
    }
    
    
    public Mascota agregarMascota(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Datos para nuevas mascotas");
        
        System.out.println("Nombre: ");
        String nombre = leer.nextLine();
        
        System.out.println("Especie: ");
        String especie = leer.nextLine();
        
        System.out.println("Raza: ");
        String raza = leer.nextLine();
        
        System.out.println("Edad: ");
        int edad = leer.nextInt();
        
        System.out.println("Fecha de Nacimiento: ");
        
        String fechaNacimiento = leer.nextLine();
        
        
        leer.nextLine();
        System.out.println("Sexo: ");
        String sexo = leer.nextLine();
        
        System.out.println("Microchip o tatuaje: ");
        String microchipTatuaje = leer.nextLine();
        
        System.out.println("Foto: ");
        String foto = leer.nextLine();
        
        System.out.println("Id del dueño: ");
        int duenoId = leer.nextInt();
        
        return new Mascota(nombre, especie, raza, edad, fechaNacimiento, sexo, microchipTatuaje, foto, duenoId);
        
    }
}
