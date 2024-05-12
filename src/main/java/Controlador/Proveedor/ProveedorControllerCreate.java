
package Controlador.Proveedor;

import Modelo.CRUDProveedor;
import vista.Proveedor.PanelProveedorCrear;

public class ProveedorControllerCreate {
    private CRUDProveedor proveedorModelo;
    private PanelProveedorCrear vistaProveedorCrear;
    
    public ProveedorControllerCreate() {
        this.proveedorModelo = new CRUDProveedor();
    }
    
    public void setVistaProveedorCrear(PanelProveedorCrear vistaProveedorCrear) {
        this.vistaProveedorCrear = vistaProveedorCrear;
    }

    public void crearProveedor(String nombre, String ruc, String descripcion, String telefono, String correo, String direccion, int idEstado) {
        proveedorModelo.crearProveedor(nombre, ruc, descripcion, telefono, correo, direccion, idEstado);   
    }
}
