/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import pss1inventarioscunoc.backend.pojos.LogIngreso;

/**
 *
 * @author jesfrin
 */
public interface LogIngresoDAO extends CRUD<LogIngreso> {

    /*Operaciones Especiales*/
    public int busquedaDeLogEvento();

    /*Querys a utilizar*/
    public static final String BUSQUEDA_ID ="SELECT id FROM LOG_INGRESO ORDER BY id DESC LIMIT 1";

    //CRUD
    public static final String INGRESO_LOG="INSERT INTO LOG_INGRESO(fecha,tipo,id_usuario,descripcion) VALUES(?,?,?,?)";
}
