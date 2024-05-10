package Controlador;

import Modelo.CRUDrol;
import Modelo.Rol;
import java.util.List;
import javax.swing.JComboBox;
import vista.PanelUsuarioCrear;

public class RolController {
    private PanelUsuarioCrear vista;
    private CRUDrol modelo;
    
    public RolController(PanelUsuarioCrear vista) {
        this.vista = vista;
        this.modelo = new CRUDrol();
    }
    
    public void cargarRolesEnComboBox() {
        JComboBox<Rol> cboEstado = vista.cboRol; 
        vista.cboRol.removeAllItems(); //Limpiar el cboRol

        List<Rol> listaEstado = modelo.listarRol();

        for (Rol rol : listaEstado) {
            cboEstado.addItem(rol);
        }
    }
    
    
}
