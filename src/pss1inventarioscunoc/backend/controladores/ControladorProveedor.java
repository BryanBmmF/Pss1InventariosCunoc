/*
 * Controlador de proveedores
 */
package pss1inventarioscunoc.backend.controladores;

import java.util.ArrayList;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionProveedor;
import pss1inventarioscunoc.backend.dao.interfaces.ProveedorDAO;
import pss1inventarioscunoc.backend.pojos.Proveedor;

/**
 *
 * @author bryan
 */
public class ControladorProveedor {

    private ProveedorDAO proveedorDAO;

    public ControladorProveedor() {
        this.proveedorDAO = new ImplementacionProveedor();
    }

    /**
     * Registra el proveedor, devuelve falso ssi no lo ha insertado
     *
     * @param proveedor
     * @return
     */
    public boolean registrar(Proveedor proveedor) {
        return proveedorDAO.registrar(proveedor);
    }

    /**
     * Recuperacion de todos los proveedores ingresados
     *
     * @return
     */
    public ArrayList<Proveedor> buscarProveedores() {
        return (ArrayList<Proveedor>) proveedorDAO.recuperarLista();
    }

    /**
     * FIltra los proveedores por el nombre indicado
     * @param nombre
     * @return 
     */
    public ArrayList<Proveedor> buscarProveedoresPorNombre(String nombre) {
        return (ArrayList<Proveedor>) proveedorDAO.buscarProveedoresPorNombre(nombre);
    }

    /**
     * Filtra proveedores por la direccion indicada
     * @param direccion
     * @return 
     */
    public ArrayList<Proveedor> buscarProveedoresPorDireccion(String direccion) {
        return (ArrayList<Proveedor>) proveedorDAO.buscarProveedoresPorDireccion(direccion);
    }

    /**
     * Filtra proveedores por la descripcion indicada
     * @param descripcion
     * @return 
     */
    public ArrayList<Proveedor> buscarProveedoresPorDescripcion(String descripcion) {
        return (ArrayList<Proveedor>) proveedorDAO.buscarProveedorPorDescripcion(descripcion);
    }

    
    /**
     * Modifica el proveedor enviado en la base de datos
     * @param proveedor
     * @return 
     */
    public boolean modificarProveedor(Proveedor proveedor){
        return proveedorDAO.modificarProveedor(proveedor);
    }
    
    /**
     * Verifica datos del proveedor, si todo esta correcto regresa True
     * @param datosProveedor
     * @return 
     */
    public boolean verificarDatosProveedor(ArrayList<String> datosProveedor){
        for (String dato : datosProveedor) {
            if(dato.isEmpty())return false;
        }
        return true;
    } 
}
