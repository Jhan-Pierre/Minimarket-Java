package Controlador.Producto;

import static Constantes.ConstantesNombreBotonesTablas.*;
import Modelo.Producto;
import Modelo.CRUDproducto;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ProductoControllerList{
    private final CRUDproducto productoModelo;
    
    public ProductoControllerList() {
        this.productoModelo = new CRUDproducto();
    }
    
    //Funcion para buscar de acuerdo al nombre del producto
     public DefaultTableModel obtenerModeloTabla(String codigobar) {
        List<Producto> listaProductos = productoModelo.buscarProductoPorCodigo(codigobar);
        String[] columnNames = {"Nombre", "Precio Venta", "Stock Disponible", "Codigo de Barras", "Categoria", "Estado", VER_DETALLES, EDITAR, ELIMINAR};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Producto producto : listaProductos) {
            Object[] row = new Object[]{
                producto.getNombre(),
                producto.getPrecio_venta(),
                producto.getStock_disponible(),
                producto.getCodigoBarras(),
                producto.getCategoria(),
                producto.getEstado(),
                VER_DETALLES,
                EDITAR,
                ELIMINAR,
            };
            model.addRow(row);
        }
        return model;
    }
 
}