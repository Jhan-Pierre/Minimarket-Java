package Validaciones;

//import vista.Proveedor.PanelProveedorCrear;

public class ValidateProveedorCreate {
   /* public static boolean validarCampos(PanelProveedorCrear vista) {
        // Limpiar los mensajes de error anteriores
        limpiarMensajesError(vista);

        boolean camposValidos = true;

        // Verificar campo de nombre
        if (vista.txtNombre.getText().isEmpty()) {
            vista.errorNombre.setText("El nombre es requerido");
            camposValidos = false;
        }

        // Verificar campo de RUC
        if (vista.txtRuc.getText().isEmpty()) {
            vista.errorRuc.setText("El RUC es requerido");
            camposValidos = false;
        } else if (!vista.txtRuc.getText().matches("\\d{11}")) {
            vista.errorRuc.setText("El RUC debe contener 11 dígitos numéricos");
            camposValidos = false;
        }

        // Verificar campo de teléfono
        if (vista.txtTelefono.getText().isEmpty()) {
            vista.errorTelefono.setText("El teléfono es requerido");
            camposValidos = false;
        }

        // Verificar campo de correo
        if (vista.txtCorreo.getText().isEmpty()) {
            vista.errorCorreo.setText("El correo es requerido");
            camposValidos = false;
        } else if (!vista.txtCorreo.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            vista.errorCorreo.setText("El correo electrónico no tiene un formato válido");
            camposValidos = false;
        }

        // Verificar campo de dirección
        if (vista.txtDireccion.getText().isEmpty()) {
            vista.errorDireccion.setText("La dirección es requerida");
            camposValidos = false;
        }

        // Verificar campo de descripción
        if (vista.txtDescripcion.getText().isEmpty()) {
            vista.errorDescripcion.setText("La descripción es requerida");
            camposValidos = false;
        }

        // Validar selección de estado
        if (vista.cboEstado.getSelectedIndex() == 0) {
            vista.errorEstado.setText("Debe seleccionar un estado");
            camposValidos = false;
        }

        return camposValidos;
    }

    public static void limpiarMensajesError(PanelProveedorCrear vista) {
        // Limpiar los mensajes de error
        vista.errorNombre.setText("");
        vista.errorRuc.setText("");
        vista.errorTelefono.setText("");
        vista.errorCorreo.setText("");
        vista.errorDireccion.setText("");
        vista.errorDescripcion.setText("");
        vista.errorEstado.setText("");
    }*/
}
