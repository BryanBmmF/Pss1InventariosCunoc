/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.pojos;

import java.sql.Timestamp;

/**
 *
 * @author jesfrin
 */
public class LogIngreso {
    
    
    private int id;
    private Timestamp fecha;
    private String tipo;
    private String idUsuario;
    private String deescripcion;

    public LogIngreso(Timestamp fecha, String tipo, String idUsuario, String deescripcion) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        this.deescripcion = deescripcion;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDeescripcion() {
        return deescripcion;
    }

    public void setDeescripcion(String deescripcion) {
        this.deescripcion = deescripcion;
    }
    
    
    
}
