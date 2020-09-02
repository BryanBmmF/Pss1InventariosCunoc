/*
 * Interfaz de Tarjeta de Responsabilidad DAO
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import java.util.List;
import pss1inventarioscunoc.backend.pojos.TarjetaResponsabilidad;

/**
 *
 * @author bryan
 */
public interface TarjetaResponsabilidadDAO extends CRUD<TarjetaResponsabilidad>{
    
    public boolean registrarConOrdenCompra(TarjetaResponsabilidad model);
    public int recuperarNumeroTarjetasPorEncargado(String idEncargado);
    public List<TarjetaResponsabilidad> recuperarListaTarjetasEncargado(String idEncargado);
    
    /*Querys a utilizar*/
    public static final String CONSULTAR_TARJETA = "SELECT * FROM TARJETA_RESPONSABILIDAD WHERE id = ?";
    //CRUD
    public static final String INSERTAR_TARJETA_ORDEN_COMPRA="INSERT INTO TARJETA_RESPONSABILIDAD "
            + "(fecha_apertura,descripcion,no_factura,fecha_factura,"
            + "no_orden_compra,cur_bien,id_responsable,"
            + "id_proveedor,estado) VALUES(?,?,?,?,?,?,?,?,?)";
    public static final String INSERTAR_TARJETA="INSERT INTO TARJETA_RESPONSABILIDAD "
            + "(fecha_apertura,descripcion,no_factura,fecha_factura,"
            + "cur_bien,id_responsable,id_proveedor,estado) VALUES(?,?,?,?,?,?,?,?)";
    public static final String CONSULTAR_TARJETAS="SELECT * FROM TARJETA_RESPONSABILIDAD";
    
    public static final String ACTUALIZAR_TARJETA="UPDATE TARJETA_RESPONSABILIDAD SET "
            + "id_responsable = ?, id_Proveedor = ?, no_factura = ? "
            + "WHERE id = ?";
    public static final String CONSULTAR_NUMERO_TARJETAS_ENCARGADO = "SELECT COUNT(*) "
            + "FROM TARJETA_RESPONSABILIDAD INNER JOIN ENCARGADO ON "
            + "TARJETA_RESPONSABILIDAD.`id_responsable` = ENCARGADO.`id_encargado` "
            + "WHERE ENCARGADO.`id_encargado` = ?";
    public static final String CONSULTAR_TARJETAS_POR_ENCARGADO = "SELECT TARJETA_RESPONSABILIDAD.* "
            + "FROM TARJETA_RESPONSABILIDAD INNER JOIN ENCARGADO ON "
            + "TARJETA_RESPONSABILIDAD.`id_responsable` = ENCARGADO.`id_encargado` "
            + "WHERE ENCARGADO.`id_encargado` = ?";
}
