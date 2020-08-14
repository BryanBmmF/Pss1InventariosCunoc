/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.frontend.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import pss1inventarioscunoc.backend.controladores.ControladorBien;
import pss1inventarioscunoc.backend.enums.TipoDeBien;
import pss1inventarioscunoc.backend.pojos.Bien;

/**
 *
 * @author bryan
 */
public class ConsultaBienes extends javax.swing.JPanel {
    
    private List<Bien> listadoBienes;
    private ObservableList<Bien> listadoBienesObservable;
    private ControladorBien controlador;
    private Bien bienSeleccionado;
    private String tempCUR;
    private char estado;

    /**
     * Creates new form ConsultaBienes
     */
    public ConsultaBienes() {
        this.listadoBienes = new ArrayList<>();
        this.listadoBienesObservable = ObservableCollections.observableList(listadoBienes);
        /*instanciando controlador de bienes para recuperar la lista*/
        this.controlador = new ControladorBien();
        this.bienSeleccionado= new Bien();
        /*Actualizar tabla una vez entrando a la ventana*/
        actualizarListadoObservable(controlador.consultarBienCompra());
        initComponents();
        this.setName("Bienes por Compra");
        this.estado ='1'; //estado por defecto
        this.tempCUR="";
    }

    //recibe una lista empleados
    public void actualizarListadoObservable(List<Bien> listadobienes) {
        this.listadoBienesObservable.clear();//se limpia la lista
        this.listadoBienesObservable.addAll(listadobienes); //se agreaga a la lista observable la lista recibida
    }

    public ObservableList<Bien> getListadoBienesObservable() {
        return listadoBienesObservable;
    }

    public void setListadoBienesObservable(ObservableList<Bien> listadoBienesObservable) {
        this.listadoBienesObservable = listadoBienesObservable;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        panelValidacion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cargoComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBienes = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        cargoComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        comboDivision = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        agregarButton = new javax.swing.JButton();
        limpiarButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtProcedencia = new javax.swing.JTextField();
        txtDivision = new javax.swing.JTextField();
        txtCur = new javax.swing.JTextField();
        txtBuscador = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(51, 119, 180));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consulta de Bienes por Compra");

        panelValidacion.setBackground(new java.awt.Color(51, 119, 180));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar por:");

        cargoComboBox.setBackground(new java.awt.Color(255, 255, 255));
        cargoComboBox.setForeground(new java.awt.Color(0, 50, 102));
        cargoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compra", "Donación", "Traslado" }));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bienes Registrados");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listadoBienesObservable}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tablaBienes);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cur}"));
        columnBinding.setColumnName("Cur");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idFactura}"));
        columnBinding.setColumnName("Id Factura");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${procedencia}"));
        columnBinding.setColumnName("Procedencia");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcion}"));
        columnBinding.setColumnName("Descripcion");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(pss1inventarioscunoc.backend.enums.TipoDeBien.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valor}"));
        columnBinding.setColumnName("Valor");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${division}"));
        columnBinding.setColumnName("Division");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado}"), tablaBienes, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(tablaBienes);

        btnBuscar.setBackground(new java.awt.Color(255, 153, 0));
        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CUR *");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("No.Factura *");

        txtFactura.setBackground(new java.awt.Color(255, 255, 255));
        txtFactura.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFactura.setForeground(new java.awt.Color(0, 0, 51));
        txtFactura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#####"))));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.idFactura}"), txtFactura, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Procedencia *");

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Valor *");

        txtValor.setBackground(new java.awt.Color(255, 255, 255));
        txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtValor.setForeground(new java.awt.Color(0, 0, 51));
        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.valor}"), txtValor, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        cargoComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        cargoComboBox1.setForeground(new java.awt.Color(0, 50, 102));
        cargoComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proveedor", "Factura", "Procedencia", "Division" }));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Division *");

        comboDivision.setBackground(new java.awt.Color(255, 255, 255));
        comboDivision.setForeground(new java.awt.Color(0, 50, 102));
        comboDivision.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ciencias de la Ingenieria", "Ciencias Economicas", "Ciencias Medicas", "Humanidades", "Ciencia y Tecnologia", "Calusac", "Sin Definir" }));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Descripción: ");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.descripcion}"), txtDescripcion, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(txtDescripcion);

        agregarButton.setBackground(new java.awt.Color(51, 204, 0));
        agregarButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        agregarButton.setForeground(new java.awt.Color(255, 255, 255));
        agregarButton.setText("AGREGAR");
        agregarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        limpiarButton.setBackground(new java.awt.Color(0, 204, 204));
        limpiarButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        limpiarButton.setForeground(new java.awt.Color(255, 255, 255));
        limpiarButton.setText("ACTUALIZAR");
        limpiarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        limpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarButtonActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tipo *");

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Divisiones Registradas");

        txtProcedencia.setBackground(new java.awt.Color(255, 255, 255));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.procedencia}"), txtProcedencia, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtDivision.setBackground(new java.awt.Color(255, 255, 255));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.division}"), txtDivision, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtCur.setBackground(new java.awt.Color(255, 255, 255));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.cur}"), txtCur, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtBuscador.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelValidacionLayout = new javax.swing.GroupLayout(panelValidacion);
        panelValidacion.setLayout(panelValidacionLayout);
        panelValidacionLayout.setHorizontalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValidacionLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cargoComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtCur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBuscador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelValidacionLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(limpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(panelValidacionLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(15, 15, 15))
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelValidacionLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cargoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panelValidacionLayout.createSequentialGroup()
                                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(182, 182, 182)
                                                .addComponent(jLabel11))
                                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                                .addComponent(txtProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(6, 6, 6)
                                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel12)
                                            .addComponent(comboDivision, 0, 264, Short.MAX_VALUE)
                                            .addComponent(jLabel13)
                                            .addComponent(txtValor, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        panelValidacionLayout.setVerticalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValidacionLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cargoComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(limpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(37, 37, 37))
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCur, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(cargoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(panelValidacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelValidacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        /*Agregar nuevo bien por compra*/
        if (txtCur.getText().isEmpty() || txtFactura.getText().isEmpty() || txtValor.getText().isEmpty()) {
            /*Error campos obligatorios*/
            JOptionPane.showMessageDialog(this, "Los campos marcados con (*) son obligatorios", "Error de Registro", JOptionPane.ERROR_MESSAGE);
        } else {
            Bien bien = new Bien(txtCur.getText(), Integer.parseInt(txtFactura.getText()), txtProcedencia.getText(), estado, txtDescripcion.getText(),
                    TipoDeBien.COMPRA, Double.parseDouble(txtValor.getText()), String.valueOf(comboDivision.getSelectedItem()));
            controlador.registrarBien(bien);
            
            JOptionPane.showMessageDialog(this, "Bien con CUR: " + bien.getCur() + "creado satisfactoriamente", "Info", JOptionPane.INFORMATION_MESSAGE);
            
            actualizarListadoObservable(controlador.consultarBienCompra()); /*no es lo mas optimo*/
        }
        
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarButtonActionPerformed
        
    }//GEN-LAST:event_limpiarButtonActionPerformed

    public Bien getBienSeleccionado() {
        return bienSeleccionado;
    }

    public void setBienSeleccionado(Bien bienSeleccionado) {
        Bien anterior = this.bienSeleccionado;
		if (bienSeleccionado != null) { //si el bien seleccionado n0 es nulo
			this.bienSeleccionado = bienSeleccionado.cloneCompra();//se clona el bien en bienSeleccionado al momento de seleccionarlo 
			tempCUR = this.bienSeleccionado.getCur(); //se guarda el cui seleccionado en una variable temporal
			//.setEnabled(true);  //se habilita el boton al momento de ser seleccionado un empleado
		}
		firePropertyChange("bienSeleccionado", anterior, this.bienSeleccionado);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarButton;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cargoComboBox;
    private javax.swing.JComboBox<String> cargoComboBox1;
    private javax.swing.JComboBox<String> comboDivision;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JPanel panelValidacion;
    private javax.swing.JTable tablaBienes;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextField txtCur;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtDivision;
    private javax.swing.JFormattedTextField txtFactura;
    private javax.swing.JTextField txtProcedencia;
    private javax.swing.JFormattedTextField txtValor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
