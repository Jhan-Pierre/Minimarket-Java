package Controlador;

import static Constantes.ConstantesPaneles.PANEL_USUARIO;
import Modelo.Estado;
import Modelo.Rol;
import Modelo.Turno;
import Modelo.UsuarioModelo;
import vista.PanelUsuarioCrear;

public class UsuarioControllerCreate {
    private UsuarioModelo usuarioModelo;
    private PanelUsuarioCrear vistaUsuarioCrear;
    
    public UsuarioControllerCreate() {
        this.usuarioModelo = new UsuarioModelo();
    }
    
    public void setVistaUsuarioCrear(PanelUsuarioCrear vistaUsuarioCrear) {
        this.vistaUsuarioCrear = vistaUsuarioCrear;
    }

    public void crearUsuario() {
        String correo = vistaUsuarioCrear.txtCorreo.getText();
        String password = vistaUsuarioCrear.txtContraseña.getText();
        String telefono = vistaUsuarioCrear.txtTelefono.getText();
        String nombre = vistaUsuarioCrear.txtNombre.getText();
        String apellido = vistaUsuarioCrear.txtApellido.getText();

        Rol rolSelecionado = (Rol) vistaUsuarioCrear.cboRol.getSelectedItem();
        int rolId = rolSelecionado.getId(); // Obtener el ID del rol seleccionado

        Estado estadoSeleccionado  = (Estado) vistaUsuarioCrear.cboEstado.getSelectedItem(); // Obtener el ID del estado seleccionado
        int estadoId = estadoSeleccionado.getId();

        Turno turnoSeleccionado = (Turno) vistaUsuarioCrear.cboTurno.getSelectedItem();
        int turnoId = turnoSeleccionado.getId(); // Obtener el ID del turno seleccionado

        // Llamar al método del modelo para crear el usuario
        usuarioModelo.crearUsuario(correo, password, telefono, nombre, apellido, rolId, estadoId, turnoId);
        
        vistaUsuarioCrear.panelListener.abrirPanel(PANEL_USUARIO);
        
        
    }
}
