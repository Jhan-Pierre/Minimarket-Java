package Modelo;

import java.sql.Date;

public class Producto {
    private Long id;
    private String nombre;
    private Float precio_compra;
    private Float precio_venta;
    private int stock_disponible;
    private String codigoBarras;
    private int categoria_producto_id;
    private int estado_id;
    private String estado;
    private String categoria;

   

    public Producto(Long id, String nombre, Float precio_compra, Float precio_venta, int stock_disponible, String codigoBarras, int categoria_producto_id, int estado_id) {
        this.id = id;
        this.nombre = nombre;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stock_disponible = stock_disponible;
        this.codigoBarras = codigoBarras;
        this.categoria_producto_id = categoria_producto_id;
        this.estado_id = estado_id;
    }

    //Constructor para el buscar producto por id
    public Producto(String nombre, Float precio_venta, int stock_disponible, String codigoBarras, String categoria, String estado) {
        this.nombre = nombre;
        this.precio_venta = precio_venta;
        this.stock_disponible = stock_disponible;
        this.codigoBarras = codigoBarras;
        this.categoria = categoria;
        this.estado = estado;
    }

    
  

    Producto(Long id, String nombre, Float precio_compra, Float precio_venta, int stock_disponible, String codigoBarras, String categoria_producto_id, String estado_id) {
        this.id = id;
        this.nombre = nombre;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stock_disponible = stock_disponible;
        this.codigoBarras = codigoBarras;
        this.categoria = categoria_producto_id;
        this.estado = estado_id;
    }

       //Constructor para el mostrar producto por id
    Producto(String nombre, Float precio_compra, Float precio_venta, int stock_disponible, String codigoBarras, String categoria, String estado) {
        this.nombre = nombre;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stock_disponible = stock_disponible;
        this.codigoBarras = codigoBarras;
        this.categoria = categoria;
        this.estado = estado;
    }

        
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getStock_disponible() {
        return stock_disponible;
    }

    public void setStock_disponible(int stock_disponible) {
        this.stock_disponible = stock_disponible;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getCategoria_producto_id() {
        return categoria_producto_id;
    }

    public void setCategoria_producto_id(int categoria_producto_id) {
        this.categoria_producto_id = categoria_producto_id;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

  
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
