/*
 * Objeto de Negocio Bien
 */
package pss1inventarioscunoc.backend.pojos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.sql.Timestamp;
import pss1inventarioscunoc.backend.enums.TipoDeBien;

/**
 *
 * @author bryan
 */
public class Bien implements Serializable{
    
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
    
    public static final String PROP_CUR = "cur";
    public static final String PROP_ID_FACT = "idFactura";
    public static final String PROP_PROCEDENCIA = "procedencia";
    public static final String PROP_ESTADO = "estado";
    public static final String PROP_DESCRIPCION = "descripcion";
    public static final String PROP_TIPO = "tipo";
    public static final String PROP_VALOR = "valor";
    public static final String PROP_DIVISION = "division";
    public static final String PROP_CORRELATIVO = "correlativo";
    public static final String PROP_PUNTO = "punto";
    public static final String PROP_NUMERO_ACTA = "numeroActa";
    public static final String PROP_FECHA = "fecha";
    public static final String PROP_AUTORIZACION = "autorizacion";
    public static final String PROP_SECCION = "seccion";
    public static final String PROP_PERSONA_RECIBE = "personaQueRecibe";
    
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

    public Bien() {
        /*vacio*/
    }
    //agregamos soporte para lanzar eventos al momento que se cambie valor de un miembro
    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);
    
    public String getCur() {
        return cur;
    }

    public void setCur(String cur) {
        String anterior = this.cur;
        this.cur = cur;
        propertySupport.firePropertyChange(PROP_CUR, anterior, cur);
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        int anterior = this.idFactura;
        this.idFactura = idFactura;
        propertySupport.firePropertyChange(PROP_ID_FACT, anterior, idFactura);
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        String anterior = this.procedencia;
        this.procedencia = procedencia;
        propertySupport.firePropertyChange(PROP_PROCEDENCIA, anterior, procedencia);
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        char anterior = this.estado;
        this.estado = estado;
        propertySupport.firePropertyChange(PROP_ESTADO, anterior, estado);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String anterior = this.descripcion;
        this.descripcion = descripcion;
        propertySupport.firePropertyChange(PROP_DESCRIPCION, anterior, descripcion);
    }

    public TipoDeBien getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeBien tipo) {
        TipoDeBien anterior = this.tipo;
        this.tipo = tipo;
        propertySupport.firePropertyChange(PROP_TIPO, anterior, tipo);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        double anterior = this.valor;
        this.valor = valor;
        propertySupport.firePropertyChange(PROP_VALOR, anterior, valor);
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        String anterior = this.division;
        this.division = division;
        propertySupport.firePropertyChange(PROP_DIVISION, anterior, division);
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        int anterior = this.correlativo;
        this.correlativo = correlativo;
        propertySupport.firePropertyChange(PROP_CORRELATIVO, anterior, correlativo);
    }

    public String getPunto() {
        return punto;
    }

    public void setPunto(String punto) {
        String anterior = this.punto;
        this.punto = punto;
        propertySupport.firePropertyChange(PROP_PUNTO, anterior, punto);
    }

    public int getNumeroActa() {
        return numeroActa;
    }

    public void setNumeroActa(int numeroActa) {
        int anterior = this.numeroActa;
        this.numeroActa = numeroActa;
        propertySupport.firePropertyChange(PROP_NUMERO_ACTA, anterior, numeroActa);
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        Timestamp anterior = this.fecha;
        this.fecha = fecha;
        propertySupport.firePropertyChange(PROP_FECHA, anterior, fecha);
    }

    public char getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(char autorizacion) {
        char anterior = this.autorizacion;
        this.autorizacion = autorizacion;
        propertySupport.firePropertyChange(PROP_AUTORIZACION, anterior, autorizacion);
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        String anterior = this.seccion;
        this.seccion = seccion;
        propertySupport.firePropertyChange(PROP_SECCION, anterior, seccion);
    }

    public String getPersonaQueRecibio() {
        return personaQueRecibio;
    }

    public void setPersonaQueRecibio(String personaQueRecibio) {
        String anterior = this.personaQueRecibio;
        this.personaQueRecibio = personaQueRecibio;
        propertySupport.firePropertyChange(PROP_PERSONA_RECIBE, anterior, personaQueRecibio);
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
    
    
    public Bien cloneCompra(){
        return new Bien(this.cur, this.idFactura, this.procedencia, this.estado, this.descripcion, this.tipo, this.valor, this.division);
    }
    public Bien cloneDonacion(){
        return new Bien(this.cur, this.idFactura, this.procedencia, this.estado, this.descripcion, this.tipo, this.valor, this.division, this.correlativo, this.punto, this.numeroActa);
    }
    public Bien cloneTraslado(){
        return new Bien(this.cur, this.idFactura, this.procedencia, this.estado, this.descripcion, this.tipo, this.valor, this.division, this.fecha, this.autorizacion, this.seccion, this.personaQueRecibio);
    }
    
    /** 
     * Metodo especifico para agregar un escucha de cambios
     *
     * @param listener
    */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    /**
     * Metodo especifico para quitar un escucha de cambios
     *
     * @param listener
    */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
