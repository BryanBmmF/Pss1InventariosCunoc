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
public class Factura {
    
    private int idFactura;
    private int idProveedor;
    private int numeroFactura;
    private Timestamp fecha;
    private String descripcion;
    private double valor;
    private String nombreProveedor;
    /**
     * Para recuperacion de facturas
     * @param idFactura
     * @param idProveedor
     * @param numeroFactura
     * @param fecha
     * @param descripcion
     * @param valor 
     */
    public Factura(int idFactura, int idProveedor, int numeroFactura, Timestamp fecha, String descripcion, double valor,String nombreProveedor) {
        this.idFactura = idFactura;
        this.idProveedor = idProveedor;
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.valor = valor;
        this.nombreProveedor=nombreProveedor;
    }
/**
 * Para ingreso de facturas
 * @param idProveedor
 * @param numeroFactura
 * @param fecha
 * @param descripcion
 * @param valor 
 */
    public Factura(int idProveedor, int numeroFactura, Timestamp fecha, String descripcion, double valor) {
        this.idProveedor = idProveedor;
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    
    
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String toString(){
        return "->Id"+this.idFactura+
               "\nIdProveedor"+this.idProveedor+
               "\nNumero:"+this.numeroFactura+
               "\nFecha:"+this.fecha+
               "\nDescripcion"+this.descripcion+
               "\nValor"+this.valor+
               "\nNombre Proveedor:"+this.nombreProveedor;
    }
    
}
