package Controlador;

import Modelo.CRUDrol;
import Modelo.Rol;
import java.util.List;
import vista.PanelUsuarioCrear;

public class RolController {
    private PanelUsuarioCrear vista;
    private CRUDrol modelo;
    
    public RolController(PanelUsuarioCrear vista) {
        this.vista = vista;
        this.modelo = new CRUDrol();
    }
    
    public void cargarRolesEnComboBox() {
        vista.cboRol.removeAllItems(); //Limpiar el cboRol

        List<Rol> listaRoles = modelo.listarRol();

        for (Rol rol : listaRoles) {
            vista.cboRol.addItem(rol.getNombre());
        }
    }
    
    
}
