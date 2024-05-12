package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CRUDmetodoPago extends Conexion {
    public List<MetodoPago> listarTipoComprobante(){
        List<MetodoPago> listaMetodoPago = new ArrayList<>();
        Connection cnx = getConexion();
        
        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_listar_metodo_pago()}")){
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("metodo_pago");
                
                MetodoPago metodoPago = new MetodoPago(id, nombre);

                listaMetodoPago.add(metodoPago);
            }
            
        }catch(SQLException e){
            Logger.getLogger(CRUDmetodoPago.class.getName()).log(Level.SEVERE, "Error al listar metodo pago: ", e);
        }
        
        cnx = null;
        
        return listaMetodoPago; 
    }
}
