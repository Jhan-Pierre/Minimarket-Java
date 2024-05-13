package vista.Categoria;

import Controlador.Categoria.CategoriaControllerCreate;
import Utilidades.IPanelListener;
import Constantes.ConstantesPaneles;
import Validaciones.Categoria.ValidateCategoriaCreate;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelCategoriaCrear extends javax.swing.JPanel {
    private CategoriaControllerCreate controlador;
    public IPanelListener panelListener;  
    public JLabel errorCategoria;
    public JTextField TextCategoria;
    
    
    public PanelCategoriaCrear(IPanelListener panelListener) {
        this.panelListener = panelListener;
        initComponents();
        
        controlador = new CategoriaControllerCreate();
    }
    
    public String obtenerNombreCategoria() {
        return TextCategoria.getText();
    }
    
    public void limpiarMensajesError() {
        errorCategoria.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloAgregarCategoria = new javax.swing.JLabel();
        btnAgregarCategoria = new javax.swing.JButton();
        NombreCategoriaAgregar = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(900, 490));

        TituloAgregarCategoria.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        TituloAgregarCategoria.setText("Agregar Categoria");

        btnAgregarCategoria.setText("Agregar");

        NombreCategoriaAgregar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NombreCategoriaAgregar.setText("Nombre de la categoria:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(btnAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TituloAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreCategoriaAgregar))))
                .addContainerGap(409, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(TituloAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(NombreCategoriaAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                .addComponent(btnAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NombreCategoriaAgregar;
    private javax.swing.JLabel TituloAgregarCategoria;
    private javax.swing.JButton btnAgregarCategoria;
    // End of variables declaration//GEN-END:variables
}
