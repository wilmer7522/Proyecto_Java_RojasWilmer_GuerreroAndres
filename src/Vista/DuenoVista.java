package Vista;

import Modelo.Dueno;

import java.util.List;
import java.util.Scanner;

public class DuenoVista {
    private Scanner leer;
    public DuenoVista() {
        this.leer = new Scanner(System.in);
    }

    public Dueno actualizarDueno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del dueño a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo telefono: ");
        String telefono = scanner.nextLine();

        System.out.print("Nueva direccion: ");
        String direccion = scanner.nextLine();

        System.out.print("Nuevo correo: ");
        String correo = scanner.nextLine();

        System.out.print("Nuevo contacto emergencia: ");
        String contacto_emergencia = scanner.nextLine();

        return new Dueno(id, nombre, telefono, direccion, correo, correo, contacto_emergencia);
    }

    public void mostrarDuenos(List<Dueno> duenos) {
        System.out.println("Lista de Dueños:");
        for (Dueno dueno : duenos) {
            System.out.println("ID: " + dueno.getId());
            System.out.println("Nombre: " + dueno.getNombre());
            System.out.println("Teléfono: " + dueno.getTelefono());
            System.out.println("Dirección: " + dueno.getDireccion());
            System.out.println("Correo: " + dueno.getCorreo());
            System.out.println("Contacto de emergencia: " + dueno.getContacto_emergencia());
            System.out.println("---------------------------");
        }
    }

    public Dueno agregarDueno() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del dueño: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la cedula del dueno: ");
        String cedula = scanner.nextLine();


        System.out.println("Ingrese la dirección del dueño: ");
        String direccion = scanner.nextLine();

        System.out.println("Ingrese el teléfono del dueño: ");
        String telefono = scanner.nextLine();

        System.out.println("Ingrese el correo del dueño: ");
        String correo = scanner.nextLine();

        System.out.println("Ingrese el contacto de emergencia del dueno: ");
        String contacto_emergencia = scanner.nextLine();

        return new Dueno(0, nombre, cedula, direccion, telefono ,correo, contacto_emergencia);
    }
}