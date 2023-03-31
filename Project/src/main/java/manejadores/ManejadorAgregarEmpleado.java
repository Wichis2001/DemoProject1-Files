/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadores;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import postgres.models.AdminDAO;
import users.Empleado;

/**
 * Está clase me permite poder manejar la ventana de agregar empleado 
 * @author luis
 */
public class ManejadorAgregarEmpleado {
    
    AdminDAO admin = new AdminDAO();
    
    /**
     * Esté metodo me permite poder verificar si el nombre del empleado que se ingresa, ya se encuentra registrado.
     * @param nombre
     * @param contrasenia
     * @param rol
     * @param sucursal
     * @param agregar
     */
    public void verificarEmpleado( JTextField nombre, JTextField contrasenia, JComboBox rol, JComboBox sucursal, JButton agregar ){
        //Verificamos que el nombre no se encuentra vacio
        if( !nombre.getText().isEmpty() ){
            //Verificamos si el cliente no existe
            if( !admin.buscarCliente( nombre.getText() )){
                //Si no existe habilitamos los campos de ingreso de datos
                nombre.setEnabled(false);
                contrasenia.setEnabled(true);
                rol.setEnabled(true);
                agregar.setEnabled(true);
                contrasenia.requestFocus();
            } else {
                //Le indicamos al usuario que el usuario que esta intentando ingresar ya se encuentra en la DB
                JOptionPane.showMessageDialog(null, "El nombre ya se encuentra registrado, selecciona otro nombre de usuario.", "PELIGRO", JOptionPane.WARNING_MESSAGE);
                nombre.setText("");
                nombre.requestFocus();
            }
        } else {
            //Vaciamos el campo
            JOptionPane.showMessageDialog(null, "El campo ingresado se encuentra vacío");
        }
    }
    
    /**
     * Esté métdo me permite poder agregar un empleado en base al nombre, la contraseña, el rol y la sucursal
     * @param nombre
     * @param contrasenia
     * @param rol
     * @param sucursal
     * @param agregar
     */
    public void agregarEmpleado(JTextField nombre, JTextField contrasenia, JComboBox rol, JComboBox sucursal, JButton agregar ){
        int sucursalNumerica = 0;
        int rolNumerico = 0;
        //Le asignamos el dato númerico del rol en base a lo que haya ingresado el usuario
        switch ( rol.getSelectedItem().toString() ) {
            case "Vendedor":
                rolNumerico = 1;
                break;
            case "Inventario":
                rolNumerico = 2;
                break;
            case "Bodega":
                rolNumerico = 3;
                sucursalNumerica = 4;
                break;
            case "Administrador":
                rolNumerico = 4;
                sucursalNumerica = 5;
                break;
        }
        //Verificamos que los roles no sean de bodega y administrador, dato que su tipo de sucursal no existe
        if( rol.getSelectedItem().toString().equals("Bodega") || rol.getSelectedItem().toString().equals("Administrador") ){
            System.out.println("Se cumple");
        } else {
            //Le asignamos la sucursal para los usuarios de tipo vendedor e inventario
            switch ( sucursal.getSelectedItem().toString() ) {
            case "Sucursal Central":
                sucursalNumerica = 1;
                break;
            case "Sucursal Norte":
                sucursalNumerica = 2;
                break;
            case "Sucursal Sur":
                sucursalNumerica = 3;
                break;
                
            }
        }
        //Creamos un nuevo empleado
        Empleado empleado = new Empleado( nombre.getText(), contrasenia.getText(), rolNumerico, sucursalNumerica);
        //Verificamos que la venta se haya ejecutado con éxito
        if( admin.addEmpleado( empleado ) ){
            JOptionPane.showMessageDialog( null, "Empleado agregado con éxito", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al agregar el empleado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    /**
     * Este método se encarga de reinciar todos los campos que posee la ventana de agregar empleado.
     * @param nombre
     * @param contrasenia
     * @param rol
     * @param sucursal
     * @param agregar
     */
    public void reiniciarVentana( JTextField nombre, JTextField contrasenia, JComboBox rol, JComboBox sucursal, JButton agregar ){
        nombre.requestFocus();
        nombre.setText("");
        contrasenia.setText("");
        nombre.setEnabled(true);
        contrasenia.setEnabled(false);
        rol.setEnabled(false);
        sucursal.setEnabled(false);
        agregar.setEnabled(false);
    }
}
