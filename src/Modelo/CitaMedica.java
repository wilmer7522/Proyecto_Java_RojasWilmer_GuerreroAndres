package Modelo;
import java.util.Date;

public class CitaMedica {
    private int id;
    private Date fechaHora;
    private int mascotaId;
    private int duenoId;
    private int veterinarioId;
    private String estado;
    private String diagnostico;
    private String prescripcion;
    private String nombreMascota;
    private String nombreDueno;

    public CitaMedica() {}

    public CitaMedica(int id, Date fechaHora, int mascotaId, String nombreMascota, int duenoId, String nombreDueno,
                      int veterinarioId, String estado, String diagnostico, String prescripcion) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.mascotaId = mascotaId;
        this.nombreMascota = nombreMascota;
        this.duenoId = duenoId;
        this.nombreDueno = nombreDueno;
        this.veterinarioId = veterinarioId;
        this.estado = estado;
        this.diagnostico = diagnostico;
        this.prescripcion = prescripcion;
    }

    public CitaMedica(int id, Date fechaHora, int mascotaId, int duenoId, int veterinarioId,
                      String estado, String diagnostico, String prescripcion) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.mascotaId = mascotaId;
        this.duenoId = duenoId;
        this.veterinarioId = veterinarioId;
        this.estado = estado;
        this.diagnostico = diagnostico;
        this.prescripcion = prescripcion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getFechaHora() { return fechaHora; }
    public void setFechaHora(Date fechaHora) { this.fechaHora = fechaHora; }

    public int getMascotaId() { return mascotaId; }
    public void setMascotaId(int mascotaId) { this.mascotaId = mascotaId; }

    public int getDuenoId() { return duenoId; }
    public void setDuenoId(int duenoId) { this.duenoId = duenoId; }

    public int getVeterinarioId() { return veterinarioId; }
    public void setVeterinarioId(int veterinarioId) { this.veterinarioId = veterinarioId; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getPrescripcion() { return prescripcion; }
    public void setPrescripcion(String prescripcion) { this.prescripcion = prescripcion; }

    public String getNombreMascota() { return nombreMascota; }
    public void setNombreMascota(String nombreMascota) { this.nombreMascota = nombreMascota; }

    public String getNombreDueno() { return nombreDueno; }
    public void setNombreDueno(String nombreDueno) { this.nombreDueno = nombreDueno; }
}