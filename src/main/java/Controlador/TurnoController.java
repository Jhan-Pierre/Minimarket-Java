package Controlador;

import Modelo.CRUDturno;
import Modelo.Estado;
import Modelo.Turno;
import vista.PanelUsuarioCrear;
import java.util.List;
import javax.swing.JComboBox;

public class TurnoController {
    
    private PanelUsuarioCrear vista;
    private CRUDturno modelo;
    
    public TurnoController(PanelUsuarioCrear vista) {
        this.vista = vista;
        this.modelo = new CRUDturno();
    }
    
    public void cargarTurnosEnComboBox() {
         JComboBox<Turno> cboTurno = vista.cboTurno; // ComboBox que contiene objetos de tipo Turno

        vista.cboTurno.removeAllItems(); //Limpiar el cboTurno

        List<Turno> listaTurnos = modelo.listarTurno();

        for (Turno turno : listaTurnos) {
            cboTurno.addItem(turno);
        }
    }
}
