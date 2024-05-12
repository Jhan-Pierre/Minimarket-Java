package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUDventa extends Conexion {
    
    public List<Venta> buscarVentaPorUsuario(String nombre){
        
         List<Venta> listaVenta = new ArrayList<>();
        
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return listaVenta;
        }
        
        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_buscar_venta_por_nombre_usuario(?)}")) {
            stmt.setString(1, nombre);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Date fecha_hora = rs.getDate("fecha_hora");
                Double impuesto = rs.getDouble("impuesto");
                Double total = rs.getDouble("total");
                String tipo_comprobante = rs.getString("comprobante");
                String metodo_pago = rs.getString("metodo_pago");
                String usuario = rs.getString("usuario");
                
                Venta venta = new Venta(id, fecha_hora, impuesto, total, tipo_comprobante, metodo_pago, usuario);
                listaVenta.add(venta);
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
        
        return listaVenta;
    }
    
    public void registrarVenta(Double impuesto, Double total, int comprobante_id, int metodo_pago_id, Long usuario_id){
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDventa.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
        }
        
        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_registrar_venta(?, ?, ?, ?, ?)}")) {
            stmt.setDouble(1, impuesto);
            stmt.setDouble(2, total);
            stmt.setInt(3, comprobante_id);
            stmt.setInt(4, metodo_pago_id);
            stmt.setLong(5, usuario_id);
            
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
    
}
