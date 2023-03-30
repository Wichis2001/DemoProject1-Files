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
 * @author luiss
 */
public class ReportesDAO {
    
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
    
    public ArrayList topClientesMasGanancias( ){
        ArrayList<reporte.Reporte>listadoReportes=new ArrayList<>();
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryTopClientesGanancias)){
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                reporte.Reporte reporte = new reporte.Reporte();
                reporte.setTitulo( result.getString("cliente"));
                reporte.setValorNumerico(result.getFloat("total_ventas"));
                listadoReportes.add( reporte);
            }
            
        } catch( Exception e ){
            System.err.println("Error al visualizar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoReportes;
    }
    
    public ArrayList sucursalesMasVentas( ){
        ArrayList<reporte.Reporte>listadoReportes=new ArrayList<>();
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryTopSucursalesVentas)){
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                reporte.Reporte reporte = new reporte.Reporte();
                switch (result.getInt("total_ventas")) {
                    case 1:
                        reporte.setTitulo("Sucursal Central");
                        break;
                    case 2:
                        reporte.setTitulo("Sucursal Norte");
                        break;
                    case 3:
                        reporte.setTitulo("Sucursal Sur");
                        break;
                    default:
                        throw new AssertionError();
                }
                
                reporte.setValorNumerico2(result.getInt("total_ventas"));
                listadoReportes.add( reporte);
            }
            
        } catch( Exception e ){
            System.err.println("Error al visualizar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoReportes;
    }
    
    public ArrayList sucursalesMasIngresos( ){
        ArrayList<reporte.Reporte>listadoReportes=new ArrayList<>();
        try( PreparedStatement preSt = Conexion.dbConnection.prepareStatement(Querys.queryTopSucursalesIngresos)){
            ResultSet result = preSt.executeQuery();
            while( result.next() ){
                reporte.Reporte reporte = new reporte.Reporte();
                switch (result.getInt("sucursal")) {
                    case 1:
                        reporte.setTitulo("Sucursal Central");
                        break;
                    case 2:
                        reporte.setTitulo("Sucursal Norte");
                        break;
                    case 3:
                        reporte.setTitulo("Sucursal Sur");
                        break;
                    default:
                        throw new AssertionError();
                }
                
                reporte.setValorNumerico(result.getFloat("total_ventas"));
                listadoReportes.add( reporte);
            }
            
        } catch( Exception e ){
            System.err.println("Error al visualizar el listado de electrodmesticos: " + e.getMessage() );
        }
        return listadoReportes;
    }
    
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
}
