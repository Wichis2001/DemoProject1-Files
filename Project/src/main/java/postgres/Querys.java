/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgres;

/**
 *
 * @author luis
 */
public class Querys {
    
    public static final String queryUsuarios="SELECT * FROM ControlUsuarios.Empleado WHERE username = ? AND contrasenia = crypt( ? , contrasenia);";
    public static final String queryElectrodomesticos = "SELECT e.id_electrodomestico AS id, e.nombre AS nombre, e.precio AS precio, i.existencia AS existencia FROM ControlSucursal.Electrodomestico AS e INNER JOIN ControlSucursal.Inventario AS i ON e.id_electrodomestico = i.id_electrodomestico WHERE i.id_sucursal = 4 AND i.estado = 1 ORDER BY e.id_electrodomestico ASC;";
    public static final String queryUltimoProducto = "SELECT MAX(id_electrodomestico) AS maximo FROM ControlSucursal.Electrodomestico;";
    public static final String queryBusquedaIDInventario = "SELECT id_inventario AS id FROM ControlSucursal.Inventario WHERE id_electrodomestico = ?;";
    public static final String queryBuscarCliente = "SELECT * FROM ControlUsuarios.Cliente WHERE nit = ?;";
    public static final String queryCargarProductoVenta = "SELECT e.id_electrodomestico AS id, e.nombre AS nombre, e.precio AS precio, i.existencia AS existencia, i.id_inventario AS inventario FROM ControlSucursal.Inventario AS i INNER JOIN ControlSucursal.Electrodomestico AS e ON i.id_electrodomestico = e.id_electrodomestico WHERE i.id_sucursal = ? AND i.estado = 1 AND i.existencia > 0 ORDER BY e.id_electrodomestico ASC;";
}
