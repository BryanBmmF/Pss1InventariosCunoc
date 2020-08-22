/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;
import pss1inventarioscunoc.backend.pojos.Factura;

/**
 *
 * @author jesfrin
 */
public interface FacturaDAO extends CRUD<Factura> {

    /*Operaciones especiales*/
    public ArrayList<Factura> buscarFacturaPorProveedor(String nombreProveedor);
    public ArrayList<Factura> buscarFacturaPorFecha(Timestamp fechaInicial, Timestamp fechaFinal);
    public Factura buscarFacturaPorId(int idFactura);
    public boolean registrarFacturaConProveedor(Factura factura);

    public boolean registrarFacturaSinProveedor(Factura factura);

    public boolean actualizarFacturaYSuProveedor(Factura factura);
    public boolean actualizarFacturaQuitandoProveedor(Factura factura);

    /*Querys a utilizar*/
    public static final String BUSCAR_FACTURA_POR_PROVEEDOR = "SELECT t1.id_Factura,t1.id_Proveedor,t1.numero_Factura,t1.fecha,t1.descripcion,t1.valor,t2.nombre_Proveedor FROM FACTURA AS t1 INNER JOIN PROVEEDOR AS t2 ON t1.id_Proveedor=t2.id_Proveedor WHERE t2.nombre_Proveedor LIKE ?";
    public static final String BUSCAR_FACTURA_POR_ID = "SELECT * FROM FACTURA WHERE id_Factura = ?";
    public static final String BUSCAR_FACTURA_POR_FECHA = "SELECT t1.id_Factura,t1.id_Proveedor,t1.numero_Factura,t1.fecha,t1.descripcion,t1.valor,t2.nombre_Proveedor FROM FACTURA AS t1 LEFT JOIN PROVEEDOR AS t2 ON t1.id_Proveedor=t2.id_Proveedor WHERE t1.fecha BETWEEN ? AND ?";
    public static final String MODIFICAR_FACTURA = "UPDATE FACTURA SET numero_Factura=?, fecha=?, descripcion=?, valor=?,id_proveedor=? WHERE id_Factura=?";
    public static final String MODIFICAR_FACTURA_ELIMINANDO_PROVEEDOR = "UPDATE FACTURA SET numero_Factura=?, fecha=?, descripcion=?, valor=?,id_proveedor=null WHERE id_Factura=?";
    
//CRUD
    public static final String BUSCAR_FACTURA = "SELECT t1.id_Factura,t1.id_Proveedor,t1.numero_Factura,t1.fecha,t1.descripcion,t1.valor,t2.nombre_Proveedor FROM FACTURA AS t1 LEFT JOIN PROVEEDOR AS t2 ON t1.id_Proveedor=t2.id_Proveedor";
    public static final String INSERTAR_FACTURA_CON_PROVEEDOR = "INSERT INTO FACTURA(id_Proveedor,numero_Factura,fecha,descripcion,valor) VALUES(?,?,?,?,?)";
    public static final String INSERTAR_FACTURA_SIN_PROVEEDOR = "INSERT INTO FACTURA(numero_Factura,fecha,descripcion,valor) VALUES(?,?,?,?)";

}
