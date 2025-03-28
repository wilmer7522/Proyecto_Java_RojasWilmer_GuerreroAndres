/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.DuenoControlador;
import Modelo.Dueno;
import Modelo.DuenoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DuenoVista {
    
    private DuenoDAO duenoDAO;

    public DuenoVista() {
        duenoDAO = new DuenoDAO(); // Asegúrate de inicializarlo
    }

    public DuenoDAO getDuenoDAO() {
        return duenoDAO;
    }
    



  /* public void mostrarDuenos(List<Dueno> duenos){
        System.out.println("Lista de Dueños:");
        for (Dueno D:duenos){
            System.out.println(D);
        }
        
    }*/

    public Dueno agregarDueno(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Datos para nuevo Dueño");
        
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        
        System.out.println("Cedula");
        String cedula = sc.nextLine();
        
        System.out.println("Direccion");
        String direccion = sc.nextLine();
        
        System.out.println("Telefono");
        String telefono = sc.nextLine();
        
        System.out.println("Correo");
        String correo = sc.nextLine();
        
        System.out.println("Contacto de Emergencia");
        String contacto_emergencia= sc.nextLine();
        
        return new Dueno(nombre,cedula, direccion, telefono, correo, contacto_emergencia);
    }
    
    
    public Dueno ingresarDatosDueno(int id) {
    Scanner leer = new Scanner(System.in);
    
    System.out.println("Ingrese el nuevo nombre del dueño: ");
    String nombre = leer.nextLine();
    
    System.out.println("Ingrese la nueva cédula: ");
    String cedula = leer.nextLine();
    
    System.out.println("Ingrese la nueva dirección: ");
    String direccion = leer.nextLine();
    
    System.out.println("Ingrese el nuevo teléfono: ");
    String telefono = leer.nextLine();
    
    System.out.println("Ingrese el nuevo correo electrónico: ");
    String correo = leer.nextLine();
    
    System.out.println("Ingrese el nuevo contacto de emergencia: ");
    String contactoEmergencia = leer.nextLine();
    
    return new Dueno(id, nombre, cedula, direccion, telefono, correo, contactoEmergencia);
}

    
    
}



/*package Vista;

import Modelo.Dueno;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DuenoVista extends JFrame {
    private JTextField txtNombre, txtCedula, txtDireccion, txtTelefono, txtCorreo, txtEmergencia;
    private JButton btnGuardar, btnCancelar, btnListar;
    private JTable tablaDuenos;
    private DefaultTableModel modeloTabla;
    private List<Dueno> listaDuenos;

    public DuenoVista() {
        setTitle("Gestión de Dueños");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        listaDuenos = new ArrayList<>();

        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(8, 2, 5, 5));

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Cédula:"));
        txtCedula = new JTextField();
        panelFormulario.add(txtCedula);

        panelFormulario.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panelFormulario.add(txtDireccion);

        panelFormulario.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panelFormulario.add(txtTelefono);

        panelFormulario.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        panelFormulario.add(txtCorreo);

        panelFormulario.add(new JLabel("Contacto Emergencia:"));
        txtEmergencia = new JTextField();
        panelFormulario.add(txtEmergencia);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDueno();
            }
        });
        panelFormulario.add(btnGuardar);

        btnListar = new JButton("Listar Dueños");
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarDuenos();
            }
        });
        panelFormulario.add(btnListar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        panelFormulario.add(btnCancelar);

        add(panelFormulario, BorderLayout.NORTH);

        // Crear modelo de la tabla
        String[] columnas = {"Nombre", "Cédula", "Dirección", "Teléfono", "Correo", "Emergencia"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaDuenos = new JTable(modeloTabla);

        add(new JScrollPane(tablaDuenos), BorderLayout.CENTER);

        setLocationRelativeTo(null); // Centrar la ventana
    }

    private void agregarDueno() {
        String nombre = txtNombre.getText();
        String cedula = txtCedula.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();
        String emergencia = txtEmergencia.getText();

        Dueno nuevoDueno = new Dueno(nombre, cedula, direccion, telefono, correo, emergencia);
        listaDuenos.add(nuevoDueno);

        JOptionPane.showMessageDialog(this, "Dueño guardado con éxito:\n" + nuevoDueno);
        limpiarCampos();
    }

    private void listarDuenos() {
        modeloTabla.setRowCount(0); // Limpiar tabla antes de actualizar

        for (Dueno d : listaDuenos) {
            modeloTabla.addRow(new Object[]{d.getNombre(), d.getCedula(), d.getDireccion(), d.getTelefono(), d.getCorreo_electronico(), d.getContacto_emergencia()});
        }

        JOptionPane.showMessageDialog(this, "Lista de dueños actualizada.");
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtEmergencia.setText("");
    }
}*/

