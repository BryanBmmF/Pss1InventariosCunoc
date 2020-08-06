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
    
    public Inventario buscarInventario(){
        return INVENTARIO_CONTABILIDAD=inventarioDAO.buscarInventario();
    }
}
