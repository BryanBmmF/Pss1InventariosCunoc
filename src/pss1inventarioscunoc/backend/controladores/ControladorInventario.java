/*
 * Controlador de Inventarios
 */
package pss1inventarioscunoc.backend.controladores;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionInventario;
import pss1inventarioscunoc.backend.dao.interfaces.InventarioDAO;
import pss1inventarioscunoc.backend.enums.TipoDeBien;
import pss1inventarioscunoc.backend.pojos.Inventario;

/**
 *
 * @author bryan
 */
public class ControladorInventario {

    public static Inventario INVENTARIO_ACTUAL = new Inventario();
    private InventarioDAO inventarioDAO;

    public ControladorInventario() {
        inventarioDAO = new ImplementacionInventario();
    }

    /**
     * Permite la creacion de inventarios
     *
     * @param inventario
     * @return
     */
    public boolean registrarInventarioi(Inventario inventario) {
        return inventarioDAO.registrar(inventario);
    }

    /**
     * Se buscan todos los inventarios del sistema
     *
     * @return
     */
    public LinkedList<Inventario> recuperarInventarios() {
        return (LinkedList<Inventario>) inventarioDAO.recuperarLista('e');
    }

    /**
     * Busca el inventario de contabilidad
     *
     * @return
     */
    public Inventario buscarInventario() {
        return INVENTARIO_ACTUAL = inventarioDAO.buscarInventario();
    }

    /**
     * Consulta el total activo, del inventario de contabilidad
     *
     * @return
     */
    public double buscarTotalDeInventariuoDeAlta() {
        return inventarioDAO.consultarTotalDeInventarioActivo(INVENTARIO_ACTUAL);
    }

    /**
     * Consulta el total dado de baja, del inventario de contabilidad
     *
     * @return
     */
    public double buscarTotalDeInventarioDeBaja() {
        return inventarioDAO.consultarTotalDeInventarioDeBaja(INVENTARIO_ACTUAL);
    }

    /**
     * *
     * Valida los datos para crear un nuevo inventario Devuelve null si son
     * incorrectos
     *
     * @param fechaInicio
     * @param descripcion
     * @param unidadAcademica
     * @param fechaFinalizacion
     * @return
     */
    public Inventario validarDatosDeInventario(Date fechaInicio, String descripcion, String unidadAcademica, Date fechaFinalizacion) {
        if (fechaInicio == null || fechaFinalizacion == null || descripcion.isEmpty() || unidadAcademica.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Faltan campos obligatorios", "Atencion", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        if (descripcion.length() >= 60) {
            JOptionPane.showMessageDialog(null, "Descripcion solo puede tener 60 caracteres", "Atencion", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        if (unidadAcademica.length() >= 60) {
            JOptionPane.showMessageDialog(null, "Unidad academica solo puede tener 45 caracteres", "Atencion", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        return new Inventario(0, new Timestamp(fechaInicio.getTime()), descripcion, unidadAcademica, new Timestamp(fechaFinalizacion.getTime()));
    }

    public boolean actualizarInventario(Inventario inventarios) {
        return inventarioDAO.actualizar(inventarios, null);
    }

    /**
     * Devuelve la suma de todos los bienes activos que se encuentren en el inventario especificado
     * @param numeroDeInventario
     * @return 
     */
    public int sumarTodosLosBienesActivosDeUnInventario(int numeroDeInventario) {
        return inventarioDAO.sumarTodosLosBienesActivosDeInventario(numeroDeInventario);
    }

    /**
     * Devuelve la suma de todos los bienes de baja que se en cuentren en el ineventario especificado
     * @param numeroDeInventario
     * @return 
     */
    public int sumarTodosLosBienesDeBajaDeUnInventario(int numeroDeInventario) {
        return inventarioDAO.sumarTodosLosBienesDeBajaDeUnInventario(numeroDeInventario);
    }
    
    /**
     * Devuelve la suma de todos los bienes activos y de tipo especificado, de el inventario especificado
     * @param numeroDeInventario
     * @param tipo
     * @return 
     */
    public int sumarBienesActivosPorTipo(int numeroDeInventario,TipoDeBien tipo){
        return inventarioDAO.sumarBienesActivosPorTipo(numeroDeInventario, tipo);
    }

    
        /**
     * Devuelve la suma de todos los bienes inactivos y de tipo especificado, de el inventario especificado
     * @param numeroDeInventario
     * @param tipo
     * @return 
     */
    public int sumarBienesDeBajaPorTipo(int numeroDeInventario,TipoDeBien tipo){
        return inventarioDAO.sumarBienesDeBajaPorTipo(numeroDeInventario, tipo);
    }
    
    
    public LinkedList<Inventario> buscarInventarioPorDescripcion(String descripcion){
        return inventarioDAO.buscarInventariosPorDescripcion(descripcion);
    }
    
    public LinkedList<Inventario> buscarInventarioPorRangoDeFecha(Timestamp fechaInicial,Timestamp fechaFinal){
        return inventarioDAO.buscarInventarioPorFecha(fechaInicial, fechaFinal);
    }
    
    /**
     * Devuelve el total de bienes de inventario
     * @param numeroDeInventario
     * @param tipo
     * @param estado
     * @return 
     */
    public int buscarTotalDeBienesDeInventario(int numeroDeInventario,TipoDeBien tipo,String estado){
        return inventarioDAO.consultarTotalDeBienes(numeroDeInventario, tipo, estado);
    }
}
