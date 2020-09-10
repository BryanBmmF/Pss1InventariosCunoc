/*
 * Interfaz de Proveddor DAO
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import java.util.ArrayList;
import pss1inventarioscunoc.backend.pojos.Proveedor;

/**
 *
 * @author bryan
 */
public interface ProveedorDAO extends CRUD<Proveedor>{
    
    /*Operaciones especiales*/
    public ArrayList<Proveedor> buscarProveedoresPorNombre(String nombre);
    public ArrayList<Proveedor> buscarProveedoresPorDireccion(String direccion);
    public ArrayList<Proveedor> buscarProveedorPorDescripcion(String descripcion);
    public boolean modificarProveedor(Proveedor proveedor);
    public Proveedor buscarProveedor(String nombre);
    /*Querys a utilizar*/
    public static final String BUSQUEDA_POR_NOMBRE="SELECT * FROM PROVEEDOR WHERE nombre_Proveedor LIKE ?";
    public static final String BUSQUEDA_POR_NOMBRE_UNICO="SELECT * FROM PROVEEDOR WHERE nombre_Proveedor=?";
    public static final String BUSQUEDA_POR_DIRECCION="SELECT * FROM PROVEEDOR WHERE direccion LIKE ?";
    public static final String BUSQUEDA_POR_DESCRIPCION="SELECT * FROM PROVEEDOR WHERE descripcion LIKE ?";
    public static final String MODIFICAR_PROVEEDOR="UPDATE PROVEEDOR SET nombre_Proveedor=?,nit=?,direccion=?,descripcion=?,correoElectronico=? WHERE id_Proveedor=?";

    //CRUD
    public static final String INSERTAR_PROVEEDOR = "INSERT INTO PROVEEDOR(nombre_Proveedor,nit,direccion,descripcion,correoElectronico) VALUES(?,?,?,?,?)";
    public static final String BUSCAR_PROVEEDORES = "SELECT * FROM PROVEEDOR";
}
