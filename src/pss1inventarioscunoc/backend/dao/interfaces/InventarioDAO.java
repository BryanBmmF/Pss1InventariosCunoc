/*
 * Interfaz de Inventario DAO
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import pss1inventarioscunoc.backend.pojos.Inventario;

/**
 *
 * @author bryan
 */
public interface InventarioDAO extends CRUD<Inventario>{
    
    //Metodos especiales
    public Inventario buscarInventario();
    //***CONSULTAS**//
    
    //Otras consultas
    //CRUD
    public String CONSULTAR_INVENTARIO = "SELECT * FROM INVENTARIO WHERE no=?";
    
}
