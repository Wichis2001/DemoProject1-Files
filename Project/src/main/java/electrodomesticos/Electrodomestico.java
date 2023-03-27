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
    private int idInventario;

    public Electrodomestico(int idElectrodomestico, String nombre, float precio, int existencia) {
        this.idElectrodomestico = idElectrodomestico;
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
    }

    public Electrodomestico(int idElectrodomestico, String nombre, float precio, int existencia, int idInventario) {
        this.idElectrodomestico = idElectrodomestico;
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
        this.idInventario = idInventario;
    }
    
    

    public Electrodomestico() {
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
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
