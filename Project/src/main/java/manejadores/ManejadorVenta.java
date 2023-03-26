/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadores;

import electrodomesticos.Electrodomestico;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ui.bodega.HomePage;

/**
 *
 * @author luis
 */
public class ManejadorVenta {
    
    //Establecemos los modelos que tendra la JTable que esta asociada a la ventana
    DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
    DefaultTableModel modelo = new DefaultTableModel();
    
    /**
     * Metodo que me permite llenar una tabla asignandole un modelo y los datos
     * @param ventana
     */
//    public void llenarTabla(HomePage ventana){
//        JTable tabla= ventana.getTable();
//        this.setModelo(tabla);
//        this.setDatos(tabla);
//    }
    
    /**
     * Este metodo me permite modificar el modelo establecido en un JTable
     * @param tabla
     */
    public void setModelo(JTable tabla){
        //Establecemoos las columnas que tendran la tabla
        String[] columna= {"Identificador","Nombre","Precio","Existencia", "Eliminar"};
        //Asociamos  el modelo a la tabla
        modelo.setColumnIdentifiers(columna);
        tabla.setModel(modelo);
    }
    
    /**
     *  Este metodo me permite modificar los datos de una tabla a travez de los datos asignados a mi tabla
     * @param tabla
     */
//    public void setDatos(JTable tabla){
//        //Establecemos un objeto el cual contendra mis datos
//        Object[] datos= new Object[modelo.getColumnCount()];
//        modelo.setRowCount(0);
//        //Esteblecemos el Array con los elementos encontrados
//        List<Electrodomestico>listadoElectrodomesticos;
//        listadoElectrodomesticos = bodegaDao.listadoElectrodomesticos();
//        //Recorremos el array de errores para extraer sus atributos
//        for(int x=0; x<listadoElectrodomesticos.size();x++){
//            //Asignamos los datos a travez de los atributos de los datos
//            datos[0]= listadoElectrodomesticos.get(x).getIdElectrodomestico();
//            datos[1]= listadoElectrodomesticos.get(x).getNombre();
//            datos[2]= listadoElectrodomesticos.get(x).getPrecio();
//            datos[3]= listadoElectrodomesticos.get(x).getExistencia();
//            //Asignamos las filas
//            modelo.addRow(datos);
//        }
//        //Centramos los atributos obtenidos por la tabla
//        alinear.setHorizontalAlignment(SwingConstants.CENTER);
//        tabla.getColumnModel().getColumn(0).setCellRenderer(alinear);
//        tabla.getColumnModel().getColumn(1).setCellRenderer(alinear);
//        tabla.getColumnModel().getColumn(2).setCellRenderer(alinear);
//        tabla.getColumnModel().getColumn(3).setCellRenderer(alinear);
//        tabla.setModel(modelo);
//    }
}
