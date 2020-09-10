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
public enum EstadoUsuario {
    
    HABILITADO("habilitado"), INHABILITADO("inhabilitado"),;
    
    private String estado;

    private EstadoUsuario(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
    
}
