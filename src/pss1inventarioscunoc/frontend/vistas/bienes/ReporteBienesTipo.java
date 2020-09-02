/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.frontend.vistas.bienes;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import pss1inventarioscunoc.backend.bd.Conexion;
import pss1inventarioscunoc.backend.controladores.ControladorBien;
import pss1inventarioscunoc.backend.controladores.ControladorInventario;
import pss1inventarioscunoc.backend.controladores.ControladorReporte;
import pss1inventarioscunoc.backend.enums.Vista;
import pss1inventarioscunoc.backend.pojos.Bien;
import pss1inventarioscunoc.backend.pojos.Factura;
import pss1inventarioscunoc.frontend.vistas.VentanaInicio;
import pss1inventarioscunoc.frontend.vistas.inventarios.ListarInventariosJdialog;

/**
 *
 * @author bryan
 */
public class ReporteBienesTipo extends javax.swing.JPanel {
    private List<Bien> listadoBienes;
    private ObservableList<Bien> listadoBienesObservable;
    private ControladorBien controlador;
    private Map<String,Object> map;
    private ControladorReporte controladorReporte;
    
    private char estadoActivo;
    private char estadoInactivo;
    private Vista vista = Vista.REPORTE_BIENES_TIPO;
    /**
     * Creates new form PanelExportacionBienes
     */
    public ReporteBienesTipo() {
        this.listadoBienes = new ArrayList<>();
        this.listadoBienesObservable = ObservableCollections.observableList(listadoBienes);
        /*instanciando controlador de bienes para recuperar la lista*/
        this.controlador = new ControladorBien();
        
        this.estadoActivo = '1'; //estado por defecto sino es por baja
        this.estadoInactivo = '0'; //estado por defecto sino es por baja
        /*Actualizar tabla una vez entrando a la ventana*/
        actualizarListadoObservable(controlador.consultarBienCompra(this.estadoActivo));
        initComponents();
        this.setName("Reporte de Bienes por Tipo");
        
        this.inventarioTextField.setText(ControladorInventario.INVENTARIO_ACTUAL.getDescripcion());
        this.map = new HashMap<String, Object>();
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
        agregarButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        inventarioTextField = new javax.swing.JTextField();
        lbFecha = new javax.swing.JLabel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        lbFecha1 = new javax.swing.JLabel();
        fechaFin = new com.toedter.calendar.JDateChooser();

        jPanel1.setBackground(new java.awt.Color(51, 119, 180));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reportes de Bienes por Tipo");

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
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcion}"));
        columnBinding.setColumnName("Descripcion");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(pss1inventarioscunoc.backend.enums.TipoDeBien.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${division}"));
        columnBinding.setColumnName("Division");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valor}"));
        columnBinding.setColumnName("Valor");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${correlativo}"));
        columnBinding.setColumnName("Correlativo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${punto}"));
        columnBinding.setColumnName("Punto");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${seccion}"));
        columnBinding.setColumnName("Seccion");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numeroActa}"));
        columnBinding.setColumnName("Numero Acta");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${autorizacion}"));
        columnBinding.setColumnName("Autorizacion");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fecha}"));
        columnBinding.setColumnName("Fecha");
        columnBinding.setColumnClass(java.sql.Timestamp.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${personaQueRecibio}"));
        columnBinding.setColumnName("Persona Que Recibio");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
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

        agregarButton.setBackground(new java.awt.Color(51, 204, 0));
        agregarButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        agregarButton.setForeground(new java.awt.Color(255, 255, 255));
        agregarButton.setText("Generar Reporte");
        agregarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tipo *");

        inventarioTextField.setEditable(false);
        inventarioTextField.setBackground(new java.awt.Color(255, 255, 255));

        lbFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(255, 255, 255));
        lbFecha.setText("Desde *");

        lbFecha1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbFecha1.setForeground(new java.awt.Color(255, 255, 255));
        lbFecha1.setText("Hasta *");

        javax.swing.GroupLayout panelValidacionLayout = new javax.swing.GroupLayout(panelValidacion);
        panelValidacion.setLayout(panelValidacionLayout);
        panelValidacionLayout.setHorizontalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValidacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addComponent(lbFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addComponent(inventarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inventarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelValidacionLayout.createSequentialGroup()
                                .addComponent(lbFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(agregarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(fechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoBienComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(430, Short.MAX_VALUE))
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(panelValidacionLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(115, 115, 115))
        );
        panelValidacionLayout.setVerticalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValidacionLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tipoBienComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFecha)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFecha1)
                    .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addGap(233, 233, 233))
        );

        jScrollPane3.setViewportView(panelValidacion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoBienComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBienComboBoxActionPerformed
        // TODO add your handling code here:

        String bien = this.tipoBienComboBox.getSelectedItem().toString();
        if (bien.equalsIgnoreCase("compra")) {
            //actualizar tabla de bienes por compra
            actualizarListadoObservable(controlador.consultarBienCompra(this.estadoActivo));
        } else if (bien.equalsIgnoreCase("donación")) {
           
            //actualizar tabla de bienes por donacion
            actualizarListadoObservable(controlador.consultarBienDonacion(this.estadoActivo));
        } else if (bien.equalsIgnoreCase("traslado")) {//Traslado
            //actualizar tabla de bienes por traslado
            actualizarListadoObservable(controlador.consultarBienTraslado(this.estadoActivo));
        } else {
            //actualizar tabla de bienes
            actualizarListadoObservable(controlador.consultarBienes(this.estadoActivo));
        }

        
    }//GEN-LAST:event_tipoBienComboBoxActionPerformed
    
    private void inventarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioButtonActionPerformed
        ListarInventariosJdialog inventarios = new ListarInventariosJdialog(null, true);
        inventarios.setVisible(true);
        if (ControladorInventario.INVENTARIO_ACTUAL != null) {
            this.inventarioTextField.setText(ControladorInventario.INVENTARIO_ACTUAL.getDescripcion());
        }
    }//GEN-LAST:event_inventarioButtonActionPerformed

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        //parametros a enviar
        if (validarParametrosEnviar()) {
            try {
                //generando primer reporte
                String bien = this.tipoBienComboBox.getSelectedItem().toString();
                if (bien.equalsIgnoreCase("compra")) {
                    //generar reporte
                    this.controladorReporte = new ControladorReporte("Templates_Reports/ReporteBienesCompra.jasper", "Reporte de Bienes por compra", map);
                    this.controladorReporte.visualizarReporte();
                    //actualizar tabla de bienes por compra
                    actualizarListadoObservable(controlador.consultarBienCompra(this.estadoActivo));
                } else if (bien.equalsIgnoreCase("donación")) {
                    //generar reporte
                    this.controladorReporte = new ControladorReporte("Templates_Reports/ReporteBienesDonacion.jasper", "Reporte de Bienes por Donación", map);
                    this.controladorReporte.visualizarReporte();
                    //actualizar tabla de bienes por donacion
                    actualizarListadoObservable(controlador.consultarBienDonacion(this.estadoActivo));
                } else if (bien.equalsIgnoreCase("traslado")) {//Traslado
                    //generar reporte
                    this.controladorReporte = new ControladorReporte("Templates_Reports/ReporteBienesTraslado.jasper", "Reporte de Bienes por Traslado", map);
                    this.controladorReporte.visualizarReporte();
                    //actualizar tabla de bienes por traslado
                    actualizarListadoObservable(controlador.consultarBienTraslado(this.estadoActivo));
                } else {
                    //generar reporte
                    this.controladorReporte = new ControladorReporte("Templates_Reports/ReporteBienes.jasper", "Reporte de Bienes", map);
                    this.controladorReporte.visualizarReporte();
                    //actualizar tabla de bienes
                    actualizarListadoObservable(controlador.consultarBienes(this.estadoActivo));
                }
            } catch (JRException ex) {
                Logger.getLogger(VentanaInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_agregarButtonActionPerformed
    
    public boolean validarParametrosEnviar(){
        if (fechaInicio.getDate()!=null && fechaFin.getDate()!=null) {
            //validar las fechas
            Timestamp fecha1 = new Timestamp(this.fechaInicio.getDate().getTime());
            Timestamp fecha2 = new Timestamp(this.fechaFin.getDate().getTime());
            if (fecha1.before(fecha2)) {
                String numInventario = String.valueOf(ControladorInventario.INVENTARIO_ACTUAL.getNumero());
                String estado = String.valueOf(this.estadoActivo);
                String tipo = this.tipoBienComboBox.getSelectedItem().toString();
                String fechaIni= fecha1.toString();
                String fechaF= fecha2.toString();
                String logo= "src/pss1inventarioscunoc/frontend/media/logo-inventarios.jpg";
                String info= "Inventario No."+ControladorInventario.INVENTARIO_ACTUAL.getNumero()+": "+ControladorInventario.INVENTARIO_ACTUAL.getDescripcion();

                map.put("pmNumInventario", numInventario);
                map.put("pmEstado", estado);
                map.put("pmTipo", tipo);
                map.put("pmFechaInicio", fechaIni);
                map.put("pmFechaFin", fechaF);
                map.put("pmLogo", logo);
                map.put("pmInfoInventario", info);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarButton;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JButton inventarioButton;
    private javax.swing.JTextField inventarioTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbFecha1;
    private javax.swing.JPanel panelValidacion;
    private javax.swing.JTable tablaBienes;
    private javax.swing.JComboBox<String> tipoBienComboBox;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
