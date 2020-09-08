/*
 * Interfaz de Inventario DAO
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import pss1inventarioscunoc.backend.enums.TipoDeBien;
import pss1inventarioscunoc.backend.pojos.Bien;
import pss1inventarioscunoc.backend.pojos.Inventario;

/**
 *
 * @author bryan
 */
public interface InventarioDAO extends CRUD<Inventario> {

    //Metodos especiales
    public Inventario buscarInventario();

    public boolean insertarRegistroBienInventario(Bien bien);

    public double consultarTotalDeInventarioActivo(Inventario inventario);

    public double consultarTotalDeInventarioDeBaja(Inventario inventario);

    public int sumarTodosLosBienesActivosDeInventario(int numeroDeInventario);

    public int sumarTodosLosBienesDeBajaDeUnInventario(int numeroDeInventario);

    public int sumarBienesActivosPorTipo(int numeroDeInventario, TipoDeBien tipo);

    public int sumarBienesDeBajaPorTipo(int numeroDeInventario, TipoDeBien tipo);

    public LinkedList<Inventario> buscarInventariosPorDescripcion(String descripcion);

    public LinkedList<Inventario> buscarInventarioPorFecha(Timestamp fechaInicio, Timestamp fechaFinal);
    
    public int consultarTotalDeBienes(int numeroDeInventario,TipoDeBien tipo,String estado);

    //***CONSULTAS**//
    public static String INSERTAR_REGISTRO_BIEN_INVENTARIO = "INSERT INTO REGISTRO_BIEN_INVENTARIO(no_inventario,cur_bien) VALUES(?,?)";
    public static String INSERTAR_INVENTARIO = "INSERT INTO INVENTARIO(fecha_inicio,descripcion,unidad_academica,fecha_finalizacion) VALUES(?,?,?,?)";
    //Otras consultas
    //CRUD
    public static String RECUPERAR_INVENTARIOS = "SELECT * FROM INVENTARIO";
    public static String MODIFICAR_INVENTARIO = "UPDATE INVENTARIO SET fecha_inicio=?,descripcion=?,unidad_academica=?,fecha_finalizacion=? WHERE no=?";
    public static String CONSULTAR_INVENTARIO = "SELECT * FROM INVENTARIO WHERE no=?";
    public static String CONSULTAR_TOTAL_DE_INVENTARIO = "SELECT SUM(valor) AS Total FROM BIEN AS t1 \n"
            + "INNER JOIN REGISTRO_BIEN_INVENTARIO AS t2\n"
            + "ON t1.cur=t2.cur_bien\n"
            + "WHERE t1.estado=? AND t2.no_inventario=?";
    /**
     * Necesita el numero de inventario
     */
    public static String SUMA_DE_BIENES_ACTIVOS_DE_INVENTARIO
            = "SELECT SUM(t1.valor) AS Total FROM BIEN AS t1\n"
            + "JOIN REGISTRO_BIEN_INVENTARIO AS t2\n"
            + "ON t1.cur = t2.cur_bien\n"
            + "WHERE t1.estado=1 AND t2.no_inventario=?;";

    /**
     * Necesita el numero de inventario
     */
    public static String SUMA_DE_BIENES_DE_BAJA_DE_INVENTARIO
            = "SELECT SUM(t1.valor) AS Total FROM BIEN AS t1\n"
            + "JOIN REGISTRO_BIEN_INVENTARIO AS t2\n"
            + "ON t1.cur = t2.cur_bien\n"
            + "WHERE t1.estado=0 AND t2.no_inventario=?;";

    /**
     * Necesita el estado, tipo de bien, no_inventario
     */
    public static String SUMA_DE_BIENES_DE_INVENTARIO
            = "SELECT SUM(t1.valor) FROM BIEN AS t1\n"
            + "JOIN REGISTRO_BIEN_INVENTARIO AS t2\n"
            + "ON t1.cur = t2.cur_bien\n"
            + "WHERE t1.estado=? AND t1.tipo=? AND t2.no_inventario=?";

    /**
     * Devuelve todos los inventarios donde la descripcion concuerde con lo
     * buscado
     */
    public static String BUSQUEDA_DE_INVENTARIO_POR_DESCRIPCION
            = "SELECT no,fecha_inicio,descripcion,unidad_academica,fecha_finalizacion FROM INVENTARIO\n"
            + "WHERE descripcion LIKE ?";

    /**
     * Devuelve los inventarios que coincidan con las fechas
     */
    public static String BUSQUEDA_DE_INVENTARIO_POR_FECHAS
            = "SELECT * FROM INVENTARIO WHERE \n"
            + "fecha_inicio >= ? AND fecha_finalizacion <= ?";

    /**
     * Busca el total de bienes de un inventario, necesita: no_inventario,tipoDeBien,estadoDeBien
     */
    public static String BUSQUEDA_DE_BIENES_DE_INVENTARIO = ""
            + "SELECT COUNT(*) FROM BIEN AS t1 JOIN REGISTRO_BIEN_INVENTARIO AS t2 ON t1.cur=t2.cur_bien \n"
            + "WHERE t2.no_inventario=? AND t1.tipo=? AND t1.estado=?";

}
