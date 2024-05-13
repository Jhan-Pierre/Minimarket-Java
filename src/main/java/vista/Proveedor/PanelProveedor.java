package vista.Proveedor;

import static Constantes.ConstantesNombreBotonesTablas.*;
import static Constantes.ConstantesPaneles.PANEL_PROVEEDOR_CREAR;
import static Constantes.ConstantesPaneles.PANEL_PROVEEDOR_EDITAR;
import static Constantes.ConstantesPaneles.PANEL_PROVEEDOR_SHOW;
import Controlador.Proveedor.ProveedorControllerDelete;
import Controlador.Proveedor.ProveedorControllerList;
import Utilidades.ButtonColumn;

import Utilidades.IButtonClickListener;
import Utilidades.IPanelListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelProveedor extends javax.swing.JPanel implements IButtonClickListener {
    private ProveedorControllerList controlador;
    private final IPanelListener panelListener;
    private ProveedorControllerDelete ctrDelete;
    
    public PanelProveedor(IPanelListener panelListener) {
        this.panelListener = panelListener;
        initComponents();
        inicializar();
        
        // Hacer una búsqueda cada vez que se escribe en txtBuscarProveedor
        txtBuscarProveedor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarProveedores(txtBuscarProveedor.getText());
            }
        });
    }
    
    public void buscarProveedores(String texto) {
        DefaultTableModel model = controlador.obtenerModeloTabla(texto);
        tbProveedor.setModel(model);
        new ButtonColumn(tbProveedor, 6, this);
        new ButtonColumn(tbProveedor, 7, this);
        new ButtonColumn(tbProveedor, 8, this);

    }
    
    @Override
    public void buttonClicked(int row, int column, String buttonText) {
        Long id = (Long) tbProveedor.getModel().getValueAt(row, 0);
        switch (buttonText) {
            case VER_DETALLES -> abrirDetallesProveedor(id);
            case EDITAR -> abrirEditarProveedor(id);
            case ELIMINAR -> eliminarProveedor(id);
        }
    }
    
    private void abrirDetallesProveedor(Long id) {
        if (panelListener != null) {
            panelListener.abrirPanel(PANEL_PROVEEDOR_SHOW, id);
        }
    }

    private void abrirEditarProveedor(Long id) {
        if (panelListener != null) {
            panelListener.abrirPanel(PANEL_PROVEEDOR_EDITAR, id);
        }
    }

    private void eliminarProveedor(Long id) {
        // Mostrar un JOptionPane de confirmación
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este proveedor?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        // Verificar si el usuario confirmó la eliminación
        if (opcion == JOptionPane.YES_OPTION) {
            // Llamar al controlador para eliminar el proveedor
            String mensaje = ctrDelete.eliminarProveedor(id);

            // Mostrar el mensaje de confirmación o error
            JOptionPane.showMessageDialog(this, mensaje);

            // Actualizar la tabla después de eliminar el proveedor
            buscarProveedores("");
        }
    }
    
    private void inicializar() {
        controlador = new ProveedorControllerList();
        ctrDelete = new ProveedorControllerDelete();
        buscarProveedores("");
    }
    
    private void abrirPanelProveedorCrear() {
        // Solicitar al PanelListener que abra PanelProveedorCrear
        this.panelListener.abrirPanel(PANEL_PROVEEDOR_CREAR);
    }

    public void resetPanel() {
        txtBuscarProveedor.setText("");
        buscarProveedores("");
    }
    
    // Cuando el panel proveedor sea visible se resetea el contenido
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProveedor = new javax.swing.JTable();
        txtBuscarProveedor = new javax.swing.JTextField();
        btnAgregarProveedor = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 490));

        jLabel1.setText("Lista de Proveedores");

        tbProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbProveedor);

        btnAgregarProveedor.setText("Agregar");
        btnAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(7, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarProveedor)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProveedor))
                .addGap(18, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        //panelPadre.vista.show(panelPadre.PanelPadre, "UsuarioCrear");
        abrirPanelProveedorCrear();
    }//GEN-LAST:event_btnAgregarProveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbProveedor;
    private javax.swing.JTextField txtBuscarProveedor;
    // End of variables declaration//GEN-END:variables
}
