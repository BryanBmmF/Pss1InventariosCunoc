/*
 * Interfaz de Bien DAO
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import pss1inventarioscunoc.backend.pojos.Bien;

/**
 *
 * @author bryan
 */
public interface BienDAO extends CRUD<Bien>{
    
    /**Operaciones especiales*/
        
    
    /*Querys a utilizar*/
        
    //CRUD
    public static final String REGISTRAR_BIEN="INSERT INTO BIEN VALUES(?,?,?,?,?,?,?,?)";
    public static final String REGISTRAR_BIEN_TRASLADO="INSERT INTO TRASLADO(cur_bien,fecha,autorizacion,seccion,persona_que_recibio) VALUES(?,?,?,?,?)";
    public static final String REGISTRAR_BIEN_DONACION="INSERT INTO DONACION(correlativo,punto,numero_acta,cur_bien) VALUES(?,?,?,?)";
    
}
