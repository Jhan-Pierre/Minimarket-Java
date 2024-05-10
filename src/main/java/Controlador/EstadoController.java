package Controlador;

import Modelo.CRUDestado;
import Modelo.Estado;
import java.util.List;
import javax.swing.JComboBox;
import vista.PanelUsuarioCrear;

public class EstadoController {
    private PanelUsuarioCrear vista;
    private CRUDestado modelo;
    
    public EstadoController(PanelUsuarioCrear vista) {
        this.vista = vista;
        this.modelo = new CRUDestado();
    }
    
    public void cargarEstados() {
        JComboBox<Estado> cboEstado = vista.cboEstado; // ComboBox que contiene objetos de tipo Estado
        cboEstado.removeAllItems(); // Limpiar el cboEstado

        List<Estado> listaEstado = modelo.listarEstado();

        for (Estado estado : listaEstado) {
            cboEstado.addItem(estado);
        }
    }
}
