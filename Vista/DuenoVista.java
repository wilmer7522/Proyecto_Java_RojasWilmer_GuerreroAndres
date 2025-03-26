package Vista;

import Modelo.Productos;
import java.util.List;
import java.util.Scanner;


public class DuenoVista {
    private Scanner leer;
    public DuenoVista() {
        this.leer = new Scanner(System.in);
    }

    public Productos actualizarProductos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo tipo: ");
        String tipo = scanner.nextLine();

        System.out.print("Nuevo fabricante: ");
        String fabricante = scanner.nextLine();

        System.out.print("Nueva cantidad: ");
        int cantidad_stock = scanner.nextInt();

        System.out.print("Nueva fecha de vencimiento: ");
        String fecha_vencimiento = scanner.nextLine();

        System.out.println("Nuevo proveedor: ");
        int proveedor = scanner.nextInt();

        return new Productos(id, nombre, tipo, fabricante, cantidad_stock, fecha_vencimiento, proveedor);
    }

    public void mostrarProductos(List<Productos> productos) {
        System.out.println("Lista de Dueños:");
        for (Productos dueno : productos) {
            System.out.println("--------------------------");
            System.out.println("ID: " + dueno.getId());
            System.out.println("Nombre: " + dueno.getNombre());
            System.out.println("Tipo: " + dueno.getTipo());
            System.out.println("Fabricante: " + dueno.getFabricante());
            System.out.println("Cantidad Stock: " + dueno.getCantidad_stock());
            System.out.println("Fecha de vencimiento: " + dueno.getFecha_vencimiento());
            System.out.println("Proveedor: " + dueno.getProveedor_id());
            System.out.println("---------------------------");
        }
    }

    public Productos agregarProductos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el tipo del producto: ");
        String tipo = scanner.nextLine();

        System.out.println("Ingrese el fabricante del producto: ");
        String fabricante = scanner.nextLine();

        System.out.println("Ingrese la cantidad del producto: ");
        int cantidad_stock = scanner.nextInt();

        System.out.println("Ingrese la fecha de vencimiento del producto: ");
        String fecha_vencimiento = scanner.nextLine();

        System.out.println("Ingrese el proveedor del producto: ");
        int proveedor_id = scanner.nextInt();

        return new Productos(0, nombre, tipo, fabricante, cantidad_stock, fecha_vencimiento, proveedor_id);
    }
}