package Controlador.Pedido;
import Modelo.CRUDPedido;
import Modelo.Pedido;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import static Constantes.ConstantesNombreBotonesTablas.*;

public class PedidoControllerList {
    private final CRUDPedido modelo;

    public PedidoControllerList() {
        this.modelo = new CRUDPedido();
    }
    
    //Funcion para buscar de acuerdo el nombre del usuario que realizo venta
    public DefaultTableModel obtenerModeloTabla(String textoBusqueda) {
        List<Pedido> listaPedido = this.modelo.buscarPedidoPorUsuario(textoBusqueda);
        String[] columnNames = {"ID","Usuario", "Proveedor", "Fecha", "Total", VER_DETALLES, EDITAR, ELIMINAR};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Pedido pedido : listaPedido) {
            Object[] row = new Object[]{
                pedido.getId(),
                pedido.getUsuario(),
                pedido.getProveedor(),
                pedido.getFecha(),
                pedido.getCostoTotal(),
                VER_DETALLES,
                EDITAR,
                ELIMINAR
            };
            model.addRow(row);
        }
        return model;
    }
    
}
