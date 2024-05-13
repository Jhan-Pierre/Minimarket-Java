package vista.Pedido;

import static Constantes.ConstantesNombreBotonesTablas.EDITAR;
import static Constantes.ConstantesNombreBotonesTablas.ELIMINAR;
import static Constantes.ConstantesNombreBotonesTablas.VER_DETALLES;
import static Constantes.ConstantesPaneles.PANEL_MANTENIMIENTO;
import Controlador.Pedido.PedidoControllerList;
import Utilidades.ButtonColumn;
import Utilidades.IButtonClickListener;
import Utilidades.IPanelListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

public class PanelPedido extends javax.swing.JPanel implements IButtonClickListener{
    
    public IPanelListener panelListener;
    private PedidoControllerList controladorList;
    
    public PanelPedido(IPanelListener panelListener) {
        this.panelListener = panelListener;
        initComponents();
        this.iniciarlizar();
        //Hacer una busque cada vez que se escribe en txt buscar
        txtBuscarPedido.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarUsuarios(txtBuscarPedido.getText());
            }
        });
    }
    public void iniciarlizar(){
        controladorList = new PedidoControllerList();
        
        buscarUsuarios("");
    }
    
    public void buscarUsuarios(String texto) {
        DefaultTableModel model = controladorList.obtenerModeloTabla(texto);
        tbPedido.setModel(model);
        new ButtonColumn(tbPedido, 5, this);
        new ButtonColumn(tbPedido, 6, this);
        new ButtonColumn(tbPedido, 7, this);
    }
    
    @Override
    public void buttonClicked(int row, int column, String buttonText) {
        //Long id = (Long) tbProducto.getModel().getValueAt(row, 0);
        switch (buttonText) {
            case VER_DETALLES -> abrirDetallesUsuario();
            case EDITAR -> abrirEditarUsuario();
            case ELIMINAR -> eliminarUsuario();
        }
    }
    
    private void abrirDetallesUsuario() {
        this.panelListener.abrirPanel(PANEL_MANTENIMIENTO);
    }

    private void eliminarUsuario() {
        this.panelListener.abrirPanel(PANEL_MANTENIMIENTO);
    }

    private void abrirEditarUsuario() {
        this.panelListener.abrirPanel(PANEL_MANTENIMIENTO);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPedido = new javax.swing.JTable();
        btnAgregarPedido = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarPedido = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("LISTA DE PEDIDOS:");

        tbPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbPedido);

        btnAgregarPedido.setText("Agregar");
        btnAgregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPedidoActionPerformed(evt);
            }
        });

        txtBuscarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarPedido)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPedidoActionPerformed

    private void btnAgregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPedidoActionPerformed
        this.panelListener.abrirPanel(PANEL_MANTENIMIENTO);
    }//GEN-LAST:event_btnAgregarPedidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPedido;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPedido;
    private javax.swing.JTextField txtBuscarPedido;
    // End of variables declaration//GEN-END:variables

}