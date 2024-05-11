package Controlador.Usuario;

import Controlador.GlobalPermisos;
import Modelo.SesionUsuario;
import Modelo.Usuario;
import java.util.Set;
import vista.FrmDashboard;
import vista.FrmLogin;
import Modelo.CRUDusuario;

public class UsuarioControllerLogin {
    private final FrmLogin vistaLogin;
    private final CRUDusuario usuarioModelo;
    private Set<String> permisosUsuario;

    public UsuarioControllerLogin(FrmLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
        this.usuarioModelo = new CRUDusuario();
        inicializar();
    }
    
    private void inicializar() {
        vistaLogin.btnIngresar.addActionListener(e -> validarLogin());
    }
 
    private void validarLogin() {
        String email = vistaLogin.txtEmail.getText();
        String password = new String(vistaLogin.txtPassword.getPassword());
        
        String resultado = usuarioModelo.validarUsuario(email, password);

        if (resultado.equals("Exito")) {
            Usuario usuarioLogeado = usuarioModelo.obtenerUsuarioLogeado(email);
            SesionUsuario.getInstancia().setUsuarioLogeado(usuarioLogeado);

            permisosUsuario = usuarioModelo.obtenerPermisosPorUsuario(usuarioLogeado.getRolId());
            GlobalPermisos.setPermisos(permisosUsuario); //Guardar los permisos de manera global

            // Crear instancia del FrmDashboard y pasar los permisos
            FrmDashboard frmDashboard = new FrmDashboard();
            frmDashboard.lblUsuario.setText(usuarioLogeado.getNombre());
            frmDashboard.setVisible(true);
        } else {
            vistaLogin.lblErrorLogin.setText(resultado);
        }
    }
    
    public Set<String> obtenerPermisosUsuario() {
        return permisosUsuario;
    }
}
