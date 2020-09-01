/*
 * Controlador de Tarjetas de Responsabilid
 */
package pss1inventarioscunoc.backend.controladores;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionTarjetaResponsabilidad;
import pss1inventarioscunoc.backend.dao.interfaces.TarjetaResponsabilidadDAO;
import pss1inventarioscunoc.backend.pojos.HistorialTarjetaResponsabilidad;
import pss1inventarioscunoc.backend.pojos.TarjetaResponsabilidad;
import pss1inventarioscunoc.frontend.tarjetasresponsabilidad.ModificacionTarjetaResponsabilidad;
import pss1inventarioscunoc.frontend.tarjetasresponsabilidad.reporteTarjetasResponsabilidad;

/**
 *
 * @author bryan
 */
public class ControladorTarjetaResponsabilidad {

    private TarjetaResponsabilidadDAO tarjetaResponsabilidadDAO = null;
    private ControladorHistorialTarjetaResponsabilidad controladorHistorialTarjeta = null;

    public ControladorTarjetaResponsabilidad() {
        this.tarjetaResponsabilidadDAO = new ImplementacionTarjetaResponsabilidad();
        this.controladorHistorialTarjeta = new ControladorHistorialTarjetaResponsabilidad();
    }

    /**
     * Retorna una Lista de objetos Encargado registrados en el sistema
     * @return 
     */
    public LinkedList<TarjetaResponsabilidad> obtenerTarjetasActuales() {
        return new LinkedList<>(tarjetaResponsabilidadDAO.recuperarLista('e'));
    }

    /**
     * Retorna una Lista de objetos Encargado registrados en el sistema
     * @param idEncargado
     * @return 
     */
    public LinkedList<TarjetaResponsabilidad> obtenerTarjetasPorEncargado(String idEncargado) {
        return new LinkedList<>(tarjetaResponsabilidadDAO.recuperarListaTarjetasEncargado(idEncargado));
    }

    /**
     * Retorna una Lista de objetos Encargado registrados en el sistema
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

    /**
     * ===== Metodos pertenecientes a GUI ModificacionTarjetaResponsabilidad
     * =====
     */
    /**
     * Actualiza la lista de Tarjetas de Responsabilidad después de una accion
     * en la vista
     *
     * @param ceb
     */
    public void actualizarTarjetasModificacionTarjetaResponsabilidad(ModificacionTarjetaResponsabilidad ceb) {
        ceb.getListaTarjetasObsr().clear();
        ceb.getListaTarjetasObsr().addAll(this.obtenerTarjetasActuales());
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

}
