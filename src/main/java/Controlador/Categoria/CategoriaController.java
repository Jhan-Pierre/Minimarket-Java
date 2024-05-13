package Controlador.Categoria;

import Modelo.CRUDCategoria;
import Modelo.CategoriaProducto;
import java.util.List;
import javax.swing.JComboBox;

public class CategoriaController {
    private CRUDCategoria modelo;
    
    public CategoriaController() {
        this.modelo = new CRUDCategoria();
    }
    
    public void cargarCategoriaEnComboBox(JComboBox<CategoriaProducto> cboCategoria) {
        cboCategoria.removeAllItems(); // Limpiar el ComboBox
        
       
        CategoriaProducto seleccionarCategoria = new CategoriaProducto(0, "Seleccionar Categoria");
        cboCategoria.addItem(seleccionarCategoria);
        
        List<CategoriaProducto> listaCategoria = modelo.listarCategoriaProducto();

        for (CategoriaProducto categoriaProducto : listaCategoria) {
            cboCategoria.addItem(categoriaProducto);
        }
    }
}