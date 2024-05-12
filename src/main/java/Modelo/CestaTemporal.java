package Modelo;

import java.math.BigDecimal;

public class CestaTemporal {
    
    private int id;
    private BigDecimal precio_unitario;
    private int cantidad;
    private BigDecimal subtotal;
    private BigDecimal usuario_id;
    private BigDecimal producto_id;
    private String Producto;
    private BigDecimal precio_venta;

    public CestaTemporal(int cantidad, BigDecimal subtotal, String producto, BigDecimal precio_venta) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.Producto = producto;
        this.precio_venta = precio_venta;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(BigDecimal precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(BigDecimal usuario_id) {
        this.usuario_id = usuario_id;
    }

    public BigDecimal getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(BigDecimal producto_id) {
        this.producto_id = producto_id;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public BigDecimal getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(BigDecimal precio_venta) {
        this.precio_venta = precio_venta;
    }
     
}
