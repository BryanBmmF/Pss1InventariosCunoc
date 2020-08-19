/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.frontend.vistas.facturas;

import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pss1inventarioscunoc.backend.controladores.ControladorFactura;
import pss1inventarioscunoc.backend.pojos.Factura;
import pss1inventarioscunoc.backend.pojos.Proveedor;
import pss1inventarioscunoc.frontend.vistas.proveedores.ListadoDeProveedoresJDialog;

/**
 *
 * @author jesfrin
 */
public class ModificarFacturasDialog extends javax.swing.JDialog {

    private Proveedor proveedor;
    private ControladorFactura controlador;
    private Factura factura;

    /**
     * Creates new form ModificarFacturasDialog
     */
    public ModificarFacturasDialog(java.awt.Frame parent, boolean modal, Factura factura) {
        super(parent, modal);
        this.factura = factura;
        this.controlador = new ControladorFactura();
        initComponents();
        iniciarCamposDeFactura();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        numeroDeFacturaTextField6 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        descripcionTextField10 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        valorTextField9 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        proveedorTextField5 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        asignarProveedorButton1 = new javax.swing.JButton();
        fechajDateChooser1 = new com.toedter.calendar.JDateChooser();
        modificarButton2 = new javax.swing.JButton();
        quitarProvedorButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 119, 180));

        jPanel1.setBackground(new java.awt.Color(51, 119, 180));

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("numero de factura*");

        numeroDeFacturaTextField6.setBackground(new java.awt.Color(255, 255, 255));
        numeroDeFacturaTextField6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        numeroDeFacturaTextField6.setForeground(new java.awt.Color(0, 0, 102));
        numeroDeFacturaTextField6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        numeroDeFacturaTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeroDeFacturaTextField6KeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("fecha*");

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("descripcion*");

        descripcionTextField10.setBackground(new java.awt.Color(255, 255, 255));
        descripcionTextField10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        descripcionTextField10.setForeground(new java.awt.Color(0, 0, 102));
        descripcionTextField10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("valor*");

        valorTextField9.setBackground(new java.awt.Color(255, 255, 255));
        valorTextField9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        valorTextField9.setForeground(new java.awt.Color(0, 0, 102));
        valorTextField9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        valorTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valorTextField9KeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("proveedor");

        proveedorTextField5.setBackground(new java.awt.Color(255, 255, 255));
        proveedorTextField5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        proveedorTextField5.setForeground(new java.awt.Color(0, 0, 102));
        proveedorTextField5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        proveedorTextField5.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Modificacion de facturas");

        asignarProveedorButton1.setBackground(new java.awt.Color(0, 204, 204));
        asignarProveedorButton1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        asignarProveedorButton1.setForeground(new java.awt.Color(255, 255, 255));
        asignarProveedorButton1.setText("Asignar Proveedor");
        asignarProveedorButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        asignarProveedorButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarProveedorButton1ActionPerformed(evt);
            }
        });

        modificarButton2.setBackground(new java.awt.Color(255, 153, 0));
        modificarButton2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        modificarButton2.setForeground(new java.awt.Color(255, 255, 255));
        modificarButton2.setText("Guardar cambios");
        modificarButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        modificarButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarButton2ActionPerformed(evt);
            }
        });

        quitarProvedorButton3.setBackground(new java.awt.Color(255, 153, 0));
        quitarProvedorButton3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        quitarProvedorButton3.setForeground(new java.awt.Color(255, 255, 255));
        quitarProvedorButton3.setText("Quitar proveedor");
        quitarProvedorButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        quitarProvedorButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarProvedorButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel18))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(proveedorTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(asignarProveedorButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(numeroDeFacturaTextField6)
                            .addComponent(fechajDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descripcionTextField10)
                            .addComponent(valorTextField9)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(modificarButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quitarProvedorButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(197, 197, 197))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel21)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(numeroDeFacturaTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fechajDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descripcionTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(valorTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(proveedorTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(asignarProveedorButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificarButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitarProvedorButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numeroDeFacturaTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroDeFacturaTextField6KeyTyped
        char c = evt.getKeyChar();
        if (c < 48 || c > 57) {
            evt.consume();
        }
    }//GEN-LAST:event_numeroDeFacturaTextField6KeyTyped

    private void valorTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorTextField9KeyTyped

    }//GEN-LAST:event_valorTextField9KeyTyped

    private void asignarProveedorButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarProveedorButton1ActionPerformed
        ListadoDeProveedoresJDialog listado = new ListadoDeProveedoresJDialog(null, true, this);
        listado.setVisible(true);
    }//GEN-LAST:event_asignarProveedorButton1ActionPerformed

    private void modificarButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarButton2ActionPerformed
        boolean ingreso;
        Factura factura = controlador.validarDatosDeIngreso(
                this.numeroDeFacturaTextField6.getText(),
                new Date(this.fechajDateChooser1.getDate().getTime()),
                this.descripcionTextField10.getText(),
                this.valorTextField9.getText(),
                proveedor);
        if (factura != null) {
            if (proveedor == null) {
                factura.setIdProveedor(this.factura.getIdProveedor());
            }

            if (factura != null) {
                factura.setIdFactura(this.factura.getIdFactura());
                if (factura.getIdProveedor() <= 0) {//Ingreso sin proveedor
                    ingreso = controlador.actualizarFacturaEliminandoProveedor(factura);
                } else {//Ingreso con proveedor
                    ingreso = controlador.actualizarFacturaYSuProveedor(factura);
                }
                if (ingreso) {
                    JOptionPane.showMessageDialog(this, "Fatura actualizada");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la factura", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_modificarButton2ActionPerformed

    private void quitarProvedorButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarProvedorButton3ActionPerformed
        if (factura.getIdProveedor() >= 0) {
            factura.setIdProveedor(0);
            this.proveedorTextField5.setText("");
            this.proveedor = null;
        }

    }//GEN-LAST:event_quitarProvedorButton3ActionPerformed

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public JTextField getProveedorTextField5() {
        return proveedorTextField5;
    }

    public void setProveedorTextField5(JTextField proveedorTextField5) {
        this.proveedorTextField5 = proveedorTextField5;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asignarProveedorButton1;
    private javax.swing.JTextField descripcionTextField10;
    private com.toedter.calendar.JDateChooser fechajDateChooser1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton modificarButton2;
    private javax.swing.JTextField numeroDeFacturaTextField6;
    private javax.swing.JTextField proveedorTextField5;
    private javax.swing.JButton quitarProvedorButton3;
    private javax.swing.JTextField valorTextField9;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        this.numeroDeFacturaTextField6.setText("");
        this.descripcionTextField10.setText("");
        this.valorTextField9.setText("");
        this.proveedor = null;
    }

    private void iniciarCamposDeFactura() {
        this.numeroDeFacturaTextField6.setText(String.valueOf(factura.getNumeroFactura()));
        this.descripcionTextField10.setText(factura.getDescripcion());
        this.valorTextField9.setText(String.valueOf(factura.getValor()));
        this.proveedorTextField5.setText(factura.getNombreProveedor());
        this.fechajDateChooser1.setDate(factura.getFecha());
    }

}