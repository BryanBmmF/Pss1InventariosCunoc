/*
 * Interfaz de Bien DAO
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;
import pss1inventarioscunoc.backend.pojos.Bien;

/**
 *
 * @author bryan
 */
public interface BienDAO extends CRUD<Bien> {

    /**
     * Operaciones especiales
     */
    
    public ArrayList<Bien> consultarBienDonacion();
    public ArrayList<Bien> consultarBienTraslado();
    public ArrayList<Bien> consultarBienCompra();
    public boolean trasladarBien(String cur,Timestamp fecha,String autorizacion,String seccion,String persona_que_recibio);
    
    /*Querys a utilizar*/
    public static final String CONSULTAR_BIEN_POR_DONACION = "SELECT * FROM BIEN AS t1 INNER JOIN DONACION AS t2 ON t1.cur=t2.cur_bien";
    public static final String CONSULTAR_BIEN_POR_TRASLADO = "SELECT * FROM BIEN AS t1 INNER JOIN TRASLADO AS t2 ON t1.cur=t2.cur_bien";
    public static final String CONSULTAR_BIEN_POR_COMPRA = "SELECT * FROM BIEN WHERE tipo='compra'";
    public static final String CONSULTAR_TODOS_LOS_BIENES = "SELECT * FROM BIEN";
    public static final String CONSULTAR_BIEN_DONACION_POR_CUR = "SELECT correlativo,punto,numero_acta FROM DONACION WHERE cur_bien=?";
    public static final String CONSULTAR_BIEN_TRASLADO_POR_CUR = "SELECT fecha,autorizacion,seccion,persona_que_recibio FROM TRASLADO WHERE cur_bien=?";
    public static final String TRASLADAR_BIEN = "INSERT INTO TRASLADO(cur_bien,fecha,autorizacion,seccion,persona_que_recibio) VALUES(?,?,?,?,?)";
    public static final String DESACTIVAR_TRASLADO = "UPDATE TRASLADO SET autorizacion =0 WHERE cur_bien =?";
    //CRUD
    public static final String REGISTRAR_BIEN = "INSERT INTO BIEN VALUES(?,?,?,?,?,?,?,?)";
    public static final String REGISTRAR_BIEN_TRASLADO = "INSERT INTO TRASLADO(cur_bien,fecha,autorizacion,seccion,persona_que_recibio) VALUES(?,?,?,?,?)";
    public static final String REGISTRAR_BIEN_DONACION = "INSERT INTO DONACION(correlativo,punto,numero_acta,cur_bien) VALUES(?,?,?,?)";

}
