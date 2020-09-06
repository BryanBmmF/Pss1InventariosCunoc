/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.controladores;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    /*valores predeterminados de un bien sin se especifica una factura,
        esto con el fin de que si despues se le quiera asociar una factura 
        no tenga que borrar el bien y crearlo de nuevo*/
    public static Factura facturaPredeterminda;

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
        return (ArrayList<Factura>) facturaDao.recuperarLista('e');
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
    
    /**
     * Verifica que que la factura predeterminada no haya sido creada
     *
     * @return factura predetrminada
     */
    public Factura consultarFacturaPred() {
        //verificando que la factura no este seteada ya
        if (facturaPredeterminda!=null) {
            return facturaPredeterminda;
        } else {
            /*sino esta ya en la BD hay que crearlo por defecto*/
            facturaPredeterminda= facturaDao.buscarFacturaPorDescripcion("FACTURA_UNICA_PREDETERMINADA");
            if (facturaPredeterminda==null) {
                    String pattern = "yyyy-MM-dd HH:mm:ss";
                    String timestampAsString = "2018-01-01 00:00:00";
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                    LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(timestampAsString));
                    Timestamp timestamp = Timestamp.valueOf(localDateTime);
                    
                    System.out.println("proveedor: "+ControladorProveedor.getProveedorPredetermindo().getIdProveedor());
                    facturaPredeterminda = new Factura(ControladorProveedor.getProveedorPredetermindo().getIdProveedor(), 0, timestamp, "FACTURA_UNICA_PREDETERMINADA", 0);
                    registrarFacturaConProveedor(facturaPredeterminda);
                    facturaPredeterminda= facturaDao.buscarFacturaPorDescripcion("FACTURA_UNICA_PREDETERMINADA");
            } 
            return facturaPredeterminda;
        }
    }

    public static Factura getFacturaPredeterminda() {
        return facturaPredeterminda;
    }

    public static void setFacturaPredeterminda(Factura facturaPredeterminda) {
        ControladorFactura.facturaPredeterminda = facturaPredeterminda;
    }
    
    
}
