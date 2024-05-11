package Validaciones;

import vista.PanelUsuarioCrear;
import javax.swing.JLabel;

public class ValidateUsuarioCreate {
    public static boolean validarCampos(PanelUsuarioCrear vista) {
        // Limpiar los mensajes de error anteriores
        limpiarMensajesError(vista);

        boolean camposValidos = true;

        // Verificar campo de correo
        if (vista.txtCorreo.getText().isEmpty()) {
            vista.errorCorreo.setText("El correo es requerido");
            camposValidos = false;
        } else if (!vista.txtCorreo.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            vista.errorCorreo.setText("El correo electrónico no tiene un formato válido");
            camposValidos = false;
        }

        // Verificar campo de contraseña
        if (vista.txtContraseña.getText().isEmpty()) {
            vista.errorContraseña.setText("La contraseña es requerida");
            camposValidos = false;
        }

        // Verificar campo de confirmación de contraseña
        if (vista.txtConfirmarContraseña.getText().isEmpty()) {
            vista.errorConfirmarContraseña.setText("Debe confirmar la contraseña");
            camposValidos = false;
        } else if (!vista.txtContraseña.getText().equals(vista.txtConfirmarContraseña.getText())) {
            vista.errorConfirmarContraseña.setText("Las contraseñas no coinciden");
            camposValidos = false;
        }

        // Verificar campo de teléfono
        if (vista.txtTelefono.getText().isEmpty()) {
            vista.errorTelefono.setText("El teléfono es requerido");
            camposValidos = false;
        }

        // Verificar campo de nombre
        if (vista.txtNombre.getText().isEmpty()) {
            vista.errorNombre.setText("El nombre es requerido");
            camposValidos = false;
        }

        // Verificar campo de apellido
        if (vista.txtApellido.getText().isEmpty()) {
            vista.errorApellido.setText("El apellido es requerido");
            camposValidos = false;
        }

        // Validar selección de estado
        if (vista.cboEstado.getSelectedIndex() == 0) {
            vista.errorEstado.setText("Debe seleccionar un estado");
            camposValidos = false;
        }

        // Validar selección de turno
        if (vista.cboTurno.getSelectedIndex() == 0) {
            vista.errorTurno.setText("Debe seleccionar un turno");
            camposValidos = false;
        }

        // Validar selección de rol
        if (vista.cboRol.getSelectedIndex() == 0) {
            vista.errorRol.setText("Debe seleccionar un rol");
            camposValidos = false;
        }
        
        return camposValidos;
    }

    public static void limpiarMensajesError(PanelUsuarioCrear vista) {
        // Limpiar los mensajes de error
        vista.errorCorreo.setText("");
        vista.errorContraseña.setText("");
        vista.errorConfirmarContraseña.setText("");
        vista.errorTelefono.setText("");
        vista.errorNombre.setText("");
        vista.errorApellido.setText("");
        vista.errorEstado.setText("");
        vista.errorRol.setText("");
        vista.errorTurno.setText("");
    }
}
