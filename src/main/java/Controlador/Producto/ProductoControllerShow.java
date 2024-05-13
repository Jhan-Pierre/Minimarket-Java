package Controlador.Producto;

import Modelo.CRUDproducto;
import Modelo.Producto;

public class ProductoControllerShow {
    private final CRUDproducto productoModelo;
    
    public ProductoControllerShow() {
        this.productoModelo = new CRUDproducto();
    }
    
    public Producto mostrarProductoPorCodigo(Long id){
        return productoModelo.mostrarProductoPorCodigo(id);
    }   
}
