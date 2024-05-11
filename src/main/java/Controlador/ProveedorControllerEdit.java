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
import Modelo.Proveedor;
import vista.PanelProveedorEditar;

public class ProveedorControllerEdit {
    private ProveedorModelo proveedorModelo;
    private PanelProveedorEditar vistaProveedorEditar;
    private Long idProveedor;

    public ProveedorControllerEdit() {
        this.proveedorModelo = new ProveedorModelo();
    }

    public void setVistaProveedorEditar(PanelProveedorEditar vistaProveedorEditar) {
        this.vistaProveedorEditar = vistaProveedorEditar;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void cargarDatosProveedor() {
        Proveedor proveedor = proveedorModelo.obtenerProveedorPorId(idProveedor);
        if (proveedor != null) {
            vistaProveedorEditar.txtNombre.setText(proveedor.getNombre());
            vistaProveedorEditar.txtRUC.setText(proveedor.getRuc());
            vistaProveedorEditar.txtDescripcion.setText(proveedor.getDescripcion());
            vistaProveedorEditar.txtTelefono.setText(proveedor.getTelefono());
            vistaProveedorEditar.txtCorreo.setText(proveedor.getCorreo());
            vistaProveedorEditar.txtDireccion.setText(proveedor.getDireccion());

            // Establecer el estado seleccionado en el ComboBox
            for (int i = 0; i < vistaProveedorEditar.cboEstado.getItemCount(); i++) {
                Estado estado = (Estado) vistaProveedorEditar.cboEstado.getItemAt(i);
                if (estado.getId() == proveedor.getIdEstado()) {
                    vistaProveedorEditar.cboEstado.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    public void guardarCambios() {
        String nombre = vistaProveedorEditar.txtNombre.getText();
        String ruc = vistaProveedorEditar.txtRUC.getText();
        String descripcion = vistaProveedorEditar.txtDescripcion.getText();
        String telefono = vistaProveedorEditar.txtTelefono.getText();
        String correo = vistaProveedorEditar.txtCorreo.getText();
        String direccion = vistaProveedorEditar.txtDireccion.getText();

        int idEstado = ((Estado) vistaProveedorEditar.cboEstado.getSelectedItem()).getId();

        proveedorModelo.actualizarProveedor(idProveedor, nombre, ruc, descripcion, telefono, correo, direccion, idEstado);
        
        // Aquí deberías tener un método para cerrar la ventana de edición
    }
}

