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


    public ArrayList<Proveedor> buscarProveedoresPorDireccion(String direccion) {
        return (ArrayList<Proveedor>) proveedorDAO.buscarProveedoresPorDireccion(direccion);
    }

    
    public ArrayList<Proveedor> buscarProveedoresPorDescripcion(String descripcion) {
        return (ArrayList<Proveedor>) proveedorDAO.buscarProveedorPorDescripcion(descripcion);
    }


}
