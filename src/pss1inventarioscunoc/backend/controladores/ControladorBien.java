/*
 * Controlador de Bienes
 */
package pss1inventarioscunoc.backend.controladores;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionBien;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionInventario;
import pss1inventarioscunoc.backend.dao.interfaces.BienDAO;
import pss1inventarioscunoc.backend.dao.interfaces.InventarioDAO;
import pss1inventarioscunoc.backend.pojos.Bien;
import pss1inventarioscunoc.backend.pojos.Factura;
import pss1inventarioscunoc.backend.pojos.Proveedor;

/**
 *
 * @author bryan
 */
public class ControladorBien {

    private BienDAO bienDao;
    public static final int ID_FACTURA_INEXISTENTE = -1;//Valor que servira para saber que a un bien no se le ha asignado factura

    public ControladorBien() {
        bienDao = new ImplementacionBien();
    }

    /**
     * Registra un bien, ya se de compra,de traslado o de donacion devuelve
     * false si no lo ha insertado
     *
     * @param bien
     * @return
     */
    public boolean registrarBien(Bien bien) {
        bienDao.registrar(bien);
        InventarioDAO inv = new ImplementacionInventario();
        return inv.insertarRegistroBienInventario(bien);
    }
    /**
     * Actualizar un bien, ya se de compra,de traslado o de donacion devuelve
     * false si no lo ha insertado
     *
     * @param bien
     * @param tempCur
     * @return
     */
    public boolean actualizarBien(Bien bien, String tempCur) {
        return bienDao.actualizar(bien, tempCur);
    }

    /**
     * Regresa todos los bienes del sistema
     *
     * @param estado
     * @return
     */
    public ArrayList<Bien> consultarBienes(char estado) {
        return (ArrayList<Bien>) bienDao.recuperarLista(estado);
    }
    
    /**
     * Regresa todos los bienes del sistema
     *
     * @param estado
     * @return
     */
    public ArrayList<Bien> consultarBienesNoAsignados(char estado) {
        return (ArrayList<Bien>) bienDao.recuperarListaNoAsignados(estado);
    }

    /**
     * Regresa todos los bienes por DONACION del sistema, null si existiera un
     * error
     *
     * @param estado
     * @return
     */
    public ArrayList<Bien> consultarBienDonacion(char estado) {
        return (ArrayList<Bien>) bienDao.consultarBienDonacion(estado);
    }
    

    /**
     * Regresa todos los bienes por TRASLADO del sistema, null si existiera un
     * error
     *
     * @param estado
     * @return
     */
    public ArrayList<Bien> consultarBienTraslado(char estado) {
        return (ArrayList<Bien>) bienDao.consultarBienTraslado(estado);
    }
    

    /**
     * Regresa todos los bienes por COMPRA del sistema, null si existiera un
     * error
     *
     * @param estado
     * @return
     */
    public ArrayList<Bien> consultarBienCompra(char estado) {
        return (ArrayList<Bien>) bienDao.consultarBienCompra(estado);
    }
    

    /**
     * Se traslada un bien ya existente
     *
     * @param cur
     * @param fecha
     * @param autorizacion
     * @param seccion
     * @param persona_que_recibio
     * @return
     */
    public boolean trasladarBien(String cur, Timestamp fecha, String autorizacion, String seccion, String persona_que_recibio) {
        return bienDao.trasladarBien(cur, fecha, autorizacion, seccion, persona_que_recibio);
    }

    /**
     * Se verifican si los datos(generales) tipo cadena de bien se han ingresado
     *
     * @param inventario
     * @param factura
     * @param cur
     * @param procedencia
     * @param descripcion
     * @param division
     * @param valor
     * @return
     */
    public boolean verificarValoresGenerales(String inventario,String factura,String cur, String procedencia, String descripcion, String division, String valor) {
        if (cur.isEmpty() || procedencia.isEmpty() || descripcion.isEmpty() || division.isEmpty() || valor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Faltan datos obligatorios", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (cur.length() > 45) {
            JOptionPane.showMessageDialog(null, "Cur solo debe tener como maximo 45 caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (procedencia.length() > 45) {
            JOptionPane.showMessageDialog(null, "Procedencia solo debe tener como maximo 45 caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (descripcion.length() > 70) {
            JOptionPane.showMessageDialog(null, "Descripcion solo debe tener como maximo 70 caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (division.length() > 70) {
            JOptionPane.showMessageDialog(null, "Division solo debe tener como 70 maximo  caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un Inventario para registrar el Bien", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (factura.isEmpty()) {
            int input = JOptionPane.showConfirmDialog(null, "¿Esta seguro de guardar este bien sin antes asociarle una factura?");
            // 0=yes, 1=no, 2=cancel
            if (input!=0) {
                return false;
            }
            
        }
        
        return verificarDatoNumerico(valor);
    }

    /**
     * Se verifican que los datos de bienes por donacion sean correctos
     *
     * @param correlativo
     * @param punto
     * @param numeroDeActa
     * @return
     */
    public boolean verificarDatosDonacion(String correlativo, String punto, String numeroDeActa) {
        if (correlativo.isEmpty() || punto.isEmpty() || numeroDeActa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Faltan campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
            Integer.valueOf(correlativo);
            Integer.valueOf(numeroDeActa);
            if (punto.length() > 45) {
                JOptionPane.showMessageDialog(null, "Putno solo puede tener como maximo 45 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El correlativo y numero de acta deben ser enteros", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Verifica que los datos del bien traslado sean correctos
     *
     * @param fecha
     * @param seccion
     * @param receptor
     * @return
     */
    public boolean verificarDatosTraslado(Date fecha, String seccion, String receptor) {
        if (fecha == null || seccion.isEmpty() || receptor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Faltan datos obligatorios en el apartado TRASLADO", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (seccion.length() > 45) {
            JOptionPane.showMessageDialog(null, "Seccion solo puede tener como maximo 45 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (receptor.length() > 45) {
            JOptionPane.showMessageDialog(null, "Receptor solo puede tener como maximo 45 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Verifica que un datos ingresado concuerde con un double
     *
     * @param dato
     * @return
     */
    public boolean verificarDatoNumerico(String dato) {
        try {
            Double.parseDouble(dato);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "En el campo valor debe ingresar un decimal Ej:25.32", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    
}
