/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

/**
 * Este metodo me permite poder crear un objeto de Factura
 * @author luis
 */
public class Factura {
    
    
    private int identificador;
    private String descripcion;
    private float precio;
    private int cantidad;
    private float subTotal;
    private int idInventario;
    private int stock;

    /**
     * Este constructor me permite poder crear una factura sin necesidad de parametros
     */
    public Factura() {
    }

    /**
     * Este constructor me permite poder crear una factura en base al identificador, a la descripción, al precio, a la cantidad, al subTotal, el idInventario y el stock
     * @param identificador
     * @param descripcion
     * @param precio
     * @param cantidad
     * @param subTotal
     * @param idInventario
     * @param stock
     */
    public Factura(int identificador, String descripcion, float precio, int cantidad, float subTotal, int idInventario, int stock) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.idInventario = idInventario;
        this.stock = stock;
    }

    /**
     * Este metodo me devuelve al stock asociado de un electrodomestico
     * @return
     */
    public int getStock() {
        return stock;
    }

    /**
     * Este metodo me permite poder cambiar el stock asociado de un electrodomestico
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Este metodo me devuelve el id del inventario asociado a la venta
     * @return
     */
    public int getIdInventario() {
        return idInventario;
    }

    /**
     * Este metodo me permite poder cambiar el id del inventario asociado a la venta
     * @param idInventario
     */
    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    /**
     * Este método me devuelve el identificador de la venta
     * @return
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Este método me permite poder cambiar el identificador de la venta
     * @param identificador
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * Este método me devuelve la descripción del inventario
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Esté metodo me permite poder cambiar la descripción del inventario
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Esté metodo me devuelve el precio asociado a una venta
     * @return
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Este método me permite cambiar el precio asociado a una venta
     * @param precio
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Este método me devuelve la cantidad de productos adquiridos en una venta
     * @return
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Este metodo me permite cambiar la cantidad de productos en una venta
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Este método me devuelve el sub total de una venta asociada a la factura
     * @return
     */
    public float getSubTotal() {
        return subTotal;
    }

    /** Est método me permite cambiar el sub total de una venta asociada a la factura
     *
     * @param subTotal
     */
    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }
    
    
}
