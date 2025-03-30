package Modelo;

public class ConsultasMedica extends CitaMedica {
    private int id;
    private String fechaHora;
    private String mascota;
    private String dueno;
    private String veterinario;
    private String estado;
    private String diagnostico;
    private String prescripcion;
    private String nombreMascota;
    private String nombreDueno;

    public ConsultasMedica(int id, String fechaHora, String mascota, String nombreMascota, String dueno, String nombreDueno,
                           String veterinario, String estado, String diagnostico, String prescripcion) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.mascota = mascota;
        this.nombreMascota = nombreMascota;
        this.dueno = dueno;
        this.nombreDueno = nombreDueno;
        this.veterinario = veterinario;
        this.estado = estado;
        this.diagnostico = diagnostico;
        this.prescripcion = prescripcion;
    }

    public ConsultasMedica(int id, String fechaHora, String mascota, String dueno, String veterinario,
                           String estado, String diagnostico, String prescripcion) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.mascota = mascota;
        this.dueno = dueno;
        this.veterinario = veterinario;
        this.estado = estado;
        this.diagnostico = diagnostico;
        this.prescripcion = prescripcion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }

    public String getMascota() { return mascota; }
    public void setMascota(String mascota) { this.mascota = mascota; }

    public String getDueno() { return dueno; }
    public void setDueno(String dueno) { this.dueno = dueno; }

    public String getVeterinario() { return veterinario; }
    public void setVeterinario(String veterinario) { this.veterinario = veterinario; }

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