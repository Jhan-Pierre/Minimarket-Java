package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUDtipoComprobante extends Conexion{
    public List<TipoComprobante> listarTipoComprobante(){
        List<TipoComprobante> listaTipoComprobante = new ArrayList<>();
        Connection cnx = getConexion();
        
        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_listar_tipo_comprobante()}")){
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("comprobante");
                
                TipoComprobante tipoComprobante = new TipoComprobante(id, nombre);

                listaTipoComprobante.add(tipoComprobante);
            }
            
        }catch(SQLException e){
            Logger.getLogger(CRUDtipoComprobante.class.getName()).log(Level.SEVERE, "Error al listar comprobante", e);
        }
        
        cnx = null;
        
        return listaTipoComprobante; 
    }
}
