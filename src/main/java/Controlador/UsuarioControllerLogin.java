package Controlador;

import Modelo.SesionUsuario;
import Modelo.Usuario;
import java.util.Set;
import vista.FrmDashboard;
import vista.FrmLogin;
import Modelo.UsuarioModelo;

public class UsuarioControllerLogin {
    private final FrmLogin vistaLogin;
    private final UsuarioModelo usuarioModelo;
    
    public UsuarioControllerLogin(FrmLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
        this.usuarioModelo = new UsuarioModelo();
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
            
            Set<String> permisosUsuario = usuarioModelo.obtenerPermisosPorUsuario(usuarioLogeado.getRolId());

            // Crear instancia del FrmDashboard y pasar los permisos
            FrmDashboard frmDashboard = new FrmDashboard(permisosUsuario);
            frmDashboard.lblUsuario.setText(usuarioLogeado.getNombre());
            frmDashboard.setVisible(true);
        } else {
            vistaLogin.lblErrorLogin.setText(resultado);
        }
    }
}
