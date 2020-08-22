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
public enum GrupoVista {
    
    INICIO("Inicio"),
    SESION("Sesion"),
    BIENES("Bienes"),
    REPORTES("Reportes"),
    ENCARGADOS("Encargados"),
    TARJETAS_RESPONSABILIDAD("Tarjetas")
    ;
    
    private String nombre;

    private GrupoVista(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    
}
