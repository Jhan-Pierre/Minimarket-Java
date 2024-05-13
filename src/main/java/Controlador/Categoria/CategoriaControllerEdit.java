package Controlador.Categoria;

import Modelo.CRUDCategoria;
import Modelo.CategoriaProducto;

public class CategoriaControllerEdit {
    private final CRUDCategoria categoriaModelo;
    
    public CategoriaControllerEdit(){
        this.categoriaModelo = new CRUDCategoria();
    }
    
    public CategoriaProducto buscarCategoriaPorId(Long id){
        return categoriaModelo.buscarCategoriaPorId(id);
    }
    
    public String editarCategoria(Long id, String nombre){
        return categoriaModelo.actualizarCategoria(new CategoriaProducto(id, nombre));
    }
}