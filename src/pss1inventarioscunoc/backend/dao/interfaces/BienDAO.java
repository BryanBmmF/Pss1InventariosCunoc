/*
 * Interfaz de Bien DAO
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import pss1inventarioscunoc.backend.pojos.Bien;

/**
 *
 * @author bryan
 */
public interface BienDAO extends CRUD<Bien> {

    /**
     * Operaciones especiales
     */
    
    public ArrayList<Bien> consultarBienDonacion(char estado);
    public ArrayList<Bien> consultarBienTraslado(char estado);
    public ArrayList<Bien> consultarBienCompra(char estado);
    public List<Bien> recuperarListaNoAsignados(char estado);
    public boolean trasladarBien(String cur,Timestamp fecha,String autorizacion,String seccion,String persona_que_recibio);
    
    /*Querys a utilizar*/
    public static final String CONSULTAR_TODOS_LOS_BIENES_NO_ASIGNADOS = "SELECT b.* "
            + "FROM BIEN b WHERE b.cur NOT IN (SELECT t.cur_bien "
            + "FROM TARJETA_RESPONSABILIDAD t WHERE t.estado='activo') AND b.estado = ?";
    public static final String CONSULTAR_BIEN_POR_DONACION = "SELECT t1.cur,t1.id_Factura,t1.procedencia,t1.estado,t1.descripcion,t1.tipo,t1.valor,t1.division,t3.correlativo,t3.punto,t3.numero_acta\n" +
                                                             "FROM BIEN AS t1 JOIN REGISTRO_BIEN_INVENTARIO AS t2 ON t1.cur=t2.cur_bien\n" +
                                                             "JOIN DONACION AS t3 ON t1.cur = t3.cur_bien\n" +
                                                             "WHERE t2.no_inventario=? AND t1.estado=?";
    public static final String CONSULTAR_BIEN_POR_TRASLADO = "SELECT t1.cur,t1.id_Factura,t1.procedencia,t1.estado,t1.descripcion,t1.tipo,t1.valor,t1.division,t3.fecha,t3.autorizacion,t3.seccion,t3.persona_que_recibio\n" +
                                                             "FROM BIEN AS t1 JOIN REGISTRO_BIEN_INVENTARIO AS t2 ON t1.cur=t2.cur_bien\n" +
                                                             "JOIN TRASLADO AS t3 ON t1.cur = t3.cur_bien\n" +
                                                             "WHERE t2.no_inventario=? AND t1.estado=?";
    public static final String CONSULTAR_BIEN_POR_COMPRA = "SELECT * FROM BIEN AS t1 JOIN REGISTRO_BIEN_INVENTARIO AS t2 ON t1.cur=t2.cur_bien\n" +
                                                           "WHERE t2.no_inventario=? AND t1.estado=? AND t1.tipo='compra';";
    
    /**CONSULTA QUE DEVUELVE TODOS LOS BIENES->
     *                           SELECT *
                                 FROM BIEN AS t1  LEFT JOIN REGISTRO_BIEN_INVENTARIO AS t2 ON t1.cur=t2.cur_bien
				 LEFT JOIN TRASLADO AS t3 ON t1.cur = t3.cur_bien
				 LEFT JOIN DONACION AS t4 ON t1.cur = t4.cur_bien
                                 WHERE t2.no_inventario=1 AND t1.estado=1;
     */
    
    public static final String CONSULTAR_TODOS_LOS_BIENES = "SELECT * FROM BIEN AS t1 JOIN REGISTRO_BIEN_INVENTARIO AS t2 ON t1.cur=t2.cur_bien WHERE t2.no_inventario=? AND t1.estado=?";
    public static final String CONSULTAR_BIEN_DONACION_POR_CUR = "SELECT correlativo,punto,numero_acta FROM DONACION WHERE cur_bien=? LIMIT 1";
    public static final String CONSULTAR_BIEN_TRASLADO_POR_CUR = "SELECT fecha,autorizacion,seccion,persona_que_recibio FROM TRASLADO WHERE cur_bien=? LIMIT 1";
    public static final String TRASLADAR_BIEN = "INSERT INTO TRASLADO(cur_bien,fecha,autorizacion,seccion,persona_que_recibio) VALUES(?,?,?,?,?)";
    public static final String DESACTIVAR_TRASLADO = "UPDATE TRASLADO SET autorizacion =0 WHERE cur_bien =?";
    //CRUD
    public static final String REGISTRAR_BIEN_SIN_FACTURA ="INSERT INTO BIEN(cur,procedencia,estado,descripcion,tipo,valor,division) VALUES(?,?,?,?,?,?,?)";
    public static final String REGISTRAR_BIEN = "INSERT INTO BIEN VALUES(?,?,?,?,?,?,?,?)";
    public static final String REGISTRAR_BIEN_TRASLADO = "INSERT INTO TRASLADO(cur_bien,fecha,autorizacion,seccion,persona_que_recibio) VALUES(?,?,?,?,?)";
    public static final String REGISTRAR_BIEN_DONACION = "INSERT INTO DONACION(correlativo,punto,numero_acta,cur_bien) VALUES(?,?,?,?)";
    
    public static final String ACTUALIZAR_BIEN = "CALL actualizar_bien_compra(?,?,?,?,?,?,?,?,?,?)";
    public static final String ACTUALIZAR_BIEN_TRASLADO = "CALL actualizar_bien_traslado(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String ACTUALIZAR_BIEN_DONACION = "CALL actualizar_bien_donacion(?,?,?,?,?,?,?,?,?,?,?,?,?)";

}
