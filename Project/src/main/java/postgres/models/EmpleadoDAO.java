/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgres.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import postgres.Conexion;
import postgres.Querys;
import users.Empleado;

/**
 * Esta clase me permite poder realizar todas las procesos de consultas o inserciones en la DB para un empleado
 * @author luis
 */
public class EmpleadoDAO {
    
    /**
     * Este método me permite poder garantizar la existencia de un empleado en la DB
     * @param empleado
     * @return
     */
    public Empleado existenciaEmpleado(Empleado empleado){
        int findUser = 0;
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement( Querys.queryUsuarios ) ){
            
            //Mandamos los parametros parala Query a realizar
            preSt.setString(1, empleado.getUsername());
            preSt.setString(2, empleado.getContrasenia());
            
            ResultSet result = preSt.executeQuery();
            
            while(result.next()){
                //El usuario fue encontrado y devolvemos los parametros
                empleado.setId_sucursal( result.getInt( "id_sucursal" ) );
                empleado.setRol( result.getInt( "rol" ) );
                
                findUser++;
            }
            //Usuario encontrado
            if( findUser != 0) {
                return empleado;
            }
            
            return null;
        } catch (Exception exc) {
            System.err.println( "Error al ejecutar la consulta: " + exc.getMessage() );
            return null;
        }
    }
}
