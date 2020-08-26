/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.frontend.vistas.facturas;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import pss1inventarioscunoc.backend.controladores.ControladorFactura;
import pss1inventarioscunoc.backend.enums.Vista;
import pss1inventarioscunoc.backend.pojos.Factura;
import pss1inventarioscunoc.backend.pojos.Proveedor;
import pss1inventarioscunoc.frontend.vistas.proveedores.ListadoDeProveedoresJDialog;

/**
 *
 * @author jesfrin
 */
public class FacturasJPanel extends javax.swing.JPanel {

    private Vista vista = Vista.FACTURAS_JPANEL;
    private Proveedor proveedor;
    private ControladorFactura controlador;
    public List<Factura> listaFacturas;
    public ObservableList<Factura> listaObservableFacturas;
    private Factura factura;

    /**
     * Creates new form FacturasJPanel
     */
    public FacturasJPanel() {
        this.proveedor = null;
        this.controlador = new ControladorFactura();
        this.factura = null;
        this.listaFacturas = new LinkedList<>();
        this.listaObservableFacturas = ObservableCollections.observableList(listaFacturas);
        actualizarLista(controlador.buscarFacturas());
        initComponents();
        this.setName("Facturas");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        buscarButton1 = new javax.swing.JButton();
        modificarButton2 = new javax.swing.JButton();
        fecha1jDateChooser1 = new com.toedter.calendar.JDateChooser();
        fecha2jDateChooser2 = new com.toedter.calendar.JDateChooser();
        proveedorTextField11 = new javax.swing.JTextField();
        opcionBusquedajComboBox1 = new javax.swing.JComboBox<>();
        guardarButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 119, 180));

        jPanel1.setBackground(new java.awt.Color(51, 119, 180));

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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
        jLabel20.setText("fecha*");

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel22.setText("descripcion*");

        descripcionTextField10.setBackground(new java.awt.Color(255, 255, 255));
        descripcionTextField10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        descripcionTextField10.setForeground(new java.awt.Color(0, 0, 102));
        descripcionTextField10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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
        jLabel19.setText("proveedor");

        proveedorTextField5.setBackground(new java.awt.Color(255, 255, 255));
        proveedorTextField5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        proveedorTextField5.setForeground(new java.awt.Color(0, 0, 102));
        proveedorTextField5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        proveedorTextField5.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel21.setText("Registro de Facturas");

        asignarProveedorButton1.setBackground(new java.awt.Color(0, 204, 204));
        asignarProveedorButton1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        asignarProveedorButton1.setText("Asignar Proveedor");
        asignarProveedorButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        asignarProveedorButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarProveedorButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 119, 180));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaObservableFacturas}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fecha}"));
        columnBinding.setColumnName("Fecha");
        columnBinding.setColumnClass(java.sql.Timestamp.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcion}"));
        columnBinding.setColumnName("Descripcion");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreProveedor}"));
        columnBinding.setColumnName("Proveedor");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numeroFactura}"));
        columnBinding.setColumnName("No Factura");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valor}"));
        columnBinding.setColumnName("Valor");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${factura}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(jTable1);

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel24.setText("Facturas");

        buscarButton1.setBackground(new java.awt.Color(255, 153, 0));
        buscarButton1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        buscarButton1.setText("Buscar");
        buscarButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buscarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButton1ActionPerformed(evt);
            }
        });

        modificarButton2.setBackground(new java.awt.Color(255, 153, 0));
        modificarButton2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        modificarButton2.setText("Modificar");
        modificarButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        modificarButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarButton2ActionPerformed(evt);
            }
        });

        proveedorTextField11.setBackground(new java.awt.Color(255, 255, 255));
        proveedorTextField11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        proveedorTextField11.setForeground(new java.awt.Color(0, 0, 102));
        proveedorTextField11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        opcionBusquedajComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "proveedor", "fecha" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fecha1jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha2jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(proveedorTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opcionBusquedajComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(341, 341, 341)
                                .addComponent(jLabel24))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(288, 288, 288)
                                .addComponent(modificarButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha1jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opcionBusquedajComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buscarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(proveedorTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fecha2jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modificarButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        guardarButton2.setBackground(new java.awt.Color(255, 153, 0));
        guardarButton2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        guardarButton2.setText("Guardar factura");
        guardarButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        guardarButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(269, 269, 269))
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
                            .addComponent(descripcionTextField10)
                            .addComponent(fechajDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valorTextField9)
                            .addComponent(numeroDeFacturaTextField6))
                        .addGap(18, 18, 18)
                        .addComponent(guardarButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(numeroDeFacturaTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel22))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fechajDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descripcionTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(guardarButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void asignarProveedorButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarProveedorButton1ActionPerformed
        ListadoDeProveedoresJDialog listado = new ListadoDeProveedoresJDialog(null, true, this);
        listado.setVisible(true);
    }//GEN-LAST:event_asignarProveedorButton1ActionPerformed

    private void buscarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButton1ActionPerformed
        String opcion = this.opcionBusquedajComboBox1.getSelectedItem().toString();
        if (opcion.equalsIgnoreCase("proveedor")) {
            if (!this.proveedorTextField11.getText().isEmpty()) {
                actualizarLista(controlador.buscarFacturas(this.proveedorTextField11.getText()));
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese el nombre de un proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            Timestamp fecha1 = new Timestamp(this.fecha1jDateChooser1.getDate().getTime());
            Timestamp fecha2 = new Timestamp(this.fecha2jDateChooser2.getDate().getTime());
            System.out.println();
            if (fecha1 != null && fecha2 != null) {
                actualizarLista(controlador.buscarFacturas(fecha1, fecha2));
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese fecha incio y final", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_buscarButton1ActionPerformed

    private void valorTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorTextField9KeyTyped

    }//GEN-LAST:event_valorTextField9KeyTyped

    private void guardarButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButton2ActionPerformed
        Integer idProveedor = null;
        if (proveedor != null) {
            idProveedor = proveedor.getIdProveedor();
        }
        if (this.fechajDateChooser1.getDate() != null) {
            Factura factura = controlador.validarDatosDeIngreso(
                    this.numeroDeFacturaTextField6.getText(),
                    new Date(this.fechajDateChooser1.getDate().getTime()),
                    this.descripcionTextField10.getText(),
                    this.valorTextField9.getText(),
                    proveedor);
            if (factura!=null && proveedor != null) {//Insercion factura con proveedor
                if (controlador.registrarFacturaConProveedor(factura)) {
                    JOptionPane.showMessageDialog(this, "Se ingreso la factura");
                    limpiarCampos();
                    actualizarLista(controlador.buscarFacturas());
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo ingresar la factura", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if(factura!=null){//Insercion sin proveedor
                if (controlador.registrarFacturaSinProveedor(factura)) {
                    JOptionPane.showMessageDialog(this, "Se ingreso la factura");
                    limpiarCampos();
                    actualizarLista(controlador.buscarFacturas());
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo ingresar la factura", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "Faltan datos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_guardarButton2ActionPerformed

    private void numeroDeFacturaTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroDeFacturaTextField6KeyTyped
        char c = evt.getKeyChar();
        if (c < 48 || c > 57) {
            evt.consume();
        }
    }//GEN-LAST:event_numeroDeFacturaTextField6KeyTyped

    private void modificarButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarButton2ActionPerformed
        ModificarFacturasDialog mod = new ModificarFacturasDialog(null, true, this.factura);
        mod.setVisible(true);
        actualizarLista(controlador.buscarFacturas());
    }//GEN-LAST:event_modificarButton2ActionPerformed

    private void actualizarLista(List<Factura> listado) {
        listaObservableFacturas.clear();
        listaObservableFacturas.addAll((List<Factura>) (List<?>) listado);
    }

    public ObservableList<Factura> getListaObservableFacturas() {
        return listaObservableFacturas;
    }

    public void setListaObservableFacturas(ObservableList<Factura> listaObservableFacturas) {
        this.listaObservableFacturas = listaObservableFacturas;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        if (factura != null) {
            this.modificarButton2.setEnabled(true);
            this.factura = factura;
        } else {
            this.modificarButton2.setEnabled(false);
            this.factura = null;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asignarProveedorButton1;
    private javax.swing.JButton buscarButton1;
    private javax.swing.JTextField descripcionTextField10;
    private com.toedter.calendar.JDateChooser fecha1jDateChooser1;
    private com.toedter.calendar.JDateChooser fecha2jDateChooser2;
    private com.toedter.calendar.JDateChooser fechajDateChooser1;
    private javax.swing.JButton guardarButton2;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modificarButton2;
    private javax.swing.JTextField numeroDeFacturaTextField6;
    private javax.swing.JComboBox<String> opcionBusquedajComboBox1;
    private javax.swing.JTextField proveedorTextField11;
    private javax.swing.JTextField proveedorTextField5;
    private javax.swing.JTextField valorTextField9;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        this.numeroDeFacturaTextField6.setText("");
        this.descripcionTextField10.setText("");
        this.valorTextField9.setText("");
        this.proveedor = null;
    }

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

    public Vista getVista() {
        return vista;
    }
    
}
