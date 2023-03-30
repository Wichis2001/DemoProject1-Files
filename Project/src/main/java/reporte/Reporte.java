/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reporte;

/**
 *
 * @author luiss
 */
public class Reporte {
    
    private String titulo;
    private float valorNumerico;
    private int valorNumerico2;
    private String titulo2;

    public Reporte(String titulo, float valorNumerico, int valorNumerico2) {
        this.titulo = titulo;
        this.valorNumerico = valorNumerico;
        this.valorNumerico2 = valorNumerico2;
    }

    public Reporte() {
    }

    public String getTitulo2() {
        return titulo2;
    }

    public void setTitulo2(String titulo2) {
        this.titulo2 = titulo2;
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getValorNumerico() {
        return valorNumerico;
    }

    public void setValorNumerico(float valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public int getValorNumerico2() {
        return valorNumerico2;
    }

    public void setValorNumerico2(int valorNumerico2) {
        this.valorNumerico2 = valorNumerico2;
    }
    
    
    
}
