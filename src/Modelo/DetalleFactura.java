package Modelo;

import java.math.BigDecimal;

public class DetalleFactura {
    private int id;
    private int facturaId;
    private String servicioProducto;
    private int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    public DetalleFactura(int id, int facturaId, String servicioProducto, int cantidad, BigDecimal precioUnitario, BigDecimal subtotal) {
        this.id = id;
        this.facturaId = facturaId;
        this.servicioProducto = servicioProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getFacturaId() { return facturaId; }
    public void setFacturaId(int facturaId) { this.facturaId = facturaId; }

    public String getServicioProducto() { return servicioProducto; }
    public void setServicioProducto(String servicioProducto) { this.servicioProducto = servicioProducto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }

    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }

    @Override
    public String toString() {
        return "DetalleFactura{" +
                "id=" + id +
                ", facturaId=" + facturaId +
                ", servicioProducto='" + servicioProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", subtotal=" + subtotal +
                '}';
    }
}