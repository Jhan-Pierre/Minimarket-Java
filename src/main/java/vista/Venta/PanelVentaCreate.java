package vista.Venta;

import Constantes.ConstantesPaneles;
import static Constantes.ConstantesPaneles.PANEL_VENTA;
import Controlador.CestaTemporal.CestaTemporalControllerList;
import Controlador.MetodoPago.MetodoPagoControllerList;
import Controlador.TipoComprobante.TipoComprobanteControllerList;
import Controlador.Venta.VentaControllerCreate;
import Modelo.MetodoPago;
import Modelo.TipoComprobante;
import Utilidades.ButtonColumn;
import Utilidades.IPanelListener;
import javax.swing.table.DefaultTableModel;

import Modelo.SesionUsuario;
import Utilidades.IButtonClickListener;
import Validaciones.ValidateVentaCreate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableModel;

public class PanelVentaCreate extends javax.swing.JPanel implements IButtonClickListener {
    public IPanelListener panelListener;  
    VentaControllerCreate controlador;
    CestaTemporalControllerList controladorList;
    private final Long idUsuario = SesionUsuario.getInstancia().getUsuarioLogeado().getId(); // Obtener el ID del usuario logueado
    
    private final Double igv = 0.0;
    
    public PanelVentaCreate(IPanelListener panelListener) {
        this.panelListener = panelListener;
        initComponents();
        this.controlador = new VentaControllerCreate();
        this.controladorList = new CestaTemporalControllerList();
        MetodoPagoControllerList metodoPago = new MetodoPagoControllerList();
        metodoPago.cargarMetodoPagoEnComboBox(cboMetodoPago);
        
        TipoComprobanteControllerList tipoComprobante = new TipoComprobanteControllerList();
        tipoComprobante.cargarTipoCOmprobanteEnComboBox(cboTipoComprobante);
        
        txtIGV.setText(String.valueOf(igv));
        resetPanel();
    }

    public void buscarUsuarios() {
        //System.out.println(idUsuario);
        // Consultar la cesta temporal por el ID de usuario (con el valor predeterminado si es necesario)
        DefaultTableModel model = controladorList.consultarCestaTemporalPorIdUsuario(this.idUsuario);

        // Establecer el modelo en la tabla
        tbVenta.setModel(model);

        // Agregar una nueva columna de botón a la tabla
        new ButtonColumn(tbVenta, 4, this);  
    }
    
    @Override
    public void buttonClicked(int row, int column, String buttonText) {
        String producto =  (String) tbVenta.getModel().getValueAt(row, 0); //Cuando se pulse el boton, recupera la inforamcion de la columna 0, de la fila donde si de click
        switch (buttonText) {
            case "Eliminar" -> eliminarProductoCestaTemporal(producto);
        }
    }
    
    private void eliminarProductoCestaTemporal(String producto) {
        eliminarItemCestaTemporal(producto);
    }
    
    private void registrarCestaTemporal(){
        controladorList.registrarCestaTemporal(idUsuario, txtCodigoBarras.getText());
        resetPanel();
    }
    
    private void resetPanel(){
        buscarUsuarios(); //busca los usuarios
        calcularTotal(); //calcula el total de los registros en la tbVenta
        
        ValidateVentaCreate.limpiarMensajesError(this);
        txtCodigoBarras.setText("");  
        if (cboMetodoPago.getItemCount() > 0) {
            cboMetodoPago.setSelectedIndex(0);
        }
        if (cboTipoComprobante.getItemCount() > 0) {
            cboTipoComprobante.setSelectedIndex(0);
        }
    }
    
    private void calcularTotal() {
        double total = 0.0;
        TableModel model = tbVenta.getModel();
        int rowCount = model.getRowCount();
        if (rowCount > 0) {
            for (int i = 0; i < rowCount; i++) {
                double subtotal = Double.parseDouble(model.getValueAt(i, 3).toString()); // Obtener el subtotal de la fila
                total += subtotal;
            }
        }
        txtTotal.setText(String.valueOf(total));
    }
    private void registrarVenta(){
        
        Double igvget = Double.valueOf(txtIGV.getText());
        Double total = Double.valueOf(txtTotal.getText());
        
        TipoComprobante tipoComprobanteSelecionado = (TipoComprobante) cboTipoComprobante.getSelectedItem();
        int tipoComprobanteId = tipoComprobanteSelecionado.getId();
        
        MetodoPago metodoPagoSelecionado = (MetodoPago) cboMetodoPago.getSelectedItem();
        int metodoPagoId = metodoPagoSelecionado.getId();
        
        this.controlador.registrarVenta(igvget, total, tipoComprobanteId, metodoPagoId, this.idUsuario);
        panelListener.abrirPanel(PANEL_VENTA);
    }
    
    private void eliminarCestaTemporalUsuario(){
        this.controladorList.eliminarCestaTemporalUsuario(this.idUsuario);
        resetPanel();
    }
    
    private void eliminarItemCestaTemporal(String producto){
        this.controladorList.eliminarItemCestaTemporal(idUsuario, producto);
        resetPanel();
    }
    
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            resetPanel();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbVenta = new javax.swing.JTable();
        txtIGV = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        cboMetodoPago = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        cboTipoComprobante = new javax.swing.JComboBox<>();
        lblRol = new javax.swing.JLabel();
        errorEstado = new javax.swing.JLabel();
        txtCodigoBarras = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        btnRegistrarVenta = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        errorCodigoBarras = new javax.swing.JLabel();
        errorIGV = new javax.swing.JLabel();
        errorTotal = new javax.swing.JLabel();
        errorMetodoPago = new javax.swing.JLabel();
        errorTipoComprobante = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        RegresarCreatVentaP = new javax.swing.JButton();

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

        txtIGV.setEnabled(false);

        lblApellido.setText("Total");

        txtTotal.setEnabled(false);
        txtTotal.setPreferredSize(new java.awt.Dimension(150, 22));

        lblNombre.setText("IGV");

        lblEstado.setText("Metodo de pago");

        lblRol.setText("Tipo Comprobante");

        errorEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorEstado.setForeground(new java.awt.Color(255, 51, 51));
        errorEstado.setInheritsPopupMenu(false);

        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnRegistrarVenta.setText("Registrar");
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        errorCodigoBarras.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorCodigoBarras.setForeground(new java.awt.Color(255, 51, 51));
        errorCodigoBarras.setInheritsPopupMenu(false);

        errorIGV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorIGV.setForeground(new java.awt.Color(255, 51, 51));
        errorIGV.setInheritsPopupMenu(false);

        errorTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorTotal.setForeground(new java.awt.Color(255, 51, 51));
        errorTotal.setInheritsPopupMenu(false);

        errorMetodoPago.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorMetodoPago.setForeground(new java.awt.Color(255, 51, 51));
        errorMetodoPago.setInheritsPopupMenu(false);

        errorTipoComprobante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorTipoComprobante.setForeground(new java.awt.Color(255, 51, 51));
        errorTipoComprobante.setInheritsPopupMenu(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("VENTAS AGREGAR");

        RegresarCreatVentaP.setText("regresar");
        RegresarCreatVentaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarCreatVentaPActionPerformed(evt);
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
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RegresarCreatVentaP, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(btnAgregarProducto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(errorCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(errorIGV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIGV, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblApellido)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(errorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(errorMetodoPago, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboMetodoPago, javax.swing.GroupLayout.Alignment.LEADING, 0, 120, Short.MAX_VALUE)
                                    .addComponent(lblEstado, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblRol)
                                            .addComponent(cboTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 9, Short.MAX_VALUE))
                                    .addComponent(errorTipoComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))))
            .addGroup(layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(291, 291, 291)
                    .addComponent(errorEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(459, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(errorCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(RegresarCreatVentaP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(lblApellido)
                            .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarProducto))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRol)
                            .addComponent(lblEstado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(btnRegistrarVenta)
                        .addGap(0, 131, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(265, 265, 265)
                    .addComponent(errorEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(215, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed
        if (ValidateVentaCreate.validarCampos(this)) {
            registrarVenta();
        }
    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
              if(ValidateVentaCreate.validarCestaTemporal(this)){
            registrarCestaTemporal();
        }  
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        eliminarCestaTemporalUsuario();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void RegresarCreatVentaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarCreatVentaPActionPerformed
      panelListener.abrirPanel(ConstantesPaneles.PANEL_VENTA);
    }//GEN-LAST:event_RegresarCreatVentaPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegresarCreatVentaP;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrarVenta;
    public javax.swing.JComboBox<MetodoPago> cboMetodoPago;
    public javax.swing.JComboBox<TipoComprobante> cboTipoComprobante;
    public javax.swing.JLabel errorCodigoBarras;
    public javax.swing.JLabel errorEstado;
    public javax.swing.JLabel errorIGV;
    public javax.swing.JLabel errorMetodoPago;
    public javax.swing.JLabel errorTipoComprobante;
    public javax.swing.JLabel errorTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRol;
    public javax.swing.JTable tbVenta;
    public javax.swing.JTextField txtCodigoBarras;
    public javax.swing.JTextField txtIGV;
    public javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
