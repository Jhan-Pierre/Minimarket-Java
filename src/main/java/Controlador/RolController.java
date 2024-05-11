package Controlador;

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

        List<Rol> listaRoles = modelo.listarRol();

        for (Rol rol : listaRoles) {
            cboRol.addItem(rol);
        }
    }
}