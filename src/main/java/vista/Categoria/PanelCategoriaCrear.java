
package vista.Categoria;

import Constantes.ConstantesPaneles;
import Controlador.Categoria.CategoriaControllerCreate;
import Utilidades.IPanelListener;
import static Constantes.ConstantesPaneles.PANEL_CATEGORIA;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Validaciones.Categoria.ValidateCategoriaCreate;

public class PanelCategoriaCrear extends javax.swing.JPanel {

    public IPanelListener panelListener;  
    private CategoriaControllerCreate controlador;

    public PanelCategoriaCrear(IPanelListener panelListener) {
        this.panelListener = panelListener;
        //this.tablaCategorias = tablaCategorias; // Inicializa la tabla
        initComponents();
    
    controlador = new CategoriaControllerCreate();
    }
    
    public String getNombreCategoria() {
        return txtCategoriaCrear.getText();
    }

    /*private void agregarCategoriaATabla(String nombreCategoria) {
        DefaultTableModel modelo = (DefaultTableModel) tablaCategorias.getModel();
        modelo.addRow(new Object[]{nombreCategoria});
    }*/
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCategoriaCrear = new javax.swing.JTextField();
        btnAgregarCategoriaCrear = new javax.swing.JButton();
        RegresarPanelCategoria = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 300));

        jLabel1.setText("CREAR CATEGORIA");

        jLabel2.setText("Nonbre de categoria:");

        btnAgregarCategoriaCrear.setText("Agregar");
        btnAgregarCategoriaCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCategoriaCrearActionPerformed(evt);
            }
        });

        RegresarPanelCategoria.setText("regresar");
        RegresarPanelCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarPanelCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCategoriaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(341, 341, 341)
                                .addComponent(btnAgregarCategoriaCrear))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(RegresarPanelCategoria)))
                .addContainerGap(396, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(RegresarPanelCategoria)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCategoriaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnAgregarCategoriaCrear)
                .addGap(81, 81, 81))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCategoriaCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCategoriaCrearActionPerformed
       String nombre = txtCategoriaCrear.getText();
    
    // Validar el nombre antes de agregar la categoría
    if (ValidateCategoriaCreate.validarNombre(nombre)) {
        // Agregar la categoría
        controlador.agregarCategoria(nombre);
        
        // Limpiar el campo de texto
        txtCategoriaCrear.setText("");
        
        // Abrir el panel de categoría
        panelListener.abrirPanel(PANEL_CATEGORIA);
    } else {
        // Mostrar un mensaje de error si el nombre no es válido
        JOptionPane.showMessageDialog(this, "El nombre de la categoría solo puede contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnAgregarCategoriaCrearActionPerformed

    private void RegresarPanelCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarPanelCategoriaActionPerformed
        // Llamar al método abrirPanel del panelListener para abrir el panel de categoría
        if (panelListener != null) {
            panelListener.abrirPanel(ConstantesPaneles.PANEL_CATEGORIA);
    }
    }//GEN-LAST:event_RegresarPanelCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegresarPanelCategoria;
    private javax.swing.JButton btnAgregarCategoriaCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JTextField txtCategoriaCrear;
    // End of variables declaration//GEN-END:variables
}
