package vista.Categoria;

import static Constantes.ConstantesPaneles.PANEL_CATEGORIA_CREAR;
import static Constantes.ConstantesPaneles.PANEL_CATEGORIA_EDITAR;
import static Constantes.ConstantesPaneles.PANEL_CATEGORIA_SHOW;
import Controlador.Categoria.CategoriaControllerDelete;
import Controlador.Categoria.CategoriaControllerList;
import Controlador.GlobalPermisos;
import Utilidades.ButtonColumn;
import Utilidades.IButtonClickListener;
import Utilidades.IPanelListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelCategoria extends javax.swing.JPanel implements IButtonClickListener {
    private CategoriaControllerList controlador;
    public IPanelListener panelListener;
    private CategoriaControllerDelete ctrDelete;
    private Set<String> permisosUsuario;
    
    public PanelCategoria(IPanelListener panelListener) {
        this.panelListener = panelListener;
        this.permisosUsuario = GlobalPermisos.getPermisos();
        initComponents();
        inicializar();
        
        // Hacer una búsqueda cada vez que se escribe en txtBuscarCategoria
        txtBuscarCategoria.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarCategorias(txtBuscarCategoria.getText());
            }
        });
    }

    
    public void buscarCategorias(String texto) {
        DefaultTableModel model = controlador.obtenerModeloTabla(texto);
        tbCategoria.setModel(model);

        // Verificar permisos antes de agregar botones a las columnas
        if (permisosUsuario.contains("ver_detalle_categoria_producto")) {
            new ButtonColumn(tbCategoria, 2, this); // Convertir la tercera columna ("Ver detalles") en un botón
        }
        if (permisosUsuario.contains("editar_categoria_producto")) {
            new ButtonColumn(tbCategoria, 3, this); // Convertir la cuarta columna ("Editar") en un botón
        }
        if (permisosUsuario.contains("eliminar_categoria_producto")) {
            new ButtonColumn(tbCategoria, 4, this); // Convertir la quinta columna ("Eliminar") en un botón
        }
    }

    
    @Override
    public void buttonClicked(int row, int column, String buttonText) {
        Long id = (Long) tbCategoria.getModel().getValueAt(row, 0);
        switch (buttonText) {
            case "Ver detalles" -> abrirDetallesCategoria(id);
            case "Editar" -> abrirEditarCategoria(id);
            case "Eliminar" -> eliminarCategoria(id);
        }
    }
    
    private void abrirDetallesCategoria(Long id) {
        if (panelListener != null) {
            panelListener.abrirPanel(PANEL_CATEGORIA_SHOW, id);
        }
    }

    private void abrirEditarCategoria(Long id) {
        if (panelListener != null) {
            panelListener.abrirPanel(PANEL_CATEGORIA_EDITAR, id);
        }
    }   

    private void eliminarCategoria(Long id) {
        // Mostrar un JOptionPane de confirmación
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar esta categoría?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        // Verificar si el usuario confirmó la eliminación
        if (opcion == JOptionPane.YES_OPTION) {
            // Llamar al controlador para eliminar la categoría
            String mensaje = ctrDelete.eliminarCategoria(id);

            // Mostrar el mensaje de confirmación o error
            JOptionPane.showMessageDialog(this, mensaje);

            // Actualizar la tabla después de eliminar la categoría
            buscarCategorias("");
        }
    }
    
    private void inicializar() {
        controlador = new CategoriaControllerList(permisosUsuario);
        ctrDelete = new CategoriaControllerDelete();
        buscarCategorias("");
    }
    
    private void abrirPanelCategoriaCrear() {
        // Solicitar al PanelListener que abra PanelCategoriaCrear
        this.panelListener.abrirPanel(PANEL_CATEGORIA_CREAR);
    }

    public void resetPanel() {
        txtBuscarCategoria.setText("");
        buscarCategorias("");
    }
    
    // Cuando el panel de categoría sea visible, se resetea el contenido
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

        txtBuscarCategoria = new javax.swing.JTextField();
        btnAgregarCategoria = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCategoria = new javax.swing.JTable();

        btnAgregarCategoria.setText("Agregar");
        btnAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCategoriaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Lista de Categoria");

        tbCategoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbCategoria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(54, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregarCategoria)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCategoriaActionPerformed
        abrirPanelCategoriaCrear();
    }//GEN-LAST:event_btnAgregarCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbCategoria;
    private javax.swing.JTextField txtBuscarCategoria;
    // End of variables declaration//GEN-END:variables
}
