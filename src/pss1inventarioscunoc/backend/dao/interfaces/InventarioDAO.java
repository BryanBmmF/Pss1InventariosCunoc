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
public interface InventarioDAO extends CRUD<Inventario> {

    //Metodos especiales
    public Inventario buscarInventario();

    public boolean insertarRegistroBienInventario(Bien bien);

    public double consultarTotalDeInventarioActivo(Inventario inventario);

    public double consultarTotalDeInventarioDeBaja(Inventario inventario);

    //***CONSULTAS**//
    public static String INSERTAR_REGISTRO_BIEN_INVENTARIO = "INSERT INTO REGISTRO_BIEN_INVENTARIO(no_inventario,cur_bien) VALUES(?,?)";
    public static String INSERTAR_INVENTARIO ="INSERT INTO INVENTARIO(fecha_inicio,descripcion,unidad_academica,fecha_finalizacion) VALUES(?,?,?,?)";
    //Otras consultas
    //CRUD
    public static String RECUPERAR_INVENTARIOS="SELECT * FROM INVENTARIO";
    public static String MODIFICAR_INVENTARIO="UPDATE INVENTARIO SET fecha_inicio=?,descripcion=?,unidad_academica=?,fecha_finalizacion=? WHERE no=?";
    public static String CONSULTAR_INVENTARIO = "SELECT * FROM INVENTARIO WHERE no=?";
    public static String CONSULTAR_TOTAL_DE_INVENTARIO = "SELECT SUM(valor) AS Total FROM BIEN AS t1 \n"
            + "INNER JOIN REGISTRO_BIEN_INVENTARIO AS t2\n"
            + "ON t1.cur=t2.cur_bien\n"
            + "WHERE t1.estado=? AND t2.no_inventario=?";
}
