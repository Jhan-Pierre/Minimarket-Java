package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private final String controlador = "com.mysql.cj.jdbc.Driver";
    private final String bd = "bd_minimarket";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + bd;
    
    public Connection getConexion(){
        Connection cnx = null;
        try {
            Class.forName(this.controlador);
            cnx = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Driver no encontrado", ex);
        } catch(SQLException e){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al conectar con la base de datos", e);
        }
        return cnx;
    }
}
