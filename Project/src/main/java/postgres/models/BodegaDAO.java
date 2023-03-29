/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgres.models;

import electrodomesticos.Electrodomestico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import postgres.Conexion;
import postgres.Delete;
import postgres.Insert;
import postgres.Querys;
import postgres.Update;

/**
 *
 * @author luis
 */
public class BodegaDAO {
    
    public ArrayList listadoElectrodomesticos( ){
        ArrayList<Electrodomestico>listadoElectrodomesticos=new ArrayList<>();
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryElectrodomesticos)){
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                Electrodomestico electrodemestico = new Electrodomestico();
                electrodemestico.setIdElectrodomestico(result.getInt("id"));
                electrodemestico.setNombre(result.getString("nombre"));
                electrodemestico.setPrecio(result.getFloat("precio"));
                electrodemestico.setExistencia(result.getInt("existencia"));
                listadoElectrodomesticos.add(electrodemestico);
            }
            
        } catch( Exception e ){
            System.err.println("Error al visualizar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoElectrodomesticos;
    }
    
    public int ultimoProductoAgregado( ){
        int ultimoProductoAgregado = 0;
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryUltimoProducto)){
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                ultimoProductoAgregado = result.getInt("maximo");
            }
            
        } catch( Exception e ){
            System.err.println("Error al buscar el ultimo producto agregado " + e.getMessage() );
        }
        return ultimoProductoAgregado;
    }
    
    public boolean addProducto( Electrodomestico electrodomestico ){
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Insert.insertElectrodomestico)){
            preSt.setString(1, electrodomestico.getNombre());
            preSt.setFloat(2, electrodomestico.getPrecio());
            
            preSt.executeUpdate();
            
        return true; 
        } catch( Exception e ){
            System.err.println("Ocurrio un error al insertar el Producto " + e.getMessage() );
            
            return false;
        }
    }
    
    public boolean addInventario ( Electrodomestico electrodomestico, int identificadorProducto){
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Insert.insertInventario)){
            preSt.setInt(1, electrodomestico.getExistencia());
            preSt.setInt(2, identificadorProducto);
            
            preSt.executeUpdate();
            
        return true; 
        } catch( Exception e ){
            System.err.println("Ocurrio un error al insertar el valor en el inventario " + e.getMessage() );
            
            return false;
        }
    }
    
    public boolean updateElectrodomestico( Electrodomestico electrodomestico ){
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Update.updateElectrodomestico) ){
            preSt.setString(1, electrodomestico.getNombre());
            preSt.setFloat(2, electrodomestico.getPrecio());
            preSt.setInt(3, electrodomestico.getIdElectrodomestico());
            
            preSt.executeUpdate();
            return true;
        } catch( Exception e ){
            System.err.println( "Error al ralizar un update al electrodomestico ");
            return false;
        }
    }
    
    public boolean updateInventario( Electrodomestico electrodomestico, int sucursal ){
        int idInventario = 0;
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryBusquedaIDInventario)){
            
            preSt.setInt(1, electrodomestico.getIdElectrodomestico());
            preSt.setInt(2, sucursal); 
            ResultSet result = preSt.executeQuery();
            
            while( result.next() ){
                idInventario = result.getInt("id");
            }
            
        } catch( Exception e ){
            System.err.println("Error al buscar el ultimo el identificador del inventario " + e.getMessage() );
        }
            
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Update.updateInventario) ){
            preSt.setInt(1, electrodomestico.getExistencia());
            preSt.setInt(2, idInventario);
            preSt.executeUpdate();
            return true;
        } catch( Exception e ){
            System.err.println( "Error al ralizar un update al inventario ");
            return false;
        }
    }
    
    public boolean deleteInventario(Electrodomestico electrodomestico, int sucursal ){
        int idInventario = 0;
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryBusquedaIDInventario)){
            
            preSt.setInt(1, electrodomestico.getIdElectrodomestico());
            preSt.setInt(2, sucursal); 
             
            ResultSet result = preSt.executeQuery();
            
            while( result.next() ){
                idInventario = result.getInt("id");
            }
            
        } catch( Exception e ){
            System.err.println("Error al buscar el ultimo el identificador del inventario " + e.getMessage() );
        }
            
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Update.deleteInventario) ){
            preSt.setInt(1, idInventario);
            preSt.executeUpdate();
            return true;
        } catch( Exception e ){
            System.err.println( "Error al eliminar el producto del inventario ");
            return false;
        }
    }
}
