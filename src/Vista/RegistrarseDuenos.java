package Vista;

import javax.swing.*;
import java.awt.*;
import Inicio.LoginDuenos;

public class RegistrarseDuenos extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnRegistrar;
    private LoginDuenos login;

    public RegistrarseDuenos(LoginDuenos login) {
        this.login = login;

        setTitle("Registro de Dueño");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Nuevo Usuario:"));
        txtUsuario = new JTextField();
        add(txtUsuario);

        add(new JLabel("Contraseña:"));
        txtContrasena = new JPasswordField();
        add(txtContrasena);

        btnRegistrar = new JButton("Registrar");
        add(btnRegistrar);

        btnRegistrar.addActionListener(e -> registrarUsuario());

        setVisible(true);
    }

    private void registrarUsuario() {
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());

        if (!usuario.isEmpty() && !contrasena.isEmpty()) {
            LoginDuenos.registrarUsuario(usuario, contrasena);
            JOptionPane.showMessageDialog(this, "Acceso permitido", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            login.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Debe completar ambos campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
