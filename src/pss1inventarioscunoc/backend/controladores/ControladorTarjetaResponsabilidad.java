/*
 * Controlador de Tarjetas de Responsabilid
 */
package pss1inventarioscunoc.backend.controladores;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import pss1inventarioscunoc.backend.dao.implementaciones.*;
import pss1inventarioscunoc.backend.dao.interfaces.*;
import pss1inventarioscunoc.backend.enums.EstadoObjeto;
import pss1inventarioscunoc.backend.pojos.HistorialTarjetaResponsabilidad;
import pss1inventarioscunoc.backend.pojos.TarjetaResponsabilidad;
import pss1inventarioscunoc.frontend.tarjetasresponsabilidad.ModificacionTarjetaResponsabilidad;
import pss1inventarioscunoc.frontend.tarjetasresponsabilidad.reporteHistorialTarjetasResponsabilidad;
import pss1inventarioscunoc.frontend.tarjetasresponsabilidad.reporteTarjetasResponsabilidad;
import pss1inventarioscunoc.frontend.vistas.bienes.ReporteBienesEncargado;

/**
 *
 * @author bryan
 */
public class ControladorTarjetaResponsabilidad {

    private TarjetaResponsabilidadDAO tarjetaResponsabilidadDAO = null;
    private HistorialTarjetaResponsabilidadDAO historialTarjetaDAO = null;
    private ControladorHistorialTarjetaResponsabilidad controladorHistorialTarjeta = null;

    public ControladorTarjetaResponsabilidad() {
        this.tarjetaResponsabilidadDAO = new ImplementacionTarjetaResponsabilidad();
        this.historialTarjetaDAO = new ImplementacionHistorialTarjetaResponsabilidad();
        this.controladorHistorialTarjeta = new ControladorHistorialTarjetaResponsabilidad();
    }

    /**
     * Retorna una Lista de objetos Encargado registrados en el sistema
     *
     * @return
     */
    public LinkedList<TarjetaResponsabilidad> obtenerTarjetasActuales() {
        return new LinkedList<>(tarjetaResponsabilidadDAO.recuperarLista('e'));
    }

    /**
     * Retorna una Lista de objetos Encargado registrados en el sistema
     *
     * @return
     */
    public LinkedList<HistorialTarjetaResponsabilidad> obtenerHistorialTarjetasActuales() {
        return new LinkedList<>(historialTarjetaDAO.recuperarLista('e'));
    }

    /**
     * Retorna una Lista de objetos Encargado registrados en el sistema
     *
     * @param idEncargado
     * @return
     */
    public LinkedList<TarjetaResponsabilidad> obtenerTarjetasPorEncargado(String idEncargado) {
        return new LinkedList<>(tarjetaResponsabilidadDAO.recuperarListaTarjetasEncargado(idEncargado));
    }

    /**
     * Retorna una Lista de objetos Encargado registrados en el sistema
     *
     * @param idEncargado
     * @return
     */
    public int obtenerNumeroTarjetasPorEncargado(String idEncargado) {
        return (tarjetaResponsabilidadDAO.recuperarNumeroTarjetasPorEncargado(idEncargado));
    }

    public boolean registrarTarjeta(TarjetaResponsabilidad model) {
        return tarjetaResponsabilidadDAO.registrar(model);
    }

    public boolean actualizarTarjeta(TarjetaResponsabilidad model, String temp) {
        boolean result = tarjetaResponsabilidadDAO.actualizar(model, temp);
        if (result) {
            Date date = new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            this.controladorHistorialTarjeta.registrarHistorialTarjetaResponsabilidad(
                    new HistorialTarjetaResponsabilidad(0, model.getId(),
                            ts, model.getIdResponsable(), model.getIdProveedor(),
                            model.getEstado(), model.getNoFactura()));
        }
        return result;
    }

    /**
     * Valida los campos de la GUI para proceder a llamar funciones de registro
     *
     * @param tr
     */
    public void registrarTarjetaResponsabilidad(TarjetaResponsabilidad tr) {
        if (tr.getNoOrdenCompra() != null) {
            if (this.registrarTarjeta(tr)) {
                JOptionPane.showMessageDialog(null, "Encargado registrado correctamente",
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido registrar el encargado",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (tarjetaResponsabilidadDAO.registrar(tr)) {
                JOptionPane.showMessageDialog(null, "Encargado registrado correctamente",
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido registrar el encargado",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void actualizarTarjetasResponsabilidadReporteTarjetasResponsabilidad(reporteTarjetasResponsabilidad rtr) {
        rtr.getListaTarjetaResponsabilidadesObsr().clear();
        rtr.getListaTarjetaResponsabilidadesObsr().addAll(this.obtenerTarjetasActuales());
    }

    public void actualizarTarjetasResponsabilidad(ReporteBienesEncargado rtr, String idEncargado) {
        rtr.getListaTarjetas().clear();
        rtr.getListaTarjetasObsr().addAll(this.obtenerTarjetasPorEncargado(idEncargado));
    }

    /**
     * ===== Metodos pertenecientes a GUI ModificacionTarjetaResponsabilidad
     * =====
     */
    public void actualizarHistorialTarjetasReporteHistorialTarjetasResponsabilidad(reporteHistorialTarjetasResponsabilidad rhtr) {
        rhtr.getListaHistorialObsr().clear();
        rhtr.getListaHistorialObsr().addAll(this.obtenerHistorialTarjetasActuales());
    }


    public void tablaTarjetasMouseClickedCambioEncargadoBien(ModificacionTarjetaResponsabilidad ceb) {
        ceb.setTableTarjetasSelected(true);
        ceb.getActualizarButton().setEnabled(true);
        ceb.getSelectedEncargadoLabel().setText(Long.toString(ceb.getSelectedTarjeta().getIdResponsable()));
        ceb.getSelectedProveedorLabel().setText(Long.toString(ceb.getSelectedTarjeta().getIdProveedor()));
        ceb.getNoFacturaTextField().setText(Long.toString(ceb.getSelectedTarjeta().getNoFactura()));
    }

    public void actualizarButtonCambioEncargadoBien(ModificacionTarjetaResponsabilidad ceb) {
        TarjetaResponsabilidad tr = ceb.getSelectedTarjeta();
        if (ceb.isTableEncargadosSelected()) {
            tr.setIdResponsable(ceb.getSelectedEncargado().getId());
        }
        if (ceb.isTableProveedoresSelected()) {
            tr.setIdProveedor(ceb.getSelectedProveedor().getIdProveedor());
        }
        if (ceb.isFacturaButtonSelected()) {
            tr.setNoFactura(ceb.getSelectedFactura().getIdFactura());
        }
        if (this.actualizarTarjeta(tr, null)) {
            ceb.actualizarLista();
            JOptionPane.showMessageDialog(null, "Tarjeta Responsabilidad actualizada correctamente",
                    "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar la Tarjeta",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Evalua si el bien con cur ya tiene una tarjeta de responsabilidad
     *
     * @param cur
     * @return true or false
     */
    public boolean obtenerTarjetaBien(String cur) {
        TarjetaResponsabilidad tarjeta = tarjetaResponsabilidadDAO.recuperarTarjetaBien(cur);
        if (tarjeta != null && tarjeta.getEstado().equalsIgnoreCase(EstadoObjeto.ACTIVO.getEstado())) {
            JOptionPane.showMessageDialog(null, "El bien con CUR: " + cur + " no puede ser dado de baja ya que posee una tarjeta de responsabilidad Activa, porfavor anule la tarjeta e intente de nuevo",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return true;
        } else {

            return false;
        }
    }
    
      public void actualizarTarjetasModificacionTarjetaResponsabilidad(ModificacionTarjetaResponsabilidad ceb) {
        ceb.getListaTarjetasObsr().clear();
        ceb.getListaTarjetasObsr().addAll(this.obtenerTarjetasActualesEstado(EstadoObjeto.ACTIVO.getEstado()));
    }
      
          /**
     * Retorna una Lista de objetos Encargado registrados en el sistema
     *
     * @return
     */
    public LinkedList<TarjetaResponsabilidad> obtenerTarjetasActualesEstado(String estado) {
        return new LinkedList<>(tarjetaResponsabilidadDAO.recuperarLista(estado));
    }
    
    
}
