/*
 * Objeto de negocios Inventario
 */
package pss1inventarioscunoc.backend.pojos;

import java.sql.Timestamp;

/**
 *
 * @author bryan
 */
public class Inventario {
    
    private int numero;
    private Timestamp fechaInicio;
    private String descripcion;
    private String unidadAcademica;
    private Timestamp fechaFinalizacion;

    public Inventario(int numero, Timestamp fechaInicio, String descripcion, String unidadAcademica, Timestamp fechaFinalizacion) {
        this.numero = numero;
        this.fechaInicio = fechaInicio;
        this.descripcion = descripcion;
        this.unidadAcademica = unidadAcademica;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    /**
     * A la hora de iniciar sesion se le asignara un inventario 0, el cual no existe en la bd,
     * cambiara cuando el usuario escoja el inventario que desea
     *  
     */
    public Inventario(){
        this.numero=0;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(String unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    public Timestamp getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Timestamp fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    @Override
    public String toString(){
        return "---------Informacion de inventario-------"
                +"\nNumero:"+this.numero
                + "\nDescripcion:"+this.descripcion
                +"\nFecha inicio:"+this.fechaInicio
                +"\nFecha final"+this.fechaFinalizacion
                +"---------------------------------------";
    }
    
}
