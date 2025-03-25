package Controlador;

import Modelo.Dueno;
import Modelo.DuenoDAO;
import Vista.DuenoVista;
import java.util.List;
import java.util.Scanner;

public class DuenoControlador {
    
    private DuenoDAO duenoDAO;
    private DuenoVista duenoVista;
    private Scanner leer;

    public DuenoControlador(DuenoDAO duenoDAO, DuenoVista duenoVista) {
        this.duenoDAO = duenoDAO;
        this.duenoVista = duenoVista;
        this.leer = new Scanner(System.in);
    }

    public void iniciar() {
        boolean regresar = true;
        while (regresar) {
            System.out.println("=============================");
            System.out.println(" Menu Dueños de las mascotas ");
            System.out.println("=============================");
            System.out.println("1. Agregar Dueño");
            System.out.println("2. Listar Dueños");
            System.out.println("3. Actualizar Dueño");
            System.out.println("4. Eliminar Dueño");
            System.out.println("5. Buscar Dueño por ID");
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
                    Dueno nuevoDueno = duenoVista.agregarDueno();
                    boolean agregado = duenoDAO.insertarDueno(nuevoDueno);
                    if (agregado) {
                        System.out.println("Dueño agregado correctamente");
                    } else {
                        System.out.println("Error al agregar el dueño");
                    }
                    break;

                case 2: // Funcional
                    List<Dueno> listaDuenos = duenoDAO.obtenerDuenos();
                    if (listaDuenos.isEmpty()) {
                        System.out.println("No hay dueños registrados");
                    } else {
                        duenoVista.mostrarDuenos(listaDuenos);
                    }
                    break;

                case 3:
                    Dueno duenoActualizar = duenoVista.actualizarDueno();
                    boolean actualizado = duenoDAO.actualizarDueno(duenoActualizar);
                    if (actualizado) {
                        System.out.println("Dueño actualizado correctamente.");
                    } else {
                        System.out.println("Error al actualizar el dueño");
                    }
                    break;
/*
                case 4:
                    System.out.print("Ingrese el ID del dueño a eliminar: ");
                    int idEliminar = leer.nextInt();
                    leer.nextLine();
                    duenoDAO.eliminarDueno(idEliminar);
                    System.out.println("¡Dueño eliminado con éxito!");
                    break;

                case 5:
                    System.out.print("Ingrese el ID del dueño a buscar: ");
                    int idBuscar = leer.nextInt();
                    leer.nextLine();
                    Dueno duenoEncontrado = duenoDAO.buscarDuenoPorId(idBuscar);
                    if (duenoEncontrado != null) {
                        System.out.println("Dueño encontrado: " + duenoEncontrado);
                    } else {
                        System.out.println("No se encontró un dueño con ese ID");
                    }
                    break;
*/
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