/*
package Controlador;

import Modelo.ProductoDAO;
import Modelo.Productos;
import Vista.ProductosVista;
import java.util.List;
import java.util.Scanner;

public class ProductoControlador {
    private ProductoDAO duenoDAO;
    private ProductosVista productosVista;
    private Scanner leer;

    public ProductoControlador(ProductoDAO duenoDAO, ProductosVista productosVista) {
        this.duenoDAO = duenoDAO;
        this.productosVista = productosVista;
        this.leer = new Scanner(System.in);
    }

    public void iniciar() {
        boolean regresar = true;
        while (regresar) {
            System.out.println("=============================");
            System.out.println("       Menú Inventario       ");
            System.out.println("=============================");
            System.out.println("1. Agregar productos");
            System.out.println("2. Listar productos");
            System.out.println("3. Actualizar productos");
            System.out.println("4. Eliminar productos");
            System.out.println("5. Buscar producto por ID");
            System.out.println("6. Salir del Programa");
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(leer.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número válido");
                continue;
            }

            switch (opcion) {
                case 1:
                    // Agregar producto
                    Productos nuevoProducto = productosVista.agregarProductos();
                    if (nuevoProducto != null) {
                        boolean agregado = duenoDAO.insertarProductos(nuevoProducto);
                        if (agregado) {
                            System.out.println("Producto agregado correctamente");
                        } else {
                            System.out.println("Error al agregar el producto");
                        }
                    }
                    break;

                case 2:
                    // Listar productos
                    List<Productos> listaProductos = duenoDAO.obtenerProductos();
                    if (listaProductos.isEmpty()) {
                        System.out.println("No hay productos registrados");
                    } else {
                        productosVista.mostrarProductos(listaProductos);
                    }
                    break;

                case 3:
                    // Actualizar producto
                    try {
                        System.out.print("Ingrese el ID del producto a actualizar: ");
                        int idActualizar = Integer.parseInt(leer.nextLine().trim());

                        Productos productoExistente = duenoDAO.buscarProductoPorId(idActualizar);

                        if (productoExistente == null) {
                            System.out.println("No se encontró un producto con ese ID");
                            break;
                        }

                        Productos productoActualizado = productosVista.actualizarProducto(productoExistente);

                        if (productoActualizado != null) {
                            boolean actualizado = duenoDAO.actualizarProductos(productoActualizado);
                            if (actualizado) {
                                System.out.println("Producto actualizado correctamente");
                            } else {
                                System.out.println("Error al actualizar el producto");
                            }
                        } else {
                            System.out.println("No se realizaron cambios en el producto");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ingresa un número válido");
                    }
                    break;

                case 4:
                    // Eliminar producto
                    try {
                        System.out.print("Ingrese el ID del producto a eliminar: ");
                        int idEliminar = Integer.parseInt(leer.nextLine().trim());

                        Productos productoAEliminar = duenoDAO.buscarProductoPorId(idEliminar);

                        if (productoAEliminar == null) {
                            System.out.println("No se encontró un producto con ese ID");
                        } else {
                            boolean eliminado = duenoDAO.eliminarProducto(idEliminar);
                            if (eliminado) {
                                System.out.println("Producto eliminado con éxito");
                            } else {
                                System.out.println("Error al eliminar el producto");
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ingresa un número válido");
                    }
                    break;

                case 5:
                    // Buscar producto por ID
                    try {
                        System.out.print("Ingrese el ID del producto a buscar: ");
                        int idBuscar = Integer.parseInt(leer.nextLine().trim());

                        Productos producto = duenoDAO.buscarProductoPorId(idBuscar);
                        if (producto != null) {
                            System.out.println("Producto encontrado: \n" + producto);
                        } else {
                            System.out.println("No se encontró un producto con ese ID");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ingresa un número válido");
                    }
                    break;

                case 6:
                    // Salir del programa
                    System.out.println("Saliendo del Programa...");
                    regresar = false;
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }
        leer.close();
    }
}
*/