package Controlador.TipoComprobante;

import Modelo.CRUDtipoComprobante;
import Modelo.TipoComprobante;
import java.util.List;
import javax.swing.JComboBox;


public class TipoComprobanteControllerList {
    private final CRUDtipoComprobante modelo;
    
    public TipoComprobanteControllerList() {
        this.modelo = new CRUDtipoComprobante();
    }
    
     public void cargarTipoCOmprobanteEnComboBox(JComboBox<TipoComprobante> cboTipoComrpobante) {
        cboTipoComrpobante.removeAllItems(); // Limpiar el ComboBox
        
        // Crear y agregar el ítem inicial para 'Seleccionar rol'
        TipoComprobante seleccionarTipoComprobante = new TipoComprobante(0, "Seleccionar Comprobante");
        cboTipoComrpobante.addItem(seleccionarTipoComprobante);
        
        List<TipoComprobante> listaTipoComprobante = modelo.listarTipoComprobante();

        for (TipoComprobante tipoComprobante : listaTipoComprobante) {
            cboTipoComrpobante.addItem(tipoComprobante);
        }
    }
    
    
}
