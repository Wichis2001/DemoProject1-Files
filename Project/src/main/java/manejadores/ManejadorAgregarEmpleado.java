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
 *
 * @author luis
 */
public class ManejadorAgregarEmpleado {
    
    AdminDAO admin = new AdminDAO();
    
    public void verificarEmpleado( JTextField nombre, JTextField contrasenia, JComboBox rol, JComboBox sucursal, JButton agregar ){
        if( !nombre.getText().isEmpty() ){
            if( !admin.buscarCliente( nombre.getText() )){
                nombre.setEnabled(false);
                contrasenia.setEnabled(true);
                rol.setEnabled(true);
                agregar.setEnabled(true);
                contrasenia.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "El nombre ya se encuentra registrado, selecciona otro nombre de usuario.", "PELIGRO", JOptionPane.WARNING_MESSAGE);
                nombre.setText("");
                nombre.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo ingresado se encuentra vacío");
        }
    }
    
    public void agregarEmpleado(JTextField nombre, JTextField contrasenia, JComboBox rol, JComboBox sucursal, JButton agregar ){
        int sucursalNumerica = 0;
        int rolNumerico = 0;
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
        if( rol.getSelectedItem().toString().equals("Bodega") || rol.getSelectedItem().toString().equals("Administrador") ){
            System.out.println("Se cumple");
        } else {
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
        
        Empleado empleado = new Empleado( nombre.getText(), contrasenia.getText(), rolNumerico, sucursalNumerica);
        if( admin.addEmpleado( empleado ) ){
            JOptionPane.showMessageDialog( null, "Empleado agregado con éxito", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al agregar el empleado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
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
