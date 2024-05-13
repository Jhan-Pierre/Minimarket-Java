package Validaciones;

import vista.Producto.PanelProductoCrear;

public class ValidateProductoCreate {
    public static boolean validarCampos(PanelProductoCrear vista) {
        // Limpiar los mensajes de error anteriores
          // Limpiar los mensajes de error anteriores
    limpiarMensajesError(vista);

    boolean camposValidos = true;

    // Verificar campo de nombre
    if (vista.txtNombre.getText().isEmpty()) {
        vista.errorNombre.setText("El nombre es requerido");
        camposValidos = false;
    }

    // Verificar campo de precio de compra
    if (vista.txtPrecioCompra.getText().isEmpty()) {
        vista.errorPrecioCompra.setText("El precio de compra es requerido");
        camposValidos = false;
    }

    // Verificar campo de precio de venta
    if (vista.txtPrecioVenta.getText().isEmpty()) {
        vista.errorPrecioVenta.setText("El precio de venta es requerido");
        camposValidos = false;
    }

    // Verificar campo de stock disponible
    if (vista.txtStockDisponible.getText().isEmpty()) {
        vista.errorStockDisponible.setText("El stock disponible es requerido");
        camposValidos = false;
    }

    // Verificar campo de código de barras
    if (vista.txtCodigoDeBarras.getText().isEmpty()) {
        vista.errorCodigoDeBarras.setText("El código de barras es requerido");
        camposValidos = false;
    }

    // Validar selección de categoría
    if (vista.cboCategoria.getSelectedIndex() == 0) {
        vista.errorCategoria.setText("Debe seleccionar una categoría");
        camposValidos = false;
    }

    // Validar selección de estado
    if (vista.cboEstado.getSelectedIndex() == 0) {
        vista.errorEstado.setText("Debe seleccionar un estado");
        camposValidos = false;
    }

    return camposValidos;
}

    public static void limpiarMensajesError(PanelProductoCrear vista) {
        // Limpiar los mensajes de error
        vista.errorNombre.setText("");
        vista.errorPrecioCompra.setText("");
        vista.errorPrecioVenta.setText("");
        vista.errorStockDisponible.setText("");
        vista.errorCodigoDeBarras.setText("");
        vista.errorCategoria.setText("");
        vista.errorEstado.setText("");
    }
}
