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
import ventas.Factura;

/**
 * Esta clase me permite poder realizar todas las procesos de consultas o inserciones en la DB para la venta
 * @author luis
 */
public class VentaDAO {
    
    /**
     * Este método me devuelve el listado de productos de una sucursal para realizar la correspondiente venta
     * @param noSucursal
     * @return
     */
    public ArrayList listadoProductos( int noSucursal ){
        ArrayList<Electrodomestico>listadoElectrodomesticos=new ArrayList<>();
  
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryCargarProductoVenta)){
            
            preSt.setInt(1, noSucursal);
    
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                Electrodomestico electrodemestico = new Electrodomestico( result.getInt("id"), result.getString("nombre"), result.getFloat("precio"), result.getInt("existencia"), result.getInt("inventario"));
                
                listadoElectrodomesticos.add(electrodemestico);
            }
            
            
        } catch( Exception e ){
            System.err.println("Error al generar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoElectrodomesticos;
    }
    
    /**
     * Este método me permite poder determinar los descuentos para una venta
     * @param nit
     * @return
     */
    public int determinarDescuento( String nit ){
        int descuento = 0;
        float total = 0;
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryDescuento)){
            
            preSt.setString(1, nit);
    
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                total = result.getFloat("total");
            }
            
            if( total >= 1000 && total < 5000 ){
                descuento = 2;              
            } else if( total >= 5000 && total < 10000 ){
                descuento = 5;
            } else if( total >= 10000 ){
                descuento = 10;               
            }
                  
        } catch( Exception e ){
            System.err.println("Error al determinar el descuento del cliente " + e.getMessage() );
        }
        
        return descuento;
    }
    
    private int totalVentas(){
        int total = 0;
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryTotalVentas)){
    
            ResultSet result = preSt.executeQuery();
            
            while( result.next() ){
                total = result.getInt("count");
            }
                  
        } catch( Exception e ){
            System.err.println("Error al determinar el total de ventas " + e.getMessage() );
        }
        
        return total;
    }
    
    /**
     * Este método me permite poder agregar una venta en base al total, el nit y el username
     * @param total
     * @param nit
     * @param username
     * @return
     */
    public boolean addVenta( float total, String nit, String username ){
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Insert.insertVenta)){
            preSt.setFloat(1, (float)(Math.round(total*100.0)/100.0));
            preSt.setString(2, nit);
            preSt.setString(3, username);
            preSt.executeUpdate();
            
        return true; 
        } catch( Exception e ){
            System.err.println("Ocurrio un error al insertar la venta " + e.getMessage() );
            
            return false;
        }
    }
    
    /**
     * Este método me permite poder agregar un detalle de la venta
     * @param factura
     * @return
     */
    public boolean addDetalleVenta( Factura factura ){
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Insert.insertDetalleVenta)){
            preSt.setFloat(1, (float)(Math.round(factura.getSubTotal()*100.0)/100.0));
            preSt.setInt(2, factura.getCantidad());
            preSt.setInt(3, this.totalVentas());
            preSt.setInt(4, factura.getIdInventario());
            preSt.executeUpdate();
            
        return true; 
        } catch( Exception e ){
            System.err.println("Ocurrio un error al insertar la venta " + e.getMessage() );
            
            return false;
        }
    }
    
    /**
     * Este método me permite poder actualizar el stock en DB de un electrodomestico
     * @param factura
     * @return
     */
    public boolean actualizarStock( Factura factura ){
        System.out.println( factura.getStock() + " " + factura.getCantidad() );
        int existenciaActualizada = factura.getStock() - factura.getCantidad();
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Update.updateStock) ){
            preSt.setInt(1, existenciaActualizada);
            preSt.setInt(2, factura.getIdInventario());
            
            preSt.executeUpdate();
            return true;
        } catch( Exception e ){
            System.err.println( "Error al actualizar el pedido");
            return false;
        }
    }
}
