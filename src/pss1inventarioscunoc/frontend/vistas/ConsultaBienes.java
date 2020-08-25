/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.frontend.vistas;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import pss1inventarioscunoc.backend.controladores.ControladorBien;
import pss1inventarioscunoc.backend.controladores.ControladorInventario;
import pss1inventarioscunoc.backend.enums.TipoDeBien;
import pss1inventarioscunoc.backend.enums.Vista;
import pss1inventarioscunoc.backend.pojos.Bien;
import pss1inventarioscunoc.backend.pojos.Factura;
import pss1inventarioscunoc.frontend.vistas.facturas.ListadoDeFacturasJDialog;
import pss1inventarioscunoc.frontend.vistas.inventarios.ListarInventariosJdialog;

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
    private Vista vista = Vista.CONSULTA_BIENES;
    private Factura factura;

    /**
     * Creates new form ConsultaBienes
     */
    public ConsultaBienes() {
        this.listadoBienes = new ArrayList<>();
        this.listadoBienesObservable = ObservableCollections.observableList(listadoBienes);
        /*instanciando controlador de bienes para recuperar la lista*/
        this.controlador = new ControladorBien();
        this.bienSeleccionado = new Bien();

        /*Actualizar tabla una vez entrando a la ventana*/
        actualizarListadoObservable(controlador.consultarBienCompra());
        initComponents();
        this.setName("Consulta de Bienes");
        this.estado = '1'; //estado por defecto sino es por baja
        this.tempCUR = "";
        bloquearCamposDonacion();
        bloquearCamposTraslado();
        this.inventarioTextField.setText(ControladorInventario.INVENTARIO_ACTUAL.getDescripcion());
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
        jScrollPane3 = new javax.swing.JScrollPane();
        panelValidacion = new javax.swing.JPanel();
        tipoBienComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBienes = new javax.swing.JTable();
        inventarioButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        facturaTextField10 = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        valorTextField10 = new javax.swing.JFormattedTextField();
        lbFecha = new javax.swing.JLabel();
        comboDivision = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcionTextField7 = new javax.swing.JTextArea();
        agregarButton = new javax.swing.JButton();
        actualizarButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        procedenciaTextField5 = new javax.swing.JTextField();
        divisionTextField9 = new javax.swing.JTextField();
        curTextField6 = new javax.swing.JTextField();
        inventarioTextField = new javax.swing.JTextField();
        lbCorrelativo = new javax.swing.JLabel();
        puntoTextField13 = new javax.swing.JTextField();
        lbPunto = new javax.swing.JLabel();
        lbActa = new javax.swing.JLabel();
        fechajDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        txtAutorizacion = new javax.swing.JTextField();
        lbAutorizacion = new javax.swing.JLabel();
        seccionTextField17 = new javax.swing.JTextField();
        lbSeccion = new javax.swing.JLabel();
        receptorTextField16 = new javax.swing.JTextField();
        lbEncargado = new javax.swing.JLabel();
        numeroActaTextField14 = new javax.swing.JTextField();
        correlativoTextField12 = new javax.swing.JTextField();
        facturaButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(51, 119, 180));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consulta de Bienes");

        panelValidacion.setBackground(new java.awt.Color(51, 119, 180));

        tipoBienComboBox.setBackground(new java.awt.Color(255, 255, 255));
        tipoBienComboBox.setForeground(new java.awt.Color(0, 50, 102));
        tipoBienComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "compra", "donación", "traslado", "todos *" }));
        tipoBienComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoBienComboBoxActionPerformed(evt);
            }
        });

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
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${correlativo}"));
        columnBinding.setColumnName("Correlativo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${punto}"));
        columnBinding.setColumnName("Punto");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numeroActa}"));
        columnBinding.setColumnName("Numero Acta");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fecha}"));
        columnBinding.setColumnName("Fecha");
        columnBinding.setColumnClass(java.sql.Timestamp.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${autorizacion}"));
        columnBinding.setColumnName("Autorizacion");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${seccion}"));
        columnBinding.setColumnName("Seccion");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${personaQueRecibio}"));
        columnBinding.setColumnName("Persona Que Recibio");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado}"), tablaBienes, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(tablaBienes);

        inventarioButton.setBackground(new java.awt.Color(255, 153, 0));
        inventarioButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        inventarioButton.setForeground(new java.awt.Color(255, 255, 255));
        inventarioButton.setText("Inventario:");
        inventarioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inventarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CUR *");

        facturaTextField10.setBackground(new java.awt.Color(255, 255, 255));
        facturaTextField10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        facturaTextField10.setForeground(new java.awt.Color(0, 0, 51));
        facturaTextField10.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.idFactura}"), facturaTextField10, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Procedencia *");

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Valor *");

        valorTextField10.setBackground(new java.awt.Color(255, 255, 255));
        valorTextField10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        valorTextField10.setForeground(new java.awt.Color(0, 0, 51));
        valorTextField10.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.valor}"), valorTextField10, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        lbFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(255, 255, 255));
        lbFecha.setText("Fecha de Traslado *");

        comboDivision.setBackground(new java.awt.Color(255, 255, 255));
        comboDivision.setForeground(new java.awt.Color(0, 50, 102));
        comboDivision.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ciencias de la Ingenieria", "Ciencias Economicas", "Ciencias Medicas", "Humanidades", "Ciencia y Tecnologia", "Calusac", "Sin Definir" }));
        comboDivision.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDivisionItemStateChanged(evt);
            }
        });
        comboDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDivisionActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Descripción: ");

        descripcionTextField7.setColumns(20);
        descripcionTextField7.setRows(5);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.descripcion}"), descripcionTextField7, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(descripcionTextField7);

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

        actualizarButton.setBackground(new java.awt.Color(0, 204, 204));
        actualizarButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        actualizarButton.setForeground(new java.awt.Color(255, 255, 255));
        actualizarButton.setText("ACTUALIZAR");
        actualizarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        actualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarButtonActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tipo *");

        procedenciaTextField5.setBackground(new java.awt.Color(255, 255, 255));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.procedencia}"), procedenciaTextField5, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        divisionTextField9.setBackground(new java.awt.Color(255, 255, 255));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.division}"), divisionTextField9, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        curTextField6.setBackground(new java.awt.Color(255, 255, 255));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.cur}"), curTextField6, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        inventarioTextField.setBackground(new java.awt.Color(255, 255, 255));

        lbCorrelativo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbCorrelativo.setForeground(new java.awt.Color(255, 255, 255));
        lbCorrelativo.setText("Correlativo *");

        puntoTextField13.setBackground(new java.awt.Color(255, 255, 255));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.punto}"), puntoTextField13, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbPunto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbPunto.setForeground(new java.awt.Color(255, 255, 255));
        lbPunto.setText("Punto *");

        lbActa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbActa.setForeground(new java.awt.Color(255, 255, 255));
        lbActa.setText("No. Acta *");

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Division *");

        txtAutorizacion.setBackground(new java.awt.Color(255, 255, 255));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.autorizacion}"), txtAutorizacion, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbAutorizacion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbAutorizacion.setForeground(new java.awt.Color(255, 255, 255));
        lbAutorizacion.setText("Autorizacion *");

        seccionTextField17.setBackground(new java.awt.Color(255, 255, 255));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.seccion}"), seccionTextField17, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbSeccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbSeccion.setForeground(new java.awt.Color(255, 255, 255));
        lbSeccion.setText("Sección *");

        receptorTextField16.setBackground(new java.awt.Color(255, 255, 255));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.personaQueRecibio}"), receptorTextField16, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbEncargado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbEncargado.setForeground(new java.awt.Color(255, 255, 255));
        lbEncargado.setText("Encargado *");

        numeroActaTextField14.setBackground(new java.awt.Color(255, 255, 255));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.numeroActa}"), numeroActaTextField14, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        correlativoTextField12.setBackground(new java.awt.Color(255, 255, 255));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${bienSeleccionado.correlativo}"), correlativoTextField12, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        facturaButton.setBackground(new java.awt.Color(255, 153, 0));
        facturaButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        facturaButton.setForeground(new java.awt.Color(255, 255, 255));
        facturaButton.setText("Factura:");
        facturaButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        facturaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelValidacionLayout = new javax.swing.GroupLayout(panelValidacion);
        panelValidacion.setLayout(panelValidacionLayout);
        panelValidacionLayout.setHorizontalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValidacionLayout.createSequentialGroup()
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1))
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel3))
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel14)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(actualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelValidacionLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(curTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(inventarioButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(facturaButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inventarioTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                        .addComponent(facturaTextField10))
                                    .addGroup(panelValidacionLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(valorTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValidacionLayout.createSequentialGroup()
                                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel15))
                                        .addGap(24, 24, 24)
                                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(procedenciaTextField5)
                                            .addComponent(tipoBienComboBox, 0, 184, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValidacionLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(comboDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(divisionTextField9))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbActa)
                                    .addComponent(lbCorrelativo)
                                    .addComponent(lbPunto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(puntoTextField13)
                                    .addComponent(numeroActaTextField14)
                                    .addComponent(correlativoTextField12)))
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelValidacionLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                                .addComponent(lbFecha)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fechajDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbAutorizacion)
                                                    .addComponent(lbSeccion))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(seccionTextField17, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                                    .addComponent(txtAutorizacion)))))
                                    .addGroup(panelValidacionLayout.createSequentialGroup()
                                        .addComponent(lbEncargado)
                                        .addGap(37, 37, 37)
                                        .addComponent(receptorTextField16)))
                                .addGap(2, 2, 2)))))
                .addGap(20, 20, 20))
        );
        panelValidacionLayout.setVerticalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValidacionLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tipoBienComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCorrelativo)
                    .addComponent(correlativoTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facturaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(facturaTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(procedenciaTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntoTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPunto))
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(comboDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(divisionTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(curTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel12)
                                    .addComponent(valorTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)))
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(numeroActaTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbActa))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fechajDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(12, 12, 12))
                            .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAutorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbAutorizacion)))
                        .addGap(24, 24, 24)))
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(seccionTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbSeccion))
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbEncargado)
                                    .addComponent(receptorTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValidacionLayout.createSequentialGroup()
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(actualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)))
                        .addComponent(jLabel3)))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        jScrollPane3.setViewportView(panelValidacion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addGap(0, 927, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1183, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(546, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                    .addContainerGap()))
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

    private void inventarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioButtonActionPerformed
        ListarInventariosJdialog inventarios = new ListarInventariosJdialog(null, true);
        inventarios.setVisible(true);
        if (ControladorInventario.INVENTARIO_ACTUAL != null) {
            this.inventarioTextField.setText(ControladorInventario.INVENTARIO_ACTUAL.getDescripcion());
        }
    }//GEN-LAST:event_inventarioButtonActionPerformed

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        //Validadndo valor
        String tipoDeBien = this.tipoBienComboBox.getSelectedItem().toString();
        int numeroFactura = ControladorBien.ID_FACTURA_INEXISTENTE;
        boolean verValores = controlador.verificarValoresGenerales(curTextField6.getText(), procedenciaTextField5.getText(), descripcionTextField7.getText(), divisionTextField9.getText(), valorTextField10.getText());
        if (verValores) {
            if (factura != null) {
                numeroFactura = factura.getIdFactura();
            }
            if (tipoDeBien.equalsIgnoreCase("traslado")) {
                boolean verificacionTraslado = controlador.verificarDatosTraslado(this.fechajDateChooser1.getDate(), seccionTextField17.getText(), receptorTextField16.getText());
                if (verificacionTraslado) {
                    Bien bien = new Bien(this.curTextField6.getText(), numeroFactura, this.procedenciaTextField5.getText(), '1', this.descripcionTextField7.getText(), TipoDeBien.TRASLADO, Double.valueOf(valorTextField10.getText()), divisionTextField9.getText(), new Timestamp(this.fechajDateChooser1.getDate().getTime()), '1', this.seccionTextField17.getText(), this.receptorTextField16.getText());
                    registrarBien(bien);
                }
            } else if (tipoDeBien.equalsIgnoreCase("donacion")) {
                boolean verificacionDonacion = controlador.verificarDatosDonacion(this.correlativoTextField12.getText(), this.puntoTextField13.getText(), this.numeroActaTextField14.getText());
                if (verificacionDonacion) {
                    Bien bien = new Bien(this.curTextField6.getText(), numeroFactura, this.procedenciaTextField5.getText(), '1', this.descripcionTextField7.getText(), TipoDeBien.DONACION, Double.valueOf(this.valorTextField10.getText()), this.divisionTextField9.getText(), Integer.valueOf(this.correlativoTextField12.getText()), this.puntoTextField13.getText(), Integer.valueOf(this.numeroActaTextField14.getText()));
                    registrarBien(bien);
                }
            } else if (tipoDeBien.equalsIgnoreCase("compra")) {
                Bien bien = new Bien(this.curTextField6.getText(), numeroFactura, this.procedenciaTextField5.getText(), '1', this.descripcionTextField7.getText(), TipoDeBien.COMPRA, Double.valueOf(this.valorTextField10.getText()), this.divisionTextField9.getText());
                registrarBien(bien);
            } else {
                JOptionPane.showMessageDialog(this, "No ha seleccionado un tipo de bien", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_agregarButtonActionPerformed

    private void actualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarButtonActionPerformed
        /*Actualizacion de un bien*/
        switch (bienSeleccionado.getTipo()) {
            case COMPRA:
                gestionarBienCompra("actualizar");
                break;
            case TRASLADO:
                gestionarBienTraslado("actualizar");
                break;
            case DONACION:
                gestionarBienDonacion("actualizar");
                break;
            default:
                throw new AssertionError();
        }


    }//GEN-LAST:event_actualizarButtonActionPerformed

    private void tipoBienComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBienComboBoxActionPerformed
        // TODO add your handling code here:

        String bien = this.tipoBienComboBox.getSelectedItem().toString();
        if (bien.equalsIgnoreCase("compra")) {
            bloquearCamposDonacion();
            bloquearCamposTraslado();
            //actualizar tabla de bienes por compra
            actualizarListadoObservable(controlador.consultarBienCompra());
        } else if (bien.equalsIgnoreCase("donación")) {
            habilitarCamposDonacion();
            bloquearCamposTraslado();
            //actualizar tabla de bienes por donacion
            actualizarListadoObservable(controlador.consultarBienDonacion());
        } else if (bien.equalsIgnoreCase("traslado")) {//Traslado
            habilitarCamposTraslado();
            bloquearCamposDonacion();
            //actualizar tabla de bienes por traslado
            actualizarListadoObservable(controlador.consultarBienTraslado());
        } else {
            habilitarCamposDonacion();
            habilitarCamposTraslado();
            //actualizar tabla de bienes
            actualizarListadoObservable(controlador.consultarBienes());
        }
    }//GEN-LAST:event_tipoBienComboBoxActionPerformed

    private void comboDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDivisionActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_comboDivisionActionPerformed

    private void comboDivisionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDivisionItemStateChanged
        // TODO add your handling code here:
        divisionTextField9.setText(String.valueOf(comboDivision.getSelectedItem()));
    }//GEN-LAST:event_comboDivisionItemStateChanged

    private void facturaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaButtonActionPerformed
        ListadoDeFacturasJDialog listado = new ListadoDeFacturasJDialog(null, true, this);
        listado.setVisible(true);
    }//GEN-LAST:event_facturaButtonActionPerformed
    public void bloquearCamposDonacion() {
        this.lbCorrelativo.setVisible(false);
        this.correlativoTextField12.setVisible(false);
        this.lbPunto.setVisible(false);
        this.puntoTextField13.setVisible(false);
        this.lbActa.setVisible(false);
        this.numeroActaTextField14.setVisible(false);
    }

    public void habilitarCamposDonacion() {
        this.lbCorrelativo.setVisible(true);
        this.correlativoTextField12.setVisible(true);
        this.lbPunto.setVisible(true);
        this.puntoTextField13.setVisible(true);
        this.lbActa.setVisible(true);
        this.numeroActaTextField14.setVisible(true);
    }

    public void bloquearCamposTraslado() {
        this.lbAutorizacion.setVisible(false);
        this.txtAutorizacion.setVisible(false);
        this.lbFecha.setVisible(false);
        this.fechajDateChooser1.setVisible(false);
        this.lbSeccion.setVisible(false);
        this.seccionTextField17.setVisible(false);
        this.lbEncargado.setVisible(false);
        this.receptorTextField16.setVisible(false);
    }

    public void habilitarCamposTraslado() {
        this.lbAutorizacion.setVisible(true);
        this.txtAutorizacion.setVisible(true);
        this.lbFecha.setVisible(true);
        this.fechajDateChooser1.setVisible(true);
        this.lbSeccion.setVisible(true);
        this.seccionTextField17.setVisible(true);
        this.lbEncargado.setVisible(true);
        this.receptorTextField16.setVisible(true);
    }

    public Bien getBienSeleccionado() {
        return bienSeleccionado;
    }

    public void setBienSeleccionado(Bien bienSeleccionado) {
        Bien anterior = this.bienSeleccionado;
        if (bienSeleccionado != null) { //si el bien seleccionado n0 es nulo
            if (bienSeleccionado.getTipo() == TipoDeBien.COMPRA) {
                this.bienSeleccionado = bienSeleccionado.cloneCompra();//se clona el bien en bienSeleccionado al momento de seleccionarlo 
            } else if (bienSeleccionado.getTipo() == TipoDeBien.DONACION) {
                this.bienSeleccionado = bienSeleccionado.cloneDonacion();//se clona el bien en bienSeleccionado al momento de seleccionarlo 
            } else if (bienSeleccionado.getTipo() == TipoDeBien.TRASLADO) {
                this.bienSeleccionado = bienSeleccionado.cloneTraslado();//se clona el bien en bienSeleccionado al momento de seleccionarlo 
                //Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(bienSeleccionado.getFecha());
                fechajDateChooser1.setDate(bienSeleccionado.getFecha());
                //txtFecha.setDateFormatString(String.valueOf(bienSeleccionado.getFecha()));
            }

            tempCUR = this.bienSeleccionado.getCur(); //se guarda el cui seleccionado en una variable temporal
            //.setEnabled(true);  //se habilita el boton al momento de ser seleccionado un empleado
        }
        firePropertyChange("bienSeleccionado", anterior, this.bienSeleccionado);
    }

    public void gestionarBienCompra(String tipo) {
        if (curTextField6.getText().isEmpty() || facturaTextField10.getText().isEmpty() || valorTextField10.getText().isEmpty() || procedenciaTextField5.getText().isEmpty() || divisionTextField9.getText().isEmpty()) {
            /*Error campos obligatorios*/
            JOptionPane.showMessageDialog(this, "Los campos marcados con (*) son obligatorios", "Error de Gestionamiento", JOptionPane.ERROR_MESSAGE);
        } else {
            Bien bien = new Bien(curTextField6.getText(), Integer.parseInt(facturaTextField10.getText()), procedenciaTextField5.getText(), '1', descripcionTextField7.getText(),
                    TipoDeBien.COMPRA, Double.parseDouble(valorTextField10.getText()), divisionTextField9.getText());
            if (tipo.equalsIgnoreCase("registro")) {
                if (controlador.registrarBien(bien)) {
                    JOptionPane.showMessageDialog(this, "Bien por compra con CUR: " + bien.getCur() + " registrado satisfactoriamente", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                if (controlador.actualizarBien(bien, tempCUR)) {
                    JOptionPane.showMessageDialog(this, "Bien por compra con CUR: " + bien.getCur() + " actualizado satisfactoriamente", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            actualizarListadoObservable(controlador.consultarBienCompra());
            /*no es lo mas optimo*/
        }
    }

    public void gestionarBienDonacion(String tipo) {
        if (curTextField6.getText().isEmpty() || facturaTextField10.getText().isEmpty() || valorTextField10.getText().isEmpty() || procedenciaTextField5.getText().isEmpty() || divisionTextField9.getText().isEmpty()
                || correlativoTextField12.getText().isEmpty() || puntoTextField13.getText().isEmpty() || numeroActaTextField14.getText().isEmpty()) {
            /*Error campos obligatorios*/
            JOptionPane.showMessageDialog(this, "Los campos marcados con (*) son obligatorios", "Error de Gestionamiento", JOptionPane.ERROR_MESSAGE);
        } else {
            Bien bien = new Bien(curTextField6.getText(), Integer.parseInt(facturaTextField10.getText()), procedenciaTextField5.getText(), '1', descripcionTextField7.getText(),
                    TipoDeBien.DONACION, Double.parseDouble(valorTextField10.getText()), divisionTextField9.getText(), Integer.parseInt(correlativoTextField12.getText()), puntoTextField13.getText(), Integer.parseInt(numeroActaTextField14.getText()));
            if (tipo.equalsIgnoreCase("registro")) {
                if (controlador.registrarBien(bien)) {
                    JOptionPane.showMessageDialog(this, "Bien por donacion con CUR: " + bien.getCur() + " registrado satisfactoriamente", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                if (controlador.actualizarBien(bien, tempCUR)) {
                    JOptionPane.showMessageDialog(this, "Bien por donación con CUR: " + bien.getCur() + " actualizado satisfactoriamente", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            actualizarListadoObservable(controlador.consultarBienDonacion());
            /*no es lo mas optimo*/
        }
    }

    public void gestionarBienTraslado(String tipo) {
        if (curTextField6.getText().isEmpty() || facturaTextField10.getText().isEmpty() || valorTextField10.getText().isEmpty() || procedenciaTextField5.getText().isEmpty() || divisionTextField9.getText().isEmpty()
                || receptorTextField16.getText().isEmpty() || txtAutorizacion.getText().isEmpty() || seccionTextField17.getText().isEmpty()) {
            /*Error campos obligatorios*/
            JOptionPane.showMessageDialog(this, "Los campos marcados con (*) son obligatorios", "Error de Gestionamiento", JOptionPane.ERROR_MESSAGE);
        } else {
            Timestamp fecha1 = new Timestamp(this.fechajDateChooser1.getDate().getTime());
            Bien bien = new Bien(curTextField6.getText(), Integer.parseInt(facturaTextField10.getText()), procedenciaTextField5.getText(), '1', descripcionTextField7.getText(),
                    TipoDeBien.TRASLADO, Double.parseDouble(valorTextField10.getText()), divisionTextField9.getText(), fecha1, '1', seccionTextField17.getText(), receptorTextField16.getText());
            if (tipo.equalsIgnoreCase("registro")) {
                if (controlador.registrarBien(bien)) {
                    JOptionPane.showMessageDialog(this, "Bien por traslado con CUR: " + bien.getCur() + " registrado satisfactoriamente", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                if (controlador.actualizarBien(bien, tempCUR)) {
                    JOptionPane.showMessageDialog(this, "Bien por traslado con CUR: " + bien.getCur() + " actualizado satisfactoriamente", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            actualizarListadoObservable(controlador.consultarBienTraslado());
            /*no es lo mas optimo*/
        }
    }

    public Vista getVista() {
        return vista;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarButton;
    private javax.swing.JButton agregarButton;
    private javax.swing.JComboBox<String> comboDivision;
    private javax.swing.JTextField correlativoTextField12;
    private javax.swing.JTextField curTextField6;
    private javax.swing.JTextArea descripcionTextField7;
    private javax.swing.JTextField divisionTextField9;
    private javax.swing.JButton facturaButton;
    private javax.swing.JFormattedTextField facturaTextField10;
    private com.toedter.calendar.JDateChooser fechajDateChooser1;
    private javax.swing.JButton inventarioButton;
    private javax.swing.JTextField inventarioTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbActa;
    private javax.swing.JLabel lbAutorizacion;
    private javax.swing.JLabel lbCorrelativo;
    private javax.swing.JLabel lbEncargado;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbPunto;
    private javax.swing.JLabel lbSeccion;
    private javax.swing.JTextField numeroActaTextField14;
    private javax.swing.JPanel panelValidacion;
    private javax.swing.JTextField procedenciaTextField5;
    private javax.swing.JTextField puntoTextField13;
    private javax.swing.JTextField receptorTextField16;
    private javax.swing.JTextField seccionTextField17;
    private javax.swing.JTable tablaBienes;
    private javax.swing.JComboBox<String> tipoBienComboBox;
    private javax.swing.JTextField txtAutorizacion;
    private javax.swing.JFormattedTextField valorTextField10;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void registrarBien(Bien bien) {
        if (controlador.registrarBien(bien)) {
            JOptionPane.showMessageDialog(this, "Se registro el bien");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo registrar el bien", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        this.curTextField6.setText("");
        this.descripcionTextField7.setText("");
        this.valorTextField10.setText("");
        this.divisionTextField9.setText("");
        this.procedenciaTextField5.setText("");
        this.facturaTextField10.setText("");
        this.factura = null;
        this.correlativoTextField12.setText("");
        this.puntoTextField13.setText("");
        this.numeroActaTextField14.setText("");
        this.seccionTextField17.setText("");
        this.receptorTextField16.setText("");
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public JFormattedTextField getFacturaTextField() {
        return facturaTextField10;
    }

    public void setFacturaTextField(JFormattedTextField facturaTextField) {
        this.facturaTextField10 = facturaTextField;
    }

}
