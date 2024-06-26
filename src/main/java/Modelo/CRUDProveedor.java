package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CRUDProveedor extends Conexion {
    
    public void crearProveedor(String nombre, String ruc, String descripcion, String telefono, String correo, String direccion, int idEstado) {
        Connection cnx = getConexion();
        if (cnx == null) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.");
            return;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_registrar_proveedor(?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setString(1, nombre);
            stmt.setString(2, ruc);
            stmt.setString(3, descripcion);
            stmt.setString(4, telefono);
            stmt.setString(5, correo);
            stmt.setString(6, direccion);
            stmt.setInt(7, idEstado);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Proveedor creado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear proveedor: " + e.getMessage());
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
    }
    
    public void editarProveedor(Long id, String nombre, String ruc, String descripcion, String telefono, String correo, String direccion, int idEstado) {
        Connection cnx = getConexion();
        if (cnx == null) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.");
            return;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_editar_proveedor(?, ?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setLong(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, ruc);
            stmt.setString(4, descripcion);
            stmt.setString(5, telefono);
            stmt.setString(6, correo);
            stmt.setString(7, direccion);
            stmt.setInt(8, idEstado);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Proveedor editado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar proveedor: " + e.getMessage());
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
    }
    
    public String eliminarProveedor(Long id) {
        String mensaje = "";
        Connection cnx = getConexion();
        if (cnx == null) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.");
            return mensaje;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_eliminar_proveedor(?)}")) {
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                mensaje = rs.getString("mensaje");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar proveedor: " + e.getMessage());
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        return mensaje;
    }
    
    
    //especiales
    
    public Proveedor mostrarProveedorPorCodigo(Long id) {
    /*//Proveedor proveedor = null;
    Connection cnx = getConexion();
    if (cnx == null) {
        Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
        return null;
    }

    try (CallableStatement stmt = cnx.prepareCall("{CALL sp_mostrar_proveedor_por_codigo(?)}")) {
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String nombre = rs.getString("nombre");
            String ruc = rs.getString("ruc");
            String telefono = rs.getString("telefono");
            String correo = rs.getString("correo");
            String direccion = rs.getString("direccion");
            String descripcion = rs.getString("descripcion");
            String estado = rs.getString("estado");

            Proveedor proveedor = new Proveedor(nombre, ruc, telefono, correo, direccion, descripcion, estado);
            return proveedor;
        }
    } catch (SQLException e) {
        Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al buscar proveedor por código", e);
    } finally {
        try {
            cnx.close();
        } catch (SQLException e) {
            Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
        }
    }
    */return null;
}


    
    //
    public List<Proveedor> buscarProveedorPorNombre(String nombre) {
        List<Proveedor> listaProveedores = new ArrayList<>();
        Connection cnx = getConexion();
        if (cnx == null) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.");
            return listaProveedores;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_buscar_proveedor_por_nombre(?)}")) {
            stmt.setString(1, nombre);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombreProveedor = rs.getString("nombre");
                String ruc = rs.getString("ruc");               
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                
                String estado = rs.getString("estado");

                Proveedor proveedor = new Proveedor(id, nombreProveedor, ruc, telefono, correo, estado);
                listaProveedores.add(proveedor);
            }
        } catch (SQLException e) {
           Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al buscar proveedor por nombre", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        return listaProveedores;
    }
    
    
    
    public Proveedor buscarProveedorPorCodigo(int idProveedor) {
    Connection cnx = getConexion();
    if (cnx == null) {
        Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
        return null;
    }

    try (CallableStatement stmt = cnx.prepareCall("{CALL sp_buscar_proveedor_por_codigo(?)}")) {
        stmt.setLong(1, idProveedor);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String ruc = rs.getString("ruc");
            String telefono = rs.getString("telefono");
            String correo = rs.getString("correo");
            String direccion = rs.getString("direccion"); // Agregar dirección
            String descripcion = rs.getString("descripcion"); // Agregar descripción
            int estado_id = rs.getInt("estado_id");

            Proveedor proveedor = new Proveedor(id, nombre, ruc, telefono, correo, direccion, descripcion, estado_id);
            return proveedor;
        }
    } catch (SQLException e) {
        Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al buscar proveedor por código", e);
    } finally {
        try {
            cnx.close();
        } catch (SQLException e) {
            Logger.getLogger(CRUDProveedor.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
        }
    }
    return null;
    }
    
}
