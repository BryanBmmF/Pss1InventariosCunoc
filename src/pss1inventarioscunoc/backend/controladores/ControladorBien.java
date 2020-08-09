/*
 * Controlador de Bienes
 */
package pss1inventarioscunoc.backend.controladores;

import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionBien;
import pss1inventarioscunoc.backend.dao.interfaces.BienDAO;
import pss1inventarioscunoc.backend.pojos.Bien;

/**
 *
 * @author bryan
 */
public class ControladorBien {
    
    private BienDAO bienDao;
    
    public ControladorBien(){
        bienDao = new ImplementacionBien();
    }
    
    /**
     * Registra un bien, ya se de compra,de traslado o de donacion
     * devuelve false si no lo ha insertado
     * @param bien
     * @return 
     */
    public boolean registrarBien(Bien bien){ 
        return bienDao.registrar(bien);
    }
    
}
