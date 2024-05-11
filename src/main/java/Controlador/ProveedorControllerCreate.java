/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author jean carlos
 */

import Modelo.Estado;
import vista.PanelProveedorCrear;
import Modelo.Proveedor;

public class ProveedorControllerCreate {
    private ProveedorModelo proveedorModelo;
    private PanelProveedorCrear vistaProveedorCrear;
    
    public ProveedorControllerCreate() {
        this.proveedorModelo = new ProveedorModelo();
    }
    
    public void setVistaProveedorCrear(PanelProveedorCrear vistaProveedorCrear) {
        this.vistaProveedorCrear = vistaProveedorCrear;
    }

    public void crearProveedor() {
        String nombre = vistaProveedorCrear.txtNombre.getText();
        String ruc = vistaProveedorCrear.txtRuc.getText();
        String descripcion = vistaProveedorCrear.txtDescripcion.getText();
        String telefono = vistaProveedorCrear.txtTelefono.getText();
        String correo = vistaProveedorCrear.txtCorreo.getText();
        String direccion = vistaProveedorCrear.txtDireccion.getText();

        int idEstado = ((Estado) vistaProveedorCrear.cboEstado.getSelectedItem()).getId();

        // Llamar al método del modelo para crear el proveedor
        proveedorModelo.crearProveedor(nombre, ruc, descripcion, telefono, correo, direccion, idEstado);
        
        // Aquí deberías tener un método panelListener.abrirPanel(PANEL_PROVEEDOR); o similar para cambiar de panel
    }
}
