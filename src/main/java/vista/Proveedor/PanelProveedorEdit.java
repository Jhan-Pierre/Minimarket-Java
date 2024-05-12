/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.Proveedor;

import static Constantes.ConstantesPaneles.PANEL_PROVEEDOR;
import Controlador.Estado.EstadoController;
import Controlador.Proveedor.ProveedorControllerEdit;
import Modelo.Estado;
import Modelo.Proveedor;
import Utilidades.IPanelListener;
import Utilidades.Identificable;
import javax.swing.JComboBox;

/**
 *
 * @author jean carlos
 */
public class PanelProveedorEdit extends javax.swing.JPanel {
    private ProveedorControllerEdit controlador;
    public IPanelListener panelListener;
    
    public PanelProveedorEdit(IPanelListener panelListener) {
        this.panelListener = panelListener;
        this.inicializar();
    }

    private void CargarComboBox(){
       /* EstadoController estadoController = new EstadoController();
        estadoController.cargarEstadosEnComboBox(cboEstado);*/
    }
    
    public void BuscarProveedorPorId(Long id){
        Proveedor proveedor = controlador.buscarProveedorPorCodigo(id);
        
        if (proveedor != null) {
            txtId.setText(String.valueOf(id));
            txtNombre.setText(proveedor.getNombre());
            txtRuc.setText(proveedor.getRuc());
            txtTelefono.setText(proveedor.getTelefono());
            txtCorreo.setText(proveedor.getCorreo());
            txtDireccion.setText(proveedor.getDireccion());
            txtDescripcion.setText(proveedor.getDescripcion());
            
            // Obtener el ID del estado
            //int estadoId = proveedor.getEstado_id();

            //Seleccionar el elemento correspondiente en el ComboBox
            //cboEstado.setSelectedItem(obtenerEstadoPorId(estadoId));
        } else {
            System.out.println("Proveedor no encontrado con el ID: " + id);
        }
    }
    
    /*private Estado obtenerEstadoPorId(int estadoId) {
        return obtenerPorId(cboEstado, estadoId);
    }*/

    // Obtener el Id de caulquier objeto
    /*private <T extends Identificable> T obtenerPorId(JComboBox<T> comboBox, int id) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            T item = comboBox.getItemAt(i);
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Si no se encuentra el item con el ID especificado
    }*/
    
    private void inicializar(){
        initComponents();
        controlador = new ProveedorControllerEdit();
        this.CargarComboBox();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCorreo = new javax.swing.JTextField();
        lblRuc = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        btnEditarProveedor = new javax.swing.JButton();
        txtDireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        cboEstado = new javax.swing.JComboBox<>();
        txtDescripcion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        lblRuc.setText("Ruc:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        lblDireccion.setText("Direccion: ");

        btnEditarProveedor.setText("Editar");
        btnEditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Editar Proveedor");

        lblNombre.setText("Nombre:");

        lblCorreo.setText("Correo:");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblTelefono.setText("Telefono:");

        lblEstado.setText("Estado:");

        lblDescripcion.setText("Descripcion:");

        txtRuc.setPreferredSize(new java.awt.Dimension(150, 22));
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });

        lblNombre2.setText("ID");

        txtId.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(75, 75, 75)
                        .addComponent(lblNombre2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCorreo)
                            .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEstado)
                                    .addComponent(lblDireccion)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(btnEditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNombre2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblNombre)
                                            .addComponent(lblRuc))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCorreo)
                                    .addComponent(lblDireccion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblTelefono))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstado)
                            .addComponent(lblDescripcion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnEditarProveedor)
                .addGap(70, 70, 70))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucActionPerformed

    private void btnEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedorActionPerformed
        long id = Long.parseLong(txtId.getText());
        String nombre = txtNombre.getText();
        String ruc = txtRuc.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();
        String direccion = txtDireccion.getText();
        String descripcion = txtDescripcion.getText();

        Estado estadoSeleccionado = (Estado) cboEstado.getSelectedItem();
        int estadoId = estadoSeleccionado.getId();

        controlador.editarProveedor(id, nombre, ruc, telefono, correo, direccion, descripcion, estadoId);
        panelListener.abrirPanel(PANEL_PROVEEDOR);


    }//GEN-LAST:event_btnEditarProveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarProveedor;
    public javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JLabel lblTelefono;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtRuc;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
