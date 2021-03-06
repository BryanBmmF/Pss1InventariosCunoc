/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.frontend.tarjetasresponsabilidad;
import pss1inventarioscunoc.frontend.encargados.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import pss1inventarioscunoc.backend.controladores.ControladorEncargado;
import pss1inventarioscunoc.backend.controladores.ControladorTarjetaResponsabilidad;
import pss1inventarioscunoc.backend.enums.GrupoVista;
import pss1inventarioscunoc.backend.enums.Vista;
import pss1inventarioscunoc.backend.pojos.Encargado;
import pss1inventarioscunoc.backend.pojos.TarjetaResponsabilidad;

/**
 *
 * @author fabricio
 */
public class reporteTarjetasResponsabilidad extends javax.swing.JPanel {

    private Vista vista = Vista.REPORTE_TARJETAS_RESPONSABILIDAD;
    public List<TarjetaResponsabilidad> listadoTarjetaResponsabilidades = null;
    public ObservableList<TarjetaResponsabilidad> listaTarjetaResponsabilidadesObsr = null;
    private TarjetaResponsabilidad selectedTarjetaResp = null;
    private ControladorTarjetaResponsabilidad controlador = null;
    private boolean tableSelected = false;

    
    /**
     * Creates new form ValidacionEncargado
     */
    public reporteTarjetasResponsabilidad() {
        this.listadoTarjetaResponsabilidades = new LinkedList<>();
        this.listaTarjetaResponsabilidadesObsr = ObservableCollections.observableList(
                listadoTarjetaResponsabilidades);
        this.controlador = new ControladorTarjetaResponsabilidad();
        initComponents();
        this.setName("Reporte");
        this.actualizarLista();
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
        actualizarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTarjetasResponsabilidad = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(51, 119, 180));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Reporte de Tarjetas");

        panelValidacion.setBackground(new java.awt.Color(51, 119, 180));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Tarjetas de Responsabilidad");

        actualizarButton.setBackground(new java.awt.Color(255, 153, 0));
        actualizarButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        actualizarButton.setText("ACTUALIZAR");
        actualizarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        actualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarButtonActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaTarjetaResponsabilidadesObsr}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tablaTarjetasResponsabilidad);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${curBien}"));
        columnBinding.setColumnName("Bien");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcion}"));
        columnBinding.setColumnName("Descripcion");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaApertura}"));
        columnBinding.setColumnName("Apertura");
        columnBinding.setColumnClass(java.sql.Timestamp.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noFactura}"));
        columnBinding.setColumnName("Factura");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idResponsable}"));
        columnBinding.setColumnName("Responsable");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProveedor}"));
        columnBinding.setColumnName("Proveedor");
        columnBinding.setColumnClass(Long.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedTarjetaResp}"), tablaTarjetasResponsabilidad, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        tablaTarjetasResponsabilidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTarjetasResponsabilidadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTarjetasResponsabilidad);

        javax.swing.GroupLayout panelValidacionLayout = new javax.swing.GroupLayout(panelValidacion);
        panelValidacion.setLayout(panelValidacionLayout);
        panelValidacionLayout.setHorizontalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValidacionLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(actualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        panelValidacionLayout.setVerticalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValidacionLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(actualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void actualizarLista(){
        this.controlador.actualizarTarjetasResponsabilidadReporteTarjetasResponsabilidad(this);
    }
    
    private void actualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarButtonActionPerformed
        this.controlador.actualizarTarjetasResponsabilidadReporteTarjetasResponsabilidad(this);
    }//GEN-LAST:event_actualizarButtonActionPerformed

    private void tablaTarjetasResponsabilidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTarjetasResponsabilidadMouseClicked
//        this.controlador.tablaEncargadosMouseClickedValidacionEncargados(this);
    }//GEN-LAST:event_tablaTarjetasResponsabilidadMouseClicked


    public boolean isTableSelected() {
        return tableSelected;
    }

    public void setTableSelected(boolean tableSelected) {
        this.tableSelected = tableSelected;
    }

    public JButton getActualizarButton() {
        return actualizarButton;
    }

    public TarjetaResponsabilidad getSelectedTarjetaResp() {
        return selectedTarjetaResp;
    }

    public void setSelectedTarjetaResp(TarjetaResponsabilidad selectedTarjetaResp) {
        this.selectedTarjetaResp = selectedTarjetaResp;
    }
   
    public Vista getVista(){
        return this.vista;
    }

    public List<TarjetaResponsabilidad> getListadoTarjetaResponsabilidades() {
        return listadoTarjetaResponsabilidades;
    }

    public void setListadoTarjetaResponsabilidades(List<TarjetaResponsabilidad> listadoTarjetaResponsabilidades) {
        this.listadoTarjetaResponsabilidades = listadoTarjetaResponsabilidades;
    }

    public ObservableList<TarjetaResponsabilidad> getListaTarjetaResponsabilidadesObsr() {
        return listaTarjetaResponsabilidadesObsr;
    }

    public void setListaTarjetaResponsabilidadesObsr(ObservableList<TarjetaResponsabilidad> listaTarjetaResponsabilidadesObsr) {
        this.listaTarjetaResponsabilidadesObsr = listaTarjetaResponsabilidadesObsr;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelValidacion;
    private javax.swing.JTable tablaTarjetasResponsabilidad;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
