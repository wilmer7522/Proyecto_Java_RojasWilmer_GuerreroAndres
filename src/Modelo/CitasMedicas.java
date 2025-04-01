/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author wilmer
 */
public class CitasMedicas {
    private int id;
    private String fecha;
    private String hora;
    private int mascotaId;
    private int duenoId;
    private String estado;

    public CitasMedicas(int id, String fecha, String hora, int mascotaId, int duenoId, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.mascotaId = mascotaId;
        this.duenoId = duenoId;
        this.estado = estado;
    }

    public CitasMedicas(String fecha, String hora, int mascotaId, int duenoId, String estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.mascotaId = mascotaId;
        this.duenoId = duenoId;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(int mascotaId) {
        this.mascotaId = mascotaId;
    }

    public int getDuenoId() {
        return duenoId;
    }

    public void setDuenoId(int duenoId) {
        this.duenoId = duenoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
     @Override
    public String toString() {
        return id + " - " + fecha + " - " + hora + " - " + mascotaId + " - "
                + duenoId + " - " + estado; 
    }
    
    
}
