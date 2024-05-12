package Controlador.Usuario;

import Modelo.CRUDusuario;
import vista.Usuario.PanelUsuarioCrear;

public class UsuarioControllerCreate {
    private CRUDusuario usuarioModelo;
    
    public UsuarioControllerCreate() {
        this.usuarioModelo = new CRUDusuario();
    }
    
    public void crearUsuario(String correo, String password, String telefono, String nombre, String apellido, int rolId, int estadoId, int turnoId) {
        usuarioModelo.crearUsuario(correo, password, telefono, nombre, apellido, rolId, estadoId, turnoId);   
    }
}
