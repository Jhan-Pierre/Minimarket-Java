package Validaciones;

import Controlador.CestaTemporal.CestaTemporalControllerList;
import vista.Venta.PanelVentaCreate;

public class ValidateVentaCreate {
    
    
    
    public static boolean validarCampos(PanelVentaCreate vista) {
        // Limpiar los mensajes de error anteriores
        limpiarMensajesError(vista);

        boolean camposValidos = true;

        // Verficar si hay registro en la tabla
        if (vista.tbVenta.getRowCount() == 0) {
            vista.errorCodigoBarras.setText("Debe agregar al menos un producto");
            camposValidos = false;
        }
        
        // Verificar campo de IGV
        try {
            Double igv = Double.valueOf(vista.txtIGV.getText());
            if (igv <= 0) {
                vista.errorIGV.setText("El IGV debe ser mayor que cero");
                camposValidos = false;
            }
        } catch (NumberFormatException e) { //si falla la conversion es porque es de un tipo diferente
            vista.errorIGV.setText("El IGV debe ser un número válido");
            camposValidos = false;
        }

        // Verificar campo de total
        try {
            Double total = Double.valueOf(vista.txtTotal.getText());
            if (total <= 0) {
                vista.errorTotal.setText("Campo Requerido");
                camposValidos = false;
            }
        } catch (NumberFormatException e) { //si falla la conversion es porque es de un tipo diferente
            vista.errorTotal.setText("El total debe ser un número válido");
            camposValidos = false;
        }

        // Validar selección de tipo de comprobante
        if (vista.cboTipoComprobante.getSelectedIndex() == 0) {
            vista.errorTipoComprobante.setText("Selecione una opción");
            camposValidos = false;
        }

        // Validar selección de método de pago
        if (vista.cboMetodoPago.getSelectedIndex() == 0) {
            vista.errorMetodoPago.setText("Selecione una opción");
            camposValidos = false;
        }

        return camposValidos;
    }

    public static boolean validarCestaTemporal(PanelVentaCreate vista){
        limpiarMensajesError(vista);
         
        boolean camposValidos = true;
        if (vista.txtCodigoBarras.getText().isEmpty()) {
            vista.errorCodigoBarras.setText("El codigo de barras es requerido");
            camposValidos = false;
        }else{
            CestaTemporalControllerList cestaTemporalController = new CestaTemporalControllerList();
            boolean existe = cestaTemporalController.existeCodigoBarras(vista.txtCodigoBarras.getText());
            if(!existe){
                vista.errorCodigoBarras.setText("El codigo de barras no existe");
                camposValidos = false;
            }
        }
        return camposValidos;
    } 
     
    public static void limpiarMensajesError(PanelVentaCreate vista) {
        // Limpiar los mensajes de error
        vista.errorIGV.setText("");
        vista.errorTotal.setText("");
        vista.errorTipoComprobante.setText("");
        vista.errorMetodoPago.setText("");
        vista.errorCodigoBarras.setText("");
        vista.errorTipoComprobante.setText("");
    }
}
