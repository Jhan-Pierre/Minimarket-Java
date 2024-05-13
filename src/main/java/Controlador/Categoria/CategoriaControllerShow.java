package Controlador.Categoria;

import Modelo.CRUDCategoria;
import Modelo.CategoriaProducto;

public class CategoriaControllerShow {
    private final CRUDCategoria categoriaModelo;
    
    public CategoriaControllerShow() {
        this.categoriaModelo = new CRUDCategoria();
    }
    
    public CategoriaProducto mostrarCategoriaPorId(Long id){
        return categoriaModelo.mostrarCategoriaPorId(id);
    }   
}
