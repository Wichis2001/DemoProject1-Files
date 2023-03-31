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
import postgres.Update;
import users.Cliente;


/**
 * Esta clase me permite poder realizar todas las procesos de consultas o inserciones en la DB para los clientes
 * @author luis
 */
public class ClienteDAO {
    
    /**
     * Este metodo me permite poder buscar un cliente que pueda existir una DB
     * @param cliente
     * @return
     */
    public Cliente buscarCliente( Cliente cliente ){
        int existeCliente = 0;
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryBuscarCliente)){
            
            preSt.setString(1, cliente.getNit() );
            
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                cliente.setNit( result.getString("nit") );
                cliente.setNombre( result.getString("nombre"));
                cliente.setDireccion(result.getString("direccion"));
                existeCliente++;
            }
            if( existeCliente != 0 ){
                return cliente;
            }
        } catch( Exception e ){
            System.err.println("Error al buscar el cliente con el nit ingresado " + e.getMessage() );
        }
        return null;
    }
    
    /**
     * Este método me permite poder agregar un nuevo cliente a la DB
     * @param cliente
     * @return
     */
    public boolean addCliente( Cliente cliente ){
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Insert.insertCliente)){
            preSt.setString(1, cliente.getNit());
            preSt.setString(2, cliente.getNombre());
            preSt.setString(3, cliente.getDireccion());
            preSt.executeUpdate();
            
        return true; 
        } catch( Exception e ){
            System.err.println("Ocurrio un error al insertar el Cliente " + e.getMessage() );
            
            return false;
        }
    }
    
    /**
     * Este método me permite poder actualizar un nuevo cliente en la DB
     * @param cliente
     * @return
     */
    public boolean updateCliente( Cliente cliente ){
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Update.updateCliente) ){
            preSt.setString(3, cliente.getNit());
            preSt.setString(1, cliente.getNombre());
            preSt.setString(2, cliente.getDireccion());
            
            preSt.executeUpdate();
            return true;
        } catch( Exception e ){
            System.err.println( "Error al ralizar un update al cliente ");
            return false;
        }
    }
}
