package vista.Categoria;

import static Constantes.ConstantesPaneles.PANEL_CATEGORIA_CREAR;
import static Constantes.ConstantesPaneles.PANEL_CATEGORIA_EDITAR;
import static Constantes.ConstantesPaneles.PANEL_CATEGORIA_SHOW;
import Controlador.Categoria.CategoriaControllerDelete;
import Controlador.Categoria.CategoriaControllerList;
import Utilidades.ButtonColumn;
import Utilidades.IButtonClickListener;
import Utilidades.IPanelListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelCategoria extends javax.swing.JPanel implements IButtonClickListener {
    private CategoriaControllerList controlador;
    public IPanelListener panelListener;
    private CategoriaControllerDelete ctrDelete;
    
    public PanelCategoria(IPanelListener panelListener) {
        this.panelListener = panelListener;
        initComponents();
        inicializar();
        
        //Hacer una búsqueda cada vez que se escribe en txtBuscarCategoria
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
        new ButtonColumn(tbCategoria, 0, this); // Botón en la columna 'id'
        new ButtonColumn(tbCategoria, 1, this); // Botón en la columna 'nombre'
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
        controlador = new CategoriaControllerList();
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
    
    //Cuando el panel de categoría sea visible, se resetea el contenido
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
        tbCategoria = new javax.swing.JTable();
        txtBuscarCategoria = new javax.swing.JTextField();
        btnAgregarCategoria = new javax.swing.JButton();

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

        btnAgregarCategoria.setText("Agregar");
        btnAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 526, Short.MAX_VALUE)
                        .addComponent(btnAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarCategoria)
                    .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCategoriaActionPerformed
       
    }//GEN-LAST:event_btnAgregarCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbCategoria;
    private javax.swing.JTextField txtBuscarCategoria;
    // End of variables declaration//GEN-END:variables
}
