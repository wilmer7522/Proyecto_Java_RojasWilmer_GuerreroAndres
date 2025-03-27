package Inicio;

import Vista.RegistrarseDuenos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import Controlador.Main;

public class LoginDuenos extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnRegistrar;
    private static final HashMap<String, String> credenciales = new HashMap<>();

    static {
        credenciales.put("admin", "1234");  // Usuario: admin, Contraseña: 1234
        credenciales.put("cliente", "5678");
    }

    public LoginDuenos() {
        setTitle("Login Dueños");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(20, 20, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 20, 150, 25);
        add(txtUsuario);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(20, 60, 80, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(100, 60, 150, 25);
        add(txtPassword);

        btnLogin = new JButton("Iniciar sesión");
        btnLogin.setBounds(80, 100, 130, 30);
        add(btnLogin);

        btnRegistrar = new JButton("Registrarse");
        btnRegistrar.setBounds(80, 140, 130, 30);
        add(btnRegistrar);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarCredenciales();
            }
        });

        btnRegistrar.addActionListener(e -> {
            new RegistrarseDuenos(this);
            setVisible(false);
        });

        setVisible(true);
    }

    private void validarCredenciales() {
        String usuario = txtUsuario.getText();
        String password = new String(txtPassword.getPassword());

        if (credenciales.containsKey(usuario) && credenciales.get(usuario).equals(password)) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
            this.dispose();
            Main.mostrarMenu();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void registrarUsuario(String usuario, String contrasena) {
        if (!credenciales.containsKey(usuario)) {
            credenciales.put(usuario, contrasena);
        }
    }
}
