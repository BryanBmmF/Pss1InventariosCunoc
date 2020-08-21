/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.controladores;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionFactura;
import pss1inventarioscunoc.backend.dao.interfaces.FacturaDAO;
import pss1inventarioscunoc.backend.pojos.Factura;
import pss1inventarioscunoc.backend.pojos.Proveedor;

/**
 *
 * @author jesfrin
 */
public class ControladorFactura {

    private FacturaDAO facturaDao;

    public ControladorFactura() {
        facturaDao = new ImplementacionFactura();
    }

    /**
     * Devuelve true si se efectuo el ingreso de la factura
     *
     * @param factura
     * @return
     */
    public boolean registrar(Factura factura) {
        return facturaDao.registrar(factura);
    }

    /**
     * Ingresa una factura con proveedor al sistema
     *
     * @param factura
     * @return
     */
    public boolean registrarFacturaConProveedor(Factura factura) {
        return facturaDao.registrarFacturaConProveedor(factura);
    }

    /**
     * Ingresa una factura sin proveedor al sistema
     *
     * @param factura
     * @return
     */
    public boolean registrarFacturaSinProveedor(Factura factura) {
        return facturaDao.registrarFacturaSinProveedor(factura);
    }

    /**
     * Devuelve todas las facturas del sistema, null si hubiera errores de
     * consulta
     *
     * @return
     */
    public ArrayList<Factura> buscarFacturas() {
        return (ArrayList<Factura>) facturaDao.recuperarLista();
    }

    /**
     * Actualiza los datos de una factura, y su proveedor
     *
     * @param factura
     * @return
     */
    public boolean actualizarFacturaYSuProveedor(Factura factura) {
        return facturaDao.actualizarFacturaYSuProveedor(factura);
    }

    /**
     * Actualiza los datos de una factura, elimina el proveedor
     *
     * @param factura
     * @return
     */
    public boolean actualizarFacturaEliminandoProveedor(Factura factura) {
        return facturaDao.actualizarFacturaQuitandoProveedor(factura);
    }

    /**
     * Devuelve las facturas del proveedor indicado, null si hubieran errores de
     * consulta
     *
     * @param nombreProveedor
     * @return
     */
    public ArrayList<Factura> buscarFacturas(String nombreProveedor) {
        return (ArrayList<Factura>) facturaDao.buscarFacturaPorProveedor(nombreProveedor);

    }

    /**
     * Devuelve las facturas que esten en el rango de fechas especificado, null
     * si existio algun error
     *
     * @param fechaInicial
     * @param fechaFinal
     * @return
     */
    public ArrayList<Factura> buscarFacturas(Timestamp fechaInicial, Timestamp fechaFinal) {
        return (ArrayList<Factura>) facturaDao.buscarFacturaPorFecha(fechaInicial, fechaFinal);
    }

    public Factura buscarFactura(int idFactura){
        return facturaDao.buscarFacturaPorId(idFactura);
    }
    
    /**
     * Se validadan los campos de ingreso de facturas
     *
     * @param numeroDeFactura
     * @param fecha
     * @param descripcion
     * @param valor
     * @param idProveedor
     * @return
     */
    public Factura validarDatosDeIngreso(String numeroDeFactura, Date fecha, String descripcion, String valor, Proveedor proveedor) {
        if (numeroDeFactura.isEmpty() || fecha == null || descripcion.isEmpty() || valor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Faltan datos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (descripcion.length() > 45) {
            JOptionPane.showMessageDialog(null, "Descripcion debe tener 45 caracteres como maximo", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {
            Integer.valueOf(numeroDeFactura);
            Double.valueOf(valor);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor debe ser un decimal Ej: 25.32", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (proveedor != null) {
            return new Factura(proveedor.getIdProveedor(), Integer.valueOf(numeroDeFactura), new Timestamp(fecha.getTime()), descripcion, Double.parseDouble(valor));
        } else {
            return new Factura(-1, Integer.valueOf(numeroDeFactura), new Timestamp(fecha.getTime()), descripcion, Double.parseDouble(valor));
        }
    }
}
