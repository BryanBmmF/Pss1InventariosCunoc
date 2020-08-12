/*
 * Objeto de Negocio Bien
 */
package pss1inventarioscunoc.backend.pojos;

import java.sql.Timestamp;
import pss1inventarioscunoc.backend.enums.TipoDeBien;

/**
 *
 * @author bryan
 */
public class Bien {
    
    private String cur;
    private int idFactura;
    private String procedencia;
    private char estado;
    private String descripcion;
    private TipoDeBien tipo;
    private double valor;
    private String division;
    
    //Atributos para bienes por donacion
    private int correlativo;
    private String punto;
    private int numeroActa;
    //Atriburos para bienes por Traslado
    private Timestamp fecha;
    private char autorizacion;
    private String seccion;
    private String personaQueRecibio;
    
    /**
     * Para ingreso de bien por traslado
     * @param cur
     * @param idFactura
     * @param procedencia
     * @param estado
     * @param descripcion
     * @param tipo
     * @param valor
     * @param division
     * @param fecha
     * @param autorizacion
     * @param seccion
     * @param personaQueRecibio 
     */
    public Bien(String cur, int idFactura, String procedencia, char estado, String descripcion, TipoDeBien tipo, double valor, String division, Timestamp fecha, char autorizacion, String seccion, String personaQueRecibio) {
        this.cur = cur;
        this.idFactura = idFactura;
        this.procedencia = procedencia;
        this.estado = estado;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valor = valor;
        this.division = division;
        this.fecha = fecha;
        this.autorizacion = autorizacion;
        this.seccion = seccion;
        this.personaQueRecibio = personaQueRecibio;
    }
    
    

    /**
     * Para ingreso de bien por compra
     * @param cur
     * @param idFactura
     * @param procedencia
     * @param estado
     * @param descripcion
     * @param tipo
     * @param valor
     * @param division 
     */
    public Bien(String cur, int idFactura, String procedencia, char estado, String descripcion, TipoDeBien tipo, double valor, String division) {
        this.cur = cur;
        this.idFactura = idFactura;
        this.procedencia = procedencia;
        this.estado = estado;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valor = valor;
        this.division = division;
    }
    
    /**
     * Para ingreso de bien por donacion
     * @param cur
     * @param idFactura
     * @param procedencia
     * @param estado
     * @param descripcion
     * @param tipo
     * @param valor
     * @param division
     * @param correlativo
     * @param punto
     * @param numeroActa 
     */
    public Bien(String cur, int idFactura, String procedencia, char estado, String descripcion, TipoDeBien tipo, double valor, String division, int correlativo, String punto, int numeroActa) {
        this.cur = cur;
        this.idFactura = idFactura;
        this.procedencia = procedencia;
        this.estado = estado;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valor = valor;
        this.division = division;
        this.correlativo = correlativo;
        this.punto = punto;
        this.numeroActa = numeroActa;
    }


    
    
    
    public String getCur() {
        return cur;
    }

    public void setCur(String cur) {
        this.cur = cur;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoDeBien getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeBien tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public String getPunto() {
        return punto;
    }

    public void setPunto(String punto) {
        this.punto = punto;
    }

    public int getNumeroActa() {
        return numeroActa;
    }

    public void setNumeroActa(int numeroActa) {
        this.numeroActa = numeroActa;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public char getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(char autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getPersonaQueRecibio() {
        return personaQueRecibio;
    }

    public void setPersonaQueRecibio(String personaQueRecibio) {
        this.personaQueRecibio = personaQueRecibio;
    }
    
    @Override
    public String toString(){
        return "---->Cur:"+this.cur
                +"\nidFactura:"+this.idFactura
                +"\nprocedencia:"+this.procedencia
                +"\nestado:"+this.estado
                +"\ndescripcion:"+this.descripcion
                +"\ntipoDeBien:"+this.tipo
                +"\nvalor:"+this.valor
                +"\ndivision:"+this.division
                +"\ncorrelativo:"+this.correlativo
                +"\npunto:"+this.punto
                +"\nnumeroActa:"+this.numeroActa
                +"\nfecha:"+this.fecha
                +"\nautorizacion:"+this.autorizacion
                +"\nseccion:"+this.seccion
                +"\npersonaQueRecibio:"+this.personaQueRecibio+"\n\n\n";
                        
                        
    }
}
