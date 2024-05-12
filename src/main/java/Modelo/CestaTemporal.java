package Modelo;

public class CestaTemporal {
    
    private int id;
    private Double precio_unitario;
    private int cantidad;
    private Double subtotal;
    private Double usuario_id;
    private Double producto_id;
    private String Producto;
    private Double precio_venta;

    public CestaTemporal(int cantidad, Double subtotal, String producto, Double precio_venta) {
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

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Double usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Double getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Double producto_id) {
        this.producto_id = producto_id;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }
     
}
