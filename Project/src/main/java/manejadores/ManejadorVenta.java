/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadores;

import electrodomesticos.Electrodomestico;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.EventObject;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import postgres.models.ClienteDAO;
import postgres.models.VentaDAO;
import ui.venta.Venta;
import users.Cliente;
import users.Empleado;
import ventas.Factura;

/**
 * Esta clase me permite poder manejar la ventana de venta
 * @author luis
 */
public class ManejadorVenta {
    
    private ClienteDAO dao = new ClienteDAO();
    private Cliente cliente = new Cliente();
    private ui.venta.Cliente ventanaCliente;
    private VentaDAO daoV = new VentaDAO();
    private ArrayList<Electrodomestico> electrodomesticosSucursal;
    private DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultListSelectionModel selectionModel = new DefaultListSelectionModel();
    private float total;
    private ArrayList<Factura> facturas = new ArrayList<>();
    private int indice;

    /**
     * Metodo que me permite llenar una tabla asignandole un modelo y los datos
     * @param ventana
     */
    public void llenarTabla(Venta ventana){
        JTable tabla= ventana.getTable();
        tabla.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
        this.setModelo(tabla);
        this.setDatos(tabla);
        
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setSelectionModel(selectionModel);
        tabla.setEnabled(true);
        
        tabla.setDefaultEditor(Object.class, new ReadOnlyCellEditor()); // Establece el editor personalizado en la tabla
    }
    
    /**
     * Este metodo me permite modificar el modelo establecido en un JTable
     * @param tabla
     */
    public void setModelo(JTable tabla){
        //Establecemoos las columnas que tendran la tabla
        String[] columna= {"Nro", "Codigo", "Descripción", "Precio", "Cantidad", "Subtotal"};
        //Asociamos  el modelo a la tabla
        modelo.setColumnIdentifiers(columna);
        tabla.setModel(modelo);
    }
    
    /**
     *  Este metodo me permite modificar los datos de una tabla a travez de los datos asignados a mi tabla
     * @param tabla
     */
    public void setDatos(JTable tabla){
        //Establecemos un objeto el cual contendra mis datos
        Object[] datos= new Object[modelo.getColumnCount()];
        modelo.setRowCount(0);
        //Recorremos el array de errores para extraer sus atributos
        for(int x=0; x<facturas.size();x++){
            //Asignamos los datos a travez de los atributos de los datos
            datos[0]= x+1;
            datos[1]= facturas.get(x).getIdentificador();
            datos[2]= facturas.get(x).getDescripcion();
            datos[3]= facturas.get(x).getPrecio();
            datos[4]= facturas.get(x).getCantidad();
            datos[5]= facturas.get(x).getSubTotal();
            //Asignamos las filas
            modelo.addRow(datos);
        }
        //Centramos los atributos obtenidos por la tabla
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(alinear);
        tabla.getColumnModel().getColumn(1).setCellRenderer(alinear);
        tabla.getColumnModel().getColumn(2).setCellRenderer(alinear);
        tabla.getColumnModel().getColumn(3).setCellRenderer(alinear);
        tabla.getColumnModel().getColumn(4).setCellRenderer(alinear);
        tabla.getColumnModel().getColumn(5).setCellRenderer(alinear);
        tabla.setModel(modelo);
    }
    
    /**
     * Esta clase me permtie realizar la busqueda de un cliente para garantizar la existencia y hacer el llenado de datos correspondientes en base a los datos ingresados
     * @param nit
     * @param nombre
     * @param buscar
     * @param editar
     * @param venta
     * @param nombreProducto
     * @param descuento
     */
    public void buscarCliente( JTextField nit, JTextField nombre, JButton buscar, JButton editar, Venta venta, JComboBox nombreProducto, JTextField descuento){
        //Verificamos el largo del NIT
        if(nit.getText().length() != 8 ){
            JOptionPane.showMessageDialog(null, "El nit ingresado no es válido", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            nit.requestFocus();
            buscar.setEnabled(false);
        } else{
            cliente.setNit(nit.getText() );
            //Realizamos la busqueda de los clientes y garantizamos su existencia
            if( dao.buscarCliente(cliente) == null ){
                //Le damos la opción de ingreso de clientes para poder agregar un nuevo cliente
                ventanaCliente = new ui.venta.Cliente(venta, false, cliente);
                venta.setVisible(false);
                ventanaCliente.setVisible(true);
            } else{
                //Colocamos los datos de los usuarios en los textbox correspondientes para garantizar el agragado de este
                cliente = dao.buscarCliente(cliente);
                editar.setEnabled(true);
                nombre.setText(cliente.getNombre());
                nombreProducto.setEnabled(true);
                nombreProducto.requestFocus(true);
                //Determinamos el descuento correspondiente para el cliente
                if( daoV.determinarDescuento( cliente.getNit() ) != 0){
                    descuento.setText( Integer.toString( daoV.determinarDescuento( cliente.getNit() ) ));
                } else{
                    descuento.setText("No aplica");
                }
            }
            nit.setEnabled(false);
            buscar.setEnabled(false);
        } 
    }
    
    /**
     * Esté metodo me permite poder realizar la edición de un cliente para poder realizar una modificación de sus campos
     * @param cliente
     * @param venta
     */
    public void editarCliente(Cliente cliente, Venta venta){
        cliente = dao.buscarCliente(cliente);
        ventanaCliente = new ui.venta.Cliente(venta, true, cliente);
        venta.setVisible(false);
        ventanaCliente.setVisible(true);
    }
    
    /**
     * Este método me permite poder realizar el lleando corresponente para la lista de productos
     * @param noSucursal
     * @param nombreProducto
     */
    public void llenarNombreProductos( int noSucursal, JComboBox nombreProducto ){
        electrodomesticosSucursal=daoV.listadoProductos(noSucursal);
        for( Electrodomestico electrodomestico: electrodomesticosSucursal){
            nombreProducto.addItem(electrodomestico.getNombre());
        }
    }
    
    /**
     * Esté metodo me permite poder agregar los campos correspondientes de un producto en base a los electrodomesticos que posea dicha sucursal
     * @param precio
     * @param stock
     * @param nombreProducto
     * @param cantidad
     */
    public void agregarCampos( JTextField precio, JTextField stock, JComboBox nombreProducto, JTextField cantidad ){
        for (int i = 0; i < electrodomesticosSucursal.size(); i++) {
            if( electrodomesticosSucursal.get(i).getNombre() == nombreProducto.getSelectedItem().toString()){
                indice = i;
                break;
            }
        }
        
        precio.setText(Float.toString( electrodomesticosSucursal.get(indice).getPrecio() ) );
        stock.setText(Integer.toString(electrodomesticosSucursal.get(indice).getExistencia()));    
    }
    
    /**
     * Este método me permite poder agregar los productos de una venta en base a la cantidad, el stock y el producto a llevarse
     * @param cantidad
     * @param ventana
     * @param total
     * @param totalSinDescuento
     * @param descuento
     * @param stock
     */
    public void agregarVenta( JTextField cantidad, Venta ventana, JTextField total, JTextField totalSinDescuento, JTextField descuento, JTextField stock){
        
        boolean productoPresente = false;
        int index=0;
        //Verificamos si el producto no se encontraba con anterioridad en la factura
        for (int i = 0; i < facturas.size(); i++) {
            if(facturas.get(i).getDescripcion().equals(ventana.getNombreProducto().getSelectedItem())){
                productoPresente = true;
            }
            index = i;
        }
        //Si el producto se encuentra presente realizamos una modifiacion en la factura del cliente
        if( productoPresente ){
            System.out.println(facturas.get(index).getCantidad() );
            //Verificamos que la cantidad ingresada por el usuario sea valida
            if (facturas.get(index).getStock() >= (facturas.get(index).getCantidad() + Integer.parseInt(cantidad.getText()) )){
                float subTotal = (facturas.get(index).getCantidad() + Integer.parseInt(cantidad.getText()) ) * electrodomesticosSucursal.get(indice).getPrecio();
                facturas.get(index).setCantidad(facturas.get(index).getCantidad() + Integer.parseInt(cantidad.getText()));
                facturas.get(index).setSubTotal(subTotal);
                calcularTotal();
                //Modificamos el total
                totalSinDescuento.setText(Float.toString(this.total));
                total.setText(Float.toString(this.calcularDescuentoyTotal(this.total, descuento.getText())));
                llenarTabla(ventana);
            } else{
                JOptionPane.showMessageDialog(ventana, "No es posible agregar este producto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //Agregamos una nueva venta a la factura y procedemos a llenar la tabla
            float subTotal = Integer.parseInt( cantidad.getText()) * electrodomesticosSucursal.get(indice).getPrecio();
            Factura factura =  new Factura(electrodomesticosSucursal.get(indice).getIdElectrodomestico(), electrodomesticosSucursal.get(indice).getNombre(), electrodomesticosSucursal.get(indice).getPrecio(), Integer.parseInt(cantidad.getText()), subTotal, electrodomesticosSucursal.get(indice).getIdInventario(), Integer.parseInt(stock.getText()));
            facturas.add(factura);
            calcularTotal();
        
            totalSinDescuento.setText(Float.toString(this.total));
            total.setText(Float.toString(this.calcularDescuentoyTotal(this.total, descuento.getText())));
            llenarTabla(ventana);
        }
        
        
    }
    
    private void calcularTotal(){
        //Este metodo me pemrite poder calcular el total en base al subtotal de las facturas
        this.total = 0;
        for(Factura factura: facturas){
            this.total = this.total + factura.getSubTotal();
        }
        this.total = (float)(Math.round(this.total * 100.0)/100.0);
    }
    
    private float calcularDescuentoyTotal( float totalSinDescuento, String descuento){
       //Calcuamos el descuento asociada para el cliente en base a sus compras
        if( !descuento.equals("No aplica") ){
            
             
            float cantidadDescontada = ( Integer.parseInt(descuento) * totalSinDescuento ) / 100;
            System.out.println(cantidadDescontada);
            float total = totalSinDescuento - cantidadDescontada;
            total = (float)(Math.round(total * 100.0) /100.0);
            return total;
        } else {
            return totalSinDescuento;
        }
    }
    
    /**
     * Este metodo me permite poder reiniciar una compra que ya había sido efecutada con anterioridad
     * @param stock
     * @param precio
     * @param cantidad
     * @param agregar
     * @param nombreProducto
     * @param eliminar
     */
    public void reiniciarCompra(JTextField stock, JTextField precio, JTextField cantidad, JButton agregar, JComboBox nombreProducto, JButton eliminar ){
        stock.setText("");
        precio.setText("");
        cantidad.setText("");
        agregar.setEnabled(false);
        nombreProducto.setEnabled(true);
        nombreProducto.requestFocus();
        eliminar.setEnabled(true);
    }
    
    /**
     * Este metodo me permite poder eliminar una plausible compra que se encuentre dentro de la factura
     * @param tabla
     * @param ventana
     * @param nombreProducto
     * @param eliminar
     * @param total
     * @param totalSinDescuento
     * @param descuento
     */
    public void eliminarCompra( JTable tabla, Venta ventana, JComboBox nombreProducto, JButton eliminar, JTextField total, JTextField totalSinDescuento, JTextField descuento ){
        //Garantizamos que se haya seleccionado una compra
        if(tabla.getSelectedRow() == -1 ){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun articulo para ser eliminado", "ERROR AL MODIFICAR PRODUCTO", JOptionPane.WARNING_MESSAGE);
        } else {
            int response = JOptionPane.showConfirmDialog(null,"¿Estas Seguro de eliminar este Registro?", "ELIMINAR",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            //Verificamos que en verdad se quiera eliminar este producto
            if (response==JOptionPane.YES_OPTION){
                String indexText = modelo.getValueAt(tabla.getSelectedRow(), 0).toString();
                int index = Integer.parseInt(indexText) - 1;
                facturas.remove(index);
                llenarTabla(ventana);
            }
            //Garantizamos que la factura posea datos
            if( facturas.size() > 0 ){
                nombreProducto.requestFocus();
            } else {
                //Eliminamos el elemento de la compra
                nombreProducto.requestFocus();
                eliminar.setEnabled(false);
            }
            //Calculamos de nuevo el total en base a los datos ingresados
            calcularTotal();
            total.setText(Float.toString(this.total));
            totalSinDescuento.setText(Float.toString(this.total));
            total.setText(Float.toString(this.calcularDescuentoyTotal(this.total, descuento.getText())));
        }
        
    }
    
    /**
     * Este metodo me permite efectuar una compra en base a los datos asignados a la factura
     * @param empleado
     * @param generarVenta
     * @param tipo
     * @param ventana
     */
    public void realizarVenta( Empleado empleado, JButton generarVenta, JComboBox tipo, Venta ventana){
        //Verificamos que hayan datos en la factura
        if(facturas.size()== 0){
            JOptionPane.showMessageDialog(null, "No puedes generar una venta si no hay productos", "PELIGRO", JOptionPane.WARNING_MESSAGE);
            generarVenta.setEnabled(false);
        } else{
            //Verificamos el tipo de cliente que se quiera asignar
            if( tipo.getSelectedItem().equals("C/F") ){
                cliente.setNit("C/F");
            }
            if( daoV.addVenta(this.total, cliente.getNit(), empleado.getUsername()) ){
            for(Factura factura: facturas){
                //Nos aseguramos que el detalle de las ventas y el stock se hayan podido llevar correctamente
                if( daoV.addDetalleVenta(factura) && daoV.actualizarStock(factura) ){
                 
                } else {
                   JOptionPane.showMessageDialog(null, "Error al insertar los detalles de la venta", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Venta Realizada correctamente", "Venta", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "Error al insertar la venta", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            //Reinicamos los campos del empleado
            this.reiniciarCampos(ventana, empleado);
        }
        
    }
    
    private class CustomHeaderRenderer implements TableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int rowIndex, int colIndex) {
            //Realizamos una modificación de todos los titulos de la tabla
            JLabel label = new JLabel(value.toString());
            label.setFont(new Font("Courier 10 Pitch", Font.BOLD, 14));
            label.setBackground(Color.LIGHT_GRAY);
            label.setBorder(BorderFactory.createRaisedBevelBorder());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            return label;
        }
    }
    
    private class ReadOnlyCellEditor extends DefaultCellEditor {
        public ReadOnlyCellEditor() {
            super(new JTextField());
        }

        @Override
        public boolean isCellEditable(EventObject e) {
            return false; // Establece el modo de edición en "solo lectura"
        }
    }
    
    /**
     *
     * @param ventana
     * @param empleado
     */
    public void reiniciarCampos( Venta ventana, Empleado empleado){
        Venta ventaRecargada = new Venta( empleado );
        ventana.setVisible(false);
        ventaRecargada.setVisible(true);
    }

}
