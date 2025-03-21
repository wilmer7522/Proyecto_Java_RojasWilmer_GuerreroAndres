/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author wilmer
 */
public class Dueno {
    private int id;
    private String nombre;
    private String cedula;
    private String direccion;
    private String telefono;
    private String correo;
    private String contacto_emergencia;

    public Dueno(int id, String nombre, String cedula, String direccion, String telefono, String correo, String contacto_emergencia) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.contacto_emergencia = contacto_emergencia;
    }

    public Dueno(String nombre, String cedula, String direccion, String telefono, String correo, String contacto_emergencia) {
       this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.contacto_emergencia = contacto_emergencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContacto_emergencia() {
        return contacto_emergencia;
    }

    public void setContacto_emergencia(String contacto_emergencia) {
        this.contacto_emergencia = contacto_emergencia;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " - " + cedula + " - " + direccion + " - "
                + telefono + " - " + correo + contacto_emergencia; 
    }
    
    
    
    
}
