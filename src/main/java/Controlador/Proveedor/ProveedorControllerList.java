/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Proveedor;

/**
 *
 * @author jean carlos
 */

import Modelo.Proveedor;
import Utilidades.ButtonColumn;
import Utilidades.IButtonClickListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vista.Proveedor.PanelProveedor;

public class ProveedorControllerList implements IButtonClickListener {
//    private final ProveedorModelo proveedorModelo;
//    private final PanelProveedor vistaProveedor;
//
//    public ProveedorControllerList(PanelProveedor vistaProveedor) {
//        this.vistaProveedor = vistaProveedor;
//        this.proveedorModelo = new ProveedorModelo();
//    }
//
//    public void actualizarVista() {
//        cargarProveedoresEnTabla();
//    }
//    
//    public void cargarProveedoresEnTabla() {
//        List<Proveedor> listaProveedores = proveedorModelo.listarProveedores();
//
//        // Crear modelo de tabla y establecerlo en la tabla
//        DefaultTableModel model = new DefaultTableModel();
//        vistaProveedor.tbProveedor.setModel(model);
//
//        // Añadir columnas al modelo de la tabla
//        model.addColumn("ID");
//        model.addColumn("Nombre");
//        model.addColumn("RUC");
//        model.addColumn("Descripción");
//        model.addColumn("Teléfono");
//        model.addColumn("Correo");
//        model.addColumn("Dirección");
//        model.addColumn("Estado");
//
//        // Añadir columnas de botones
//        model.addColumn("Ver detalles");
//        model.addColumn("Editar");
//        model.addColumn("Eliminar");
//
//        // Añadir filas al modelo de la tabla
//        for (Proveedor proveedor : listaProveedores) {
//            model.addRow(new Object[]{
//                proveedor.getId(),
//                proveedor.getNombre(),
//                proveedor.getRuc(),
//                proveedor.getDescripcion(),
//                proveedor.getTelefono(),
//                proveedor.getCorreo(),
//                proveedor.getDireccion(),
//                proveedor.getIdEstado(),
//                "Ver detalles", "Editar", "Eliminar"
//            });
//        }
//
//        // Crear los botones en las columnas correspondientes
//        new ButtonColumn(vistaProveedor.tbProveedor, 7, this); // Ver detalles
//        new ButtonColumn(vistaProveedor.tbProveedor, 8, this); // Editar
//        new ButtonColumn(vistaProveedor.tbProveedor, 9, this); // Eliminar
//    }
//    
    @Override
    public void buttonClicked(int row, int column, String buttonText) {
//        Long id = (Long) vistaProveedor.tbProveedor.getModel().getValueAt(row, 0);
//        switch (buttonText) {
//            case "Ver detalles" -> abrirDetallesProveedor(id);
//            case "Editar" -> abrirEditarProveedor(id);
//            case "Eliminar" -> eliminarProveedor(id);
//        }
    }
//    
//    public void buscarProveedores(String texto) {
//        List<Proveedor> listaProveedores = proveedorModelo.buscarProveedorPorNombre(texto);
//        actualizarTablaConProveedores(listaProveedores);
//    }
//
//    private void actualizarTablaConProveedores(List<Proveedor> listaProveedores) {
//        DefaultTableModel model = (DefaultTableModel) vistaProveedor.tbProveedor.getModel();
//        model.setRowCount(0); // Limpiar la tabla antes de añadir los nuevos resultados
//
//        for (Proveedor proveedor : listaProveedores) {
//            model.addRow(new Object[]{
//                proveedor.getId(),
//                proveedor.getNombre(),
//                proveedor.getRuc(),
//                proveedor.getDescripcion(),
//                proveedor.getTelefono(),
//                proveedor.getCorreo(),
//                proveedor.getDireccion(),
//                proveedor.getIdEstado(),
//                "Ver detalles", "Editar", "Eliminar"
//            });
//        }
//    }
//    
//    private void abrirDetallesProveedor(Long id) {
//        System.out.println("Detalle del proveedor con ID: " + id);
//        // Aquí puedes implementar la lógica para mostrar los detalles del proveedor
//    }
//
//    private void abrirEditarProveedor(Long id) {
//        System.out.println("Editar proveedor con ID: " + id);
//        // Aquí puedes implementar la lógica para abrir el formulario de edición del proveedor
//    }
//
//    private void eliminarProveedor(Long id) {
//        System.out.println("Eliminar proveedor con ID: " + id);
//        // Aquí puedes implementar la lógica para eliminar el proveedor de la base de datos
//    }
}