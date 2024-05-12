package Controlador.Proveedor;

import Modelo.CRUDProveedor;

public class ProveedorControllerDelete {
    private final CRUDProveedor proveedorModelo;
    
    public ProveedorControllerDelete(){
        this.proveedorModelo = new CRUDProveedor();
    }
    
    public String eliminarProveedor(Long id) {
        return proveedorModelo.eliminarProveedor(id);
    }  
}
