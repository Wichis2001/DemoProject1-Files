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
import users.Empleado;

/**
 * Esta clase me permite poder manejar la ventana de acceso a la bodega
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

    /**
     * Este método me permite poder verificar  que los campos de nombre, precio y existencia no se encuentren vacíos
     * @param nombre
     * @param precio
     * @param existencia
     * @param agregar
     */
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
    
    /**
     * Este metodo me permite poder agregar un nuevo producto a la DB
     * @param ventana
     * @param electrodomestico
     */
    public void addProducto( HomePage ventana, Electrodomestico electrodomestico ){
        //Verificamos que el producto se pueda añadir a la DB
        if( bodegaDao.addProducto(electrodomestico) ){
            //Determinamos cual es el ultimpo producto que se inserto para que lo podamos añadir al inventario
            int ultimoProducto = bodegaDao.ultimoProductoAgregado();
            //Añadimos el producto creado al inventario de la bodega
            if( bodegaDao.addInventario(electrodomestico, ultimoProducto) ){
                JOptionPane.showMessageDialog(ventana, "EL producto fue agregado a la bodega con éxito", "AÑADIDO", JOptionPane.INFORMATION_MESSAGE );
                llenarTabla(ventana);
            } else {
                //Indicamos que no se puede agregar el producto al inventario
                JOptionPane.showMessageDialog(ventana, "Error al agregar el producto al inventario", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //Indicamos que no se puede agregar el producto
            JOptionPane.showMessageDialog(ventana, "Error al agregar el producto", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Verificamos el llenado de los campos para poder agregar o actualizar un producto
     * @param ventana
     * @param nombre
     * @param precio
     * @param existencia
     * @return
     */
    public boolean verificarLLenado( HomePage ventana, JTextField nombre, JTextField precio, JTextField existencia ){
        //Verificamos que los campos se encuentran llenos
        if( nombre.getText().isEmpty() || precio.getText().isEmpty() || existencia.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(ventana, "Aún hay campos vacios", "ERROR", JOptionPane.ERROR_MESSAGE);
            nombre.requestFocus();
            return false;
            //Verificamos el precio del producto no sea igual o menor a cero
        } else if( Float.parseFloat(precio.getText()) <= 0 ){
            JOptionPane.showMessageDialog(ventana, "El Precio del producto no puede ser menor o igual a cero", "ERROR", JOptionPane.ERROR_MESSAGE);
            nombre.requestFocus();
            return false;
            //Verificamos que la existencia del producto no se igual o menor a cero
        } else if( Integer.parseInt(existencia.getText()) < 0 ){
            JOptionPane.showMessageDialog(ventana, "La existencia del producto no puede ser menor o igual a cero", "ERROR", JOptionPane.ERROR_MESSAGE);
            nombre.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * Este método se encarga de realizar la limpieza de los campos 
     * @param nombre
     * @param precio
     * @param existencia
     * @param agregar
     * @param modificar
     * @param eliminar
     */
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
    
    /**
     * Esté metodo se encarga de verificar si se puede habilitar el modo de edición  para poder habilitar los campos necesarios
     * @param nombre
     * @param precio
     * @param existencia
     * @param tabla
     * @param agregar
     * @param modificar
     * @param eliminar
     */
    public void habiliatarModoEdicion( JTextField nombre, JTextField precio, JTextField existencia, JTable tabla, JButton agregar, JButton modificar, JButton eliminar ){
        //Verificamos que se haya seleccionado un objeto en la tabla
        if(tabla.getSelectedRow() == -1 ){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun articulo para ser modificado", "ERROR AL MODIFICAR PRODUCTO", JOptionPane.WARNING_MESSAGE);
        } else {
            //Habilitamos los campos para poder realizar la edición
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
    
    /**
     * Este método me permite poder editar el elemento en la bodega
     * @param nombre
     * @param precio
     * @param existencia
     * @param agregar
     * @param modificar
     * @param eliminar
     * @param ventana
     * @param empleado
     */
    public void editarBodega(JTextField nombre, JTextField precio, JTextField existencia, JButton agregar, JButton modificar, JButton eliminar, HomePage ventana, Empleado empleado ){
        //Verificamos que los datos se encuentren llenados
        if( verificarLLenado(ventana, nombre, precio, existencia) ){
             //Creamos un nuevo objeto electrodomestico
             Electrodomestico electrodomestico = new Electrodomestico();
             electrodomestico.setIdElectrodomestico(idElectrodomestico);
             electrodomestico.setExistencia(Integer.parseInt(existencia.getText()));
             electrodomestico.setNombre(nombre.getText());
             electrodomestico.setPrecio(Float.parseFloat(precio.getText()));
             //Verificamos que la actualización se pueda realizar
             if( bodegaDao.updateElectrodomestico(electrodomestico) ){
                 //Verifiamos que se pueda actualizar el inventario
                 if( bodegaDao.updateInventario(electrodomestico, empleado.getId_sucursal() ) ){
                     JOptionPane.showMessageDialog(null, "El producto fue actualizado en bodega correctamente", "Actualización", JOptionPane.INFORMATION_MESSAGE);
                     llenarTabla(ventana);
                 } else {
                     // Error al acutalizar el producot
                     JOptionPane.showMessageDialog(null, "El inventario de bodega no fue actualizado correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
                 }
             } else {
                 JOptionPane.showMessageDialog(null, "El producto de bodega no fue actualizado correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
             }
             //Realizamos una limpieza de los productos
             limpiezaCampos(nombre, precio, existencia, agregar, modificar, eliminar);
         }
    }
    
    /**
     * Este método me permite poder eliminar un titulo en la bodega
     * @param nombre
     * @param precio
     * @param existencia
     * @param agregar
     * @param modificar
     * @param eliminar
     * @param ventana
     * @param empleado
     */
    public void eliminarBodega(JTextField nombre, JTextField precio, JTextField existencia, JButton agregar, JButton modificar, JButton eliminar, HomePage ventana, Empleado empleado ){
        int response = JOptionPane.showConfirmDialog(ventana,"¿Estas Seguro de eliminar este Registro?", "ELIMINAR",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        //Verificamos que se la opción seleccionada sea de sí
        if (response==JOptionPane.YES_OPTION){
            //Verificamos el llenado  de los campos para garantizar que se haya seleccionado una opción
            if( verificarLLenado(ventana, nombre, precio, existencia) ){
             //Creamos un nuevo electrodomestico para poder eliminarlo
             Electrodomestico electrodomestico = new Electrodomestico();
             electrodomestico.setIdElectrodomestico(idElectrodomestico);
             electrodomestico.setExistencia(Integer.parseInt(existencia.getText()));
             electrodomestico.setNombre(nombre.getText());
             electrodomestico.setPrecio(Float.parseFloat(precio.getText()));
             //Verificamos que el elemento de la bodega sea eliminada
             if( bodegaDao.deleteInventario(electrodomestico, empleado.getId_sucursal()) ){
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
        //Habilitamos  el método de edición para los titulos de las columnas de las tablas
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
