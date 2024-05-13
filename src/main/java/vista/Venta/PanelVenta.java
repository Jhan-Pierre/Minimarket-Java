package vista.Venta;

import static Constantes.ConstantesPaneles.PANEL_VENTA_CREAR;
import Controlador.Venta.VentaControllerList;
import Utilidades.IButtonClickListener;
import Utilidades.IPanelListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

public class PanelVenta extends javax.swing.JPanel implements IButtonClickListener{
    public IPanelListener panelListener;
    private VentaControllerList controladorList;
    
    public PanelVenta(IPanelListener panelListener) {
        this.panelListener = panelListener;
        initComponents();
        this.iniciarlizar();
        //Hacer una busque cada vez que se escribe en txt buscar
        txtBuscarVenta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarUsuarios(txtBuscarVenta.getText());
            }
        });
    }

    public void iniciarlizar(){
        controladorList = new VentaControllerList();
        
        buscarUsuarios("");
    }
    
    @Override
    public void buttonClicked(int row, int column, String buttonText) {
        Long id = (Long) tbVenta.getModel().getValueAt(row, 0);
        switch (buttonText) {
            case "Ver detalles" -> abrirDetallesUsuario(id);
            case "Editar" -> abrirEditarUsuario(id);
            case "Eliminar" -> eliminarUsuario(id);
        }
    }
    
    public void buscarUsuarios(String texto) {
        DefaultTableModel model = controladorList.obtenerModeloTabla(texto);
        tbVenta.setModel(model);


    }
    
    private void abrirDetallesUsuario(Long id) {
        System.out.println("abrir:" + id);    
    }

    private void abrirEditarUsuario(Long id) {
        System.out.println("editar:" + id);    
    }

    private void eliminarUsuario(Long id) {
        System.out.println("eliminar:" + id);    
    }
    
    public void resetPanel() {
        txtBuscarVenta.setText("");
        buscarUsuarios("");
    }
    
    //Cuando el panel usuario sea visible se resetea el contenido
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            resetPanel();
        }
    }
    
    private void abrirPanelUsuarioCrear() {
        this.panelListener.abrirPanel(PANEL_VENTA_CREAR);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscarVenta = new javax.swing.JTextField();
        btnAgregarVenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVenta = new javax.swing.JTable();

        btnAgregarVenta.setText("Agregar");
        btnAgregarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVentaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Lista de Ventas");

        tbVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbVenta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVentaActionPerformed
        abrirPanelUsuarioCrear();
    }//GEN-LAST:event_btnAgregarVentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbVenta;
    private javax.swing.JTextField txtBuscarVenta;
    // End of variables declaration//GEN-END:variables

}
