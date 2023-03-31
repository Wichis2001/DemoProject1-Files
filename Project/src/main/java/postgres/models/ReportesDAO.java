/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgres.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import postgres.Conexion;
import postgres.Querys;

/**
 * Esta clase me permite poder realizar todas las procesos de consultas o inserciones en la DB para los reportes de la DB
 * @author luiss
 */
public class ReportesDAO {
    
    /**
     * Este método me devuelve el reporte de los productos más vendidos
     * @return
     */
    public ArrayList topProductosMasVendidos( ){
        ArrayList<reporte.Reporte>listadoReportes=new ArrayList<>();
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryTopProductosVendidos)){
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                reporte.Reporte reporte = new reporte.Reporte();
                reporte.setTitulo( result.getString("electrodomestico"));
                reporte.setValorNumerico2( result.getInt("total_vendido"));
                listadoReportes.add( reporte);
            }
            
        } catch( Exception e ){
            System.err.println("Error al visualizar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoReportes;
    }
    
    /**
     * Este método me devuelve el reporte de los clientes que generan más ganancias
     * @return
     */
    public ArrayList topClientesMasGanancias( ){
        ArrayList<reporte.Reporte>listadoReportes=new ArrayList<>();
        boolean cf = false;
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryTopClientesGanancias)){
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                if(listadoReportes.size() != 10 && result.getString("cliente")!= null){
                    reporte.Reporte reporte = new reporte.Reporte();
                    reporte.setTitulo( result.getString("cliente"));
                    reporte.setValorNumerico(result.getFloat("total_ventas"));
                    listadoReportes.add( reporte);
                }
                
            }
        } catch( Exception e ){
            System.err.println("Error al visualizar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoReportes;
    }
    
    /**
     * Este método me devuelve el reporte de las sucursales con más ventas
     * @return
     */
    public ArrayList sucursalesMasVentas( ){
        ArrayList<reporte.Reporte>listadoReportes=new ArrayList<>();
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryTopSucursalesVentas)){
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                reporte.Reporte reporte = new reporte.Reporte();
                reporte.setTitulo(result.getString("sucursal"));
                reporte.setValorNumerico2(result.getInt("total_ventas"));
                listadoReportes.add( reporte);
            }
            
        } catch( Exception e ){
            System.err.println("Error al visualizar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoReportes;
    }
    
    /**
     * Este método me devuelve el reporte de las sucursales poseen más ingresos
     * @return
     */
    public ArrayList sucursalesMasIngresos( ){
        ArrayList<reporte.Reporte>listadoReportes=new ArrayList<>();
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryTopSucursalesIngresos)){
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                reporte.Reporte reporte = new reporte.Reporte();
                reporte.setTitulo(result.getString("sucursal"));
                reporte.setValorNumerico(result.getFloat("total_ventas"));
                listadoReportes.add( reporte);
            }
            
        } catch( Exception e ){
            System.err.println("Error al visualizar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoReportes;
    }
    
    /**
     * Este método me devuelve el reporte de los empleados que poseen más ventas
     * @return
     */
    public ArrayList empleadosMasVentas( ){
        ArrayList<reporte.Reporte>listadoReportes=new ArrayList<>();
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryTopEmpleadoMasVentas)){
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                reporte.Reporte reporte = new reporte.Reporte();
                reporte.setTitulo(result.getString("empleado"));
                reporte.setValorNumerico2(result.getInt("total_ventas"));
                listadoReportes.add( reporte);
            }
            
        } catch( Exception e ){
            System.err.println("Error al visualizar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoReportes;
    }
    
    /**
     * Este método me devuelve el reporte de los empleados con más ingresos 
     * @return
     */
    public ArrayList empleadosMasIngresos( ){
        ArrayList<reporte.Reporte>listadoReportes=new ArrayList<>();
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryTopEmpleadoMasIngresos)){
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                reporte.Reporte reporte = new reporte.Reporte();
                reporte.setTitulo(result.getString("empleado"));
                
                reporte.setValorNumerico(result.getFloat("total_ventas"));
                listadoReportes.add( reporte);
            }
            
        } catch( Exception e ){
            System.err.println("Error al visualizar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoReportes;
    }
    
    /**
     * Este método me devuelve el reporte de los productos con más ingresos
     * @return
     */
    public ArrayList productosMasIngresos( ){
        ArrayList<reporte.Reporte>listadoReportes=new ArrayList<>();
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryTopProductosMasIngresos)){
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                reporte.Reporte reporte = new reporte.Reporte();
                reporte.setTitulo(result.getString("producto"));
                reporte.setValorNumerico(result.getFloat("total_ingresos"));
                listadoReportes.add( reporte);
            }
            
        } catch( Exception e ){
            System.err.println("Error al visualizar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoReportes;
    }
    
    /**
     * Este método me devuelve el reporte de los productos más vendidos por sucursal
     * @param seleccion
     * @return
     */
    public ArrayList prodcutosMasVendidosSucursal(JComboBox seleccion ){
        ArrayList<reporte.Reporte>listadoReportes=new ArrayList<>();
        int sucursal;
        switch ( seleccion.getSelectedItem().toString() ) {
            case "Sucursal Central":
                sucursal = 1;
                break;
            case "Sucursal Norte":
                sucursal = 2;
                break;
            case "Sucursal Sur":
                sucursal = 3;
                break;
            default:
                sucursal = 0;
        }
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryTopProductosMasVendidosSucursal)){
            preSt.setInt(1, sucursal);
            
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                reporte.Reporte reporte = new reporte.Reporte();
                reporte.setTitulo(result.getString("producto"));
                reporte.setValorNumerico2(result.getInt("total_vendido"));
                listadoReportes.add( reporte);
            }
            
        } catch( Exception e ){
            System.err.println("Error al visualizar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoReportes;
    }
    
    /**
     * Este método me devuelve el reporte de los productos con más ingresos por sucursal
     * @param seleccion
     * @return
     */
    public ArrayList productosMasIngresosSucursal(JComboBox seleccion ){
        ArrayList<reporte.Reporte>listadoReportes=new ArrayList<>();
        int sucursal;
        switch ( seleccion.getSelectedItem().toString() ) {
            case "Sucursal Central":
                sucursal = 1;
                break;
            case "Sucursal Norte":
                sucursal = 2;
                break;
            case "Sucursal Sur":
                sucursal = 3;
                break;
            default:
                sucursal = 0;
        }
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryTopProductosMasIngresosSucursal)){
           
            preSt.setInt(1, sucursal);
            
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                
                reporte.Reporte reporte = new reporte.Reporte();
                reporte.setTitulo(result.getString("producto"));
                reporte.setValorNumerico(result.getFloat("total_vendido"));
                
                listadoReportes.add( reporte);
            }
            
        } catch( Exception e ){
            System.err.println("Error al visualizar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoReportes;
    }
}
