package Modelo;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CRUDusuario extends Conexion {

    public String validarUsuario(String email, String password) {
        Connection cnx = getConexion();
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
    
    public Set<String> obtenerPermisosPorUsuario(int rol_id) {
        Set<String> permisos = new HashSet<>();
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return permisos;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_obtener_permisos_por_rol(?)}")) {
            stmt.setInt(1, rol_id);

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
        Connection cnx = getConexion();
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
                int rol_id = rs.getInt("rol_id");
                usuario = new Usuario(id, nombre, correo, rol_id);
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
    
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return listaUsuarios;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_listar_usuario()}")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String correo = rs.getString("correo");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                Date fechaAlta = rs.getDate("fecha_alta");
                String rolNombre = rs.getString("rol"); // Asegúrate de cambiar este nombre si es necesario para evitar conflictos con la columna 'nombre' de 'tb_usuario'
                String estado = rs.getString("estado");
                
                Usuario usuario = new Usuario(id, correo, nombre, telefono, fechaAlta, rolNombre, estado);
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al listar usuarios", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        return listaUsuarios;
    }
     
    public void crearUsuario(String correo, String password, String telefono, String nombre, String apellido, int rol_id, int estado_id, int turno_id) {
        // Hashear la contraseña
        String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());

        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_crear_usuario(?, ?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setString(1, correo);
            stmt.setString(2, hashedPassword); // Usar la contraseña hasheada
            stmt.setString(3, telefono);
            stmt.setString(4, nombre);
            stmt.setString(5, apellido);
            stmt.setInt(6, rol_id);
            stmt.setInt(7, estado_id);
            stmt.setInt(8, turno_id);

            stmt.execute();
        } catch (SQLException e) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al crear usuario", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
    }
    
    public List<Usuario> buscarUsuarioPorNombre(String nombre) {
        List<Usuario> listaUsuarios = new ArrayList<>();
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return listaUsuarios;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_buscar_usuario_por_nombre(?)}")) {
            stmt.setString(1, nombre);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String correo = rs.getString("correo");
                String nombreCompleto = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                Date fechaAlta = rs.getDate("fecha_alta");
                String rolNombre = rs.getString("rol");
                String estado = rs.getString("estado");

                Usuario usuario = new Usuario(id, correo, nombreCompleto, telefono, fechaAlta, rolNombre, estado);
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al buscar usuarios por nombre", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        return listaUsuarios;
    }
    
    public void editarUsuario(Long id, String correo, String password, String telefono, String nombre, String apellido, int rol_id, int estado_id, int turno_id) {
        // Hashear la contraseña si se proporciona una nueva contraseña
        String hashedPassword = null;
        if (password != null && !password.isEmpty()) {
            hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        }

        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_editar_usuario(?, ?, ?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setLong(1, id);
            stmt.setString(2, correo);
            if (hashedPassword != null) {
                stmt.setString(3, hashedPassword); // Usar la contraseña hasheada si se proporciona una nueva contraseña
            } else {
                stmt.setNull(3, Types.VARCHAR); // Mantener la contraseña existente si no se proporciona una nueva contraseña
            }
            stmt.setString(4, telefono);
            stmt.setString(5, nombre);
            stmt.setString(6, apellido);
            stmt.setInt(7, rol_id);
            stmt.setInt(8, estado_id);
            stmt.setInt(9, turno_id);

            stmt.execute();
        } catch (SQLException e) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al editar usuario", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
    }
    
    public Usuario buscarUsuarioPorCodigo(long idUsuario) {
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return null;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_buscar_usuario_por_codigo(?)}")) {
            stmt.setLong(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String correo = rs.getString("correo");
                String telefono = rs.getString("telefono");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int rol_id = rs.getInt("rol_id");
                int turno_id = rs.getInt("turno_id");
                int estado_id = rs.getInt("estado_id");

                Usuario usuario = new Usuario(nombre, apellido, correo, telefono, rol_id, estado_id, turno_id);
                return usuario;
            }
        } catch (SQLException e) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al buscar usuario por código", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        return null;
    }
    
}