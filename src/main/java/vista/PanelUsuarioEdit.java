package vista;

import static Constantes.ConstantesPaneles.PANEL_USUARIO;
import Controlador.Estado.EstadoController;
import Controlador.Rol.RolController;
import Controlador.Turno.TurnoController;
import Controlador.Usuario.UsuarioControllerEdit;
import Modelo.Estado;
import Modelo.Rol;
import Modelo.Turno;
import Modelo.Usuario;
import Utilidades.IPanelListener;
import Utilidades.Identificable;
import javax.swing.JComboBox;

public class PanelUsuarioEdit extends javax.swing.JPanel {
    private UsuarioControllerEdit controlador;
    public IPanelListener panelListener;
    
    public PanelUsuarioEdit(IPanelListener panelListener) {
        this.panelListener = panelListener;
        this.inicializar();
    }

    private void CargarComboBox(){
        TurnoController turnoController = new TurnoController();
        turnoController.cargarTurnosEnComboBox(cboTurno); 
        
        EstadoController estadoController = new EstadoController();
        estadoController.cargarEstadosEnComboBox(cboEstado);
        
        RolController rolController = new RolController();
        rolController.cargarRolesEnComboBox(cboRol); 
    }
    
    public void BuscarUsuarioPorId(Long id){
        Usuario usuario = controlador.buscarUsuarioPorCodigo(id);
        
        if (usuario != null) {
            txtId.setText(String.valueOf(id));
            txtNombre.setText(usuario.getNombre());
            txtApellido.setText(usuario.getApellido());
            txtTelefono.setText(usuario.getTelefono());
            txtCorreo.setText(usuario.getCorreo());
            
            // Obtener los IDs de rol, estado y turno
            int rolId = usuario.getRolId();
            int estadoId = usuario.getEstado_id();
            int turnoId = usuario.getTurno_id();

            // Seleccionar los elementos correspondientes en los ComboBox
            cboRol.setSelectedItem(obtenerRolPorId(rolId));
            cboEstado.setSelectedItem(obtenerEstadoPorId(estadoId));
            cboTurno.setSelectedItem(obtenerTurnoPorId(turnoId));
        } else {
            System.out.println("Usuario no encontrado con el ID: " + id);
        }
    }
    
    private Rol obtenerRolPorId(int rolId) {
        return obtenerPorId(cboRol, rolId);
    }

    private Estado obtenerEstadoPorId(int estadoId) {
        return obtenerPorId(cboEstado, estadoId);
    }

    private Turno obtenerTurnoPorId(int turnoId) {
        return obtenerPorId(cboTurno, turnoId);
    }

    // Obtener el Id de caulquier objeto
    private <T extends Identificable> T obtenerPorId(JComboBox<T> comboBox, int id) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            T item = comboBox.getItemAt(i);
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Si no se encuentra el item con el ID especificado
    }
    
    private void inicializar(){
        initComponents();
        controlador = new UsuarioControllerEdit();
        this.CargarComboBox();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre1 = new javax.swing.JLabel();
        btnEditarUsuario = new javax.swing.JButton();
        txtContraseña = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JLabel();
        txtConfirmarContraseña = new javax.swing.JTextField();
        lblTurno = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        cboTurno = new javax.swing.JComboBox<>();
        lblNombre = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        cboRol = new javax.swing.JComboBox<>();
        txtApellido = new javax.swing.JTextField();
        lblRol = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(900, 490));

        lblNombre1.setText("Contraseña");

        btnEditarUsuario.setText("Editar");
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });

        lblApellido1.setText("Confirma contraseña");

        txtConfirmarContraseña.setPreferredSize(new java.awt.Dimension(150, 22));

        lblTurno.setText("Turno");

        lblTelefono.setText("Telefono");

        lblEstado.setText("Estado");

        lblNombre.setText("Nombre");

        jLabel3.setText("Correo");

        lblApellido.setText("Apellido");

        txtApellido.setPreferredSize(new java.awt.Dimension(150, 22));

        lblRol.setText("Rol");

        lblNombre2.setText("ID");

        txtId.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstado)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRol)
                            .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTurno)
                            .addComponent(cboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNombre2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNombre))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblApellido)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTelefono)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNombre1))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblApellido1)
                                .addComponent(txtConfirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(155, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(382, 382, 382))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
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
                        .addComponent(lblTelefono)
                        .addGap(28, 28, 28))
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombre1)
                                    .addComponent(lblApellido1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtConfirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTurno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(btnEditarUsuario)
                .addGap(62, 62, 62))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
        long id = Long.parseLong(txtId.getText());
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
        
        controlador.editarUsuario(id, correo, password, telefono, nombre, apellido, rolId, estadoId, turnoId);
        panelListener.abrirPanel(PANEL_USUARIO);
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEditarUsuario;
    public javax.swing.JComboBox<Estado> cboEstado;
    public javax.swing.JComboBox<Rol> cboRol;
    public javax.swing.JComboBox<Turno> cboTurno;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTurno;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtConfirmarContraseña;
    public javax.swing.JTextField txtContraseña;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
