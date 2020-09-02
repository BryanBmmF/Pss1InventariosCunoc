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
public enum EstadoObjeto {
    
    ACTIVO("activo"),INACTIVO("inactivo"),;
    
    private String estado;

    private EstadoObjeto(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
