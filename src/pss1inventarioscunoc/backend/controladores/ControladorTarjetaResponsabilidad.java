/*
 * Controlador de Tarjetas de Responsabilid
 */
package pss1inventarioscunoc.backend.controladores;

import javax.swing.JOptionPane;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionTarjetaResponsabilidad;
import pss1inventarioscunoc.backend.dao.interfaces.TarjetaResponsabilidadDAO;
import pss1inventarioscunoc.backend.pojos.TarjetaResponsabilidad;
import pss1inventarioscunoc.frontend.tarjetasresponsabilidad.reporteTarjetasResponsabilidad;

/**
 *
 * @author bryan
 */
public class ControladorTarjetaResponsabilidad {

    private TarjetaResponsabilidadDAO tarjetaResponsabilidadDAO = null;

    public ControladorTarjetaResponsabilidad() {
        this.tarjetaResponsabilidadDAO = new ImplementacionTarjetaResponsabilidad();
    }

    /**
     * Valida los campos de la GUI para proceder a llamar funciones de registro
     * @param tarjetaResponsabilidad 
     */
    public void registrarTarjetaResponsabilidad(TarjetaResponsabilidad tarjetaResponsabilidad) {
        if (tarjetaResponsabilidad.getNoOrdenCompra() != null) {
            if (tarjetaResponsabilidadDAO.registrarConOrdenCompra(tarjetaResponsabilidad)) {
                JOptionPane.showMessageDialog(null, "Encargado registrado correctamente",
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido registrar el encargado",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (tarjetaResponsabilidadDAO.registrar(tarjetaResponsabilidad)) {
                JOptionPane.showMessageDialog(null, "Encargado registrado correctamente",
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido registrar el encargado",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void actualizarTarjetasResponsabilidadReporteTarjetasResponsabilidad(reporteTarjetasResponsabilidad rtr){
        rtr.getListaTarjetaResponsabilidadesObsr().clear();
        rtr.getListaTarjetaResponsabilidadesObsr().addAll(tarjetaResponsabilidadDAO.recuperarLista('e'));
    }
    
}
