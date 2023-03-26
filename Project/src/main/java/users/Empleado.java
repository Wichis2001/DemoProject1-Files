/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

/**
 * Esta clase me permite manejar y construir un empleado para que pueda tener acceso a la base de datos
 * @author luis
 */
public class Empleado {
    
    private String username;
    private String contrasenia;
    private int rol;
    private int id_sucursal;

    /**
     * Este constructor me permite poder crear un objeto empleado, en base al username, la contraseña, el rol y la contraseña de este.
     * @param username
     * @param contrasenia
     */
    public Empleado(String username, String contrasenia) {
        this.username = username;
        this.contrasenia = contrasenia;
    }

    /**
     * Me devuelve el username del empleado
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Me permite cambiar el username de este empleado
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Me devuelve la contraseña del empleado
     * @return
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Me permite cambiar la contraseña de un empleado
     * @param contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Me devuelve el tipo de rol al que pertence un empleado
     * @return
     */
    public int getRol() {
        return rol;
    }

    /**
     * Me permite cambiar el rol al cual pertenece un empleado
     * @param rol
     */
    public void setRol(int rol) {
        this.rol = rol;
    }

    /**
     * Me devuelve el id de sucursal al cual pertence un empleado
     * @return
     */
    public int getId_sucursal() {
        return id_sucursal;
    }

    /**
     * Me permite cambiar el id de sucursal al cual pertenece un empleado
     * @param id_sucursal
     */
    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }
    
    
}
