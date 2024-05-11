package Controlador.Usuario;

import Modelo.CRUDusuario;

public class UsuarioControllerDelete {
    private final CRUDusuario usuarioModelo;
    
    public UsuarioControllerDelete(){
        this.usuarioModelo = new CRUDusuario();
    }
    
    public String eliminarUsuario(Long id) {
        return usuarioModelo.eliminarUsuario(id);
    }  
}
