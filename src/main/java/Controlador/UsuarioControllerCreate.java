package Controlador;

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

    public void crearUsuario(String correo, String password, String telefono, String nombre, String apellido, int rolId, int estadoId, int turnoId) {
        usuarioModelo.crearUsuario(correo, password, telefono, nombre, apellido, rolId, estadoId, turnoId);   
    }
}
