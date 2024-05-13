package Controlador.Producto;

import Modelo.CRUDproducto;


public class ProductoControllerCreate {
    
    private CRUDproducto productoModelo;
    
    public ProductoControllerCreate() {
        this.productoModelo = new CRUDproducto();
    }
    
    public void crearProducto(String nombre, Float precio_compra, Float precio_venta, int stock_disponible, String codigoBarras, int categoria_producto_id, int estado_id) {
        productoModelo.crearProducto(nombre, precio_compra, precio_venta, stock_disponible, codigoBarras, categoria_producto_id, estado_id);   
    }
}
