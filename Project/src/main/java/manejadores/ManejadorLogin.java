/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadores;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import postgres.models.EmpleadoDAO;
import ui.admin.AdminHomePage;
import ui.bodega.HomePage;
import ui.inventario.InventarioHome;
import ui.login.Login;
import ui.venta.Venta;
import users.Empleado;

/**
 * Esta clase me permite poder manipular la ventana de LogIn
 * @author luis
 */
public class ManejadorLogin {
    
    Empleado empleado;
    EmpleadoDAO dao = new EmpleadoDAO();
    
    /**
     * Este metodo me permite poder loggear a un usuario y colocarlo en la base correspondiente acorde a su usuario y su contraseña
     * @param username
     * @param contrasenia
     * @param ventana
     * @param boton
     */
    public void logIn( JTextField username, JPasswordField contrasenia, Login ventana, JButton boton ){
        //Nos aseguramos de que todos los campos se encuentren llenos
        if( username.getText() == "" || contrasenia.getText() == "") {
            //Mostramos mensaje de error
            JOptionPane.showMessageDialog( ventana, "Hay aun campos vacíos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            username.requestFocus();
        } else {
            Empleado empleado = new Empleado( username.getText() , contrasenia.getText() );
            //Nos aseguramos de que el usuario existe
            if( dao.existenciaEmpleado( empleado ) != null ){
                //Indicamos que la sesión fue asignada correctamete
                JOptionPane.showMessageDialog( ventana, "Sesión Iniciada Correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
                ventana.setVisible( false );
                //Acorde al rol, lo llevamos al usuario correspondiente
                if( empleado.getRol()== 3 ){
                    HomePage bodega = new HomePage( empleado );
                    bodega.setVisible(true);
                } else if ( empleado.getRol()== 1 ){
                    Venta venta = new Venta(empleado);
                    venta.setVisible( true );
                } else if( empleado.getRol()==2){
                    InventarioHome inventario = new InventarioHome(empleado);
                    inventario.setVisible(true);
                } else if( empleado.getRol()== 4){
                    AdminHomePage admin = new AdminHomePage(empleado);
                    admin.setVisible(true);
                }
                //Indicamos que el usuario ingresado no fue ingresado correctamente
            } else{
                JOptionPane.showMessageDialog( ventana, "No se ha encontrado ningun usuario con esos datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                username.setText("");
                contrasenia.setText("");
                username.requestFocus();
                boton.setEnabled( false );
            }
        }
        
    }
    
    /**
     *
     * @param username
     * @param contrasenia
     * @param boton
     */
    public void permitirLogIn( JTextField username, JPasswordField contrasenia, JButton boton ) {
        if( !username.getText().isEmpty() && !contrasenia.getText().isEmpty() ){
            boton.setEnabled( true );
        }
    }
    
}
