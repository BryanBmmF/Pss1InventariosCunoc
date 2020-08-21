/*
 * Interfaz de Tarjeta de Responsabilidad DAO
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import pss1inventarioscunoc.backend.pojos.TarjetaResponsabilidad;

/**
 *
 * @author bryan
 */
public interface TarjetaResponsabilidadDAO extends CRUD<TarjetaResponsabilidad>{
    
    public boolean registrarConOrdenCompra(TarjetaResponsabilidad model);
    
    /*Querys a utilizar*/
    public static final String CONSULTAR_TARJETA = "SELECT * FROM TARJETA_RESPONSABILIDAD WHERE id = ?";
    //CRUD
    public static final String INSERTAR_TARJETA_ORDEN_COMPRA="INSERT INTO TARJETA_RESPONSABILIDAD "
            + "(fecha_apertura,descripcion,no_factura,fecha_factura,"
            + "no_orden_compra,cur_bien,id_responsable,"
            + "id_proveedor) VALUES(?,?,?,?,?,?,?,?)";
    public static final String INSERTAR_TARJETA="INSERT INTO TARJETA_RESPONSABILIDAD "
            + "(fecha_apertura,descripcion,no_factura,fecha_factura,"
            + "cur_bien,id_responsable,id_proveedor) VALUES(?,?,?,?,?,?,?)";
    public static final String CONSULTAR_TARJETAS="SELECT * FROM TARJETA_RESPONSABILIDAD";
    
}
