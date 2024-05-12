package Controlador.Proveedor;


import static Constantes.ConstantesNombreBotonesTablas.*;
import Modelo.Proveedor;
import Modelo.CRUDProveedor;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProveedorControllerList{
    private final CRUDProveedor proveedorModelo;
    
    public ProveedorControllerList() {
        this.proveedorModelo = new CRUDProveedor();
    }
    
    //Funcion para buscar de acuerdo al nombre del proveedor
     public DefaultTableModel obtenerModeloTabla(String textoBusqueda) {
        List<Proveedor> listaProveedores = proveedorModelo.buscarProveedorPorNombre(textoBusqueda);
        String[] columnNames = {"ID", "Nombre", "RUC", "Telefono", "Correo", "Estado", VER_DETALLES, EDITAR, ELIMINAR};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Proveedor proveedor : listaProveedores) {
            Object[] row = new Object[]{
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getRuc(),
                
                proveedor.getTelefono(),
                proveedor.getCorreo(),
                
                proveedor.getEstado(),
                VER_DETALLES,
                EDITAR,
                ELIMINAR
            };
            model.addRow(row);
        }
        return model;
    }
}
