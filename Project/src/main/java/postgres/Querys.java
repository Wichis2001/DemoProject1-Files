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
    
    //Querys FUncionamiento del Programa
    public static final String queryUsuarios="SELECT * FROM ControlUsuarios.Empleado WHERE username = ? AND contrasenia = crypt( ? , contrasenia);";
    public static final String queryElectrodomesticos = "SELECT e.id_electrodomestico AS id, e.nombre AS nombre, e.precio AS precio, i.existencia AS existencia FROM ControlSucursal.Electrodomestico AS e INNER JOIN ControlSucursal.Inventario AS i ON e.id_electrodomestico = i.id_electrodomestico WHERE i.id_sucursal = 4 AND i.estado = 1 ORDER BY e.id_electrodomestico ASC;";
    public static final String queryUltimoProducto = "SELECT MAX(id_electrodomestico) AS maximo FROM ControlSucursal.Electrodomestico;";
    public static final String queryBusquedaIDInventario = "SELECT id_inventario AS id FROM ControlSucursal.Inventario WHERE id_electrodomestico = ? AND id_sucursal = ?;";
    public static final String queryBuscarCliente = "SELECT * FROM ControlUsuarios.Cliente WHERE nit = ?;";
    public static final String queryCargarProductoVenta = "SELECT e.id_electrodomestico AS id, e.nombre AS nombre, e.precio AS precio, i.existencia AS existencia, i.id_inventario AS inventario FROM ControlSucursal.Inventario AS i INNER JOIN ControlSucursal.Electrodomestico AS e ON i.id_electrodomestico = e.id_electrodomestico WHERE i.id_sucursal = ? AND i.estado = 1 AND i.existencia > 0 ORDER BY e.id_electrodomestico ASC;";
    public static final String queryDescuento = "SELECT total FROM ControlVentas.Venta WHERE nit = ? ORDER BY id_venta DESC LIMIT 1;";
    public static final String queryTotalVentas = "SELECT COUNT(*) FROM ControlVentas.Venta;";
    public static final String queryElectrodomesticosInventario = "SELECT e.id_electrodomestico AS id, e.nombre AS nombre, e.precio AS precio, i.existencia AS existencia FROM ControlSucursal.Electrodomestico AS e INNER JOIN ControlSucursal.Inventario AS i ON e.id_electrodomestico = i.id_electrodomestico WHERE i.id_sucursal = ? AND i.estado = 1 ORDER BY e.id_electrodomestico ASC;";
    public static final String queryIdElectrodoemestico = "SELECT * FROM ControlSucursal.Electrodomestico WHERE nombre = ? LIMIT 1;";
    public static final String queryBusquedaIDInventarioOrigen = "SELECT id_inventario AS id, existencia FROM ControlSucursal.Inventario WHERE id_electrodomestico = ? AND id_sucursal = ?;";
    public static final String queryElectrodomesticoSolicitados = "SELECT e.id_electrodomestico AS id, e.nombre AS nombre, e.precio AS precio, i.existencia AS existencia FROM ControlSucursal.Electrodomestico AS e INNER JOIN ControlSucursal.Inventario AS i ON e.id_electrodomestico = i.id_electrodomestico WHERE i.id_sucursal = ? AND i.estado = 1 AND i.existencia > 0 ORDER BY e.id_electrodomestico ASC;";

    //Querys Administrador
    public static final String queryTopProductosVendidos = "SELECT e.nombre as electrodomestico, SUM(dv.cantidad) as total_vendido FROM ControlVentas.DetalleVenta dv INNER JOIN ControlSucursal.Inventario i ON dv.id_inventario = i.id_inventario INNER JOIN ControlSucursal.Electrodomestico e ON i.id_electrodomestico = e.id_electrodomestico GROUP BY i.id_inventario, e.nombre ORDER BY total_vendido DESC LIMIT 10;";
    public static final String queryTopClientesGanancias = "SELECT c.nombre as cliente, SUM(v.total) as total_ventas FROM ControlUsuarios.Cliente c INNER JOIN ControlVentas.Venta v ON c.nit = v.nit GROUP BY c.nit, c.nombre ORDER BY total_ventas DESC LIMIT 10;";
    public static final String queryTopSucursalesIngresos = "SELECT s.nombre as sucursal, COUNT(v.total) as total_ventas FROM ControlSucursal.Sucursal s INNER JOIN ControlUsuarios.Empleado e ON s.id_sucursal = e.id_sucursal INNER JOIN ControlVentas.Venta v ON e.username = v.username GROUP BY s.id_sucursal, s.nombre ORDER BY total_ventas DESC LIMIT 3;";
    public static final String queryTopSucursalesVentas = "SELECT s.nombre as sucursal, SUM(v.total) as total_ventas FROM ControlSucursal.Sucursal s INNER JOIN ControlUsuarios.Empleado e ON s.id_sucursal = e.id_sucursal INNER JOIN ControlVentas.Venta v ON e.username = v.username GROUP BY s.id_sucursal, s.nombre ORDER BY total_ventas DESC LIMIT 3;";
    public static final String queryTopEmpleadoMasVentas = "SELECT e.username as empleado, COUNT(*) as total_ventas FROM ControlUsuarios.Empleado e INNER JOIN ControlVentas.Venta v ON e.username = v.username GROUP BY e.username ORDER BY total_ventas DESC LIMIT 3;";
    public static final String queryTopEmpleadoMasIngresos = "SELECT e.username as empleado, SUM(v.total) as total_ventas FROM ControlUsuarios.Empleado e INNER JOIN ControlVentas.Venta v ON e.username = v.username GROUP BY e.username ORDER BY total_ventas DESC LIMIT 3;";
    public static final String queryTopProductosMasVendidos = "SELECT e.nombre as electrodomestico, SUM(dv.cantidad) as total_vendido FROM ControlVentas.DetalleVenta dv INNER JOIN ControlSucursal.Inventario i ON dv.id_inventario = i.id_inventario INNER JOIN ControlSucursal.Electrodomestico e ON i.id_electrodomestico = e.id_electrodomestico GROUP BY i.id_inventario, e.nombre WHERE ORDER BY total_vendido DESC LIMIT 10;";
    public static final String queryTopProductosMasIngresos = "SELECT e.nombre as producto, SUM(dv.precio) as total_ingresos FROM ControlSucursal.Electrodomestico e INNER JOIN ControlSucursal.Inventario i ON e.id_electrodomestico = i.id_electrodomestico INNER JOIN ControlVentas.DetalleVenta dv ON i.id_inventario = dv.id_inventario GROUP BY e.id_electrodomestico, e.nombre ORDER BY total_ingresos DESC LIMIT 10;";
    
    
}
