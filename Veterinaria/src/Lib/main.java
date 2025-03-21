/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import Controlador.DuenoControlador;
import Modelo.DuenoDAO;
import Vista.DuenoVista;

/**
 *
 * @author wilmer
 */
public class main {
    public static void main(String[] args) {
        
        DuenoDAO duenoDAO = new DuenoDAO();
        DuenoVista duenoVista = new DuenoVista();
        DuenoControlador duenoControlador = new DuenoControlador(duenoDAO,duenoVista);

        duenoControlador.iniciar();
        
    }
}
