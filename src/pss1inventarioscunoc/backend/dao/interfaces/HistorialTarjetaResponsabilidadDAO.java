/*
 * Interfaz de Tarjeta de Responsabilidad DAO
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import pss1inventarioscunoc.backend.pojos.HistorialTarjetaResponsabilidad;

/**
 *
 * @author bryan
 */
public interface HistorialTarjetaResponsabilidadDAO extends CRUD<HistorialTarjetaResponsabilidad>{
    
    
    /*Querys a utilizar*/
    public static final String CONSULTAR_HISTORIAL_TARJETA = "SELECT * FROM TARJETA_RESPONSABILIDAD WHERE id = ?";
    //CRUD
    public static final String INSERTAR_HISTORIAL_TARJETA="INSERT INTO HISTORIAL_TARJETA_RESP "
            + "(id_tarjeta_responsabilidad,fecha_modificacion,id_responsable,id_proveedor,"
            + "estado,no_factura) VALUES(?,?,?,?,?,?)";
    public static final String CONSULTAR_HISTORIAL_TARJETAS="SELECT * FROM HISTORIAL_TARJETA_RESP";
    
}
