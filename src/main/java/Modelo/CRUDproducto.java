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
import javax.swing.JOptionPane;

public class CRUDproducto extends Conexion {
     
    public void crearProducto(String nombre, Float precio_compra, Float precio_venta, int stock_disponible, String codigoBarras, int categoria_producto_id, int estado_id) {
        
        Connection cnx = getConexion();
        if (cnx == null) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.");
            return;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_registrar_producto(?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setString(1, nombre);
            stmt.setFloat(2, precio_compra);
            stmt.setFloat(3, precio_venta);
            stmt.setInt(4, stock_disponible);
            stmt.setString(5, codigoBarras);
            stmt.setInt(6, categoria_producto_id);
            stmt.setInt(7, estado_id);

            stmt.execute();
        } catch (SQLException e) {
            Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "Error al crear producto", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
    }
    
    public List<Producto> buscarProductoPorCodigo(String codigobar) {
        List<Producto> listaProductos = new ArrayList<>();
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return listaProductos;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_buscar_producto_por_codigo(?)}")) {
            stmt.setString(1, codigobar);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre_producto");
                Float precio_venta = rs.getFloat("precio_venta");
                int stock_disponible = rs.getInt("stock_disponible");
                String codigoBarras = rs.getString("codigoBarras");
                String estado = rs.getString("estado");
                String categoria = rs.getString("categoria");

                Producto producto = new Producto(nombre,precio_venta, stock_disponible, codigoBarras, categoria, estado);
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "Error al buscar productos por Codigo", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        return listaProductos;
    }
    
    public void editarProducto(Long id, String nombre, Float precio_compra, Float precio_venta, int stock_disponible, String codigoBarras, int categoria_producto_id, int estado_id) {
    
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_editar_producto(?, ?, ?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setLong(1, id);
            stmt.setString(2, nombre);
            stmt.setFloat(3, precio_compra);
            stmt.setFloat(4, precio_venta);
            stmt.setInt(5, stock_disponible);
            stmt.setString(6, codigoBarras);
            stmt.setInt(7, categoria_producto_id);
            stmt.setInt(8, estado_id);

            stmt.execute();
        } catch (SQLException e) {
            Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "Error al editar producto", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
    }
    
    public Producto mostrarProductoPorCodigo(Long id){
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return null;
        }
        
        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_mostrar_producto_por_codigo(?)}")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                Float precio_compra = rs.getFloat("precio_compra");
                Float precio_venta = rs.getFloat("precio_venta");
                int stock_disponible = rs.getInt("stock_disponible");
                String codigoBarras = rs.getString("codigoBarras");
                String categoria = rs.getString("categoria");
                String estado = rs.getString("estado");

                Producto producto = new Producto(nombre, precio_compra, precio_venta, stock_disponible, codigoBarras, categoria, estado);
                return producto;
            }
        } catch (SQLException e) {
            Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "Error al buscar producto por código", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        return null;
    }
    
    public String eliminarProducto(Long id) {
        String mensaje = "";
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return mensaje;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_eliminar_producto(?)}")) {
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                mensaje = rs.getString("mensaje");
            }
        } catch (SQLException e) {
            Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "Error al eliminar producto", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDproducto.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        return mensaje;
    }
}