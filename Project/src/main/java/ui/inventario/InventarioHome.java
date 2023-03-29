/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.inventario;

import ui.bodega.*;
import electrodomesticos.Electrodomestico;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import manejadores.ManejadorInventario;
import ui.login.Login;
import users.Empleado;

/**
 *
 * @author luis
 */
public class InventarioHome extends javax.swing.JFrame {
    
    ManejadorInventario manejador = new ManejadorInventario();
    Empleado empleado;
    private int local = 0;
    /**
     * Creates new form HomePage
     */
    public InventarioHome( Empleado empleado ) {
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
        this.empleado = empleado;
        this.tabla.setEnabled(false);
        manejador.llenarTabla(this, empleado.getId_sucursal());
        agregarProducto.requestFocus();
    }
    
    public JTable getTable(){
        return this.tabla;
    }
    
    public void llenarTabla(){
        manejador.llenarTabla(this, empleado.getId_sucursal());
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
        Regresar = new javax.swing.JLabel();
        logOut = new javax.swing.JLabel();
        subtitulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        eliminarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        agregarProducto = new javax.swing.JButton();
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
        getContentPane().add(sucursalEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 740, -1));

        nombreEmpleado.setFont(new java.awt.Font("Courier 10 Pitch", 0, 14)); // NOI18N
        nombreEmpleado.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(nombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 690, -1));

        nombreTitulo.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        nombreTitulo.setForeground(new java.awt.Color(0, 0, 153));
        nombreTitulo.setText("Nombre Empleado:");
        getContentPane().add(nombreTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        sucursalTitulo.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        sucursalTitulo.setForeground(new java.awt.Color(0, 0, 153));
        sucursalTitulo.setText("Sucursal:");
        getContentPane().add(sucursalTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngwing.com (4) (1).png"))); // NOI18N
        Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegresarMouseClicked(evt);
            }
        });
        getContentPane().add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 620, -1, -1));

        logOut.setFont(new java.awt.Font("Ubuntu", 3, 15)); // NOI18N
        logOut.setForeground(new java.awt.Color(1, 1, 1));
        logOut.setText("LogOut");
        getContentPane().add(logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 700, -1, -1));

        subtitulo1.setFont(new java.awt.Font("Courier 10 Pitch", 0, 36)); // NOI18N
        subtitulo1.setForeground(new java.awt.Color(0, 0, 153));
        subtitulo1.setText("VISUALIZA Y AGREGA PRODUCTOS A LA SUCURSAL.");
        getContentPane().add(subtitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngwing.com (11) (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, -1));

        eliminarProducto.setBackground(new java.awt.Color(102, 255, 255));
        eliminarProducto.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        eliminarProducto.setForeground(new java.awt.Color(0, 0, 153));
        eliminarProducto.setText("ELIMININAR PRODUCTO");
        eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProductoActionPerformed(evt);
            }
        });
        eliminarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                eliminarProductoKeyPressed(evt);
            }
        });
        getContentPane().add(eliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 350, 70));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 890, 300));

        agregarProducto.setBackground(new java.awt.Color(102, 255, 255));
        agregarProducto.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        agregarProducto.setForeground(new java.awt.Color(0, 0, 153));
        agregarProducto.setText("AGREGAR PRODUCTOS A LA SUCURSAL");
        agregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProductoActionPerformed(evt);
            }
        });
        agregarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                agregarProductoKeyPressed(evt);
            }
        });
        getContentPane().add(agregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 350, 70));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/homescreen.png"))); // NOI18N
        fondo.setText("jLabel1");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -170, 1080, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegresarMouseClicked
        //Regresamos al menú de manejadores
        int response = JOptionPane.showConfirmDialog(this,"¿Quieres Cerrar Sesión?", "CERRAR SESIÓN",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (response==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(this, "Cerrando Sesión...");
            //Cerramos esta ventana y procedemos a mostrar el menu manejadores
            this.setVisible(false);
            Login login = new Login();
            login.setVisible(true);
        }
    }//GEN-LAST:event_RegresarMouseClicked

    private void eliminarProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eliminarProductoKeyPressed

    }//GEN-LAST:event_eliminarProductoKeyPressed

    private void eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProductoActionPerformed
       manejador.elimininarInventario(this, empleado.getId_sucursal(), empleado);
    }//GEN-LAST:event_eliminarProductoActionPerformed

    private void agregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProductoActionPerformed
        SeleccionProducto seleccion = new SeleccionProducto(empleado, this);
        this.setVisible(false);
        seleccion.setVisible(true);
    }//GEN-LAST:event_agregarProductoActionPerformed

    private void agregarProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_agregarProductoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarProductoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Regresar;
    private javax.swing.JButton agregarProducto;
    private javax.swing.JButton eliminarProducto;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel iconoNombre;
    private javax.swing.JLabel iconoSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logOut;
    private javax.swing.JLabel nombreEmpleado;
    private javax.swing.JLabel nombreTitulo;
    private javax.swing.JLabel subtitulo1;
    private javax.swing.JLabel sucursalEmpleado;
    private javax.swing.JLabel sucursalTitulo;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
