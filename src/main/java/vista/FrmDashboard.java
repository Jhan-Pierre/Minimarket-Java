package vista;

import vista.Usuario.PanelUsuarioShow;
import vista.Usuario.PanelUsuarioEdit;
import vista.Usuario.PanelUsuario;
import vista.Producto.PanelProducto;
import vista.Usuario.PanelUsuarioCrear;
import static Constantes.ConstantesPaneles.*;
import Controlador.GlobalPermisos;

import vista.Proveedor.PanelProveedorShow;
import vista.Proveedor.PanelProveedorEdit;
import vista.Proveedor.PanelProveedor;
import vista.Proveedor.PanelProveedorCrear;

import vista.Categoria.PanelCategoria;
import vista.Categoria.PanelCategoriaEdit;
import vista.Categoria.PanelCategoriaCrear;
import vista.Categoria.PanelCategoriaShow;


import javax.swing.JOptionPane;
import java.awt.CardLayout;
import java.util.Set;
import javax.swing.JPanel;
import Utilidades.IPanelListener;
import javax.swing.JTable;
import vista.Venta.PanelVenta;
import vista.Venta.PanelVentaCreate;
import vista.Pedido.PanelPedido;
import vista.Producto.PanelProductoCrear;


public final class FrmDashboard extends javax.swing.JFrame implements IPanelListener {
    // Declaración de tus paneles
    PanelDashboard panelDashboard;
    PanelUsuario panelUsuario;
    PanelUsuarioCrear panelUsuarioCrear;
    PanelUsuarioEdit panelUsuarioEdit;
    PanelUsuarioShow panelUsuarioShow;
    
    PanelProveedor panelProveedor;
    PanelProveedorCrear panelProveedorCrear;
    PanelProveedorEdit panelProveedorEdit;
    PanelProveedorShow panelProveedorShow;
    
    PanelCategoria panelCategoria;
    PanelCategoriaShow panelCategoriaShow;
    PanelCategoriaEdit panelCategoriaEdit;
    PanelCategoriaCrear panelCategoriaCrear;
    
    PanelProducto panelProducto;
    PanelProductoCrear panelProductoCrear; 
    
    
    PanelVenta panelVenta;
    PanelVentaCreate panelventaCreate;
    

    PanelPedido panelPedido;

    private int mouseX;
    private int mouseY;

     private JTable tablaCategorias = new JTable();
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
        
        panelProveedor = new PanelProveedor(this);
        panelProveedorCrear = new PanelProveedorCrear(this);
        panelProveedorEdit = new PanelProveedorEdit(this);
        panelProveedorShow = new PanelProveedorShow(this);
        
        panelCategoria = new PanelCategoria(this);
        panelCategoriaCrear = new PanelCategoriaCrear(this);
        panelCategoriaEdit = new PanelCategoriaEdit(this);
        panelCategoriaShow = new PanelCategoriaShow(this);
        
        panelProducto = new PanelProducto(this);
        panelProductoCrear = new PanelProductoCrear(this);
        
        panelVenta = new PanelVenta(this);
        panelventaCreate = new PanelVentaCreate(this);
        panelPedido = new PanelPedido(this);
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
        agregarPanel(panelProducto, PANEL_PRODUCTO);
        agregarPanel(panelProductoCrear, PANEL_PRODUCTO_CREAR);
        agregarPanel(panelVenta, PANEL_VENTA);
        agregarPanel(panelventaCreate, PANEL_VENTA_CREAR);
        agregarPanel(panelPedido, PANEL_PEDIDO);
        
        agregarPanel(panelCategoria, PANEL_CATEGORIA);
        agregarPanel(panelCategoriaCrear, PANEL_CATEGORIA_CREAR);
        agregarPanel(panelCategoriaShow, PANEL_CATEGORIA_SHOW);
        agregarPanel(panelCategoriaEdit, PANEL_CATEGORIA_EDITAR);
        
        agregarPanel(panelProveedor, PANEL_PROVEEDOR);
        agregarPanel(panelProveedorCrear, PANEL_PROVEEDOR_CREAR);
        agregarPanel(panelProveedorEdit, PANEL_PROVEEDOR_EDITAR);
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
            //panelProducto.resetPanel(); // Restablece el panel Producto
        });
    
        btnVenta.addActionListener(e -> {
            vista.show(PanelPadre, PANEL_VENTA);
        });
        
        btnCategoria.addActionListener(e -> {
            vista.show(PanelPadre, PANEL_CATEGORIA); // Muestra el panel de categoría al hacer clic en btnCategoria
            //panelCategoria.resetPanel();
        });
        
        btnPedido.addActionListener(e -> {
            vista.show(PanelPadre, PANEL_PEDIDO); // Muestra el panel de categoría al hacer clic en btnCategoria
            //panelCategoria.resetPanel();
        });
        
        btnProveedor.addActionListener(e -> {
            vista.show(PanelPadre, PANEL_PROVEEDOR); // Muestra el panel de categoría al hacer clic en btnCategoria
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
        if (PANEL_PROVEEDOR_EDITAR.equals(panelName)) {
            if (panelProveedorEdit == null) {
                panelProveedorEdit = new PanelProveedorEdit(this);
            }
            panelProveedorEdit.BuscarProveedorPorId(id);
            PanelPadre.add(panelProveedorEdit, PANEL_PROVEEDOR_EDITAR);
            vista.show(PanelPadre, PANEL_PROVEEDOR_EDITAR);
        }
        if (PANEL_PROVEEDOR_SHOW.equals(panelName)) {
            if (panelProveedorShow == null) {
                panelProveedorShow = new PanelProveedorShow(this);
            }
            panelProveedorShow.mostrarProveedorPorId(id);
            PanelPadre.add(panelProveedorShow, PANEL_PROVEEDOR_SHOW);
            vista.show(PanelPadre, PANEL_PROVEEDOR_SHOW);
        }
    }   
    
    public PanelUsuario getPanelUsuario() {
        return this.panelUsuario; // Asegúrate de que panelUsuario es un atributo de la clase
    }
    //Evita que muestren botones a los que no se deberia tener acceso por el rol
    public void configurarAccesoSegunRol(Set<String> permisosUsuario) {
        btnUsuario.setVisible(permisosUsuario.contains("ver_usuario"));
        btnProducto.setVisible(permisosUsuario.contains("ver_producto"));
        btnVenta.setVisible(permisosUsuario.contains("ver_venta"));
        btnCategoria.setVisible(permisosUsuario.contains("ver_categoria_producto"));
        btnPedido.setVisible(permisosUsuario.contains("ver_pedido"));
        btnProveedor.setVisible(permisosUsuario.contains("ver_proveedor"));
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
        btnPedido = new javax.swing.JButton();
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
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

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

        btnPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPedido.setForeground(new java.awt.Color(255, 153, 0));
        btnPedido.setText("Pedido");
        btnPedido.setToolTipText("");
        btnPedido.setBorder(null);
        btnPedido.setBorderPainted(false);
        btnPedido.setFocusPainted(false);

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
                    .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
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
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("    DON PEPE");
        jLabel1.setToolTipText("");
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(204, 204, 204));
        lblUsuario.setText("Usuario Iniciado Sesión");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addComponent(lblUsuario))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 80));

        setSize(new java.awt.Dimension(1110, 570));
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

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - mouseX, y - mouseY);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - mouseX, y - mouseY);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProveedorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelControles;
    public javax.swing.JPanel PanelPadre;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnPedido;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
