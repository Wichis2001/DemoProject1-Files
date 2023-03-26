/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgres;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Esta clase me permite poder entablar una conexión con la base de datos construida en postgres
 * @author luis
 */
public class Conexion {
    
    /**
     * Me permite establecer una conexion universal para todo mi sistema
     */
    public static Connection dbConnection;
    
    String url = "jdbc:postgresql://localhost:5432/electronichomes";
    String user = "postgres";
    String password = "Wichis6661";
    
    /**
     * Me permite establecer una conexión 
     * @return
     */
    public boolean inicializarConexion() {
        try{
            dbConnection = DriverManager.getConnection(url, user, password);
            return true;
        } catch( Exception e ) {
            System.err.println( "Error al conectar la base de datos " + e.getMessage() );
            return false;
        }
    }
}
