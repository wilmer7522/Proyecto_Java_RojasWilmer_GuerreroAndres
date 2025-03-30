/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author wilmer
 */
public class Mascota {
    
    private int id;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String fechaNacimiento;
    private String sexo;
    private String microchipTatuaje;
    private String foto;
    private Integer dueno;

    public Mascota(int id, String nombre, String especie, String raza, int edad, String fechaNacimiento, String sexo, String microchipTatuaje, String foto, Integer dueno) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.microchipTatuaje = microchipTatuaje;
        this.foto = foto;
        this.dueno = dueno;
    }

    public Mascota(String nombre, String especie, String raza, int edad, String fechaNacimiento, String sexo, String microchipTatuaje, String foto, Integer dueno) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.microchipTatuaje = microchipTatuaje;
        this.foto = foto;
        this.dueno = dueno;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMicrochipTatuaje() {
        return microchipTatuaje;
    }

    public void setMicrochipTatuaje(String microchipTatuaje) {
        this.microchipTatuaje = microchipTatuaje;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getDueno() {
        return dueno;
    }

    public void setDueno(Integer dueno) {
        this.dueno = dueno;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " - " +
                especie + " - " + raza + " - " +
                edad + " - " + fechaNacimiento + " - " +
                sexo + " - " + microchipTatuaje + " - " +
                foto + " - " + dueno;
    }
    
    
    
}
