/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.frontend.encargados;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import pss1inventarioscunoc.backend.controladores.ControladorEncargado;
import pss1inventarioscunoc.backend.enums.EstadoUsuario;
import pss1inventarioscunoc.backend.enums.GrupoVista;
import pss1inventarioscunoc.backend.enums.Vista;
import pss1inventarioscunoc.backend.pojos.Encargado;

/**
 *
 * @author fabricio
 */
public class ValidacionEncargados extends javax.swing.JPanel {

    private Vista vista = Vista.MANEJO_ENCARGADOS;
    public List<Encargado> listaEncargados = null;
    public ObservableList<Encargado> listaEncargadosObsr = null;
    private Encargado selectedEncargado = null;
    private String selectedCargo = null;
    private String selectedDivision = null;
    private String newStateEncargado = "";
    private ControladorEncargado controlador = null;
    private boolean tableSelected = false;

    public static final String PROP_NOMBRE = "nombre";

    
    /**
     * Creates new form ValidacionEncargado
     */
    public ValidacionEncargados() {
        this.controlador = new ControladorEncargado();
        this.listaEncargados = new LinkedList<>();
        this.listaEncargadosObsr = ObservableCollections.observableList(listaEncargados);
        initComponents();
        this.setName("Validacion");
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
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cargoComboBox = new javax.swing.JComboBox<>();
        cargoTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        divisionComboBox = new javax.swing.JComboBox<>();
        divisionTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        agregarButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        actualizarButton = new javax.swing.JButton();
        deshabilitarHabilitarButton = new javax.swing.JButton();
        limpiarButton = new javax.swing.JButton();
        apellidoTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dpiTextField = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEncargados = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(51, 119, 180));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Validación de Encargados");

        panelValidacion.setBackground(new java.awt.Color(51, 119, 180));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Agregar Encargado");

        nombreTextField.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        nombreTextField.setForeground(new java.awt.Color(0, 0, 102));
        nombreTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Apellido");

        cargoComboBox.setBackground(new java.awt.Color(255, 255, 255));
        cargoComboBox.setForeground(new java.awt.Color(0, 50, 102));
        cargoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cargoComboBoxItemStateChanged(evt);
            }
        });
        cargoComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cargoComboBoxFocusLost(evt);
            }
        });
        cargoComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargoComboBoxMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cargoComboBoxMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cargoComboBoxMouseEntered(evt);
            }
        });

        cargoTextField.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        cargoTextField.setForeground(new java.awt.Color(0, 0, 102));
        cargoTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Cargo");

        divisionComboBox.setBackground(new java.awt.Color(255, 255, 255));
        divisionComboBox.setForeground(new java.awt.Color(0, 50, 102));
        divisionComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                divisionComboBoxItemStateChanged(evt);
            }
        });

        divisionTextField.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        divisionTextField.setForeground(new java.awt.Color(0, 0, 102));
        divisionTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("División");

        agregarButton.setBackground(new java.awt.Color(51, 204, 0));
        agregarButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        agregarButton.setText("AGREGAR");
        agregarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Tabla de Encargados");

        actualizarButton.setBackground(new java.awt.Color(255, 153, 0));
        actualizarButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        actualizarButton.setText("ACTUALIZAR");
        actualizarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        actualizarButton.setEnabled(false);
        actualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarButtonActionPerformed(evt);
            }
        });

        deshabilitarHabilitarButton.setBackground(new java.awt.Color(204, 0, 0));
        deshabilitarHabilitarButton.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        deshabilitarHabilitarButton.setText("DESHABILITAR");
        deshabilitarHabilitarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        deshabilitarHabilitarButton.setEnabled(false);
        deshabilitarHabilitarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deshabilitarHabilitarButtonActionPerformed(evt);
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

        apellidoTextField.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        apellidoTextField.setForeground(new java.awt.Color(0, 0, 102));
        apellidoTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("DPI");

        dpiTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dpiTextField.setForeground(new java.awt.Color(0, 0, 51));
        try {
            dpiTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### ##### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dpiTextField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                dpiTextFieldCaretUpdate(evt);
            }
        });
        dpiTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dpiTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dpiTextFieldFocusLost(evt);
            }
        });
        dpiTextField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                dpiTextFieldInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaEncargadosObsr}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tablaEncargados);
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
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedEncargado}"), tablaEncargados, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        tablaEncargados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEncargadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEncargados);

        javax.swing.GroupLayout panelValidacionLayout = new javax.swing.GroupLayout(panelValidacion);
        panelValidacion.setLayout(panelValidacionLayout);
        panelValidacionLayout.setHorizontalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValidacionLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addComponent(divisionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(divisionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addComponent(cargoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cargoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(apellidoTextField)))
                    .addComponent(dpiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(43, 43, 43)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addComponent(actualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(deshabilitarHabilitarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        panelValidacionLayout.setVerticalGroup(
            panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValidacionLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(9, 9, 9)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelValidacionLayout.createSequentialGroup()
                        .addComponent(dpiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellidoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cargoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cargoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(8, 8, 8)
                        .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(divisionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(divisionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deshabilitarHabilitarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
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
        this.controlador.actualizarEncargadosValidacionEncargados(this);
    }
    
    private void actualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarButtonActionPerformed
        this.controlador.actualizarButtonValidacionEncargados(this);
    }//GEN-LAST:event_actualizarButtonActionPerformed

    private void deshabilitarHabilitarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deshabilitarHabilitarButtonActionPerformed
        this.controlador.deshabilitarHabilitarButtonValidacionEncargados(this);
    }//GEN-LAST:event_deshabilitarHabilitarButtonActionPerformed

    private void tablaEncargadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEncargadosMouseClicked
        this.controlador.tablaEncargadosMouseClickedValidacionEncargados(this);
    }//GEN-LAST:event_tablaEncargadosMouseClicked

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        this.controlador.agregarButtonValidacionEncargados(this);
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void divisionComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_divisionComboBoxItemStateChanged
        this.setTextDivisionTextField((String) this.getDivisionComboBox().getSelectedItem());
    }//GEN-LAST:event_divisionComboBoxItemStateChanged

    private void dpiTextFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dpiTextFieldInputMethodTextChanged

    }//GEN-LAST:event_dpiTextFieldInputMethodTextChanged

    private void dpiTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dpiTextFieldFocusLost

    }//GEN-LAST:event_dpiTextFieldFocusLost

    private void dpiTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dpiTextFieldFocusGained
        this.controlador.dpiTextFieldFocusGainedValidacionEncargados(this);
    }//GEN-LAST:event_dpiTextFieldFocusGained

    private void dpiTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_dpiTextFieldCaretUpdate

    }//GEN-LAST:event_dpiTextFieldCaretUpdate

    private void cargoComboBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargoComboBoxMouseEntered

    }//GEN-LAST:event_cargoComboBoxMouseEntered

    private void cargoComboBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargoComboBoxMouseExited

    }//GEN-LAST:event_cargoComboBoxMouseExited

    private void cargoComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargoComboBoxMouseClicked

    }//GEN-LAST:event_cargoComboBoxMouseClicked

    private void cargoComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cargoComboBoxFocusLost

    }//GEN-LAST:event_cargoComboBoxFocusLost

    private void cargoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cargoComboBoxItemStateChanged
        this.setTextCargoTextField((String) this.getCargoComboBox().getSelectedItem());
    }//GEN-LAST:event_cargoComboBoxItemStateChanged

    private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarButtonActionPerformed
        this.controlador.limpiarButtonValidacionEncargados(this);
    }//GEN-LAST:event_limpiarButtonActionPerformed

    public JButton getAgregarButton() {
        return agregarButton;
    }

    public JTextField getApellidoTextField() {
        return apellidoTextField;
    }

    public boolean isTableSelected() {
        return tableSelected;
    }

    public void setTableSelected(boolean tableSelected) {
        this.tableSelected = tableSelected;
    }

    public JComboBox<String> getCargoComboBox() {
        return cargoComboBox;
    }

    public JTextField getCargoTextField() {
        return cargoTextField;
    }

    public JComboBox<String> getDivisionComboBox() {
        return divisionComboBox;
    }

    public JTextField getDivisionTextField() {
        return divisionTextField;
    }

    public JFormattedTextField getDpiTextField() {
        return dpiTextField;
    }

    public JButton getEliminarButton() {
        return deshabilitarHabilitarButton;
    }

    public JButton getActualizarButton() {
        return actualizarButton;
    }

    public JButton getLimpiarButton() {
        return limpiarButton;
    }

    public JTextField getNombreTextField() {
        return nombreTextField;
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

    public Encargado getSelectedEncargado() {
        return selectedEncargado;
    }

    public void setSelectedEncargado(Encargado selectedEncargado) {
        this.selectedEncargado = selectedEncargado;
    }

    public String getSelectedCargo() {
        return selectedCargo;
    }

    public void setSelectedCargo(String selectedCargo) {
        this.selectedCargo = selectedCargo;
    }

    public String getSelectedDivision() {
        return selectedDivision;
    }

    public void setSelectedDivision(String selectedDivision) {
        this.selectedDivision = selectedDivision;
    }
    
    public void setTextCargoTextField(String text){
        this.cargoTextField.setText(text);
    }
    
    public void setTextDivisionTextField(String text){
        this.divisionTextField.setText(text);
    }
    
    public void setTextDpiTextField(String text){
        this.dpiTextField.setText(text);
    }
    
    public void setTextNombreTextField(String text){
        this.nombreTextField.setText(text);
    }
    
    public void setTextApellidoTextField(String text){
        this.apellidoTextField.setText(text);
    }
    
    public String getTextDpiTextField(){
        return this.dpiTextField.getText();
    }
    
    public String getTextNombreTextField(){
        return this.nombreTextField.getText();
    }
    
    public String getTextApellidoTextField(){
        return this.apellidoTextField.getText();
    }
    
    public String getTextCargoTextField(){
        return this.cargoTextField.getText();
    }
    
    public String getTextDivisionTextField(){
        return this.divisionTextField.getText();
    }
    
    public Vista getVista(){
        return this.vista;
    }

    public JButton getDeshabilitarHabilitarButton() {
        return deshabilitarHabilitarButton;
    }

    public void setDeshabilitarHabilitarButton(JButton deshabilitarHabilitarButton) {
        this.deshabilitarHabilitarButton = deshabilitarHabilitarButton;
    }

    public String getNewStateEncargado() {
        return newStateEncargado;
    }

    public void setNewStateEncargado(String newStateEncargado) {
        this.newStateEncargado = newStateEncargado;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarButton;
    private javax.swing.JButton agregarButton;
    private javax.swing.JTextField apellidoTextField;
    private javax.swing.JComboBox<String> cargoComboBox;
    private javax.swing.JTextField cargoTextField;
    private javax.swing.JButton deshabilitarHabilitarButton;
    private javax.swing.JComboBox<String> divisionComboBox;
    private javax.swing.JTextField divisionTextField;
    private javax.swing.JFormattedTextField dpiTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JPanel panelValidacion;
    private javax.swing.JTable tablaEncargados;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}