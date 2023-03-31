/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electrodomesticos;

/**
 * Esta clase me permite poder crar un Objeto electrodomestico para poder utilizarlo en mi clase
 * @author luis
 */
public class Electrodomestico {
    
    private int idElectrodomestico;
    private String nombre;
    private float precio;
    private int existencia;
    private int idInventario;

    /**
     * Constructor que me permite poder agregar un electrodomestico en base al identificador, el nombre , el precio y la existencia
     * @param idElectrodomestico
     * @param nombre
     * @param precio
     * @param existencia
     */
    public Electrodomestico(int idElectrodomestico, String nombre, float precio, int existencia) {
        this.idElectrodomestico = idElectrodomestico;
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
    }

    /**
     * Constructor que me permite poder crear un electrodomestico en base al identificador, el nombre, el precio, la existencia y el inventario
     * @param idElectrodomestico
     * @param nombre
     * @param precio
     * @param existencia
     * @param idInventario
     */
    public Electrodomestico(int idElectrodomestico, String nombre, float precio, int existencia, int idInventario) {
        this.idElectrodomestico = idElectrodomestico;
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
        this.idInventario = idInventario;
    }
    
    /**
     * Constructor vacio que me permite crear un electrodomesitco sin necesidad de parametros
     */
    public Electrodomestico() {
    }

    /**
     * Este metodo me devuelve el id del inventario de un electrodomestico
     * @return
     */
    public int getIdInventario() {
        return idInventario;
    }

    /**
     * Este metodo me permite cambiar el ID de inventario de un electrodomestico
     * @param idInventario
     */
    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }
    
    /**
     * Este metodo me devuelve el ID del electrodomestico
     * @return
     */
    public int getIdElectrodomestico() {
        return idElectrodomestico;
    }

    /**
     * Este metodo me permite cambiar el ID del electrodomestico
     * @param idElectrodomestico
     */
    public void setIdElectrodomestico(int idElectrodomestico) {
        this.idElectrodomestico = idElectrodomestico;
    }

    /**
     * Este metodo me devuelve el nombre del electrodomestico
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este metodo me permite cambiar el nombre de un electrodomestico
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este metodo me devuelve el precio de un electrodomestico
     * @return
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Este metodo me permite cambiar el nombre de un electrodomestico
     * @param precio
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Este metodo me devuelve la existencia de un electrodomestico
     * @return
     */
    public int getExistencia() {
        return existencia;
    }

    /**
     * Este metodo me permite cambiar la existencia de un electrodomestico
     * @param existencia
     */
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    
    
}
