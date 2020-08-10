/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.controladores;

import java.sql.Timestamp;
import java.util.ArrayList;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionFactura;
import pss1inventarioscunoc.backend.dao.interfaces.FacturaDAO;
import pss1inventarioscunoc.backend.pojos.Factura;

/**
 *
 * @author jesfrin
 */
public class ControladorFactura {

    private FacturaDAO facturaDao;

    public ControladorFactura() {
        facturaDao = new ImplementacionFactura();
    }

    /**
     * Devuelve true si se efectuo el ingreso de la factura
     *
     * @param factura
     * @return
     */
    public boolean registrar(Factura factura) {
        return facturaDao.registrar(factura);
    }

    /**
     * Devuelve todas las facturas del sistema, null si hubiera errores de consulta
     *
     * @return
     */
    public ArrayList<Factura> buscarFacturas() {
        return (ArrayList<Factura>) facturaDao.recuperarLista();
    }

    /**
     * Devuelve las facturas del proveedor indicado, null si hubieran errores de consulta
     * @param nombreProveedor
     * @return 
     */
    public ArrayList<Factura> buscarFacturas(String nombreProveedor) {
        return (ArrayList<Factura>) facturaDao.buscarFacturaPorProveedor(nombreProveedor);

    }
    
    /**
     * Devuelve las facturas que esten en el rango de fechas especificado, null si existio algun error
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     */
    public ArrayList<Factura> buscarFacturas(Timestamp fechaInicial, Timestamp fechaFinal){
        return (ArrayList<Factura>)facturaDao.buscarFacturaPorFecha(fechaInicial, fechaFinal);
    }
}
