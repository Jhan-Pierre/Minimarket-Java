package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUDrol extends Conexion{
    public List<Rol> listarRol(){
        List<Rol> listRol = new ArrayList<>();
        Connection cnx = getConexion();
        
        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_listar_rol_usuario()}")){
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                
                Rol rol = new Rol(id, nombre);

                listRol.add(rol);
            }
            
        }catch(SQLException e){
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "Error al listar turnos", e);
        }
        
        cnx = null;
        
        return listRol; 
    }
}
