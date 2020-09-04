/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.enums;

/**
 *
 * @author fabricio
 */
public enum Vista {
    
    INICIO("Ventana de Inicio",GrupoVista.INICIO,1),
    VENTANA_REGISTRO("Inicio de Sesion",GrupoVista.SESION,2),
    VENTANA_SESION("Creacion de Sesion",GrupoVista.SESION,3),
    BIENES_JPANEL1("Panel de Bienes",GrupoVista.BIENES,4),
    FACTURAS_JPANEL("Panel de Facturas",GrupoVista.BIENES,5),
    LISTADO_DE_FACTURAS_JDIALOG("Panel de Listado de Facturas",GrupoVista.BIENES,6),
    LISTADO_DE_PROVEEDORES("Listado de Proveedores",GrupoVista.BIENES,7),
    MODIFICAR_PROVEEDOR_JDIALOG("Panel de Modificar Proveedor",GrupoVista.BIENES,8),
    PROVEEDOR_JPANEL("Panel de Proveedor",GrupoVista.BIENES,9),
    MANEJO_ENCARGADOS("Manejo de Encargados",GrupoVista.ENCARGADOS,10),
    ASIGNACION_ENCARGADOS("Asignacion de Encargados",GrupoVista.ENCARGADOS,11),
    REPORTE_TARJETAS_RESPONSABILIDAD("Reporte de Tarjetas de Responsabilidad", GrupoVista.TARJETAS_RESPONSABILIDAD,12),
    CONSULTA_BIENES("Consulta de Bienes",GrupoVista.BIENES,13),
    CONSULTA_BIENES_BAJA("Consulta de Bienes dados de Baja",GrupoVista.BIENES,14),
    REPORTE_BIENS_1("Reporte de Bienes en Inventario",GrupoVista.INVENTARIOS,15),
    INVENTARIOS("Inventarios",GrupoVista.INVENTARIOS,16),
    REPORTE_BIENES_TIPO("Reporte de Bienes por Tipo",GrupoVista.REPORTES,17),
    REPORTE_BIENES_PROVEEDOR("Reporte de Bienes por Proveedor",GrupoVista.REPORTES,18),
    REPORTE_BIENES_ENCARGADO("Reporte de Bienes por Encargado",GrupoVista.REPORTES,19),
    MODIFICACION_TARJETAS("Modificacion Tarjeta Responsabilidad",GrupoVista.TARJETAS_RESPONSABILIDAD,20),
    ;
    
    private String nombre;
    private GrupoVista grupo;
    private int item;

    private Vista (String nombre, GrupoVista grupo, int item){
        this.nombre = nombre;
        this.grupo = grupo;
        this.item = item;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public GrupoVista getGrupo(){
        return this.grupo;
    }
    
    public int getItem(){
        return this.item;
    }
    
}
