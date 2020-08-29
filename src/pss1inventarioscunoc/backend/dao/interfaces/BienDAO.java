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
    public static final String CONSULTAR_BIEN_POR_DONACION = "SELECT * FROM BIEN AS t1 INNER JOIN DONACION AS t2 ON t1.cur=t2.cur_bien AND t1.estado=?";
    public static final String CONSULTAR_BIEN_POR_TRASLADO = "SELECT * FROM BIEN AS t1 INNER JOIN TRASLADO AS t2 ON t1.cur=t2.cur_bien AND t1.estado=?";
    public static final String CONSULTAR_BIEN_POR_COMPRA = "SELECT * FROM BIEN WHERE tipo='compra' AND estado=?";
    public static final String CONSULTAR_TODOS_LOS_BIENES = "SELECT * FROM BIEN WHERE estado=?";
    public static final String CONSULTAR_TODOS_LOS_BIENES_NO_ASIGNADOS = "SELECT b.* "
            + "FROM BIEN b WHERE b.cur NOT IN (SELECT t.cur_bien "
            + "FROM TARJETA_RESPONSABILIDAD t) AND b.estado = ?";
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
