package Controlador;

import Inicio.LoginDuenos;
import Inicio.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        new LoginDuenos();
    }

    public static void mostrarMenu() {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }
}
