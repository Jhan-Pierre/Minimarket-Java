
package vista.Producto;

import Modelo.CategoriaProducto;
import Modelo.Estado;
import static Constantes.ConstantesPaneles.PANEL_PRODUCTO;
import Controlador.Categoria.CategoriaController;
import Controlador.Estado.EstadoController;
import Controlador.Producto.ProductoControllerEdit;
import Controlador.Rol.RolController;
import Controlador.Turno.TurnoController;
import Controlador.Usuario.UsuarioControllerEdit;
import Modelo.Producto;
import Modelo.Rol;
import Modelo.Turno;
import Modelo.Usuario;
import Utilidades.IPanelListener;
import Utilidades.Identificable;
import javax.swing.JComboBox;

/**
 *
 * @author User
 */
public class PanelProductoEdit extends javax.swing.JPanel {
    /*
    private ProductoControllerEdit controlador;
    public IPanelListener panelListener;
    
    public PanelProductoEdit(IPanelListener panelListener) {
        this.panelListener = panelListener;
        this.inicializar();
    }

    private void CargarComboBox(){
        EstadoController estadoController = new EstadoController();
        estadoController.cargarEstadosEnComboBox(cboEstado);
        
        CategoriaController categoriaController = new CategoriaController();
        categoriaController.cargarCategoriaEnComboBox(cboCategoriaProducto); 
    }
    
    public void BuscarProductoPorId(int codigobar){
        Producto producto = (Producto) controlador.buscarProductoPorCodigo(codigobar);
        
        if (producto != null) {
            txtId.setText(String.valueOf(id));
            txtNombre.setText(producto.getNombre());
            txtPrecioCompra.setText(producto.getPrecioCompra());
            txtPrecioVenta.setText(producto.getPrecioVenta());
            txtStock.setText(usuario.getCorreo());
            
            // Obtener los IDs de rol, estado y turno
            int rolId = usuario.getRolId();
            int estadoId = usuario.getEstado_id();
            int turnoId = usuario.getTurno_id();

            // Seleccionar los elementos correspondientes en los ComboBox
            cboRol.setSelectedItem(obtenerRolPorId(rolId));
            cboEstado.setSelectedItem(obtenerEstadoPorId(estadoId));
            cboTurno.setSelectedItem(obtenerTurnoPorId(turnoId));
        } else {
            System.out.println("Usuario no encontrado con el ID: " + id);
        }
    }
    
    private Rol obtenerRolPorId(int rolId) {
        return obtenerPorId(cboRol, rolId);
    }

    private Estado obtenerEstadoPorId(int estadoId) {
        return obtenerPorId(cboEstado, estadoId);
    }

    private Turno obtenerTurnoPorId(int turnoId) {
        return obtenerPorId(cboTurno, turnoId);
    }

    // Obtener el Id de caulquier objeto
    private <T extends Identificable> T obtenerPorId(JComboBox<T> comboBox, int id) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            T item = comboBox.getItemAt(i);
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Si no se encuentra el item con el ID especificado
    }
    private void inicializar() {
       initComponents();
        controlador = new UsuarioControllerEdit();
        this.CargarComboBox(); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre2 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        btnEditarProducto = new javax.swing.JButton();
        txtCodigoBarras = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblPrecioCompra = new javax.swing.JLabel();
        cboCategoriaProducto = new javax.swing.JComboBox<>();
        txtPrecioVenta = new javax.swing.JTextField();
        txtPrecioCompra = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();

        lblNombre2.setText("ID");

        lblEstado.setText("Estado");

        txtId.setEnabled(false);

        lblNombre.setText("Nombre");

        btnEditarProducto.setText("Editar");
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });

        jLabel3.setText("Codigo de Barras");

        lblPrecioCompra.setText("Precio Compra");

        txtPrecioCompra.setPreferredSize(new java.awt.Dimension(150, 22));

        lblTelefono.setText("Precio Venta");

        lblCategoria.setText("Categoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(382, 382, 382))
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstado)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategoria)
                            .addComponent(cboCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecioCompra)
                            .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefono))))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(lblPrecioCompra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTelefono)
                        .addGap(28, 28, 28))
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 225, Short.MAX_VALUE)
                        .addComponent(btnEditarProducto)
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
    
    }//GEN-LAST:event_btnEditarProductoActionPerformed
     // Cuando el panel sea visible se resetea el contenido
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            resetPanel();
        }
    }
    
    public void resetPanel() {
        limpiarMensajesError(this);
        // Resetea los campos de texto
        txtnombre.setText("");
        txtContraseña.setText("");
        txtConfirmarContraseña.setText("");
        txtTelefono.setText("");
        txtNombre.setText("");
        
        
        // Resetea los combobox seleccionando el primer ítem
        if (cboCategoriaProducto.getItemCount() > 0) {
            cboCategoriaProducto.setSelectedIndex(0);
        }
        if (cboEstado.getItemCount() > 0) {
            cboEstado.setSelectedIndex(0);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEditarProducto;
    public javax.swing.JComboBox<CategoriaProducto> cboCategoriaProducto;
    public javax.swing.JComboBox<Estado> cboEstado;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblPrecioCompra;
    private javax.swing.JLabel lblTelefono;
    public javax.swing.JTextField txtCodigoBarras;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPrecioCompra;
    public javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
*/
    
}
