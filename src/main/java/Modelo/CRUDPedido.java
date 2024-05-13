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

public class CRUDPedido extends Conexion{
    public List<Pedido> buscarPedidoPorUsuario(String nombre){
        
        List<Pedido> listaPedido = new ArrayList<>();
        
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDusuario.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return listaPedido;
        }
        
        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_buscar_pedido_por_nombre_usuario(?)}")) {
            stmt.setString(1, nombre);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Date fecha = rs.getDate("fecha");
                Double total = rs.getDouble("costoTotal");
                String usuario = rs.getString("usuario");
                String proveedor = rs.getString("proveedor");
                
                Pedido pedido = new Pedido(id, fecha, total, usuario, proveedor);
                listaPedido.add(pedido);
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
        
        return listaPedido;
    }
}
