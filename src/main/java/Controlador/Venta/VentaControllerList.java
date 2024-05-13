package Controlador.Venta;

import Modelo.CRUDventa;
import Modelo.Venta;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import static Constantes.ConstantesNombreBotonesTablas.*;

public class VentaControllerList {

    private final CRUDventa modelo;
    private Set<String> permisosUsuario;

    public VentaControllerList(Set<String> permisosUsuario) {
        this.modelo = new CRUDventa();
        this.permisosUsuario = permisosUsuario;
    }
    
    //Funcion para buscar de acuerdo el nombre del usuario que realizo venta
    public DefaultTableModel obtenerModeloTabla(String textoBusqueda) {
        List<Venta> listaVentas = this.modelo.buscarVentaPorUsuario(textoBusqueda);
        // Define las columnas básicas
        String[] columnNames = {"ID", "Usuario", "fecha_hora", "Impuesto", "Total", "Metodo", "Comprobante"};
        // Agrega las columnas de acciones si el usuario tiene permisos
        if (permisosUsuario.contains("buscar_venta")) {
            columnNames = new String[]{"ID", "Usuario", "fecha_hora", "Impuesto", "Total", "Metodo", "Comprobante", VER_DETALLES};
        }
        if (permisosUsuario.contains("editar_venta")) {
            columnNames = new String[]{"ID", "Usuario", "fecha_hora", "Impuesto", "Total", "Metodo", "Comprobante", VER_DETALLES, EDITAR};
        }
        if (permisosUsuario.contains("eliminar_venta")) {
            columnNames = new String[]{"ID", "Usuario", "fecha_hora", "Impuesto", "Total", "Metodo", "Comprobante", VER_DETALLES, EDITAR, ELIMINAR};
        }
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Venta venta : listaVentas) {
            Object[] row = new Object[]{
                venta.getId(),
                venta.getUsuario(),
                venta.getFecha_hora(),
                venta.getImpuesto(),
                venta.getTotal(),
                venta.getMetodo_pago(),
                venta.getComprobante()
            };
            // Agrega las celdas de acciones si el usuario tiene permisos
            if (permisosUsuario.contains("buscar_venta")) {
                row = new Object[]{venta.getId(), venta.getUsuario(), venta.getFecha_hora(), venta.getImpuesto(), venta.getTotal(), venta.getMetodo_pago(), venta.getComprobante(), VER_DETALLES};
            }
            if (permisosUsuario.contains("editar_venta")) {
                row = new Object[]{venta.getId(), venta.getUsuario(), venta.getFecha_hora(), venta.getImpuesto(), venta.getTotal(), venta.getMetodo_pago(), venta.getComprobante(), VER_DETALLES, EDITAR};
            }
            if (permisosUsuario.contains("eliminar_venta")) {
                row = new Object[]{venta.getId(), venta.getUsuario(), venta.getFecha_hora(), venta.getImpuesto(), venta.getTotal(), venta.getMetodo_pago(), venta.getComprobante(), VER_DETALLES, EDITAR, ELIMINAR};
            }
            model.addRow(row);
        }
        return model;
    }
}
