package Controlador.Proveedor;

import Modelo.CRUDProveedor;

public class ProveedorControllerDelete {
    private final CRUDProveedor usuarioModelo;
    
    public ProveedorControllerDelete(){
        this.usuarioModelo = new CRUDProveedor();
    }
    
    public String eliminarUsuario(Long id) {
        return usuarioModelo.eliminarProveedor(id);
    }  
}
