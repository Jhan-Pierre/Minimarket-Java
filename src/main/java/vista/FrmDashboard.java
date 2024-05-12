package vista;

import vista.Usuario.PanelUsuarioShow;
import vista.Usuario.PanelUsuarioEdit;
import vista.Usuario.PanelUsuario;
import vista.Usuario.PanelUsuarioCrear;
import static Constantes.ConstantesPaneles.*;
import Controlador.GlobalPermisos;

import javax.swing.JOptionPane;
import java.awt.CardLayout;
import java.util.Set;
import javax.swing.JPanel;
import Utilidades.IPanelListener;
import vista.Categoria.PanelCategoria;
import vista.Venta.PanelVenta;
import vista.Venta.PanelVentaCreate;


public final class FrmDashboard extends javax.swing.JFrame implements IPanelListener {
    // Declaración de tus paneles
    PanelDashboard panelDashboard;
    PanelUsuario panelUsuario;
    PanelUsuarioCrear panelUsuarioCrear;
    PanelUsuarioEdit panelUsuarioEdit;
    PanelUsuarioShow panelUsuarioShow;
    
    PanelCategoria panelCategoria;
    
    PanelProducto panelProducto;
    
    PanelVenta panelVenta;
    PanelVentaCreate panelventaCreate;
    
    public static CardLayout vista;

    public FrmDashboard() {
        initComponents();
        configurarPaneles();
        configurarListeners();
        configurarAccesoSegunRol(GlobalPermisos.getPermisos()); // Utiliza la clase global aquí
    }
    
    private void configurarPaneles() {
        panelDashboard = new PanelDashboard();
        panelUsuario = new PanelUsuario(this);
        panelUsuarioCrear = new PanelUsuarioCrear(this);
        panelUsuarioEdit = new PanelUsuarioEdit(this);
        panelUsuarioShow = new PanelUsuarioShow(this);
        
        panelCategoria = new PanelCategoria(this);
        
        panelProducto = new PanelProducto();
        
        panelVenta = new PanelVenta(this);
        panelventaCreate = new PanelVentaCreate(this);
        inicializarPaneles();
    }
    
    private void inicializarPaneles() {
        // Usamos CardLayout para cambiar entre paneles
        vista = new CardLayout();
        PanelPadre.setLayout(vista);

        // Añadimos los paneles a PanelPadre
        agregarPanel(panelDashboard, PANEL_DASHBOARD);
        agregarPanel(panelUsuario, PANEL_USUARIO);
        agregarPanel(panelUsuarioCrear, PANEL_USUARIO_CREAR);
        agregarPanel(panelUsuarioEdit, PANEL_USUARIO_EDITAR);
        agregarPanel(panelCategoria, PANEL_CATEGORIA);
        agregarPanel(panelProducto, PANEL_PRODUCTO);
        agregarPanel(panelVenta, PANEL_VENTA);
        agregarPanel(panelventaCreate, PANEL_VENTA_CREAR);
    }

    private void configurarListeners() {
        btnDashboard.addActionListener(e -> {
            vista.show(PanelPadre, PANEL_DASHBOARD);
        });

        btnUsuario.addActionListener(e -> {
            vista.show(PanelPadre, PANEL_USUARIO);
            panelUsuario.resetPanel(); // Restablece el panel Usuario
        });

        btnProducto.addActionListener(e -> {
            vista.show(PanelPadre, PANEL_PRODUCTO);
            panelProducto.resetPanel(); // Restablece el panel Producto
        });
    
        btnVenta.addActionListener(e -> {
            vista.show(PanelPadre, PANEL_VENTA);
        });
        
        btnCategoria.addActionListener(e -> {
            vista.show(PanelPadre, PANEL_CATEGORIA); // Muestra el panel de categoría al hacer clic en btnCategoria
            //panelCategoria.resetPanel();
    });
        
    }
    
    @Override
    public void abrirPanel(String nombrePanel) {
        vista.show(PanelPadre, nombrePanel);
    }
    
    @Override
    public void abrirPanel(String panelName, Long id) {
        if (PANEL_USUARIO_EDITAR.equals(panelName)) {
            if (panelUsuarioEdit == null) {
                panelUsuarioEdit = new PanelUsuarioEdit(this);
            }
            panelUsuarioEdit.BuscarUsuarioPorId(id);
            PanelPadre.add(panelUsuarioEdit, PANEL_USUARIO_EDITAR);
            vista.show(PanelPadre, PANEL_USUARIO_EDITAR);
        }
        if (PANEL_USUARIO_SHOW.equals(panelName)) {
            if (panelUsuarioShow == null) {
                panelUsuarioShow = new PanelUsuarioShow(this);
            }
            panelUsuarioShow.mostrarUsuarioPorId(id);
            PanelPadre.add(panelUsuarioShow, PANEL_USUARIO_SHOW);
            vista.show(PanelPadre, PANEL_USUARIO_SHOW);
        }
    }   
    
    public PanelUsuario getPanelUsuario() {
        return this.panelUsuario; // Asegúrate de que panelUsuario es un atributo de la clase
    }
    //Evita que muestren botones a los que no se deberia tener acceso por el rol
    public void configurarAccesoSegunRol(Set<String> permisosUsuario) {
        btnUsuario.setVisible(permisosUsuario.contains("ver_usuario"));
        btnProducto.setVisible(permisosUsuario.contains("ver_producto"));
    }
   
    private void agregarPanel(JPanel panel, String nombre) {
        PanelPadre.add(panel, nombre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelControles = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        PanelPadre = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelControles.setBackground(new java.awt.Color(255, 174, 120));

        btnDashboard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 153, 51));
        btnDashboard.setText("Dashboard");
        btnDashboard.setToolTipText("");
        btnDashboard.setBorder(null);
        btnDashboard.setBorderPainted(false);
        btnDashboard.setFocusPainted(false);

        btnUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(255, 153, 51));
        btnUsuario.setText("Usuarios");
        btnUsuario.setToolTipText("");
        btnUsuario.setBorder(null);
        btnUsuario.setBorderPainted(false);
        btnUsuario.setFocusPainted(false);

        btnProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnProducto.setForeground(new java.awt.Color(255, 153, 0));
        btnProducto.setText("Productos");
        btnProducto.setToolTipText("");
        btnProducto.setBorder(null);
        btnProducto.setBorderPainted(false);
        btnProducto.setFocusPainted(false);

        btnProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(255, 153, 0));
        btnProveedor.setText("Proveedores");
        btnProveedor.setToolTipText("");
        btnProveedor.setBorder(null);
        btnProveedor.setBorderPainted(false);
        btnProveedor.setFocusPainted(false);

        btnVenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVenta.setForeground(new java.awt.Color(255, 153, 0));
        btnVenta.setText("Ventas");
        btnVenta.setToolTipText("");
        btnVenta.setBorder(null);
        btnVenta.setBorderPainted(false);
        btnVenta.setFocusPainted(false);

        btnCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCategoria.setForeground(new java.awt.Color(255, 153, 0));
        btnCategoria.setText("Categorias");
        btnCategoria.setToolTipText("");
        btnCategoria.setBorder(null);
        btnCategoria.setBorderPainted(false);
        btnCategoria.setFocusPainted(false);

        btnCerrarSesion.setBackground(new java.awt.Color(255, 102, 102));
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setToolTipText("");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setDefaultCapable(false);
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelControlesLayout = new javax.swing.GroupLayout(PanelControles);
        PanelControles.setLayout(PanelControlesLayout);
        PanelControlesLayout.setHorizontalGroup(
            PanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addGroup(PanelControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelControlesLayout.setVerticalGroup(
            PanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelControlesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(PanelControles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, 490));

        PanelPadre.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelPadreLayout = new javax.swing.GroupLayout(PanelPadre);
        PanelPadre.setLayout(PanelPadreLayout);
        PanelPadreLayout.setHorizontalGroup(
            PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        PanelPadreLayout.setVerticalGroup(
            PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        getContentPane().add(PanelPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 900, 490));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DON PEPE");

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(204, 204, 204));
        lblUsuario.setText("Usuario Iniciado Sesión");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 729, Short.MAX_VALUE)
                .addComponent(lblUsuario)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUsuario))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 80));

        setSize(new java.awt.Dimension(1105, 570));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres cerrar sesión?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            FrmLogin login = new FrmLogin();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelControles;
    public javax.swing.JPanel PanelPadre;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
