package Controlador.Usuario;

import Modelo.CRUDusuario;
import Modelo.Usuario;

public class UsuarioControllerShow {
    private final CRUDusuario usuarioModelo;
    
    public UsuarioControllerShow() {
        this.usuarioModelo = new CRUDusuario();
    }
    
    public Usuario mostrarUsuarioPorCodigo(Long id){
        return usuarioModelo.mostrarUsuarioPorCodigo(id);
    }   
}
