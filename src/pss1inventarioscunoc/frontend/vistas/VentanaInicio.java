/*
 * Frame de ventana de inicio del sistema
 */
package pss1inventarioscunoc.frontend.vistas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import pss1inventarioscunoc.frontend.encargados.ValidacionEncargados;
import javax.swing.UIManager;
import pss1inventarioscunoc.backend.controladores.ControladorDeArchivos;
import pss1inventarioscunoc.backend.controladores.ControladorVistas;
import pss1inventarioscunoc.backend.enums.GrupoVista;
import pss1inventarioscunoc.backend.enums.Vista;
import pss1inventarioscunoc.frontend.vistas.bienes.BienesJPanel1;
import pss1inventarioscunoc.frontend.vistas.bienes.ReporteDeBiens;
import pss1inventarioscunoc.frontend.vistas.facturas.FacturasJPanel;
import pss1inventarioscunoc.frontend.vistas.inventarios.InventarioPanel;
import pss1inventarioscunoc.frontend.vistas.proveedores.ProveedorJPanel;
import sun.awt.WindowClosingListener;

/**
 *
 * @author fabricio
 */
public class VentanaInicio extends javax.swing.JFrame{

    private Vista vista = Vista.INICIO;
    private ControladorVistas controlador = null;

    /**
     * Creates new form VentanaInicio
     */
    public VentanaInicio() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("Sistema de Inventarios CUNOC");
        this.controlador = new ControladorVistas();
        this.ventanaPrincipal.add(new InventarioPanel());
        this.initDependencies();
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
//                JOptionPane.showMessageDialog(null, "BIENVENIDO");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                //Aca se escribira el log
                ControladorDeArchivos.escribirLog();
            }

            @Override
            public void windowClosed(WindowEvent e) {
 //             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowIconified(WindowEvent e) {
 //               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
  //              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
  //              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tarjetaRespButton = new javax.swing.JButton();
        usuariosButton = new javax.swing.JButton();
        encargadosButton = new javax.swing.JButton();
        bienesButton = new javax.swing.JButton();
        inventariosButton1 = new javax.swing.JButton();
        reportesButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        ventana = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        ventanaPrincipal = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        jButton9.setBackground(new java.awt.Color(0, 51, 153));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-off.jpg"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton9.setFocusPainted(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1002, 550));

        jPanel1.setBackground(new java.awt.Color(0, 50, 102));

        jPanel3.setBackground(new java.awt.Color(0, 50, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/icons8-analizar-desde-el-portapapeles-45.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 45, 45));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/icons8-tarjeta-de-identificación-45.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 45, 45));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TARJETA RESP.");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INVENTARIOS");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BIENES");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ENCARGADOS");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 20));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("USUARIOS");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/icons8-caja-vacía-45.png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 45, 45));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/icons8-reporte-de-negocios-45.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 45, 45));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/icons8-grupo-de-primer-plano-seleccionado-45.png"))); // NOI18N
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 45, 45));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("REPORTES");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/icons8-caja-vacía-45.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 45, 45));

        tarjetaRespButton.setBackground(new java.awt.Color(0, 51, 153));
        tarjetaRespButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-off.jpg"))); // NOI18N
        tarjetaRespButton.setBorder(null);
        tarjetaRespButton.setBorderPainted(false);
        tarjetaRespButton.setContentAreaFilled(false);
        tarjetaRespButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tarjetaRespButton.setFocusPainted(false);
        tarjetaRespButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        tarjetaRespButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        tarjetaRespButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaRespButtonActionPerformed(evt);
            }
        });
        jPanel3.add(tarjetaRespButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 60));

        usuariosButton.setBackground(new java.awt.Color(0, 51, 153));
        usuariosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-off.jpg"))); // NOI18N
        usuariosButton.setBorder(null);
        usuariosButton.setBorderPainted(false);
        usuariosButton.setContentAreaFilled(false);
        usuariosButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usuariosButton.setFocusPainted(false);
        usuariosButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        usuariosButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        usuariosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosButtonActionPerformed(evt);
            }
        });
        jPanel3.add(usuariosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 250, 60));

        encargadosButton.setBackground(new java.awt.Color(0, 51, 153));
        encargadosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-off.jpg"))); // NOI18N
        encargadosButton.setBorder(null);
        encargadosButton.setBorderPainted(false);
        encargadosButton.setContentAreaFilled(false);
        encargadosButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        encargadosButton.setFocusPainted(false);
        encargadosButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        encargadosButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        encargadosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encargadosButtonActionPerformed(evt);
            }
        });
        jPanel3.add(encargadosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 250, 60));

        bienesButton.setBackground(new java.awt.Color(0, 51, 153));
        bienesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-off.jpg"))); // NOI18N
        bienesButton.setBorder(null);
        bienesButton.setBorderPainted(false);
        bienesButton.setContentAreaFilled(false);
        bienesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bienesButton.setFocusPainted(false);
        bienesButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        bienesButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        bienesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bienesButtonActionPerformed(evt);
            }
        });
        jPanel3.add(bienesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 250, 60));

        inventariosButton1.setBackground(new java.awt.Color(0, 51, 153));
        inventariosButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-off.jpg"))); // NOI18N
        inventariosButton1.setBorder(null);
        inventariosButton1.setBorderPainted(false);
        inventariosButton1.setContentAreaFilled(false);
        inventariosButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        inventariosButton1.setFocusPainted(false);
        inventariosButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        inventariosButton1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        inventariosButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventariosButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(inventariosButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 250, 60));

        reportesButton2.setBackground(new java.awt.Color(0, 51, 153));
        reportesButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-off.jpg"))); // NOI18N
        reportesButton2.setBorder(null);
        reportesButton2.setBorderPainted(false);
        reportesButton2.setContentAreaFilled(false);
        reportesButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        reportesButton2.setFocusPainted(false);
        reportesButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        reportesButton2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        reportesButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(reportesButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, 60));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/icons8-reporte-de-negocios-45.png"))); // NOI18N
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 45, 45));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ventana.setBackground(new java.awt.Color(0, 50, 102));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout ventanaLayout = new javax.swing.GroupLayout(ventana);
        ventana.setLayout(ventanaLayout);
        ventanaLayout.setHorizontalGroup(
            ventanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ventanaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
                .addContainerGap())
        );
        ventanaLayout.setVerticalGroup(
            ventanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ventanaPrincipal)
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edición");

        jMenuItem4.setText("jMenuItem4");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("jMenuItem5");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Acerca");

        jMenuItem6.setText("jMenuItem6");
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("jMenuItem7");
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ventana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ventana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bienesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bienesButtonActionPerformed
        controlador.bienesButtonVentanaInicio(this);
    }//GEN-LAST:event_bienesButtonActionPerformed

    private void usuariosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosButtonActionPerformed
    }//GEN-LAST:event_usuariosButtonActionPerformed

    private void encargadosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encargadosButtonActionPerformed
        controlador.encargadosButtonVentanaInicio(this);
    }//GEN-LAST:event_encargadosButtonActionPerformed

    private void tarjetaRespButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaRespButtonActionPerformed
        controlador.tarjetasRespButtonVentanaInicio(this);
    }//GEN-LAST:event_tarjetaRespButtonActionPerformed

    private void inventariosButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventariosButton1ActionPerformed
        controlador.inventarioButtonVentanaInicio(this);
    }//GEN-LAST:event_inventariosButton1ActionPerformed

    private void reportesButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportesButton2ActionPerformed

    public Vista getVista() {
        return vista;
    }

    public JTabbedPane getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void initDependencies() {
        this.controlador.insertIntoInicioDefaultGrupoVista(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bienesButton;
    private javax.swing.JButton encargadosButton;
    private javax.swing.JButton inventariosButton1;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton reportesButton2;
    private javax.swing.JButton tarjetaRespButton;
    private javax.swing.JButton usuariosButton;
    private javax.swing.JPanel ventana;
    private javax.swing.JTabbedPane ventanaPrincipal;
    // End of variables declaration//GEN-END:variables


        
   
}
