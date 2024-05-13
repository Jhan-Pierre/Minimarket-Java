
package vista.Categoria;

import Controlador.Categoria.CategoriaControllerCreate;
import Utilidades.IPanelListener;
import static Constantes.ConstantesPaneles.PANEL_CATEGORIA;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelCategoriaCrear extends javax.swing.JPanel {

    public IPanelListener panelListener;  
    private JTable tablaCategorias;
    private CategoriaControllerCreate controlador;

    public PanelCategoriaCrear(IPanelListener panelListener, JTable tablaCategorias) {
        this.panelListener = panelListener;
        this.tablaCategorias = tablaCategorias; // Inicializa la tabla
        initComponents();
    
    controlador = new CategoriaControllerCreate();
    }
    
    public String getNombreCategoria() {
        return txtCategoriaCrear.getText();
    }

    private void agregarCategoriaATabla(String nombreCategoria) {
        DefaultTableModel modelo = (DefaultTableModel) tablaCategorias.getModel();
        modelo.addRow(new Object[]{nombreCategoria});
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCategoriaCrear = new javax.swing.JTextField();
        btnAgregarCategoriaCrear = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 300));

        jLabel1.setText("CREAR CATEGORIA");

        jLabel2.setText("Nonbre de categoria:");

        btnAgregarCategoriaCrear.setText("Agregar");
        btnAgregarCategoriaCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCategoriaCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(txtCategoriaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(btnAgregarCategoriaCrear)))
                .addContainerGap(437, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(80, 80, 80)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCategoriaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(btnAgregarCategoriaCrear)
                .addGap(88, 88, 88))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCategoriaCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCategoriaCrearActionPerformed
        String nombreCategoria = getNombreCategoria();

        // Llamar al método del controlador para agregar la categoría
        String mensaje = controlador.agregarCategoria(nombreCategoria);

        // Verificar si se agregó correctamente
        if (mensaje.startsWith("Categoría agregada")) {
            // Agregar la nueva categoría a la tabla
            agregarCategoriaATabla(nombreCategoria);

            panelListener.abrirPanel(PANEL_CATEGORIA);
        } else {
            // Mostrar mensaje de error si hubo algún problema al agregar la categoría
            JOptionPane.showMessageDialog(this, mensaje, "Error al agregar categoría", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarCategoriaCrearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCategoriaCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JTextField txtCategoriaCrear;
    // End of variables declaration//GEN-END:variables
}
