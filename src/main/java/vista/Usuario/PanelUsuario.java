package vista.Usuario;

import static Constantes.ConstantesPaneles.PANEL_USUARIO_CREAR;
import static Constantes.ConstantesPaneles.PANEL_USUARIO_EDITAR;
import static Constantes.ConstantesPaneles.PANEL_USUARIO_SHOW;
import Controlador.Usuario.UsuarioControllerDelete;
import Controlador.Usuario.UsuarioControllerList;
import Controlador.Usuario.UsuarioControllerLogin;
import Utilidades.ButtonColumn;
import Utilidades.IButtonClickListener;
import Utilidades.IPanelListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PanelUsuario extends javax.swing.JPanel implements IButtonClickListener {
    private UsuarioControllerList controlador;
    public IPanelListener panelListener;
    private UsuarioControllerDelete ctrDelete;
    
    public PanelUsuario(IPanelListener panelListener) {
        this.panelListener = panelListener;
        initComponents();
        inicializar();
        
        //Hacer una busque cada vez que se escribe en txt buscar
        txtBuscarUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarUsuarios(txtBuscarUsuario.getText());
            }
        });
    }
    
    public void buscarUsuarios(String texto) {
        DefaultTableModel model = controlador.obtenerModeloTabla(texto);
        tbUsuario.setModel(model);
        new ButtonColumn(tbUsuario, 7, this);
        new ButtonColumn(tbUsuario, 8, this);
        new ButtonColumn(tbUsuario, 9, this);

    }
    
    @Override
    public void buttonClicked(int row, int column, String buttonText) {
        Long id = (Long) tbUsuario.getModel().getValueAt(row, 0);
        switch (buttonText) {
            case "Ver detalles" -> abrirDetallesUsuario(id);
            case "Editar" -> abrirEditarUsuario(id);
            case "Eliminar" -> eliminarUsuario(id);
        }
    }
    
    private void abrirDetallesUsuario(Long id) {
        if (panelListener != null) {
            panelListener.abrirPanel(PANEL_USUARIO_SHOW, id);
        }
    }

    private void abrirEditarUsuario(Long id) {
        if (panelListener != null) {
            panelListener.abrirPanel(PANEL_USUARIO_EDITAR, id);
        }
    }

    private void eliminarUsuario(Long id) {
        // Mostrar un JOptionPane de confirmación
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        // Verificar si el usuario confirmó la eliminación
        if (opcion == JOptionPane.YES_OPTION) {
            // Llamar al controlador para eliminar el usuario
            String mensaje = ctrDelete.eliminarUsuario(id);

            // Mostrar el mensaje de confirmación o error
            JOptionPane.showMessageDialog(this, mensaje);

            // Actualizar la tabla después de eliminar el usuario
            buscarUsuarios("");
        }
    }
    private void inicializar() {
        controlador = new UsuarioControllerList();
        ctrDelete = new UsuarioControllerDelete();
        buscarUsuarios("");
    }
    

    private void abrirPanelUsuarioCrear() {
        // Solicitar al PanelListener que abra PanelUsuarioCrear
        this.panelListener.abrirPanel(PANEL_USUARIO_CREAR);
    }

    public void resetPanel() {
        txtBuscarUsuario.setText("");
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        txtBuscarUsuario = new javax.swing.JTextField();
        btnAgregarUsuario = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 490));

        jLabel1.setText("Lista de Usuarios");

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbUsuario);

        btnAgregarUsuario.setText("Agregar");
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });

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
                        .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregarUsuario)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
         abrirPanelUsuarioCrear();
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbUsuario;
    private javax.swing.JTextField txtBuscarUsuario;
    // End of variables declaration//GEN-END:variables
}
