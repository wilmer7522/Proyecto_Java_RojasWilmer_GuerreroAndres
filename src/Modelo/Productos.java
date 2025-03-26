package Modelo;

public class Productos {
    private int id;
    private String nombre;
    private String tipo;
    private String fabricante;
    private int cantidad_stock;
    private String fecha_vencimiento;
    private int proveedor_id;

    public Productos(int id, String nombre, String tipo, String fabricante, int cantidad_stock, String fecha_vencimiento, int proveedor_id) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fabricante = fabricante;
        this.cantidad_stock = cantidad_stock;
        this.fecha_vencimiento = fecha_vencimiento;
        this.proveedor_id = proveedor_id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getCantidad_stock() {
        return cantidad_stock;
    }

    public void setCantidad_stock(int cantidad_stock) {
        this.cantidad_stock = this.cantidad_stock;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " - " + tipo + " - " + fabricante + " - "
                + cantidad_stock + " - " + fecha_vencimiento + " - " + proveedor_id;
    }
}