/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Clases;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import java.awt.Panel;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author kenny
 */
public class JFGuiPrincipal extends javax.swing.JFrame {

    ConfigFile cf = new ConfigFile();
    ReadExcel readExcel;

    public JFGuiPrincipal() {
        try {
            
            UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());
            Conexion cn = new Conexion();
            

        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("papa keni");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        fileSaver = new javax.swing.JFileChooser();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLSecuencial = new javax.swing.JLabel();
        dirExcel = new javax.swing.JTextField();
        jLDirExcel = new javax.swing.JLabel();
        secuencial = new javax.swing.JTextField();
        jLRutaGuardado = new javax.swing.JLabel();
        rutaGuardado = new javax.swing.JTextField();
        seleccionarGuardado = new javax.swing.JButton();
        seleccionarExcel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        paises = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        Generar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMGuardar = new javax.swing.JMenuItem();
        jMCargar = new javax.swing.JMenuItem();
        salirApp = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        fileChooser.setDialogTitle("Elegir archivo");
        fileChooser.setFileFilter(new CustomFilter());
        fileChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuracion inicial"));

        jLSecuencial.setText("Secuencial:");

        dirExcel.setEditable(false);

        jLDirExcel.setText("Direccion Excel:");

        secuencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secuencialActionPerformed(evt);
            }
        });

        jLRutaGuardado.setText("Ruta guardado:");

        rutaGuardado.setEditable(false);

        seleccionarGuardado.setText("Seleccionar");
        seleccionarGuardado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarGuardadoActionPerformed(evt);
            }
        });

        seleccionarExcel.setText("Seleccionar");
        seleccionarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLSecuencial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLDirExcel)
                            .addComponent(jLRutaGuardado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rutaGuardado)
                            .addComponent(dirExcel)
                            .addComponent(secuencial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seleccionarGuardado)
                    .addComponent(seleccionarExcel))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secuencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSecuencial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRutaGuardado)
                    .addComponent(rutaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleccionarGuardado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dirExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleccionarExcel)
                    .addComponent(jLDirExcel))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos transmisión"));

        jLabel2.setText("Fecha embarque:");

        paises.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Ninguno-", "ALA" }));
        paises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paisesActionPerformed(evt);
            }
        });

        jLabel1.setText("Pais destinatario:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paises, 0, 143, Short.MAX_VALUE)
                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(334, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paises, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        Generar.setText("Generar XMLS");
        Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Generar))
                .addGap(8, 8, 8))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(Generar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        jMGuardar.setText("Guardar configuracion");
        jMGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(jMGuardar);

        jMCargar.setText("Cargar configuracion previa");
        jMCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCargarActionPerformed(evt);
            }
        });
        jMenu1.add(jMCargar);

        salirApp.setText("Salir");
        salirApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirAppActionPerformed(evt);
            }
        });
        jMenu1.add(salirApp);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem2.setText("jMenuItem2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed

    }//GEN-LAST:event_fileChooserActionPerformed
    public static void print2D(String mat[][]) {
        // Loop through all rows
        for (String[] row : mat) // converting each row as string
        // and then printing in a separate line
        {
            for (String row1 : row) {
                System.out.print(row1);
            }
            System.out.println();
        }
    }
    private void salirAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirAppActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirAppActionPerformed

    private void secuencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secuencialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secuencialActionPerformed

    private void seleccionarGuardadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarGuardadoActionPerformed
        fileSaver.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fileSaver.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            this.rutaGuardado.setText(fileSaver.getSelectedFile().getAbsolutePath());
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_seleccionarGuardadoActionPerformed

    private void GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarActionPerformed
        if (this.secuencial.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese un secuencial inicial de archivo primero.");
            return;
        }
        if (this.dirExcel.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese una direccion de excel.");
            return;
        }
        if (this.rutaGuardado.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese una ruta para guardar los generados.");
            return;
        }

        if (this.fecha.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese la fecha de embarque.");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaEmbarque = sdf.format(this.fecha.getDate()) + "T07:00:00Z";

        System.out.println(fechaEmbarque);
        if (this.paises.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un pais.");
            return;
        }
        //this.print2D();
        readExcel = new ReadExcel(this.dirExcel.getText());

        String pais = this.paises.getSelectedItem().toString();

        AdministrateXMLS adminXMLS = new AdministrateXMLS(readExcel.getMatriz(), new BigInteger(this.secuencial.getText()), fechaEmbarque, pais);
        String getLastSecuencial = "";
        try {
            getLastSecuencial = adminXMLS.crearArchivos(this.rutaGuardado.getText());
            this.secuencial.setText(getLastSecuencial);
        } catch (IOException ex) {
            Logger.getLogger(JFGuiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(rootPane, "Archivos creados correctamente");

        this.guardarDatos();
    }//GEN-LAST:event_GenerarActionPerformed

    private void jMGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMGuardarActionPerformed
        if (JOptionPane.showInternalConfirmDialog(null, "Estas seguro que deseas guardar la configuracion actual?") == JOptionPane.YES_OPTION) {
            this.guardarDatos();
        }    }//GEN-LAST:event_jMGuardarActionPerformed

    private void jMCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCargarActionPerformed
        this.cargarDatos();

    }//GEN-LAST:event_jMCargarActionPerformed

    private void seleccionarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarExcelActionPerformed

        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();
            this.dirExcel.setText(file.getAbsolutePath());
            readExcel = new ReadExcel(this.dirExcel.getText());

        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_seleccionarExcelActionPerformed

    private void paisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paisesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paisesActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void cargarDatos() {
        try {
            this.secuencial.setText(cf.get(this.jLSecuencial.getText()));
            this.rutaGuardado.setText(cf.get(this.jLRutaGuardado.getText()));
            this.dirExcel.setText(cf.get(this.jLDirExcel.getText()));
        } catch (IOException ex) {
            Logger.getLogger(JFGuiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarDatos() {
        try {
            cf.save(this.jLSecuencial.getText(), this.secuencial.getText());
            cf.save(this.jLRutaGuardado.getText(), this.rutaGuardado.getText());
            cf.save(this.jLDirExcel.getText(), this.dirExcel.getText());
        } catch (IOException ex) {
            Logger.getLogger(JFGuiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//
//            UIManager.setLookAndFeel(new FlatLightLaf());
//
//        } catch (Exception ex) {
//            System.err.println("Failed to initialize LaF");
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JFGuiPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Generar;
    private javax.swing.JTextField dirExcel;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JFileChooser fileSaver;
    private javax.swing.JLabel jLDirExcel;
    private javax.swing.JLabel jLRutaGuardado;
    private javax.swing.JLabel jLSecuencial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMCargar;
    private javax.swing.JMenuItem jMGuardar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> paises;
    private javax.swing.JTextField rutaGuardado;
    private javax.swing.JMenuItem salirApp;
    private javax.swing.JTextField secuencial;
    private javax.swing.JButton seleccionarExcel;
    private javax.swing.JButton seleccionarGuardado;
    // End of variables declaration//GEN-END:variables
}
