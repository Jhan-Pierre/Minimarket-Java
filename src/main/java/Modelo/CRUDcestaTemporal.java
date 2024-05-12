package Modelo;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUDcestaTemporal extends Conexion{
    public List<CestaTemporal> consultarCestaTemporalPorIdUsuario(Long id){
        List<CestaTemporal> listaCestaTemporal = new ArrayList<>();
        
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return listaCestaTemporal;
        }
        
        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_consultar_cesta_temporal_usuario(?)}")) {
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String producto = rs.getString("producto");
                BigDecimal precio_venta = rs.getBigDecimal("precio_unitario");
                int cantidad = rs.getInt("cantidad");
                BigDecimal subtotal = rs.getBigDecimal("subtotal");
                
                CestaTemporal cestaTemporal = new CestaTemporal(cantidad, subtotal, producto, precio_venta);
                listaCestaTemporal.add(cestaTemporal);
            }
        } catch (SQLException e) {
            Logger.getLogger(CRUDcestaTemporal.class.getName()).log(Level.SEVERE, "Error al buscar datos de la scesta temporal", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDcestaTemporal.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }   
        return listaCestaTemporal;
    }
    
    public void registrarCestaTemporal(Long id, String codigoBarras){
        
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
        }
        
        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_registrar_cesta_temporal(?, ?)}")) {
            stmt.setLong(1, id);
            stmt.setString(2, codigoBarras);
            stmt.execute();
        } catch (SQLException e) {
            Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "Error al agregar categoría", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        
    }
    
}
