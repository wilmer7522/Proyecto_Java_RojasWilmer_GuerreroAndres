package Controlador;

import Modelo.ProductoDAO;
import Modelo.Productos;
import Vista.ProductosVista;
import java.util.List;
import java.util.Scanner;

public class InventarioControlador {

    private ProductoDAO duenoDAO;
    private ProductosVista productosVista;
    private Scanner leer;

    public InventarioControlador(ProductoDAO duenoDAO, ProductosVista productosVista) {
        this.duenoDAO = duenoDAO;
        this.productosVista = productosVista;
        this.leer = new Scanner(System.in);
    }

    public void iniciar() {
        boolean regresar = true;
        while (regresar) {
            System.out.println("=============================");
            System.out.println("       Menu Inventario       ");
            System.out.println("=============================");
            System.out.println("1. Agregar productos");
            System.out.println("2. Listar productos");
            System.out.println("3. Actualizar productos");
            System.out.println("4. Eliminar productos");
            System.out.println("5. Buscar producto por ID");
            System.out.println("6. Salir del Programa");
            System.out.print("Seleccione una opcion: ");

            int opcion;
            try {
                opcion = leer.nextInt();
                leer.nextLine();
            } catch (Exception e) {
                System.out.println("Ingresa un número válido");
                leer.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    List<Productos> listaProductos = null;
                    Productos nuevoProducto = productosVista.agregarProductos(listaProductos);
                    boolean agregado = duenoDAO.insertarProductos(nuevoProducto);
                    if (agregado) {
                        System.out.println("Producto agregado correctamente");
                    } else {
                        System.out.println("Error al agregar el dueño");
                    }
                    break;

                case 2:
                    listaProductos = duenoDAO.obtenerProductos();
                    if (listaProductos.isEmpty()) {
                        System.out.println("No hay productos registrados");
                    } else {
                        productosVista.agregarProductos(listaProductos);
                    }
                    break;
/*
                case 3:
                    Productos actualizarProductos = productosVista.VentanaActualizarProducto();
                    boolean actualizado = duenoDAO.actualizarProductos(actualizarProductos);
                    if (actualizado) {
                        System.out.println("producto actualizado correctamente");
                    } else {
                        System.out.println("Error al actualizar el producto");
                    }
                    break;
*/
                case 4:
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    int idEliminar = leer.nextInt();
                    leer.nextLine();
                    duenoDAO.eliminarProducto(idEliminar);
                    System.out.println("¡producto eliminado con éxito!");
                    break;

                case 5:
                    System.out.print("Ingrese el ID del producto a buscar: ");
                    int idBuscar = leer.nextInt();
                    leer.nextLine();
                    Productos producto = duenoDAO.buscarProductoPorId(idBuscar);
                    if (producto != null) {
                        System.out.println("producto encontrado: " + producto);
                    } else {
                        System.out.println("No se encontró un producto con ese ID");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del Programa...");
                    regresar = false;
                    break;

                default:
                    System.out.println("Opción invalida");
            }
        }
        leer.close();
    }
}