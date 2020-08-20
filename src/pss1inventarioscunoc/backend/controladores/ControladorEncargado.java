/*
 * Controlador de Encargados
 */
package pss1inventarioscunoc.backend.controladores;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionEncargado;
import pss1inventarioscunoc.backend.dao.interfaces.EncargadoDAO;
import pss1inventarioscunoc.backend.pojos.Encargado;
import pss1inventarioscunoc.frontend.encargados.ManejoEncargados;

/**
 *
 * @author bryan
 */
public class ControladorEncargado {
    
    private EncargadoDAO encargadoDAO;
    public static String EMPTY_TEXT = "";

    public ControladorEncargado() {
        this.encargadoDAO = new ImplementacionEncargado();
    }
    
    /**
     * Metodo encargado de registrar un encargado
     * Si no existen errores en la base de datos se devuelve un dialogo con un
     * informe de exito, de lo contrario se informará un error
     * @param encargado 
     */
    public void registrar(Encargado encargado){
        if (encargadoDAO.registrar(encargado)) {
            JOptionPane.showMessageDialog(null, "Encargado registrado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido registrar el encargado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Metodo encargado de registrar un encargado
     * Si no existen errores en la base de datos se devuelve un dialogo con un
     * informe de exito, de lo contrario se informará un error
     * @param encargado 
     */
    public void actualizar(Encargado encargado, String temp){
        if (encargadoDAO.actualizar(encargado, temp)) {
            JOptionPane.showMessageDialog(null, "Encargado actualizado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar el encargado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Retorna una Lista de objetos Encargado
     * Se utiliza la implementacion de encargado para obtener todos los encargados
     * registrados en el sistema
     * @return 
     */
    public List<Encargado> obtenerEncargadosActuales(){
        return encargadoDAO.recuperarLista();
    }
    
    /**
     * ===== Metodos pertenecientes a GUI ValidacionEncargados =====
     */
    
    /**
     * Recibe como primer parametro la instancia de la interfaz (vista) a manejar
     * Método encargado de actualizar la lista de Encargados después de una
     * accion en la vista
     * @param ve 
     */
    public void actualizarEncargadosValidacionEncargados(ManejoEncargados ve){
        ve.getListaEncargadosObsr().clear();
        ve.getListaEncargadosObsr().addAll(obtenerEncargadosActuales());
        this.fillCargoComboBox(ve, encargadoDAO.recuperarListaCargos());
        this.fillDivisionComboBox(ve, encargadoDAO.recuperarListaDivisiones());
    }
    
    /**
     * Valida los campos ingresados en la vista que no esten
     * vacios, llamando a otra funcion para validarlos
     * Se registra el nuevo encargado por medio de la llamada a una funcion
     * Por utlimo, se limpian los campos de la vista
     * @param ve 
     */
    public void agregarButtonValidacionEncargados(ManejoEncargados ve){
        List<String> campos = new LinkedList<>();
        campos.add(ve.getTextDpiTextField());
        campos.add(ve.getTextNombreTextField());
        campos.add(ve.getTextApellidoTextField());
        campos.add(ve.getTextCargoTextField());
        campos.add(ve.getTextDivisionTextField());
        if(!existenCamposVacios(campos)){
            this.registrar(new Encargado(Long.parseLong(campos.get(0).replaceAll("\\s","")), 
                    campos.get(1).trim(), campos.get(2).trim(), campos.get(3).trim(), campos.get(4).trim()));
            this.limpiarButtonValidacionEncargados(ve);
            this.actualizarEncargadosValidacionEncargados(ve);
        }
    }
    
    /**
     * Recibe como primer parametro la instancia de la interfaz (vista) a manejar
     * Metodo encargado de limpiar los campos en la vista en que se esta trabajando
     * colocando como texto por defecto la variable EMPTY_TEXT
     * @param ve 
     */
    public void limpiarButtonValidacionEncargados(ManejoEncargados ve){
        setTextInFieldsdValidacionEncargados(ve, EMPTY_TEXT);
    }
    
    /**
     * Inserta el texto recibido como parametro en los campos disponibles
     * en la GUI ValidacionEncargados
     * @param ve
     * @param text 
     */
    public void setTextInFieldsdValidacionEncargados(ManejoEncargados ve, String text){
        ve.setTextDpiTextField(text);
        ve.setTextNombreTextField(text);
        ve.setTextApellidoTextField(text);
        ve.setTextCargoTextField(text);
        ve.setTextDivisionTextField(text);
    }
    
    /**
     * Actualiza los campos del encargado seleccionado en la tabla de 
     * la GUI ValidacionEncargados
     * @param ve 
     */
    public void actualizarButtonValidacionEncargados(ManejoEncargados ve){
        List<String> campos = new LinkedList<>();
        campos.add(ve.getTextDpiTextField());
        campos.add(ve.getTextNombreTextField());
        campos.add(ve.getTextApellidoTextField());
        campos.add(ve.getTextCargoTextField());
        campos.add(ve.getTextDivisionTextField());
        
        if(!existenCamposVacios(campos)){
            
            this.setStateSecundaryButtons(ve, false);
            this.setStatePrimaryButtons(ve, true);
            
            this.actualizar(new Encargado(Long.parseLong(campos.get(0).replaceAll("\\s","")), 
                    campos.get(1).trim(), campos.get(2).trim(), campos.get(3).trim(), 
                    campos.get(4).trim()), null);
            
            ve.setTableSelected(false);
            this.limpiarButtonValidacionEncargados(ve);
            this.actualizarEncargadosValidacionEncargados(ve);
        }
        
    }
    
    /**
     * Se encarga de deshabilitar el encargado seleccionado
     * @param ve 
     */
    public void eliminarButtonValidacionEncargados(ManejoEncargados ve){
        this.setStateSecundaryButtons(ve, false);
        this.setStatePrimaryButtons(ve, true);
    }
    
    /**
     * Evento Mouse Clicked de la GUI Validacion Encargados
     * Inserta en los campos de la GUI los datos del encargado seleccionado
     * Habilita los botones Actualizar y Eliminar
     * @param ve 
     */
    public void tablaEncargadosMouseClickedValidacionEncargados(ManejoEncargados ve){
        ve.setTextDpiTextField(Long.toString(ve.getSelectedEncargado().getId()));
        ve.setTextNombreTextField(ve.getSelectedEncargado().getNombre());
        ve.setTextApellidoTextField(ve.getSelectedEncargado().getApellido());
        ve.setTextCargoTextField(ve.getSelectedEncargado().getCargo());
        ve.setTextDivisionTextField(ve.getSelectedEncargado().getDivision());
        
        setStateSecundaryButtons(ve, true);
        setStatePrimaryButtons(ve, false);
        ve.setTableSelected(true);
    }
    
    /**
     * Determina el estado de los botones de la GUI dependiendo del texto
     * ingresado en el campo dpiTextField comparandolo con el DPI seleccionado de la tabla
     * Evento llamado al momento de seleccionar el dpiTextField
     * @param ve 
     */
    public void dpiTextFieldFocusGainedValidacionEncargados(ManejoEncargados ve){
        if(ve.isTableSelected()){
            setStateSecundaryButtons(ve, false);
            setStatePrimaryButtons(ve, true);
            ve.setTableSelected(false);
        }
    }
    
    /**
     * Determina el estado de los botones de la GUI dependiendo del texto
     * ingresado en el campo dpiTextField comparandolo con el DPI seleccionado de la tabla
     * Evento llamado al momento de deseleccionar el dpiTextField
     * @param ve 
     */
    public void dpiTextFieldFocusLostValidacionEncargados(ManejoEncargados ve){
        if(ve.getSelectedEncargado() != null){
            if(!ve.getTextDpiTextField().trim().isEmpty()){
                long id = Long.parseLong(ve.getTextDpiTextField().replaceAll("\\s", ""));
                if(id != ve.getSelectedEncargado().getId()){
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
     * @param ve
     * @param state 
     */
    private void setStatePrimaryButtons(ManejoEncargados ve, boolean state){
        ve.getAgregarButton().setEnabled(state);
        ve.getLimpiarButton().setEnabled(state);
    }
    
    /**
     * Asigna un estado a los botones denominados secundarios
     * @param ve
     * @param state
     */
    private void setStateSecundaryButtons(ManejoEncargados ve, boolean state){
        ve.getActualizarButton().setEnabled(state);
        ve.getEliminarButton().setEnabled(state);
    }
    
    /**
     * Se actualizan los items del combo box cargoComboBox 
     * @param ve 
     */
    public void fillCargoComboBox(ManejoEncargados ve, List<String> cargos){
        JComboBox cargoComboBox = ve.getCargoComboBox();
        cargoComboBox.removeAllItems();
        if(cargos != null){
                for (String cargo : cargos) {
                cargoComboBox.addItem(cargo);
            }
        }
//        ve.getCargoComboBox().
    }
    
    /**
     * Se actualizan los items del combo box divisionComboBox 
     * @param ve 
     */
    public void fillDivisionComboBox(ManejoEncargados ve, List<String> divisiones){
        JComboBox divisionComboBox = ve.getDivisionComboBox();
        divisionComboBox.removeAllItems();
        if(divisiones != null){
                for (String cargo : divisiones) {
                divisionComboBox.addItem(cargo);
            }
        }
    }
    
    /**
     * Recibe como primer parametro una lista de objetos String
     * Retorna un valor verdadero si alguno de los campos en la lista se
     * encuentra vacia, de lo contrario retornara falso
     * @param campos
     * @return 
     */
    private boolean existenCamposVacios(List<String> campos){
        for (String campo : campos) {
            if(campo.trim().isEmpty()){
                return true;
            }
        }
        return false;
    }
    
}
