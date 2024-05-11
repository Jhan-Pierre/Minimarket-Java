package Controlador;

import Modelo.Estado;
import Modelo.Rol;
import Modelo.Turno;
import Modelo.UsuarioModelo;
import vista.PanelUsuarioEdit;

public class UsuarioControllerEdit {
    private UsuarioModelo usuarioModelo;
    private PanelUsuarioEdit vistaUsuarioEdit;

    public UsuarioControllerEdit() {
        this.usuarioModelo = new UsuarioModelo();
    }

    public void setVistaUsuarioEdit(PanelUsuarioEdit vistaUsuarioEdit) {
        this.vistaUsuarioEdit = vistaUsuarioEdit;
    }
    
    public void editarUsuario(long idUsuario) {
        String correo = vistaUsuarioEdit.txtCorreo.getText();
        String password = vistaUsuarioEdit.txtContraseña.getText();
        String telefono = vistaUsuarioEdit.txtTelefono.getText();
        String nombre = vistaUsuarioEdit.txtNombre.getText();
        String apellido = vistaUsuarioEdit.txtApellido.getText();

        Rol rolSeleccionado = (Rol) vistaUsuarioEdit.cboRol.getSelectedItem();
        int rolId = rolSeleccionado.getId(); // Obtener el ID del rol seleccionado

        Estado estadoSeleccionado = (Estado) vistaUsuarioEdit.cboEstado.getSelectedItem();
        int estadoId = estadoSeleccionado.getId(); // Obtener el ID del estado seleccionado

        Turno turnoSeleccionado = (Turno) vistaUsuarioEdit.cboTurno.getSelectedItem();
        int turnoId = turnoSeleccionado.getId(); // Obtener el ID del turno seleccionado

        // Llamar al método del modelo para editar el usuario
        usuarioModelo.editarUsuario(idUsuario, correo, password, telefono, nombre, apellido, rolId, estadoId, turnoId);
        
        // Aquí puedes agregar cualquier lógica adicional después de editar el usuario, como mostrar un mensaje de éxito, etc.
    }
}
