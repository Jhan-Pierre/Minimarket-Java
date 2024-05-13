package Controlador.Categoria;

import static Constantes.ConstantesNombreBotonesTablas.*;
import Modelo.CategoriaProducto;
import Modelo.CRUDCategoria;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

public class CategoriaControllerList {
    private final CRUDCategoria categoriaModelo;
    private Set<String> permisosUsuario;

    public CategoriaControllerList(Set<String> permisosUsuario) {
        this.categoriaModelo = new CRUDCategoria();
        this.permisosUsuario = permisosUsuario;
    }

    public DefaultTableModel obtenerModeloTabla(String textoBusqueda) {
        List<CategoriaProducto> listaCategorias = categoriaModelo.buscarCategoriaProductoPorNombre(textoBusqueda);
        // Define las columnas básicas
        String[] columnNames = {"ID", "Nombre"};
        // Agrega las columnas de acciones si el usuario tiene permisos
        if (permisosUsuario.contains("buscar_categoria_producto")) {
            columnNames = new String[]{"ID", "Nombre", VER_DETALLES};
        }
        if (permisosUsuario.contains("editar_categoria_producto")) {
            columnNames = new String[]{"ID", "Nombre", VER_DETALLES, EDITAR};
        }
        if (permisosUsuario.contains("eliminar_categoria_producto")) {
            columnNames = new String[]{"ID", "Nombre", VER_DETALLES, EDITAR, ELIMINAR};
        }
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (CategoriaProducto categoria : listaCategorias) {
            Object[] row = new Object[]{
                categoria.getId(),
                categoria.getNombre()
            };
            // Agrega las celdas de acciones si el usuario tiene permisos
            if (permisosUsuario.contains("buscar_categoria_producto")) {
                row = new Object[]{categoria.getId(), categoria.getNombre(), VER_DETALLES};
            }
            if (permisosUsuario.contains("editar_categoria_producto")) {
                row = new Object[]{categoria.getId(), categoria.getNombre(), VER_DETALLES, EDITAR};
            }
            if (permisosUsuario.contains("eliminar_categoria_producto")) {
                row = new Object[]{categoria.getId(), categoria.getNombre(), VER_DETALLES, EDITAR, ELIMINAR};
            }
            model.addRow(row);
        }
        return model;
    }
}
