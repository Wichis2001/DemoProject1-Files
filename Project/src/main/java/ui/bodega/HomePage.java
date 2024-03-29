/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.bodega;

import electrodomesticos.Electrodomestico;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import manejadores.ManejadorHomePageBodega;
import ui.login.Login;
import users.Empleado;

/**
 * Esta ventana me permite poder establecer la ventana asociada al home page de la bodega
 * @author luis
 */
public class HomePage extends javax.swing.JFrame {
    
    ManejadorHomePageBodega manejador = new ManejadorHomePageBodega();
    Empleado empleado;
    Electrodomestico electrodomestico = new Electrodomestico();
    /**
     * Creates new form HomePage
     * @param empleado
     */
    public HomePage( Empleado empleado ) {
        initComponents();
        this.setLocationRelativeTo(null);
        nombreEmpleado.setText( empleado.getUsername() );
        this.empleado = empleado;
        this.tabla.setEnabled(false);
        manejador.llenarTabla(this);
        nombre.requestFocus();
    }
    
    /**
     * Me devuelve la tabla asociada a la ventana 
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
        subtitulo = new javax.swing.JLabel();
        sucursalEmpleado = new javax.swing.JLabel();
        nombreEmpleado = new javax.swing.JLabel();
        nombreTitulo = new javax.swing.JLabel();
        sucursalTitulo = new javax.swing.JLabel();
        Regresar = new javax.swing.JLabel();
        logOut = new javax.swing.JLabel();
        subtitulo1 = new javax.swing.JLabel();
        existenciaLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        precioLabel = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        existencia = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        eliminar = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
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
        tituloPrincipal.setText("PANTALLA DE BODEGA");
        getContentPane().add(tituloPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 550, 70));

        subtitulo.setFont(new java.awt.Font("Courier 10 Pitch", 0, 24)); // NOI18N
        subtitulo.setForeground(new java.awt.Color(0, 0, 153));
        subtitulo.setText("Agrega nuevos productos a Bodega:");
        getContentPane().add(subtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 790, -1));

        sucursalEmpleado.setFont(new java.awt.Font("Courier 10 Pitch", 0, 14)); // NOI18N
        sucursalEmpleado.setForeground(new java.awt.Color(0, 0, 153));
        sucursalEmpleado.setText("Bodega");
        getContentPane().add(sucursalEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 60, -1));

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
        getContentPane().add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 650, -1, -1));

        logOut.setFont(new java.awt.Font("Ubuntu", 3, 15)); // NOI18N
        logOut.setForeground(new java.awt.Color(1, 1, 1));
        logOut.setText("LogOut");
        getContentPane().add(logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 730, -1, -1));

        subtitulo1.setFont(new java.awt.Font("Courier 10 Pitch", 0, 36)); // NOI18N
        subtitulo1.setForeground(new java.awt.Color(0, 0, 153));
        subtitulo1.setText("Inventario de productos disponibles en Bodega");
        getContentPane().add(subtitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        existenciaLabel.setFont(new java.awt.Font("Courier 10 Pitch", 1, 15)); // NOI18N
        existenciaLabel.setForeground(new java.awt.Color(0, 0, 153));
        existenciaLabel.setText("Existencia Producto:");
        getContentPane().add(existenciaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, -1, -1));

        nombreLabel.setFont(new java.awt.Font("Courier 10 Pitch", 1, 15)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(0, 0, 153));
        nombreLabel.setText("Nombre Producto:");
        getContentPane().add(nombreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        precioLabel.setFont(new java.awt.Font("Courier 10 Pitch", 1, 15)); // NOI18N
        precioLabel.setForeground(new java.awt.Color(0, 0, 153));
        precioLabel.setText("Precio Producto:");
        getContentPane().add(precioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        precio.setBackground(new java.awt.Color(102, 255, 255));
        precio.setFont(new java.awt.Font("Courier 10 Pitch", 0, 15)); // NOI18N
        precio.setForeground(new java.awt.Color(0, 0, 153));
        precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precioKeyPressed(evt);
            }
        });
        getContentPane().add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 230, 30));

        existencia.setBackground(new java.awt.Color(102, 255, 255));
        existencia.setFont(new java.awt.Font("Courier 10 Pitch", 0, 15)); // NOI18N
        existencia.setForeground(new java.awt.Color(0, 0, 153));
        existencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                existenciaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                existenciaKeyPressed(evt);
            }
        });
        getContentPane().add(existencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 300, 230, 30));

        nombre.setBackground(new java.awt.Color(102, 255, 255));
        nombre.setFont(new java.awt.Font("Courier 10 Pitch", 0, 15)); // NOI18N
        nombre.setForeground(new java.awt.Color(0, 0, 153));
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreKeyPressed(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 230, 30));

        eliminar.setBackground(new java.awt.Color(102, 255, 255));
        eliminar.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        eliminar.setForeground(new java.awt.Color(0, 0, 153));
        eliminar.setText("Eliminar");
        eliminar.setEnabled(false);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        eliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                eliminarKeyPressed(evt);
            }
        });
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 350, 130, 50));

        agregar.setBackground(new java.awt.Color(102, 255, 255));
        agregar.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        agregar.setForeground(new java.awt.Color(0, 0, 153));
        agregar.setText("Agregar");
        agregar.setEnabled(false);
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        agregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                agregarKeyPressed(evt);
            }
        });
        getContentPane().add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 130, 50));

        editar.setBackground(new java.awt.Color(102, 255, 255));
        editar.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        editar.setForeground(new java.awt.Color(0, 0, 153));
        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editarKeyPressed(evt);
            }
        });
        getContentPane().add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 130, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngwing.com (6) (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, -1));

        modificar.setBackground(new java.awt.Color(102, 255, 255));
        modificar.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        modificar.setForeground(new java.awt.Color(0, 0, 153));
        modificar.setText("Modificar");
        modificar.setEnabled(false);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        modificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                modificarKeyPressed(evt);
            }
        });
        getContentPane().add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 350, 130, 50));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 930, 340));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/homescreen.png"))); // NOI18N
        fondo.setText("jLabel1");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -170, 1120, 940));

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

    private void nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyPressed
        manejador.verificarAgregar(nombre, precio, existencia, agregar);
        if( evt.getKeyCode()==KeyEvent.VK_ENTER ) {
            precio.requestFocus();
        }
    }//GEN-LAST:event_nombreKeyPressed

    private void precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyPressed
        manejador.verificarAgregar(nombre, precio, existencia, agregar);
        if( evt.getKeyCode()==KeyEvent.VK_ENTER ) {
            existencia.requestFocus();
        }
    }//GEN-LAST:event_precioKeyPressed

    private void precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyTyped
        //Verificamos que en este Jtextfield solo hayan números
        char validar=evt.getKeyChar();
        if ( validar != '.' && !(Character.isDigit(validar)) && validar!= '\n' && validar!= '\b' ){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingresar solo números", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_precioKeyTyped

    private void existenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_existenciaKeyTyped
        //Verificamos que en este Jtextfield solo hayan números
        char validar=evt.getKeyChar();
        if (!(Character.isDigit(validar)) && validar!= '\n' && validar!= '\b'){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingresar solo números", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_existenciaKeyTyped

    private void existenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_existenciaKeyPressed
        manejador.verificarAgregar(nombre, precio, existencia, agregar);
        if( evt.getKeyCode()==KeyEvent.VK_ENTER ) {
            if( agregar.isEnabled() ){
                agregar.requestFocus();
            } else {
                nombre.requestFocus();
            }
        }
    }//GEN-LAST:event_existenciaKeyPressed

    private void agregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_agregarKeyPressed
        if( evt.getKeyCode()==KeyEvent.VK_RIGHT ) {
            editar.requestFocus();
        }
    }//GEN-LAST:event_agregarKeyPressed

    private void editarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editarKeyPressed
        if( evt.getKeyCode()==KeyEvent.VK_RIGHT ) {
            modificar.requestFocus();
        } else if( evt.getKeyCode()==KeyEvent.VK_LEFT ) {
            agregar.requestFocus();
        }
    }//GEN-LAST:event_editarKeyPressed

    private void eliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eliminarKeyPressed
        if( evt.getKeyCode()==KeyEvent.VK_LEFT ) {
            modificar.requestFocus();
        }
        
    }//GEN-LAST:event_eliminarKeyPressed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        
    }//GEN-LAST:event_nombreKeyTyped

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if( manejador.verificarLLenado(this, nombre, precio, existencia) ){
            electrodomestico.setNombre(nombre.getText());
            electrodomestico.setPrecio(Float.parseFloat(precio.getText()));
            electrodomestico.setExistencia(Integer.parseInt(existencia.getText()));
            manejador.addProducto(this, electrodomestico);
            manejador.limpiezaCampos(nombre, precio, existencia, agregar, modificar, eliminar);
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void modificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modificarKeyPressed
        if( evt.getKeyCode()==KeyEvent.VK_RIGHT ) {
            eliminar.requestFocus();
        } else if( evt.getKeyCode()==KeyEvent.VK_LEFT ) {
            editar.requestFocus();
        }
    }//GEN-LAST:event_modificarKeyPressed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        manejador.habiliatarModoEdicion(nombre, precio, existencia, tabla, agregar, modificar, eliminar);
    }//GEN-LAST:event_editarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        manejador.editarBodega(nombre, precio, existencia, agregar, modificar, eliminar, this, empleado);
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        manejador.eliminarBodega(nombre, precio, existencia, agregar, modificar, eliminar, this, empleado);
    }//GEN-LAST:event_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Regresar;
    private javax.swing.JButton agregar;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField existencia;
    private javax.swing.JLabel existenciaLabel;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel iconoNombre;
    private javax.swing.JLabel iconoSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logOut;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombreEmpleado;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel nombreTitulo;
    private javax.swing.JTextField precio;
    private javax.swing.JLabel precioLabel;
    private javax.swing.JLabel subtitulo;
    private javax.swing.JLabel subtitulo1;
    private javax.swing.JLabel sucursalEmpleado;
    private javax.swing.JLabel sucursalTitulo;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
