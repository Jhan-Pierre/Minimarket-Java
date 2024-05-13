package Controlador.Proveedor;

import Modelo.CRUDProveedor;
import Modelo.Proveedor;

public class ProveedorControllerEdit {
    private final CRUDProveedor proveedorModelo;
    
    public ProveedorControllerEdit(){
        this.proveedorModelo = new CRUDProveedor();
    }
    
    public Proveedor buscarProveedorPorCodigo(Long id){
        return proveedorModelo.buscarProveedorPorCodigo((id.intValue()));
    }
    
    public void editarProveedor(Long id, String nombre, String ruc, String descripcion, String telefono, String correo, String direccion, int idEstado) { 
        proveedorModelo.editarProveedor(id, nombre, ruc, descripcion, telefono, correo, direccion, idEstado);
    }
    
}
    