package Validaciones.Categoria;

public class ValidateCategoriaCreate {
    public static boolean validarNombre(String nombre) {
        // Aquí implementa la lógica de validación
        // Por ejemplo, verifica si el nombre solo contiene letras
        return nombre.matches("[a-zA-Z]+");
    }
}
