package Lib;

import Controlador.DuenoControlador;
import Modelo.DuenoDAO;
import Vista.DuenoVista;

public class main {
    public static void main(String[] args) {
        
        DuenoDAO duenoDAO = new DuenoDAO();
        DuenoVista duenoVista = new DuenoVista();
        DuenoControlador duenoControlador = new DuenoControlador(duenoDAO,duenoVista);

        duenoControlador.iniciar();
        
    }
}