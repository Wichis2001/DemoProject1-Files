/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

/**
 *
 * @author luis
 */
public class DetalleVenta {
    private float precio;
    private int cantidad;
    private int idVenta;
    private int idInventario;

    public DetalleVenta(float precio, int cantidad, int idVenta, int idInventario) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.idVenta = idVenta;
        this.idInventario = idInventario;
    }
    
    
    
}
