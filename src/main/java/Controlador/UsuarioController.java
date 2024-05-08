package Controlador;

import Modelo.CRUDusuario;
import vista.FrmLogin;

public class UsuarioController {
    private FrmLogin vista;
    private CRUDusuario modelo;

    public UsuarioController(FrmLogin vista) {
        this.vista = vista;
        this.modelo = new CRUDusuario();
    }

    public void iniciar() {
        this.vista.btnIngresar.addActionListener(e -> validarLogin());
    }

    private void validarLogin() {
        String email = vista.txtEmail.getText();
        String password = new String(vista.txtPassword.getPassword());

        vista.lblErrorLogin.setText(modelo.validarUsuario(email, password));
    }
}