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
    
    INICIO("Ventana de Inicio",GrupoVista.INICIO),
    SIGN_IN("Inicio de Sesion",GrupoVista.SESION),
    SIGN_UP("Creacion de Sesion",GrupoVista.SESION),
    BIENES("Panel de Bienes",GrupoVista.BIENES),
    FACTURAS("Panel de Facturas",GrupoVista.BIENES),
    PROVEEDOR("Panel de Proveedor",GrupoVista.BIENES),
    REPORTE_BIENES("Reporte de Bienes",GrupoVista.BIENES),
    MANEJO_ENCARGADOS("Manejo de Encargados",GrupoVista.ENCARGADOS),
    
    ;
    
    private String nombre;
    private GrupoVista grupo;

    private Vista (String nombre, GrupoVista grupo){
        this.nombre = nombre;
        this.grupo = grupo;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public GrupoVista getGrupo(){
        return this.grupo;
    }
    
}
