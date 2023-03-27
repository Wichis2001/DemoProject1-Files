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
import postgres.Querys;

/**
 *
 * @author luis
 */
public class VentaDAO {
    
    
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
}
