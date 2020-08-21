/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.frontend.encargados;
import com.toedter.calendar.JDateChooser;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import pss1inventarioscunoc.backend.controladores.ControladorEncargado;
import pss1inventarioscunoc.backend.enums.GrupoVista;
import pss1inventarioscunoc.backend.enums.Vista;
import pss1inventarioscunoc.backend.pojos.*;

/**
 *
 * @author fabricio
 */
public class AsignacionEncargados extends javax.swing.JPanel {

    public static String DEFAULT_TEXT_SIN_ASIGNAR = "Sin asignar";
    private Vista vista = Vista.ASIGNACION_ENCARGADOS;
    public List<Encargado> listaEncargados = null;
    public ObservableList<Encargado> listaEncargadosObsr = null;
    public List<Bien> listaBienes = null;
    public ObservableList<Bien> listaBienesObsr = null;
    private Encargado selectedEncargado = null;
    private Bien selectedBien = null;
    private ControladorEncargado controlador = null;
    private boolean tableEncargadosSelected = false;
    private boolean tableBienesSelected = false;

    
    /**
     * Creates new form ValidacionEncargado
     */
    public AsignacionEncargados() {
        this.iniciarlizar();
        this.initComponents();
        this.setName("Asignacion");
        this.actualizarLista();
        this.selectedBienLabel.setText(DEFAULT_TEXT_SIN_ASIGNAR);
        this.selectedEncargadoLabel.setText(DEFAULT_TEXT_SIN_ASIGNAR);
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        panelValidacion = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        asignarButton = new javax.swing.JButton();
        actualizarTablasButton = new javax.swing.JButton();
        limpiarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEncargados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBienes = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        fechaAperturaDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        noOrdenCompraTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        selectedBienLabel = new javax.swing.JLabel();
        selectedEncargadoLabel = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(51, 119, 180));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Asignación Bienes a Encargados");

        panelValidacion.setBackground(new java.awt.Color(51, 119, 180));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Tabla de Encargados");

        asignarButton.setBackground(new java.awt.Color(51, 204, 0));
        asignarButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        asignarButton.setText("ASIGNAR");
        asignarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        asignarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarButtonActionPerformed(evt);
            }
        });

        actualizarTablasButton.setBackground(new java.awt.Color(255, 153, 0));
        actualizarTablasButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        actualizarTablasButton.setText("ACTUALIZAR TABLAS");
        actualizarTablasButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        actualizarTablasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarTablasButtonActionPerformed(evt);
            }
        });

        limpiarButton.setBackground(new java.awt.Color(0, 204, 204));
        limpiarButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        limpiarButton.setText("LIMPIAR");
        limpiarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        limpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarButtonActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaEncargadosObsr}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tablaEncargados);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("DPI");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cargo}"));
        columnBinding.setColumnName("Cargo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${division}"));
        columnBinding.setColumnName("Division");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedEncargado}"), tablaEncargados, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        tablaEncargados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEncargadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEncargados);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaBienesObsr}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tablaBienes);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cur}"));
        columnBinding.setColumnName("Cur");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(pss1inventarioscunoc.backend.enums.TipoDeBien.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcion}"));
        columnBinding.setColumnName("Descripcion");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${procedencia}"));
        columnBinding.setColumnName("Procedencia");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${division}"));
        columnBinding.setColumnName("Division");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedBien}"), tablaBienes, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        tablaBienes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBienesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaBienes);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Bienes disponibles");

        fechaAperturaDateChooser.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Fecha Apertura*");

        noOrdenCompraTextField.setBackground(new java.awt.Color(255, 255, 255));
        noOrdenCompraTextField.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        noOrdenCompraTextField.setForeground(new java.awt.Color(0, 0, 102));
        noOrdenCompraTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("No. Orden de Compra");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Bien:");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Encargado:");

        selectedBienLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        selectedBienLabel.setText("Sin seleccionar");

        selectedEncargadoLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        selectedEncargadoLabel.setText("Sin seleccionar");

        javax.swing.GroupLayout panelValidacionLayout = new javax.swing.GroupLayout(panelValidacion);
        panelValidacion.setLayout(panelValidacionLayout);
        panelValidacionLayout.setHorizontalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValidacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addComponent(limpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(asignarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(40, 40, 40)
                                .addComponent(actualizarTablasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelValidacionLayout.createSequentialGroup()
                                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(fechaAperturaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(noOrdenCompraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelValidacionLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(selectedBienLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(selectedEncargadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValidacionLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(228, 228, 228))))
        );
        panelValidacionLayout.setVerticalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValidacionLayout.createSequentialGroup()
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(10, 10, 10)
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(noOrdenCompraTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(fechaAperturaDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValidacionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)
                                .addGap(12, 12, 12)))
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectedEncargadoLabel)
                            .addComponent(selectedBienLabel))))
                .addGap(26, 26, 26)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asignarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizarTablasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void actualizarLista(){
        this.controlador.actualizarEncargadosAsignacionEncargados(this);
        this.controlador.actualizarBienesAsignacionEncargados(this);
    }
    
    private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarButtonActionPerformed
        this.controlador.limpiarButtonAsignacionEncargados(this);
    }//GEN-LAST:event_limpiarButtonActionPerformed

    private void asignarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarButtonActionPerformed
        this.controlador.asignarButtonAsignacionEncargados(this);
    }//GEN-LAST:event_asignarButtonActionPerformed

    private void actualizarTablasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarTablasButtonActionPerformed
        this.actualizarLista();
    }//GEN-LAST:event_actualizarTablasButtonActionPerformed

    private void tablaEncargadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEncargadosMouseClicked
        this.controlador.tablaEncargadosMouseClickedAsignacionEncargados(this);
    }//GEN-LAST:event_tablaEncargadosMouseClicked

    private void tablaBienesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBienesMouseClicked
        this.controlador.tablaBienesMouseClickedAsignacionEncargados(this);
    }//GEN-LAST:event_tablaBienesMouseClicked


    public boolean isTableSelected() {
        return tableEncargadosSelected;
    }

    public void setTableSelected(boolean tableSelected) {
        this.tableEncargadosSelected = tableSelected;
    }

    public JButton getEliminarButton() {
        return actualizarTablasButton;
    }

    public JButton getActualizarButton() {
        return asignarButton;
    }

    public JButton getLimpiarButton() {
        return limpiarButton;
    }

    public List<Encargado> getListaEncargados() {
        return listaEncargados;
    }

    public void setListaEncargados(List<Encargado> listaEncargados) {
        this.listaEncargados = listaEncargados;
    }

    public ObservableList<Encargado> getListaEncargadosObsr() {
        return listaEncargadosObsr;
    }

    public void setListaEncargadosObsr(ObservableList<Encargado> listaEncargadosObsr) {
        this.listaEncargadosObsr = listaEncargadosObsr;
    }

    public List<Bien> getListaBienes() {
        return listaBienes;
    }

    public void setListaBienes(List<Bien> listaBienes) {
        this.listaBienes = listaBienes;
    }

    public ObservableList<Bien> getListaBienesObsr() {
        return listaBienesObsr;
    }

    public void setListaBienesObsr(ObservableList<Bien> listaBienesObsr) {
        this.listaBienesObsr = listaBienesObsr;
    }

    public Encargado getSelectedEncargado() {
        return selectedEncargado;
    }

    public void setSelectedEncargado(Encargado selectedEncargado) {
        this.selectedEncargado = selectedEncargado;
    }

    public Bien getSelectedBien() {
        return selectedBien;
    }

    public void setSelectedBien(Bien selectedBien) {
        this.selectedBien = selectedBien;
    }

    public JLabel getSelectedBienLabel() {
        return selectedBienLabel;
    }

    public JLabel getSelectedEncargadoLabel() {
        return selectedEncargadoLabel;
    }
    
    public Vista getVista(){
        return this.vista;
    }

    public boolean isTableEncargadosSelected() {
        return tableEncargadosSelected;
    }

    public void setTableEncargadosSelected(boolean tableEncargadoSelected) {
        this.tableEncargadosSelected = tableEncargadoSelected;
    }

    public boolean isTableBienesSelected() {
        return tableBienesSelected;
    }

    public void setTableBienesSelected(boolean tableBienesSelected) {
        this.tableBienesSelected = tableBienesSelected;
    }
    
    private void iniciarlizar(){
        this.controlador = new ControladorEncargado();
        this.listaEncargados = new LinkedList<>();
        this.listaEncargadosObsr = ObservableCollections.observableList(listaEncargados);
        this.listaBienes = new LinkedList<>();
        this.listaBienesObsr = ObservableCollections.observableList(listaBienes);
    }

    public JTextField getNoOrdenCompraTextField() {
        return noOrdenCompraTextField;
    }

    public void setNoOrdenCompraTextField(JTextField NoOrdenCompraTextField) {
        this.noOrdenCompraTextField = NoOrdenCompraTextField;
    }

    public JDateChooser getFechaAperturaDateChooser() {
        return fechaAperturaDateChooser;
    }

    public void setFechaAperturaDateChooser(JDateChooser fechaAperturaDateChooser) {
        this.fechaAperturaDateChooser = fechaAperturaDateChooser;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarTablasButton;
    private javax.swing.JButton asignarButton;
    private com.toedter.calendar.JDateChooser fechaAperturaDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JTextField noOrdenCompraTextField;
    private javax.swing.JPanel panelValidacion;
    private javax.swing.JLabel selectedBienLabel;
    private javax.swing.JLabel selectedEncargadoLabel;
    private javax.swing.JTable tablaBienes;
    private javax.swing.JTable tablaEncargados;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
