package Controlador;

import Inicio.LoginDuenos;
import Inicio.Menu;
import Inicio.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        new LoginDuenos();
    }

    public static void mostrarMenu() {
        MenuPrincipal menu = new MenuPrincipal(new Menu());
        menu.setVisible(true);
    }
}
