/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgres;

/**
 * Esta clase me permite poder establecer las inserciones que serán adjuntadas a la DB
 * @author luis
 */
public class Insert {

    /**
     * Insert de electrodomesticos a la DB
     */
    public static final String insertElectrodomestico = "INSERT INTO ControlSucursal.Electrodomestico ( nombre, precio ) VALUES ( ?, ? );";

    /**
     * Insert de inventarios a la DB
     */
    public static final String insertInventario = "INSERT INTO ControlSucursal.Inventario ( existencia, id_sucursal, id_electrodomestico, estado ) VALUES (  ?, 4, ?, 1);";

    /**
     * Insert de clientes a la DB
     */
    public static final String insertCliente = "INSERT INTO ControlUsuarios.Cliente ( nit, nombre, direccion ) VALUES ( ?, ?, ? );";

    /**
     * Insert de ventas a la DB
     */
    public static final String insertVenta = "INSERT INTO ControlVentas.Venta ( total, nit, username ) VALUES ( ?, ?, ? );";

    /**
     * Insert de detalles de ventas a la DB
     */
    public static final String insertDetalleVenta = "INSERT INTO ControlVentas.DetalleVenta ( precio, cantidad, id_venta, id_inventario ) VALUES ( ?, ?, ?, ?)";

    /**
     * Insert de empleados a la DB
     */
    public static final String insertEmpleado = "INSERT INTO ControlUsuarios.Empleado VALUES (?, crypt(?, gen_salt('bf')), ?, ?);";

    /**
     * Insert de inventarios a la DB
     */
    public static final String insertInventarioSucursal = "INSERT INTO ControlSucursal.Inventario ( existencia, id_sucursal, id_electrodomestico, estado ) VALUES (  ?, ?, ?, 1);";
}
