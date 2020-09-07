/*
 * Clase Usuario como modelo
 */
package pss1inventarioscunoc.backend.pojos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author bryan
 */
public class Usuario {

    //Tipos de usuario
    public static final String USUARIO_NORMAL="normal";
    public static final String USUARIO_ADMIN="admin";
    public static final String USUARIO_VISITANTE="visitante";
    
    
    private String id_usuario;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String estado;
    private String tipo;
    private String correoElectronico;
    
    public static final String PROP_USUARIO = "id_usuario";
    public static final String PROP_NOMBRE = "nombre";
    public static final String PROP_APELLIDO = "apellido";
    public static final String PROP_CONTRASENA = "contrasena";
    public static final String PROP_ESTADO = "estado";
    public static final String PROP_TIPO = "tipo";
    public static final String PROP_CORREO_ELECTRONICO = "correoElectronico";

    public Usuario(String id_usuario, String nombre, String apellido, String contrasena, String estado, String tipo, String correoElectronico) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.estado = estado;
        this.tipo = tipo;
        this.correoElectronico = correoElectronico;
    }

    public Usuario() {
    }

    //agregamos soporte para lanzar eventos al momento que se cambie valor de un miembro
    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);
    
    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        String anterior = this.id_usuario;
        this.id_usuario = id_usuario;
        propertySupport.firePropertyChange(PROP_USUARIO, anterior, id_usuario);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String anterior = this.nombre;
        this.nombre = nombre;
        propertySupport.firePropertyChange(PROP_NOMBRE, anterior, nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        String anterior = this.apellido;
        this.apellido = apellido;
        propertySupport.firePropertyChange(PROP_APELLIDO, anterior, apellido);
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        String anterior = this.contrasena;
        this.contrasena = contrasena;
        propertySupport.firePropertyChange(PROP_CONTRASENA, anterior, contrasena);
    }
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String anterior = this.tipo;
        this.tipo = tipo;
        propertySupport.firePropertyChange(PROP_TIPO, anterior, tipo);
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        String anterior = this.correoElectronico;
        this.correoElectronico = correoElectronico;
        propertySupport.firePropertyChange(PROP_CORREO_ELECTRONICO, anterior, correoElectronico);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String anterior = this.estado;
        this.estado = estado;
        propertySupport.firePropertyChange(PROP_ESTADO, anterior, estado);
    }

    @Override
    public String toString(){
       return "--------Usuario encontrado:-----"
               + "\nid:"+this.id_usuario
               + "\nnombre:"+this.nombre
               + "\napellido:"+this.apellido
               + "\ncorreo:"+this.correoElectronico
               + "\ntipo:"+this.tipo
               + "\n------------------------------"; 
    }
    
    @Override
    public Usuario clone(){
        return new Usuario(this.id_usuario, this.nombre, this.apellido, this.contrasena, this.estado, this.tipo, this.correoElectronico);
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
