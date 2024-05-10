package Controlador;

import Modelo.CRUDestado;
import Modelo.Estado;
import java.util.List;
import vista.PanelUsuarioCrear;

public class EstadoController {
    private PanelUsuarioCrear vista;
    private CRUDestado modelo;
    
    public EstadoController(PanelUsuarioCrear vista) {
        this.vista = vista;
        this.modelo = new CRUDestado();
    }
    
    public void cargarEstados() {
        vista.cboEstado.removeAllItems(); //Limpiar el cboEstado

        List<Estado> listaEstado = modelo.listarEstado();

        for (Estado estado : listaEstado) {
            vista.cboEstado.addItem(estado.getNombre());
        }
    }
}
