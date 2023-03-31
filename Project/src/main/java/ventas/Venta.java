/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

/**
 * Esta clase me permite poder crear un objeto de venta.
 * @author luis
 */
public class Venta {
    
    private float total;
    private int nit;
    private String username;

    /**
     * Este constructor me permite poder crear un objeto de venta snn necesidad de parametros
     */
    public Venta() {
    }

    /**
     * Este constructor me permite crear una venta en base al total, el nit y el nobmre del usuario
     * @param total
     * @param nit
     * @param username
     */
    public Venta(float total, int nit, String username) {
        this.total = total;
        this.nit = nit;
        this.username = username;
    }

    /**
     * Este metodo me devuelve el total de una venta
     * @return
     */
    public float getTotal() {
        return total;
    }

    /**
     * Este método me permite cambiar el total de una venta
     * @param total
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * Este método me devuelve el nit asociado a una venta
     * @return
     */
    public int getNit() {
        return nit;
    }

    /**
     * Este método me permite cambiar el NIT asociado a una venta
     * @param nit
     */
    public void setNit(int nit) {
        this.nit = nit;
    }

    /**
     * Este método me permite cambiar el nombre del usuario
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Este método me permite modificar el nombre del usuario
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
