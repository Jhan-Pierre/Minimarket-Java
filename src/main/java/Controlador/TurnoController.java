package Controlador;

import Modelo.CRUDturno;
import Modelo.Turno;
import vista.PanelUsuarioCrear;
import java.util.List;

public class TurnoController {
    
    private PanelUsuarioCrear vista;
    private CRUDturno modelo;
    
    public TurnoController(PanelUsuarioCrear vista) {
        this.vista = vista;
        this.modelo = new CRUDturno();
    }
    
    public void cargarTurnosEnComboBox() {
        vista.cboTurno.removeAllItems(); //Limpiar el cboTurno

        List<Turno> listaTurnos = modelo.listarTurno();

        for (Turno turno : listaTurnos) {
            vista.cboTurno.addItem(turno.getNombre());
        }
    }
}
