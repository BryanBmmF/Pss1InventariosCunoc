/*
 * Frame de ventana de inicio del sistema
 */
package pss1inventarioscunoc.frontend.vistas;

import javax.swing.UIManager;

/**
 *
 * @author fabricio
 */
public class VentanaInicio extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInicio
     */
    public VentanaInicio() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("Sistema de Inventarios CUNOC");
        ventanaPrincipal.add(new ValidacionEncargados());
        ventanaPrincipal.add(new ValidacionEncargados());
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
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
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
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
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
        jLabel2.setText("REPORTES");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BIENES");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ENCARGADOS");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

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

        jButton6.setBackground(new java.awt.Color(0, 51, 153));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-off.jpg"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.setFocusPainted(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        jButton6.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, 60));

        jButton7.setBackground(new java.awt.Color(0, 51, 153));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-off.jpg"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton7.setFocusPainted(false);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        jButton7.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 60));

        jButton8.setBackground(new java.awt.Color(0, 51, 153));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-off.jpg"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton8.setFocusPainted(false);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        jButton8.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 250, 60));

        jButton10.setBackground(new java.awt.Color(0, 51, 153));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-off.jpg"))); // NOI18N
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton10.setFocusPainted(false);
        jButton10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        jButton10.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 250, 60));

        jButton15.setBackground(new java.awt.Color(0, 51, 153));
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-off.jpg"))); // NOI18N
        jButton15.setBorder(null);
        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton15.setFocusPainted(false);
        jButton15.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        jButton15.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/button-select-on.jpg"))); // NOI18N
        jPanel3.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 250, 60));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 215, Short.MAX_VALUE))
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
                .addComponent(ventanaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                .addContainerGap())
        );
        ventanaLayout.setVerticalGroup(
            ventanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ventanaPrincipal)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Archivo");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Edición");

        jMenuItem4.setText("jMenuItem4");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("jMenuItem5");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel ventana;
    private javax.swing.JTabbedPane ventanaPrincipal;
    // End of variables declaration//GEN-END:variables
}
