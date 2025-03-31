package Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vacuna {
    private int id;
    private String nombre;
    private String fabricante;
    private String lote;
    private String fechaAplicacion;  // Ahora es String
    private String fechaVencimiento; // Ahora es String
    private int mascotaId;
    private int inventarioId;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Vacuna(int id, String nombre, String fabricante, String lote, String fechaAplicacion, String fechaVencimiento, int mascotaId, int inventarioId) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.lote = lote;
        this.fechaAplicacion = fechaAplicacion;
        this.fechaVencimiento = fechaVencimiento;
        this.mascotaId = mascotaId;
        this.inventarioId = inventarioId;
    }

    public Vacuna(String nombre, String fabricante, String lote, String fechaAplicacion, String fechaVencimiento, int mascotaId, int inventarioId) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.lote = lote;
        this.fechaAplicacion = fechaAplicacion;
        this.fechaVencimiento = fechaVencimiento;
        this.mascotaId = mascotaId;
        this.inventarioId = inventarioId;
    }

    // Métodos para convertir entre String y LocalDate cuando sea necesario
    public LocalDate getFechaAplicacionAsDate() {
        return LocalDate.parse(fechaAplicacion, formatter);
    }

    public LocalDate getFechaVencimientoAsDate() {
        return LocalDate.parse(fechaVencimiento, formatter);
    }

    public void setFechaAplicacionFromDate(LocalDate fecha) {
        this.fechaAplicacion = fecha.format(formatter);
    }

    public void setFechaVencimientoFromDate(LocalDate fecha) {
        this.fechaVencimiento = fecha.format(formatter);
    }

    // Getters y Setters normales
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }
    public String getFechaAplicacion() { return fechaAplicacion; }
    public void setFechaAplicacion(String fechaAplicacion) { this.fechaAplicacion = fechaAplicacion; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public int getMascotaId() { return mascotaId; }
    public void setMascotaId(int mascotaId) { this.mascotaId = mascotaId; }
    public int getInventarioId() { return inventarioId; }
    public void setInventarioId(int inventarioId) { this.inventarioId = inventarioId; }
}