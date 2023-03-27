/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgres;

/**
 *
 * @author luis
 */
public class Insert {
    public static final String insertElectrodomestico = "INSERT INTO ControlSucursal.Electrodomestico ( nombre, precio ) VALUES ( ?, ? );";
    public static final String insertInventario = "INSERT INTO ControlSucursal.Inventario ( existencia, id_sucursal, id_electrodomestico, estado ) VALUES (  ?, 4, ?, 1);";
    public static final String insertCliente = "INSERT INTO ControlUsuarios.Cliente ( nit, nombre, direccion ) VALUES ( ?, ?, ? );";
}
