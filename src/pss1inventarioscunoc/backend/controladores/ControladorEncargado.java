/*
 * Controlador de Encargados
 */
package pss1inventarioscunoc.backend.controladores;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionEncargado;
import pss1inventarioscunoc.backend.dao.interfaces.EncargadoDAO;
import pss1inventarioscunoc.backend.pojos.Encargado;
import pss1inventarioscunoc.frontend.vistas.ValidacionEncargados;

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
    
    public void registrar(Encargado encargado){
        if (encargadoDAO.registrar(encargado)) {
            JOptionPane.showMessageDialog(null, "Encargado registrado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido registrar el encargado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarEncargadosValidacionEncargados(ValidacionEncargados ve){
        ve.getListaEncargadosObsr().clear();
        ve.getListaEncargadosObsr().addAll(obtenerEncargadosActuales());
    }
    
    public List<Encargado> obtenerEncargadosActuales(){
        return encargadoDAO.recuperarLista();
    }
    
    /**
     * Metodos pertenecientes a GUI ValidacionEncargados
     */
    
    public void agregarButtonValidacionEncargados(ValidacionEncargados ve){
        List<String> campos = new LinkedList<>();
        campos.add(ve.getDpiTextField().getText());
        campos.add(ve.getNombreTextField().getText());
        campos.add(ve.getApellidoTextField().getText());
        campos.add(ve.getCargoTextField().getText());
        campos.add(ve.getDivisionTextField().getText());
        
        if(!existenCamposVacios(campos)){
            this.registrar(new Encargado(Long.parseLong(campos.get(0).replaceAll("\\s","")), 
                    campos.get(1).trim(), campos.get(2).trim(), campos.get(3).trim(), campos.get(4).trim()));
            this.limpiarButtonValidacionEncargados(ve);
        }
    }
    
    public void limpiarButtonValidacionEncargados(ValidacionEncargados ve){
        ve.getDpiTextField().setText(EMPTY_TEXT);
        ve.getNombreTextField().setText(EMPTY_TEXT);
        ve.getApellidoTextField().setText(EMPTY_TEXT);
        ve.getCargoTextField().setText(EMPTY_TEXT);
        ve.getDivisionTextField().setText(EMPTY_TEXT);
    }
    
    public void guardarButtonValidacionEncargados(ValidacionEncargados ve){
        
    }
    
    public void eliminarButtonValidacionEncargados(ValidacionEncargados ve){
        
    }
    
    private boolean existenCamposVacios(List<String> campos){
        for (String campo : campos) {
            if(campo.trim().isEmpty()){
                return true;
            }
        }
        return false;
    }
    
}
