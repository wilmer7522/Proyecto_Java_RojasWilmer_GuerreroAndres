/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Mascota;
import Modelo.MascotaDAO;
import Vista.MascotaVista;

import java.util.List;
import java.util.Scanner;


public class MascotaControlador {

    private MascotaDAO mascotaDAO;
    private MascotaVista mascotaVista;
    private Scanner leer;


    public MascotaControlador(MascotaDAO mascotaDAO, MascotaVista mascotaVista) {
        this.mascotaDAO = mascotaDAO;
        this.mascotaVista = mascotaVista;
        this.leer = leer = new Scanner(System.in);
    }

    public void iniciarMascota() {
        
        boolean regresar = true;
        while (regresar) {
            System.out.println("Menu principal ");
            System.out.println("1. Agregar Mascota");
            System.out.println("2. listar Mascotas");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Buscar usuario por ID");
            System.out.println("6. Salir del Programa");
            System.out.println(":");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    Mascota nuevaMascota = mascotaVista.agregarMascota();
                    mascotaDAO.insertarMascota(nuevaMascota);
                    System.out.println("Mascota Agregada!");

                    break;

                case 2:
                    System.out.println("Lista de Mascotas");
                    List<String> listaMascotas = mascotaDAO.obtenerMascotas();
                    for (String mascota : listaMascotas) {
                        System.out.println(mascota);
                    }
                    break;

            }
        }

    }
}

