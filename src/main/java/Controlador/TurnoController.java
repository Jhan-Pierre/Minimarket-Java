package Controlador;

import Modelo.CRUDturno;
import Modelo.Turno;
import java.util.List;
import javax.swing.JComboBox;

public class TurnoController {
    
    private CRUDturno modelo;
    
    public TurnoController() {
        this.modelo = new CRUDturno();
    }
    
    public void cargarTurnosEnComboBox(JComboBox<Turno> cboTurno) {
        cboTurno.removeAllItems(); // Limpiar el ComboBox
        List<Turno> listaTurnos = modelo.listarTurno();
        System.out.println(listaTurnos);
        for (Turno turno : listaTurnos) {
            cboTurno.addItem(turno);
        }
    }
}
