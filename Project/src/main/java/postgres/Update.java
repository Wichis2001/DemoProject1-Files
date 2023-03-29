/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgres;

/**
 *
 * @author luis
 */
public class Update {
    public static String updateElectrodomestico = "UPDATE ControlSucursal.Electrodomestico SET nombre = ?, precio = ? WHERE id_electrodomestico = ?;";

    public static String updateInventario = "UPDATE ControlSucursal.Inventario SET existencia = ? WHERE id_inventario = ?;";
    
    public static String deleteInventario = "UPDATE ControlSucursal.Inventario SET estado = 2 WHERE id_inventario = ?;";
    
    public static String updateCliente = "UPDATE ControlUsuarios.Cliente SET nombre = ?, direccion = ? WHERE nit = ?;";
    
    public static String updateStock = "UPDATE ControlSucursal.Inventario SET existencia = ? WHERE id_inventario = ?;";
    
    public static String updateStockEstado = "UPDATE ControlSucursal.Inventario SET existencia = ?, estado = 1 WHERE id_inventario = ?;";
}
