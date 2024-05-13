package Controlador.Producto;

import Modelo.CRUDproducto;

public class ProductoControllerDelete {
    private final CRUDproducto productoModelo;
    
    public ProductoControllerDelete(){
        this.productoModelo = new CRUDproducto();
    }
    
    public String eliminarProducto(Long id) {
        return productoModelo.eliminarProducto(id);
    }  
}
