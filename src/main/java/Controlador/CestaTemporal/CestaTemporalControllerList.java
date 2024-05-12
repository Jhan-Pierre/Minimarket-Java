package Controlador.CestaTemporal;

import static Constantes.ConstantesNombreBotonesTablas.ELIMINAR;
import Modelo.CRUDcestaTemporal;
import Modelo.CestaTemporal;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CestaTemporalControllerList {
    private CRUDcestaTemporal modelo;
    
    public CestaTemporalControllerList(){
        this.modelo = new CRUDcestaTemporal();
    }
    
    public DefaultTableModel consultarCestaTemporalPorIdUsuario(Long id) {
        List<CestaTemporal> listaCestaTemporal = this.modelo.consultarCestaTemporalPorIdUsuario(id);
        System.out.println(listaCestaTemporal);
        String[] columnNames = {"Producto","Precio Unitario", "Cantidad", "SubTotal"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (CestaTemporal cestaTemporal : listaCestaTemporal) {
            Object[] row = new Object[]{
                cestaTemporal.getProducto(),
                cestaTemporal.getPrecio_unitario(),
                cestaTemporal.getCantidad(),
                cestaTemporal.getSubtotal(),

            };
            model.addRow(row);
        }
        return model;
    }
}
