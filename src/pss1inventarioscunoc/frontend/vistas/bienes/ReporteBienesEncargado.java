/*
 * Vista para generar Reportes de bienes segun encargado
 */
package pss1inventarioscunoc.frontend.vistas.bienes;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import pss1inventarioscunoc.backend.controladores.ControladorEncargado;
import pss1inventarioscunoc.backend.controladores.ControladorReporte;
import pss1inventarioscunoc.backend.controladores.ControladorTarjetaResponsabilidad;
import pss1inventarioscunoc.backend.enums.Vista;
import pss1inventarioscunoc.backend.pojos.Encargado;
import pss1inventarioscunoc.backend.pojos.TarjetaResponsabilidad;
import static pss1inventarioscunoc.frontend.tarjetasresponsabilidad.ModificacionTarjetaResponsabilidad.DEFAULT_TEXT_SIN_ASIGNAR;

/**
 *
 * @author bryan
 */
public class ReporteBienesEncargado extends javax.swing.JPanel {
    private Vista vista = Vista.REPORTE_BIENES_ENCARGADO;
    public LinkedList<Encargado> listaEncargados = null;
    public ObservableList<Encargado> listaEncargadosObsr = null;
    public LinkedList<TarjetaResponsabilidad> listaTarjetas = null;
    public ObservableList<TarjetaResponsabilidad> listaTarjetasObsr = null;
    private Encargado selectedEncargado = null;
    private TarjetaResponsabilidad selectedTarjeta = null;
    private ControladorEncargado controladorEncargado = null;
    private ControladorTarjetaResponsabilidad controladorTarjeta = null;
    private boolean tableEncargadosSelected = false;
    private boolean tableTarjetasSelected = false;
    
    private Map<String,Object> map;
    private ControladorReporte controladorReporte;
    /**
     * Creates new form ReporteBienesEncargado
     */
    public ReporteBienesEncargado() {
        this.iniciarlizar();
        this.initComponents();
        this.setName("Reporte de Bienes por Encargado");
        this.actualizarLista();
        
        this.selectedEncargadoLabel.setText(DEFAULT_TEXT_SIN_ASIGNAR);
        this.map = new HashMap<String, Object>();
        
    }
    private void iniciarlizar(){
        this.controladorEncargado = new ControladorEncargado();
        this.controladorTarjeta = new ControladorTarjetaResponsabilidad();
        this.listaEncargados = new LinkedList<>();
        this.listaEncargadosObsr = ObservableCollections.observableList(listaEncargados);
        this.listaTarjetas = new LinkedList<>();
        this.listaTarjetasObsr = ObservableCollections.observableList(listaTarjetas);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        panelValidacion = new javax.swing.JPanel();
        genararReporteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEncargado = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTarjetas = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        lbFecha1 = new javax.swing.JLabel();
        fechaFin = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        selectedEncargadoLabel = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(51, 119, 180));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Reporte de Bienes por Encargado");

        panelValidacion.setBackground(new java.awt.Color(51, 119, 180));

        genararReporteButton.setBackground(new java.awt.Color(255, 153, 0));
        genararReporteButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        genararReporteButton.setText("Generar Reporte");
        genararReporteButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        genararReporteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genararReporteButtonActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaEncargadosObsr}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tablaEncargado);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${apellido}"));
        columnBinding.setColumnName("Apellido");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cargo}"));
        columnBinding.setColumnName("Cargo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${division}"));
        columnBinding.setColumnName("Division");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedEncargado}"), tablaEncargado, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        tablaEncargado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEncargadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEncargado);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaTarjetasObsr}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tablaTarjetas);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${curBien}"));
        columnBinding.setColumnName("Cur Bien");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcion}"));
        columnBinding.setColumnName("Descripcion");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaApertura}"));
        columnBinding.setColumnName("Fecha Apertura");
        columnBinding.setColumnClass(java.sql.Timestamp.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaFactura}"));
        columnBinding.setColumnName("Fecha Factura");
        columnBinding.setColumnClass(java.sql.Timestamp.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProveedor}"));
        columnBinding.setColumnName("Id Proveedor");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idResponsable}"));
        columnBinding.setColumnName("Id Responsable");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noFactura}"));
        columnBinding.setColumnName("No Factura");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noOrdenCompra}"));
        columnBinding.setColumnName("No Orden Compra");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noSerie}"));
        columnBinding.setColumnName("No Serie");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noSolicitudCompra}"));
        columnBinding.setColumnName("No Solicitud Compra");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        tablaTarjetas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTarjetasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaTarjetas);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Listado de Bienes Asignados");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Listado de Encargados");

        lbFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(255, 255, 255));
        lbFecha.setText("Desde *");

        lbFecha1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbFecha1.setForeground(new java.awt.Color(255, 255, 255));
        lbFecha1.setText("Hasta *");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Encargado:");

        selectedEncargadoLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        selectedEncargadoLabel.setText("Sin seleccionar");

        javax.swing.GroupLayout panelValidacionLayout = new javax.swing.GroupLayout(panelValidacion);
        panelValidacion.setLayout(panelValidacionLayout);
        panelValidacionLayout.setHorizontalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValidacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValidacionLayout.createSequentialGroup()
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelValidacionLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(selectedEncargadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbFecha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(genararReporteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        panelValidacionLayout.setVerticalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValidacionLayout.createSequentialGroup()
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectedEncargadoLabel)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGap(0, 55, Short.MAX_VALUE)
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFecha1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genararReporteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panelValidacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelValidacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
    public void actualizarLista(){
        this.controladorEncargado.actualizarEncargados(this);
        //this.controladorTarjeta.actualizarTarjetasResponsabilidad(this);
    }
    
    private void genararReporteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genararReporteButtonActionPerformed
        //this.actualizarLista();
        if (validarParametrosEnviar()) {
            if (!getSelectedEncargadoLabel().getText().equalsIgnoreCase(DEFAULT_TEXT_SIN_ASIGNAR)) {
               try {
                    //generar reporte
                    this.controladorReporte = new ControladorReporte("Templates_Reports/ReporteBienesEncargado.jasper", "Reporte de Bienes por Encargado", map);
                    this.controladorReporte.visualizarReporte();
                } catch (JRException ex) {
                    Logger.getLogger(ReporteBienesEncargado.class.getName()).log(Level.SEVERE, null, ex);
                } 
            } else {
                JOptionPane.showMessageDialog(this, "Porfavor selecciona un encargado de la lista para generar el reporte", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
       
    }//GEN-LAST:event_genararReporteButtonActionPerformed

    private void tablaEncargadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEncargadoMouseClicked
        this.controladorEncargado.tablaEncargadosMouseClicked(this);
        //actualizar tabla de tarjetas de responsabilidad segun el encargado seleccionado
        this.controladorTarjeta.actualizarTarjetasResponsabilidad(this,this.getSelectedEncargadoLabel().getText());
    }//GEN-LAST:event_tablaEncargadoMouseClicked

    private void tablaTarjetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTarjetasMouseClicked
        
    }//GEN-LAST:event_tablaTarjetasMouseClicked
    public boolean validarParametrosEnviar(){
        if (fechaInicio.getDate()!=null && fechaFin.getDate()!=null) {
            //validar las fechas
            Timestamp fecha1 = new Timestamp(this.fechaInicio.getDate().getTime());
            Timestamp fecha2 = new Timestamp(this.fechaFin.getDate().getTime());
            if (fecha1.before(fecha2)) {
                String fechaIni= fecha1.toString();
                String fechaF= fecha2.toString();
                String logo= "src/pss1inventarioscunoc/frontend/media/logo-inventarios.jpg";
                String idEncargado= this.getSelectedEncargadoLabel().getText();
                map.put("pmFechaInicio", fechaIni);
                map.put("pmFechaFin", fechaF);
                map.put("pmLogo", logo);
                map.put("pmIdEncargado", idEncargado);
                return true;
            } else {
                return false;
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Porfavor verifíque los rangos de fecha, al parecer no son correctos o no se han especificado", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
    }
    public Vista getVista() {
        return vista;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }

    public LinkedList<Encargado> getListaEncargados() {
        return listaEncargados;
    }

    public void setListaEncargados(LinkedList<Encargado> listaEncargados) {
        this.listaEncargados = listaEncargados;
    }

    public ObservableList<Encargado> getListaEncargadosObsr() {
        return listaEncargadosObsr;
    }

    public void setListaEncargadosObsr(ObservableList<Encargado> listaEncargadosObsr) {
        this.listaEncargadosObsr = listaEncargadosObsr;
    }

    public LinkedList<TarjetaResponsabilidad> getListaTarjetas() {
        return listaTarjetas;
    }

    public void setListaTarjetas(LinkedList<TarjetaResponsabilidad> listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
    }

    public ObservableList<TarjetaResponsabilidad> getListaTarjetasObsr() {
        return listaTarjetasObsr;
    }

    public void setListaTarjetasObsr(ObservableList<TarjetaResponsabilidad> listaTarjetasObsr) {
        this.listaTarjetasObsr = listaTarjetasObsr;
    }

    public Encargado getSelectedEncargado() {
        return selectedEncargado;
    }

    public void setSelectedEncargado(Encargado selectedEncargado) {
        this.selectedEncargado = selectedEncargado;
    }

    public TarjetaResponsabilidad getSelectedTarjeta() {
        return selectedTarjeta;
    }

    public void setSelectedTarjeta(TarjetaResponsabilidad selectedTarjeta) {
        this.selectedTarjeta = selectedTarjeta;
    }

    public JLabel getSelectedEncargadoLabel() {
        return selectedEncargadoLabel;
    }

    public void setSelectedEncargadoLabel(JLabel selectedEncargadoLabel) {
        this.selectedEncargadoLabel = selectedEncargadoLabel;
    }

    public boolean isTableEncargadosSelected() {
        return tableEncargadosSelected;
    }

    public void setTableEncargadosSelected(boolean tableEncargadosSelected) {
        this.tableEncargadosSelected = tableEncargadosSelected;
    }

    public boolean isTableTarjetasSelected() {
        return tableTarjetasSelected;
    }

    public void setTableTarjetasSelected(boolean tableTarjetasSelected) {
        this.tableTarjetasSelected = tableTarjetasSelected;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JButton genararReporteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbFecha1;
    private javax.swing.JPanel panelValidacion;
    private javax.swing.JLabel selectedEncargadoLabel;
    private javax.swing.JTable tablaEncargado;
    private javax.swing.JTable tablaTarjetas;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
