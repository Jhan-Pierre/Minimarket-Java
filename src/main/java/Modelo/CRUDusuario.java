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
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

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
    
    public Set<String> obtenerPermisosPorUsuario(String email) {
        Set<String> permisos = new HashSet<>();
        Connection cnx = conexion.getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return permisos;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_obtener_permisos_por_usuario(?)}")) {
            stmt.setString(1, email);

            boolean hasResults = stmt.execute();
            if (hasResults) {
                try (ResultSet rs = stmt.getResultSet()) {
                    while (rs.next()) {
                        permisos.add(rs.getString("permiso"));
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al obtener permisos por usuario", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        return permisos;
    }
    
    public Usuario obtenerUsuarioLogeado(String email) {
        Usuario usuario = null;
        Connection cnx = conexion.getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return null;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_obtener_usuario_logeado(?)}")) {
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String rol = rs.getString("rol");
                usuario = new Usuario(id, nombre, correo, rol);
            }
        } catch (SQLException e) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al obtener usuario logeado", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        return usuario;
    }
}