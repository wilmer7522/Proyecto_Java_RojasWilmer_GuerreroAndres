package Controlador;

import Inicio.LoginDuenos;

public class Main {
    public static void main(String[] args) {
        new LoginDuenos();
    }

    public static void mostrarMenu() {
        Inicio.MenuPrincipal menu = new Inicio.MenuPrincipal();
        menu.setVisible(true);
    }
}