package Controlador.Usuario;

import Modelo.CRUDusuario;
import Modelo.Usuario;

public class UsuarioControllerEdit {
    private final CRUDusuario usuarioModelo;
    
    public UsuarioControllerEdit(){
        this.usuarioModelo = new CRUDusuario();
    }
    
    public Usuario buscarUsuarioPorCodigo(Long id){
        return usuarioModelo.buscarUsuarioPorCodigo(id);
    }
    
    public void editarUsuario(Long id, String correo, String password, String telefono, String nombre, String apellido, int rol_id, int estado_id, int turno_id){ 
        usuarioModelo.editarUsuario(id, correo, password, telefono, nombre, apellido, rol_id, estado_id, turno_id);
    }
    
}
