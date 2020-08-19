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
