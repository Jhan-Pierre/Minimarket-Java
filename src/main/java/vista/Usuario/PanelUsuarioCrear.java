package vista.Usuario;

import Constantes.ConstantesPaneles;
import Controlador.Estado.EstadoController;
import Controlador.Rol.RolController;
import Controlador.Turno.TurnoController;
import Controlador.Usuario.UsuarioControllerCreate;
import Modelo.Estado;
import Modelo.Rol;
import Modelo.Turno;
import Utilidades.IPanelListener;
import static Constantes.ConstantesPaneles.PANEL_USUARIO;
import Utilidades.OnlyNumbers;
import static Validaciones.ValidateUsuarioCreate.*; //importar las validaciones de los campos


public class PanelUsuarioCrear extends javax.swing.JPanel {
    private UsuarioControllerCreate controlador;
    public IPanelListener panelListener;  
    
    public PanelUsuarioCrear(IPanelListener panelListener) {
        this.panelListener = panelListener;
        initComponents();
        
        txtTelefono.addKeyListener(new OnlyNumbers()); //impedir que se digite algo diferente a un numero

        controlador = new UsuarioControllerCreate();
        
        TurnoController turnoController = new TurnoController();
        turnoController.cargarTurnosEnComboBox(cboTurno); 
        
        EstadoController estadoController = new EstadoController();
        estadoController.cargarEstadosEnComboBox(cboEstado);
        
        RolController rolController = new RolController();
        rolController.cargarRolesEnComboBox(cboRol);   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cboTurno = new javax.swing.JComboBox<>();
        lblNombre = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        lblApellido1 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        cboRol = new javax.swing.JComboBox<>();
        lblRol = new javax.swing.JLabel();
        btnAgregarUsuario = new javax.swing.JButton();
        errorNombre = new javax.swing.JLabel();
        errorApellido = new javax.swing.JLabel();
        errorTelefono = new javax.swing.JLabel();
        errorTurno = new javax.swing.JLabel();
        errorContraseña = new javax.swing.JLabel();
        errorConfirmarContraseña = new javax.swing.JLabel();
        errorEstado = new javax.swing.JLabel();
        errorRol = new javax.swing.JLabel();
        errorCorreo = new javax.swing.JLabel();
        RegresarCrearP = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        txtConfirmarContraseña = new javax.swing.JPasswordField();

        setPreferredSize(new java.awt.Dimension(900, 490));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setText("Crear Usuario");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombre.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Correo");

        lblApellido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblApellido.setText("Apellido");

        txtApellido.setPreferredSize(new java.awt.Dimension(150, 22));

        lblNombre1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombre1.setText("Contraseña");

        lblApellido1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblApellido1.setText("Confirma contraseña");

        lblTurno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTurno.setText("Turno");

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTelefono.setText("Telefono");

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEstado.setText("Estado");

        lblRol.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRol.setText("Rol");

        btnAgregarUsuario.setText("Agregar");
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });

        errorNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorNombre.setForeground(new java.awt.Color(255, 51, 51));
        errorNombre.setInheritsPopupMenu(false);

        errorApellido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorApellido.setForeground(new java.awt.Color(255, 51, 51));
        errorApellido.setInheritsPopupMenu(false);

        errorTelefono.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorTelefono.setForeground(new java.awt.Color(255, 51, 51));
        errorTelefono.setInheritsPopupMenu(false);

        errorTurno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorTurno.setForeground(new java.awt.Color(255, 51, 51));
        errorTurno.setInheritsPopupMenu(false);

        errorContraseña.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorContraseña.setForeground(new java.awt.Color(255, 51, 51));
        errorContraseña.setInheritsPopupMenu(false);

        errorConfirmarContraseña.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorConfirmarContraseña.setForeground(new java.awt.Color(255, 51, 51));
        errorConfirmarContraseña.setInheritsPopupMenu(false);

        errorEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorEstado.setForeground(new java.awt.Color(255, 51, 51));
        errorEstado.setInheritsPopupMenu(false);

        errorRol.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorRol.setForeground(new java.awt.Color(255, 51, 51));
        errorRol.setInheritsPopupMenu(false);

        errorCorreo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorCorreo.setForeground(new java.awt.Color(255, 51, 51));
        errorCorreo.setInheritsPopupMenu(false);

        RegresarCrearP.setText("regresar");
        RegresarCrearP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarCrearPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(errorEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(errorRol, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(385, 385, 385))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(errorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(errorApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblNombre))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblApellido)
                                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtCorreo)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblEstado)
                                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblRol)
                                            .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(errorCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(errorTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTurno)
                                            .addComponent(cboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(errorTurno, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblNombre1)
                                            .addComponent(btnAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(errorContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(txtContraseña))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblApellido1)
                                            .addComponent(errorConfirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtConfirmarContraseña))))))
                        .addGap(49, 49, 49))))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(RegresarCrearP, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(RegresarCrearP)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombre)
                                    .addComponent(lblApellido))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTurno)
                                    .addComponent(lblTelefono))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorTurno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errorApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombre1)
                        .addComponent(lblApellido1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorConfirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRol)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorRol, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(btnAgregarUsuario)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed

        if(validarCampos(this)){
            String correo = txtCorreo.getText();
            String password = txtContraseña.getText();
            String telefono = txtTelefono.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();

            Rol rolSelecionado = (Rol) cboRol.getSelectedItem();
            int rolId = rolSelecionado.getId();

            Estado estadoSeleccionado = (Estado) cboEstado.getSelectedItem();
            int estadoId = estadoSeleccionado.getId();

            Turno turnoSeleccionado = (Turno) cboTurno.getSelectedItem();
            int turnoId = turnoSeleccionado.getId();

            // Llamar al método del controlador para crear el usuario
            controlador.crearUsuario(correo, password, telefono, nombre, apellido, rolId, estadoId, turnoId);


            panelListener.abrirPanel(PANEL_USUARIO);
        }
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

    private void RegresarCrearPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarCrearPActionPerformed
        if (panelListener != null) {
        panelListener.abrirPanel(ConstantesPaneles.PANEL_USUARIO);
    }
    }//GEN-LAST:event_RegresarCrearPActionPerformed

    // Cuando el panel sea visible se resetea el contenido
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            resetPanel();
        }
    }
    
    public void resetPanel() {
        limpiarMensajesError(this);
        // Resetea los campos de texto
        txtCorreo.setText("");
        txtContraseña.setText("");
        txtConfirmarContraseña.setText("");
        txtTelefono.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        
        // Resetea los combobox seleccionando el primer ítem
        if (cboRol.getItemCount() > 0) {
            cboRol.setSelectedIndex(0);
        }
        if (cboEstado.getItemCount() > 0) {
            cboEstado.setSelectedIndex(0);
        }
        if (cboTurno.getItemCount() > 0) {
            cboTurno.setSelectedIndex(0);
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegresarCrearP;
    public javax.swing.JButton btnAgregarUsuario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    public javax.swing.JComboBox<Estado> cboEstado;
    public javax.swing.JComboBox<Rol> cboRol;
    public javax.swing.JComboBox<Turno> cboTurno;
    public javax.swing.JLabel errorApellido;
    public javax.swing.JLabel errorConfirmarContraseña;
    public javax.swing.JLabel errorContraseña;
    public javax.swing.JLabel errorCorreo;
    public javax.swing.JLabel errorEstado;
    public javax.swing.JLabel errorNombre;
    public javax.swing.JLabel errorRol;
    public javax.swing.JLabel errorTelefono;
    public javax.swing.JLabel errorTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTurno;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JPasswordField txtConfirmarContraseña;
    public javax.swing.JPasswordField txtContraseña;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
