/*package Controlador;

import Modelo.CategoriaProducto;
import Modelo.CRUDCategoriaProducto;
import Utilidades.ButtonColumn;
import Utilidades.IButtonClickListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vista.PanelCategoriaProducto;

public class CategoriaProductoControllerList implements IButtonClickListener {
    private final CRUDCategoriaProducto categoriaProductoModelo;
    private final PanelCategoriaProducto vistaCategoriaProducto;

    public CategoriaProductoControllerList(PanelCategoriaProducto vistaCategoriaProducto) {
        this.vistaCategoriaProducto = vistaCategoriaProducto;
        this.categoriaProductoModelo = new CRUDCategoriaProducto();
    }

    public void actualizarVista() {
        // Lógica para actualizar la vista con la información más reciente
        cargarCategoriasEnTabla();
    }
    
    public void cargarCategoriasEnTabla() {
        List<CategoriaProducto> listaCategorias = categoriaProductoModelo.listarCategorias();

        // Crear modelo de tabla y establecerlo en la tabla
        DefaultTableModel model = new DefaultTableModel();
        vistaCategoriaProducto.tbCategoria.setModel(model);

        // Añadir columnas al modelo de la tabla
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Ver detalles");
        model.addColumn("Editar");
        model.addColumn("Eliminar");

        // Añadir filas al modelo de la tabla
        for (CategoriaProducto categoria : listaCategorias) {
            model.addRow(new Object[]{
                categoria.getId(),
                categoria.getNombre(),
                "Ver detalles", "Editar", "Eliminar"
            });
        }

        // Crear los botones en las columnas correspondientes
        new ButtonColumn(vistaCategoriaProducto.tbCategoria, 2, this); // Ver detalles
        new ButtonColumn(vistaCategoriaProducto.tbCategoria, 3, this); // Editar
        new ButtonColumn(vistaCategoriaProducto.tbCategoria, 4, this); // Eliminar
    }
    
    @Override
    public void buttonClicked(int row, int column, String buttonText) {
        int id = (int) vistaCategoriaProducto.tbCategoria.getModel().getValueAt(row, 0);
        switch (buttonText) {
            case "Ver detalles" -> abrirDetallesCategoria(id);
            case "Editar" -> abrirEditarCategoria(id);
            case "Eliminar" -> eliminarCategoria(id);
        }
    }
    
    private void abrirDetallesCategoria(int id) {
        System.out.println("detalle: " + id);
    }

    private void abrirEditarCategoria(int id) {
        System.out.println("editar: " + id);
    }

    private void eliminarCategoria(int id) {
        System.out.println("eliminar: " + id);
    }
}*/ 
