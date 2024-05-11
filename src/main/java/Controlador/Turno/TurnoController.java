package Controlador.Turno;

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

        // Crear y agregar el ítem inicial para 'Seleccionar turno'
        Turno seleccionarTurno = new Turno(0, "Seleccionar turno");
        cboTurno.addItem(seleccionarTurno);

        // Cargar el resto de los turnos desde la base de datos
        List<Turno> listaTurnos = modelo.listarTurno();
        for (Turno turno : listaTurnos) {
            cboTurno.addItem(turno);
        }
    }
}
