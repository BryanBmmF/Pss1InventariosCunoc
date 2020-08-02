/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.pojos;

/**
 *
 * @author bryan
 */
public class Usuario {

    //Tipos de usuario
    public static final String USUARIO_NORMAL="normal";
    public static final String USUARIO_ADMIN="admin";
    
    
    private String id_usuario;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String estado;
    private String tipo;
    private String correoElectronico;

    public Usuario(String id_usuario, String nombre, String apellido, String contrasena, String estado, String tipo, String correoElectronico) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.estado = estado;
        this.tipo = tipo;
        this.correoElectronico = correoElectronico;
    }

    
    
    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
    
}
