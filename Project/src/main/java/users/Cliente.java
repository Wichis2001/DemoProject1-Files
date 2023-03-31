/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

/**
 * Esta clase me permite poder crear un objeto Cliente
 * @author luis
 */
public class Cliente {
    
    private String nit;
    private String nombre;
    private String direccion;

    /**
     * Este constructor me permite poder crar un objeto cliente sin necesidad de parametros
     */
    public Cliente() {
    }

    /**
     * Este metodo me devuelve el NIT de un cliente
     * @return
     */
    public String getNit() {
        return nit;
    }

    /**
     * Este método me permite poder cambiar el NIT de un cliente
     * @param nit
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * Este método me devuelve el nombre de un cliente
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este método me permite cambiar el nombre de un cliente
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este metodo me devuelve la dirección asociada a un cliente
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Este metodo me permite cambiar la dirección de un cliente
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
}
