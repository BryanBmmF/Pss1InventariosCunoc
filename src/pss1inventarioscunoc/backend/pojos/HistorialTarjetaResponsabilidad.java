/*
 * Objeto de Negocios Tarjeta de Responsabilidad
 */
package pss1inventarioscunoc.backend.pojos;

import java.sql.Timestamp;

/**
 *
 * @author bryan
 */
public class HistorialTarjetaResponsabilidad {
    
    private long id;
    private long idTarjetaResponsabilidad;
    private Timestamp fechaModificacion;
    private long idResponsable;
    private long idProveedor;
    private String estado;
    private long noFactura;

    public HistorialTarjetaResponsabilidad(long id, long idTarjetaResponsabilidad, 
            Timestamp fechaModificacion, long idResponsable, long idProveedor, 
            String estado, long noFactura) {
        this.id = id;
        this.idTarjetaResponsabilidad = idTarjetaResponsabilidad;
        this.fechaModificacion = fechaModificacion;
        this.idResponsable = idResponsable;
        this.idProveedor = idProveedor;
        this.estado = estado;
        this.noFactura = noFactura;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdTarjetaResponsabilidad() {
        return idTarjetaResponsabilidad;
    }

    public void setIdTarjetaResponsabilidad(long idTarjetaResponsabilidad) {
        this.idTarjetaResponsabilidad = idTarjetaResponsabilidad;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public long getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(long idResponsable) {
        this.idResponsable = idResponsable;
    }

    public long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(long noFactura) {
        this.noFactura = noFactura;
    }
    
    
    
}
