package Controlador.Categoria;

import Modelo.CRUDCategoria;

public class CategoriaControllerCreate {
    private final CRUDCategoria categoriaModelo;
    
    public CategoriaControllerCreate() {
        this.categoriaModelo = new CRUDCategoria();
    }
    
    public String agregarCategoria(String nombre) {
        return categoriaModelo.agregarCategoria(nombre);
    }
}
