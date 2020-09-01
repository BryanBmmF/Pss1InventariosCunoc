/*
 * Controlador de Tarjetas de Responsabilid
 */
package pss1inventarioscunoc.backend.controladores;

import javax.swing.JOptionPane;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionHistorialTarjetaResponsabilidad;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionTarjetaResponsabilidad;
import pss1inventarioscunoc.backend.dao.interfaces.HistorialTarjetaResponsabilidadDAO;
import pss1inventarioscunoc.backend.pojos.HistorialTarjetaResponsabilidad;
import pss1inventarioscunoc.backend.pojos.TarjetaResponsabilidad;
import pss1inventarioscunoc.frontend.tarjetasresponsabilidad.reporteTarjetasResponsabilidad;

/**
 *
 * @author bryan
 */
public class ControladorHistorialTarjetaResponsabilidad {

    private HistorialTarjetaResponsabilidadDAO historialTarjetaResponsabilidadDAO = null;

    public ControladorHistorialTarjetaResponsabilidad() {
        this.historialTarjetaResponsabilidadDAO = new ImplementacionHistorialTarjetaResponsabilidad();
    }

    /**
     * Valida los campos de la GUI para proceder a llamar funciones de registro
     * @param tarjetaResponsabilidad 
     */
    public void registrarHistorialTarjetaResponsabilidad(HistorialTarjetaResponsabilidad historialTarjetaResponsabilidad) {
        this.historialTarjetaResponsabilidadDAO.registrar(historialTarjetaResponsabilidad);
//        if (tarjetaResponsabilidad.getNoOrdenCompra() != null) {
//            if (historialTarjetaResponsabilidadDAO.registrarConOrdenCompra(tarjetaResponsabilidad)) {
//                JOptionPane.showMessageDialog(null, "Encargado registrado correctamente",
//                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, "No se ha podido registrar el encargado",
//                        "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        } else {
//            if (historialTarjetaResponsabilidadDAO.registrar(tarjetaResponsabilidad)) {
//                JOptionPane.showMessageDialog(null, "Encargado registrado correctamente",
//                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, "No se ha podido registrar el encargado",
//                        "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
    }
    
}
