/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.inventario;

import electrodomesticos.Electrodomestico;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import manejadores.ManejadorSeleccionProducto;
import users.Empleado;

/**
 * Este método me permite establecer una ventana para el correspondiente producto para una sucursal
 * @author luis
 */
public class SeleccionProducto extends javax.swing.JFrame {
    
    ManejadorSeleccionProducto manejador = new ManejadorSeleccionProducto();
    Empleado empleado;
    InventarioHome inventario;
    Electrodomestico electrodomestico = new Electrodomestico();
    /**
     * Creates new form HomePage
     * @param empleado
     * @param inventario
     */
    public SeleccionProducto( Empleado empleado, InventarioHome inventario ) {
        initComponents();
        this.setLocationRelativeTo(null);
        nombreEmpleado.setText( empleado.getUsername() );
        switch ( empleado.getId_sucursal() ) {
            case 1:
                sucursalEmpleado.setText("Central");
                break;
            case 2:
                sucursalEmpleado.setText("Norte");
                break;
            case 3:
                sucursalEmpleado.setText("Sur");
                break;
            default:
                sucursalEmpleado.setText("ERROR");
        }
        manejador.llenadoCombobox(sucursalSeleccionada, empleado.getId_sucursal() );
        this.empleado = empleado;
        this.tabla.setEnabled(false);
        this.inventario = inventario;
        sucursalSeleccionada.requestFocus();
        sucursalSeleccionada.setEnabled(true);
    }
    
    /**
     * Este método me devuelve la tabla de un usuario
     * @return
     */
    public JTable getTable(){
        return this.tabla;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconoNombre = new javax.swing.JLabel();
        iconoSucursal = new javax.swing.JLabel();
        tituloPrincipal = new javax.swing.JLabel();
        sucursalEmpleado = new javax.swing.JLabel();
        nombreEmpleado = new javax.swing.JLabel();
        nombreTitulo = new javax.swing.JLabel();
        sucursalTitulo = new javax.swing.JLabel();
        subtitulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        transferir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        sucursalTitulo1 = new javax.swing.JLabel();
        sucursalSeleccionada = new javax.swing.JComboBox<>();
        buscar = new javax.swing.JButton();
        regresarLabel = new javax.swing.JLabel();
        regresar = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconoNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngwing.com (1).png"))); // NOI18N
        getContentPane().add(iconoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        iconoSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngwing.com (2) (2).png"))); // NOI18N
        getContentPane().add(iconoSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        tituloPrincipal.setFont(new java.awt.Font("Courier 10 Pitch", 1, 48)); // NOI18N
        tituloPrincipal.setForeground(new java.awt.Color(0, 0, 153));
        tituloPrincipal.setText("PANTALLA DE INVENTARIO");
        getContentPane().add(tituloPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 650, 70));

        sucursalEmpleado.setFont(new java.awt.Font("Courier 10 Pitch", 0, 14)); // NOI18N
        sucursalEmpleado.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(sucursalEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 660, -1));

        nombreEmpleado.setFont(new java.awt.Font("Courier 10 Pitch", 0, 14)); // NOI18N
        nombreEmpleado.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(nombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 690, -1));

        nombreTitulo.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        nombreTitulo.setForeground(new java.awt.Color(0, 0, 153));
        nombreTitulo.setText("Nombre Empleado:");
        getContentPane().add(nombreTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        sucursalTitulo.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        sucursalTitulo.setForeground(new java.awt.Color(0, 0, 153));
        sucursalTitulo.setText("Sucursal Seleccionada:");
        getContentPane().add(sucursalTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        subtitulo1.setFont(new java.awt.Font("Courier 10 Pitch", 0, 36)); // NOI18N
        subtitulo1.setForeground(new java.awt.Color(0, 0, 153));
        subtitulo1.setText("VISUALIZA Y AGREGA PRODUCTOS A LA SUCURSAL.");
        getContentPane().add(subtitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngwing.com (11) (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, -1));

        transferir.setBackground(new java.awt.Color(102, 255, 255));
        transferir.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        transferir.setForeground(new java.awt.Color(0, 0, 153));
        transferir.setText("Transferir");
        transferir.setEnabled(false);
        transferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferirActionPerformed(evt);
            }
        });
        transferir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transferirKeyPressed(evt);
            }
        });
        getContentPane().add(transferir, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 170, 60));

        tabla.setBackground(new java.awt.Color(102, 255, 255));
        tabla.setFont(new java.awt.Font("Courier 10 Pitch", 0, 15)); // NOI18N
        tabla.setForeground(new java.awt.Color(0, 0, 153));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 890, 320));

        sucursalTitulo1.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        sucursalTitulo1.setForeground(new java.awt.Color(0, 0, 153));
        sucursalTitulo1.setText("Sucursal:");
        getContentPane().add(sucursalTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        sucursalSeleccionada.setBackground(new java.awt.Color(102, 255, 255));
        sucursalSeleccionada.setFont(new java.awt.Font("Courier 10 Pitch", 0, 15)); // NOI18N
        sucursalSeleccionada.setForeground(new java.awt.Color(0, 0, 153));
        sucursalSeleccionada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucursalSeleccionadaActionPerformed(evt);
            }
        });
        getContentPane().add(sucursalSeleccionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 210, 30));

        buscar.setBackground(new java.awt.Color(102, 255, 255));
        buscar.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        buscar.setForeground(new java.awt.Color(0, 0, 153));
        buscar.setText("Buscar");
        buscar.setEnabled(false);
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarKeyPressed(evt);
            }
        });
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 170, 60));

        regresarLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        regresarLabel.setForeground(new java.awt.Color(0, 0, 0));
        regresarLabel.setText("REGRESAR");
        getContentPane().add(regresarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 700, -1, -1));

        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regresar.png"))); // NOI18N
        regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresarMouseClicked(evt);
            }
        });
        getContentPane().add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 620, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/homescreen.png"))); // NOI18N
        fondo.setText("jLabel1");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -170, 1080, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transferirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_transferirKeyPressed
     
    }//GEN-LAST:event_transferirKeyPressed

    private void transferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferirActionPerformed
        manejador.actualizarInventario(this, empleado, sucursalSeleccionada);
    }//GEN-LAST:event_transferirActionPerformed

    private void sucursalSeleccionadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucursalSeleccionadaActionPerformed
        sucursalSeleccionada.setEnabled(false);
        buscar.setEnabled(true);
        buscar.requestFocus();
    }//GEN-LAST:event_sucursalSeleccionadaActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        manejador.llenarTabla(this, sucursalSeleccionada);
        buscar.setEnabled(false);
        sucursalSeleccionada.setEnabled(true);
        transferir.setEnabled(true);
        transferir.requestFocus();
    }//GEN-LAST:event_buscarActionPerformed

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarKeyPressed

    private void regresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarMouseClicked
        //Regresamos al menú de ventas
        int response = JOptionPane.showConfirmDialog(this,"¿Quieres Regresar a la Pestaña Anterior?", "REGRESAR",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (response==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(this, "Regresando...");
            //Cerramos esta ventana y procedemos a mostrar el menu manejadores 
            inventario.setVisible(true);
            inventario.llenarTabla();
            this.setVisible(false);
        }
    }//GEN-LAST:event_regresarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel iconoNombre;
    private javax.swing.JLabel iconoSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreEmpleado;
    private javax.swing.JLabel nombreTitulo;
    private javax.swing.JLabel regresar;
    private javax.swing.JLabel regresarLabel;
    private javax.swing.JLabel subtitulo1;
    private javax.swing.JLabel sucursalEmpleado;
    private javax.swing.JComboBox<String> sucursalSeleccionada;
    private javax.swing.JLabel sucursalTitulo;
    private javax.swing.JLabel sucursalTitulo1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel tituloPrincipal;
    private javax.swing.JButton transferir;
    // End of variables declaration//GEN-END:variables
}
