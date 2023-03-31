/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgres;

/**
 * Esta clase me permite poder crear las Querys de update necesarias para la DB
 * @author luis
 */
public class Update {

    /**
     * Query para el update del electrodomestico
     */
    public static String updateElectrodomestico = "UPDATE ControlSucursal.Electrodomestico SET nombre = ?, precio = ? WHERE id_electrodomestico = ?;";

    /**
     * Query correspondiente al update del inventario
     */
    public static String updateInventario = "UPDATE ControlSucursal.Inventario SET existencia = ? WHERE id_inventario = ?;";
    
    /**
     * Query correspondiente al delete del inventario
     */
    public static String deleteInventario = "UPDATE ControlSucursal.Inventario SET estado = 2 WHERE id_inventario = ?;";
    
    /**
     * Query correspondiente al update del cliente
     */
    public static String updateCliente = "UPDATE ControlUsuarios.Cliente SET nombre = ?, direccion = ? WHERE nit = ?;";
    
    /**
     * Query correspondiente al update del Stock
     */
    public static String updateStock = "UPDATE ControlSucursal.Inventario SET existencia = ? WHERE id_inventario = ?;";
    
    /**
     * Query correspondiente al update del Stock del estado
     */
    public static String updateStockEstado = "UPDATE ControlSucursal.Inventario SET existencia = ?, estado = 1 WHERE id_inventario = ?;";
}
