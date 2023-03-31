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
import users.Empleado;

/**
 * Esta clase me permite manejar la ventana de inventario
 * @author luis
 */
public class ManejadorInventario {
    
    //Establecemos los modelos que tendra la JTable que esta asociada a la ventana
    private DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultListSelectionModel selectionModel = new DefaultListSelectionModel();
    private InventarioDAO dao = new InventarioDAO();
    
    /**
     * Metodo que me permite llenar una tabla asignandole un modelo y los datos
     * @param ventana
     * @param local
     */
    public void llenarTabla(InventarioHome ventana, int local){
        JTable tabla= ventana.getTable();
        tabla.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
        this.setModelo(tabla);
        this.setDatos(tabla, local);
        
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
     * @param local
     */
    public void setDatos(JTable tabla, int local){
        //Establecemos un objeto el cual contendra mis datos
        Object[] datos= new Object[modelo.getColumnCount()];
        modelo.setRowCount(0);
        //Esteblecemos el Array con los elementos encontrados
        List<Electrodomestico>listadoElectrodomesticos;
        listadoElectrodomesticos = dao.listadoElectrodomesticos( local );
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
    
    /**
     * Este método me permite poder eliminar un elemento del inventario
     * @param ventana
     * @param local
     * @param empleado
     */
    public void elimininarInventario(InventarioHome ventana, int local, Empleado empleado){
        //Nos aseguramos de que se haya seleccionada un elemento en la tabla
        if(ventana.getTable().getSelectedRow() == -1 ){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun articulo para ser eliminado", "ERROR AL ELIMINAR PRODUCTO", JOptionPane.WARNING_MESSAGE);
        } else {
            int response = JOptionPane.showConfirmDialog(null,"¿Estas Seguro de eliminar este Registro?", "ELIMINAR",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            //Nos aseguramos de que el usuario en verdad quiera eliminar el registro
            if (response==JOptionPane.YES_OPTION){
                //Elaboramos un nuevo electrodomestico
                Electrodomestico electrodomestico = new Electrodomestico();
                electrodomestico.setIdElectrodomestico(Integer.parseInt(modelo.getValueAt(ventana.getTable().getSelectedRow(), 0).toString()));
                electrodomestico.setExistencia(Integer.parseInt(modelo.getValueAt(ventana.getTable().getSelectedRow(), 3).toString()));
                electrodomestico.setNombre( modelo.getValueAt(ventana.getTable().getSelectedRow(), 1).toString());
                electrodomestico.setPrecio(Float.parseFloat( modelo.getValueAt(ventana.getTable().getSelectedRow(), 2).toString()));
                //Nos aseguramos de que el inventario se pueda eliminar
                if( dao.deleteInventario(electrodomestico, empleado.getId_sucursal() ) ){
                    JOptionPane.showMessageDialog(null, "El producto fue eliminado de bodega correctamente", "ELIMINACIÓN", JOptionPane.INFORMATION_MESSAGE);
                    llenarTabla(ventana, local);
                } else {
                    JOptionPane.showMessageDialog(null, "El producto de bodega no fue eliminado correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
                } 
            }
        
        }
        
    }
    
    private class CustomHeaderRenderer implements TableCellRenderer {
        //Le asignamos una modificación a los titulos de las columnas
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
