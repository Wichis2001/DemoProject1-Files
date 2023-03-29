/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadores;

import electrodomesticos.Electrodomestico;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.EventObject;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListSelectionModel;
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
import postgres.models.InventarioDAO;
import ui.inventario.InventarioHome;
import ui.inventario.SeleccionProducto;
import users.Empleado;

/**
 *
 * @author luis
 */
public class ManejadorSeleccionProducto {
    
    //Establecemos los modelos que tendra la JTable que esta asociada a la ventana
    private DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultListSelectionModel selectionModel = new DefaultListSelectionModel();
    private InventarioDAO dao = new InventarioDAO();
    
    public void llenadoCombobox( JComboBox sucursalSeleccionada, int sucursal ){
        if( sucursal == 1 ){
            sucursalSeleccionada.addItem("Sucursal Norte");
            sucursalSeleccionada.addItem("Sucursal Sur");
        } else if( sucursal == 2 ){
            sucursalSeleccionada.addItem("Sucursal Central");
            sucursalSeleccionada.addItem("Sucursal Sur");
        } else {
            sucursalSeleccionada.addItem("Sucursal Central");
            sucursalSeleccionada.addItem("Sucursal Norte");
        }
        sucursalSeleccionada.addItem("Bodega");
    }
    
    private int seleccionarIndex( JComboBox sucursalSeleccionada ){
        int numero;
        System.out.println(sucursalSeleccionada.getSelectedItem().toString());
        switch (sucursalSeleccionada.getSelectedItem().toString()) {
            case "Sucursal Central":
                numero = 1;
                break;
            case "Sucursal Norte":
                numero = 2;
                break;
            case "Sucursal Sur":
                numero = 3;
                break;
            case "Bodega":
                numero = 4;
                break;
            default:
                numero = 0;
        }
        return numero;
    }
    
    public void actualizarInventario(SeleccionProducto ventana, Empleado empleado, JComboBox producto){
        if(ventana.getTable().getSelectedRow() == -1 ){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun articulo para transferir", "ERROR AL TRANSFERIR PRODUCTO", JOptionPane.WARNING_MESSAGE);
        } else {
            int response = JOptionPane.showConfirmDialog(null,"¿Estas seguro que deseas transferir este producto?", "TRANSFERIR",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (response==JOptionPane.YES_OPTION){
                Electrodomestico electrodomestico = new Electrodomestico();
                electrodomestico.setIdElectrodomestico(Integer.parseInt(modelo.getValueAt(ventana.getTable().getSelectedRow(), 0).toString()));
                electrodomestico.setExistencia(Integer.parseInt(modelo.getValueAt(ventana.getTable().getSelectedRow(), 3).toString()));
                electrodomestico.setNombre( modelo.getValueAt(ventana.getTable().getSelectedRow(), 1).toString());
                electrodomestico.setPrecio(Float.parseFloat( modelo.getValueAt(ventana.getTable().getSelectedRow(), 2).toString()));
                try{
                    int existencia = Integer.parseInt( JOptionPane.showInputDialog("Ingresa las unidades que deseas transferir"));
                    if( existencia > 0 && electrodomestico.getExistencia() >= existencia){
 
                        if( dao.existeProducto(electrodomestico, empleado.getId_sucursal())){
                            System.out.print("Exuste");
                            if( (dao.actualizacionExistenciaOrigen(electrodomestico, seleccionarIndex(producto), existencia)) && (dao.actualizacionExistenciaDestino(electrodomestico, empleado.getId_sucursal(), existencia))){
                                JOptionPane.showMessageDialog(null, "Producto trasladado a la sucursal de destino con éxito");
                                llenarTabla(ventana, producto);
                            } else{
                                JOptionPane.showMessageDialog(null, "Error al trasladar los productos existentes a la sucursal de destino");
                            }
                        } else {
                            System.out.print("NO Exuste");
                            if( (dao.actualizacionExistenciaOrigen(electrodomestico, seleccionarIndex(producto), existencia)) && (dao.asignacionNuevoProducto(electrodomestico, existencia, empleado.getId_sucursal()))){
                                JOptionPane.showMessageDialog(null, "Producto trasladado a la sucursal de destino con éxito");
                                llenarTabla(ventana, producto);
                            } else{
                                JOptionPane.showMessageDialog(null, "Error al trasladar los productos existentes a la sucursal de destino");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se puede transferir esa existencia de productos", "PELIGRO", JOptionPane.WARNING_MESSAGE );
                    }
                } catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "La entrada debe ser númerica", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        
        }
        
    }
    
    /**
     * Metodo que me permite llenar una tabla asignandole un modelo y los datos
     * @param ventana
     */
    public void llenarTabla(SeleccionProducto ventana, JComboBox sucursalSeleccionada){
        JTable tabla= ventana.getTable();
        tabla.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
        this.setModelo(tabla);
        this.setDatos(tabla, seleccionarIndex(sucursalSeleccionada));
        
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
        String[] columna= {"Identificador","Nombre","Precio","Existencia"};
        //Asociamos  el modelo a la tabla
        modelo.setColumnIdentifiers(columna);
        tabla.setModel(modelo);
    }
    
    /**
     *  Este metodo me permite modificar los datos de una tabla a travez de los datos asignados a mi tabla
     * @param tabla
     */
    public void setDatos(JTable tabla, int local){
        //Establecemos un objeto el cual contendra mis datos
        Object[] datos= new Object[modelo.getColumnCount()];
        modelo.setRowCount(0);
        //Esteblecemos el Array con los elementos encontrados
        List<Electrodomestico>listadoElectrodomesticos;
        listadoElectrodomesticos = dao.listadoElectrodomesticosSeleccionProducto( local );
        //Recorremos el array de errores para extraer sus atributos
        for(int x=0; x<listadoElectrodomesticos.size();x++){
            //Asignamos los datos a travez de los atributos de los datos
            datos[0]= listadoElectrodomesticos.get(x).getIdElectrodomestico();
            datos[1]= listadoElectrodomesticos.get(x).getNombre();
            datos[2]= listadoElectrodomesticos.get(x).getPrecio();
            datos[3]= listadoElectrodomesticos.get(x).getExistencia();
            //Asignamos las filas
            modelo.addRow(datos);
        }
        //Centramos los atributos obtenidos por la tabla
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(alinear);
        tabla.getColumnModel().getColumn(1).setCellRenderer(alinear);
        tabla.getColumnModel().getColumn(2).setCellRenderer(alinear);
        tabla.getColumnModel().getColumn(3).setCellRenderer(alinear);
        tabla.setModel(modelo);
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
