/*
 * Controlador de Bienes
 */
package pss1inventarioscunoc.backend.controladores;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionBien;
import pss1inventarioscunoc.backend.dao.interfaces.BienDAO;
import pss1inventarioscunoc.backend.pojos.Bien;

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
        return bienDao.registrar(bien);
    }

    /**
     * Regresa todos los bienes del sistema
     *
     * @return
     */
    public ArrayList<Bien> consultarBienes() {
        return (ArrayList<Bien>) bienDao.recuperarLista();
    }

    /**
     * Regresa todos los bienes por DONACION del sistema, null si existiera un
     * error
     *
     * @return
     */
    public ArrayList<Bien> consultarBienDonacion() {
        return (ArrayList<Bien>) bienDao.consultarBienDonacion();
    }

    /**
     * Regresa todos los bienes por TRASLADO del sistema, null si existiera un
     * error
     *
     * @return
     */
    public ArrayList<Bien> consultarBienTraslado() {
        return (ArrayList<Bien>) bienDao.consultarBienTraslado();
    }

    /**
     * Regresa todos los bienes por COMPRA del sistema, null si existiera un
     * error
     *
     * @return
     */
    public ArrayList<Bien> consultarBienCompra() {
        return (ArrayList<Bien>) bienDao.consultarBienCompra();
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
     * @param datosBien
     * @return
     */
    public boolean verificarDatosGeneralesBien(ArrayList<String> datosBien, String valor) {
        for (String dato : datosBien) {
            if (dato.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Faltan campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
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
        try {
            Integer.valueOf(correlativo);
            Integer.valueOf(numeroDeActa);
            if (punto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Faltan campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
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
     * @param receptor
     * @param personaQueRecibio
     * @return
     */
    public boolean verificarDatosTraslado(Date fecha, String receptor, String personaQueRecibio) {
        if (fecha == null || receptor.isEmpty() || personaQueRecibio.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Faltan datos obligatorios en el apartado TRASLADO", "Error", JOptionPane.ERROR_MESSAGE);
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
