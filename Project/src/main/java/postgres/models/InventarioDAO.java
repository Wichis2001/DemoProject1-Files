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
 *
 * @author luis
 */
public class InventarioDAO {
    
    public ArrayList listadoElectrodomesticos( int local ){
        ArrayList<Electrodomestico>listadoElectrodomesticos=new ArrayList<>();
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryElectrodomesticosInventario)){
            
            preSt.setInt(1, local);
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
            System.err.println("Error al visualizar el listado de electrodmesticos en Inventario: " + e.getMessage() );
        }
        return listadoElectrodomesticos;
    } 
    
    public ArrayList listadoElectrodomesticosSeleccionProducto( int local ){
        ArrayList<Electrodomestico>listadoElectrodomesticos=new ArrayList<>();
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryElectrodomesticoSolicitados)){
            
            preSt.setInt(1, local);
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
            System.err.println("Error al visualizar el listado de electrodmesticos en Inventario: " + e.getMessage() );
        }
        return listadoElectrodomesticos;
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
    
    public boolean existeProducto(Electrodomestico electrodomestico, int sucursal ){
        int existe = 0;
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryBusquedaIDInventario)){
            
            preSt.setInt(1, electrodomestico.getIdElectrodomestico());
            preSt.setInt(2, sucursal);
             
            ResultSet result = preSt.executeQuery();
            
            while( result.next() ){
                existe++;
            }
            if(existe!=0){
                return true;
            }
            
        } catch( Exception e ){
            System.err.println("Error al buscar el ultimo el identificador del inventario " + e.getMessage() );
        }
        return false;
    }
    
    public boolean actualizacionExistenciaOrigen( Electrodomestico electrodomestico, int sucursalOrigen, int cantidadSolicitada){
        int idInventario = 0;
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryBusquedaIDInventario)){
            
            preSt.setInt(1, electrodomestico.getIdElectrodomestico());
            preSt.setInt(2, sucursalOrigen);
            ResultSet result = preSt.executeQuery();
            
            while( result.next() ){
                idInventario = result.getInt("id");
            }
            
        } catch( Exception e ){
            System.err.println("Error al buscar el ultimo el identificador del inventario origen " + e.getMessage() );
        }
        
        int existenciaActualizada = electrodomestico.getExistencia() - cantidadSolicitada;
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Update.updateStock) ){
            preSt.setInt(1, existenciaActualizada);
            preSt.setInt(2, idInventario);
            
            preSt.executeUpdate();
            return true;
        } catch( Exception e ){
            System.err.println( "Error al actualizar el pedido de origen");
            return false;
        }
    }
    
    public boolean actualizacionExistenciaDestino( Electrodomestico electrodomestico, int sucursalDestino, int cantidadSolicitada ){
        int idInventario = 0;
        int existencia = 0;
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryBusquedaIDInventarioOrigen)){
            
            preSt.setInt(1, electrodomestico.getIdElectrodomestico());
            preSt.setInt(2, sucursalDestino);
             
            ResultSet result = preSt.executeQuery();
            
            while( result.next() ){
                idInventario = result.getInt("id");
                existencia = result.getInt("existencia");
            }
            
        } catch( Exception e ){
            System.err.println("Error al buscar el ultimo el identificador del inventario destino" + e.getMessage() );
        }
        
        int existenciaActualizada = existencia + cantidadSolicitada;
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Update.updateStockEstado) ){
            preSt.setInt(1, existenciaActualizada);
            preSt.setInt(2, idInventario);
            
            preSt.executeUpdate();
            return true;
        } catch( Exception e ){
            System.err.println( "Error al actualizar el pedido de origen");
            return false;
        }
    }
    
    
    public boolean asignacionNuevoProducto( Electrodomestico electrodomestico, int pedido, int sucursalPedido ){
        
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Insert.insertInventarioSucursal)){
            preSt.setInt(1, pedido);
            preSt.setInt(2, sucursalPedido);
            preSt.setInt(3, electrodomestico.getIdElectrodomestico() );
            
            preSt.executeUpdate();
            
        return true; 
        } catch( Exception e ){
            System.err.println("Ocurrio un error al insertar el valor en el inventario " + e.getMessage() );
            
            return false;
        }
    }
}
