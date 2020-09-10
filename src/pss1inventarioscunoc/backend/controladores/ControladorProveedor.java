/*
 * Controlador de proveedores
 */
package pss1inventarioscunoc.backend.controladores;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionProveedor;
import pss1inventarioscunoc.backend.dao.interfaces.ProveedorDAO;
import pss1inventarioscunoc.backend.pojos.Proveedor;
import pss1inventarioscunoc.frontend.tarjetasresponsabilidad.ModificacionTarjetaResponsabilidad;

/**
 *
 * @author bryan
 */
public class ControladorProveedor {

    private ProveedorDAO proveedorDAO;
    /*valores predeterminados de un bien sin se especifica una factura,
        esto con el fin de que si despues se le quiera asociar una factura 
        no tenga que borrar el bien y crearlo de nuevo*/
    public static Proveedor proveedorPredetermindo;

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
        return (ArrayList<Proveedor>) proveedorDAO.recuperarLista('e');
    }

    /**
     * FIltra los proveedores por el nombre indicado
     *
     * @param nombre
     * @return
     */
    public ArrayList<Proveedor> buscarProveedoresPorNombre(String nombre) {
        return (ArrayList<Proveedor>) proveedorDAO.buscarProveedoresPorNombre(nombre);
    }

    /**
     * Filtra proveedores por la direccion indicada
     *
     * @param direccion
     * @return
     */
    public ArrayList<Proveedor> buscarProveedoresPorDireccion(String direccion) {
        return (ArrayList<Proveedor>) proveedorDAO.buscarProveedoresPorDireccion(direccion);
    }

    /**
     * Filtra proveedores por la descripcion indicada
     *
     * @param descripcion
     * @return
     */
    public ArrayList<Proveedor> buscarProveedoresPorDescripcion(String descripcion) {
        return (ArrayList<Proveedor>) proveedorDAO.buscarProveedorPorDescripcion(descripcion);
    }

    /**
     * Modifica el proveedor enviado en la base de datos
     *
     * @param proveedor
     * @return
     */
    public boolean modificarProveedor(Proveedor proveedor) {
        return proveedorDAO.modificarProveedor(proveedor);
    }

    /**
     * Verifica datos del proveedor, si todo esta correcto regresa True
     *
     * @param nombreProveedor
     * @param nit
     * @param direccion
     * @param descipcion
     * @param correoElectronico
     * @return
     */
    public boolean verificarDatosProveedor(String nombreProveedor, String nit, String direccion, String descipcion, String correoElectronico) {
        if (nombreProveedor.isEmpty() || nit.isEmpty() || direccion.isEmpty() || descipcion.isEmpty() || correoElectronico.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Faltan datos para poder crear un proveedor",
                    "Datos incompletos",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (nombreProveedor.length() > 45) {
            JOptionPane.showMessageDialog(null, "Nombre debe tener 45 caracteres como maximo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (nit.length() > 9) {
            JOptionPane.showMessageDialog(null, "Nit debe tener 9 caracteres como maximo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (direccion.length() > 50) {
            JOptionPane.showMessageDialog(null, "Direccion debe tener 50 caracteres como maximo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (descipcion.length() > 45) {
            JOptionPane.showMessageDialog(null, "Descripcion debe tener 45 caracteres como maximo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (correoElectronico.length() > 45 || !correoElectronico.contains("@") || !correoElectronico.contains(".")) {
            JOptionPane.showMessageDialog(null, "COrreo debe tener 45 caracteres como maximo, y debe contener @ y .", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    /**
     * ===== Metodos pertenecientes a GUI ModificacionTarjetaResponsabilidad =====
     */
    
    public void actualizarProveedoresModificacionTarjetaResponsabilidad(ModificacionTarjetaResponsabilidad ceb){
        ceb.getListaProveedoresObsr().clear();
        ceb.getListaProveedoresObsr().addAll(this.buscarProveedores());
    }
    
    public void tablaProveedoresMouseClickedModificacionTarjetaResponsabilidad(ModificacionTarjetaResponsabilidad ceb){
        ceb.getSelectedProveedorLabel().setText(Integer.toString(ceb.getSelectedProveedor().getIdProveedor()));
        ceb.setTableProveedoresSelected(true);
    }
    
    /**
     * Verifica que que el proveedor predeterminado no haya sido creado
     *
     * @return proveedor predetrminado
     */
    public Proveedor consultarProveedorPred() {
        //verificando que el proveedor no este seteado ya
        if (proveedorPredetermindo!=null) {
            return proveedorPredetermindo;
        } else {
            /*sino esta ya en la BD hay que crearlo por defecto*/
            proveedorPredetermindo = proveedorDAO.buscarProveedor("PROVEEDOR_UNICO_PREDETERMINADO");
            
            if (proveedorPredetermindo==null) {
                proveedorPredetermindo = new Proveedor("PROVEEDOR_UNICO_PREDETERMINADO", "--------", "--------", "--------", "--------");
                registrar(proveedorPredetermindo);
                proveedorPredetermindo = proveedorDAO.buscarProveedor("PROVEEDOR_UNICO_PREDETERMINADO");
            } 
            System.out.println(""+proveedorPredetermindo.getNombreDeProveedor()+proveedorPredetermindo.getIdProveedor());
            return proveedorPredetermindo;
        }
    }

    public static Proveedor getProveedorPredetermindo() {
        return proveedorPredetermindo;
    }

    public static void setProveedorPredetermindo(Proveedor proveedorPredetermindo) {
        ControladorProveedor.proveedorPredetermindo = proveedorPredetermindo;
    }
 
    
}
