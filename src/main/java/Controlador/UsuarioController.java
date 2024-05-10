package Controlador;

import Modelo.CRUDusuario;
import Modelo.Estado;
import Modelo.Rol;
import Modelo.SesionUsuario;
import Modelo.Turno;
import Modelo.Usuario;
import Utilidades.ButtonColumn;
import Utilidades.IButtonClickListener;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import vista.FrmLogin;
import vista.FrmDashboard;
import vista.PanelUsuario;
import vista.PanelUsuarioCrear;

public class UsuarioController implements IButtonClickListener{
    private FrmLogin vista;
    private CRUDusuario modelo;
    private FrmDashboard dashboard;
    private PanelUsuario vistaUsuario;
    private PanelUsuarioCrear vistaUsuarioCrear;
    
    public UsuarioController(FrmLogin vista) {
        this.vista = vista;
        this.modelo = new CRUDusuario();
    }
    
    public UsuarioController(PanelUsuarioCrear vista) {
        this.modelo = new CRUDusuario();
        this.vistaUsuarioCrear = vista;
    }
    
    public UsuarioController(PanelUsuario vista) {
        this.vistaUsuario = vista;
        this.modelo = new CRUDusuario();
    }
    
    public void setDashboard(FrmDashboard dashboard) {
        this.dashboard = dashboard;
    }
    
    public void abrirDashboard() {
        if (dashboard != null) {
            dashboard.setVisible(true);
        }
    }

    public void iniciar() {
        this.vista.btnIngresar.addActionListener(e -> validarLogin());
    }

    private void validarLogin() {
        String email = vista.txtEmail.getText();
        String password = new String(vista.txtPassword.getPassword());

        String resultado = modelo.validarUsuario(email, password);
        
        if (resultado.equals("Exito")) {
            // recuperar la inforamcion basica del usuario loeado
            Usuario usuarioLogeado = modelo.obtenerUsuarioLogeado(email);
            SesionUsuario.getInstancia().setUsuarioLogeado(usuarioLogeado);
            
            // enviar al dashboard, los permisos que tiene el rol del usuario logueado
            Set<String> permisosUsuario = modelo.obtenerPermisosPorUsuario(usuarioLogeado.getRolId());
             FrmDashboard dashboard2 = new FrmDashboard(permisosUsuario);
              
            dashboard2.lblUsuario.setText(usuarioLogeado.getNombre());
            
            dashboard2.setVisible(true);
            vista.dispose(); // Cerrar el FrmLogin
        }else{
            vista.lblErrorLogin.setText(resultado);
        }
    }
    
    public void cargarUsuariosEnTabla() {
        List<Usuario> listaUsuarios = modelo.listarUsuarios();

        // Crear modelo de tabla y establecerlo en la tabla
        DefaultTableModel model = new DefaultTableModel();
        vistaUsuario.tbUsuario.setModel(model);

        // Añadir columnas al modelo de la tabla
        model.addColumn("ID");
        model.addColumn("Correo");
        model.addColumn("Nombre");
        model.addColumn("Telefono");
        model.addColumn("Fecha Alta");
        model.addColumn("Rol");
        model.addColumn("Estado");

        // Añadir columnas de botones
        model.addColumn("Ver detalles");
        model.addColumn("Editar");
        model.addColumn("Eliminar");
        
        // Añadir filas al modelo de la tabla
        for (Usuario usuario : listaUsuarios) {
            model.addRow(new Object[] {
                usuario.getId(), 
                usuario.getEmail(), 
                usuario.getNombre(), 
                usuario.getTelefono(), 
                usuario.getFechaAlta(), 
                usuario.getRol(), 
                usuario.getEstado(), 
                "Ver detalles", "Editar", "Eliminar"});
        }

        // Crear los botones en las columnas correspondientes
        new ButtonColumn(vistaUsuario.tbUsuario, 7, this); // Ver detalles
        new ButtonColumn(vistaUsuario.tbUsuario, 8, this); // Editar
        new ButtonColumn(vistaUsuario.tbUsuario, 9, this); // Eliminar
    }

     @Override
    public void buttonClicked(int row, int column, String buttonText) {
        Long id = (Long) vistaUsuario.tbUsuario.getModel().getValueAt(row, 0);
        switch (buttonText) {
            case "Ver detalles" -> abrirDetallesUsuario(id);
            case "Editar" -> abrirEditarUsuario(id);
            case "Eliminar" -> eliminarUsuario(id);
        }
    }

    public void crearUsuario() {
        String correo = vistaUsuarioCrear.txtCorreo.getText();
        String password = vistaUsuarioCrear.txtContraseña.getText();
        String telefono = vistaUsuarioCrear.txtTelefono.getText();
        String nombre = vistaUsuarioCrear.txtNombre.getText();
        String apellido = vistaUsuarioCrear.txtApellido.getText();
       
        Rol rolSelecionado = (Rol) vistaUsuarioCrear.cboRol.getSelectedItem();
        int rolId = rolSelecionado.getId(); // Obtener el ID del rol seleccionado
        
        Estado estadoSeleccionado  = (Estado) vistaUsuarioCrear.cboEstado.getSelectedItem(); // Obtener el ID del estado seleccionado
        int estadoId = estadoSeleccionado.getId();

        Turno turnoSeleccionado = (Turno) vistaUsuarioCrear.cboTurno.getSelectedItem();
        int turnoId = turnoSeleccionado.getId(); // Obtener el ID del turno seleccionado

        // Llamar al método del modelo para crear el usuario
        //System.out.println(correo + password + telefono + nombre + apellido + rolId + estadoId + turnoId);
        modelo.crearUsuario(correo, password, telefono, nombre, apellido, rolId, estadoId, turnoId);
       // Actualizar la tabla de usuarios

    }
    
    private void abrirDetallesUsuario(Long id) {
        System.out.println("detalle: " + id);
    }

    private void abrirEditarUsuario(Long id) {
        System.out.println("editar: " + id);
    }

    private void eliminarUsuario(Long id) {
        System.out.println("eliminar: " + id);
    }

}