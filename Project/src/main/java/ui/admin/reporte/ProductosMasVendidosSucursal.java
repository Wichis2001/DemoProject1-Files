/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.admin.reporte;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import manejadores.reportes.ManejadorProductosMasVendidosSucursal;
import ui.admin.AdminHomePage;
import users.Empleado;

/**
 * Está ventana me permite mostrarle al usuario el reporte de los productos más vendidos por sucursal
 * @author luis
 */
public class ProductosMasVendidosSucursal extends javax.swing.JFrame {
    
    ManejadorProductosMasVendidosSucursal manejador = new ManejadorProductosMasVendidosSucursal();
    Empleado empleado;
    private int local = 0;
    AdminHomePage admin;
    /**
     * Creates new form HomePage
     * @param empleado
     * @param admin
     */
    public ProductosMasVendidosSucursal( Empleado empleado, AdminHomePage admin ) {
        initComponents();
        this.setLocationRelativeTo(null);
        nombreEmpleado.setText( empleado.getUsername() );
        this.empleado = empleado;
        this.tabla.setEnabled(false);
        this.admin = admin;
    }
    
    /**
     * Este método me devuelve la tabla de las ventanas
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
        tituloPrincipal = new javax.swing.JLabel();
        sucursalEmpleado = new javax.swing.JLabel();
        nombreEmpleado = new javax.swing.JLabel();
        nombreTitulo = new javax.swing.JLabel();
        Regresar = new javax.swing.JLabel();
        logOut = new javax.swing.JLabel();
        subtitulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        subtitulo2 = new javax.swing.JLabel();
        nombreTitulo1 = new javax.swing.JLabel();
        sucursal = new javax.swing.JComboBox<>();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconoNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngwing.com (1).png"))); // NOI18N
        getContentPane().add(iconoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        tituloPrincipal.setFont(new java.awt.Font("Courier 10 Pitch", 1, 48)); // NOI18N
        tituloPrincipal.setForeground(new java.awt.Color(0, 0, 153));
        tituloPrincipal.setText("PANTALLA DE ADMINISTRADOR");
        getContentPane().add(tituloPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 820, 70));

        sucursalEmpleado.setFont(new java.awt.Font("Courier 10 Pitch", 0, 14)); // NOI18N
        sucursalEmpleado.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(sucursalEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 740, -1));

        nombreEmpleado.setFont(new java.awt.Font("Courier 10 Pitch", 0, 14)); // NOI18N
        nombreEmpleado.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(nombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 690, -1));

        nombreTitulo.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        nombreTitulo.setForeground(new java.awt.Color(0, 0, 153));
        nombreTitulo.setText("Selecciona una Sucursal:");
        getContentPane().add(nombreTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regresar.png"))); // NOI18N
        Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegresarMouseClicked(evt);
            }
        });
        getContentPane().add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 620, -1, -1));

        logOut.setFont(new java.awt.Font("Ubuntu", 3, 15)); // NOI18N
        logOut.setForeground(new java.awt.Color(1, 1, 1));
        logOut.setText("Regresar");
        getContentPane().add(logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 700, -1, -1));

        subtitulo1.setFont(new java.awt.Font("Courier 10 Pitch", 0, 36)); // NOI18N
        subtitulo1.setForeground(new java.awt.Color(0, 0, 153));
        subtitulo1.setText("VISUALIZA LOS REPORTES DE LA EMPRESA");
        getContentPane().add(subtitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/graficas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 890, 300));

        subtitulo2.setFont(new java.awt.Font("Courier 10 Pitch", 0, 36)); // NOI18N
        subtitulo2.setForeground(new java.awt.Color(0, 0, 153));
        subtitulo2.setText("TOP 5 PRODUCTOS MAS VENDIDOS SUCURSAL");
        getContentPane().add(subtitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        nombreTitulo1.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        nombreTitulo1.setForeground(new java.awt.Color(0, 0, 153));
        nombreTitulo1.setText("Nombre Empleado:");
        getContentPane().add(nombreTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        sucursal.setBackground(new java.awt.Color(102, 255, 255));
        sucursal.setFont(new java.awt.Font("Courier 10 Pitch", 3, 15)); // NOI18N
        sucursal.setForeground(new java.awt.Color(0, 0, 153));
        sucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sucursal Central", "Sucursal Norte", "Sucursal Sur" }));
        sucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucursalActionPerformed(evt);
            }
        });
        getContentPane().add(sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 370, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/homescreen.png"))); // NOI18N
        fondo.setText("jLabel1");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -170, 1080, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegresarMouseClicked
        //Regresamos al menú de administrador
        int response = JOptionPane.showConfirmDialog(this,"¿Quieres Regresar?", "REGRESAR",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (response==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(this, "Regresando...");
            //Cerramos esta ventana y procedemos a mostrar el menu de administrador
            admin.setVisible(true);
            this.setVisible(false);
            admin.setEnabled(true);
        }
    }//GEN-LAST:event_RegresarMouseClicked

    private void sucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucursalActionPerformed
        manejador.llenarTabla(this, sucursal);
    }//GEN-LAST:event_sucursalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Regresar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel iconoNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logOut;
    private javax.swing.JLabel nombreEmpleado;
    private javax.swing.JLabel nombreTitulo;
    private javax.swing.JLabel nombreTitulo1;
    private javax.swing.JLabel subtitulo1;
    private javax.swing.JLabel subtitulo2;
    private javax.swing.JComboBox<String> sucursal;
    private javax.swing.JLabel sucursalEmpleado;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
