/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgres.models;

import electrodomesticos.Electrodomestico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import postgres.Conexion;
import postgres.Insert;
import postgres.Querys;
import postgres.Update;

/**
 * Esta clase me permite poder realizar todas las procesos de consultas o inserciones en la DB para la bodega
 * @author luis
 */
public class BodegaDAO {
    
    /**
     * Este metodo me regresa un arraylist con el listado de todos los electrodomesticos disponibles
     * @return
     */
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
    
    /**
     * Este metodo me devueve un entero del ultimo producto agregado para poder realizar la insercion al inventario
     * @return
     */
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
    
    /**
     * Esté metodo me devuelve un booleando en base a la inserción de un electrodomestico
     * @param electrodomestico
     * @return
     */
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
    
    /**
     * Este metodo me devuelve un booleando en base a la inserción del inventario de una sucursal
     * @param electrodomestico
     * @param identificadorProducto
     * @return
     */
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
    
    /**
     * Este método me devuelve un booleano en base al éxito de la actualización de un electrodomestico
     * @param electrodomestico
     * @return
     */
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
    
    /**
     * Este método me permite poder actualizar el inventario en base al electrodomestico y la sucursal para el inventario
     * @param electrodomestico
     * @param sucursal
     * @return
     */
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
    
    /**
     * Esté metodo me permite poder elimitar una fila de la tabla del inventario
     * @param electrodomestico
     * @param sucursal
     * @return
     */
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
