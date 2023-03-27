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
import java.util.List;
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
import ui.bodega.HomePage;
import ui.venta.Venta;
import users.Cliente;
import ventas.Factura;

/**
 *
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
    private String totalSinDescuento;
    private String descuento;
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
    
    public void buscarCliente( JTextField nit, JTextField nombre, JButton buscar, JButton editar, Venta venta, JComboBox nombreProducto){
        if(nit.getText().length() != 8 ){
            JOptionPane.showMessageDialog(null, "El nit ingresado no es válido", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            nit.requestFocus();
            buscar.setEnabled(false);
        } else{
            cliente.setNit(nit.getText() );
            if( dao.buscarCliente(cliente) == null ){
                ventanaCliente = new ui.venta.Cliente(venta, false, cliente);
                venta.setVisible(false);
                ventanaCliente.setVisible(true);
            } else{
                cliente = dao.buscarCliente(cliente);
                editar.setEnabled(true);
                nombre.setText(cliente.getNombre());
                nombreProducto.setEnabled(true);
                nombreProducto.requestFocus(true);
            }
            nit.setEnabled(false);
            buscar.setEnabled(false);
        } 
    }
    
    public void editarCliente(Cliente cliente, Venta venta){
        cliente = dao.buscarCliente(cliente);
        ventanaCliente = new ui.venta.Cliente(venta, true, cliente);
        venta.setVisible(false);
        ventanaCliente.setVisible(true);
    }
    
    public void llenarNombreProductos( int noSucursal, JComboBox nombreProducto ){
        electrodomesticosSucursal=daoV.listadoProductos(noSucursal);
        for( Electrodomestico electrodomestico: electrodomesticosSucursal){
            nombreProducto.addItem(electrodomestico.getNombre());
        }
    }
    
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
    
    public void agregarVenta( JTextField cantidad, Venta ventana, JTextField total){
        float subTotal = Integer.parseInt( cantidad.getText()) * electrodomesticosSucursal.get(indice).getPrecio();
        Factura factura =  new Factura(electrodomesticosSucursal.get(indice).getIdElectrodomestico(), electrodomesticosSucursal.get(indice).getNombre(), electrodomesticosSucursal.get(indice).getPrecio(), Integer.parseInt(cantidad.getText()), subTotal, electrodomesticosSucursal.get(indice).getIdInventario());
        facturas.add(factura);
        calcularTotal();
        total.setText(Float.toString(this.total));
        llenarTabla(ventana);
    }
    
    private void calcularTotal(){
        this.total = 0;
        for(Factura factura: facturas){
            this.total = this.total + factura.getSubTotal();
        }
    }
    
    public void reiniciarCompra(JTextField stock, JTextField precio, JTextField cantidad, JButton agregar, JComboBox nombreProducto, JButton eliminar ){
        stock.setText("");
        precio.setText("");
        cantidad.setText("");
        agregar.setEnabled(false);
        nombreProducto.setEnabled(true);
        nombreProducto.requestFocus();
        eliminar.setEnabled(true);
    }
    
    public void eliminarCompra( JTable tabla, Venta ventana, JComboBox nombreProducto, JButton eliminar, JTextField total ){
        if(tabla.getSelectedRow() == -1 ){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun articulo para ser modificado", "ERROR AL MODIFICAR PRODUCTO", JOptionPane.WARNING_MESSAGE);
        } else {
            int response = JOptionPane.showConfirmDialog(null,"¿Estas Seguro de eliminar este Registro?", "ELIMINAR",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (response==JOptionPane.YES_OPTION){
                String indexText = modelo.getValueAt(tabla.getSelectedRow(), 0).toString();
                int index = Integer.parseInt(indexText) - 1;
                facturas.remove(index);
                llenarTabla(ventana);
            }
            
            if( facturas.size() > 0 ){
                nombreProducto.requestFocus();
            } else {
                nombreProducto.requestFocus();
                eliminar.setEnabled(false);
            }
            
            calcularTotal();
            total.setText(Float.toString(this.total));
        }
        
    }
    
    private class CustomHeaderRenderer implements TableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int rowIndex, int colIndex) {

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

}
