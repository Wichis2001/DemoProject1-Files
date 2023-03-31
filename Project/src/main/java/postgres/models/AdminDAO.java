/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgres.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import postgres.Conexion;
import postgres.Insert;
import postgres.Querys;
import users.Cliente;
import users.Empleado;

/**
 *
 * @author luis
 */
public class AdminDAO {
    
    public Boolean buscarCliente( String nombreEmpleado ){
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryBuscarEmpleado)){
            
            preSt.setString(1, nombreEmpleado );
            
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                return true;
            }
            
        } catch( Exception e ){
            System.err.println("Error al buscar al usuario ingresado " + e.getMessage() );
        }
        return false;
    }
    
    public Boolean addEmpleado( Empleado empleado ){
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Insert.insertEmpleado)){
            preSt.setString(1, empleado.getUsername());
            preSt.setString(2, empleado.getContrasenia());
            preSt.setInt(3, empleado.getRol());
            preSt.setInt(4, empleado.getId_sucursal());
            preSt.executeUpdate();
            
        return true; 
        } catch( Exception e ){
            System.err.println("Ocurrio un error al insertar el Empleado " + e.getMessage() );
            
            return false;
        }
    }
}
