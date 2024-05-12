package Controlador.Venta;

import Modelo.CRUDventa;
import Modelo.Venta;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import static Constantes.ConstantesNombreBotonesTablas.*;

public class VentaControllerList {

    private final CRUDventa modelo;

    public VentaControllerList() {
        this.modelo = new CRUDventa();
    }
    
    //Funcion para buscar de acuerdo el nombre del usuario que realizo venta
    public DefaultTableModel obtenerModeloTabla(String textoBusqueda) {
        List<Venta> listaVentas = this.modelo.buscarVentaPorUsuario(textoBusqueda);
        String[] columnNames = {"ID","Usuario", "fecha_hora", "Impuesto", "Total", "Metodo", "Comprobante", VER_DETALLES, EDITAR, ELIMINAR};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Venta venta : listaVentas) {
            Object[] row = new Object[]{
                venta.getId(),
                venta.getUsuario(),
                venta.getFecha_hora(),
                venta.getImpuesto(),
                venta.getTotal(),
                venta.getMetodo_pago(),
                venta.getComprobante(),
                VER_DETALLES,
                EDITAR,
                ELIMINAR
            };
            model.addRow(row);
        }
        return model;
    }
    
}
