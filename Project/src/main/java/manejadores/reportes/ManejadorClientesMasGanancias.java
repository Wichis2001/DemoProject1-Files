/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadores.reportes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.EventObject;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import postgres.models.ReportesDAO;
import ui.admin.reporte.ClientesMasGanancias;

/**
 * Esta clase me permite manipular la ventana que contiene el reporte de clientes con más ganancias.
 * @author luiss
 */
public class ManejadorClientesMasGanancias {
    //Establecemos los modelos que tendra la JTable que esta asociada a la ventana
    private DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultListSelectionModel selectionModel = new DefaultListSelectionModel();
    private ReportesDAO reportesDao = new ReportesDAO();

     /**
     * Metodo que me permite llenar una tabla asignandole un modelo y los datos
     * @param ventana
     */
    public void llenarTabla(ClientesMasGanancias ventana){
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
        String[] columna= {"Nombre Cliente","Ganancia Generada"};
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
        List<reporte.Reporte>listadoReportes;
        listadoReportes = reportesDao.topClientesMasGanancias();
        //Recorremos el array de errores para extraer sus atributos
        for(int x=0; x<listadoReportes.size();x++){
            //Asignamos los datos a travéz de los atributos de los datos
            datos[0]= listadoReportes.get(x).getTitulo();
            datos[1]= listadoReportes.get(x).getValorNumerico();
            //Asignamos las filas
            modelo.addRow(datos);
        }
        //Centramos los atributos obtenidos por la tabla
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(alinear);
        tabla.getColumnModel().getColumn(1).setCellRenderer(alinear);
        tabla.setModel(modelo);
    }
    
    private class CustomHeaderRenderer implements TableCellRenderer {
        //Modificamos el titulo de las columnas de la tabla
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
