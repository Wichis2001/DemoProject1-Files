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
import ui.bodega.HomePage;
import ui.login.Login;
import users.Empleado;

/**
 *
 * @author luis
 */
public class ManejadorLogin {
    
    Empleado empleado;
    EmpleadoDAO dao = new EmpleadoDAO();
    
    public void logIn( JTextField username, JPasswordField contrasenia, Login ventana, JButton boton ){
        
        if( username.getText() == "" ) {
            JOptionPane.showMessageDialog( ventana, "Hay aun campos vacíos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            username.requestFocus();
        } else {
            Empleado empleado = new Empleado( username.getText() , contrasenia.getText() );
        
            if( dao.existenciaEmpleado( empleado ) != null ){
                
                JOptionPane.showMessageDialog( ventana, "Sesión Iniciada Correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
                ventana.setVisible( false );
                
                if( empleado.getId_sucursal() == 4 ){
                    HomePage bodega = new HomePage( empleado );
                    bodega.setVisible(true);
                }
                
            } else{
                JOptionPane.showMessageDialog( ventana, "No se ha encontrado ningun usuario con esos datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                username.setText("");
                contrasenia.setText("");
                username.requestFocus();
                boton.setEnabled( false );
            }
        }
        
    }
    
    public void permitirLogIn( JTextField username, JPasswordField contrasenia, JButton boton ) {
        if( !username.getText().isEmpty() && !contrasenia.getText().isEmpty() ){
            boton.setEnabled( true );
        }
    }
    
}
