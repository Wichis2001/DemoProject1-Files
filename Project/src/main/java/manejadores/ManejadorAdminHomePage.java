/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadores;

import javax.swing.JButton;
import javax.swing.JComboBox;
import ui.admin.AdminHomePage;
import ui.admin.reporte.ClientesMasGanancias;
import ui.admin.reporte.EmpleadosMasIngresos;
import ui.admin.reporte.EmpleadosMasVentas;
import ui.admin.reporte.ProductosMasIngresos;
import ui.admin.reporte.ProductosMasIngresosSucursal;
import ui.admin.reporte.ProductosMasVendidos;
import ui.admin.reporte.ProductosMasVendidosSucursal;
import ui.admin.reporte.SucursalesMasIngresos;
import ui.admin.reporte.SucursalesMasVentas;
import users.Empleado;

/**
 * Está clase me permite poder manejar la ventana que incluye el AdminHomePage
 * @author luis
 */
public class ManejadorAdminHomePage {
    
    /**
     * Este metodo me permite poder dirigir que ventana de reporte se va generar al cambiar la opción del JComboBOx
     * @param admin
     * @param opcion
     * @param seleccionarReporte
     * @param empleado
     */
    public void dirigirReporte( AdminHomePage admin, JComboBox opcion, JButton seleccionarReporte, Empleado empleado ){
        //Vemos que tipo de reporte tenemos y mostramos la ventana
        switch( opcion.getSelectedItem().toString() ){
            case "Top 10 Productos más vendidos":
                ProductosMasVendidos reportePV = new ProductosMasVendidos(empleado, admin);
                reportePV.setVisible(true);
                break;
            case "Top 10 Clientes que generan más ganancias":
                ClientesMasGanancias reporteC = new ClientesMasGanancias(empleado, admin);
                reporteC.setVisible(true);
                break;
            case "Top 3 Sucursales con más ventas":
                SucursalesMasVentas reporteSV = new SucursalesMasVentas(empleado, admin);
                reporteSV.setVisible(true);
                break;
            case "Top 3 Sucursales con más ingresos":
                SucursalesMasIngresos reporteSI = new SucursalesMasIngresos(empleado, admin);
                reporteSI.setVisible(true);
                break;
            case "Top 3 Empleados con más ventas":
                EmpleadosMasVentas reporteEV = new EmpleadosMasVentas(empleado, admin);
                reporteEV.setVisible(true);
                break;
            case "Top 3 Empleados con más ingresos":
                EmpleadosMasIngresos reporteEI = new EmpleadosMasIngresos(empleado, admin);
                reporteEI.setVisible(true);
                break;
            case "Top 10 Productos con más ingresos":
                ProductosMasIngresos reportePI = new ProductosMasIngresos(empleado, admin);
                reportePI.setVisible(true);
                break;
            case "Top 5 Productos más vendidos por sucursal":
                ProductosMasVendidosSucursal reportePMVS = new ProductosMasVendidosSucursal(empleado, admin);
                reportePMVS.setVisible(true);
                break;
            case "Top 5 Productos con más ingresos por sucursal":
                ProductosMasIngresosSucursal reportePMIS = new ProductosMasIngresosSucursal(empleado, admin);
                reportePMIS.setVisible(true);
                break;
        }
        //Deshabilitamos el botón de selección de reporte y la página de adminsitración
        seleccionarReporte.setEnabled(false);
        admin.setVisible(false);
    }
}
