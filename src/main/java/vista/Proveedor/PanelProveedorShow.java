
package vista.Proveedor;


import Controlador.Proveedor.ProveedorControllerShow;
import Modelo.Proveedor;
import Utilidades.IPanelListener;

public class PanelProveedorShow extends javax.swing.JPanel {
    public IPanelListener panelListener;
    private final ProveedorControllerShow controlador;
    
    public PanelProveedorShow(IPanelListener panelListener) {
        this.panelListener = panelListener;
        initComponents();
        controlador = new ProveedorControllerShow();
    }
    
    public void mostrarProveedorPorId(Long id){
    Proveedor proveedor = controlador.mostrarProveedorPorCodigo(id);
    
    if (proveedor != null) {
        lblTitulo.setText("Información del usuario con ID: " + String.valueOf(id));
        txtNombre.setText(proveedor.getNombre());
        txtRuc.setText(proveedor.getRuc());
        txtTelefono.setText(proveedor.getTelefono());
        txtCorreo.setText(proveedor.getCorreo());
        txtDireccion.setText(proveedor.getDireccion());
        txtDescripcion.setText(proveedor.getDescripcion());
        
        // Asumiendo que txtEstado es un JTextField
        txtEstado.setText(proveedor.getEstado());
    } else {
        System.out.println("Proveedor no encontrado con el ID: " + id);
    }
    }   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRuc = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        lblRuc = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();

        txtRuc.setPreferredSize(new java.awt.Dimension(150, 22));
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });

        lblRuc.setText("Ruc:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        lblDireccion.setText("Direccion: ");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Informacion de ");

        lblNombre.setText("Nombre:");

        lblCorreo.setText("Correo:");

        lblTelefono.setText("Telefono:");

        lblEstado.setText("Estado:");

        lblDescripcion.setText("Descripcion:");

        txtEstado.setEnabled(false);
        txtEstado.setPreferredSize(new java.awt.Dimension(150, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
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
                                    .addComponent(lblEstado)
                                    .addComponent(lblDireccion)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblTitulo)
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
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel5)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtEstado;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtRuc;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
