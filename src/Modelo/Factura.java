package Modelo;

import java.math.BigDecimal;

public class Factura {
    private int id;
    private String fecha;
    private int dueno_id;
    private BigDecimal total;
    private String cufe;
    private String codigo_qr;

    public Factura(int id, String fecha, int dueno_id , BigDecimal total, String cufe, String codigo_qr ) {
        this.id = id;
        this.fecha = fecha;
        this.dueno_id = dueno_id;
        this.total = total;
        this.cufe = cufe;
        this.codigo_qr = codigo_qr;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public int getDueno_id() { return dueno_id; }
    public void setDueno_id(int dueno_id) { this.dueno_id = dueno_id; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public String getCufe() { return cufe; }
    public void setCufe(String cufe) { this.cufe = cufe; }

    public String getCodigo_qr() { return codigo_qr; }
    public void setCodigo_qr(String codigo_qr) { this.codigo_qr = codigo_qr; }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", dueno_id='" + dueno_id + '\'' +
                ", total=" + total +
                ", cufe=" + cufe +
                ", codigo_qr=" + codigo_qr +
                '}';
    }
}