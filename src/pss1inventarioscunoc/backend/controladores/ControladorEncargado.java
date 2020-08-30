/*
 * Controlador de Encargados
 */
package pss1inventarioscunoc.backend.controladores;

import java.awt.Color;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import pss1inventarioscunoc.backend.dao.implementaciones.*;
import pss1inventarioscunoc.backend.dao.interfaces.*;
import pss1inventarioscunoc.backend.enums.EstadoUsuario;
import pss1inventarioscunoc.backend.pojos.*;
import pss1inventarioscunoc.frontend.encargados.AsignacionEncargados;
import pss1inventarioscunoc.frontend.encargados.ValidacionEncargados;

/**
 *
 * @author bryan
 */
public class ControladorEncargado {

    private ControladorBien controladorBien = null;
    private ControladorFactura controladorFactura = null;
    private ControladorTarjetaResponsabilidad controladorTarjetaResponsabilidad = null;
    private EncargadoDAO encargadoDAO;
    private String DEFAULT_STATE_ENCARGADO = EstadoUsuario.HABILITADO.getEstado();
    public static String EMPTY_TEXT = "";
    public static String DESHABILITAR_TEXT = "DESHABILITAR";
    public static String HABILITAR_TEXT = "HABILITAR";

    public ControladorEncargado() {
        this.encargadoDAO = new ImplementacionEncargado();
        this.controladorBien = new ControladorBien();
        this.controladorFactura = new ControladorFactura();
        this.controladorTarjetaResponsabilidad = new ControladorTarjetaResponsabilidad();
    }

    /**
     * Metodo encargado de registrar un encargado Si no existen errores en la
     * base de datos se devuelve un dialogo con un informe de exito, de lo
     * contrario se informará un error
     *
     * @param encargado
     */
    public void registrarEncargado(Encargado encargado) {
        if (encargadoDAO.registrar(encargado)) {
            JOptionPane.showMessageDialog(null, "Encargado registrado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido registrar el encargado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo encargado de registrar un encargado Si no existen errores en la
     * base de datos se devuelve un dialogo con un informe de exito, de lo
     * contrario se informará un error
     *
     * @param encargado
     */
    public void actualizarEncargado(Encargado encargado, String temp) {
        if (encargadoDAO.actualizar(encargado, temp)) {
            JOptionPane.showMessageDialog(null, "Encargado actualizado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar el encargado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Retorna una Lista de objetos Encargado registrados en el sistema
     */
    public List<Encargado> obtenerEncargadosActuales() {
        return encargadoDAO.recuperarLista('e');
    }
    
    /**
     * Retorna una Lista de objetos Encargado registrados en el sistema
     */
    public List<Encargado> obtenerEncargadosActualesByState(String state) {
        return encargadoDAO.recuperarListaByState(state);
    }

    /**
     * ===== Metodos pertenecientes a GUI ManejoEncargados =====
     */
    /**
     * Recibe como primer parametro la instancia de la interfaz (vista) a
     * manejar Método encargado de actualizar la lista de Encargados después de
     * una accion en la vista
     *
     * @param ve
     */
    public void actualizarEncargadosValidacionEncargados(ValidacionEncargados ve) {
        ve.getListaEncargadosObsr().clear();
        ve.getListaEncargadosObsr().addAll(obtenerEncargadosActuales());
        this.fillCargoComboBox(ve, encargadoDAO.recuperarListaCargos());
        this.fillDivisionComboBox(ve, encargadoDAO.recuperarListaDivisiones());
    }

    /**
     * Valida los campos ingresados en la vista que no esten vacios, llamando a
     * otra funcion para validarlos Se registra el nuevo encargado por medio de
     * la llamada a una funcion Por utlimo, se limpian los campos de la vista
     *
     * @param ve
     */
    public void agregarButtonValidacionEncargados(ValidacionEncargados ve) {
        List<String> campos = new LinkedList<>();
        campos.add(ve.getTextDpiTextField());
        campos.add(ve.getTextNombreTextField());
        campos.add(ve.getTextApellidoTextField());
        campos.add(ve.getTextCargoTextField());
        campos.add(ve.getTextDivisionTextField());
        if (!existenCamposVacios(campos)) {
            this.registrarEncargado(new Encargado(Long.parseLong(campos.get(0).replaceAll("\\s", "")),
                    campos.get(1).trim(), campos.get(2).trim(), campos.get(3).trim(),
                    campos.get(4).trim(), DEFAULT_STATE_ENCARGADO));
            this.limpiarButtonValidacionEncargados(ve);
            this.actualizarEncargadosValidacionEncargados(ve);
        }
    }

    /**
     * Recibe como primer parametro la instancia de la interfaz (vista) a
     * manejar Metodo encargado de limpiar los campos en la vista en que se esta
     * trabajando colocando como texto por defecto la variable EMPTY_TEXT
     *
     * @param ve
     */
    public void limpiarButtonValidacionEncargados(ValidacionEncargados ve) {
        setTextInFieldsdValidacionEncargados(ve, EMPTY_TEXT);
    }

    /**
     * Inserta el texto recibido como parametro en los campos disponibles en la
     * GUI ValidacionEncargados
     *
     * @param ve
     * @param text
     */
    public void setTextInFieldsdValidacionEncargados(ValidacionEncargados ve, String text) {
        ve.setTextDpiTextField(text);
        ve.setTextNombreTextField(text);
        ve.setTextApellidoTextField(text);
        ve.setTextCargoTextField(text);
        ve.setTextDivisionTextField(text);
    }

    /**
     * Actualiza los campos del encargado seleccionado en la tabla de la GUI
     * ValidacionEncargados
     *
     * @param ve
     */
    public void actualizarButtonValidacionEncargados(ValidacionEncargados ve) {
        List<String> campos = new LinkedList<>();
        campos.add(ve.getTextDpiTextField());
        campos.add(ve.getTextNombreTextField());
        campos.add(ve.getTextApellidoTextField());
        campos.add(ve.getTextCargoTextField());
        campos.add(ve.getTextDivisionTextField());

        if (!existenCamposVacios(campos)) {

            this.setStateSecundaryButtons(ve, false);
            this.setStatePrimaryButtons(ve, true);

            this.actualizarEncargado(new Encargado(ve.getSelectedEncargado().getId(),
                    campos.get(1).trim(), campos.get(2).trim(), campos.get(3).trim(),
                    campos.get(4).trim(), ve.getSelectedEncargado().getEstado()), null);

            ve.setTableSelected(false);
            this.limpiarButtonValidacionEncargados(ve);
            this.actualizarEncargadosValidacionEncargados(ve);
        }

    }

    /**
     * Se encarga de deshabilitar el encargado seleccionado
     *
     * @param ve
     */
    public void deshabilitarHabilitarButtonValidacionEncargados(ValidacionEncargados ve) {
        this.setStateSecundaryButtons(ve, false);
        this.setStatePrimaryButtons(ve, true);

        Encargado estadoEncargado = ve.getSelectedEncargado();
        estadoEncargado.setEstado(ve.getNewStateEncargado());
        this.actualizarEncargado(estadoEncargado, null);
        this.actualizarEncargadosValidacionEncargados(ve);
    }

    /**
     * Evento Mouse Clicked de la GUI Validacion Encargados Inserta en los
     * campos de la GUI los datos del encargado seleccionado Habilita los
     * botones Actualizar y Eliminar
     *
     * @param ve
     */
    public void tablaEncargadosMouseClickedValidacionEncargados(ValidacionEncargados ve) {
        ve.setTextDpiTextField(Long.toString(ve.getSelectedEncargado().getId()));
        ve.setTextNombreTextField(ve.getSelectedEncargado().getNombre());
        ve.setTextApellidoTextField(ve.getSelectedEncargado().getApellido());
        ve.setTextCargoTextField(ve.getSelectedEncargado().getCargo());
        ve.setTextDivisionTextField(ve.getSelectedEncargado().getDivision());

        if (ve.getSelectedEncargado().getEstado().equals(EstadoUsuario.HABILITADO.getEstado())) {
            ve.getDeshabilitarHabilitarButton().setBackground(Color.red);
            ve.getDeshabilitarHabilitarButton().setText(DESHABILITAR_TEXT);
            ve.setNewStateEncargado(EstadoUsuario.INHABILITADO.getEstado());
        } else {
            ve.getDeshabilitarHabilitarButton().setBackground(Color.green);
            ve.getDeshabilitarHabilitarButton().setText(HABILITAR_TEXT);
            ve.setNewStateEncargado(EstadoUsuario.HABILITADO.getEstado());
        }

        setStateSecundaryButtons(ve, true);
        setStatePrimaryButtons(ve, false);
        ve.setTableSelected(true);
    }

    /**
     * Determina el estado de los botones de la GUI dependiendo del texto
     * ingresado en el campo dpiTextField comparandolo con el DPI seleccionado
     * de la tabla Evento llamado al momento de seleccionar el dpiTextField
     *
     * @param ve
     */
    public void dpiTextFieldFocusGainedValidacionEncargados(ValidacionEncargados ve) {
        if (ve.isTableSelected()) {
            setStateSecundaryButtons(ve, false);
            setStatePrimaryButtons(ve, true);
            ve.setTableSelected(false);
        }
    }

    /**
     * Determina el estado de los botones de la GUI dependiendo del texto
     * ingresado en el campo dpiTextField comparandolo con el DPI seleccionado
     * de la tabla Evento llamado al momento de deseleccionar el dpiTextField
     *
     * @param ve
     */
    public void dpiTextFieldFocusLostValidacionEncargados(ValidacionEncargados ve) {
        if (ve.getSelectedEncargado() != null) {
            if (!ve.getTextDpiTextField().trim().isEmpty()) {
                long id = Long.parseLong(ve.getTextDpiTextField().replaceAll("\\s", ""));
                if (id != ve.getSelectedEncargado().getId()) {
                    setStateSecundaryButtons(ve, false);
                    setStatePrimaryButtons(ve, true);
//                ve.setTableSelected(false);
                } else {
                    setStateSecundaryButtons(ve, true);
                    setStatePrimaryButtons(ve, false);
                }
            }
        }
    }

    /**
     * Asigna un estado a los botones denominados primarios
     *
     * @param ve
     * @param state
     */
    private void setStatePrimaryButtons(ValidacionEncargados ve, boolean state) {
        ve.getAgregarButton().setEnabled(state);
        ve.getLimpiarButton().setEnabled(state);
    }

    /**
     * Asigna un estado a los botones denominados secundarios
     *
     * @param ve
     * @param state
     */
    private void setStateSecundaryButtons(ValidacionEncargados ve, boolean state) {
        ve.getActualizarButton().setEnabled(state);
        ve.getEliminarButton().setEnabled(state);
    }

    /**
     * Se actualizan los items del combo box cargoComboBox
     *
     * @param ve
     */
    public void fillCargoComboBox(ValidacionEncargados ve, List<String> cargos) {
        JComboBox cargoComboBox = ve.getCargoComboBox();
        cargoComboBox.removeAllItems();
        if (cargos != null) {
            for (String cargo : cargos) {
                cargoComboBox.addItem(cargo);
            }
        }
//        ve.getCargoComboBox().
    }

    /**
     * Se actualizan los items del combo box divisionComboBox
     *
     * @param ve
     */
    public void fillDivisionComboBox(ValidacionEncargados ve, List<String> divisiones) {
        JComboBox divisionComboBox = ve.getDivisionComboBox();
        divisionComboBox.removeAllItems();
        if (divisiones != null) {
            for (String cargo : divisiones) {
                divisionComboBox.addItem(cargo);
            }
        }
    }

    /**
     * ===== Metodos pertenecientes a GUI AsignacionEncargados =====
     */
    /**
     * Actualiza la lista de Encargados después de una accion en la vista
     *
     * @param ae
     */
    public void actualizarEncargadosAsignacionEncargados(AsignacionEncargados ae) {
        ae.getListaEncargadosObsr().clear();
        ae.getListaEncargadosObsr().addAll(obtenerEncargadosActualesByState(EstadoUsuario.HABILITADO.getEstado()));
    }

    /**
     * Actualiza la lista de Bienes después de una accion en la vista
     *
     * @param ae
     */
    public void actualizarBienesAsignacionEncargados(AsignacionEncargados ae) {
        ae.getListaBienesObsr().clear();
        ae.getListaBienesObsr().addAll(controladorBien.consultarBienesNoAsignados('1'));
    }

    public void asignarButtonAsignacionEncargados(AsignacionEncargados ae) {
        if (ae.getFechaAperturaDateChooser().getDate() != null) {
            ae.getAsignarButton().setEnabled(false);
            Factura factura = controladorFactura.buscarFactura(ae.getSelectedBien().getIdFactura());
            TarjetaResponsabilidad tr = new TarjetaResponsabilidad(new Timestamp(ae.getFechaAperturaDateChooser().getDate().getTime()),
                    ae.getSelectedBien().getDescripcion(),
                    ae.getSelectedBien().getIdFactura(),
                    null, factura.getFecha(),
                    null, ae.getSelectedBien().getCur(), ae.getSelectedEncargado().getId(), factura.getIdProveedor());
            if (!ae.getNoOrdenCompraTextField().getText().trim().isEmpty()) {
                tr.setNoOrdenCompra(ae.getNoOrdenCompraTextField().getText().trim());
            }
            controladorTarjetaResponsabilidad.registrarTarjetaResponsabilidad(tr);
            this.actualizarBienesAsignacionEncargados(ae);
            this.actualizarEncargadosAsignacionEncargados(ae);
        } else {
            JOptionPane.showMessageDialog(ae, "Se debe seleccionar una fecha", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void tablaEncargadosMouseClickedAsignacionEncargados(AsignacionEncargados ae) {
        ae.getSelectedEncargadoLabel().setText(Long.toString(ae.getSelectedEncargado().getId()));
        ae.setTableEncargadosSelected(true);
        this.enableAsignarButtonAsignacionEncargados(ae);
    }

    public void enableAsignarButtonAsignacionEncargados(AsignacionEncargados ae) {
        if (ae.isTableBienesSelected() && ae.isTableEncargadosSelected()) {
            ae.getAsignarButton().setEnabled(true);
        }
    }

    public void tablaBienesMouseClickedAsignacionEncargados(AsignacionEncargados ae) {
        ae.getSelectedBienLabel().setText(ae.getSelectedBien().getCur());
        ae.setTableBienesSelected(true);
        this.enableAsignarButtonAsignacionEncargados(ae);
    }

    public void limpiarButtonAsignacionEncargados(AsignacionEncargados ae) {
        ae.getSelectedBienLabel().setText(AsignacionEncargados.DEFAULT_TEXT_SIN_ASIGNAR);
        ae.getSelectedEncargadoLabel().setText(AsignacionEncargados.DEFAULT_TEXT_SIN_ASIGNAR);
        ae.setTableBienesSelected(false);
        ae.setTableEncargadosSelected(false);
        ae.getAsignarButton().setEnabled(false);
    }

    /**
     * Recibe como primer parametro una lista de objetos String Retorna un valor
     * verdadero si alguno de los campos en la lista se encuentra vacia, de lo
     * contrario retornara falso
     *
     * @param campos
     * @return
     */
    private boolean existenCamposVacios(List<String> campos) {
        for (String campo : campos) {
            if (campo.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

}
