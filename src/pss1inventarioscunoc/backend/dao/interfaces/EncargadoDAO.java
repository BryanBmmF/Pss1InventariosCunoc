/*
 * Interfaz de Encargado DAO
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import pss1inventarioscunoc.backend.pojos.Encargado;

/**
 *
 * @author bryan
 */
public interface EncargadoDAO extends CRUD<Encargado>{
    
    public static final String INSERTAR_ENCARGADO="INSERT INTO ENCARGADO VALUES(?,?,?,?,?)";
    public static final String CONSULTAR_ENCARGADOS="SELECT * FROM ENCARGADO";
    
}
