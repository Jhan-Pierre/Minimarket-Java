package Controlador.Producto;

import static Constantes.ConstantesNombreBotonesTablas.*;
import Modelo.Producto;
import Modelo.CRUDproducto;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

public class ProductoControllerList {
    private final CRUDproducto productoModelo;
    private Set<String> permisosUsuario;

    public ProductoControllerList(Set<String> permisosUsuario) {
        this.productoModelo = new CRUDproducto();
        this.permisosUsuario = permisosUsuario;
    }
    
    // Función para buscar de acuerdo al nombre del producto
    public DefaultTableModel obtenerModeloTabla(String codigobar) {
        List<Producto> listaProductos = productoModelo.buscarProductoPorCodigo(codigobar);
        // Define las columnas básicas
        String[] columnNames = {"Nombre", "Precio Venta", "Stock Disponible", "Codigo de Barras", "Categoria", "Estado"};
        // Agrega las columnas de acciones si el usuario tiene permisos
        if (permisosUsuario.contains("buscar_producto")) {
            columnNames = new String[]{"Nombre", "Precio Venta", "Stock Disponible", "Codigo de Barras", "Categoria", "Estado", VER_DETALLES};
        }
        if (permisosUsuario.contains("editar_producto")) {
            columnNames = new String[]{"Nombre", "Precio Venta", "Stock Disponible", "Codigo de Barras", "Categoria", "Estado", VER_DETALLES, EDITAR};
        }
        if (permisosUsuario.contains("eliminar_producto")) {
            columnNames = new String[]{"Nombre", "Precio Venta", "Stock Disponible", "Codigo de Barras", "Categoria", "Estado", VER_DETALLES, EDITAR, ELIMINAR};
        }
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Producto producto : listaProductos) {
            Object[] row = new Object[]{
                producto.getNombre(),
                producto.getPrecio_venta(),
                producto.getStock_disponible(),
                producto.getCodigoBarras(),
                producto.getCategoria(),
                producto.getEstado()
            };
            // Agrega las celdas de acciones si el usuario tiene permisos
            if (permisosUsuario.contains("buscar_producto")) {
                row = new Object[]{producto.getNombre(), producto.getPrecio_venta(), producto.getStock_disponible(), producto.getCodigoBarras(), producto.getCategoria(), producto.getEstado(), VER_DETALLES};
            }
            if (permisosUsuario.contains("editar_producto")) {
                row = new Object[]{producto.getNombre(), producto.getPrecio_venta(), producto.getStock_disponible(), producto.getCodigoBarras(), producto.getCategoria(), producto.getEstado(), VER_DETALLES, EDITAR};
            }
            if (permisosUsuario.contains("eliminar_producto")) {
                row = new Object[]{producto.getNombre(), producto.getPrecio_venta(), producto.getStock_disponible(), producto.getCodigoBarras(), producto.getCategoria(), producto.getEstado(), VER_DETALLES, EDITAR, ELIMINAR};
            }
            model.addRow(row);
        }
        return model;
    }
}
