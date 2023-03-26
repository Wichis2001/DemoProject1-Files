/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electrodomesticos;

/**
 *
 * @author luis
 */
public class Electrodomestico {
    
    private int idElectrodomestico;
    private String nombre;
    private float precio;
    private int existencia;

    public Electrodomestico(int idElectrodomestico, String nombre, float precio, int existencia) {
        this.idElectrodomestico = idElectrodomestico;
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
    }

    public Electrodomestico() {
    }
    

    public int getIdElectrodomestico() {
        return idElectrodomestico;
    }

    public void setIdElectrodomestico(int idElectrodomestico) {
        this.idElectrodomestico = idElectrodomestico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    
    
}
