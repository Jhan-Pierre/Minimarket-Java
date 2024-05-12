package Controlador.MetodoPago;

import Modelo.CRUDmetodoPago;
import Modelo.MetodoPago;
import java.util.List;
import javax.swing.JComboBox;

public class MetodoPagoControllerList {
    private CRUDmetodoPago modelo;

    public MetodoPagoControllerList() {
        this.modelo = new CRUDmetodoPago();
    }
    
    public void cargarMetodoPagoEnComboBox(JComboBox<MetodoPago> cboMetodoPago) {
        cboMetodoPago.removeAllItems(); // Limpiar el ComboBox
        
        // Crear y agregar el ítem inicial para 'Seleccionar rol'
        MetodoPago seleccionarRol = new MetodoPago(0, "Seleccionar Metodo Pago");
        cboMetodoPago.addItem(seleccionarRol);
        
        List<MetodoPago> listaMetodoPago = modelo.listarTipoComprobante();

        for (MetodoPago metodoPago : listaMetodoPago) {
            cboMetodoPago.addItem(metodoPago);
        }
    }
}
