/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import pss1inventarioscunoc.backend.pojos.Factura;

/**
 *
 * @author jesfrin
 */
public interface FacturaDAO extends CRUD<Factura>{
    
    /*Operaciones especiales*/
    
    /*Querys a utilizar*/
    
    //CRUD
    public static final String INSERTAR_FACTURA="INSERT INTO FACTURA(id_Proveedor,numero_Factura,fecha,descripcion,valor) VALUES(?,?,?,?,?)";
    
    
    
}
