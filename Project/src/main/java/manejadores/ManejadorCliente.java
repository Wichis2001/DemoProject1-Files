/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadores;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import postgres.models.ClienteDAO;
import ui.venta.Venta;
import users.Cliente;

/**
 * Esta clase me permite poder manejar la ventana que me permite poder crear un nuevo cliente
 * @author luis
 */
public class ManejadorCliente {
    
    private ClienteDAO dao = new ClienteDAO();
    private Cliente cliente = new Cliente();
    
    /**
     * Este método me permite poder crear un nuevo cliente en base al nit, la direccion y su nombre 
     * @param nit
     * @param direccion
     * @param nombre
     * @param venta
     * @param ventanaCliente
     */
    public void crearCliente( JTextField nit, JTextField direccion, JTextField nombre, Venta venta, ui.venta.Cliente ventanaCliente ){
        //Creamos un nuevo cliente en base a los parametros de nit, nombre y direccion
        cliente.setNit(nit.getText());
        cliente.setDireccion(direccion.getText());
        cliente.setNombre(nombre.getText());
        //Nos aseguramos de que la venta se haya podido ejecutar con éxito
        if( dao.addCliente(cliente) ){
            //Reiniciamos la ventana y dirigimos al usuario a la pantalla de venta
            JOptionPane.showMessageDialog(null, "El cliente fue creado correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
            ventanaCliente.setVisible(false);
            venta.setVisible(true);
            venta.getNit().setEnabled(false);
            venta.getBuscarCliente().setEnabled(false);
            venta.getEditar().setEnabled(true);
            venta.getNombreProducto().setEnabled(true);
            venta.getNombre().setText(cliente.getNombre());
        } else{
            //La venta no se pudo crear correctamte
            JOptionPane.showMessageDialog(null, "ERROR al ingresar un nuevo cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Este metodo me poermte poder actualizar un empleado que ya se encuentre agregado en la DB
     * @param nit
     * @param direccion
     * @param nombre
     * @param venta
     * @param ventanaCliente
     */
    public void actualizarCliente( JTextField nit, JTextField direccion, JTextField nombre, Venta venta, ui.venta.Cliente ventanaCliente ){
        //Construimos un nuevo cliente en base a su NIT, su dirección y su nombre
        cliente.setNit(nit.getText());
        cliente.setDireccion(direccion.getText());
        cliente.setNombre(nombre.getText());
        //Verifiamos si la acutalización del cliente se pudo ejecutar con éxito
        if( dao.updateCliente(cliente) ){
            //Reiniciamos la ventana de cliente y redirigimos al vendedor a la ventana de ventas
            JOptionPane.showMessageDialog(null, "El cliente fue actualizado correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
            ventanaCliente.setVisible(false);
            venta.setVisible(true);
            venta.getEditar().setEnabled(true);
            venta.getNombreProducto().setEnabled(true);
            venta.getNombre().setText(cliente.getNombre());
        } else{
            //Error al realizar la actualización de la venta.
            JOptionPane.showMessageDialog(null, "ERROR al actualizar el cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
