/*
 * Ventana de manejo de usuarios
 */
package pss1inventarioscunoc.frontend.sesion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import pss1inventarioscunoc.backend.controladores.ControladorBien;
import pss1inventarioscunoc.backend.controladores.ControladorUser;
import pss1inventarioscunoc.backend.enums.Vista;
import pss1inventarioscunoc.backend.pojos.Bien;
import pss1inventarioscunoc.backend.pojos.Usuario;

/**
 *
 * @author bryan
 */
public class VentanaUsuarios extends javax.swing.JPanel {
    private Vista vista = Vista.MANEJO_USUARIOS;
    private List<Usuario> listadoUsuarios;
    private ObservableList<Usuario> listadoUsuariosObservable;
    private ControladorUser controlador;
    private Usuario usuarioSeleccionado;
    private String tempUser;
    private boolean mostrarContra;
    /**
     * Creates new form VentanaUsuarios
     */
    public VentanaUsuarios() {
        this.setName("Gestión de Usuarios");
        this.listadoUsuarios = new ArrayList<>();
        this.listadoUsuariosObservable = ObservableCollections.observableList(listadoUsuarios);
        /*instanciando controlador de bienes para recuperar la lista*/
        this.controlador = new ControladorUser();
        this.usuarioSeleccionado = new Usuario();
        /*Actualizar tabla una vez entrando a la ventana*/
        actualizarListadoObservable(controlador.busquedaUsuarios());
        this.mostrarContra=false;
       
        initComponents();
        btnHabilitar.setEnabled(false);
        btnDeshabilitar.setEnabled(false);
        btnActualizarPass.setEnabled(false);
        
        
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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBienes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnHabilitar = new javax.swing.JButton();
        btnDeshabilitar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnActualizarPass = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();

        jPanel1.setBackground(new java.awt.Color(51, 119, 180));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consulta de Usuarios del Sistema");

        panelValidacion.setBackground(new java.awt.Color(51, 119, 180));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuarios Registrados");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listadoUsuariosObservable}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tablaBienes);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id_usuario}"));
        columnBinding.setColumnName("Id_usuario");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${correoElectronico}"));
        columnBinding.setColumnName("Correo Electronico");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${usuarioSeleccionado}"), tablaBienes, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(tablaBienes);

        jButton1.setBackground(new java.awt.Color(255, 153, 102));
        jButton1.setText("ver");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(0, 204, 204));
        btnRegistrar.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar Nuevo");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtUser.setEditable(false);
        txtUser.setBackground(new java.awt.Color(255, 255, 255));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${usuarioSeleccionado.id_usuario}"), txtUser, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Usuario *:");

        btnHabilitar.setBackground(new java.awt.Color(51, 204, 0));
        btnHabilitar.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnHabilitar.setForeground(new java.awt.Color(255, 255, 255));
        btnHabilitar.setText("Habilitar");
        btnHabilitar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilitarActionPerformed(evt);
            }
        });

        btnDeshabilitar.setBackground(new java.awt.Color(204, 0, 0));
        btnDeshabilitar.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnDeshabilitar.setText("Deshabilitar");
        btnDeshabilitar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDeshabilitar.setEnabled(false);
        btnDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshabilitarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nueva Contraseña *:");

        btnActualizarPass.setBackground(new java.awt.Color(0, 204, 204));
        btnActualizarPass.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnActualizarPass.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarPass.setText("Actualizar Contraseña");
        btnActualizarPass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnActualizarPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelValidacionLayout = new javax.swing.GroupLayout(panelValidacion);
        panelValidacion.setLayout(panelValidacionLayout);
        panelValidacionLayout.setHorizontalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValidacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelValidacionLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelValidacionLayout.createSequentialGroup()
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnActualizarPass, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 285, Short.MAX_VALUE))
        );
        panelValidacionLayout.setVerticalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValidacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(38, 38, 38)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(295, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(panelValidacion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addContainerGap(373, Short.MAX_VALUE))
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
    
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // habilitando pantalla de registro
        VentanaRegistro ventanaRegistro = new VentanaRegistro(this);
        ventanaRegistro.setAlwaysOnTop(true); //modal
        ventanaRegistro.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //evento de salida cerrar solo ventana actual
        ventanaRegistro.setVisible(true);

    }//GEN-LAST:event_btnRegistrarActionPerformed
     //recibe una lista empleados
    public void actualizarListadoObservable(List<Usuario> listadoUsuarios) {
        this.listadoUsuariosObservable.clear();//se limpia la lista
        this.listadoUsuariosObservable.addAll(listadoUsuarios); //se agreaga a la lista observable la lista recibida
    }

    public List<Usuario> getListadoUsuarios() {
        return listadoUsuarios;
    }

    public void setListadoUsuarios(List<Usuario> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }

    public ObservableList<Usuario> getListadoUsuariosObservable() {
        return listadoUsuariosObservable;
    }

    public void setListadoUsuariosObservable(ObservableList<Usuario> listadoUsuariosObservable) {
        this.listadoUsuariosObservable = listadoUsuariosObservable;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public ControladorUser getControlador() {
        return controlador;
    }

    public void setControlador(ControladorUser controlador) {
        this.controlador = controlador;
    }
    
    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        Usuario anterior = this.usuarioSeleccionado;
        if (usuarioSeleccionado != null) { //si el usuario seleccionado n0 es nulo
            this.usuarioSeleccionado = usuarioSeleccionado.clone();//se clona el usuario en bienSeleccionado al momento de seleccionarlo 

            tempUser = this.usuarioSeleccionado.getId_usuario(); //se guarda el user seleccionado en una variable temporal
            btnHabilitar.setEnabled(true);
            btnDeshabilitar.setEnabled(true);
            btnActualizarPass.setEnabled(true);
            
        }
        firePropertyChange("usuarioSeleccionado", anterior, this.usuarioSeleccionado);
    }
    
    
    
    private void btnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarActionPerformed
       
        if(usuarioSeleccionado!=null) {
            if (!usuarioSeleccionado.getEstado().equalsIgnoreCase("activo")) {
                controlador.actualizar(new Usuario(usuarioSeleccionado.getId_usuario(), usuarioSeleccionado.getNombre(), "",
                        usuarioSeleccionado.getContrasena(), "activo", usuarioSeleccionado.getTipo(), usuarioSeleccionado.getCorreoElectronico()),tempUser);
                actualizarListadoObservable(controlador.busquedaUsuarios());
            } else{
                JOptionPane.showMessageDialog(null, "El usuario: "+usuarioSeleccionado.getId_usuario()+" ya esta habilitado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione primero un usuario de la lista para habilitarlo", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        btnHabilitar.setEnabled(false);
        btnDeshabilitar.setEnabled(false);
        btnActualizarPass.setEnabled(false);

    }//GEN-LAST:event_btnHabilitarActionPerformed

    private void btnDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshabilitarActionPerformed
        if(usuarioSeleccionado!=null) {
            if (!usuarioSeleccionado.getEstado().equalsIgnoreCase("inactivo")) {
                controlador.actualizar(new Usuario(usuarioSeleccionado.getId_usuario(), usuarioSeleccionado.getNombre(), "",
                        usuarioSeleccionado.getContrasena(), "inactivo", usuarioSeleccionado.getTipo(), usuarioSeleccionado.getCorreoElectronico()),tempUser);
                actualizarListadoObservable(controlador.busquedaUsuarios());
            } else{
                JOptionPane.showMessageDialog(null, "El usuario: "+usuarioSeleccionado.getId_usuario()+" ya esta deshabilitado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione primero un usuario de la lista para deshabilitarlo", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        btnHabilitar.setEnabled(false);
        btnDeshabilitar.setEnabled(false);
        btnActualizarPass.setEnabled(false);
    }//GEN-LAST:event_btnDeshabilitarActionPerformed

    private void btnActualizarPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPassActionPerformed
        // TODO add your handling code here:
        if(usuarioSeleccionado!=null) {
            if (!String.valueOf(txtPass.getPassword()).isEmpty()) {
                controlador.actualizar(new Usuario(usuarioSeleccionado.getId_usuario(), usuarioSeleccionado.getNombre(), "",
                        String.valueOf(txtPass.getPassword()), usuarioSeleccionado.getEstado(), usuarioSeleccionado.getTipo(), usuarioSeleccionado.getCorreoElectronico()),tempUser);
                actualizarListadoObservable(controlador.busquedaUsuarios());
            } else{
                JOptionPane.showMessageDialog(null, "Porfavor ingrese una nueva contraseña para realizar el cambio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione primero un usuario de la lista para actualizar su contraseña", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        btnHabilitar.setEnabled(false);
        btnDeshabilitar.setEnabled(false);
        btnActualizarPass.setEnabled(false);
    }//GEN-LAST:event_btnActualizarPassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.mostrarContra == false) {
            this.txtPass.setEchoChar((char) 0);
            this.mostrarContra = true;
        } else {
            this.txtPass.setEchoChar('*');
            this.mostrarContra = false;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public Vista getVista() {
        return vista;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarPass;
    private javax.swing.JButton btnDeshabilitar;
    private javax.swing.JButton btnHabilitar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelValidacion;
    private javax.swing.JTable tablaBienes;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
