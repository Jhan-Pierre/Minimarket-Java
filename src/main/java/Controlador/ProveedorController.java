package Controlador;

import Modelo.CRUDProveedor;
import Modelo.Proveedor;
import Utilidades.ButtonColumn;
import Utilidades.IButtonClickListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vista.PanelProveedor;
import vista.PanelProveedorCrear;

public class ProveedorController implements IButtonClickListener {
    private PanelProveedor vistaProveedor;
    private PanelProveedorCrear vistaProveedorCrear;
    private CRUDProveedor modelo;

    public ProveedorController(PanelProveedor vista) {
        this.vistaProveedor = vista;
        this.modelo = new CRUDProveedor();
    }

    public ProveedorController(PanelProveedorCrear vista) {
        this.vistaProveedorCrear = vista;
        this.modelo = new CRUDProveedor();
    }

    public void cargarProveedoresEnTabla() {
        List<Proveedor> listaProveedores = modelo.listarProveedores();

        // Crear modelo de tabla y establecerlo en la tabla
        DefaultTableModel model = new DefaultTableModel();
        vistaProveedor.tbProveedor.setModel(model);

        // Añadir columnas al modelo de la tabla
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("RUC");
        model.addColumn("Descripción");
        model.addColumn("Teléfono");
        model.addColumn("Correo");
        model.addColumn("Dirección");
        model.addColumn("Estado");

        // Añadir columnas de botones
        model.addColumn("Ver detalles");
        model.addColumn("Editar");
        model.addColumn("Eliminar");

        // Añadir filas al modelo de la tabla
        for (Proveedor proveedor : listaProveedores) {
            model.addRow(new Object[]{
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getRuc(),
                proveedor.getDescripcion(),
                proveedor.getTelefono(),
                proveedor.getCorreo(),
                proveedor.getDireccion(),
                proveedor.getIdEstado(),
                "Ver detalles", "Editar", "Eliminar"
            });
        }

        // Crear los botones en las columnas correspondientes
        new ButtonColumn(vistaProveedor.tbProveedor, 7, this); // Ver detalles
        new ButtonColumn(vistaProveedor.tbProveedor, 8, this); // Editar
        new ButtonColumn(vistaProveedor.tbProveedor, 9, this); // Eliminar
    }

    @Override
    public void buttonClicked(int row, int column, String buttonText) {
        Long id = (Long) vistaProveedor.tbProveedor.getModel().getValueAt(row, 0);
        switch (buttonText) {
            case "Ver detalles" -> abrirDetallesProveedor(id);
            case "Editar" -> abrirEditarProveedor(id);
            case "Eliminar" -> eliminarProveedor(id);
        }
    }

    private void abrirDetallesProveedor(Long id) {
        System.out.println("Detalle proveedor: " + id);
    }

    private void abrirEditarProveedor(Long id) {
        System.out.println("Editar proveedor: " + id);
    }

    private void eliminarProveedor(Long id) {
        System.out.println("Eliminar proveedor: " + id);
    }

    public void crearProveedor() {
        String nombre = vistaProveedorCrear.txtNombre.getText();
        //String ruc = vistaProveedorCrear.txtRuc.getText();
        //String descripcion = vistaProveedorCrear.txtDescripcion.getText();
        String telefono = vistaProveedorCrear.txtTelefono.getText();
        String correo = vistaProveedorCrear.txtDescripcion.getText();
        //String direccion = vistaProveedorCrear.txtDireccion.getText();
        int idEstado = vistaProveedorCrear.cboEstado.getSelectedIndex(); // Obtener el ID del estado seleccionado

        // Llamar al método del modelo para crear el proveedor
        //System.out.println(nombre + ruc + descripcion + telefono + correo + direccion + idEstado);
        //modelo.crearProveedor(nombre, ruc, descripcion, telefono, correo, direccion, idEstado);
    }
}
