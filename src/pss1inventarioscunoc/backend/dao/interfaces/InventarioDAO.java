/*
 * Interfaz de Inventario DAO
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import pss1inventarioscunoc.backend.pojos.Bien;
import pss1inventarioscunoc.backend.pojos.Inventario;

/**
 *
 * @author bryan
 */
public interface InventarioDAO extends CRUD<Inventario>{
    
    //Metodos especiales
    public Inventario buscarInventario();
    public boolean insertarRegistroBienInventario(Bien bien);
    //***CONSULTAS**//
    
    //Otras consultas
    //CRUD
    public String CONSULTAR_INVENTARIO = "SELECT * FROM INVENTARIO WHERE no=?";
    public String INSERTAR_REGISTRO_BIEN_INVENTARIO="INSERT INTO REGISTRO_BIEN_INVENTARIO(no_inventario,cur_bien) VALUES(?,?)";
}
