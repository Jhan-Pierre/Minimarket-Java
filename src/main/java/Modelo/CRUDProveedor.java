package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import minimarket01.Proveedor;

public class CRUDProveedor extends Conexion {
    
    
    public List<Proveedor> listarProveedores() {
        List<Proveedor> listaProveedores = new ArrayList<>();
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return listaProveedores;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_listar_proveedores()}")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String ruc = rs.getString("ruc");
                String descripcion = rs.getString("descripcion");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String direccion = rs.getString("direccion");
                int idEstado = rs.getInt("id_estado");

                Proveedor proveedor = new Proveedor(id, nombre, ruc, descripcion, telefono, correo, direccion, idEstado);
                listaProveedores.add(proveedor);
            }
        } catch (SQLException e) {
            Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al listar proveedores", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        return listaProveedores;
    }
    
    
    public String agregarProveedor(Proveedor proveedor) {
        Connection cnx = getConexion();
        if (cnx == null) {
            return "No se pudo establecer conexión con la base de datos.";
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_agregar_proveedor(?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getRuc());
            stmt.setString(3, proveedor.getDescripcion());
            stmt.setString(4, proveedor.getTelefono());
            stmt.setString(5, proveedor.getCorreo());
            stmt.setString(6, proveedor.getDireccion());
            stmt.setInt(7, proveedor.getIdEstado());

            stmt.execute();
            return "Proveedor agregado correctamente.";
        } catch (SQLException e) {
            Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al agregar proveedor", e);
            return "Error: " + e.getMessage();
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
    }

    public String actualizarProveedor(Proveedor proveedor) {
        Connection cnx = getConexion();
        if (cnx == null) {
            return "No se pudo establecer conexión con la base de datos.";
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_actualizar_proveedor(?, ?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setLong(1, proveedor.getId());
            stmt.setString(2, proveedor.getNombre());
            stmt.setString(3, proveedor.getRuc());
            stmt.setString(4, proveedor.getDescripcion());
            stmt.setString(5, proveedor.getTelefono());
            stmt.setString(6, proveedor.getCorreo());
            stmt.setString(7, proveedor.getDireccion());
            stmt.setInt(8, proveedor.getIdEstado());

            stmt.execute();
            return "Proveedor actualizado correctamente.";
        } catch (SQLException e) {
            Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al actualizar proveedor", e);
            return "Error: " + e.getMessage();
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
    }

    public String eliminarProveedor(Long idProveedor) {
        Connection cnx = getConexion();
        if (cnx == null) {
            return "No se pudo establecer conexión con la base de datos.";
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_eliminar_proveedor(?)}")) {
            stmt.setLong(1, idProveedor);

            stmt.execute();
            return "Proveedor eliminado correctamente.";
        } catch (SQLException e) {
            Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al eliminar proveedor", e);
            return "Error: " + e.getMessage();
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
    }

    
}
