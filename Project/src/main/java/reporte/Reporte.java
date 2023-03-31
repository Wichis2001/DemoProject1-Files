/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reporte;

/**
 * Esta clase me permite crear un objeto reporte, para el manejo de reportes de la empresa
 * @author luiss
 */
public class Reporte {
    
    private String titulo;
    private float valorNumerico;
    private int valorNumerico2;
    private String titulo2;

    /**
     * Este constructor me permite poder crear un nuevo reporte en base al titulo, y los valores númericos de este
     * @param titulo
     * @param valorNumerico
     * @param valorNumerico2
     */
    public Reporte(String titulo, float valorNumerico, int valorNumerico2) {
        this.titulo = titulo;
        this.valorNumerico = valorNumerico;
        this.valorNumerico2 = valorNumerico2;
    }

    /**
     * Este constructor me permite poder crear un reporte sin necesidad de parametros
     */
    public Reporte() {
    }

    /**
     * Este metodo me devuelve el texto asociado al cliente
     * @return
     */
    public String getTitulo2() {
        return titulo2;
    }

    /**
     * Este método me permite cambiar el texto asociado al cliente
     * @param titulo2
     */
    public void setTitulo2(String titulo2) {
        this.titulo2 = titulo2;
    }
    
    /**
     * Este método me devuelve el titulo asociado a un reporte
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Este método me permite cambiar el titulo asociado a un reporte
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Este método me devuelve el valor numerico del reporte
     * @return
     */
    public float getValorNumerico() {
        return valorNumerico;
    }

    /**
     * Este método me permite cambiar el valor númerico de un usuario
     * @param valorNumerico
     */
    public void setValorNumerico(float valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    /**
     * Este método me permite cambiar el valor númerico de un usuario
     * @return
     */
    public int getValorNumerico2() {
        return valorNumerico2;
    }

    /**
     * Este método me devuelve el valor numerico del reporte
     * @param valorNumerico2
     */
    public void setValorNumerico2(int valorNumerico2) {
        this.valorNumerico2 = valorNumerico2;
    }
    
    
    
}
