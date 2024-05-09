package Controlador;

import Modelo.CRUDusuario;
import vista.FrmLogin;
import vista.FrmDashboard;

public class UsuarioController {
    private FrmLogin vista;
    private CRUDusuario modelo;
    private FrmDashboard dashboard;

    public UsuarioController(FrmLogin vista) {
        this.vista = vista;
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
        vista.lblErrorLogin.setText(resultado);

        if (resultado.equals("Exito")) {
            FrmDashboard dashboard = new FrmDashboard();
            dashboard.setVisible(true);
            vista.dispose(); // Cerrar el FrmLogin
        }   
    }
}