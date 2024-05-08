
package Modelo;
import at.favre.lib.crypto.bcrypt.BCrypt;
import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CRUDusuario {
    private final Conexion conexion = new Conexion();

    public String validarUsuario(String email, String password) {
    Connection cnx = conexion.getConexion();
    if (cnx == null) {
        return "No se pudo establecer conexión con la base de datos.";
    }
    
    try (CallableStatement stmt = cnx.prepareCall("{CALL sp_login(?, ?, ?, ?)}")) {
        stmt.setString(1, email);
        stmt.registerOutParameter(2, Types.VARCHAR);
        stmt.registerOutParameter(3, Types.BIGINT);
        stmt.registerOutParameter(4, Types.BOOLEAN);
        
        stmt.execute();
        
        String hashedPassword = stmt.getString(2);
        Long userId = stmt.getLong(3);
        Boolean isActive = stmt.getBoolean(4);
        
        // Cláusula de guarda: Verificar si se obtuvo un userId válido
        if (userId == null) {
            return "Usuario no encontrado.";
        }
        
        // Cláusula de guarda: Verificar si se obtuvo un hashedPassword válido
        if (hashedPassword == null) {
            return "No se pudo obtener la contraseña del usuario.";
        }
        
        if (!isActive) {
            return "El usuario no está activo.";
        }
        
        // Verificar si la contraseña coincide
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hashedPassword);
        if (result.verified) {
            return "Exito";
        } else {
            return "Contraseña incorrecta.";
        }
    }  catch (SQLException e) {
        Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al validar usuario", e);
        return "Error: " + e.getMessage();
    } finally {
        try {
            cnx.close();
        } catch (SQLException e) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
        }
    }
}
}