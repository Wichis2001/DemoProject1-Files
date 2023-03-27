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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import postgres.models.BodegaDAO;
import ui.bodega.HomePage;

/**
 *
 * @author luis
 */
public class ManejadorHomePageBodega {
    
    //Establecemos los modelos que tendra la JTable que esta asociada a la ventana
    private DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultListSelectionModel selectionModel = new DefaultListSelectionModel();
    private BodegaDAO bodegaDao = new BodegaDAO();
    private boolean modoEditar = false;
    private int idElectrodomestico = 0;

    public void verificarAgregar(  JTextField nombre, JTextField precio, JTextField existencia, JButton agregar ){
        if( !nombre.getText().isEmpty() && !precio.getText().isEmpty() && !existencia.getText().isEmpty() && !modoEditar ){
            agregar.setEnabled( true );
        }
    }
    
    /**
     * Metodo que me permite llenar una tabla asignandole un modelo y los datos
     * @param ventana
     */
    public void llenarTabla(HomePage ventana){
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
        String[] columna= {"Identificador","Nombre","Precio","Existencia"};
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
        //Esteblecemos el Array con los elementos encontrados
        List<Electrodomestico>listadoElectrodomesticos;
        listadoElectrodomesticos = bodegaDao.listadoElectrodomesticos();
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
    
    public void addProducto( HomePage ventana, Electrodomestico electrodomestico ){
        if( bodegaDao.addProducto(electrodomestico) ){
            int ultimoProducto = bodegaDao.ultimoProductoAgregado();
            if( bodegaDao.addInventario(electrodomestico, ultimoProducto) ){
                JOptionPane.showMessageDialog(ventana, "EL producto fue agregado a la bodega con éxito", "AÑADIDO", JOptionPane.INFORMATION_MESSAGE );
                llenarTabla(ventana);
            } else {
                JOptionPane.showMessageDialog(ventana, "Error al agregar el producto al inventario", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(ventana, "Error al agregar el producto", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean verificarLLenado( HomePage ventana, JTextField nombre, JTextField precio, JTextField existencia ){
        if( nombre.getText().isEmpty() || precio.getText().isEmpty() || existencia.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(ventana, "Aún hay campos vacios", "ERROR", JOptionPane.ERROR_MESSAGE);
            nombre.requestFocus();
            return false;
        } else if( Float.parseFloat(precio.getText()) <= 0 ){
            JOptionPane.showMessageDialog(ventana, "El Precio del producto no puede ser menor o igual a cero", "ERROR", JOptionPane.ERROR_MESSAGE);
            nombre.requestFocus();
            return false;
        } else if( Integer.parseInt(existencia.getText()) < 0 ){
            JOptionPane.showMessageDialog(ventana, "La existencia del producto no puede ser menor o igual a cero", "ERROR", JOptionPane.ERROR_MESSAGE);
            nombre.requestFocus();
            return false;
        }
        return true;
    }
    
    public void limpiezaCampos( JTextField nombre, JTextField precio, JTextField existencia, JButton agregar, JButton modificar, JButton eliminar ){
        nombre.setText("");
        precio.setText("");
        existencia.setText("");
        nombre.requestFocus();
        agregar.setEnabled(false);
        modificar.setEnabled(false);
        eliminar.setEnabled(false);
        modoEditar = false;
    }
    
    public void habiliatarModoEdicion( JTextField nombre, JTextField precio, JTextField existencia, JTable tabla, JButton agregar, JButton modificar, JButton eliminar ){
        if(tabla.getSelectedRow() == -1 ){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun articulo para ser modificado", "ERROR AL MODIFICAR PRODUCTO", JOptionPane.WARNING_MESSAGE);
        } else {
            modoEditar = true;
            modificar.setEnabled( true );
            eliminar.setEnabled( true );
            agregar.setEnabled( false );
            nombre.setText(modelo.getValueAt(tabla.getSelectedRow(), 1).toString());
            precio.setText(modelo.getValueAt(tabla.getSelectedRow(), 2).toString());
            existencia.setText(modelo.getValueAt(tabla.getSelectedRow(), 3).toString());
            idElectrodomestico = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
        }
        nombre.requestFocus();
    }
    
    public void editarBodega(JTextField nombre, JTextField precio, JTextField existencia, JButton agregar, JButton modificar, JButton eliminar, HomePage ventana ){
         if( verificarLLenado(ventana, nombre, precio, existencia) ){
             Electrodomestico electrodomestico = new Electrodomestico();
             electrodomestico.setIdElectrodomestico(idElectrodomestico);
             electrodomestico.setExistencia(Integer.parseInt(existencia.getText()));
             electrodomestico.setNombre(nombre.getText());
             electrodomestico.setPrecio(Float.parseFloat(precio.getText()));
             if( bodegaDao.updateElectrodomestico(electrodomestico) ){
                 if( bodegaDao.updateInventario(electrodomestico) ){
                     JOptionPane.showMessageDialog(null, "El producto fue actualizado en bodega correctamente", "Actualización", JOptionPane.INFORMATION_MESSAGE);
                     llenarTabla(ventana);
                 } else {
                     JOptionPane.showMessageDialog(null, "El inventario de bodega no fue actualizado correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
                 }
             } else {
                 JOptionPane.showMessageDialog(null, "El producto de bodega no fue actualizado correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
             }
             limpiezaCampos(nombre, precio, existencia, agregar, modificar, eliminar);
         }
    }
    
    public void eliminarBodega(JTextField nombre, JTextField precio, JTextField existencia, JButton agregar, JButton modificar, JButton eliminar, HomePage ventana ){
        int response = JOptionPane.showConfirmDialog(ventana,"¿Estas Seguro de eliminar este Registro?", "ELIMINAR",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (response==JOptionPane.YES_OPTION){
            if( verificarLLenado(ventana, nombre, precio, existencia) ){
             Electrodomestico electrodomestico = new Electrodomestico();
             electrodomestico.setIdElectrodomestico(idElectrodomestico);
             electrodomestico.setExistencia(Integer.parseInt(existencia.getText()));
             electrodomestico.setNombre(nombre.getText());
             electrodomestico.setPrecio(Float.parseFloat(precio.getText()));
             if( bodegaDao.deleteInventario(electrodomestico) ){
                JOptionPane.showMessageDialog(null, "El producto fue eliminado de bodega correctamente", "ELIMINACIÓN", JOptionPane.INFORMATION_MESSAGE);
                llenarTabla(ventana);
             } else {
                 JOptionPane.showMessageDialog(null, "El producto de bodega no fue eliminado correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
             } 
         }
        }
        limpiezaCampos(nombre, precio, existencia, agregar, modificar, eliminar);
        
        
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
