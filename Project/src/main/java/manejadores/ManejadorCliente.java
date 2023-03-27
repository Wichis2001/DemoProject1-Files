/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadores;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import postgres.models.ClienteDAO;
import ui.venta.Venta;
import users.Cliente;

/**
 *
 * @author luis
 */
public class ManejadorCliente {
    
    private ClienteDAO dao = new ClienteDAO();
    private Cliente cliente = new Cliente();
    
    public void crearCliente( JTextField nit, JTextField direccion, JTextField nombre, Venta venta, ui.venta.Cliente ventanaCliente ){
        cliente.setNit(nit.getText());
        cliente.setDireccion(direccion.getText());
        cliente.setNombre(nombre.getText());
        
        if( dao.addCliente(cliente) ){
            JOptionPane.showMessageDialog(null, "El cliente fue creado correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
            ventanaCliente.setVisible(false);
            venta.setVisible(true);
            venta.getNit().setEnabled(false);
            venta.getBuscarCliente().setEnabled(false);
            venta.getEditar().setEnabled(true);
            venta.getNombreProducto().setEnabled(true);
            venta.getNombre().setText(cliente.getNombre());
        } else{
            JOptionPane.showMessageDialog(null, "ERROR al ingresar un nuevo cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarCliente( JTextField nit, JTextField direccion, JTextField nombre, Venta venta, ui.venta.Cliente ventanaCliente ){
        cliente.setNit(nit.getText());
        cliente.setDireccion(direccion.getText());
        cliente.setNombre(nombre.getText());
        
        if( dao.updateCliente(cliente) ){
            JOptionPane.showMessageDialog(null, "El cliente fue actualizado correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
            ventanaCliente.setVisible(false);
            venta.setVisible(true);
            venta.getEditar().setEnabled(true);
            venta.getNombreProducto().setEnabled(true);
            venta.getNombre().setText(cliente.getNombre());
        } else{
            JOptionPane.showMessageDialog(null, "ERROR al actualizar el cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
