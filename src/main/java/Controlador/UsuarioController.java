package Controlador;

import Modelo.Conexion;
import Modelo.Usuario;
import vista.login; // Importa la vista para poder actualizarla
import vista.dashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioController {

    private login vistaLogin; // Referencia a la vista

    public UsuarioController(login vista) {
        this.vistaLogin = vista;
    }

    public void validarUsuario(String email, String password) {
        Usuario usuario = new Usuario(email, password);
        Conexion conexion = new Conexion();
        Connection cnx = conexion.getConexion();
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        
        try (PreparedStatement statement = cnx.prepareStatement(sql)) {
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getPassword());
            
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                vistaLogin.setVisible(false); // Oculta la vista de login
                new dashboard().setVisible(true); // Muestra el dashboard
            } else {
                vistaLogin.lblErrorLogin.setText("Email o contraseña incorrectos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar excepción
        }
    }
}
