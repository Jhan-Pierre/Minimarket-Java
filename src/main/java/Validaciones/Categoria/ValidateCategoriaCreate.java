/*package Validaciones.Categoria;

import vista.Categoria.PanelCategoriaCrear;

public class ValidateCategoriaCreate {
    public static boolean validarCampos(PanelCategoriaCrear vista) {
        // Limpiar los mensajes de error anteriores
        limpiarMensajesError(vista);

        boolean camposValidos = true;
    
        // Verificar campo de nombre de categoría
        if (vista.txtCategoriaCrear.getText().isEmpty()) {
            vista.errorNombreCategoria.setText("El nombre de la categoría es requerido");
            camposValidos = false;
        }

        return camposValidos;
    }

    public static void limpiarMensajesError(PanelCategoriaCrear vista) {
        // Limpiar los mensajes de error
        vista.errorNombreCategoria.setText("");
    }
}*/