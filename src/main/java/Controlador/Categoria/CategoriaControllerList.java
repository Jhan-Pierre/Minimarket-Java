package Controlador.Categoria;

import Modelo.CategoriaProducto;
import Modelo.CRUDCategoria;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CategoriaControllerList {
    private final CRUDCategoria categoriaModelo;

    public CategoriaControllerList() {
        this.categoriaModelo = new CRUDCategoria();
    }

    public DefaultTableModel obtenerModeloTabla(String textoBusqueda) {
        List<CategoriaProducto> listaCategorias = categoriaModelo.buscarCategoriaProductoPorNombre(textoBusqueda);
        String[] columnNames = {"ID", "Nombre", "Ver detalles", "Editar", "Eliminar"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (CategoriaProducto categoria : listaCategorias) {
            Object[] row = new Object[]{
                categoria.getId(),
                categoria.getNombre(),
                "Ver detalles",
                "Editar",
                "Eliminar"
            };
            model.addRow(row);
        }
        return model;
    }
}