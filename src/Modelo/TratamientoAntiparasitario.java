package Modelo;

public class TratamientoAntiparasitario {
    private int id;
    private String tipo;
    private String fechaAplicacion;
    private String fechaProximaDosis;
    private int mascotaId;
    private int inventarioId;

    public TratamientoAntiparasitario(int id, String tipo, String fechaAplicacion, String fechaProximaDosis, int mascotaId, int inventarioId) {
        this.id = id;
        this.tipo = tipo;
        this.fechaAplicacion = fechaAplicacion;
        this.fechaProximaDosis = fechaProximaDosis;
        this.mascotaId = mascotaId;
        this.inventarioId = inventarioId;
    }

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public String getFechaAplicacion() { return fechaAplicacion; }
    public String getFechaProximaDosis() { return fechaProximaDosis; }
    public int getMascotaId() { return mascotaId; }
    public int getInventarioId() { return inventarioId; }

    public void setId(int id) { this.id = id; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setFechaAplicacion(String fechaAplicacion) { this.fechaAplicacion = fechaAplicacion; }
    public void setFechaProximaDosis(String fechaProximaDosis) { this.fechaProximaDosis = fechaProximaDosis; }
    public void setMascotaId(int mascotaId) { this.mascotaId = mascotaId; }
    public void setInventarioId(int inventarioId) { this.inventarioId = inventarioId; }
}