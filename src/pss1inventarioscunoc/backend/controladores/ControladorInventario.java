/*
 * Controlador de Inventarios
 */
package pss1inventarioscunoc.backend.controladores;

import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionInventario;
import pss1inventarioscunoc.backend.dao.interfaces.InventarioDAO;
import pss1inventarioscunoc.backend.pojos.Inventario;

/**
 *
 * @author bryan
 */
public class ControladorInventario {
    
    public static Inventario INVENTARIO_CONTABILIDAD;
    private InventarioDAO inventarioDAO;
    
    public ControladorInventario(){
        inventarioDAO = new ImplementacionInventario();
    }
    
    /**
     * Busca el inventario de contabilidad
     * @return 
     */
    public Inventario buscarInventario(){
        return INVENTARIO_CONTABILIDAD=inventarioDAO.buscarInventario();
    }
    /**
     * Consulta el total activo, del inventario de contabilidad
     * @return 
     */
    public double buscarTotalDeInventariuoDeAlta(){
        return inventarioDAO.consultarTotalDeInventarioActivo(INVENTARIO_CONTABILIDAD);
    }
    
    /**
     * Consulta el total dado de baja, del inventario de contabilidad
     * @return 
     */
    public double buscarTotalDeInventarioDeBaja(){
        return inventarioDAO.consultarTotalDeInventarioDeBaja(INVENTARIO_CONTABILIDAD);
    }
}
