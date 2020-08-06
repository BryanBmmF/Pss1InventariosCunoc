/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.controladores;

import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionFactura;
import pss1inventarioscunoc.backend.dao.interfaces.FacturaDAO;
import pss1inventarioscunoc.backend.pojos.Factura;

/**
 *
 * @author jesfrin
 */
public class ControladorFactura {
    
    private FacturaDAO facturaDao;
    
    public ControladorFactura(){
        facturaDao = new ImplementacionFactura();
    }
    
    /**
     * Devuelve true si se efectuo el ingreso de la factura
     * @param factura
     * @return 
     */
    public boolean registrar(Factura factura){
        return facturaDao.registrar(factura);
    }
    
}
