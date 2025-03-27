package Inicio;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import Controlador.Main;
import Vista.RegistrarseDuenos;

public class LoginDuenos extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnLogin;

    // Diccionario local de usuarios
    private static HashMap<String, String> credenciales = new HashMap<>();

    // Usuarios predefinidos
    static {
        credenciales.put("admin", "1234");
        credenciales.put("usuario", "mascota123");
        credenciales.put("veterinario", "veterinario123");
    }

    public LoginDuenos() {
        setTitle("Inicio de Sesión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        add(txtUsuario);

        add(new JLabel("Contraseña:"));
        txtContrasena = new JPasswordField();
        add(txtContrasena);

        btnLogin = new JButton("Iniciar Sesión");
        add(btnLogin);

        btnLogin.addActionListener(e -> autenticar());

        setVisible(true);
    }

    private void autenticar() {
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());

        if (credenciales.containsKey(usuario) && credenciales.get(usuario).equals(contrasena)) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            abrirMenuPrincipal();
        } else {
            int respuesta = JOptionPane.showConfirmDialog(this, "Usuario no encontrado. ¿Deseas registrarte?", "Registro", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                new RegistrarseDuenos(this);
                setVisible(false);
            }
        }
    }

    private void abrirMenuPrincipal() {
        this.dispose();
        Main.mostrarMenu();
    }

    public static void registrarUsuario(String usuario, String contrasena) {
        credenciales.put(usuario, contrasena);
    }
}