/*
 * Objeto de negocio Proveedor
 */
package pss1inventarioscunoc.backend.pojos;

import java.sql.Timestamp;

/**
 *
 * @author bryan
 */
public class Proveedor {
    
    private int idProveedor;
    private String nombreDeProveedor;
    private String nit;
    private String direccion;
    private String descripcion;
    private String correoElectronico;

    /**
     * Recuperar Proveedor/Modificar Proveedor
     * @param idProveedor
     * @param nombreDeProveedor
     * @param nit
     * @param direccion
     * @param descripcion
     * @param correoElectronico 
     */
    public Proveedor(int idProveedor, String nombreDeProveedor, String nit, String direccion, String descripcion, String correoElectronico) {
        this.idProveedor = idProveedor;
        this.nombreDeProveedor = nombreDeProveedor;
        this.nit = nit;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.correoElectronico = correoElectronico;
    }
 
    /**
     * Ingresar proveedor
     * @param nombreDeProveedor
     * @param nit
     * @param direccion
     * @param descripcion
     * @param correoElectronico 
     */
    public Proveedor(String nombreDeProveedor, String nit, String direccion, String descripcion, String correoElectronico) {
        this.nombreDeProveedor = nombreDeProveedor;
        this.nit = nit;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.correoElectronico = correoElectronico;
    }
    
        /**
     * Actualizar proveedor
     * @param nombreDeProveedor
     * @param nit
     * @param direccion
     * @param descripcion
     * @param correoElectronico 
     */
    public Proveedor(String nombreDeProveedor, String nit, String direccion, String descripcion, String correoElectronico,int idProveedor) {
        this.nombreDeProveedor = nombreDeProveedor;
        this.nit = nit;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.correoElectronico = correoElectronico;
        this.idProveedor=idProveedor;
    }
    

    public Proveedor() {
    }
    
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreDeProveedor() {
        return nombreDeProveedor;
    }

    public void setNombreDeProveedor(String nombreDeProveedor) {
        this.nombreDeProveedor = nombreDeProveedor;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    @Override
    public String toString(){
        return "----------Proveedor-------"
               +"\nId:"+this.idProveedor
               +"\nNombre:"+this.nombreDeProveedor
               +"\nCorreo:"+this.correoElectronico
               +"\nDescripcion:"+this.descripcion
               +"\nDireccion:"+this.direccion;
    }
    
    
}
