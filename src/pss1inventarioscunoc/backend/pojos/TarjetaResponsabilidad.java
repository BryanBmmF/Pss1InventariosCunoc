/*
 * Objeto de Negocios Tarjeta de Responsabilidad
 */
package pss1inventarioscunoc.backend.pojos;

import java.sql.Timestamp;

/**
 *
 * @author bryan
 */
public class TarjetaResponsabilidad {
    
    private long id;
    private Timestamp fechaApertura;
    private String descripcion;
    private long noFactura;
    private String noSerie;
    private Timestamp fechaFactura;
    private String noOrdenCompra;
    private String curBien;
    private long idResponsable;
    private String noSolicitudCompra;
    private long idProveedor;
    private String estado;

    public TarjetaResponsabilidad(long id, Timestamp fechaApertura, String descripcion, 
            long noFactura, String noSerie, Timestamp fechaFactura, String noOrdenCompra, 
            String curBien, long idResponsable, String noSolicitudCompra, long idProveedor, String estado) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.descripcion = descripcion;
        this.noFactura = noFactura;
        this.noSerie = noSerie;
        this.fechaFactura = fechaFactura;
        this.noOrdenCompra = noOrdenCompra;
        this.curBien = curBien;
        this.idResponsable = idResponsable;
        this.noSolicitudCompra = noSolicitudCompra;
        this.idProveedor = idProveedor;
        this.estado = estado;
    }
    
    public TarjetaResponsabilidad(Timestamp fechaApertura, String descripcion, 
            long noFactura, String noSerie, Timestamp fechaFactura, String noOrdenCompra, 
            String curBien, long idResponsable, long idProveedor, String estado) {
        this.fechaApertura = fechaApertura;
        this.descripcion = descripcion;
        this.noFactura = noFactura;
        this.noSerie = noSerie;
        this.fechaFactura = fechaFactura;
        this.noOrdenCompra = noOrdenCompra;
        this.curBien = curBien;
        this.idResponsable = idResponsable;
        this.idProveedor = idProveedor;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Timestamp fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(long noFactura) {
        this.noFactura = noFactura;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public Timestamp getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Timestamp fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getNoOrdenCompra() {
        return noOrdenCompra;
    }

    public void setNoOrdenCompra(String noOrdenCompra) {
        this.noOrdenCompra = noOrdenCompra;
    }

    public String getCurBien() {
        return curBien;
    }

    public void setCurBien(String curBien) {
        this.curBien = curBien;
    }

    public long getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(long idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getNoSolicitudCompra() {
        return noSolicitudCompra;
    }

    public void setNoSolicitudCompra(String noSolicitudCompra) {
        this.noSolicitudCompra = noSolicitudCompra;
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
    
}
