package Controlador.Producto;

import Modelo.CRUDproducto;
import Modelo.Producto;
import java.util.List;

public class ProductoControllerEdit {
    private final CRUDproducto productoModelo;
    
    public ProductoControllerEdit(){
        this.productoModelo = new CRUDproducto();
    }
    
    public List<Producto> buscarProductoPorCodigo(String codigobar){
        return productoModelo.buscarProductoPorCodigo(codigobar);
    }
    
    public void editarProducto(Long id, String nombre, Float precio_compra, Float precio_venta, int stock_disponible, String codigoBarras, int categoria_producto_id, int estado_id){ 
        productoModelo.editarProducto(id, nombre, precio_compra, precio_venta, stock_disponible, codigoBarras, categoria_producto_id, estado_id);
    }
    
}
