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
        String[] columnNames = {"ID", "Nombre", "RUC","Correo" ,"Telefono" , "Estado", VER_DETALLES, EDITAR, ELIMINAR};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Proveedor proveedor : listaProveedores) {
            Object[] row = new Object[]{
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getRuc(),
                proveedor.getCorreo(),
                proveedor.getTelefono(),
                
                
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
