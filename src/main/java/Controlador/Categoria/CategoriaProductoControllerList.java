package Controlador.Categoria;

import Modelo.CategoriaProducto;
import Modelo.CRUDCategoriaProducto;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CategoriaProductoControllerList {
    private final CRUDCategoriaProducto categoriaModelo;

    public CategoriaProductoControllerList() {
        this.categoriaModelo = new CRUDCategoriaProducto();
    }

    public DefaultTableModel obtenerModeloTabla(String textoBusqueda) {
        List<CategoriaProducto> listaCategorias = categoriaModelo.buscarCategoriaProductoPorNombre(textoBusqueda);
        String[] columnNames = {"ID", "Nombre"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (CategoriaProducto categoria : listaCategorias) {
            Object[] row = new Object[]{
                categoria.getId(),
                categoria.getNombre()
            };
            model.addRow(row);
        }
        return model;
    }
}
