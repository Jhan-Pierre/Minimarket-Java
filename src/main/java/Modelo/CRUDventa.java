package Modelo;

import java.math.BigDecimal;
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
                BigDecimal impuesto = rs.getBigDecimal("impuesto");
                BigDecimal total = rs.getBigDecimal("total");
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
    
}
