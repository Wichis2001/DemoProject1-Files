/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

/**
 * Esté metodo me permite poder crear una clase con los de detalles de la venta de una factura
 * @author luis
 */
public class DetalleVenta {
    private float precio;
    private int cantidad;
    private int idVenta;
    private int idInventario;

    /**
     * Este constructo me permite poder crear un objeto de detalles de una venta en base al precio, la cantidad, el identificador de la venta y el identificador del inventario
     * @param precio
     * @param cantidad
     * @param idVenta
     * @param idInventario
     */
    public DetalleVenta(float precio, int cantidad, int idVenta, int idInventario) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.idVenta = idVenta;
        this.idInventario = idInventario;
    }
    
    
    
}
