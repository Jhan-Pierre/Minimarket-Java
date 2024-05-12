package Controlador.Venta;

import Modelo.CRUDventa;

public class VentaControllerCreate {
    private final CRUDventa modelo;
    
    public VentaControllerCreate() {
        this.modelo = new CRUDventa();
    }
    
    public void registrarVenta(Double impuesto, Double total, int comprobante_id, int metodo_pago_id, Long usuario_id){
        modelo.registrarVenta(impuesto, total, comprobante_id, metodo_pago_id, usuario_id);
    }
    
}
