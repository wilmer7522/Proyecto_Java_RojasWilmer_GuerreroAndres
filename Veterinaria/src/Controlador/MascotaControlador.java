/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Mascota;
import Modelo.MascotaDAO;
import Modelo.Dueno;
import Modelo.DuenoDAO;
import Vista.MascotaVista;

import java.util.List;
import java.util.Scanner;

public class MascotaControlador {

    private MascotaDAO mascotaDAO;
    private MascotaVista mascotaVista;
    private DuenoDAO duenoDAO; // Agregado para buscar dueños
    private Scanner leer;

    public MascotaControlador(MascotaDAO mascotaDAO, MascotaVista mascotaVista, DuenoDAO duenoDAO) {
        this.mascotaDAO = mascotaDAO;
        this.mascotaVista = mascotaVista;
        this.duenoDAO = duenoDAO;
        this.leer = new Scanner(System.in);
    }

    public void iniciarMascota() {
        boolean regresar = true;
        while (regresar) {
            System.out.println("\nMenu principal ");
            System.out.println("1. Agregar Mascota");
            System.out.println("2. Listar Mascotas");
            System.out.println("3. Actualizar Mascota");
            System.out.println("4. Eliminar Mascota");
            System.out.println("5. Buscar dueño y sus mascotas");
            System.out.println("6. Menu Principal");
            System.out.println("Seleccione una opción:");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    Mascota nuevaMascota = mascotaVista.agregarMascota();
                    mascotaDAO.insertarMascota(nuevaMascota);
                    System.out.println("Mascota Agregada!");
                    break;

                case 2:
                    System.out.println("Lista de Mascotas");
                    List<Mascota> listaMascotas = mascotaDAO.obtenerMascotas();
                    for (Mascota mascota : listaMascotas) {
                        System.out.println(mascota);
                    }
                    break;

                case 5:
                    buscarDuenoYMascotas();
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    regresar = false;
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    public void buscarDuenoYMascotas() {
        System.out.println("Ingrese el ID del dueño:");
        int duenoId = leer.nextInt();

        // Obtener información del dueño
        Dueno dueno = duenoDAO.obtenerDuenoPorId(duenoId);

        if (dueno == null) {
            System.out.println("No se encontró un dueño con ese ID.");
            return;
        }

        System.out.println("\nInformación del Dueño:");
        System.out.println("ID: " + dueno.getId());
        System.out.println("Nombre: " + dueno.getNombre());
        System.out.println("Cédula: " + dueno.getCedula());
        System.out.println("Dirección: " + dueno.getDireccion());
        System.out.println("Teléfono: " + dueno.getTelefono());
        System.out.println("Correo Electrónico: " + dueno.getCorreo_electronico());
        System.out.println("Contacto de Emergencia: " + dueno.getContacto_emergencia());

        // Obtener mascotas del dueño
        List<Mascota> mascotas = mascotaDAO.obtenerMascotasPorDueno(duenoId);

        if (mascotas.isEmpty()) {
            System.out.println("Este dueño no tiene mascotas registradas.");
        } else {
            System.out.println("\nMascotas del Dueño:");
            for (Mascota mascota : mascotas) {
                System.out.println(mascota);
            }
        }
    }
}
