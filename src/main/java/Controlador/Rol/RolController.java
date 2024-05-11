package Controlador.Rol;

import Modelo.CRUDrol;
import Modelo.Rol;
import java.util.List;
import javax.swing.JComboBox;

public class RolController {
    private CRUDrol modelo;
    
    public RolController() {
        this.modelo = new CRUDrol();
    }
    
    public void cargarRolesEnComboBox(JComboBox<Rol> cboRol) {
        cboRol.removeAllItems(); // Limpiar el ComboBox

        // Crear y agregar el ítem inicial para 'Seleccionar rol'
        Rol seleccionarRol = new Rol(0, "Seleccionar rol");
        cboRol.addItem(seleccionarRol);

        // Cargar el resto de los roles desde la base de datos
        List<Rol> listaRoles = modelo.listarRol();
        for (Rol rol : listaRoles) {
            cboRol.addItem(rol);
        }
    }
}